package org.soluvas.web.site.widget;

import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.data.DisplayAttribute;
import org.soluvas.data.Value;

/**
 * Displays a list of {@link DisplayAttribute} in a &lt;dl&gt;.
 * @author haidar
 */
@SuppressWarnings("serial")
public class DisplayAttributeListPanel extends
		GenericPanel<List<DisplayAttribute>> {

	/**
	 * @param id
	 */
	public DisplayAttributeListPanel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public DisplayAttributeListPanel(String id,
			IModel<List<DisplayAttribute>> model) {
		super(id, model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ListView<DisplayAttribute>("attrValues", getModel()) {
			@Override
			protected void populateItem(ListItem<DisplayAttribute> item) {
				item.setRenderBodyOnly(true);
				item.add(new Label("attrDisplayName", new PropertyModel<>(item.getModel(), "attrDisplayName")));
				item.add(new ValueLabel("value", new PropertyModel<Value<?>>(item.getModel(), "value")));
			}
		});
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("dl");
		super.onComponentTag(tag);
	}
	
}
