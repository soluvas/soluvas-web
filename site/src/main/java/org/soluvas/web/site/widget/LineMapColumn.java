package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.web.site.widget.MeasureLabel;
import org.wicketstuff.gmap.GMap;
import org.wicketstuff.gmap.api.GLatLng;
import org.wicketstuff.gmap.api.GPolyline;

import javax.annotation.Nullable;
import javax.measure.unit.Unit;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * Renders a line between two latlons using {@link org.wicketstuff.gmap.GMap}.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class LineMapColumn<T> extends AbstractColumn<T, String> {

	private final String startLatExpr;
	private final String startLonExpr;
	private final String finishLatExpr;
	private final String finishLonExpr;

	public LineMapColumn(IModel<String> displayModel,
						 String startLatExpr, String startLonExpr,
						 String finishLatExpr, String finishLonExpr) {
		super(displayModel);
		this.startLatExpr = startLatExpr;
		this.startLonExpr = startLonExpr;
		this.finishLatExpr = finishLatExpr;
		this.finishLonExpr = finishLonExpr;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final Double startLat = new PropertyModel<Double>(model, startLatExpr).getObject();
		final Double startLon = new PropertyModel<Double>(model, startLonExpr).getObject();
		final Double finishLat = new PropertyModel<Double>(model, finishLatExpr).getObject();
		final Double finishLon = new PropertyModel<Double>(model, finishLonExpr).getObject();
		if (startLat != null && startLon != null && finishLat != null && finishLon != null) {
			final GMap gmap = new GMap(componentId);
			gmap.setPanControlEnabled(false);
			gmap.setScaleControlEnabled(false);
			gmap.setScrollWheelZoomEnabled(false);
			gmap.setZoomControlEnabled(false);
			gmap.setMapTypeControlEnabled(false);
			gmap.setDraggingEnabled(false);
			gmap.setDoubleClickZoomEnabled(false);
			final GLatLng startLatLng = new GLatLng(startLat, startLon);
			final GLatLng finishLatLng = new GLatLng(finishLat, finishLon);
			final GLatLng centerLatLng = new GLatLng((startLat + finishLat) / 2d,
					(startLon + finishLon) / 2d);
			gmap.setCenter(centerLatLng);

			gmap.addOverlay(new GPolyline("red", 4, 0.8f, startLatLng, finishLatLng));
			gmap.add(new AttributeAppender("style", "width: 16em; height: 8em"));
 			item.add(gmap);
		} else {
			item.add(new EmptyPanel(componentId));
		}
//		item.add(new AttributeAppender("class", "measure text-right"));
	}
}