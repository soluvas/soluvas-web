/**
 */
package org.soluvas.web.site;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.wicket.Component;
import org.apache.wicket.Session;
import org.eclipse.emf.common.util.Enumerator;

import com.google.common.collect.ImmutableSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Interaction</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Used for providing sound effects (themeable) during or after interactions.
 * 
 * <p><b>Note</b>: Sound effects are generally only playable during user actions, so for example we can't play sound on page load.
 * 
 * <p>A sound theme depend on other themes, so it can use sounds from them.
 * 
 * <p>See <a href="https://idbippo.atlassian.net/browse/BC-1811">BC-1811: Integrasi growl / Wicket feedback dengan sound effect</a>.
 * 
 * <!-- end-model-doc -->
 * @see org.soluvas.web.site.SitePackage#getInteraction()
 * @model
 * @generated
 */
public enum Interaction implements Enumerator {
	/**
	 * The '<em><b>Login</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGIN_VALUE
	 * @generated
	 * @ordered
	 */
	LOGIN(0, "login", "login"),

	/**
	 * The '<em><b>Logout</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGOUT_VALUE
	 * @generated
	 * @ordered
	 */
	LOGOUT(1, "logout", "logout"),

	/**
	 * The '<em><b>Info</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFO_VALUE
	 * @generated
	 * @ordered
	 */
	INFO(2, "info", "info"),

	/**
	 * The '<em><b>Question</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUESTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUESTION(16, "question", "question"), /**
	 * The '<em><b>Warning</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WARNING_VALUE
	 * @generated
	 * @ordered
	 */
	WARNING(3, "warning", "warning"),

	/**
	 * The '<em><b>Error</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR(4, "error", "error"),

	/**
	 * The '<em><b>Deleted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETED_VALUE
	 * @generated
	 * @ordered
	 */
	DELETED(5, "deleted", "deleted"),

	/**
	 * The '<em><b>Added</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDED_VALUE
	 * @generated
	 * @ordered
	 */
	ADDED(6, "added", "added"),

	/**
	 * The '<em><b>Modified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFIED(7, "modified", "modified"),

	/**
	 * The '<em><b>Searched</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEARCHED_VALUE
	 * @generated
	 * @ordered
	 */
	SEARCHED(8, "searched", "searched"),

	/**
	 * The '<em><b>Filtered</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILTERED_VALUE
	 * @generated
	 * @ordered
	 */
	FILTERED(9, "filtered", "filtered"),

	/**
	 * The '<em><b>Loading light</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADING_LIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	LOADING_LIGHT(10, "loading_light", "loading_light"),

	/**
	 * The '<em><b>Loading heavy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADING_HEAVY_VALUE
	 * @generated
	 * @ordered
	 */
	LOADING_HEAVY(11, "loading_heavy", "loading_heavy"),

	/**
	 * The '<em><b>Message sent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_SENT_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_SENT(12, "message_sent", "message_sent"),

	/**
	 * The '<em><b>Message received</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_RECEIVED_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_RECEIVED(13, "message_received", "message_received"),

	/**
	 * The '<em><b>Im received</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_RECEIVED_VALUE
	 * @generated
	 * @ordered
	 */
	IM_RECEIVED(18, "im_received", "im_received"), /**
	 * The '<em><b>Im sent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_SENT_VALUE
	 * @generated
	 * @ordered
	 */
	IM_SENT(17, "im_sent", "im_sent"), /**
	 * The '<em><b>Liked</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIKED_VALUE
	 * @generated
	 * @ordered
	 */
	LIKED(14, "liked", "liked"),

	/**
	 * The '<em><b>Unliked</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNLIKED_VALUE
	 * @generated
	 * @ordered
	 */
	UNLIKED(15, "unliked", "unliked");

	/**
	 * The '<em><b>Login</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tenant user logs in to tenant.
	 * <!-- end-model-doc -->
	 * @see #LOGIN
	 * @model name="login"
	 * @generated
	 * @ordered
	 */
	public static final int LOGIN_VALUE = 0;

	/**
	 * The '<em><b>Logout</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tenant user logs out from tenant.
	 * <!-- end-model-doc -->
	 * @see #LOGOUT
	 * @model name="logout"
	 * @generated
	 * @ordered
	 */
	public static final int LOGOUT_VALUE = 1;

	/**
	 * The '<em><b>Info</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * General notification.
	 * <!-- end-model-doc -->
	 * @see #INFO
	 * @model name="info"
	 * @generated
	 * @ordered
	 */
	public static final int INFO_VALUE = 2;

	/**
	 * The '<em><b>Question</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Question or confirmation box, usually a modal.
	 * <!-- end-model-doc -->
	 * @see #QUESTION
	 * @model name="question"
	 * @generated
	 * @ordered
	 */
	public static final int QUESTION_VALUE = 16;

	/**
	 * The '<em><b>Warning</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Warning notification.
	 * <!-- end-model-doc -->
	 * @see #WARNING
	 * @model name="warning"
	 * @generated
	 * @ordered
	 */
	public static final int WARNING_VALUE = 3;

	/**
	 * The '<em><b>Error</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Error notification.
	 * <!-- end-model-doc -->
	 * @see #ERROR
	 * @model name="error"
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_VALUE = 4;

	/**
	 * The '<em><b>Deleted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more entities have been deleted.
	 * <!-- end-model-doc -->
	 * @see #DELETED
	 * @model name="deleted"
	 * @generated
	 * @ordered
	 */
	public static final int DELETED_VALUE = 5;

	/**
	 * The '<em><b>Added</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more entities have been added.
	 * <!-- end-model-doc -->
	 * @see #ADDED
	 * @model name="added"
	 * @generated
	 * @ordered
	 */
	public static final int ADDED_VALUE = 6;

	/**
	 * The '<em><b>Modified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more entities have been modified.
	 * <!-- end-model-doc -->
	 * @see #MODIFIED
	 * @model name="modified"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFIED_VALUE = 7;

	/**
	 * The '<em><b>Searched</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Search results have been shown.
	 * <!-- end-model-doc -->
	 * @see #SEARCHED
	 * @model name="searched"
	 * @generated
	 * @ordered
	 */
	public static final int SEARCHED_VALUE = 8;

	/**
	 * The '<em><b>Filtered</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Filtered results have been shown.
	 * <!-- end-model-doc -->
	 * @see #FILTERED
	 * @model name="filtered"
	 * @generated
	 * @ordered
	 */
	public static final int FILTERED_VALUE = 9;

	/**
	 * The '<em><b>Loading light</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Loading loop for light/short operations, usually without progress bar. e.g. {@link com.vaynberg.wicket.select2.Select2Choice}.
	 * <!-- end-model-doc -->
	 * @see #LOADING_LIGHT
	 * @model name="loading_light"
	 * @generated
	 * @ordered
	 */
	public static final int LOADING_LIGHT_VALUE = 10;

	/**
	 * The '<em><b>Loading heavy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * Loading loop for heavy/long operations, usually with either AJAX spinner or progress bar. e.g. {@link de.agilecoders.wicket.extensions.markup.html.bootstrap.ladda.LaddaAjaxButton}.
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Loading loop for heavy/long operations, usually with either AJAX spinner or progress bar. e.g. {@link org.soluvas.web.site.widget.AutoDisableAjaxButton}.
	 * <!-- end-model-doc -->
	 * @see #LOADING_HEAVY
	 * @model name="loading_heavy"
	 * @generated
	 * @ordered
	 */
	public static final int LOADING_HEAVY_VALUE = 11;

	/**
	 * The '<em><b>Message sent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Message or comment sent.
	 * <!-- end-model-doc -->
	 * @see #MESSAGE_SENT
	 * @model name="message_sent"
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_SENT_VALUE = 12;

	/**
	 * The '<em><b>Message received</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Message or comment (long, non-private) received.
	 * <!-- end-model-doc -->
	 * @see #MESSAGE_RECEIVED
	 * @model name="message_received"
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_RECEIVED_VALUE = 13;

	/**
	 * The '<em><b>Im received</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Short/private instant message received.
	 * <!-- end-model-doc -->
	 * @see #IM_RECEIVED
	 * @model name="im_received"
	 * @generated
	 * @ordered
	 */
	public static final int IM_RECEIVED_VALUE = 18;

	/**
	 * The '<em><b>Im sent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Short/private instant message sent.
	 * <!-- end-model-doc -->
	 * @see #IM_SENT
	 * @model name="im_sent"
	 * @generated
	 * @ordered
	 */
	public static final int IM_SENT_VALUE = 17;

	/**
	 * The '<em><b>Liked</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Liked or starred or watched.
	 * <!-- end-model-doc -->
	 * @see #LIKED
	 * @model name="liked"
	 * @generated
	 * @ordered
	 */
	public static final int LIKED_VALUE = 14;

	/**
	 * The '<em><b>Unliked</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unliked or unstarred or unwatched.
	 * <!-- end-model-doc -->
	 * @see #UNLIKED
	 * @model name="unliked"
	 * @generated
	 * @ordered
	 */
	public static final int UNLIKED_VALUE = 15;

	/**
	 * An array of all the '<em><b>Interaction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Interaction[] VALUES_ARRAY =
		new Interaction[] {
			LOGIN,
			LOGOUT,
			INFO,
			QUESTION,
			WARNING,
			ERROR,
			DELETED,
			ADDED,
			MODIFIED,
			SEARCHED,
			FILTERED,
			LOADING_LIGHT,
			LOADING_HEAVY,
			MESSAGE_SENT,
			MESSAGE_RECEIVED,
			IM_RECEIVED,
			IM_SENT,
			LIKED,
			UNLIKED,
		};

	/**
	 * A public read-only list of all the '<em><b>Interaction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Interaction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Interaction</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Interaction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Interaction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Interaction</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Interaction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Interaction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Interaction</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Interaction get(int value) {
		switch (value) {
			case LOGIN_VALUE: return LOGIN;
			case LOGOUT_VALUE: return LOGOUT;
			case INFO_VALUE: return INFO;
			case QUESTION_VALUE: return QUESTION;
			case WARNING_VALUE: return WARNING;
			case ERROR_VALUE: return ERROR;
			case DELETED_VALUE: return DELETED;
			case ADDED_VALUE: return ADDED;
			case MODIFIED_VALUE: return MODIFIED;
			case SEARCHED_VALUE: return SEARCHED;
			case FILTERED_VALUE: return FILTERED;
			case LOADING_LIGHT_VALUE: return LOADING_LIGHT;
			case LOADING_HEAVY_VALUE: return LOADING_HEAVY;
			case MESSAGE_SENT_VALUE: return MESSAGE_SENT;
			case MESSAGE_RECEIVED_VALUE: return MESSAGE_RECEIVED;
			case IM_RECEIVED_VALUE: return IM_RECEIVED;
			case IM_SENT_VALUE: return IM_SENT;
			case LIKED_VALUE: return LIKED;
			case UNLIKED_VALUE: return UNLIKED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;
	
	public static final Set<Interaction> LOOPED_SOUNDS = ImmutableSet.of(
			LOADING_HEAVY, LOADING_LIGHT);

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Interaction(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
	/**
	 * Notifies {@link InteractionMessage} using {@link Session#info(java.io.Serializable)}.
	 * 
	 * <pre>
	 * Interaction.LOGIN.info("You are now logged in as %s", personId);
	 * </pre>
	 * 
	 * @param message
	 * @return
	 */
	public InteractionMessage info(String message) {
		final InteractionMessage msg = new InteractionMessage(this, message);
		Session.get().info(msg);
		return msg;
	}

	/**
	 * Notifies {@link InteractionMessage} using {@link Session#info(java.io.Serializable)}.
	 * 
	 * <pre>
	 * Interaction.LOGIN.info(this, "You are now logged in as %s", personId);
	 * </pre>
	 * 
	 * @param format
	 * @param params
	 * @return
	 */
	public InteractionMessage info(String format, Object... params) {
		final InteractionMessage msg = new InteractionMessage(this, String.format(format, params));
		Session.get().info(msg);
		return msg;
	}
	
	/**
	 * Notifies {@link InteractionMessage} using {@link Component#info(java.io.Serializable)}.
	 * 
	 * <pre>
	 * Interaction.LOGIN.info(this, "You are now logged in as %s", personId);
	 * </pre>
	 * 
	 * @param component
	 * @param message
	 * @return
	 */
	public InteractionMessage info(Component component, String message) {
		final InteractionMessage msg = new InteractionMessage(this, message);
		component.info(msg);
		return msg;
	}
	
	/**
	 * Notifies {@link InteractionMessage} using {@link Component#info(java.io.Serializable)}.
	 * 
	 * <pre>
	 * Interaction.LOGIN.info(this, "You are now logged in as %s", personId);
	 * </pre>
	 * 
	 * @param component
	 * @param format
	 * @param params
	 * @return
	 */
	public InteractionMessage info(@Nullable Component component, String format, Object... params) {
		final InteractionMessage msg = new InteractionMessage(this, String.format(format, params));
		if (component != null) {
			component.info(msg);
		} else {
			Session.get().info(msg);
		}
		return msg;
	}

	/**
	 * Notifies {@link InteractionMessage} using {@link Session#error(java.io.Serializable)}.
	 *
	 * <pre>
	 * Interaction.ERROR.error("Cannot edit person '%s'", personId);
	 * </pre>
	 *
	 * @param message
	 * @return
	 */
	public InteractionMessage error(String message) {
		final InteractionMessage msg = new InteractionMessage(this, message);
		Session.get().error(msg);
		return msg;
	}

	/**
	 * Notifies {@link InteractionMessage} using {@link Session#error(java.io.Serializable)}.
	 *
	 * <pre>
	 * Interaction.ERROR.error("Cannot edit person '%s'", personId);
	 * </pre>
	 *
	 * @param format
	 * @return
	 */
	public InteractionMessage error(String format, Object... params) {
		final InteractionMessage msg = new InteractionMessage(this, String.format(format, params));
		Session.get().error(msg);
		return msg;
	}


	/**
	 * Notifies {@link InteractionMessage} using {@link Session#error(java.io.Serializable)}.
	 *
	 * <pre>
	 * Interaction.ERROR.error("Cannot edit person '%s'", personId);
	 * </pre>
	 *
	 * @param message
	 * @return
	 */
	public InteractionMessage error(@Nullable Component component, String message) {
		final InteractionMessage msg = new InteractionMessage(this, message);
		if (component != null) {
			component.error(msg);
		} else {
			Session.get().error(msg);
		}
		return msg;
	}

	/**
	 * Notifies {@link InteractionMessage} using {@link Session#error(java.io.Serializable)}.
	 *
	 * <pre>
	 * Interaction.ERROR.error("Cannot edit person '%s'", personId);
	 * </pre>
	 *
	 * @param format
	 * @return
	 */
	public InteractionMessage error(@Nullable Component component, String format, Object... params) {
		final InteractionMessage msg = new InteractionMessage(this, String.format(format, params));
		if (component != null) {
			component.error(msg);
		} else {
			Session.get().error(msg);
		}
		return msg;
	}

} //Interaction
