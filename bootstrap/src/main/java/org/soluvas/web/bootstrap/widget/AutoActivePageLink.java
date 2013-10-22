package org.soluvas.web.bootstrap.widget;

import javax.annotation.Nullable;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;

/**
 * Bootstrap-enhanced {@link BookmarkablePageLink}, that appends
 * {@code class="active"} if it links to the current page.
 * @author ceefour
 */
public class AutoActivePageLink<T extends Page> extends BookmarkablePageLink<T> {

	private static final long serialVersionUID = 1L;

	public <C extends Page> AutoActivePageLink(String id, Class<C> pageClass,
			PageParameters parameters) {
		super(id, pageClass, parameters);
	}

	public <C extends Page> AutoActivePageLink(String id, Class<C> pageClass) {
		super(id, pageClass);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
			@Override @Nullable
			public String getObject() {
				return isActive() ? "active" : null;
			}
		}));
	}
	
	/**
	 * Returns whether the link is active. Requires access to current request's {@link Page}.
	 * @return
	 */
	public boolean isActive() {
		return linksTo(getPage());
	}
	
	

}
