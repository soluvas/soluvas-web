package org.soluvas.web.bootstrap.sound;

import java.util.Map;

import javax.xml.namespace.QName;

import org.soluvas.web.site.Interaction;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

/**
 * Sound theme for {@link Interaction}.
 * @author ceefour
 */
public abstract class Sounds {
	
	private final String id;
	/**
	 * Sprite ID (e.g. {@code KDE_Startup}) with optional sound ID as {@code nsPrefix} (e.g. {@code cleanus1:KDE_Startup1},
	 * to be played by {@link Howler} for an {@link Interaction}.
	 * <p>The sound may be looped depending on {@link Interaction}.
	 */
	private final ImmutableMap<Interaction, QName> sprites;
	/**
	 * Required sound themes.
	 */
	private final ImmutableSet<String> dependencies;
	
	/**
	 * Dependencies are automatically calculated.
	 * @param id
	 * @param sprites
	 */
	public Sounds(final String id, Map<Interaction, String> sprites) {
		super();
		this.id = id;
		final ImmutableSet.Builder<String> deps = ImmutableSet.builder();
		this.sprites = ImmutableMap.copyOf(Maps.transformValues(sprites, new Function<String, QName>() {
			@Override
			public QName apply(String input) {
				final QName sprite = parse(input, id);
				if (!id.equals(sprite.getPrefix())) {
					deps.add(sprite.getPrefix());
				}
				return sprite;
			}
		}));
		this.dependencies = deps.build();
	}

	public String getId() {
		return id;
	}
	
	/**
	 * Get sprite {@link QName} with sound ID as {@code nsPrefix} (e.g. {@code cleanus1:KDE_Startup1},
	 * to be played by {@link Howler} for an {@link Interaction}.
	 * <p>The sound may be looped depending on {@link Interaction#LOOPED_SOUNDS}.
	 * 
	 * @param interaction
	 * @return
	 */
	public Optional<QName> getSprite(Interaction interaction) {
		return Optional.fromNullable(sprites.get(interaction));
	}
	
	public ImmutableSet<String> getDependencies() {
		return dependencies;
	}
	
	public static QName parse(String spriteRef, String defaultNsPrefix) {
		final ImmutableList<String> split = ImmutableList.copyOf(Splitter.on(';').split(spriteRef));
		switch (split.size()) {
		case 1:
			return new QName("urn:sound:" + defaultNsPrefix + "#", spriteRef, defaultNsPrefix);
		case 2:
			return new QName("urn:sound:" + split.get(0) + "#", split.get(1), split.get(0));
		default:
			throw new IllegalArgumentException("Invalid sound sprite URI: " + spriteRef);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sounds [" + id + ", "
				+ "sprites=" + sprites.size() + ", "
				+ "dependencies=" + dependencies
				+ "]";
	}

}
