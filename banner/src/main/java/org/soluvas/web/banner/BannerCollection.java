/**
 */
package org.soluvas.web.banner;

import java.io.Serializable;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.banner.BannerCollection#getBanners <em>Banners</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.banner.BannerPackage#getBannerCollection()
 * @model interface="true" abstract="true"
 */
public interface BannerCollection extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Banners</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.banner.Banner}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Banners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Banners</em>' containment reference list.
	 * @see org.soluvas.web.banner.BannerPackage#getBannerCollection_Banners()
	 * @model containment="true"
	 * @generated
	 */
	EList<Banner> getBanners();

} // BannerCollection
