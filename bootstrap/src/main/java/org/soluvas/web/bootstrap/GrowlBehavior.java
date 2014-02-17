package org.soluvas.web.bootstrap;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.feedback.FeedbackCollector;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/**
 * <a href="https://github.com/ifightcrime/bootstrap-growl">bootstrap-growl</a> based {@link FeedbackMessage} notifier.
 * 
 * <p><a href="http://cdnjs.com/libraries/bootstrap-growl/">CDNJS</a> URIs:
 * <ul>
 * 	<li>//cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.js
 * 	<li>//cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.min.js
 * </ul>
 * 
 * <p>This also checks the {@link FeedbackMessage} during page render. To use it during page redirect,
 * use {@link Session#info(java.io.Serializable)} / {@link Session#warn(java.io.Serializable)} / {@link Session#error(java.io.Serializable)}
 * instead of {@link Component#info(java.io.Serializable)}'s variants.
 * Note that if you already have a {@link FeedbackPanel} in your {@link Page}, the panel will consume {@link FeedbackMessage}s before
 * {@link GrowlBehavior}.
 * 
 * <p>(Obsolete) <del>For Ajax behavior explanation, see:
 * 
 * <ul>
 * 	<li>http://www.wexoo.net/20110831/building-a-custom-feedbackpanel-in-wicket-with-js</li>
 * 	<li>http://javathoughts.capesugarbird.com/2009/06/replacing-wickets-feedbackpanel-with.html</li>
 * </ul></del>
 * 
 * @author ceefour
 */
public class GrowlBehavior extends Behavior {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(GrowlBehavior.class);
	private static JavaScriptResourceReference GROWL_JS = new JavaScriptResourceReference(GrowlBehavior.class, "jquery.bootstrap-growl-132647f01c.js") {
		private static final long serialVersionUID = 1L;

		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of(JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()));
		};
	};
	
	public GrowlBehavior() {
		super();
		Injector.get().inject(this);
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.render(JavaScriptHeaderItem.forReference(GROWL_JS));
		final String script = getNotifyScript("renderHead", component.getPage());
		if (script != null) {
			response.render(OnLoadHeaderItem.forScript(script));
		}
	}
	
	@Override
	public void onEvent(Component component, IEvent<?> event) {
		super.onEvent(component, event);
//		log.debug("We get event {}", event.getPayload());
		if (event.getPayload() instanceof AjaxRequestTarget) {
			final AjaxRequestTarget target = (AjaxRequestTarget) event.getPayload();
			final String script = getNotifyScript("AjaxRequestTarget", target.getPage());
			if (script != null) {
				target.appendJavaScript(script);
			}
		}
	}

	/**
	 * Gets the bootstrap growl notify popup script for FeedbackMessages for the specified Page.
	 * @return String Script, or {@code null} if no message needs to be displayed.
	 */
	@Nullable
	protected String getNotifyScript(String purpose, Page page) {
		final List<FeedbackMessage> feedbackMessages = new FeedbackCollector(page).collect();
		if (!feedbackMessages.isEmpty()) {
			log.debug("{} got {} feedback messages for {}", Session.get(), feedbackMessages.size(), purpose);
			String script = "";
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
				msg.markRendered();
				script += "$.bootstrapGrowl(" +
					JsonUtils.asJson(messageText) + ", {type: '" + growlType + "'});\n";					
			}
			return Strings.emptyToNull(script);
		} else {
			return null;
		}
	}

}
