package org.soluvas.web.bootstrap.category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
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
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.impl.CategoryImpl;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.Translation;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinManager;
import org.soluvas.web.site.CategoryModel;
import org.soluvas.web.site.EmfModel;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.widget.AutoDisableAjaxButton;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;
import com.vaynberg.wicket.select2.TextChoiceProvider;

/**
 * View/edit a {@link Category}, only editable if nsPrefix != base.
 * <p>Use e.g. @ManageMountPath("category/base/Color/${uName}")
 * <pre>{@literal
 * @ManageMountPath("category/base/Color/${uName}/")
 * public class ColorDetailPage extends AuthorizedMallPage {
 * 	
 * 	@SpringBean(name="colorCategoryRepo")
 * 	private CategoryRepository colorCategoryRepo;
 * 	
 * 	public ColorDetailPage(final PageParameters params) {
 * 		super(params);
 * 		final String uName = params.get("uName").toString();
 * 		add(new CategoryDetailPanel("detail", colorCategoryRepo, uName, "base", "Color", "Colors", ColorListPage.class));
 * 	}
 * 	
 * }
 * }</pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CategoryDetailPanel extends GenericPanel<Category> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CategoryDetailPanel.class);
	private enum EditMode {
		ADD,
		MODIFY
	}
	private static final String kindDisplayName = "Categories";
	private final Class<? extends Page> backPage;
	@SpringBean
	private TenantRef tenant;
	@SpringBean
	private MixinManager mixinMgr;
	@SpringBean
	private AppManifest appManifest;
	
	private final CategoryRepository categoryRepo;
	private final EditMode editMode;
	private final String originalUName;
	
	private final IModel<Locale> categoryLocaleModel = new Model<>();
	private final IModel<Locale> selectedLocaleModel = new Model<>(appManifest.getDefaultLocale());
	private final IModel<List<Locale>> localesModel = new ListModel<>(new ArrayList<Locale>());
	
	private final IModel<Map<Locale, String>> transNameMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transDescriptionMapModel = new MapModel<>(new HashMap<Locale, String>());

	/**
	 * For creating a new {@link Category}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param categoryRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param backPage
	 * @param parentUName Parent {@link Category#getUName()} (non-editable).
	 * @param defaultMixinUName Default {@link Category#setDefaultMixin(String)}, this is app specific e.g. {@code base_Apparel}.
	 * 		The {@link Mixin} must exist in the {@link MixinManager}. Only used if {@code parentUName} is specified,
	 * 		otherwise it will use the parent's {@code defaultMixin}.
	 */
	public CategoryDetailPanel(String id, CategoryRepository categoryRepo,
			final Class<? extends Page> backPage, @Nullable String parentUName, String defaultMixinUName) {
		super(id);
		this.editMode = EditMode.ADD;
		this.originalUName = null;
		this.categoryRepo = categoryRepo;
		this.backPage = backPage;
		
		final CategoryImpl category = new CategoryImpl();
		category.setNsPrefix(tenant.getTenantId());
		category.setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		if (parentUName != null) {
			category.setParentUName(parentUName);
			final Category parent = Preconditions.checkNotNull(categoryRepo.findOne(parentUName),
					"Cannot find parent category '%s' using %s", parentUName, categoryRepo);
			category.setDefaultMixin(parent.getDefaultMixin());
		} else {
			category.setDefaultMixin(defaultMixinUName);
		}
		category.setStatus(CategoryStatus.ACTIVE);
		setModel(new CategoryModel<Category>(category));
	}

	/**
	 * For viewing or editing an existing {@link Category}.
	 * @param id
	 * @param categoryRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public CategoryDetailPanel(String id, CategoryRepository categoryRepo, String uName,
			final Class<? extends Page> backPage) {
		// FIXME: reference to parent is gone
		super(id, new CategoryModel<>(
				Preconditions.checkNotNull(categoryRepo.findOne(uName),
						"Cannot find category %s using %s", uName, categoryRepo)
			));
		this.editMode = EditMode.MODIFY;
		this.categoryRepo = categoryRepo;
		this.originalUName = uName;
		this.backPage = backPage;
		if (getModelObject().getLanguage() == null) {
			getModelObject().setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		}
		changeTranslationsByDefault();
	}
	
	@SuppressWarnings("null")
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		categoryLocaleModel.setObject(Locale.forLanguageTag(getModelObject().getLanguage()));
		initLocalesAndTranslationMapModel();
		
		if (editMode == EditMode.ADD) {
			final String mixinUName = getModelObject().getDefaultMixin();
			Preconditions.checkNotNull(mixinMgr.findMixin(mixinUName),
					"Mixin '%s' referred by new category must exist.", mixinUName);
		}
		
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		add(new Label("kind", kindDisplayName));
		add(new BookmarkablePageLink<>("backLink", backPage));
		
		final Label headerUNameLabel = new Label("headerUName", new PropertyModel<>(getModel(), "uName"));
		headerUNameLabel.setOutputMarkupId(true);
		add(headerUNameLabel);
		
		final Form<Void> form = new Form<>("form");
		add(form);
		
		form.add(new Label("parentUName", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				if (getModelObject().getParentUName() != null) {
					return getModelObject().getParentUName();
				} else {
					return "(root)";
				}
			}
		}));
		
		final WebMarkupContainer uNameDiv = new WebMarkupContainer("uNameDiv");
		uNameDiv.setOutputMarkupId(true);
		uNameDiv.add(new Label("nsPrefix", new PropertyModel<>(getModel(), "nsPrefix")));
		final TextField<String> nameFld = new TextField<>("name", new PropertyModel<String>(getModel(), "id"));
		nameFld.setEnabled(false); // don't allow changes to ID attribute, users will mess it up!
//		nameFld.add(new OnChangeThrottledBehavior() {
//			@Override
//			protected void onUpdate(AjaxRequestTarget target) {
//				target.add(headerUNameLabel);
//			}
//		});
		uNameDiv.add(nameFld);
		form.add(uNameDiv);
		
		final WebMarkupContainer slugPathDiv = new WebMarkupContainer("slugPathDiv");
		slugPathDiv.setOutputMarkupId(true);
		final TextField<String> slugPathFld = new TextField<>("slugPath", new PropertyModel<String>(getModel(), "slugPath"));
		slugPathFld.setEnabled(false);
		slugPathDiv.add(slugPathFld);
		form.add(slugPathDiv);
		
		final IModel<String> nameModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					return getModel().getObject().getName();
				} else {
					final String translation = transNameMapModel.getObject().get(selectedLocale);
					log.debug("loading name for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextField<String> displayNameFld = new TextField<String>("displayName", nameModel){
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
		displayNameFld.setOutputMarkupId(true);
		displayNameFld.setRequired(true);
		displayNameFld.setEnabled(editable);
		displayNameFld.add(new OnChangeThrottledBehavior("onchange") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category category = CategoryDetailPanel.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (editMode == EditMode.ADD) {
					if (Objects.equal(selectedLocale, categoryLocale)) {
						category.setName(nameModel.getObject());
						
						final String id = SlugUtils.generateValidId(category.getName(), new Predicate<String>() {
							@Override
							public boolean apply(@Nullable String input) {
								return !categoryRepo.exists(tenant.getTenantId() + "_" + input);
							}
						});
						category.setId(id);
						category.setSlug(null);
						category.resolve(categoryRepo);
					} else {
						updateAttributeTranslations(selectedLocale, Category.NAME_ATTR, nameModel.getObject());
						transNameMapModel.getObject().put(selectedLocale, nameModel.getObject());
					}
				} else {
					if (Objects.equal(selectedLocale, categoryLocale)) {
						category.setName(nameModel.getObject());
					} else {
						updateAttributeTranslations(selectedLocale, Category.NAME_ATTR, nameModel.getObject());
						transNameMapModel.getObject().put(selectedLocale, nameModel.getObject());
					}
				}
				target.add(headerUNameLabel, uNameDiv, slugPathDiv);
			}
		});
		form.add(displayNameFld);
		
		final IModel<String> descriptionModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale productReleaseLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, productReleaseLocale)) {
					return getModel().getObject().getDescription();
				} else {
					final String translation = transDescriptionMapModel.getObject().get(selectedLocale);
					log.debug("loading description for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextArea<String> descriptionFld = new TextArea<String>("description", descriptionModel){
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
		descriptionFld.add(new OnChangeThrottledBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category category = CategoryDetailPanel.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					category.setDescription(descriptionModel.getObject());
				} else {
					updateAttributeTranslations(selectedLocale, Category.DESCRIPTION_ATTR, descriptionModel.getObject());
					transDescriptionMapModel.getObject().put(selectedLocale, descriptionModel.getObject());
				}
			}
		});
		descriptionFld.setEnabled(editable);
		form.add(descriptionFld);
		
		final IModel<Boolean> statusModel = new Model<>( getModelObject().getStatus() == CategoryStatus.ACTIVE );
		form.add(new CheckBox("status", statusModel));
		
		form.add(new NumberTextField<>("positioner", new PropertyModel<Integer>(getModel(), "positioner"), Integer.class));
		
//		getModel().getObject().getd
		final IModel<List<Mixin>> sortedMixinsModel = new LoadableDetachableModel<List<Mixin>>() {
			@Override
			protected List<Mixin> load() {
				final Collection<Mixin> mixins = EcoreUtil.copyAll(mixinMgr.getMixins());
				final Ordering<Mixin> mixinOrderer = Ordering.from(new Comparator<Mixin>() {
					@Override
					public int compare(Mixin o1, Mixin o2) {
						return o1.getName().compareToIgnoreCase(o2.getName());
					}
				});
				final List<Mixin> sortedMixins = mixinOrderer.immutableSortedCopy(mixins);
				log.debug("Got {} mixins", sortedMixins.size());
				return sortedMixins;
			}
		};
		final String curDefaultMixin = getModelObject().getDefaultMixin();
		log.debug("Got curMixin from Category {} is {}", getModelObject().getUName(), curDefaultMixin);
		final Mixin curMixin = mixinMgr.findMixin(curDefaultMixin);
		final IModel<Mixin> curMixinModel = new EmfModel<>(curMixin);
		final Select2Choice<Mixin> mixinChoices = new Select2Choice<>("defaultMixin", curMixinModel, new TextChoiceProvider<Mixin>() {
			@Override
			protected String getDisplayText(Mixin choice) {
				return choice.getDisplayName();
			}
			
			@Override
			protected Object getId(Mixin choice) {
				return choice.getQName();
			}
			
			@Override
			public void query(final String term, int page, Response<Mixin> response) {
				Preconditions.checkNotNull(sortedMixinsModel, "Sorted Mixins Model must not be null");
				Preconditions.checkNotNull(sortedMixinsModel.getObject(), "Sorted Mixins must not be null");
				final Collection<Mixin> filteredMixins = Collections2.filter(sortedMixinsModel.getObject(), new Predicate<Mixin>() {
					@Override
					public boolean apply(@Nullable Mixin input) {
						return StringUtils.containsIgnoreCase(input.getDisplayName(), term);
					}
				});
				response.addAll(filteredMixins);
			}
			
			@Override
			public Collection<Mixin> toChoices(Collection<String> ids) {
				final Collection<Mixin> matchedChoices = Collections2.filter( Collections2.transform(ids, new Function<String, Mixin>() {
					@Override @Nullable
					public Mixin apply(@Nullable final String qName) {
						return Iterables.find(sortedMixinsModel.getObject(), new Predicate<Mixin>() {
							@Override
							public boolean apply(@Nullable Mixin input) {
								return input.getQName().equals(qName);
							}
						});
					}
				}), new NotNullPredicate<>());
				return matchedChoices;
			}
		});
		mixinChoices.setRequired(true);
		form.add(mixinChoices);
		
		final IndicatingAjaxButton saveBtn = new AutoDisableAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Category category = CategoryDetailPanel.this.getModelObject();
				if (editMode == EditMode.ADD) {
					final String id = SlugUtils.generateValidId(category.getName(), new Predicate<String>() {
						@Override
						public boolean apply(@Nullable String input) {
							return !categoryRepo.exists(tenant.getTenantId() + "_" + input);
						}
					});
					category.setId(id);
					category.setSlug(null);
					category.resolve(categoryRepo);
				}
				category.setStatus( statusModel.getObject() ? CategoryStatus.ACTIVE : CategoryStatus.VOID );
				category.setDefaultMixin(curMixinModel.getObject().getQName());
				switch (editMode) {
				case ADD:
					categoryRepo.add(category);
					info("Added category " + category.getNsPrefix() + "_" + category.getName());
					break;
				case MODIFY:
					categoryRepo.modify(originalUName, category);
					info("Modified category " + category.getNsPrefix() + "_" + category.getName());
					break;
				}
				setResponsePage(backPage);
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
						return "return confirm('Do you want to delete category ' + " + JSONObject.quote(originalUName) + " + '?')";
					}
				});
			}
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Category category = CategoryDetailPanel.this.getModelObject();
				categoryRepo.delete(originalUName);
				warn("Deleted category " + originalUName);
				setResponsePage(backPage);
			}
		};
		deleteBtn.setEnabled(editable);
		deleteBtn.setVisible(false); // don't allow them to delete because old products might have inconsistent data. if want to delete, ask developers :)
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
						nameModel.detach();
						descriptionModel.detach();
						target.add(displayNameFld, descriptionFld, wmcLocales);
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
		final Collection<Locale> locales = SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.values();
		for (final Locale locale : locales) {
			transNameMapModel.getObject().put(locale, null);
			transDescriptionMapModel.getObject().put(locale, null);
		}
		
		if (getModelObject().getTranslations() != null && !getModelObject().getTranslations().isEmpty()) {
			for (final Entry<String, Translation> entry : getModelObject().getTranslations().entrySet()) {
				final Locale locale = Locale.forLanguageTag(entry.getKey());
				if (!locales.contains(locale)) {
					locales.add(locale);
				}
				
				final Translation translation = entry.getValue();
				for (final Entry<String, String> messageEntry : translation.getMessages()) {
					//name
					if (messageEntry.getKey().equals(Category.NAME_ATTR)) {
						transNameMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//description
					if (messageEntry.getKey().equals(Category.DESCRIPTION_ATTR)) {
						transDescriptionMapModel.getObject().put(locale, messageEntry.getValue());
					}
				}
			}
		}
		
		localesModel.getObject().addAll(locales);
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
			updateAttributeTranslations(oldLocale, Category.NAME_ATTR, getModelObject().getName());
			if (getModelObject().getDescription() != null) {
				updateAttributeTranslations(oldLocale, Category.DESCRIPTION_ATTR, getModelObject().getDescription());
			}
		}
		
		if (getModelObject().getTranslations().containsKey(defaultLanguageTag)) {
			//update attribute from translation if exists
			final Translation translation = getModelObject().getTranslations().get(defaultLanguageTag);
			if (translation.getMessages().containsKey(Category.NAME_ATTR)) {
				getModelObject().setName(translation.getMessages().get(Category.NAME_ATTR));
			}
			if (translation.getMessages().containsKey(Category.DESCRIPTION_ATTR)) {
				getModelObject().setDescription(translation.getMessages().get(Category.DESCRIPTION_ATTR));
			}
			
			//remove translation as default language product
			getModelObject().getTranslations().remove(defaultLanguageTag);
		}
	}
	
}
