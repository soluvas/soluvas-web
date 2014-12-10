package org.soluvas.web.bootstrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.pages.AbstractErrorPage;
import org.apache.wicket.request.http.WebResponse;

import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.references.BootstrapJavaScriptReference;
import de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapCssReference;

/**
 * Human-friendly and mobile first {@link AbstractErrorPage}
 * with Bootstrap layout.
 * @author ceefour
 * @see TenantNotFoundRequestListener
 */
@SuppressWarnings("serial")
public class TenantNotFoundPage extends AbstractErrorPage {

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// do not depend on BootstrapSettings, because they will use ThemeProvider, which use custom theme which can be problematic or no bootstrap CSS at all
		response.render(JavaScriptHeaderItem.forReference(BootstrapJavaScriptReference.instance()));
		response.render(CssHeaderItem.forReference(BootstrapCssReference.instance()));
	}

	@Override
	protected void setHeaders(final WebResponse response)
	{
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	public TenantNotFoundPage(Exception ex) {
		super();
		add(new HtmlTag("html", getRequest().getLocale()));
		add(new HeaderResponseContainer("footer-container", "footer-container"));
//		add(new BootstrapBaseBehavior());

		final String serverName = ((HttpServletRequest) getRequest().getContainerRequest()).getServerName();
		add(new Label("serverName", serverName));
		add(new Label("serverName2", serverName));
	}

}
