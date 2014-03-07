package org.soluvas.web.site;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;

/**
 * A hybrid container which renders Mustache markup as HTML,
 * but also generates JavaScript sources conforming to Backbone API.
 * This is the debug variant, which actually outputs several code
 * blocks. The working variant requires a mechanism to provide the generated
 * JavaScript to the browser on separate render:
 * 
 * 1. <strong>pre-generated</strong> : this requires a separate build step that
 *    parses (Wicket?) Mustache markup container with sufficient metadata
 *    and generates JavaScript files to some source folder
 * 2. <strong>dynamically generated</strong> : some kind of content repository service
 *    is required, so the component can publish the generated JavaScript there.
 *    The content then needs to be served to the browser using JAX-RS.
 * 3. <strong>inline</strong> : useful for testing. the generated JavaScript
 *    is rendered as <tt>script</tt> tags, which works but not bandwidth-efficient.
 *    
 * The generated JS are :
 * 1. template JS -- this can (and should) be pre-generated
 * 2. Backbone View implementation JS -- this can (and should) be pre-generated
 * 3. instantiate the Backbone View with a model
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class DebugMustacheBackboneContainer extends WebComponent {

	private static final Logger log = LoggerFactory.getLogger(DebugMustacheBackboneContainer.class);
	private Mustache mainMustache;
	private final String modelPath = "bippo/product/";
	private final String backboneModelClassName = "Product";
	private final String templatePath = "bippo/product/";
	private final String templateModule = "Product";
	private final String backboneViewName = "SomeView";
	
	public DebugMustacheBackboneContainer(String id, IModel<?> model) {
		super(id, model);
	}
	
	protected String getJsTemplateName() {
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, backboneViewName) + "Full";
	}
	
	protected String renderTemplateJs(MarkupStream markupStream) {
		String template = markupStream.get().toString();
		return "var " + getJsTemplateName() + " = " + Strings.replaceAll(JSONObject.quote(template), "\n", "\\\n") + ";\n";
	}
	
	protected String renderViewJs(MarkupStream markupStream, ComponentTag openTag) {
		String template = markupStream.get().toString();
		URL url = DebugMustacheBackboneContainer.class.getResource("backbone_view.stg");
		Preconditions.checkNotNull(url, "Cannot find backbone_view.stg");
		STGroupFile stg = new STGroupFile(url, "UTF-8", '~', '~');
		ST st = stg.getInstanceOf("backbone_view");
		st.add("modelPath", modelPath);
		st.add("backboneModelClassName", backboneModelClassName);
		st.add("backboneViewName", backboneViewName);
		st.add("tagName", openTag.getName());
		st.add("templatePath", templatePath);
		st.add("templateModule", templateModule);
		st.add("templateName", getJsTemplateName());
		String js = st.render(80);
		return js;
//		return "var " + backboneViewName + " = Backbone.View.extend({});";
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		// Compile the template only if not already compiled
		if (mainMustache == null) {
			log.debug("Compiling Mustache for {}", getId());
			String template = markupStream.get().toString();
			DefaultMustacheFactory mf = new DefaultMustacheFactory();
			mainMustache = mf.compile(new StringReader(template), "main");
		}
		
		final StringWriter writer = new StringWriter();
		mainMustache.execute(writer, getDefaultModelObject());
		final String htmlBody = writer.toString();
		
		String body = "<p>HTML:</p>";
		body += "<pre>" + Strings.escapeMarkup(htmlBody) + "</pre>";
		
		body += "<p>Template JS:</p><pre>" + Strings.escapeMarkup(renderTemplateJs(markupStream)) + "</pre>";
		body += "<p>View JS:</p><pre>" + Strings.escapeMarkup(renderViewJs(markupStream, openTag)) + "</pre>";
		
		replaceComponentTagBody(markupStream, openTag, body);
	}

}
