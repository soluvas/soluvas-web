/**
 */
package org.soluvas.web.olark;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Live Chat Provider</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.olark.OlarkPackage#getLiveChatProvider()
 * @model
 * @generated
 */
public enum LiveChatProvider implements Enumerator {
	/**
	 * The '<em><b>Olark</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OLARK_VALUE
	 * @generated
	 * @ordered
	 */
	OLARK(0, "olark", "olark"),

	/**
	 * The '<em><b>Livechatinc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIVECHATINC_VALUE
	 * @generated
	 * @ordered
	 */
	LIVECHATINC(1, "livechatinc", "livechatinc");

	/**
	 * The '<em><b>Olark</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Olark</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OLARK
	 * @model name="olark"
	 * @generated
	 * @ordered
	 */
	public static final int OLARK_VALUE = 0;

	/**
	 * The '<em><b>Livechatinc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Livechatinc</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIVECHATINC
	 * @model name="livechatinc"
	 * @generated
	 * @ordered
	 */
	public static final int LIVECHATINC_VALUE = 1;

	/**
	 * An array of all the '<em><b>Live Chat Provider</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LiveChatProvider[] VALUES_ARRAY =
		new LiveChatProvider[] {
			OLARK,
			LIVECHATINC,
		};

	/**
	 * A public read-only list of all the '<em><b>Live Chat Provider</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LiveChatProvider> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Live Chat Provider</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LiveChatProvider get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LiveChatProvider result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Live Chat Provider</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LiveChatProvider getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LiveChatProvider result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Live Chat Provider</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LiveChatProvider get(int value) {
		switch (value) {
			case OLARK_VALUE: return OLARK;
			case LIVECHATINC_VALUE: return LIVECHATINC;
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

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private LiveChatProvider(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //LiveChatProvider
