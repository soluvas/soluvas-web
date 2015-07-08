package org.soluvas.web.site;

import java.util.Map;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.google.common.collect.ImmutableMap;

/**
 * Image component that supports URI templating using {@link WebAddress}.
 * @author rio
 */
@SuppressWarnings("serial")
public class WebImage extends WebMarkupContainer {

	private static final Logger log = LoggerFactory.getLogger(WebImage.class);
	
	@SpringBean
	private WebAddress webAddress;

	public WebImage(String id) {
		super(id);
	}
	
	/**
	 * @param id
	 * @param altTitleModel Used for both {@code alt} and {@code title} attributes.
	 */
	public WebImage(String id, IModel<String> altTitleModel) {
		this(id);
		add(new AttributeModifier("alt", altTitleModel));
		add(new AttributeModifier("title", altTitleModel));
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
			
			if (disableCaching()) {
				addAntiCacheParameter(tag);
			}
		} catch (VariableExpansionException | MalformedUriTemplateException e) {
			throw new SiteException(e, "WebImage %'s src invalid URI template or without variables, please use standard img for non-dynamic URIs: %s",
					getPageRelativePath(), srcTemplate);
		}
	}
	
	
	protected boolean disableCaching() {
		return false;
	}
	
	/**
	 * Adds random noise to the url every request to prevent the browser from caching the image.
	 * 
	 */
	protected void addAntiCacheParameter(ComponentTag tag) {
		String url = tag.getAttributes().getString("src");
		url = url + (url.contains("?") ? "&" : "?");
		url = url + "antiCache=" + System.currentTimeMillis();
		tag.put("src", url);
	}
	
	
}
