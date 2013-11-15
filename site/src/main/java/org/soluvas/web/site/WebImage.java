package org.soluvas.web.site;

import java.util.Map;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;

import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.impl.ExpressionParseException;
import com.google.common.collect.ImmutableMap;

/**
 * Image component that supports URI templating using {@link WebAddress}.
 * @author rio
 */
public class WebImage extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(WebImage.class);
	
	@SpringBean
	private WebAddress webAddress;
	
	public WebImage(String id) {
		super(id);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		final String srcTemplate = getMarkupAttributes().getString("src");
		final Map<String, Object> vars = ImmutableMap.<String, Object>of(
				"imagesUri", webAddress.getImagesUri(), "skinUri", webAddress.getSkinUri());
		log.trace("Expanding {} using {}", getPageRelativePath(), srcTemplate);
		try {
			final String src = UriTemplate.fromTemplate(srcTemplate).expand(vars);
			tag.put("src", src);
		} catch (ExpressionParseException e) {
			throw new SiteException(e, "WebImage %'s src invalid URI template or without variables, please use standard img for non-dynamic URIs: %s",
					getPageRelativePath(), srcTemplate);
		}
	}
	
}
