package org.soluvas.web.bootstrap.sound.cleanus1;

import org.soluvas.web.bootstrap.sound.Sounds;
import org.soluvas.web.site.Interaction;

import com.google.common.collect.ImmutableMap;

/**
 * Based on <a href="http://gnome-look.org/content/show.php/Cleanus?content=61245">Cleanus 1 by martyncircus</a>.
 * Licensed under <a href="https://creativecommons.org/licenses/by-sa/2.0/">Creative Commons - Attribution-Share Alike 2.0 Generic</a>.
 * @author ceefour
 */
public class Cleanus1Sounds extends Sounds {
	
	public static final String ID = "cleanus1";
	
	public Cleanus1Sounds() {
		super(ID, ImmutableMap.<Interaction, String>builder()
				.put(Interaction.INFO, "KDE_pop")
				.put(Interaction.QUESTION, "KDE_Event")
				.put(Interaction.WARNING, "KDE_Event2")
				.put(Interaction.ERROR, "KDE_Error")
				.put(Interaction.LOGIN, "KDE_Startup")
				.put(Interaction.LOGOUT, "KDE_Logout")
				.build());
	}

}
