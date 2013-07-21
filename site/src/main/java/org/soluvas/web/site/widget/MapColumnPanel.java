package org.soluvas.web.site.widget;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

import com.google.common.collect.ImmutableList;

/**
 *
 * @author ceefour
 */
public class MapColumnPanel extends GenericPanel<Map<String, Object>> {

	private static final long serialVersionUID = 1L;

	public MapColumnPanel(String id, final IModel<Map<String, Object>> model) {
		super(id, model);
		final IModel<List<Entry<String, Object>>> entriesModel = new LoadableDetachableModel<List<Map.Entry<String, Object>>>() {
			@Override
			protected List<Entry<String, Object>> load() {
				return ImmutableList.copyOf(model.getObject().entrySet());
			}
		};
		add(new ListView<Map.Entry<String, Object>>("entries", entriesModel) {
			@Override
			protected void populateItem(ListItem<Map.Entry<String, Object>> item) {
				item.add(new Label("key", new PropertyModel<>(item.getModel(), "key")));
				item.add(new Label("value", new PropertyModel<>(item.getModel(), "value")));
			}
		});
	}
	
}
