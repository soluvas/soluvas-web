package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.impl.CategoryImpl;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinManager;
import org.soluvas.web.site.CategoryModel;
import org.soluvas.web.site.EmfModel;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.widget.AutoDisableAjaxButton;

import com.google.common.base.Function;
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
	private final CategoryRepository categoryRepo;
	private final EditMode editMode;
	private final String originalUName;

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
	}
	
	@SuppressWarnings("null")
	@Override
	protected void onInitialize() {
		super.onInitialize();
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
		
		final TextField<String> displayNameFld = new TextField<>("displayName", new PropertyModel<String>(getModel(), "name"));
		displayNameFld.setRequired(true);
		displayNameFld.setEnabled(editable);
		displayNameFld.add(new OnChangeThrottledBehavior("onchange") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
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
				target.add(headerUNameLabel, uNameDiv, slugPathDiv);
			}
		});
		form.add(displayNameFld);
		
		final TextArea<String> descriptionFld = new TextArea<>("description", new PropertyModel<String>(getModel(), "description"));
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
	}
	
}
