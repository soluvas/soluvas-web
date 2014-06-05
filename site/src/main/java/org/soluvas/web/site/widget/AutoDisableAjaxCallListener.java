package org.soluvas.web.site.widget;

import java.util.Objects;

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
@SuppressWarnings("serial")
public class AutoDisableAjaxCallListener extends AjaxCallListener {
	
	@Override
	public CharSequence getPrecondition(Component component) {
		return "if (Wicket.Event.keyCode(attrs.event) !== 13) {$(this).attr('disabled', 'disabled');\n" + 
				Objects.toString(super.getBeforeSendHandler(component), "") + "}";
	}
	
	@Override
	public CharSequence getBeforeSendHandler(
			Component component) {
		return "if (Wicket.Event.keyCode(attrs.event) !== 13) {$(this).attr('disabled', 'disabled');\n" +
				Objects.toString(super.getBeforeSendHandler(component), "") + "}";
	}

	@Override
	public CharSequence getCompleteHandler(
			Component component) {
		return Objects.toString(super.getCompleteHandler(component), "") +
				"\n$(this).attr('disabled', " + (component.isEnabledInHierarchy() ? "null" : "'disabled'") + ");";
	}

}
