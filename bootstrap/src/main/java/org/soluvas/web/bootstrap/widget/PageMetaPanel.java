package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.web.site.ModelVisibilityBehavior;
import org.soluvas.web.site.pagemeta.PageMeta;

import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;

/**
 * Conditionally renders {@link PageMeta} contents inside {@code <head>} tag,
 * with simple localization support.
 * 
 * <p>Usage:
 * 
 * <pre>
 * &lt;head>
 * 	...
 * 	&lt;wicket:container wicket:id="meta">&lt;/wicket:container>
 * </pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PageMetaPanel extends GenericPanel<PageMeta> {

	public PageMetaPanel(String id, IModel<PageMeta> model) {
		super(id, model);
		setRenderBodyOnly(true);
		final PropertyModel<String> robotsModel = new PropertyModel<String>(model, "robots");
		add(new MetaTag("robots", new Model<>("robots"), robotsModel).add(new ModelVisibilityBehavior(robotsModel)));
	}
	
}
