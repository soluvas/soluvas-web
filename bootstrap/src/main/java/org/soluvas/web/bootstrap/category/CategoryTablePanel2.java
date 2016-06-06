package org.soluvas.web.bootstrap.category;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryPackage;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.web.site.widget.EnumColumn;
import org.soluvas.web.site.widget.LinkColumn;

import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton;

/**
 * List {@link Category}s in a {@link ProductCatalog}.
 * 
 * <pre>{@literal
 * @ManageMountPath("term/base/Color/")
 * public class ColorListPage extends AuthorizedMallPage {
 * 	
 * 	@SpringBean(name="colorCategoryRepo")
 * 	private CategoryRepository colorCategoryRepo;
 * 	
 * 	public ColorListPage(final PageParameters params) {
 * 		super(params);
 * 		add(new CategoryTablePanel("tablePanel", colorCategoryRepo, "base", "Color", "Colors",
 * 				ColorDetailPage.class));
 * 	}
 * 
 * }
 * }</pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CategoryTablePanel2 extends Panel {
	
	@SpringBean
	private MongoCategoryRepository catRepo;

	public CategoryTablePanel2(String id, final Class<? extends Page> addPage, final Class<? extends Page> detailPage) {
		super(id);
		final Form<Void> form = new Form<>("form");
		form.add(new Label("kindDisplayName", "Categories"));
		form.add(new BookmarkablePageLink<>("addLink", addPage));
		
		final IModel<String> txtSearchModel = new Model<>();
		
		final SortableDataProvider<Category2, String> termDp = new SortableDataProvider<Category2, String>() {

			@Override
			public Iterator<? extends Category2> iterator(long first, long count) {
				final SortParam<String> sortParam = getSort();
				final Sort sort = sortParam != null ? new Sort(sortParam.isAscending() ? Direction.ASC : Direction.DESC, sortParam.getProperty())
					: new Sort("positioner");
				final org.soluvas.data.domain.Page<Category2> page = catRepo.findAll(txtSearchModel.getObject(),  ImmutableList.of(), new PageOffsetRequest(first, count, sort));
				return page.getContent().iterator();
			}

			@Override
			public long size() {
				return catRepo.countAll(txtSearchModel.getObject(), ImmutableList.of());
			}

			@Override
			public IModel<Category2> model(Category2 object) {
				return new Model<>(object);
			}
		};
		termDp.setSort("positioner", SortOrder.ASCENDING);
		final List<IColumn<Category2, String>> columns = new ArrayList<>();
		columns.add(new EnumColumn<Category2>(new Model<>("Status"), "status", CategoryPackage.Literals.CATEGORY_STATUS,
				CategoryStatus.ICON_MAPPING).enumVisible(false).headerIcon("cog"));
		columns.add(new LinkColumn<Category2, String>(new Model<>("Name"), "name", "name", detailPage,
				"id", "id"));
		columns.add(new PropertyColumn<Category2, String>(new Model<>("Slug Path"), "slugPath", "slugPath"));
		columns.add(new PropertyColumn<Category2, String>(new Model<>("Namespace"), "nsPrefix", "nsPrefix"));
		columns.add(new PropertyColumn<Category2, String>(new Model<>("Position"), "positioner", "positioner"));
		columns.add(new AddChildColumn2(new Model<>("New Child Category"), addPage));
		final AjaxFallbackDefaultDataTable<Category2, String> tblCategory = new AjaxFallbackDefaultDataTable<>("table", columns, termDp, 20);
		tblCategory.setOutputMarkupId(true);
		form.add(tblCategory);
		
		//search
		form.add(new TextField<>("txtSearch", txtSearchModel));
		form.add(new LaddaAjaxButton("btnSearch", new Model<>("Search"), Buttons.Type.Default){
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				target.add(tblCategory);
			}
		});
		
		add(form);
	}
	
}
