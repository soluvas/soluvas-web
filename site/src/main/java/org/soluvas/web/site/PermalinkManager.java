/**
 */
package org.soluvas.web.site;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permalink Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.web.site.SitePackage#getPermalinkManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface PermalinkManager extends SerializableEObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get permalink URI relative to current website.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String relative(String namespace, String slugPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get absolute permalink URI, considering plain HTTP vs secure HTTPS.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String absolute(String namespace, String slugPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get absolute permalink URI, plain HTTP only.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String unsecureAbsolute(String namespace, String slugPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get absolute permalink URI, secure HTTPS.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String secureAbsolute(String namespace, String slugPath);

} // PermalinkManager
