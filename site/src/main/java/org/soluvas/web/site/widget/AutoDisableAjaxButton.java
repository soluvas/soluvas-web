package org.soluvas.web.site.widget;

import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

/**
 * {@link IndicatingAjaxButton} which auto-disables during AJAX request.
 * 
 * <p>It used to use {@link AjaxChannel.Type#ACTIVE} to prevent duplicate AJAX requests on the Wicket-Ajax level.
 * It also uses the same channel name {@code "0"} to prevent
 * <a href="http://apache-wicket.1842946.n4.nabble.com/ListenerInvocationNotAllowedException-and-EmptyRequestHandler-td4663618.html#a4666112">ListenerInvocationNotAllowedException</a>.
 * But: https://issues.apache.org/jira/browse/WICKET-5611?focusedCommentId=14020693&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-14020693
 * 
 * @author rudi
 * @see de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton
 * @see AutoDisableAjaxCallListener
 * @deprecated Use {@link de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton} instead
 */
@Deprecated
@SuppressWarnings("serial")
public abstract class AutoDisableAjaxButton extends IndicatingAjaxButton {
	
	public AutoDisableAjaxButton(String id, Form<?> form) {
		super(id, form);
	}

	public AutoDisableAjaxButton(String id, IModel<String> model, Form<?> form) {
		super(id, model, form);
	}

	public AutoDisableAjaxButton(String id, IModel<String> model) {
		super(id, model);
	}

	public AutoDisableAjaxButton(String id) {
		super(id);
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		// https://issues.apache.org/jira/browse/WICKET-5611?focusedCommentId=14020693&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-14020693
		// attributes.setChannel(new AjaxChannel("0", AjaxChannel.Type.ACTIVE));
		attributes.getAjaxCallListeners().add(new AutoDisableAjaxCallListener());
	}
	
}
