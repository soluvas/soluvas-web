package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.PatternValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Term;
import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.mongo.MongoTermRepository;
import org.soluvas.web.bootstrap.widget.ColorPickerTextField;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.widget.AutoDisableAjaxButton;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;
import com.mongodb.DuplicateKeyException;

/**
 * View/edit a {@link Term}, only editable if nsPrefix != base.
 * <p>Use e.g. @ManageMountPath("term/base/Color/${uName}")
 * <pre>{@literal
 * @ManageMountPath("term/base/Color/${uName}/")
 * public class ColorDetailPage extends AuthorizedMallPage {
 * 	
 * 	@SpringBean(name="colorTermRepo")
 * 	private TermRepository colorTermRepo;
 * 	
 * 	public ColorDetailPage(final PageParameters params) {
 * 		super(params);
 * 		final String uName = params.get("uName").toString();
 * 		add(new TermDetailPanel("detail", colorTermRepo, uName, "base", "Color", "Colors", ColorListPage.class));
 * 	}
 * 	
 * }
 * }</pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class Term2DetailPanel extends GenericPanel<Term2> {
	
	private static final Logger log = LoggerFactory
			.getLogger(Term2DetailPanel.class);
	
	private static final String IMAGE_ID_PATTERN = "[^\\s]{1,7}";
	
	private enum EditMode {
		ADD,
		MODIFY
	}
	private final String kindDisplayName;
	private final Class<? extends Page> backPage;
	
	@SpringBean
	private MongoTermRepository termCatalogRepo;
	@SpringBean
	private TenantRef tenant;
	@SpringBean
	private EventBus ev;
	@SpringBean
	private AppManifest appManifest;
	@Inject
	private CacheManager cacheMgr;
	
	private final EditMode editMode;
	private final String termId;
	
	private final IModel<List<Locale>> localesModel = new ListModel<>(new ArrayList<Locale>());
	private final IModel<Locale> termLocaleModel = new Model<>();
	private final IModel<Locale> selectedLocaleModel = new Model<>(appManifest.getDefaultLocale());
	
	private final IModel<Map<Locale, String>> transDisplayNameMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transDescMapModel = new MapModel<>(new HashMap<Locale, String>());

	private final IModel<TermKind> termKindModel;

	/**
	 * For creating a new {@link Term}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param termRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindName
	 * @param kindDisplayName
	 * @param shoeSize 
	 * @param string 
	 * @param backPage
	 */
	public Term2DetailPanel(String id, final Class<? extends Page> backPage, IModel<TermKind> termKindModel) {
		super(id);
		this.editMode = EditMode.ADD;
		this.termId = null;
		this.backPage = backPage;
		this.termKindModel= termKindModel;
		this.kindDisplayName = termKindModel.getObject().getName();
		
		final Term2 term = new Term2();
		term.setEnumerationId(termKindModel.getObject().getId());
		term.setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		setModel(new Model<Term2>(term));
	}

	/**
	 * For viewing or editing an existing {@link Term}.
	 * @param id
	 * @param termRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public Term2DetailPanel(final String id, final IModel<Term2> model, final Class<? extends Page> backPage,
			final IModel<TermKind> termKindModel) {
		super(id, model);
		
		
		this.editMode = EditMode.MODIFY;
		this.termId = model.getObject().getId();
		this.termKindModel = termKindModel;
		this.kindDisplayName = termKindModel.getObject().getName();
		this.backPage = backPage;
		
		if (getModel().getObject().getLanguage() == null) {
			getModel().getObject().setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		}
		
		changeTranslationsByDefault();
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		termLocaleModel.setObject(Locale.forLanguageTag(getModel().getObject().getLanguage()));
		initLocalesAndTranslationMapModel();
		
		final boolean editable = !Strings.isNullOrEmpty(getModelObject().getFormalId()) ? getModelObject().getFormalId().startsWith(tenant.getTenantId() + "_") : true;
		add(new Label("kind", kindDisplayName));
		 
		final PageParameters params = new PageParameters();
		params.set("termKindId", termKindModel.getObject().getId());
		add(new BookmarkablePageLink<>("backLink", backPage, params));
		 
		final Label uNameLabel = new Label("termUName", new PropertyModel<>(getModel(), "id"));
		uNameLabel.setOutputMarkupId(true);
		add(uNameLabel);
		
		final Form<Void> form = new Form<>("form");
		add(form);
		
		final TextField<String> idFld = new TextField<>("name", new PropertyModel<String>(getModel(), "id"));
		idFld.setEnabled(false);
		idFld.setOutputMarkupId(true);
		form.add(idFld);
		
		final IModel<String> displayNameModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = termLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					return getModel().getObject().getName();
				} else {
					final String translation = transDisplayNameMapModel.getObject().get(selectedLocale);
					log.debug("loading display name for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextField<String> nameFld = new TextField<String>("displayName", displayNameModel){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					add(new AttributeModifier("class", "form-control"));
				} else {
					add(new AttributeModifier("class", "form-control focus"));
				}
			}
		};
		nameFld.setEnabled(editable);
		nameFld.add(new OnChangeThrottledBehavior("onchange") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = termLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					getModelObject().setName(displayNameModel.getObject());
					if (editMode == EditMode.ADD) {
						if (displayNameModel.getObject() != null) {
							final String formalId = SlugUtils.generateValidId(tenant.getTenantId() + " " + getModelObject().getName(),
									new Predicate<String>() {
								@Override
								public boolean apply(@Nullable String input) {
									return !termCatalogRepo.existsByEnumerationId(getModelObject().getEnumerationId(), input).isPresent();
								}
							});
							getModelObject().setFormalId(formalId);
							getModelObject().setId(getModelObject().getEnumerationId() + "/" + formalId);
						} else {
							getModelObject().setFormalId(null);
							getModelObject().setId(null);
						}
						target.add(idFld, uNameLabel);
					}
				} else {
					updateAttributeTranslations(selectedLocale, Term2.NAME_ATTR, displayNameModel.getObject());
					transDisplayNameMapModel.getObject().put(selectedLocale, displayNameModel.getObject());
				}
			}
		});
		form.add(nameFld);
		
		final IModel<String> descModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = termLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					return getModel().getObject().getDescription();
				} else {
					final String translation = transDescMapModel.getObject().get(selectedLocale);
					log.debug("loading description for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextArea<String> descFld = new TextArea<String>("desc", descModel){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					add(new AttributeModifier("class", "form-control"));
				} else {
					add(new AttributeModifier("class", "form-control focus"));
				}
			}
		};
		descFld.setEnabled(editable);
		descFld.add(new OnChangeThrottledBehavior("onchange") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale termLocale = termLocaleModel.getObject();
				if (Objects.equal(selectedLocale, termLocale)) {
					getModelObject().setDescription(descModel.getObject());
//					log.debug("Updated desc for locale '{}': {}", selectedLocale.toLanguageTag(),
//							getModelObject().getDescription());
				} else {
					updateAttributeTranslations(selectedLocale, Term2.DESCRIPTION_ATTR, descModel.getObject());
					transDescMapModel.getObject().put(selectedLocale, descModel.getObject());
//					log.debug("Updated desc for locale '{}': {}", selectedLocale.toLanguageTag(),
//							getModelObject().getTranslations());
				}
			}
		});
		form.add(descFld);
		
		final TextField<String> imageId = new TextField<String>("imageId", new PropertyModel<String>(getModel(), "imageId")){

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setEnabled(editable);
				final Subject subject = SecurityUtils.getSubject();
				final boolean isSysadmin = subject.isPermitted("sysadmin");
				setVisible( isSysadmin );
			}
		};
		imageId.add(new PatternValidator(IMAGE_ID_PATTERN));
		form.add(imageId);
		final IModel<Boolean> colorUsed = new Model<>(getModelObject().getColor() != null);
		final PropertyModel<String> colorModel = new PropertyModel<>(getModel(), "color");
		final Label colorBox = new Label("colorBox");
		colorBox.setOutputMarkupId(true);
		colorBox.add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return "background-color: " + Optional.fromNullable(colorModel.getObject()).or("white") + ";";
			}
		}));
		form.add(colorBox);
		final ColorPickerTextField colorFld = new ColorPickerTextField("color", colorModel) {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setEnabled(editable && colorUsed.getObject());
			}
		};
		// 'change' event doesn't work, neither does OnChangeAjaxBehavior, dunno why
		colorFld.add(new AjaxFormComponentUpdatingBehavior("blur") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(colorBox);
			}
		});
		colorFld.setOutputMarkupId(true);
		colorFld.setEnabled(editable);
		form.add(colorFld);
		final CheckBox colorUsedFld = new CheckBox("colorUsed", colorUsed);
		colorUsedFld.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(colorFld);
			}
		});
		colorUsedFld.setEnabled(editable);
		form.add(colorUsedFld);
		
		final IndicatingAjaxButton saveBtn = new AutoDisableAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term2 term = Term2DetailPanel.this.getModelObject();
				if (Strings.isNullOrEmpty(term.getName())) {
					error("Display Name must not be null or empty");
					return;
				}
//				log.debug("Desc: {}", term.getDescription());
//				log.debug("Trans: {}", term.getTranslations());
				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
				}
				
				// delete cache
				final Cache term2EnumIdCache = cacheMgr.getCache("term2EnumId");
				final String term2EnumIdKey = String.format("term2:%s:%s", tenant.getTenantId(), term.getEnumerationId());
				term2EnumIdCache.evict(term2EnumIdKey);
				
				switch (editMode) {
				case ADD:
					final String formalId = SlugUtils.generateValidId(tenant.getTenantId() + " " + term.getName(),
							new Predicate<String>() {
						@Override
						public boolean apply(@Nullable String input) {
							return !termCatalogRepo.existsByEnumerationId(term.getEnumerationId(), input).isPresent();
						}
					});
					term.setFormalId(formalId);
					term.setId(term.getEnumerationId() + "/" + formalId);
					try {
						termCatalogRepo.add(term);
					} catch (DuplicateKeyException dke) {
						log.info("Term for '{}' - {} has already exists: {}", term.getId(), term.getName(), dke);
						info(String.format("Term '%s' sudah ada!!", term.getName()));
						return;
					}
					//FIXME: ga perlu cpp + update on memory
//					ev.post(new AddedTermEvent(EcoreUtil.copy(term), tenant.getTenantId(), UUID.randomUUID().toString()));
					info("Added term " + term.getId());
					break;
				case MODIFY:
					termCatalogRepo.modify(termId, term);
					
					// delete cache for this term
					final Cache slugsCache = cacheMgr.getCache("term2ids");
					final String key = String.format("term2:%s:%s", tenant.getTenantId(), term.getId());
					slugsCache.evict(key);
					
					//FIXME: ga perlu cpp + update on memory
//					ev.post(new ModifiedTermEvent(termId, EcoreUtil.copy(term), tenant.getTenantId(), UUID.randomUUID().toString()));
					info("Modified term " + term.getId());
					break;
				}
//				final PageParameters params = new PageParameters();
//				params.set("termKind", termKindModel.getObject().name());
				setResponsePage(backPage, params);
			}
		};
		saveBtn.setEnabled(editable);
		add(saveBtn);
		
		final IndicatingAjaxButton deleteBtn = new AutoDisableAjaxButton("deleteBtn", form) {

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				super.updateAjaxAttributes(attributes);
				attributes.getAjaxCallListeners().add(new AjaxCallListener() {
					@Override
					public CharSequence getPrecondition(Component component) {
						return "return confirm('Do you want to delete term ' + " + JSONObject.quote(termId) + " + '?')";
					}
				});
			}
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term2 term = Term2DetailPanel.this.getModelObject();
//				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
//				}
				termCatalogRepo.delete(termId);
				//FIXME: ga perlu cpp + update on memory
//				ev.post(new RemovedTermEvent(EcoreUtil.copy(term), tenant.getTenantId(), UUID.randomUUID().toString()));
				warn("Deleted term " + termId);
				setResponsePage(backPage);
			}
		};
		deleteBtn.setEnabled(editable);
//		deleteBtn.setVisible(editMode == EditMode.MODIFY);
		deleteBtn.setVisible(false);
		add(deleteBtn);
		
		/*LANGUAGE BUTTONS*/
		final WebMarkupContainer wmcLocales = new WebMarkupContainer("wmcLocales");
		wmcLocales.setOutputMarkupId(true);
		wmcLocales.add(new ListView<Locale>("locales", localesModel) {
			@Override
			protected void populateItem(final ListItem<Locale> item) {
				final AjaxLink<Void> btnLocale = new AjaxLink<Void>("btnLocale") {
					@Override
					public void onClick(AjaxRequestTarget target) {
						selectedLocaleModel.setObject(item.getModelObject());
						displayNameModel.detach();
						descModel.detach();
//						log.debug("Selected locale '{}', displayName '{}'", selectedLocaleModel.getObject().toLanguageTag(), displayNameModel.getObject());
						target.add(nameFld, descFld, wmcLocales);
					}
					
					@Override
					protected void onConfigure() {
						super.onConfigure();
						setOutputMarkupId(true);
						if (Objects.equal(selectedLocaleModel.getObject(), item.getModelObject())) {
							add(new AttributeModifier("class", "btn-sm btn-info active multilang pull-left"));
						} else {
							add(new AttributeModifier("class", "btn-sm btn-default multilang pull-left"));
						}
					}
				};
				
				final Label lblLocale = new Label("lblLocale", new Model<>(
							item.getModelObject().getDisplayLanguage() + 
							"-" + item.getModelObject().getDisplayCountry() +
							(Objects.equal(appManifest.getDefaultLocale(), item.getModelObject()) ? " AS DEFAULT" : "")
						));
				btnLocale.add(lblLocale);
				item.add(btnLocale);
			}
		});
		form.add(wmcLocales);
	}
	
	private void initLocalesAndTranslationMapModel() {
		//TODO: get languages from app manifest
		final Collection<Locale> locales = new ArrayList<>(SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.values());
		for (final Locale locale : locales) {
			transDisplayNameMapModel.getObject().put(locale, null);
			transDescMapModel.getObject().put(locale, null);
		}
		
		if (getModelObject().getTranslations() != null && !getModelObject().getTranslations().isEmpty()) {
			for (final Entry<String, Map<String, String>> entry : getModelObject().getTranslations().entrySet()) {
				final Locale locale = Locale.forLanguageTag(entry.getKey());
				if (!locales.contains(locale)) {
					locales.add(locale);
				}
				
				final Map<String, String> translation = entry.getValue();
				for (final Entry<String, String> messageEntry : translation.entrySet()) {
					//display name
					if (messageEntry.getKey().equals(Term2.NAME_ATTR)) {
						transDisplayNameMapModel.getObject().put(locale, messageEntry.getValue());
					}
					if (messageEntry.getKey().equals(Term2.DESCRIPTION_ATTR)) {
						transDescMapModel.getObject().put(locale, messageEntry.getValue());
					}
				}
			}
		}
		
		localesModel.getObject().addAll(locales);
	}
	
	private void updateAttributeTranslations(final Locale selectedLocale, final String attribute,
			@Nonnull final String upValue) {
		if (getModelObject().getTranslations().containsKey(selectedLocale.toLanguageTag())) {
			final Map<String, String> translation = getModelObject().getTranslations().get(selectedLocale.toLanguageTag());
			if (!Strings.isNullOrEmpty(upValue)) {
				log.debug("Putting translation {} - {} for {}", attribute, upValue, selectedLocale.toLanguageTag());
				translation.put(attribute, upValue);
			} else {
				log.debug("Removing translation {} for {}", attribute, selectedLocale.toLanguageTag());
				translation.remove(attribute);
			}
		} else {
			log.debug("Putting new translation {} - {} for {}", attribute, upValue, selectedLocale.toLanguageTag());
			final Map<String, String> newTranslation = new HashMap<>();
			newTranslation.put(attribute, upValue);
			getModelObject().getTranslations().put(selectedLocale.toLanguageTag(), newTranslation);
		}
	}
	
	private void changeTranslationsByDefault() {
		final String defaultLanguageTag = appManifest.getDefaultLocale().toLanguageTag();
		final String oldLanguageTag = getModelObject().getLanguage();
		final Locale oldLocale = Locale.forLanguageTag(oldLanguageTag);
		if (defaultLanguageTag.equals(oldLanguageTag)) {
			log.info("No need for translating different language with default (get from appManifest)");
			return;
		}
		//set the language as default of product
		getModelObject().setLanguage(defaultLanguageTag);
		if (!getModelObject().getTranslations().containsKey(oldLanguageTag)) {
			//create translation for old language
			updateAttributeTranslations(oldLocale, Term2.NAME_ATTR, getModelObject().getName());
		}
		
		if (getModelObject().getTranslations().containsKey(defaultLanguageTag)) {
			//update attribute from translation if exists
			final Map<String, String> translation = getModelObject().getTranslations().get(defaultLanguageTag);
			if (translation.containsKey(Term2.NAME_ATTR)) {
				getModelObject().setName(translation.get(Term2.NAME_ATTR));
			}
			
			//remove translation as default language product
			getModelObject().getTranslations().remove(defaultLanguageTag);
		}
	}
	
}
