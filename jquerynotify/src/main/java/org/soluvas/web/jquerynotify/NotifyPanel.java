package org.soluvas.web.jquerynotify;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.feedback.FeedbackCollector;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.inject.Supplied;
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
	
	@Inject @Supplied
	private WebAddress webAddress;	
	
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
//		log.debug("We get event {}", event.getPayload());
		if (event.getPayload() instanceof AjaxRequestTarget) {
			createNotify((AjaxRequestTarget) event.getPayload());
		}
	}
	
	protected void createNotify(AjaxRequestTarget target) {
		final List<FeedbackMessage> feedbackMessages = new FeedbackCollector(target.getPage()).collect();
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
				String pathIcon = webAddress.getSkinUri() + "org.soluvas.web.jquerynotify/images/";
				if (msg.isError()) {
					pathIcon += "error.png";
				} else if (msg.isWarning()) {
					pathIcon += "warning.png";
				} else if (msg.isInfo()) {
					pathIcon += "info.png";
				} else if (msg.isDebug()) {
					pathIcon += "debug.png";
				}
				
//				log.debug("Path Icon is: {}", pathIcon);
				
				final String messageText = Optional.fromNullable(msg.getMessage()).or("").toString();
//				target.appendJavaScript("jQuery('#notify-container').prepend('<img id=\"icon\"" +
//						"src=\"" + pathIcon + "\" />')");
				target.appendJavaScript("jQuery('#notify-container').notify('create', {text: " +
						JsonUtils.asJson(messageText) + ", pathIcon: \"" + pathIcon + "\"});");
				msg.markRendered();
			}
		}
	}
	
}
