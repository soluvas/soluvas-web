package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
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
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.PatternValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.Translation;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.Value;
import org.soluvas.data.event.AddedTermEvent;
import org.soluvas.data.event.ModifiedTermEvent;
import org.soluvas.data.event.RemovedTermEvent;
import org.soluvas.data.impl.TermImpl;
import org.soluvas.web.bootstrap.widget.ColorPickerTextField;
import org.soluvas.web.site.EmfModel;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.SeoBookmarkableMapper;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeIconType;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton;

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
public class TermDetailPanel extends GenericPanel<Term> {
	
	private static final Logger log = LoggerFactory
			.getLogger(TermDetailPanel.class);
	
	private static final String IMAGE_ID_PATTERN = "[^\\s]{1,7}";
	
	private enum EditMode {
		ADD,
		MODIFY
	}
	private final String kindDisplayName;
	private final Class<? extends Page> backPage;
	@SpringBean
	private TenantRef tenant;
	@SpringBean
	private EventBus ev;
	@SpringBean
	private AppManifest appManifest;
	
	private final TermRepository termRepo;
	private final EditMode editMode;
	private final String originalUName;
	
	private final IModel<List<Locale>> localesModel = new ListModel<>(new ArrayList<Locale>());
	private final IModel<Locale> termLocaleModel = new Model<>();
	private final IModel<Locale> selectedLocaleModel = new Model<>(appManifest.getDefaultLocale());
	
	private final IModel<Map<Locale, String>> transDisplayNameMapModel = new MapModel<>(new HashMap<Locale, String>());

	/**
	 * For creating a new {@link Term}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param termRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public TermDetailPanel(String id, TermRepository termRepo, final String kindNsPrefix, final String kindName, String kindDisplayName,
			final Class<? extends Page> backPage) {
		super(id);
		this.editMode = EditMode.ADD;
		this.originalUName = null;
		this.termRepo = termRepo;
		this.kindDisplayName = kindDisplayName;
		this.backPage = backPage;
		final TermImpl term = new TermImpl();
		term.setKindNsPrefix(kindNsPrefix);
		term.setKindName(kindName);
		term.setNsPrefix(tenant.getTenantId());
		term.setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		setModel(new EmfModel<Term>(term));
	}

	/**
	 * For viewing or editing an existing {@link Term}.
	 * @param id
	 * @param termRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public TermDetailPanel(String id, TermRepository termRepo, String uName, final String kindNsPrefix, final String kindName, String kindDisplayName,
			final Class<? extends Page> backPage) {
		super(id, new EmfModel<>(
				Preconditions.checkNotNull(termRepo.findOne(uName),
						"Cannot find term %s using %s", uName, termRepo)
			));
		this.editMode = EditMode.MODIFY;
		this.termRepo = termRepo;
		this.originalUName = uName;
		this.kindDisplayName = kindDisplayName;
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
		
		final Form<Void> form = new Form<>("form");
		add(form);
		
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		add(new Label("kind", kindDisplayName));
		form.add(new BookmarkablePageLink<>("backLink", backPage));
		
		final Label uNameLabel = new Label("termUName", new PropertyModel<>(getModel(), "qName"));
		uNameLabel.setOutputMarkupId(true);
		add(uNameLabel);
		
		
		form.add(new Label("nsPrefix", new PropertyModel<>(getModel(), "nsPrefix")));
		final TextField<String> nameFld = new TextField<>("name", new PropertyModel<String>(getModel(), "name"));
		nameFld.setEnabled(false);
		nameFld.setOutputMarkupId(true);
		form.add(nameFld);
		final IModel<String> displayNameModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = termLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					return getModel().getObject().getDisplayName();
				} else {
					final String translation = transDisplayNameMapModel.getObject().get(selectedLocale);
					log.debug("loading display name for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextField displayNameFld = new TextField<String>("displayName", displayNameModel){
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
		displayNameFld.setEnabled(editable);
		displayNameFld.add(new OnChangeThrottledBehavior("change") {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = termLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					getModelObject().setDisplayName(displayNameModel.getObject());
					
					if (editMode == EditMode.ADD) {
						final String id = SlugUtils.generateValidId(getModelObject().getDisplayName(),
								new Predicate<String>() {
							@Override
							public boolean apply(@Nullable String input) {
								return !termRepo.exists(getModelObject().getNsPrefix() + "_" + input);
							}
						});
						getModelObject().setName(id);
						target.add(nameFld, uNameLabel);
					}
				} else {
					updateAttributeTranslations(selectedLocale, Value.DISPLAY_NAME_ATTR, displayNameModel.getObject());
					transDisplayNameMapModel.getObject().put(selectedLocale, displayNameModel.getObject());
				}
			}
		});
		form.add(displayNameFld);
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
		
		final BootstrapAjaxButton saveBtn = new LaddaAjaxButton("saveBtn", new Model<>("Save"), Buttons.Type.Primary) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
				if (Strings.isNullOrEmpty(term.getDisplayName())) {
					error("Display Name must not be null or empty");
					return;
				}
				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
				}
				switch (editMode) {
				case ADD:
					final String id = SlugUtils.generateValidId(term.getDisplayName(),
							new Predicate<String>() {
								@Override
								public boolean apply(@Nullable String input) {
									return !termRepo.exists(term.getNsPrefix() + "_" + input);
								}
							});
					term.setName(id);
					termRepo.add(term);
					ev.post(new AddedTermEvent(EcoreUtil.copy(term), tenant.getTenantId(), UUID.randomUUID().toString()));
					info("Added term " + term.getQName());
					break;
				case MODIFY:
					termRepo.modify(originalUName, term);
					ev.post(new ModifiedTermEvent(originalUName, EcoreUtil.copy(term), tenant.getTenantId(), UUID.randomUUID().toString()));
					info("Modified term " + term.getQName());
					break;
				}
				setResponsePage(backPage);
			}
		}.setIconType(FontAwesomeIconType.check);
		saveBtn.setEnabled(editable);
		form.add(saveBtn);
		
		final BootstrapAjaxButton deleteBtn = new LaddaAjaxButton("deleteBtn", new Model<>("Delete"), Buttons.Type.Danger) {

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				super.updateAjaxAttributes(attributes);
				attributes.getAjaxCallListeners().add(new AjaxCallListener() {
					@Override
					public CharSequence getPrecondition(Component component) {
						return "return confirm('Do you want to delete term ' + " + JSONObject.quote(originalUName) + " + '?')";
					}
				});
			}
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
//				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
//				}
				termRepo.delete(originalUName);
				ev.post(new RemovedTermEvent(EcoreUtil.copy(term), tenant.getTenantId(), UUID.randomUUID().toString()));
				warn("Deleted term " + originalUName);
				setResponsePage(backPage);
			}
		}.setIconType(FontAwesomeIconType.trash_o);
		deleteBtn.setEnabled(editable);
//		deleteBtn.setVisible(editMode == EditMode.MODIFY);
		deleteBtn.setVisible(false);
		form.add(deleteBtn);
		
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
						log.debug("Selected locale '{}', displayName '{}'", selectedLocaleModel.getObject().toLanguageTag(), displayNameModel.getObject());
						target.add(displayNameFld, wmcLocales);
					}
					
					@Override
					protected void onConfigure() {
						super.onConfigure();
						setOutputMarkupId(true);
						if (Objects.equal(selectedLocaleModel.getObject(), item.getModelObject())) {
							add(new AttributeAppender("class", "btn btn-default active"));
						} else {
							add(new AttributeAppender("class", "btn btn-default"));
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
		}
		
		if (getModelObject().getTranslations() != null && !getModelObject().getTranslations().isEmpty()) {
			for (final Entry<String, Translation> entry : getModelObject().getTranslations().entrySet()) {
				final Locale locale = Locale.forLanguageTag(entry.getKey());
				if (!locales.contains(locale)) {
					locales.add(locale);
				}
				
				final Translation translation = entry.getValue();
				for (final Entry<String, String> messageEntry : translation.getMessages()) {
					//display name
					if (messageEntry.getKey().equals(Value.DISPLAY_NAME_ATTR)) {
						transDisplayNameMapModel.getObject().put(locale, messageEntry.getValue());
					}
				}
			}
		}
		
		localesModel.getObject().addAll(locales);
	}
	
	private void updateAttributeTranslations(final Locale selectedLocale, final String attribute,
			@Nonnull final String upValue) {
		if (getModelObject().getTranslations().containsKey(selectedLocale.toLanguageTag())) {
			final Translation translation = getModelObject().getTranslations().get(selectedLocale.toLanguageTag());
			if (!Strings.isNullOrEmpty(upValue)) {
				log.debug("Putting translation {} - {} for {}", attribute, upValue, selectedLocale.toLanguageTag());
				translation.getMessages().put(attribute, upValue);
			} else {
				log.debug("Removing translation {} for {}", attribute, selectedLocale.toLanguageTag());
				translation.getMessages().remove(attribute);
			}
		} else {
			log.debug("Putting new translation {} - {} for {}", attribute, upValue, selectedLocale.toLanguageTag());
			final Translation newTranslation = CommonsFactory.eINSTANCE.createTranslation();
			newTranslation.setLanguage(selectedLocale.toLanguageTag());
			newTranslation.getMessages().put(attribute, upValue);
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
			updateAttributeTranslations(oldLocale, Value.DISPLAY_NAME_ATTR, getModelObject().getDisplayName());
		}
		
		if (getModelObject().getTranslations().containsKey(defaultLanguageTag)) {
			//update attribute from translation if exists
			final Translation translation = getModelObject().getTranslations().get(defaultLanguageTag);
			if (translation.getMessages().containsKey(Value.DISPLAY_NAME_ATTR)) {
				getModelObject().setDisplayName(translation.getMessages().get(Value.DISPLAY_NAME_ATTR));
			}
			
			//remove translation as default language product
			getModelObject().getTranslations().remove(defaultLanguageTag);
		}
	}
	
}
