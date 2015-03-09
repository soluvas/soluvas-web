package org.soluvas.web.bootstrap.bootstrap3wysihtml5;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;

/**
 * @author anton
 *
 */
@SuppressWarnings("serial")
public class WysihtmlTextArea extends TextArea<String> {

	/**
	 * @param id
	 */
	public WysihtmlTextArea(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public WysihtmlTextArea(String id, IModel<String> model) {
		super(id, model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new CssClassNameAppender("wysihtml5"));
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		// bootstrap-wysihtml5 is activated by advanced-form.js
		response.render(Bootstrap3Wysihtml5.asHeaderItem());
		response.render(JavaScriptHeaderItem.forScript(
				"$(function() { $('.wysihtml5').wysihtml5({color: true}); });", "wysihtml5-activator"));
		
//		//wysihtml5 start
//		// Bippo hack to workaround missing CSS since JavaScript doesn't know the (WicketResource) location of the CSS file
//		$('.wysihtml5').wysihtml5({color: true,
//			stylesheets: ['/wicket/resource/id.co.bippo.web.mall.BackendPage/assets/bootstrap-wysihtml5/wysiwyg-color.css']});
//		//wysihtml5 end
	}

}
