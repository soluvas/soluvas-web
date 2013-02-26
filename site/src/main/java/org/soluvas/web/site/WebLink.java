package org.soluvas.web.site;

import java.util.Map;

import javax.inject.Inject;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.util.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.inject.Supplied;

import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.impl.ExpressionParseException;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * {@link Link} component that supports URI templating using {@link WebAddress}.
 * @author rio
 */
@SuppressWarnings("serial")
public class WebLink extends ExternalLink {

	private static final Logger log = LoggerFactory.getLogger(WebLink.class);
	
	@Inject @Supplied
	private WebAddress webAddress;

	private final IModel<Map<String, Object>> params;
	
	public WebLink(String id) {
		super(id, "");
		this.params = new MapModel<String, Object>(ImmutableMap.<String, Object>of());
	}
	
	public WebLink(String id, IModel<Map<String, Object>> params) {
		super(id, "");
		this.params = params;
	}
	
	public WebLink(String id, final String paramKey, final IModel<?> paramValue) {
		this(id, new LoadableDetachableModel<Map<String, Object>>() {
			@Override
			protected Map<String, Object> load() {
				return ImmutableMap.<String, Object>of(paramKey, paramValue.getObject());
			}
		});
	}
	
	public WebLink(String id, String paramKey, Object paramValue) {
		this(id, new MapModel<String, Object>(ImmutableMap.of(paramKey, paramValue)));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		final String hrefTemplate = getMarkupAttributes().getString("href");
		final Map<String, Object> vars = Maps.newHashMap();
		vars.put("basePath", webAddress.getBasePath());
		vars.put("imagesUri", webAddress.getImagesUri());
		vars.put("skinUri", webAddress.getSkinUri() );
		vars.putAll(params.getObject());
		log.trace("Expanding {} using {}", getPageRelativePath(), hrefTemplate);
		try {
			final String href = UriTemplate.fromTemplate(hrefTemplate).expand(vars);
			tag.put("href", href);
		} catch (ExpressionParseException e) {
			throw new SiteException(e, "WebLink %'s href is invalid URI template or without variables, please use standard link for non-dynamic URIs: %s",
					getPageRelativePath(), hrefTemplate);
		}
	}
	
}
