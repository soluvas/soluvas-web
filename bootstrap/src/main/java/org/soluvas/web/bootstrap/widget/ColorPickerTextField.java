package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Bootstrap ColorPicker from http://www.eyecon.ro/bootstrap-colorpicker/
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ColorPickerTextField extends TextField<String> {

	private static JavaScriptResourceReference colorpickerJs = new JavaScriptResourceReference(
			ColorPickerTextField.class, "bootstrap-colorpicker.js");
	private static CssResourceReference colorpickerCss = new CssResourceReference(
			ColorPickerTextField.class, "colorpicker.css");
	
	/**
	 * @param id
	 */
	public ColorPickerTextField(String id) {
		super(id, String.class);
	}

	/**
	 * @param id
	 * @param model
	 */
	public ColorPickerTextField(String id, IModel<String> model) {
		super(id, model, String.class);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("bootstrap-colorpicker"), " "));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(colorpickerCss));
		response.render(JavaScriptHeaderItem.forReference(colorpickerJs));
		response.render(JavaScriptHeaderItem.forScript("$(document).ready(function() {" +
				"$('.bootstrap-colorpicker').colorpicker();" +
			"});",
			"bootstrap-colorpicker"));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
	}

}
