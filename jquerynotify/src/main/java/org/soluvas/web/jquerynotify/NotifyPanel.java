package org.soluvas.web.jquerynotify;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxRequestTarget.ITargetRespondListener;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.string.JavaScriptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For Ajax behavior explanation, see:
 * 
 * http://www.wexoo.net/20110831/building-a-custom-feedbackpanel-in-wicket-with-js
 * http://javathoughts.capesugarbird.com/2009/06/replacing-wickets-feedbackpanel-with.html
 * 
 * See also jGrowl behavior in https://github.com/wicketstuff/core
 * 
 * We might just move to that.
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class NotifyPanel extends Panel {

	private transient Logger log = LoggerFactory.getLogger(NotifyPanel.class);
	
	public NotifyPanel(String id) {
		super(id);
		setRenderBodyOnly(true);
	}
	
	@Override
	public void onEvent(IEvent<?> event) {
		super.onEvent(event);
		if (event.getPayload() instanceof AjaxRequestTarget) {
			createNotify((AjaxRequestTarget) event.getPayload());
		}
	}

	protected void createNotify(AjaxRequestTarget target) {
		FeedbackMessages feedbackMessages = Session.get().getFeedbackMessages();
		if (!feedbackMessages.isEmpty()) {
			log.debug("{} got {} feedback messages", Session.get(), feedbackMessages.size());
			for (FeedbackMessage msg : feedbackMessages) {
				target.appendJavaScript("jQuery('#notify-container').notify('create', {text: \"" + JavaScriptUtils.escapeQuotes(msg.getMessage().toString()) + "\"});");
			}
		}
	}
	
}
