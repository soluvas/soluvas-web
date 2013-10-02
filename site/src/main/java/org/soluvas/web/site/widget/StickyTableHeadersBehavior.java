package org.soluvas.web.site.widget;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.resource.CssResourceReference;

/**
 * Uses {@link StickyTableHeadersJavaScriptReference} + {@code stickytableheaders.css} (workaround for common Bootstrap table styling).
 * Works even after AJAX render (using JavaScript {@code setTimeout()} as workaround).
 * @author ceefour
 */
public class StickyTableHeadersBehavior extends Behavior {

	private static final long serialVersionUID = 1L;
	private static final CssResourceReference CSS_REFERENCE = new CssResourceReference(StickyTableHeadersBehavior.class, "stickytableheaders.css");
	
	@Override
	public void bind(Component component) {
		super.bind(component);
		component.setOutputMarkupId(true);
	}
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.render(CssHeaderItem.forReference(CSS_REFERENCE));
		response.render(JavaScriptHeaderItem.forReference(StickyTableHeadersJavaScriptReference.INSTANCE));
	}

	@Override
	public void afterRender(Component component) {
		super.afterRender(component);
		final Response response = component.getResponse();
		// setTimeout is required for it to work after AJAX render
		response.write("<script>setTimeout(function() { $('#" + component.getMarkupId() + "').stickyTableHeaders(); }, 0);</script>\n");
	}
	
}
