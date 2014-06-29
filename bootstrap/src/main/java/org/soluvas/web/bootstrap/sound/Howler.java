package org.soluvas.web.bootstrap.sound;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.namespace.QName;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.parboiled.common.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.bootstrap.GrowlBehavior;
import org.soluvas.web.bootstrap.sound.cleanus1.Cleanus1Sounds;
import org.soluvas.web.bootstrap.sound.feather.FeatherSounds;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.SoluvasWebSession;
import org.soluvas.web.site.widget.AutoDisableAjaxCallListener;

import com.google.common.base.Optional;

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
 */
public class Howler {
	
	private static final Logger log = LoggerFactory.getLogger(Howler.class);
	private static ConcurrentHashMap<String, Sounds> themes = new ConcurrentHashMap<>();
	
	static {
		themes.put(FeatherSounds.ID, new FeatherSounds());
		themes.put(Cleanus1Sounds.ID, new Cleanus1Sounds());
		// FIXME: better way to do this
		AutoDisableAjaxCallListener.beforeHook = play(Interaction.LOADING_HEAVY, getActive());
		AutoDisableAjaxCallListener.completeHook = stopLoop();
	}
	
	public static Sounds get(String soundThemeId) {
		Preconditions.checkArgument(themes.containsKey(soundThemeId),
				"Unknown sound theme '%s'. %s available: %s",
				soundThemeId, themes.size(), themes.keySet());
		return themes.get(soundThemeId);
	}
	
	/**
	 * Get active {@link Sounds} theme based on {@link SoluvasWebSession}.
	 * @todo Implement dynamic behavior.
	 * @return
	 */
	public static Sounds getActive() {
		return get(Cleanus1Sounds.ID);
	}
	
	/**
	 * @param target
	 * @param interaction
	 */
	public static String play(Interaction interaction, Sounds sounds) {
		final Optional<QName> sprite = sounds.getSprite(interaction);
		if (sprite.isPresent()) {
			final boolean looped = Interaction.LOOPED_SOUNDS.contains(interaction);
			return play(sprite.get(), looped);
		} else {
			log.debug("No sound for {} in {}", interaction, sounds);
			return stopLoop();
		}
	}

	/**
	 * Low-level method to play a sprite with or without looping.
	 * 
	 * <p>For non-loop:
	 * <pre>
	 * if (typeof window.lastLoop != 'undefined') { window.lastLoop.stop(); window.lastLoop = undefined; }
	 * cleanus1_fx.play('KDE_Event');
	 * </pre>
	 * 
	 * <p>For loop:
	 * <pre>
	 * if (typeof window.lastLoop != 'undefined') { window.lastLoop.stop(); window.lastLoop = undefined; }
	 * cleanus1_loop.play('KDE_Event');
	 * </pre>
	 * 
	 * <p>The {@code window.} part is required due to <a href="https://github.com/soluvas/soluvas-web/issues/39">an issue with Bootstrap-Modal</a>.
	 * 
	 * @param target
	 * @param sprite must contain {@link QName#getPrefix()}.
	 * @param loop
	 */
	public static String play(QName sprite, boolean loop) {
		final String script;
		if (loop) {
			script = stopLoop() + "\n" + sprite.getPrefix() + "_loop.play(" + JSONObject.quote(sprite.getLocalPart()) + ");\n" +
					"window.lastLoop = " + sprite.getPrefix() + "_loop;";
		} else {
			script = stopLoop() + "\n" + sprite.getPrefix() + "_fx.play(" + JSONObject.quote(sprite.getLocalPart()) + ");";
		}
		log.debug("Play {} loop={} with: {}", script);
		return script;
	}
	
	public static String stopLoop() {
		return "if (typeof window.lastLoop != 'undefined') { window.lastLoop.stop(); window.lastLoop = undefined; }";
	}
	
	public static Set<String> mergeDependencies(Sounds sounds) {
		final Set<String> deps = new HashSet<>(sounds.getDependencies());
		for (String cur : deps) {
			deps.addAll(mergeDependencies(get(cur)));
		}
		return deps;
	}
	
	/**
	 * Render {@link HowlerJavaScriptReference} and the sound theme JS including {@link Sounds#getDependencies()}.
	 * @param component
	 * @param response
	 * @param sounds
	 */
	public static void renderHead(Component component, IHeaderResponse response, Sounds sounds) {
		HowlerJavaScriptReference.renderHead(component, response);
		final Set<String> deps = mergeDependencies(sounds);
		log.debug("Sound theme '{}' has {} merged dependencies: {}",
				sounds.getId(), deps.size(), deps);
		for (String cur : deps) {
			doRenderHead(component, response, get(cur));
		}
		doRenderHead(component, response, sounds);
	}
	
	protected static void doRenderHead(Component component, IHeaderResponse response, Sounds sounds) {
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
				sounds.getClass(), sounds.getId() + ".js")));
	}
	
	public static void install(Application app) {
        IPackageResourceGuard resourceGuard = app.getResourceSettings().getPackageResourceGuard();
        if (resourceGuard instanceof SecurePackageResourceGuard) {
            SecurePackageResourceGuard securePackageResourceGuard = (SecurePackageResourceGuard) resourceGuard;
            securePackageResourceGuard.addPattern("+*.map"); // bootstrap 3 map
            securePackageResourceGuard.addPattern("+*.mp3"); // howler
            securePackageResourceGuard.addPattern("+*.ogg"); // howler
        }
	}

}
