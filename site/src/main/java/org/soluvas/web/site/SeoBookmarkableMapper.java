package org.soluvas.web.site;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.core.request.mapper.AbstractBookmarkableMapper;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.handler.RedirectRequestHandler;
import org.apache.wicket.request.mapper.info.PageComponentInfo;
import org.apache.wicket.request.mapper.parameter.IPageParametersEncoder;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.mapper.parameter.PageParametersEncoder;
import org.apache.wicket.util.lang.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ceefour
 *
 */
public abstract class SeoBookmarkableMapper extends AbstractBookmarkableMapper {
	
	public static final String LOCALE_PREF_ID_PARAMETER = "localePrefId";
	protected final Logger log = LoggerFactory.getLogger(getClass());
	protected final IPageParametersEncoder pageParametersEncoder = new PageParametersEncoder();
	/**
	 * @todo FIXME: Should use AppManifest's
	 */
	public static final String DEFAULT_LOCALE_PREF_ID = "id";
	
	public static final String DEFAULT_LOCALE_PREF_EN = "en";

	/**
	 * Creates a {@code IRequestHandler} that processes a bookmarkable request.
	 * 
	 * @param pageClass
	 * @param pageParameters
	 * @return a {@code IRequestHandler} capable of processing the bookmarkable request.
	 */
	protected final IRequestHandler processBookmarkable(Class<? extends IRequestablePage> pageClass,
		PageParameters pageParameters, RedirectPolicy redirectPolicy) {
		PageProvider provider = new PageProvider(pageClass, pageParameters);
		provider.setPageSource(getContext());
		return new RenderPageRequestHandler(provider, redirectPolicy);
	}

	@Override
	public final IRequestHandler mapRequest(Request request) {
		try {
			final String userAgent = ((HttpServletRequest) request.getContainerRequest()).getHeader("User-Agent");
			final RedirectPolicy redirectPolicy = userAgent != null && BotUtils.isBot(userAgent) ? RedirectPolicy.NEVER_REDIRECT : RedirectPolicy.AUTO_REDIRECT;
			
			final UrlInfo urlInfo = parseRequest(request);

			// check if the URL is long enough and starts with the proper segments
			if (urlInfo != null)
			{
				PageComponentInfo info = urlInfo.getPageComponentInfo();
				Class<? extends IRequestablePage> pageClass = urlInfo.getPageClass();
				PageParameters pageParameters = urlInfo.getPageParameters();

				if (info == null)
				{
					// if there are is no page instance information
					// then this is a simple bookmarkable URL
					return processBookmarkable(pageClass, pageParameters, redirectPolicy);
				}
				else if (info.getPageInfo().getPageId() != null && info.getComponentInfo() == null)
				{
					// if there is page instance information in the URL but no component and listener
					// interface then this is a hybrid URL - we need to try to reuse existing page
					// instance
					return processHybrid(info.getPageInfo(), pageClass, pageParameters, null);
				}
				else if (info.getComponentInfo() != null)
				{
					// with both page instance and component+listener this is a listener interface URL
					return processListener(info, pageClass, pageParameters);
				}
				else if (info.getPageInfo().getPageId() == null)
				{
					return processBookmarkable(pageClass, pageParameters, redirectPolicy);
				}

			}
			return null;
		} catch (MapperRedirectException e) {
			final String redirectUri = RequestCycle.get()
					.urlFor((Class< org.apache.wicket.Page>) e.getPageProvider().getPageClass(), e.getPageProvider().getPageParameters()).toString();
			log.debug("Redirecting permanently '{}' to canonical URI '{}'", request.getUrl(), redirectUri);
			// SEO: to avoid duplicate content, redirect permanently old URIs to new URIs
			return new RedirectRequestHandler(redirectUri, 301);
		}
	}

	@Override
	protected final boolean pageMustHaveBeenCreatedBookmarkable() {
		return true;
	}

	/**
	 * Encodes the given {@link org.apache.wicket.request.mapper.parameter.PageParameters} to the URL using the given
	 * {@link org.apache.wicket.request.mapper.parameter.IPageParametersEncoder}. The original URL object is unchanged.
	 *
	 * @param url
	 * @param pageParameters
	 * @param encoder
	 * @return URL with encoded parameters
	 */
	@Override
	protected final Url encodePageParameters(Url url, PageParameters pageParameters,
									   final IPageParametersEncoder encoder) {
		Args.notNull(url, "url");
		Args.notNull(encoder, "encoder");

		if (pageParameters == null)
		{
			pageParameters = new PageParameters();
		}

		Url parametersUrl = encoder.encodePageParameters(pageParameters);
		if (parametersUrl != null)
		{
			// copy the url
			url = new Url(url);

			for (String s : parametersUrl.getSegments())
			{
				url.getSegments().add(s);
			}
			for (Url.QueryParameter p : parametersUrl.getQueryParameters())
			{
				url.getQueryParameters().add(p);
			}
		}

		return url;
	}
	
}
