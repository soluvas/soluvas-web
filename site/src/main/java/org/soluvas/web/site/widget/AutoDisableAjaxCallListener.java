package org.soluvas.web.site.widget;

import java.util.Objects;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.attributes.AjaxCallListener;

/**
 * Disables the component via JavaScript before AJAX, and re-enables it again after AJAX success or failure.
 * 
 * <p>I used to think that you still need to use a {@link AjaxChannel.Type#ACTIVE} {@link AjaxChannel} for {@code "0"}, because the default
 * is {@link AjaxChannel.Type#QUEUE}.
 * But: https://issues.apache.org/jira/browse/WICKET-5611?focusedCommentId=14020693&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-14020693
 * 
 * @see AutoDisableAjaxButton
 * @see de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton
 * @author rudi
 * @deprecated Use {@link de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton} instead
 */
@Deprecated
@SuppressWarnings("serial")
public class AutoDisableAjaxCallListener extends AjaxCallListener {
	
	/**
	 * FIXME: Used by Howler. better way to do this 
	 */
	public static String beforeHook = "";
	/**
	 * FIXME: Used by Howler. better way to do this 
	 */
	public static String completeHook = "";

	@Override
	public CharSequence getPrecondition(Component component) {
		return "if (Wicket.Event.keyCode(attrs.event) !== 13) {$(this).attr('disabled', 'disabled');\n" + 
				Objects.toString(super.getBeforeSendHandler(component), "") + "}";
	}
	
	@Override
	public CharSequence getBeforeSendHandler(
			Component component) {
		return beforeHook + "if (Wicket.Event.keyCode(attrs.event) !== 13) {$(this).attr('disabled', 'disabled');\n" +
				Objects.toString(super.getBeforeSendHandler(component), "") + "}";
	}

	@Override
	public CharSequence getCompleteHandler(
			Component component) {
		return Objects.toString(super.getCompleteHandler(component), "") +
				completeHook + "\n$(this).attr('disabled', " + (component.isEnabledInHierarchy() ? "null" : "'disabled'") + ");";
	}

}
