package org.soluvas.web.site;

import java.io.Serializable;

import org.apache.wicket.feedback.FeedbackMessage;

/**
 * {@link Interaction} with textual message.
 * 
 * <p>Usage:
 * 
 * <pre>
 * Interaction.LOGIN.info(this, "You are now logged in as %s", personId);
 * </pre>
 * 
 * @author ceefour
 */
public class InteractionMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Interaction interaction;
	private final String message;
	
	/**
	 * @param interaction
	 * @param message the message in AsciiDoc format
	 */
	public InteractionMessage(Interaction interaction, String message) {
		super();
		this.interaction = interaction;
		this.message = message;
	}

	/**
	 * @return the interaction
	 */
	public Interaction getInteraction() {
		return interaction;
	}

	/**
	 * @return the message in AsciiDoc format
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns {@link #getMessage()} for compatibility with non-{@link Interaction} aware {@link FeedbackMessage} renderer.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getMessage();
	}
	
}
