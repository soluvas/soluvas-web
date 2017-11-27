package org.soluvas.web.site;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupElement;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.locale.FormatCurrency;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

/**
 * Renders a Mustache template, template is contained within HTML markup itself.
 * Cannot cache due to Wicket serialization mechanism.
 * <p>Built-in scopes: id, markupId, nl2br, appManifest, webAddress.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MustacheMarkupContainer extends WebMarkupContainer {

	private static final Logger log = LoggerFactory.getLogger(MustacheMarkupContainer.class);
	@SpringBean
	private WebAddress webAddress;
	@SpringBean(name="appManifest")
	private AppManifest appManifest;
	
	public MustacheMarkupContainer(String id, IModel<?> model) {
		super(id, model);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		log.trace("Compiling Mustache for {}", getPageRelativePath());
		markupStream.setCurrentIndex(1);
		String template = "";
		MarkupElement currentElement = markupStream.get(); //getMarkupFragment().toString(true);
		while (markupStream.hasMore()) {
			if (currentElement != null) {
				if (currentElement.closes(openTag)) {
					// skip closing tag for this component
				} else {
					template += currentElement.toString();
				}
			}
			currentElement = markupStream.next();
		}
		log.trace("Mustache template for {}: {}", getPageRelativePath(), template);
		
		try {
			final MustacheFactory mf = new DefaultMustacheFactory();
			final Mustache mainMustache = mf.compile(new StringReader(template), "main");
			
			final StringWriter writer = new StringWriter();
			final Map<String, Object> mapper = new HashMap<>();
			mapper.put("id", getId());
			mapper.put("markupId", getMarkupId());
			mapper.put("nl2br", new Nl2Br());
			mapper.put("appManifest", appManifest);
			mapper.put("webAddress", webAddress);
			mapper.put( "formatCurrency", new FormatCurrency(appManifest.getDefaultLocale(), appManifest.getDefaultCurrency()) );
			mainMustache.execute(writer, new Object[] { getDefaultModelObject(), mapper });
			final String body = writer.toString();
			replaceComponentTagBody(markupStream, openTag, body);
		} catch (Throwable e) {
			throw new SiteException(e, "Cannot render mustache for %s: %s",
					getPageRelativePath(), template);
		}
	}
	
}
