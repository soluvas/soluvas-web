package org.soluvas.web.site;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;

/**
 * Renders a Mustache template using mustache-java on the server side,
 * and a precompiled Handlebars template on the client side.
 * A Backbone View and Backbone Model need to also be provided.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class HandlebarsRenderer extends WebComponent {

	private transient Logger log = LoggerFactory.getLogger(HandlebarsRenderer.class);
	private Class<? extends Component> templateComponent;
	private Mustache mainMustache;
	private String tagName;
	private String modelClassName;
	private String modelName;
	private String viewName;
	private String viewId;
	private String templatePath;
	private String templateName;
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @param templateName In the form of fully classified class name of the Wicket component,
	 * 		e.g. <tt>org.soluvas.web.login.LoginForm</tt>. Only the 'full' variant is used. 
	 */
	public HandlebarsRenderer(String id, IModel<?> model, Class<? extends Component> templateComponent,
			String tagName, String styleClasses) {
		super(id, model);
		this.templateComponent = templateComponent;
		this.tagName = tagName;
		this.modelClassName = templateComponent.getSimpleName() + "Data";
		this.modelName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelClassName);
		this.viewName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, templateComponent.getSimpleName());
		this.viewId = viewName;
		this.templatePath = templateComponent.getPackage().getName().replace('.', '/') + "/";
		this.templateName = templateComponent.getName();
		add(new AttributeModifier("class", styleClasses));
		setMarkupId(viewId);
		setOutputMarkupId(true);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName(tagName);
		super.onComponentTag(tag);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		// Compile the template only if not already compiled
		if (mainMustache == null) {
			final String templateResourcePath = "/templates_web/" + templateName + ".mustache";
			log.debug("Compiling Mustache for {} from {}", getId(), templateResourcePath);
			DefaultMustacheFactory mf = new DefaultMustacheFactory();
			mainMustache = mf.compile(new InputStreamReader( templateComponent.getResourceAsStream(templateResourcePath) ), "main");
		}
		final StringWriter writer = new StringWriter();
		mainMustache.execute(writer, getDefaultModelObject());
		String body = writer.toString() + "\n";

		URL url = HandlebarsRenderer.class.getResource("instantiate_model.stg");
		Preconditions.checkNotNull(url, "Cannot find instantiate_model.stg");
		STGroupFile stg = new STGroupFile(url, "UTF-8", '~', '~');
		
		// Define model
		ST defineModel = stg.getInstanceOf("defineModel");
		defineModel.add("modelClassName", modelClassName);
		String defineModelJs = defineModel.render(80);
		body += defineModelJs + "\n";
		
		// Define view
		ST defineView = stg.getInstanceOf("defineView");
		defineView.add("modelClassName", modelClassName);
		defineView.add("viewClassName", templateComponent.getSimpleName());
		String defineViewJs = defineView.render(80);
		body += defineViewJs + "\n";
		
		// Instantiate model
		ST instantiateModel = stg.getInstanceOf("instantiateModel");
		instantiateModel.add("modelName", modelName);
		instantiateModel.add("modelClassName", modelClassName);
		instantiateModel.add("modelData", JsonUtils.asJson(getDefaultModelObject()));
		String instantiateModelJs = instantiateModel.render(80);
		body += instantiateModelJs + "\n";
		
		// Instantiate view
		ST instantiateView = stg.getInstanceOf("instantiateViewPrecompiled");
		instantiateView.add("viewName", viewName);
		instantiateView.add("viewClassName", templateComponent.getSimpleName());
		instantiateView.add("viewId", viewId);
		instantiateView.add("modelName", modelName);
		instantiateView.add("templatePath", templatePath);
		instantiateView.add("templateName", templateName);
		String instantiateViewJs = instantiateView.render(80);
		body += instantiateViewJs + "\n";
		
		replaceComponentTagBody(markupStream, openTag, body);
	}

}
