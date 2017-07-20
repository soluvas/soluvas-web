package org.soluvas.web.bootstrap.sound;

import com.google.common.collect.ImmutableSet;
import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.protocol.http.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.bootstrap.GrowlBehavior;
import org.soluvas.web.site.Interaction;

import javax.xml.namespace.QName;
import java.util.Set;

/**
 * Howler utility methods, requires {@link GrowlBehavior}.
 * 
 * <p>{@link WebApplication#init()}:
 * 
 * <pre>
 * Howler.install(this);
 * </pre>
 * 
 * @author ceefour
 * @see HowlerJavaScriptReference
 * @deprecated Flawed UX idea, and flaky browser support.
 */
@Deprecated
public class Howler {
	
	private static final Logger log = LoggerFactory.getLogger(Howler.class);

	public static Sounds get(String soundThemeId) {
		throw new UnsupportedOperationException("no longer supported");
	}
	
	public static Sounds getActive() {
		return null;
	}
	
	public static String play(Interaction interaction, Sounds sounds) {
		return "";
	}

	public static String play(QName sprite, boolean loop) {
		return "";
	}
	
	public static String stopLoop() {
		return "";
	}
	
	public static Set<String> mergeDependencies(Sounds sounds) {
		return ImmutableSet.of();
	}
	
	public static void renderHead(Component component, IHeaderResponse response, Sounds sounds) {
	}

	/**
	 * does nothing
	 * @param app
	 */
	public static void install(Application app) {
	}

}
