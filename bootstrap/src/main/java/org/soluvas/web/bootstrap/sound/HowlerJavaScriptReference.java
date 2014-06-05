package org.soluvas.web.bootstrap.sound;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="http://goldfirestudios.com/blog/104/howler.js-Modern-Web-Audio-Javascript-Library">
 * howler.js - Modern Web Audio Javascript Library</a>
 * 
 * <p>Browsers have come a long way over the years, and we are now able to achieve
 * amazing results using all of the great new technologies often referred to as
 * HTML5. However, generally speaking, audio still sucks. Thankfully, Google
 * decided to create Web Audio API and make all our lives easier. The problem is
 * that only the latest browsers support this new-fangled browser audio, so what
 * are we to do?
 * 
 * <p>We were presented with this very question while developing our new HTML5 game
 * and set out to find a library that provided the functionality we needed,
 * without all of the bloat, while still supporting the majority of browsers.
 * Unfortunately, we didn't find anything that met our needs. So, we decided to
 * create our own library and open source it. This library works great for
 * games, but it can work just as well for any other audio-related web app.
 *
 * <h3>Features</h3>
 * <ul>
 * <li>Defaults to Web Audio API</li>
 * <li>Falls back to HTML5 Audio</li>
 * <li>Supports multiple file formats to support all browsers</li>
 * <li>Automatic caching for Web Audio API</li>
 * <li>Implements cache pool for HTML5 Audio</li>
 * <li>Per-sound and global mute/unmute and volume control</li>
 * <li>Playback of multiple sounds at the same time</li>
 * <li>Easy sound sprite definition and playback</li>
 * <li>Fade in/out sounds</li>
 * <li>Methods can be chained</li>
 * <li>Uses no outside libraries, just pure Javascript</li>
 * <li>Lightweight, 9kb filesize (3kb gzipped)</li>
 * </ul>
 * 
 * @author ceefour
 * @see Howler
 */
@SuppressWarnings("serial")
public class HowlerJavaScriptReference extends JavaScriptResourceReference {

	private static final String HOWLER_CDN = "//cdnjs.cloudflare.com/ajax/libs/howler/1.1.17/howler.min.js";

	/**
	 * @param scope
	 * @param name
	 */
	public HowlerJavaScriptReference() {
		super(HowlerJavaScriptReference.class, "howler.js");
	}
	
	/**
	 * Either the local or CDN {@link ResourceReference} based on {@link BootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance() {
		return new HowlerJavaScriptReference();
	}
	
	public static void renderHead(final Component component, final IHeaderResponse headerResponse) {
		final IBootstrapSettings settings = Bootstrap.getSettings(component.getApplication());
		if (settings.useCdnResources()) {
			headerResponse.render(JavaScriptHeaderItem.forUrl(HOWLER_CDN));
		} else {
			headerResponse.render(JavaScriptHeaderItem.forReference(instance()));
		}
	}

}
