/**
 */
package org.soluvas.web.site;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Java Script Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.SitePackage#getJavaScriptMode()
 * @model
 * @generated
 */
public enum JavaScriptMode implements Enumerator {
	/**
	 * The '<em><b>Development</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEVELOPMENT_VALUE
	 * @generated
	 * @ordered
	 */
	DEVELOPMENT(0, "development", "development"),

	/**
	 * The '<em><b>Minified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	MINIFIED(1, "minified", "minified"),

	/**
	 * The '<em><b>Aggregated minified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGGREGATED_MINIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	AGGREGATED_MINIFIED(2, "aggregated_minified", "aggregated_minified");

	/**
	 * The '<em><b>Development</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Use original JS.
	 * <!-- end-model-doc -->
	 * @see #DEVELOPMENT
	 * @model name="development"
	 * @generated
	 * @ordered
	 */
	public static final int DEVELOPMENT_VALUE = 0;

	/**
	 * The '<em><b>Minified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Use minified JS.
	 * <!-- end-model-doc -->
	 * @see #MINIFIED
	 * @model name="minified"
	 * @generated
	 * @ordered
	 */
	public static final int MINIFIED_VALUE = 1;

	/**
	 * The '<em><b>Aggregated minified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Aggregate all JavaScript, then minify it.
	 * <!-- end-model-doc -->
	 * @see #AGGREGATED_MINIFIED
	 * @model name="aggregated_minified"
	 * @generated
	 * @ordered
	 */
	public static final int AGGREGATED_MINIFIED_VALUE = 2;

	/**
	 * An array of all the '<em><b>Java Script Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JavaScriptMode[] VALUES_ARRAY =
		new JavaScriptMode[] {
			DEVELOPMENT,
			MINIFIED,
			AGGREGATED_MINIFIED,
		};

	/**
	 * A public read-only list of all the '<em><b>Java Script Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JavaScriptMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Java Script Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaScriptMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JavaScriptMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Java Script Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaScriptMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JavaScriptMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Java Script Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaScriptMode get(int value) {
		switch (value) {
			case DEVELOPMENT_VALUE: return DEVELOPMENT;
			case MINIFIED_VALUE: return MINIFIED;
			case AGGREGATED_MINIFIED_VALUE: return AGGREGATED_MINIFIED;
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
	private JavaScriptMode(int value, String name, String literal) {
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
	
} //JavaScriptMode
