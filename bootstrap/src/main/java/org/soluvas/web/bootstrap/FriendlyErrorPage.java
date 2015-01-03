package org.soluvas.web.bootstrap;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.pages.InternalErrorPage;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.core.env.Environment;

import com.google.common.base.Throwables;

import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.references.BootstrapJavaScriptReference;
import de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapCssReference;

/**
 * Human-friendly and mobile first {@link InternalErrorPage}
 * with Bootstrap layout.
 * @author ceefour
 * @see FriendlyErrorRequestListener
 */
@SuppressWarnings("serial")
public class FriendlyErrorPage extends InternalErrorPage {

	@Inject
	private Environment env;
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// do not depend on BootstrapSettings, because they will use ThemeProvider, which use custom theme which can be problematic or no bootstrap CSS at all
		response.render(JavaScriptHeaderItem.forReference(BootstrapJavaScriptReference.instance()));
		response.render(CssHeaderItem.forReference(BootstrapCssReference.instance()));
	}
	
	public FriendlyErrorPage(UUID incidentId, Exception ex) {
		super();
		add(new HtmlTag("html", getRequest().getLocale()));
		add(new HeaderResponseContainer("footer-container", "footer-container"));
//		add(new BootstrapBaseBehavior());

		Throwable realCause = ex;
		while (true) {
			if ((realCause instanceof WicketRuntimeException || realCause instanceof InvocationTargetException) && realCause.getCause() != null) {
				realCause = realCause.getCause();
				continue;
			}
			break;
		}
		add(new Label("exceptionName", realCause.getClass().getSimpleName()));
		add(new Label("incidentId2", incidentId));
		add(new Label("incidentId", incidentId));
		final DateTimeZone timeZone = DateTimeZone.forID(env.getProperty("defaultTimeZone", DateTimeZone.getDefault().getID()));
		add(new Label("time", new DateTime(timeZone)));
		final HttpServletRequest httpRequest = (HttpServletRequest) getRequest().getContainerRequest();
		final String servletLocale = httpRequest.getLocale() != null ? httpRequest.getLocale().toLanguageTag() : null;
		final String wicketLocale = getRequest().getLocale() != null ? getRequest().getLocale().toLanguageTag() : null;
		String requestDetails =
				"Auth type: " + httpRequest.getAuthType() + "\n"
						+ "Character encoding: " + httpRequest.getCharacterEncoding() + "\n"
						+ "Content length: " + httpRequest.getContentLength() + "\n" 
						+ "Content type: " + httpRequest.getContentType() + "\n" 
						+ "Context path: " + httpRequest.getContextPath() + "\n" 
						+ "Local address: " + httpRequest.getLocalAddr() + "\n" 
						+ "Local name: " + httpRequest.getLocalName() + "\n" 
						+ "Local port: " + httpRequest.getLocalPort() + "\n" 
						+ "Locale: servlet=" + servletLocale + ", wicket=" + wicketLocale + "\n" 
						+ "Method: " + httpRequest.getMethod() + "\n" 
						+ "Path info: " + httpRequest.getPathInfo() + "\n" 
						+ "Path translated: " + httpRequest.getPathTranslated() + "\n" 
						+ "Protocol: " + httpRequest.getProtocol() + "\n" 
						+ "Query string: " + httpRequest.getQueryString() + "\n" 
						+ "Remote address: " + httpRequest.getRemoteAddr() + "\n" 
						+ "Remote host: " + httpRequest.getRemoteHost() + "\n" 
						+ "Remote port: " + httpRequest.getRemotePort() + "\n" 
						+ "Remote user: " + httpRequest.getRemoteUser() + "\n" 
						+ "Requested session ID: " + httpRequest.getRequestedSessionId() + "\n" 
						+ "Request URI: " + httpRequest.getRequestURI() + "\n" 
						+ "Request URL: " + httpRequest.getRequestURL() + "\n" 
						+ "Scheme: " + httpRequest.getScheme() + "\n" 
						+ "Server name: " + httpRequest.getServerName() + "\n" 
						+ "Server port: " + httpRequest.getServerPort() + "\n" 
						+ "Servlet path: " + httpRequest.getServletPath() + "\n" 
						+ "User principal: " + httpRequest.getUserPrincipal() + "\n";
		add(new Label("request", requestDetails));
		
		String cookies = "";
		if (httpRequest.getCookies() != null) {
			for (final Cookie cookie : httpRequest.getCookies()) {
				cookies += cookie.getName() + ": " + cookie.getValue() + "; maxAge=" + cookie.getMaxAge()
						+ "; domain=" + cookie.getDomain() + "; path=" + cookie.getPath() + "; version=" + cookie.getVersion()
						+ "; secure=" + cookie.getSecure() + "; comment=" + cookie.getComment() + "\n";
			}
		}
		add(new Label("cookies", cookies));
		
		String headers = "";
		for (final String headerName : Collections.list(httpRequest.getHeaderNames())) {
			headers += headerName + ": " + httpRequest.getHeader(headerName) + "\n";
		}
		add(new Label("headers", headers));
		
		add(new Label("stackTrace", Throwables.getStackTraceAsString(ex)));
	}

}
