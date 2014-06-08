/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.EntityKind;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get permalink URI relative to current website, no switch of HTTP(S) protocol.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String relative(EntityKind kind, String slugPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get absolute permalink URI, considering the recommended protocol for the entity show page, e.g. plain HTTP vs secure HTTPS.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String absolute(String webHost, EntityKind kind, String slugPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get absolute permalink URI, plain HTTP only.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String unsecureAbsolute(String webHost, EntityKind kind, String slugPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get absolute permalink URI, secure HTTPS.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String secureAbsolute(String webHost, EntityKind kind, String slugPath);

	/**
	 * @todo change to enum {@code PermalinkType} later, just like {@link ImageType}
	 */
	public static final String PRODUCT_TYPE = "product";

} // PermalinkManager
