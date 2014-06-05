package org.soluvas.web.bootstrap.sound;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.namespace.QName;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.parboiled.common.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.bootstrap.GrowlBehavior;
import org.soluvas.web.bootstrap.sound.cleanus1.Cleanus1Sounds;
import org.soluvas.web.site.Interaction;

import com.google.common.base.Optional;

/**
 * Howler utility methods, requires {@link GrowlBehavior}.
 * 
 * <p>{@link WebApplication#init()}:
 * 
 * <pre>
 * final SecurePackageResourceGuard packageResourceGuard = new SecurePackageResourceGuard();
 * packageResourceGuard.addPattern("+*.map"); // bootstrap 3 map
 * packageResourceGuard.addPattern("+*.mp3"); // howler
 * packageResourceGuard.addPattern("+*.ogg"); // howler
 * getResourceSettings().setPackageResourceGuard(packageResourceGuard);
 * </pre>
 * 
 * @author ceefour
 * @see HowlerJavaScriptReference
 */
public class Howler {
	
	private static final Logger log = LoggerFactory.getLogger(Howler.class);
	private static ConcurrentHashMap<String, Sounds> themes = new ConcurrentHashMap<>();
	
	static {
		themes.put(Cleanus1Sounds.ID, new Cleanus1Sounds());
	}
	
	public static Sounds get(String soundThemeId) {
		Preconditions.checkArgument(themes.containsKey(soundThemeId),
				"Unknown sound theme '%s'. %s available: %s",
				soundThemeId, themes.size(), themes.keySet());
		return themes.get(soundThemeId);
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
			return "";
		}
	}

	/**
	 * Low-level method to play a sprite with or without looping.
	 * 
	 * <p>For non-loop:
	 * 
	 * <pre>
	 * cleanus1_loop.stop();
	 * cleanus1_fx.play('KDE_Event');
	 * </pre>
	 * 
	 * <p>For loop:
	 * 
	 * <pre>
	 * cleanus1_loop.stop().play('KDE_Event');
	 * </pre>
	 * 
	 * @param target
	 * @param sprite must contain {@link QName#getPrefix()}.
	 * @param loop
	 */
	public static String play(QName sprite, boolean loop) {
		final String script;
		if (loop) {
			script = sprite.getPrefix() + "_loop.stop().play(" + JSONObject.quote(sprite.getLocalPart()) + ");";
		} else {
			script = sprite.getPrefix() + "_loop.stop();\n" + sprite.getPrefix() + "_fx.play(" + JSONObject.quote(sprite.getLocalPart()) + ");";
		}
		log.debug("Play {} loop={} with: {}", script);
		return script;
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
		log.trace("Sound theme '{}' has {} merged dependencies: {}",
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

}
