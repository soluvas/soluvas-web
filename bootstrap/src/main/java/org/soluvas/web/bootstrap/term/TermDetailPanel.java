package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

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
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
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
import org.soluvas.web.site.widget.AutoDisableAjaxButton;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.eventbus.EventBus;

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
	private final IModel<Locale> productReleaseLocaleModel = new Model<>();
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
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		add(new Label("kind", kindDisplayName));
		add(new BookmarkablePageLink<>("backLink", backPage));
		
		final Label uNameLabel = new Label("termUName", new PropertyModel<>(getModel(), "qName"));
		uNameLabel.setOutputMarkupId(true);
		add(uNameLabel);
		
		final Form<Void> form = new Form<>("form");
		add(form);
		
		form.add(new Label("nsPrefix", new PropertyModel<>(getModel(), "nsPrefix")));
		final TextField<String> nameFld = new TextField<>("name", new PropertyModel<String>(getModel(), "name"));
		nameFld.setEnabled(false);
		nameFld.setOutputMarkupId(true);
		form.add(nameFld);
		new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		final Component displayNameFld = new TextField<>("displayName", new PropertyModel<>(getModel(), "displayName")).setRequired(true).setEnabled(editable);
		if (editMode == EditMode.ADD) {
			displayNameFld.add(new OnChangeThrottledBehavior("onchange") {
				
				@Override
				protected void onUpdate(AjaxRequestTarget target) {
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
			});
		}
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
		
		final IndicatingAjaxButton saveBtn = new AutoDisableAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
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
					ev.post(new AddedTermEvent(EcoreUtil.copy(term), UUID.randomUUID().toString()));
					info("Added term " + term.getQName());
					break;
				case MODIFY:
					termRepo.modify(originalUName, term);
					ev.post(new ModifiedTermEvent(originalUName, EcoreUtil.copy(term), UUID.randomUUID().toString()));
					info("Modified term " + term.getQName());
					break;
				}
				setResponsePage(backPage);
			}
		};
		saveBtn.setEnabled(editable);
		add(saveBtn);
		
		final IndicatingAjaxButton deleteBtn = new AutoDisableAjaxButton("deleteBtn", form) {
			private static final long serialVersionUID = 1L;

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
				ev.post(new RemovedTermEvent(EcoreUtil.copy(term), UUID.randomUUID().toString()));
				warn("Deleted term " + originalUName);
				setResponsePage(backPage);
			}
		};
		deleteBtn.setEnabled(editable);
//		deleteBtn.setVisible(editMode == EditMode.MODIFY);
		deleteBtn.setVisible(false);
		add(deleteBtn);
		
	}
	
	private void updateAttributeTranslations(final Locale selectedLocale, final String attribute,
			final String upValue) {
		if (getModelObject().getTranslations().containsKey(selectedLocale.toLanguageTag())) {
			log.debug("Putting translation {} - {} for {}", attribute, upValue, selectedLocale.toLanguageTag());
			final Translation translation = getModelObject().getTranslations().get(selectedLocale.toLanguageTag());
			translation.getMessages().put(attribute, upValue);
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
