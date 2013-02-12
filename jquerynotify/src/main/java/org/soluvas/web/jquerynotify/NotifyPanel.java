package org.soluvas.web.jquerynotify;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.google.common.base.Optional;

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

	private static Logger log = LoggerFactory.getLogger(NotifyPanel.class);
	
	public NotifyPanel(String id) {
		this(id, null);
	}
	
	/**
	 * @param id
	 * @param model
	 */
	public NotifyPanel(String id, IModel<?> model) {
		super(id, model);
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
		final FeedbackMessages feedbackMessages = Session.get().getFeedbackMessages();
		if (!feedbackMessages.isEmpty()) {
			log.debug("{} got {} feedback messages", Session.get(), feedbackMessages.size());
			for (final FeedbackMessage msg : feedbackMessages) {
				// FeedbackMessage.getMessage() can return:
				// 1. String
				// 2. something else: e.g. 
//			{
//			  "error" : {
//			    "keys" : [ "Required" ]^,
//			    "message" : null,
//			    "variables" : { }
//			  },
//			  "message" : "Field 'password' is required."
//			}
//				target.appendJavaScript("require('jquery', new function(jQuery) {\n" +
//						"  jQuery('#notify-container').notify('create', {text: \"" +
//						JavaScriptUtils.escapeQuotes(msg.getMessage().toString()) + "\"}); });");
				// Wicket's JavaScriptUtils.escapeQuotes() does not escape \n :-(
				String icon = "";
				if (msg.isInfo()) {
					icon = "icon";
				} else if (msg.isError()) {
					
				} else if (msg.isWarning()) {
					
				} else if (msg.isDebug()) {
					
				}
				
				final String messageText = Optional.fromNullable(msg.getMessage()).or("").toString();
				target.appendJavaScript("jQuery('#notify-container').notify('create', {text: " +
						JsonUtils.asJson(messageText) + "});");
			}
		}
	}
	
}
