package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.gmap.GMap;
import org.wicketstuff.gmap.api.GLatLng;
import org.wicketstuff.gmap.api.GMarker;
import org.wicketstuff.gmap.api.GMarkerOptions;
import org.wicketstuff.gmap.api.GPolyline;

/**
 * Renders a {@link org.wicketstuff.gmap.api.GMarker} in latlon using {@link GMap}.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class MarkerMapColumn<T> extends AbstractColumn<T, String> {

	private final String latExpr;
	private final String lonExpr;

	public MarkerMapColumn(IModel<String> displayModel,
						   String latExpr, String lonExpr) {
		super(displayModel);
		this.latExpr = latExpr;
		this.lonExpr = lonExpr;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final Double lat = new PropertyModel<Double>(model, latExpr).getObject();
		final Double lon = new PropertyModel<Double>(model, lonExpr).getObject();
		if (lat != null && lon != null && lat != null && lon != null) {
			final GMap gmap = new GMap(componentId);
			gmap.setPanControlEnabled(false);
			gmap.setScaleControlEnabled(false);
			gmap.setScrollWheelZoomEnabled(false);
			gmap.setZoomControlEnabled(false);
			gmap.setMapTypeControlEnabled(false);
			gmap.setDraggingEnabled(false);
			gmap.setDoubleClickZoomEnabled(false);
			final GLatLng latLng = new GLatLng(lat, lon);
			gmap.setCenter(latLng);

			gmap.addOverlay(new GMarker(new GMarkerOptions(gmap, latLng)));
			gmap.add(new AttributeAppender("style", "width: 16em; height: 8em"));
 			item.add(gmap);
		} else {
			item.add(new EmptyPanel(componentId));
		}
//		item.add(new AttributeAppender("class", "measure text-right"));
	}
}