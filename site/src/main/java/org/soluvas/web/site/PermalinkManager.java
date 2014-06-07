/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.image.ImageType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permalink Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.web.site.SitePackage#getPermalinkManager()
 * @model
 * @generated
 */
public interface PermalinkManager extends EObject {
	
	/**
	 * @todo change to enum {@code PermalinkType} later, just like {@link ImageType}
	 */
	public static final String PRODUCT_TYPE = "product";
	
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
