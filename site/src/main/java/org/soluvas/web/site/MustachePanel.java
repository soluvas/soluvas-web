package org.soluvas.web.site;

import java.io.StringWriter;

import org.apache.commons.io.input.CharSequenceReader;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.common.collect.ImmutableMap;

/**
 * Renders a Mustache template, template is contained within the panel HTML markup.
 * Cannot cache due to Wicket serialization mechanism.
 * 
 * <p>Built-in scopes: id, markupId, nl2br, appManifest, webAddress.
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MustachePanel extends Panel {

	private static final Logger log = LoggerFactory.getLogger(MustachePanel.class);
	@SpringBean(name="webAddress")
	private WebAddress webAddress;
	@SpringBean(name="appManifest")
	private AppManifest appManifest;
	
	public MustachePanel(String id, IModel<?> model) {
		super(id, model);
		add(new AbstractTransformerBehavior() {
			@Override
			public CharSequence transform(Component component, CharSequence output)
					throws Exception {
				final CharSequence template = output;
				log.debug("Compiling Mustache for {}: {}", getPageRelativePath(), template);
				final MustacheFactory mf = new DefaultMustacheFactory();
				final Mustache mainMustache = mf.compile(new CharSequenceReader(template), "main");
				
				final StringWriter writer = new StringWriter();
				mainMustache.execute(writer, new Object[] { getDefaultModelObject(),
						ImmutableMap.of("id", getId(), "markupId", getMarkupId(),
								"nl2br", new Nl2Br(), "appManifest", appManifest, "webAddress", webAddress) });
				final String body = writer.toString();
				return body;
			}
		});
	}
	
	@Override
	protected void onRender() {
		super.onRender();
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		super.onComponentTagBody(markupStream, openTag);
	}

}
