/**
 */
package org.soluvas.web.site.compose;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Creation Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * How to create ComponentContributor.
 * <!-- end-model-doc -->
 * @see org.soluvas.web.site.compose.ComposePackage#getCreationMode()
 * @model
 * @generated
 */
public enum CreationMode implements Enumerator {
	/**
	 * The '<em><b>Constructor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTRUCTOR(0, "constructor", "constructor"),

	/**
	 * The '<em><b>Factory class</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACTORY_CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	FACTORY_CLASS(1, "factory_class", "factory_class"),

	/**
	 * The '<em><b>Factory bean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACTORY_BEAN_VALUE
	 * @generated
	 * @ordered
	 */
	FACTORY_BEAN(2, "factory_bean", "factory_bean");

	/**
	 * The '<em><b>Constructor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Constructor</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTRUCTOR
	 * @model name="constructor"
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRUCTOR_VALUE = 0;

	/**
	 * The '<em><b>Factory class</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Factory class</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACTORY_CLASS
	 * @model name="factory_class"
	 * @generated
	 * @ordered
	 */
	public static final int FACTORY_CLASS_VALUE = 1;

	/**
	 * The '<em><b>Factory bean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Factory bean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACTORY_BEAN
	 * @model name="factory_bean"
	 * @generated
	 * @ordered
	 */
	public static final int FACTORY_BEAN_VALUE = 2;

	/**
	 * An array of all the '<em><b>Creation Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CreationMode[] VALUES_ARRAY =
		new CreationMode[] {
			CONSTRUCTOR,
			FACTORY_CLASS,
			FACTORY_BEAN,
		};

	/**
	 * A public read-only list of all the '<em><b>Creation Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CreationMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Creation Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CreationMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CreationMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Creation Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CreationMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CreationMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Creation Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CreationMode get(int value) {
		switch (value) {
			case CONSTRUCTOR_VALUE: return CONSTRUCTOR;
			case FACTORY_CLASS_VALUE: return FACTORY_CLASS;
			case FACTORY_BEAN_VALUE: return FACTORY_BEAN;
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
	private CreationMode(int value, String name, String literal) {
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
	
} //CreationMode
