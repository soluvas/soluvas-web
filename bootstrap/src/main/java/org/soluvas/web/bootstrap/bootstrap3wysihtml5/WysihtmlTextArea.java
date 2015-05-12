package org.soluvas.web.bootstrap.bootstrap3wysihtml5;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.soluvas.web.bootstrap.bootstrap3wysihtml5v2.Bootstrap3Wysihtml5v2;

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
		setOutputMarkupId(true);
		add(new CssClassNameAppender("wysihtml5"));
	}
	
//	@Override
//    public void onEvent(IEvent<?> event) {
//		super.onEvent(event);
//
//		if (event.getPayload() instanceof AjaxRequestTarget) {
//		    final AjaxRequestTarget target = (AjaxRequestTarget) event.getPayload();
//		    if (target.getComponents().contains(this)) {
//		    	target.appendJavaScript("$('#" + getMarkupId() + "').wysihtml5({color: true});");
//		    }
//		}
//    }
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		//v 2
		response.render(Bootstrap3Wysihtml5v2.CSS_BOOTSTRAP3_WYSIHTML5);
		response.render(Bootstrap3Wysihtml5v2.CSS_BOOTSTRAP3_WYSIHTML5_EDITOR);
		response.render(Bootstrap3Wysihtml5v2.WYSIHTML5X_TOOLBAR_MIN);
		response.render(Bootstrap3Wysihtml5v2.BOOTSTRAP3_WYSIHTML5_MIN);
		
		response.render(OnLoadHeaderItem.forScript(
				"$('#" + getMarkupId() + "').wysihtml5();"));
		
		// bootstrap-wysihtml5 is activated by advanced-form.js
//		response.render(Bootstrap3Wysihtml5.asHeaderItem());
//		response.render(OnLoadHeaderItem.forScript(
//				"$('#" + getMarkupId() + "').wysihtml5({color: true});"));
		
//		//wysihtml5 start
//		// Bippo hack to workaround missing CSS since JavaScript doesn't know the (WicketResource) location of the CSS file
//		$('.wysihtml5').wysihtml5({color: true,
//			stylesheets: ['/wicket/resource/id.co.bippo.web.mall.BackendPage/assets/bootstrap-wysihtml5/wysiwyg-color.css']});
//		//wysihtml5 end
	}

}
