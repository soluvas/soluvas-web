package org.soluvas.web.bootstrap.category;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.inject.Inject;

import org.apache.jena.ext.com.google.common.base.Optional;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
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
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryException;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.FormalCategory;
import org.soluvas.category.FormalCategoryRepository;
import org.soluvas.category.LayoutCategory;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.category.MongoCategoryRepositoryImpl;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.MixinManager;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.web.bootstrap.bootstrap3wysihtml5.WysihtmlTextArea;
import org.soluvas.web.bootstrap.bootstrap3wysihtml5.WysihtmlTextArea.SupportImage;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.widget.DisplayImageContainer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mongodb.DuplicateKeyException;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeIconType;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton;

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
	@SpringBean
	private ImageManager imageMgr;
	@SpringBean(name="categoryImageRepo")
	private ImageRepository categoryImageRepo;
	
	private final EditMode editMode;
	private final String originalId;
	
	private final IModel<Locale> categoryLocaleModel = new Model<>();
	private final IModel<Locale> selectedLocaleModel = new Model<>(appManifest.getDefaultLocale());
	private final IModel<List<Locale>> localesModel = new ListModel<>(new ArrayList<Locale>());
	private final IModel<FormalCategory> formalCategoryModel;
	
	private final IModel<Map<Locale, String>> transNameMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transDescriptionMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transMetaTitleMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transMetaKeywordsMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transMetaDescriptionMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<Map<Locale, String>> transTitleMapModel = new MapModel<>(new HashMap<Locale, String>());
	private final IModel<List<PropertyDefinition>> curPropertyOverridesModel = new ListModel<>();
	private Form<Void> form;
	private final IModel<List<String>> defaultEnumsModel;
	private final IModel<String> descriptionModel = new Model<>();
	
	private final IModel<String> fullHorizontalModel = new Model<>();
	private final IModel<Map<Locale, String>> transFullHorizontalMapModel = new MapModel<>(new HashMap<Locale, String>());
	
	private final IModel<String> threeColumns1Model = new Model<>();
	private final IModel<Map<Locale, String>> transThreeColumns1MapModel = new MapModel<>(new HashMap<Locale, String>());
	
	private final IModel<String> threeColumns2Model = new Model<>();
	private final IModel<Map<Locale, String>> transThreeColumns2MapModel = new MapModel<>(new HashMap<Locale, String>());
	
	private final IModel<String> threeColumns3Model = new Model<>();
	private final IModel<Map<Locale, String>> transThreeColumns3MapModel = new MapModel<>(new HashMap<Locale, String>());

	/**
	 * For creating a new {@link Category}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param backPage
	 * @param parentModel Parent {@link Category#getUName()} (non-editable).
	 * @param formalCategoryModel
	 * @param defaultEnumsModel
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
			newCategory.setGoogleFormalId(parentModel.getObject().getGoogleFormalId());
		}
		if (parentModel.getObject() == null && formalCategoryModel.getObject() != null) {
			newCategory.setGoogleFormalId(formalCategoryModel.getObject().getGoogleId());
			if (formalCategoryModel.getObject().getPropertyOverrides() != null && !formalCategoryModel.getObject().getPropertyOverrides().isEmpty()) {
				newCategory.getPropertyOverrides().addAll(formalCategoryModel.getObject().getPropertyOverrides());
			}
		}
		newCategory.setStatus(CategoryStatus.ACTIVE);
		newCategory.setPositioner(0);
		newCategory.setLayout(LayoutCategory.FULL_HORIZONTAL);
		setModel(new Model<>(newCategory));
	}

	/**
	 * For viewing or editing an existing {@link Category}.
	 * @param id
	 * @param originalId
	 * @param backPage
	 * @param defaultEnumsModel
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
		
		form = new Form<>("form");
		add(form);
		
		categoryLocaleModel.setObject(Locale.forLanguageTag(getModelObject().getLanguage()));
		initLocalesAndTranslationMapModel();
		
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		form.add(new BookmarkablePageLink<>("backLink", backPage));
		
		
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
					
					if (editMode == EditMode.ADD && !Strings.isNullOrEmpty(category.getName())) {
						final String id = SlugUtils.generateValidId(category.getName(), new Predicate<String>() {
							@Override
							public boolean apply(@Nullable String input) {
//								return !catRepo.exists(tenant.getTenantId() + "_" + input); //udh ga pk nsPrefix lg
								return !catRepo.exists(input);
							}
						});
						category.setId(id);
						category.setSlug(null);
						category.resolve(catRepo);
					} else {
						category.setId(null);
						category.setSlug(null);
						category.resolve(null);
					}
					target.add(uNameDiv, slugPathDiv);
				} else {
					updateAttributeTranslations(selectedLocale, Category2.NAME_ATTR, displayNameModel.getObject());
					transNameMapModel.getObject().put(selectedLocale, displayNameModel.getObject());
				}
			}
		});
		form.add(displayNameFld);
		
		final IModel<String> titleModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					return getModel().getObject().getTitle();
				} else {
					final String translation = transTitleMapModel.getObject().get(selectedLocale);
					return translation;
				}
			}
		};
		final TextArea<String> titleFld = new TextArea<String>("titleTxtArea", titleModel){
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
		titleFld.add(new OnChangeThrottledBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					category.setTitle(titleModel.getObject());
				} else {
					updateAttributeTranslations(selectedLocale, Category2.TITLE_ATTR, titleModel.getObject());
					transTitleMapModel.getObject().put(selectedLocale, titleModel.getObject());
				}
			}
		});
		titleFld.setEnabled(editable);
		form.add(titleFld);
		
		final WebMarkupContainer wmcDescriptionWysihtml = new WebMarkupContainer("wmcDescriptionWysihtml");
		wmcDescriptionWysihtml.setOutputMarkupId(true);
		final WysihtmlTextArea descriptionWysihtml = new WysihtmlTextArea("descriptionWysihtml", descriptionModel, SupportImage.ENABLED){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					descriptionModel.setObject(CategoryDetailPanel2.this.getModelObject().getDescription());
					add(new AttributeModifier("class", "form-control"));
				} else {
					descriptionModel.setObject(transDescriptionMapModel.getObject().get(selectedLocaleModel.getObject()));
					add(new AttributeModifier("class", "form-control focus"));
				}
			};
		};
		wmcDescriptionWysihtml.add(descriptionWysihtml);
		form.add(wmcDescriptionWysihtml);
		
		final WebMarkupContainer wmcContents = new WebMarkupContainer("wmcContents");
		wmcContents.setOutputMarkupId(true);
		
		final DropDownChoice<LayoutCategory> ddcLayout = new DropDownChoice<>("ddcLayout", new PropertyModel<>(getModel(), "layout"),
				new ListModel<>(ImmutableList.copyOf(LayoutCategory.values())), new IChoiceRenderer<LayoutCategory>() {

					@Override
					public Object getDisplayValue(LayoutCategory object) {
						switch (object) {
						case FULL_HORIZONTAL:
							return "Full Horizontal";
						case THREE_COLUMNS:
							return "3 Columns";
						default:
							throw new CategoryException(String.format("Unsupported for layout '%s'", object));
						}
					}

					@Override
					public String getIdValue(LayoutCategory object, int index) {
						return object.name();
					}
			
				});
		ddcLayout.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(wmcContents);
			}
		});
		form.add( ddcLayout );
		
		//full horizontal
		final WebMarkupContainer fullHorizontal = new WebMarkupContainer("fullHorizontal"){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(CategoryDetailPanel2.this.getModelObject().getLayout() == LayoutCategory.FULL_HORIZONTAL);
			}
		};
		final WysihtmlTextArea contentFullHorizontal = new WysihtmlTextArea("contentFullHorizontal", fullHorizontalModel, SupportImage.ENABLED){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					fullHorizontalModel.setObject(CategoryDetailPanel2.this.getModelObject().getContents().get(Category2.KEY_CONTENT_FULL_HORIZONTAL));
					add(new AttributeModifier("class", "form-control"));
				} else {
					fullHorizontalModel.setObject(transFullHorizontalMapModel.getObject().get(selectedLocaleModel.getObject()));
					add(new AttributeModifier("class", "form-control focus"));
				}
			};
		};
		fullHorizontal.add(contentFullHorizontal);
		wmcContents.add(fullHorizontal);
		
		//three columns
		final WebMarkupContainer threeColumns = new WebMarkupContainer("threeColumns"){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(CategoryDetailPanel2.this.getModelObject().getLayout() == LayoutCategory.THREE_COLUMNS);
			}
		};
		final WysihtmlTextArea contentThreeColumns1 = new WysihtmlTextArea("contentThreeColumns1", threeColumns1Model, SupportImage.ENABLED){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					threeColumns1Model.setObject(CategoryDetailPanel2.this.getModelObject().getContents().get(Category2.KEY_CONTENT_THREE_COLUMNS_1));
					add(new AttributeModifier("class", "form-control"));
				} else {
					threeColumns1Model.setObject(transThreeColumns1MapModel.getObject().get(selectedLocaleModel.getObject()));
					add(new AttributeModifier("class", "form-control focus"));
				}
			};
		};
		threeColumns.add(contentThreeColumns1);
		final WysihtmlTextArea contentThreeColumns2 = new WysihtmlTextArea("contentThreeColumns2", threeColumns2Model, SupportImage.ENABLED){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					threeColumns2Model.setObject(CategoryDetailPanel2.this.getModelObject().getContents().get(Category2.KEY_CONTENT_THREE_COLUMNS_2));
					add(new AttributeModifier("class", "form-control"));
				} else {
					threeColumns2Model.setObject(transThreeColumns2MapModel.getObject().get(selectedLocaleModel.getObject()));
					add(new AttributeModifier("class", "form-control focus"));
				}
			};
		};
		threeColumns.add(contentThreeColumns2);
		final WysihtmlTextArea contentThreeColumns3 = new WysihtmlTextArea("contentThreeColumns3", threeColumns3Model, SupportImage.ENABLED){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					threeColumns3Model.setObject(CategoryDetailPanel2.this.getModelObject().getContents().get(Category2.KEY_CONTENT_THREE_COLUMNS_3));
					add(new AttributeModifier("class", "form-control"));
				} else {
					threeColumns3Model.setObject(transThreeColumns3MapModel.getObject().get(selectedLocaleModel.getObject()));
					add(new AttributeModifier("class", "form-control focus"));
				}
			};
		};
		threeColumns.add(contentThreeColumns3);
		wmcContents.add(threeColumns);
		
		form.add(wmcContents);
		
		final IModel<Boolean> statusModel = new Model<>( getModelObject().getStatus() == CategoryStatus.ACTIVE );
		form.add(new CheckBox("status", statusModel));
		
		form.add(new NumberTextField<>("positioner", new PropertyModel<Integer>(getModel(), "positioner"), Integer.class));
		
		final IModel<DisplayImage> displayImageModel = new LoadableDetachableModel<DisplayImage>() {
			@Override
			protected DisplayImage load() {
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				log.debug("category image id is {}", category.getImageId());
				if (category.getImageId() != null) {
					return imageMgr.getSafeImage(ImageTypes.CATEGORY, category.getImageId(), ImageStyles.SMALL);
				} else {
					return null;
				}
			}
		};
		
		final WebMarkupContainer imageCtr = new WebMarkupContainer("imageCtr");
		imageCtr.add(new DisplayImageContainer("categoryImage", displayImageModel));
		imageCtr.setOutputMarkupId(true);
		form.add(imageCtr);
		
		FileUploadField uploadImageField = new FileUploadField("img");
		uploadImageField.add(new AjaxFormSubmitBehavior("change") {
			@SuppressWarnings("deprecation")
			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				super.onSubmit(target);
				final FileUpload uploadedFile = uploadImageField.getFileUpload();
				try {
					if (uploadedFile == null) throw new IllegalArgumentException("Cannot process null image");
					File file = uploadedFile.writeToTempFile();
					final Predicate<String> predicate = new Predicate<String>() {
						@Override
						public boolean apply(String input) {
							return !categoryImageRepo.exists(input);
						}
					};
					Image image = new Image(file, uploadedFile.getContentType(), uploadedFile.getClientFileName(),
							predicate);
					
					log.debug("attempting to upload category image");
					// 
					try(ImageInputStream in = ImageIO.createImageInputStream(file)){
						final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
					    if (readers.hasNext()) {
					        ImageReader reader = readers.next();
					        try {
					            reader.setInput(in);
					            final java.awt.Dimension dimension = new java.awt.Dimension(reader.getWidth(0), reader.getHeight(0));
					            Double xxxhdpiWidth = new Double(dimension.getWidth() * 4.0);
					            Double xxxhdpiHeight = new Double(dimension.getHeight() * 4.0);
					            categoryImageRepo.addStyle("xxxhdpi", "xxxhdpi", xxxhdpiWidth.intValue(), xxxhdpiHeight.intValue());
					            
					            Double xxhdpiWidth = new Double(dimension.getWidth() * 3.0);
					            Double xxhdpiHeight = new Double(dimension.getHeight() * 3.0);
								categoryImageRepo.addStyle("xxhdpi", "xxhdpi", xxhdpiWidth.intValue(), xxhdpiHeight.intValue());
								
								Double xhdpiWidth = new Double(dimension.getWidth() * 2.0);
					            Double xhdpiHeight = new Double(dimension.getHeight() * 2.0);
								categoryImageRepo.addStyle("xhdpi", "xhdpi", xhdpiWidth.intValue(), xhdpiHeight.intValue());
								
								Double hdpiWidth = new Double(dimension.getWidth() * 1.5);
					            Double hdpiHeight = new Double(dimension.getHeight() * 1.5);
								categoryImageRepo.addStyle("hdpi", "hdpi", hdpiWidth.intValue(), hdpiHeight.intValue());
					        } finally {
					            reader.dispose();
					        }
					    }
					}
					
					log.debug("attempting to save new image category");
					Image addedImage = categoryImageRepo.add(image);
					final Category2 category = CategoryDetailPanel2.this.getModelObject();
					log.debug("added image id {}", addedImage.getId());
					category.setImageId(addedImage.getId());
					displayImageModel.detach();
					file.delete();
					target.add(imageCtr);
				} catch (IllegalArgumentException ex) {
					ex.printStackTrace();
					log.error("ada error: {}", ex.getMessage());
					error(ex.getMessage());
				} catch (IOException e) {
					log.error("Cannot upload category image because of {}", e.getMessage());
					error("Cannot upload category image");
				}
				
//				if (uploadedFile != null) {
//					try {
//						final File tmpFile = uploadedFile.writeToTempFile();
//						log.debug("Tmp File: {}", tmpFile);
//				    	try {
//				    		final Image newImage = new Image(tmpFile, uploadedFile.getContentType(), uploadedFile.getClientFileName());
//        					final Image added = Preconditions.checkNotNull(personImageRepo.add(newImage),
//        							"Cannot upload image %s (%s bytes) in temporary file %s using %s",
//        							uploadedFile.getClientFileName(), uploadedFile.getSize(), tmpFile, personImageRepo);
//							final String imageId = added.getId();
//							log.debug("PhotoID before: {}", personModel.getObject().getPhotoId());
//							personModel.getObject().setPhotoId(imageId);
//							log.debug("PhotoID after: {}", personModel.getObject().getPhotoId());
//						} finally {
//							log.debug("Deleting {}", tmpFile);
//							tmpFile.delete();
//						}
//					} catch (Exception e) {
//						log.error("Cannot process image " + uploadedFile, e);
//						throw new RuntimeException("Cannot process image " + uploadedFile, e);
//					}
//				}
//				
//				target.add(FileUploaderForm.this);
			}
		});
		form.add(uploadImageField);
		
		/*SEO*/
		final IModel<String> metaTitleModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
//					log.debug("loading name for locale '{}': {}", selectedLocale, getModelObject().getName());
					return getModel().getObject().getMetaTitle();
				} else {
					final String translation = transMetaTitleMapModel.getObject().get(selectedLocale);
//					log.debug("loading name for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextField<String> metaTitle = new TextField<String>("metaTitle", metaTitleModel){
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
		metaTitle.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					category.setMetaTitle(metaTitleModel.getObject());
				} else {
					updateAttributeTranslations(selectedLocale, Category2.META_TITLE_ATTR, metaTitleModel.getObject());
					transMetaTitleMapModel.getObject().put(selectedLocale, metaTitleModel.getObject());
				}
			}
		});
		metaTitle.setOutputMarkupId(true);
		form.add(metaTitle);
		
		final IModel<String> metaKeywordsModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
//					log.debug("loading description for locale '{}': {}", selectedLocale, getModelObject().getDescription());
					return getModel().getObject().getMetaKeywords();
				} else {
					final String translation = transMetaKeywordsMapModel.getObject().get(selectedLocale);
//					log.debug("loading description for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextArea<String> metaKeywords = new TextArea<String>("metaKeywords", metaKeywordsModel){
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
		metaKeywords.add(new OnChangeThrottledBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					category.setMetaKeywords(metaKeywordsModel.getObject());
				} else {
					updateAttributeTranslations(selectedLocale, Category2.META_KEYWORDS_ATTR, metaKeywordsModel.getObject());
					transMetaKeywordsMapModel.getObject().put(selectedLocale, metaKeywordsModel.getObject());
				}
			}
		});
		metaKeywords.setOutputMarkupId(true);
		form.add(metaKeywords);
		
		final IModel<String> metaDescriptionModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
//					log.debug("loading description for locale '{}': {}", selectedLocale, getModelObject().getDescription());
					return getModel().getObject().getMetaDescription();
				} else {
					final String translation = transMetaDescriptionMapModel.getObject().get(selectedLocale);
//					log.debug("loading description for locale '{}': {}", selectedLocale, translation);
					return translation;
				}
			}
		};
		final TextArea<String> metaDescription = new TextArea<String>("metaDescription", metaDescriptionModel){
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
		metaDescription.add(new OnChangeThrottledBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					category.setMetaDescription(metaDescriptionModel.getObject());
				} else {
					updateAttributeTranslations(selectedLocale, Category2.META_DESCRIPTION_ATTR, metaDescriptionModel.getObject());
					transMetaDescriptionMapModel.getObject().put(selectedLocale, metaDescriptionModel.getObject());
				}
			}
		});
		metaDescription.setOutputMarkupId(true);
		form.add(metaDescription);
		
		
		/*ADVANCED*/
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
		
		final LaddaAjaxButton btnAddNewPropertyDefinition = new LaddaAjaxButton("btnAddNewPropertyDefinition", new Model<>("Add New"), Buttons.Type.Default) {
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
		
		final BootstrapAjaxButton saveBtn = new LaddaAjaxButton("saveBtn", new Model<>("Save"), Buttons.Type.Primary) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Category2 category = CategoryDetailPanel2.this.getModelObject();
				
				if (Strings.isNullOrEmpty(category.getName())) {
					info("Nama tidak boleh kosong.");
					return;
				}
				
				if (editMode == EditMode.ADD) {
					final String id = SlugUtils.generateValidId(category.getName(), new Predicate<String>() {
						@Override
						public boolean apply(@Nullable String input) {
							//FIXME: how??
//							return !catRepo.exists(tenant.getTenantId() + "_" + input); //udh ga pk nsPrefix lg
							return !catRepo.exists(input);
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
				
				updateDescription();
				updateContents();
				
				switch (editMode) {
				case ADD:
					try {
						catRepo.add(category);
						info("Added category " + category.getNsPrefix() + "_" + category.getName());
					} catch (DuplicateKeyException dke) {
						log.error(String.format("Duplicate Key exception: %s", dke), dke);
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
		}.setIconType(FontAwesomeIconType.trash_o);
		deleteBtn.setEnabled(editable);
		deleteBtn.setVisible(false); // don't allow them to delete because old products might have inconsistent data. if want to delete, ask developers :)
		form.add(deleteBtn);
		
		/*LANGUAGE BUTTONS*/
		final WebMarkupContainer wmcLocales = new WebMarkupContainer("wmcLocales");
		wmcLocales.setOutputMarkupId(true);
		wmcLocales.add(new ListView<Locale>("locales", localesModel) {
			@Override
			protected void populateItem(final ListItem<Locale> item) {
				final Model<String> lblModel = new Model<>(
						item.getModelObject().getDisplayLanguage() +
								"-" + item.getModelObject().getDisplayCountry() +
								(Objects.equal(appManifest.getDefaultLocale(), item.getModelObject()) ? " AS DEFAULT" : "")
				);
				final LaddaAjaxButton btnLocale = new LaddaAjaxButton("btnLocale", lblModel, Buttons.Type.Default) {
					@Override
					protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
						super.onSubmit(target, form);
						updateDescription();
						updateContents();
						
						selectedLocaleModel.setObject(item.getModelObject());
						
						displayNameModel.detach();
						metaTitleModel.detach();
						metaKeywordsModel.detach();
						metaDescriptionModel.detach();
						titleModel.detach();
						target.add(displayNameFld, wmcDescriptionWysihtml, wmcLocales, wmcPropertyOverrideList, metaTitle, metaKeywords, metaDescription, titleFld, wmcContents);
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
				item.add(btnLocale);
			}
		});
		form.add(wmcLocales);
	}
	
	private void updateDescription() {
		final Category2 category = CategoryDetailPanel2.this.getModelObject();
		final Locale selectedLocale = selectedLocaleModel.getObject();
		final Locale categoryLocale = categoryLocaleModel.getObject();
		final String descriptionValue = descriptionModel.getObject();
		if (Objects.equal(selectedLocale, categoryLocale)) {
			category.setDescription(descriptionValue);
		} else {
			updateAttributeTranslations(selectedLocale, Category2.DESCRIPTION_ATTR, descriptionValue);
			transDescriptionMapModel.getObject().put(selectedLocale, descriptionValue);
		}
	}
	
	private void updateContents() {
		final Category2 category = CategoryDetailPanel2.this.getModelObject();
		final Locale selectedLocale = selectedLocaleModel.getObject();
		final Locale categoryLocale = categoryLocaleModel.getObject();

		if (category.getLayout() == null) {
			return;
		}
		switch (category.getLayout()) {
		case FULL_HORIZONTAL:
			final String contentFullHorizontal = fullHorizontalModel.getObject();
			if (Objects.equal(selectedLocale, categoryLocale)) {
				category.getContents().put(Category2.KEY_CONTENT_FULL_HORIZONTAL, contentFullHorizontal);
			} else {
				updateAttributeTranslations(selectedLocale, Category2.KEY_CONTENT_FULL_HORIZONTAL, contentFullHorizontal);
				transFullHorizontalMapModel.getObject().put(selectedLocale, contentFullHorizontal);
			}
			break;
		case THREE_COLUMNS:
			final String contentThreeColumn1 = threeColumns1Model.getObject();
			if (Objects.equal(selectedLocale, categoryLocale)) {
				category.getContents().put(Category2.KEY_CONTENT_THREE_COLUMNS_1, contentThreeColumn1);
			} else {
				updateAttributeTranslations(selectedLocale, Category2.KEY_CONTENT_THREE_COLUMNS_1, contentThreeColumn1);
				transThreeColumns1MapModel.getObject().put(selectedLocale, contentThreeColumn1);
			}
			
			final String contentThreeColumn2 = threeColumns2Model.getObject();
			if (Objects.equal(selectedLocale, categoryLocale)) {
				category.getContents().put(Category2.KEY_CONTENT_THREE_COLUMNS_2, contentThreeColumn2);
			} else {
				updateAttributeTranslations(selectedLocale, Category2.KEY_CONTENT_THREE_COLUMNS_2, contentThreeColumn2);
				transThreeColumns2MapModel.getObject().put(selectedLocale, contentThreeColumn2);
			}
			
			final String contentThreeColumn3 = threeColumns3Model.getObject();
			if (Objects.equal(selectedLocale, categoryLocale)) {
				category.getContents().put(Category2.KEY_CONTENT_THREE_COLUMNS_3, contentThreeColumn3);
			} else {
				updateAttributeTranslations(selectedLocale, Category2.KEY_CONTENT_THREE_COLUMNS_3, contentThreeColumn3);
				transThreeColumns3MapModel.getObject().put(selectedLocale, contentThreeColumn3);
			}
			
			break;
		default:
			throw new CategoryException(String.format("Unsupported for layout '%s'", category.getLayout()));
		}
		
		
	}
	
	private void initLocalesAndTranslationMapModel() {
		//TODO: get languages from app manifest
		final Collection<Locale> locales = new ArrayList<>(SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.values());
		for (final Locale locale : locales) {
			transNameMapModel.getObject().put(locale, null);
			transDescriptionMapModel.getObject().put(locale, null);
			transFullHorizontalMapModel.getObject().put(locale, null);
			transMetaDescriptionMapModel.getObject().put(locale, null);
			transMetaKeywordsMapModel.getObject().put(locale, null);
			transMetaTitleMapModel.getObject().put(locale, null);
			transThreeColumns1MapModel.getObject().put(locale, null);
			transThreeColumns2MapModel.getObject().put(locale, null);
			transThreeColumns3MapModel.getObject().put(locale, null);
			transTitleMapModel.getObject().put(locale, null);
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
					if (messageEntry.getKey().equals(Category2.NAME_ATTR)) {
						transNameMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//description
					if (messageEntry.getKey().equals(Category2.DESCRIPTION_ATTR)) {
						transDescriptionMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//meta title
					if (messageEntry.getKey().equals(Category2.META_TITLE_ATTR)) {
						transMetaTitleMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//meta keywords
					if (messageEntry.getKey().equals(Category2.META_KEYWORDS_ATTR)) {
						transMetaKeywordsMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//meta description
					if (messageEntry.getKey().equals(Category2.META_DESCRIPTION_ATTR)) {
						transMetaDescriptionMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//title
					if (messageEntry.getKey().equals(Category2.TITLE_ATTR)) {
						transTitleMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//content - full horizontal
					if (messageEntry.getKey().equals(Category2.KEY_CONTENT_FULL_HORIZONTAL)) {
						transFullHorizontalMapModel.getObject().put(locale, messageEntry.getValue());
					}
					//content - three columns 1
					if (messageEntry.getKey().equals(Category2.KEY_CONTENT_THREE_COLUMNS_1)) {
						transThreeColumns1MapModel.getObject().put(locale, messageEntry.getValue());
					}
					//content - three columns 2
					if (messageEntry.getKey().equals(Category2.KEY_CONTENT_THREE_COLUMNS_2)) {
						transThreeColumns2MapModel.getObject().put(locale, messageEntry.getValue());
					}
					//content - three columns 3
					if (messageEntry.getKey().equals(Category2.KEY_CONTENT_THREE_COLUMNS_3)) {
						transThreeColumns3MapModel.getObject().put(locale, messageEntry.getValue());
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
		log.info("Updating translation for different language with default (get from appManifest)");
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
			if (getModelObject().getTitle() != null) {
				updateAttributeTranslations(oldLocale, Category2.TITLE_ATTR, getModelObject().getTitle());
			}
			if (getModelObject().getContents() != null && !getModelObject().getContents().isEmpty()) {
				for (final Entry<String, String> entry : getModelObject().getContents().entrySet()) {
					updateAttributeTranslations(oldLocale, entry.getKey(), entry.getValue());
				}
			}
		}
		
		if (getModelObject().getTranslations().containsKey(defaultLanguageTag)) {
			//update attribute from translation if exists
			final Map<String, String> translation = getModelObject().getTranslations().get(defaultLanguageTag);
			if (translation.containsKey(Category2.NAME_ATTR)) {
				getModelObject().setName(translation.get(Category2.NAME_ATTR));
			}
			if (translation.containsKey(Category2.DESCRIPTION_ATTR)) {
				getModelObject().setDescription(translation.get(Category2.DESCRIPTION_ATTR));
			}
			if (translation.containsKey(Category2.TITLE_ATTR)) {
				getModelObject().setTitle(translation.get(Category2.TITLE_ATTR));
			}
			if (translation.containsKey(Category2.KEY_CONTENT_FULL_HORIZONTAL)) {
				getModelObject().getContents().put(Category2.KEY_CONTENT_FULL_HORIZONTAL, translation.get(Category2.KEY_CONTENT_FULL_HORIZONTAL));
			}
			if (translation.containsKey(Category2.KEY_CONTENT_THREE_COLUMNS_1)) {
				getModelObject().getContents().put(Category2.KEY_CONTENT_THREE_COLUMNS_1, translation.get(Category2.KEY_CONTENT_THREE_COLUMNS_1));
			}
			if (translation.containsKey(Category2.KEY_CONTENT_THREE_COLUMNS_2)) {
				getModelObject().getContents().put(Category2.KEY_CONTENT_THREE_COLUMNS_2, translation.get(Category2.KEY_CONTENT_THREE_COLUMNS_2));
			}
			if (translation.containsKey(Category2.KEY_CONTENT_THREE_COLUMNS_3)) {
				getModelObject().getContents().put(Category2.KEY_CONTENT_THREE_COLUMNS_3, translation.get(Category2.KEY_CONTENT_THREE_COLUMNS_3));
			}
			
			//remove translation as default language product
			getModelObject().getTranslations().remove(defaultLanguageTag);
		}
	}
	
	public void addCurPropertyOverrides(Collection<PropertyDefinition> upPropertyOverrides) {
		curPropertyOverridesModel.getObject().addAll(upPropertyOverrides);
	}
	
}
