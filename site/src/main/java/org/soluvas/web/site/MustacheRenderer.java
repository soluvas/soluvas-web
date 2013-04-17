package org.soluvas.web.site;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.collect.ImmutableMap;

/**
 * Renders a Mustache template, template is provided by templateSupplier.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MustacheRenderer extends WebComponent {

	private static final Logger log = LoggerFactory
			.getLogger(MustacheRenderer.class);
	@SpringBean
	private WebAddress webAddress;
	@SpringBean(name="appManifest")
	private AppManifest appManifest;
	private final IModel<String> templateModel;
	
	public MustacheRenderer(String id, IModel<?> model, IModel<String> templateModel) {
		super(id, model);
		this.templateModel = templateModel;
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		final String template = templateModel.getObject();
		final DefaultMustacheFactory mf = new DefaultMustacheFactory();
		final Mustache mainMustache = mf.compile(new StringReader(template), "main");
		final StringWriter writer = new StringWriter();
		mainMustache.execute(writer, new Object[] { getDefaultModelObject(),
				ImmutableMap.of("id", getId(), "markupId", getMarkupId(),
						"nl2br", new Nl2Br(), "appManifest", appManifest, "webAddress", webAddress) });
		final String body = writer.toString();
		replaceComponentTagBody(markupStream, openTag, body);
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		setVisible( templateModel.getObject() != null );
	}

}
