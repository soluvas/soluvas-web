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
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(Bootstrap3Wysihtml5v2.BOOTSTRAP3_WYSIHTML5_MIN_CSS);
		response.render(Bootstrap3Wysihtml5v2.WYSIWYG_COLOR_CSS);
		response.render(Bootstrap3Wysihtml5v2.BOOTSTRAP3_WYSIHTML5_MIN);
		response.render(Bootstrap3Wysihtml5v2.BOOTSTRAP3_WYSIHTML5_ALL_MIN);
		
		response.render(OnLoadHeaderItem.forScript(
				"$('#" + getMarkupId() + "').wysihtml5({"
						+ "\"image\": false,"
						+ "\"color\": true,"
						+"parser: function(html) { return html;},"		
						+ "\"stylesheets\": [\"" + urlFor(Bootstrap3Wysihtml5v2.WYSIWYG_COLOR_CSS.getReference(), null) + "\"]"
				+ "})"));
		
		
	}

}
