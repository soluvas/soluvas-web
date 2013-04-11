package org.soluvas.web.bootstrap;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.feedback.FeedbackCollector;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.json.JsonUtils;

import com.google.common.base.Optional;

/**
 * For Ajax behavior explanation, see:
 * 
 * http://www.wexoo.net/20110831/building-a-custom-feedbackpanel-in-wicket-with-js
 * http://javathoughts.capesugarbird.com/2009/06/replacing-wickets-feedbackpanel-with.html
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class GrowlBehavior extends Behavior {

	private static Logger log = LoggerFactory.getLogger(GrowlBehavior.class);
	
	@SpringBean
	private WebAddress webAddress;
	
	public GrowlBehavior() {
		super();
		Injector.get().inject(this);
	}

	@Override
	public void onEvent(Component component, IEvent<?> event) {
		super.onEvent(component, event);
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
				String growlType = "info";
				if (msg.isError()) {
					growlType = "error";
				} else if (msg.isWarning()) {
					growlType = "error";
				} else if (msg.isInfo()) {
					growlType = "success";
				} else if (msg.isDebug()) {
					growlType = "info";
				}
				
//				log.debug("Path Icon is: {}", pathIcon);
				
				final String messageText = Optional.fromNullable(msg.getMessage()).or("").toString();
//				target.appendJavaScript("jQuery('#notify-container').prepend('<img id=\"icon\"" +
//						"src=\"" + pathIcon + "\" />')");
//				target.appendJavaScript("jQuery('#notify-container').notify('create', {text: " +
//						JsonUtils.asJson(messageText) + ", pathIcon: \"" + pathIcon + "\"});");
				target.appendJavaScript("require(['bootstrap-growl'], function(){ $.bootstrapGrowl(" +
						JsonUtils.asJson(messageText) + ", {type: '" + growlType + "'}); });");
				msg.markRendered();
			}
		}
	}

}
