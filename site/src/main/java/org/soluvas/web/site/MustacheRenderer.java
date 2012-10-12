package org.soluvas.web.site;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.base.Supplier;

/**
 * Renders a Mustache template, template is provided by templateSupplier.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MustacheRenderer extends WebComponent {

	private Supplier<String> templateSupplier;
	
	public MustacheRenderer(String id, IModel<?> model, Supplier<String> templateSupplier) {
		super(id, model);
		this.templateSupplier = templateSupplier;
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		String template = templateSupplier.get();
		DefaultMustacheFactory mf = new DefaultMustacheFactory();
		Mustache mainMustache = mf.compile(new StringReader(template), "main");
		final StringWriter writer = new StringWriter();
		mainMustache.execute(writer, getDefaultModelObject());
		final String body = writer.toString();
		replaceComponentTagBody(markupStream, openTag, body);
	}

}
