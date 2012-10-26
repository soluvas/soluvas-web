/**
 */
package org.soluvas.web.banner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Image Base</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.banner.BannerPackage#getImageBase()
 * @model
 * @generated
 */
public enum ImageBase implements Enumerator {
	/**
	 * The '<em><b>Absolute</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_VALUE
	 * @generated
	 * @ordered
	 */
	ABSOLUTE(0, "absolute", "absolute"),

	/**
	 * The '<em><b>Images</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMAGES_VALUE
	 * @generated
	 * @ordered
	 */
	IMAGES(1, "images", "images");

	/**
	 * The '<em><b>Absolute</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Provided Image URI is an absolute URI.
	 * <!-- end-model-doc -->
	 * @see #ABSOLUTE
	 * @model name="absolute"
	 * @generated
	 * @ordered
	 */
	public static final int ABSOLUTE_VALUE = 0;

	/**
	 * The '<em><b>Images</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Provided Image URI is an relative path to site's Images URI.
	 * <!-- end-model-doc -->
	 * @see #IMAGES
	 * @model name="images"
	 * @generated
	 * @ordered
	 */
	public static final int IMAGES_VALUE = 1;

	/**
	 * An array of all the '<em><b>Image Base</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImageBase[] VALUES_ARRAY =
		new ImageBase[] {
			ABSOLUTE,
			IMAGES,
		};

	/**
	 * A public read-only list of all the '<em><b>Image Base</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImageBase> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Image Base</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImageBase get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImageBase result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Image Base</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImageBase getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImageBase result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Image Base</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImageBase get(int value) {
		switch (value) {
			case ABSOLUTE_VALUE: return ABSOLUTE;
			case IMAGES_VALUE: return IMAGES;
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
	private ImageBase(int value, String name, String literal) {
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
	
} //ImageBase
