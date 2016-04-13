package org.soluvas.web.bootstrap.category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.jena.ext.com.google.common.base.Optional;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.ajax.markup.html.AjaxLink;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.FormalCategory;
import org.soluvas.category.FormalCategoryRepository;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.category.MongoCategoryRepositoryImpl;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinManager;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.widget.AutoDisableAjaxButton;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.mongodb.DuplicateKeyException;

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
public class CategoryDetailPanel2 extends GenericPanel<Category2> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CategoryDetailPanel2.class);
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
	@Inject
	private FormalCategoryRepository formalCategoryRepo;
	@Inject
	private MongoCategoryRepository catRepo;
	@Inject
	private CacheManager cacheMgr;
	
	private final EditMode editMode;
	private final String originalId;
	
	private final IModel<Locale> categoryLocaleModel = new Model<>();
	private final IModel<Locale> selectedLocaleModel = new Model<>(appManifest.getDefaultLocale());
	private final IModel<List<Locale>> localesModel = new ListModel<>(new ArrayList<Locale>());
	private final IModel<FormalCategory> formalCategoryModel;
	
	private final IModel<Map<Locale, String>> transNameMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transDescriptionMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<List<PropertyDefinition>> curPropertyOverridesModel = new ListModel<>();
	private Form<Void> form;
	private final IModel<List<String>> defaultEnumsModel;

	/**
	 * For creating a new {@link Category}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param categoryRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param backPage
	 * @param parentModel Parent {@link Category#getUName()} (non-editable).
	 * @param defaultEnumsModel 
	 * @param defaultMixinUName Default {@link Category#setDefaultMixin(String)}, this is app specific e.g. {@code base_Apparel}.
	 * 		The {@link Mixin} must exist in the {@link MixinManager}. Only used if {@code parentUName} is specified,
	 * 		otherwise it will use the parent's {@code defaultMixin}.
	 */
	public CategoryDetailPanel2(final String id, final Class<? extends Page> backPage,
			@Nullable final IModel<Category2> parentModel, final IModel<FormalCategory> formalCategoryModel,
			final IModel<List<String>> defaultEnumsModel) {
		super(id);
		
		this.editMode = EditMode.ADD;
		this.originalId = null;
		this.backPage = backPage;
		this.formalCategoryModel = formalCategoryModel;
		this.defaultEnumsModel = defaultEnumsModel;
		
		final Category2 newCategory = new Category2();
		newCategory.setNsPrefix(tenant.getTenantId());
		newCategory.setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		if (parentModel.getObject() != null) {
			//Property Overrides di kasihkan dari parent-nya!
			newCategory.setParentId(parentModel.getObject().getId());
			if (parentModel.getObject().getPropertyOverrides() != null && !parentModel.getObject().getPropertyOverrides().isEmpty()) {
				newCategory.getPropertyOverrides().addAll(parentModel.getObject().getPropertyOverrides());
			}
		}
		if (parentModel.getObject() == null && formalCategoryModel.getObject() != null) {
			newCategory.setGoogleFormalId(formalCategoryModel.getObject().getGoogleId());
			if (formalCategoryModel.getObject().getPropertyOverrides() != null && !formalCategoryModel.getObject().getPropertyOverrides().isEmpty()) {
				newCategory.getPropertyOverrides().addAll(formalCategoryModel.getObject().getPropertyOverrides());
			}
		}
		newCategory.setStatus(CategoryStatus.ACTIVE);
		newCategory.setPositioner(0);
		setModel(new Model<>(newCategory));
	}

	/**
	 * For viewing or editing an existing {@link Category}.
	 * @param id
	 * @param categoryRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param originalId
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public CategoryDetailPanel2(String id, String originalId, final Class<? extends Page> backPage, final IModel<List<String>> defaultEnumsModel) {
		super(id);
		setModel(new Model<>(Preconditions.checkNotNull(catRepo.findOne(originalId),
						"Cannot find category %s using %s", originalId, catRepo)));
		this.editMode = EditMode.MODIFY;
		this.originalId = originalId;
		this.backPage = backPage;
		this.formalCategoryModel = new Model<>(Preconditions.checkNotNull(formalCategoryRepo.findOne(
				Preconditions.checkNotNull(getModelObject().getGoogleFormalId(), "Google Formal ID must not be null for category '%s'", getModelObject().getId())),
					"Formal Category must not be null by id '%s'", getModelObject().getGoogleFormalId()));
		
		this.defaultEnumsModel = defaultEnumsModel;
		
		if (this.formalCategoryModel.getObject().getPropertyOverrides() != null && !this.formalCategoryModel.getObject().getPropertyOverrides().isEmpty()) {
			final List<String> defaultEnumsByGoogle = this.formalCategoryModel.getObject().getPropertyOverrides().stream().filter(new java.util.function.Predicate<PropertyDefinition>() {
				@Override
				public boolean test(PropertyDefinition t) {
					return Optional.fromNullable(t.getUsableAsOption()).or(new Boolean(false)).booleanValue();
				}
			}).map(new Function<PropertyDefinition, String>() {
				@Override
				public String apply(PropertyDefinition t) {
					return t.getDefaultEnum();
				}
			}).collect(Collectors.toList());
			
			defaultEnumsByGoogle.forEach(new Consumer<String>() {
				@Override
				public void accept(String t) {
					if (!CategoryDetailPanel2.this.defaultEnumsModel.getObject().contains(t)) {
						CategoryDetailPanel2.this.defaultEnumsModel.getObject().add(t);
					}
				}
			});
		}
		
		
		if (getModelObject().getLanguage() == null) {
			getModelObject().setLanguage(appManifest.getDefaultLocale().toLanguageTag());
		}
		changeTranslationsByDefault();
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		categoryLocaleModel.setObject(Locale.forLanguageTag(getModelObject().getLanguage()));
		initLocalesAndTranslationMapModel();
		
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		add(new Label("kind", kindDisplayName));
		add(new BookmarkablePageLink<>("backLink", backPage));
		
		form = new Form<>("form");
		add(form);
		
		form.add(new Label("parentUName", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				if (getModelObject().getParentId() != null) {
					return getModelObject().getParentId();
				} else {
					return "(root)";
				}
			}
		}));
		
		form.add(new Label("formalCategory", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return formalCategoryModel.getObject().getName();
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
		
		final IModel<String> displayNameModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
//					log.debug("loading name for locale '{}': {}", selectedLocale, getModelObject().getName());
					return getModel().getObject().getName();
				} else {
					final String translation = transNameMapModel.getObject().get(selectedLocale);
//					log.debug("loading name for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextField<String> displayNameFld = new TextField<String>("displayName", displayNameModel){
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
		displayNameFld.setLabel(new Model<>("Display name"));
		displayNameFld.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					category.setName(displayNameModel.getObject());
					
					if (editMode == EditMode.ADD) {
						final String id = SlugUtils.generateValidId(category.getName(), new Predicate<String>() {
							@Override
							public boolean apply(@Nullable String input) {
								//FIXME: how??
								return !catRepo.exists(tenant.getTenantId() + "_" + input);
							}
						});
						category.setId(id);
						category.setSlug(null);
						category.resolve(catRepo);
						target.add(uNameDiv, slugPathDiv);
					}
				} else {
					updateAttributeTranslations(selectedLocale, Category.NAME_ATTR, displayNameModel.getObject());
					transNameMapModel.getObject().put(selectedLocale, displayNameModel.getObject());
				}
			}
		});
		form.add(displayNameFld);
		
		final IModel<String> descriptionModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
//					log.debug("loading description for locale '{}': {}", selectedLocale, getModelObject().getDescription());
					return getModel().getObject().getDescription();
				} else {
					final String translation = transDescriptionMapModel.getObject().get(selectedLocale);
//					log.debug("loading description for locale '{}': {}", selectedLocale, translation);
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
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
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
		
		
		curPropertyOverridesModel.setObject(new ArrayList<>(getModelObject().getPropertyOverrides()));
		final IModel<Collection<PropertyDefinition>> newPropertyOverridesModel = (IModel) new ListModel<>(new ArrayList<>());
		
		final WebMarkupContainer wmcPropertyOverride = new WebMarkupContainer("wmcPropertyOverride");
		wmcPropertyOverride.setOutputMarkupId(true);
		final PropertyDefinitionSelect2MultiChoice acPropertyDefinition = new PropertyDefinitionSelect2MultiChoice("acPropertyDefinition",
				newPropertyOverridesModel, curPropertyOverridesModel);
		acPropertyDefinition.setLabel(new Model<>("Property Override"));
		wmcPropertyOverride.add(acPropertyDefinition);

		final WebMarkupContainer wmcPropertyOverrideList = new WebMarkupContainer("wmcPropertyOverrides");
		wmcPropertyOverrideList.setOutputMarkupId(true);
		
		final AutoDisableAjaxButton btnAddNewPropertyDefinition = new AutoDisableAjaxButton("btnAddNewPropertyDefinition") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				if (newPropertyOverridesModel.getObject() == null || newPropertyOverridesModel.getObject().isEmpty()) {
					error("Please choose at least one property definition.");
					return;
				}
				for (final PropertyDefinition newPropDef : newPropertyOverridesModel.getObject()) {
					CategoryDetailPanel2.this.getModelObject().getPropertyOverrides().add(newPropDef);
				}
				addCurPropertyOverrides(newPropertyOverridesModel.getObject());
				newPropertyOverridesModel.getObject().clear();
//				log.debug("newPropertyOverrides are {}",
//						newPropertyOverridesModel.getObject() != null ? newPropertyOverridesModel.getObject().size() + " row(s)" : null);
				//$("#s2id_acPropertyDefinition135") --> clear all values
				final String call = "$('#" + acPropertyDefinition.getMarkupId() + "').select2(\"val\", \"\");";
				target.appendJavaScript(call);
				target.add(wmcPropertyOverrideList, wmcPropertyOverride);
				
			};
		};
		wmcPropertyOverride.add(btnAddNewPropertyDefinition);
		form.add(wmcPropertyOverride);
		
		final PropertyOverridesListView propertyOverridesLv = new PropertyOverridesListView("propertyOverrides",
				curPropertyOverridesModel, selectedLocaleModel, categoryLocaleModel, defaultEnumsModel){
			@Override
			protected void updatePropertyOverride(PropertyDefinition upPropertyOv, AjaxRequestTarget target) {
				final PropertyDefinition prevPropertyOv = Iterables.find(CategoryDetailPanel2.this.getModelObject().getPropertyOverrides(), new Predicate<PropertyDefinition>() {
					@Override
					public boolean apply(PropertyDefinition input) {
						return input.getId().equals(upPropertyOv.getId());
					}
				});
				log.debug("Found propertyOv: {}", prevPropertyOv);
				if (!CategoryDetailPanel2.this.getModelObject().getPropertyOverrides().remove(prevPropertyOv)) {
					error(String.format("Failed to update Property Override '%s'", upPropertyOv.getName()));
					return;
				}
				CategoryDetailPanel2.this.getModelObject().getPropertyOverrides().add(upPropertyOv);
				
				target.add(wmcPropertyOverrideList);
			}
		};
		wmcPropertyOverrideList.add(propertyOverridesLv);
		form.add(wmcPropertyOverrideList);
		
		final IndicatingAjaxButton saveBtn = new AutoDisableAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				if (editMode == EditMode.ADD) {
					final String id = SlugUtils.generateValidId(category.getName(), new Predicate<String>() {
						@Override
						public boolean apply(@Nullable String input) {
							//FIXME: how??
							return !catRepo.exists(tenant.getTenantId() + "_" + input);
						}
					});
					category.setId(id);
					category.setSlug(null);
					category.resolve(catRepo);
				}
				category.setStatus( statusModel.getObject() ? CategoryStatus.ACTIVE : CategoryStatus.VOID );
				
				// delete cache
				final Cache category2LevelStatusCache = cacheMgr.getCache("category2LevelStatus");
				final String category2LevelStatusKey = String.format("category2:%s:%s", tenant.getTenantId(), MongoCategoryRepositoryImpl.CATEGORY2_LEVEL_STATUS + category.getLevel());
				category2LevelStatusCache.evict(category2LevelStatusKey);
				
				final Cache category2LevelStatusParentIdCache = cacheMgr.getCache("category2LevelStatusParentId");
				final String category2LevelStatusParentIdKey = String.format("category2:%s:%s", tenant.getTenantId(), MongoCategoryRepositoryImpl.CATEGORY2_LEVEL_STATUS_PARENT_ID + category.getLevel() + category.getParentId());
				category2LevelStatusParentIdCache.evict(category2LevelStatusParentIdKey);
				
				final Cache category2StatusCache = cacheMgr.getCache("category2Status");
				final String category2StatusKey = String.format("category2:%s:%s", tenant.getTenantId(), "category2Status");
				category2StatusCache.evict(category2StatusKey);
				
				switch (editMode) {
				case ADD:
					try {
						catRepo.add(category);
						info("Added category " + category.getNsPrefix() + "_" + category.getName());
					} catch (DuplicateKeyException dke) {
						error("Duplikat kode/uname, mohon ubah nama.");
						return;
					}
					break;
				case MODIFY:
					catRepo.modify(originalId, category);
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
						return "return confirm('Do you want to delete category ' + " + JSONObject.quote(originalId) + " + '?')";
					}
				});
			}
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				//FIXME: how??
				catRepo.delete(originalId);
				warn("Deleted category " + originalId);
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
						displayNameModel.detach();
						descriptionModel.detach();
						target.add(displayNameFld, descriptionFld, wmcLocales, wmcPropertyOverrideList);
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
			transNameMapModel.getObject().put(locale, null);
			transDescriptionMapModel.getObject().put(locale, null);
		}
		
		if (getModelObject().getTranslations() != null && !getModelObject().getTranslations().isEmpty()) {
			for (final Entry<String, Map<String, String>> entry : getModelObject().getTranslations().entrySet()) {
				final Locale locale = Locale.forLanguageTag(entry.getKey());
				if (!locales.contains(locale)) {
					locales.add(locale);
				}
				
				final Map<String, String> translation = entry.getValue();
				for (final Entry<String, String> messageEntry : translation.entrySet()) {
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
			@Nullable final String upValue) {
		if (getModelObject().getTranslations() == null) {
			getModelObject().setTranslations(new HashMap<String, Map<String,String>>());
		}
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
		final String oldLanguageTag = Strings.nullToEmpty(getModelObject().getLanguage());
		final Locale oldLocale = Locale.forLanguageTag(oldLanguageTag);
		if (defaultLanguageTag.equals(oldLanguageTag)) {
			log.info("No need for translating different language with default (get from appManifest)");
			return;
		}
		//set the language as default of product
		getModelObject().setLanguage(defaultLanguageTag);
		if (getModelObject().getTranslations() == null) {
			getModelObject().setTranslations(new HashMap<String, Map<String,String>>());
		}
		if (!getModelObject().getTranslations().containsKey(oldLanguageTag)) {
			//create translation for old language
			updateAttributeTranslations(oldLocale, Category2.NAME_ATTR, getModelObject().getName());
			if (getModelObject().getDescription() != null) {
				updateAttributeTranslations(oldLocale, Category2.DESCRIPTION_ATTR, getModelObject().getDescription());
			}
		}
		
		if (getModelObject().getTranslations().containsKey(defaultLanguageTag)) {
			//update attribute from translation if exists
			final Map<String, String> translation = getModelObject().getTranslations().get(defaultLanguageTag);
			if (translation.containsKey(Category2.NAME_ATTR)) {
				getModelObject().setName(translation.get(Category.NAME_ATTR));
			}
			if (translation.containsKey(Category2.DESCRIPTION_ATTR)) {
				getModelObject().setDescription(translation.get(Category.DESCRIPTION_ATTR));
			}
			
			//remove translation as default language product
			getModelObject().getTranslations().remove(defaultLanguageTag);
		}
	}
	
	public void addCurPropertyOverrides(Collection<PropertyDefinition> upPropertyOverrides) {
		curPropertyOverridesModel.getObject().addAll(upPropertyOverrides);
	}
	
}
