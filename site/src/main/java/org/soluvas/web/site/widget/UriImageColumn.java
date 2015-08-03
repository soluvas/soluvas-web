package org.soluvas.web.site.widget;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.UrlResourceReference;

/**
 * Renders the a relative image URI into {@link IColumn} containing {@link Image} with {@link UrlResourceReference}.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class UriImageColumn<T> extends PropertyColumn<T, String> {

	private int height;
	private String cssClass = "img";

	/**
	 *
	 * @param displayModel
	 * @param propertyExpression Expression for site base URI-relative image URI.
	 * @param height Height of image in pixels, all will be resized to this height.
	 */
	public UriImageColumn(IModel<String> displayModel, String propertyExpression, int height) {
		super(displayModel, propertyExpression);
		this.height = height;
	}

	public UriImageColumn<T> cssClass(String cssClass) {
		this.cssClass = cssClass;
		return this;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		item.add(new UriImagePanel(componentId, (IModel) getDataModel(model), cssClass, height));
	}

}