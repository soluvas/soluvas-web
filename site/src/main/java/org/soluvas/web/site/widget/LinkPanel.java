package org.soluvas.web.site.widget;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@SuppressWarnings("serial")
public class LinkPanel<T, S> extends Panel {

	public LinkPanel(final String componentId,
			final Class<? extends Page> pageClass, final PageParameters params,
			final IModel<String> labelModel) {
		super(componentId);
		final BookmarkablePageLink<Page> link = new BookmarkablePageLink<>("link", pageClass, params);
		link.add(new TagLabel("label", labelModel, TagType.TT));
		add(link);
	}
	
}