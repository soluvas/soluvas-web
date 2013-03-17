package org.soluvas.web.site;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.common.collect.ImmutableMap;

/**
 * Renders a Mustache template, template is contained within the panel HTML markup.
 * Cannot cache due to Wicket serialization mechanism.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MustachePanel extends Panel {

	private static final Logger log = LoggerFactory.getLogger(MustachePanel.class);
	
	public MustachePanel(String id, IModel<?> model) {
		super(id, model);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		log.debug("Compiling Mustache for {}", getPageRelativePath());
		final String template = getMarkup().toString(true);
		final MustacheFactory mf = new DefaultMustacheFactory();
		final Mustache mainMustache = mf.compile(new StringReader(template), "main");
		
		final StringWriter writer = new StringWriter();
		mainMustache.execute(writer, new Object[] { getDefaultModelObject(),
				ImmutableMap.of("nl2br", new Nl2Br()) });
		final String body = writer.toString();
		replaceComponentTagBody(markupStream, openTag, body);
	}

}
