package org.soluvas.web.bootstrap.sound.feather;

import org.soluvas.web.bootstrap.sound.Sounds;
import org.soluvas.web.site.Interaction;

import com.google.common.collect.ImmutableMap;

/**
 * Based on <a href="http://gnome-look.org/content/show.php/Cleanus?content=61245">Cleanus 1 by martyncircus</a>.
 * Licensed under <a href="https://creativecommons.org/licenses/by-sa/2.0/">Creative Commons - Attribution-Share Alike 2.0 Generic</a>.
 * @author ceefour
 */
public class FeatherSounds extends Sounds {
	
	public static final String ID = "feather";
	
	public FeatherSounds() {
		super(ID, ImmutableMap.<Interaction, String>builder()
				.put(Interaction.INFO, "beep")
				.put(Interaction.QUESTION, "popup")
				.put(Interaction.WARNING, "critical")
				.put(Interaction.ERROR, "fail")
				.put(Interaction.LOGIN, "opening")
				.put(Interaction.LOGOUT, "ending")
				// Hervin doesn't like it. And it's flaky anyway. :(
//				.put(Interaction.LOADING_LIGHT, "loading_2")
//				.put(Interaction.LOADING_HEAVY, "loading")
				.put(Interaction.MESSAGE_RECEIVED, "new_mail_notification")
				.put(Interaction.IM_RECEIVED, "IM_notification")
				.build());
	}

}
