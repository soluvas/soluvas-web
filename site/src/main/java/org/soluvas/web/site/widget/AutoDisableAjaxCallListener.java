package org.soluvas.web.site.widget;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.attributes.AjaxCallListener;

/**
 * Disables the component via JavaScript before AJAX, and re-enables it again after AJAX success or failure.
 * Note that you still need to use a {@link AjaxChannel.Type#ACTIVE} {@link AjaxChannel} for {@code "0"}, because the default
 * is {@link AjaxChannel.Type#QUEUE}.
 * 
 * @see AutoDisableAjaxButton
 * @author rudi
 */
public class AutoDisableAjaxCallListener extends AjaxCallListener {

	private static final long serialVersionUID = 1L;

	@Override
	public CharSequence getPrecondition(Component component) {
//		return "console.log('PRE', $(this).attr('disabled')); if ($(this).attr('disabled') != undefined) return false;\n" + super.getPrecondition(component);
//		return "if ($(this).attr('disabled') != undefined) return false;\n" + super.getPrecondition(component);
		String event = "if (Wicket.Event.keyCode(attrs.event) !== 13) {$(this).attr('disabled', 'disabled');\n" + super.getBeforeSendHandler(component) + "}";
		return event;
	}
	
	@Override
	public CharSequence getBeforeSendHandler(
			Component component) {
//		return "console.log('beforeSEND');$(this).attr('disabled', 'disabled');\n" + super.getBeforeSendHandler(component);
		String event = "if (Wicket.Event.keyCode(attrs.event) !== 13) {$(this).attr('disabled', 'disabled');\n" + super.getBeforeSendHandler(component) + "}";
//		return "$(this).attr('disabled', 'disabled');\n" + super.getBeforeSendHandler(component);
		return event;
	}

	@Override
	public CharSequence getCompleteHandler(
			Component component) {
//		return super.getCompleteHandler(component) + "\nconsole.log('AFTER');$(this).attr('disabled', " + (component.isEnabledInHierarchy() ? "null" : "'disabled'") + ");";
		return super.getCompleteHandler(component) + "\n$(this).attr('disabled', " + (component.isEnabledInHierarchy() ? "null" : "'disabled'") + ");";
	}

}