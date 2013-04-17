package org.soluvas.web.bootstrap;

import java.util.List;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.feedback.FeedbackCollector;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
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
 * See also jGrowl behavior in https://github.com/wicketstuff/core
 * 
 * We might just move to that.
 * 
 * @todo There is issue with z-index, it is covered by navbar.
 * @author ceefour
 * @deprecated No longer used. Use {@link GrowlBehavior} panel instead,
 * 	more lightweight (no CSS because already provided by Bootstrap),
 *  uses Bootstrap theme, CDN available at cdnjs.com, works on top of navbar.
 */
@SuppressWarnings("serial") @Deprecated
public class NotifyPanel extends Panel {

	private static Logger log = LoggerFactory.getLogger(NotifyPanel.class);
	
	@SpringBean(name="webAddress")
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
				String templateName = "ui-notify-info";
				if (msg.isError()) {
					templateName = "ui-notify-error";
				} else if (msg.isWarning()) {
					templateName = "ui-notify-warning";
				} else if (msg.isInfo()) {
					templateName = "ui-notify-info";
				} else if (msg.isDebug()) {
					templateName = "ui-notify-debug";
				}
				
//				log.debug("Path Icon is: {}", pathIcon);
				
				final String messageText = Optional.fromNullable(msg.getMessage()).or("").toString();
//				target.appendJavaScript("jQuery('#notify-container').prepend('<img id=\"icon\"" +
//						"src=\"" + pathIcon + "\" />')");
//				target.appendJavaScript("jQuery('#notify-container').notify('create', {text: " +
//						JsonUtils.asJson(messageText) + ", pathIcon: \"" + pathIcon + "\"});");
				target.appendJavaScript("jQuery('#notify-container').notify('create', '" + templateName + "', {text: " +
						JsonUtils.asJson(messageText) + "});");
				msg.markRendered();
			}
		}
	}
	
}
