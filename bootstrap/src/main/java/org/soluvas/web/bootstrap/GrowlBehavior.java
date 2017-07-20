package org.soluvas.web.bootstrap;

import java.util.List;
import java.util.Objects;

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
import org.apache.wicket.markup.head.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.InteractionMessage;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="https://github.com/ifightcrime/bootstrap-growl">bootstrap-growl</a> based {@link FeedbackMessage} notifier
 * for Bootstrap 3.x.
 * <p>
 * <p><a href="http://cdnjs.com/libraries/bootstrap-growl/">CDNJS</a> URIs:
 * <ul>
 * <li>//cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.js
 * <li>//cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.min.js
 * </ul>
 * <p>
 * <p>This also checks the {@link FeedbackMessage} during page render. To use it during page redirect,
 * use {@link Session#info(java.io.Serializable)} / {@link Session#warn(java.io.Serializable)} / {@link Session#error(java.io.Serializable)}
 * instead of {@link Component#info(java.io.Serializable)}'s variants.
 * Note that if you already have a {@link FeedbackPanel} in your {@link Page}, the panel will consume {@link FeedbackMessage}s before
 * {@link GrowlBehavior}.
 * <p>
 * <p>If you want to <a href="http://apache-wicket.1842946.n4.nabble.com/setResponsePage-swallows-my-session-feedback-messages-td4650274.html">preserve {@link FeedbackMessage} across page redirects</a>,
 * please use {@link Session#info(java.io.Serializable)}
 * or {@link Interaction#info(String, Object...)}, not from {@link Component#info(java.io.Serializable)}.
 * <p>
 * <p>(Obsolete) <del>For Ajax behavior explanation, see:
 * <p>
 * <ul>
 * <li>http://www.wexoo.net/20110831/building-a-custom-feedbackpanel-in-wicket-with-js</li>
 * <li>http://javathoughts.capesugarbird.com/2009/06/replacing-wickets-feedbackpanel-with.html</li>
 * </ul></del>
 *
 * @author ceefour
 */
@SuppressWarnings("serial")
public class GrowlBehavior extends Behavior {

    private static Logger log = LoggerFactory.getLogger(GrowlBehavior.class);
    private static CssResourceReference ANIMATE_CSS = new CssResourceReference(
            GrowlBehavior.class, "animate.min.css");
    private static UrlResourceReference ANIMATE_CSS_CDN = new UrlResourceReference(Url.parse(
            "https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"));
    private static JavaScriptResourceReference NOTIFY_JS = new JavaScriptResourceReference(
            GrowlBehavior.class, "bootstrap-notify.min.js") {
        @Override
        public List<HeaderItem> getDependencies() {
            return ImmutableList.of(JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()));
        }
    };
	private static UrlResourceReference NOTIFY_JS_CDN = new UrlResourceReference(Url.parse("//cdnjs.cloudflare.com/ajax/libs/mouse0270-bootstrap-notify/3.1.7/bootstrap-notify.min.js")) {
		@Override
		public List<HeaderItem> getDependencies() {
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
        final IBootstrapSettings settings = Bootstrap.getSettings(component.getApplication());
		if (settings.useCdnResources()) { // BC-1940
            response.render(CssHeaderItem.forReference(ANIMATE_CSS));
            response.render(JavaScriptHeaderItem.forReference(NOTIFY_JS));
		} else {
            response.render(CssHeaderItem.forReference(ANIMATE_CSS_CDN));
            response.render(JavaScriptHeaderItem.forReference(NOTIFY_JS_CDN));
		}

        final String script = getNotifyScript("renderHead", component.getPage());
        if (script != null) {
            log.trace("onLoad FeedbackMessages: {}", script);
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
     *
     * @return String Script, or {@code null} if no message needs to be displayed.
     */
    @Nullable
    protected String getNotifyScript(String purpose, Page page) {
        final List<FeedbackMessage> feedbackMessages = new FeedbackCollector(page).collect();
        if (!feedbackMessages.isEmpty()) {
            log.debug("{} got {} feedback messages during {}", Session.get(), feedbackMessages.size(), purpose);
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
                final String growlType;
                final String glyphicon;
                final Optional<Interaction> interaction = msg.getMessage() instanceof InteractionMessage ?
                        Optional.of(((InteractionMessage) msg.getMessage()).getInteraction()) : Optional.<Interaction>absent();
                log.trace("{} message: {}", interaction, msg);
                if (msg.isError()) {
                    growlType = "danger";
                    glyphicon = "remove-sign";
                } else if (msg.isWarning()) {
                    growlType = "warning";
                    glyphicon = "warning-sign";
                } else if (msg.isInfo()) {
                    growlType = "success";
                    glyphicon = "ok-sign";
                } else if (msg.isDebug()) {
                    growlType = "info";
                    glyphicon = "info-sign";
                } else {
                    growlType = "info";
                    glyphicon = "info-sign";
                }

//				log.debug("Path Icon is: {}", pathIcon);

                final String messageText = !Strings.isNullOrEmpty(Objects.toString(msg.getMessage(), null)) ?
                        msg.getMessage().toString() : "Unknown error: " + msg.getReporter().getPageRelativePath().replace(":", " > ");
//				target.appendJavaScript("jQuery('#notify-container').prepend('<img id=\"icon\"" +
//						"src=\"" + pathIcon + "\" />')");
//				target.appendJavaScript("jQuery('#notify-container').notify('create', {text: " +
//						JsonUtils.asJson(messageText) + ", pathIcon: \"" + pathIcon + "\"});");
                msg.markRendered();

              //tuneeca minta di off-in
                script += "$.notify({icon: 'glyphicon glyphicon-" + glyphicon + "', message: " +
                        JsonUtils.asJson(messageText) + "}, {type: '" + growlType + "', delay: 5000});\n";
            }
            return Strings.emptyToNull(script);
        } else {
            return null;
        }
    }

}
