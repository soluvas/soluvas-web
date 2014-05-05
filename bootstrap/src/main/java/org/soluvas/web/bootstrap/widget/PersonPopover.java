package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo;
import org.soluvas.image.ImageManager;
import org.soluvas.web.site.widget.IconImageContainer;

import de.agilecoders.wicket.core.markup.html.bootstrap.components.PopoverBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.PopoverConfig;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipConfig.Placement;

/**
 * Renders {@link PersonInfo} with {@link Gender} image.
 * @author ceefour
 */
public class PersonPopover extends GenericPanel<PersonInfo> {
	
	@SpringBean
	private ImageManager imageMgr;
	
	public PersonPopover(String id, IModel<PersonInfo> model) {
		super(id, model);
	}

	public PersonPopover(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("name", new PropertyModel<String>(getModel(), "name")));
		// Hover trigger doesn't work properly because even if going to popover content,
		// it will still get hidden
		final PopoverConfig config = new PopoverConfig().withAnimation(true)
				.withPlacement(Placement.bottom)
				.withHtml(true);//.withHoverTrigger().withDelay(Duration.milliseconds(500));
		add(new IconImageContainer("icon", getModel()));
		final IModel<String> labelModel = new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				final PersonInfo person = getModelObject();
				return person != null && person.getName() != null ? "<strong>" + Strings.escapeMarkup(person.getName()) + "</strong>" : "";
			}
		};
		if (getModel().getObject() != null) {
			final PersonPopoverBody body = new PersonPopoverBody(ComponentRenderer.COMP_ID, getModel());
			final IModel<String> bodyModel = new AbstractReadOnlyModel<String>() {
				@Override
				public String getObject() {
					final PersonInfo person = getModelObject();
					if (person != null) {
						return ComponentRenderer.renderComponent(body).toString();
					} else {
						return null;
					}
				}
			};
			add(new PopoverBehavior(labelModel, bodyModel, config) {
//			@Override
//			protected CharSequence createInitializerScript(Component component,
//					AbstractConfig config) {
//				return $(component).chain("popover", config)
//						// Trigger for the popover
//						.chain(EachJqueryFunction.each(new JavaScriptInlineFunction(
//								"var $this = $(this);" +
//								"$this.on('hover', function() {" +
//								"  var popover = $this.data('popover');" +
//								"  var shown = popover && popover.tip().is(':visible');" +
//								"  if (shown) return;        /* Avoids flashing */" +
//								"  $this.popover('show');" +
//								"});")))
//						.get();
//			}
			});
		}
		add(new AttributeAppender("style", "cursor: pointer;"));
	}

	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("div");
		super.onComponentTag(tag);
	}
}
