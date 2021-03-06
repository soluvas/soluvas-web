package org.soluvas.web.site.widget;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.data.DisplayAttribute;
import org.soluvas.data.Term2;
import org.soluvas.data.entity.TermValue;
import org.soluvas.mongo.MongoTermRepository;

/**
 * Displays a list of {@link DisplayAttribute} in a &lt;dl&gt;.
 * @author rudi
 */
@SuppressWarnings("serial")
public class DisplayAttributeListPanel extends GenericPanel<List<DisplayAttribute>> {
	
	@Inject
	private MongoTermRepository termRepo;

	private final String curLanguageTag;

	/**
	 * @param id
	 */
	public DisplayAttributeListPanel(String id, String curLanguageTag) {
		super(id);
		this.curLanguageTag = curLanguageTag;
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
	public DisplayAttributeListPanel(String id, IModel<List<DisplayAttribute>> model,
			String curLanguageTag) {
		super(id, model);
		this.curLanguageTag = curLanguageTag;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ListView<DisplayAttribute>("attrValues", getModel()) {
			@Override
			protected void populateItem(ListItem<DisplayAttribute> displayAttItem) {
				displayAttItem.setRenderBodyOnly(true);
				displayAttItem.add(new Label("attrDisplayName", displayAttItem.getModelObject().getPropertyDefinition().getEffectiveName(curLanguageTag)));
				displayAttItem.add( new ListView<String>("valueList", new PropertyModel<List<String>>(displayAttItem.getModel(), "values")) {
					@Override
					protected void populateItem(ListItem<String> valueItem) {
						@Nullable Term2 term2 = termRepo.findOne(valueItem.getModelObject());
						if (term2 != null) {
							final TermValue termValue = new TermValue();
							termValue.copyFromMongo(term2);
							valueItem.add(new ValueLabel2("value", termValue));
						} else {
							valueItem.add(new Label("value", valueItem.getModel()));
						}
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
