package org.soluvas.web.site.widget;

import javax.annotation.Nullable;

import org.apache.wicket.Page;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * {@link LinkPanel} / {@link LinkColumn} can be used by anything (e.g. name), not just ID.
 * Contains either {@link BookmarkablePageLink} or {@link ExternalLink}.
 *
 * @author rudi
 * @see LinkColumn
 */
@SuppressWarnings("serial")
public class LinkPanel extends GenericPanel<String> {

	private String iconClassNames;

	public LinkPanel(final String componentId,
			final Class<? extends Page> pageClass, final PageParameters params,
			final IModel<String> labelModel) {
		this(componentId, pageClass, params, labelModel, null);
	}
	
	public LinkPanel(final String componentId,
			final Class<? extends Page> pageClass, final PageParameters params,
			final IModel<String> labelModel, @Nullable TagType tagType) {
		super(componentId);
		final BookmarkablePageLink<Page> link = new BookmarkablePageLink<>("link", pageClass, params);
		if (tagType != null) {
			link.add(new TagLabel("label", labelModel, tagType));
		} else {
			link.add(new Label("label", labelModel));
		}
		add(link);
		add(new WebMarkupContainer("lock") {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(!isEnabledInHierarchy());
			}
		});
	}
	
	public LinkPanel(final String componentId,
			final IModel<String> hrefModel, final IModel<String> labelModel, @Nullable TagType tagType) {
		super(componentId);
		final ExternalLink link = new ExternalLink("link", hrefModel);
		if (tagType != null) {
			link.add(new TagLabel("label", labelModel, tagType));
		} else {
			link.add(new Label("label", labelModel));
		}
		add(link);
		add(new WebMarkupContainer("lock") {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(!isEnabledInHierarchy());
			}
		});
	}

	public LinkPanel(final String componentId,
			final IModel<String> hrefModel, final IModel<String> labelModel) {
		this(componentId, hrefModel, labelModel, null);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		final WebMarkupContainer icon = new WebMarkupContainer("icon");
		if (null != iconClassNames) {
			icon.add(new AttributeAppender("class", iconClassNames, " "));
		} else {
			icon.setVisible(false);
		}
		add(icon);
	}

	public LinkPanel setIconType(String classNames) {
		this.iconClassNames = classNames;
		return this;
	}

}