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
import org.soluvas.data.DisplayAttribute2;
import org.soluvas.data.Value;

/**
 * Displays a list of {@link DisplayAttribute} in a &lt;dl&gt;.
 * @author haidar
 */
@SuppressWarnings("serial")
public class DisplayAttributeListPanel2 extends GenericPanel<List<DisplayAttribute2>> {

	/**
	 * @param id
	 */
	public DisplayAttributeListPanel2(String id) {
		super(id);
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		setVisible(getModel().getObject() != null && !getModelObject().isEmpty());
	}

	/**
	 * @param id
	 * @param model
	 */
	public DisplayAttributeListPanel2(String id,
			IModel<List<DisplayAttribute2>> model) {
		super(id, model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ListView<DisplayAttribute2>("attrValues", getModel()) {
			@Override
			protected void populateItem(ListItem<DisplayAttribute2> displayAttItem) {
				displayAttItem.setRenderBodyOnly(true);
				displayAttItem.add(new Label("attrDisplayName", new PropertyModel<>(displayAttItem.getModel(), "attrDisplayName")));
				displayAttItem.add( new ListView<Value<?>>("valueList", new PropertyModel<List<Value<?>>>(displayAttItem.getModel(), "values")) {
					@Override
					protected void populateItem(ListItem<Value<?>> valueItem) {
						valueItem.add(new ValueLabel("value", valueItem.getModel()));
					}
				} );
			}
		});
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("dl");
		super.onComponentTag(tag);
	}
	
}
