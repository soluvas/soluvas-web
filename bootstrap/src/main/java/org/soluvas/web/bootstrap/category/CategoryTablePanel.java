package org.soluvas.web.bootstrap.category;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryPackage;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.web.site.CategoryModel;
import org.soluvas.web.site.widget.EnumColumn;
import org.soluvas.web.site.widget.LinkColumn;

/**
 * List {@link Category}s in a {@link ProductCatalog}.
 * 
 * <pre>{@literal
 * @WicketMountPoint(mountPoint="term/base/Color/")
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
public class CategoryTablePanel extends Panel {
	
	private CategoryRepository categoryRepo;

	public CategoryTablePanel(String id, CategoryRepository categoryRepo,
			final Class<? extends Page> addPage, final Class<? extends Page> detailPage) {
		super(id);
		this.categoryRepo = categoryRepo;
		add(new Label("kindDisplayName", "Categories"));
		add(new BookmarkablePageLink<>("addLink", addPage));
		
		final SortableDataProvider<Category, String> termDp = new SortableDataProvider<Category, String>() {
			@Override
			public Iterator<? extends Category> iterator(long first, long count) {
				final SortParam<String> sortParam = getSort();
				final Sort sort = sortParam != null ? new Sort(sortParam.isAscending() ? Direction.ASC : Direction.DESC, sortParam.getProperty())
					: new Sort("positioner");
				final org.soluvas.data.domain.Page<Category> page = CategoryTablePanel.this.categoryRepo.findAll(new PageOffsetRequest(first, count, sort));
				return page.getContent().iterator();
			}

			@Override
			public long size() {
				return CategoryTablePanel.this.categoryRepo.count();
			}

			@Override
			public IModel<Category> model(Category object) {
				return new CategoryModel<>(object);
			}
		};
		termDp.setSort("positioner", SortOrder.ASCENDING);
		final List<IColumn<Category, String>> columns = new ArrayList<>();
		columns.add(new LinkColumn<Category, String>(new Model<>("Name"), "name", "name", detailPage,
				"uName", "uName"));
		columns.add(new PropertyColumn<Category, String>(new Model<>("Slug Path"), "slugPath", "slugPath"));
		columns.add(new EnumColumn<Category>(new Model<>("Status"), "status", CategoryPackage.Literals.CATEGORY_STATUS,
				CategoryStatus.ICON_MAPPING));
		columns.add(new PropertyColumn<Category, String>(new Model<>("Namespace"), "nsPrefix", "nsPrefix"));
		columns.add(new PropertyColumn<Category, String>(new Model<>("Position"), "positioner", "positioner"));
		add(new AjaxFallbackDefaultDataTable<>("table", columns, termDp, 20));
	}
	
}
