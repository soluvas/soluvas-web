package org.soluvas.web.bootstrap.category;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.impl.CategoryImpl;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.web.site.EmfModel;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * View/edit a {@link Category}, only editable if nsPrefix != base.
 * <p>Use e.g. @WicketMountPoint(mountPoint="category/base/Color/${uName}")
 * <pre>{@literal
 * @WicketMountPoint(mountPoint="category/base/Color/${uName}/")
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
	private static final String kindDisplayName = "Releases";
	private final Class<? extends Page> backPage;
	@SpringBean
	private TenantRef tenant;
	private final CategoryRepository categoryRepo;
	private final EditMode editMode;
	private final String originalUName;

	/**
	 * For creating a new {@link Category}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param categoryRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public CategoryDetailPanel(String id, CategoryRepository categoryRepo,
			final Class<? extends Page> backPage) {
		super(id);
		this.editMode = EditMode.ADD;
		this.originalUName = null;
		this.categoryRepo = categoryRepo;
		this.backPage = backPage;
		
		// get the topmost position
		final List<Category> mostRecents = categoryRepo.findAll(new PageRequest(0, 1, Direction.ASC, "positioner")).getContent();
		
		final CategoryImpl category = new CategoryImpl();
		category.setNsPrefix(tenant.getTenantId());
		category.setStatus(CategoryStatus.ACTIVE);
		if (!mostRecents.isEmpty()) {
			// subtract 10 so the new category is before the most recent category
			log.debug("most recent category is {}", mostRecents.get(0).getName());
			category.setPositioner(Optional.fromNullable(mostRecents.get(0).getPositioner()).or(0) - 10);
		} else {
			category.setPositioner(0);
		}
		setModel(new EmfModel<Category>(category));
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
		super(id, new EmfModel<>(
				Preconditions.checkNotNull(categoryRepo.findOne(uName),
						"Cannot find category %s using %s", uName, categoryRepo)
			));
		this.editMode = EditMode.MODIFY;
		this.categoryRepo = categoryRepo;
		this.originalUName = uName;
		this.backPage = backPage;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		add(new Label("kind", kindDisplayName));
		add(new BookmarkablePageLink<>("backLink", backPage));
		
		final Label uNameLabel = new Label("categoryUName", new PropertyModel<>(getModel(), "uName"));
		uNameLabel.setOutputMarkupId(true);
		add(uNameLabel);
		
		final Form<Void> form = new Form<>("form");
		add(form);
		
		final WebMarkupContainer uNameDiv = new WebMarkupContainer("uNameDiv");
		uNameDiv.setOutputMarkupId(true);
		uNameDiv.add(new Label("nsPrefix", new PropertyModel<>(getModel(), "nsPrefix")));
		final TextField<String> nameFld = new TextField<>("name", new PropertyModel<String>(getModel(), "id"));
		nameFld.setEnabled(false);
		nameFld.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(uNameLabel);
			}
		});
		uNameDiv.add(nameFld);
		form.add(uNameDiv);
		
		final WebMarkupContainer slugPathDiv = new WebMarkupContainer("slugPathDiv");
		slugPathDiv.setOutputMarkupId(true);
		final TextField<String> slugPathFld = new TextField<>("slugPath", new PropertyModel<String>(getModel(), "slugPath"));
		slugPathFld.setEnabled(false);
		slugPathDiv.add(slugPathFld);
		form.add(slugPathDiv);
		
		final TextField<Object> displayNameFld = new TextField<>("displayName", new PropertyModel<>(getModel(), "name"));
		displayNameFld.setRequired(true);
		displayNameFld.setEnabled(editable);
		displayNameFld.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final Category category = CategoryDetailPanel.this.getModelObject();
				category.setId(null);
				category.setSlug(null);
				category.resolve();
				target.add(uNameDiv, slugPathDiv);
			}
		});
		form.add(displayNameFld);
		
		final IModel<Boolean> statusModel = new Model<>( getModelObject().getStatus() == CategoryStatus.ACTIVE );
		form.add(new CheckBox("status", statusModel));
		
		form.add(new NumberTextField<>("positioner", new PropertyModel<Integer>(getModel(), "positioner"), Integer.class));
		
		final IndicatingAjaxButton saveBtn = new IndicatingAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Category category = CategoryDetailPanel.this.getModelObject();
				category.setId(null);
				category.setSlug(null);
				category.resolve();
				category.setStatus( statusModel.getObject() ? CategoryStatus.ACTIVE : CategoryStatus.VOID );
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
		
		final IndicatingAjaxButton deleteBtn = new IndicatingAjaxButton("deleteBtn", form) {
			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				super.updateAjaxAttributes(attributes);
				attributes.getAjaxCallListeners().add(new AjaxCallListener() {
					@Override
					public CharSequence getPrecondition(Component component) {
						return "return confirm(\"Do you want to delete category '" + originalUName + "'?\")";
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
