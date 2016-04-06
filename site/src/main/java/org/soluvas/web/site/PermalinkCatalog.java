/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permalink Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.PermalinkCatalog#getPermalinks <em>Permalinks</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getPermalinkCatalog()
 * @model
 * @generated
 */
public interface PermalinkCatalog extends EObject {
	/**
	 * Returns the value of the '<em><b>Permalinks</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.Permalink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permalinks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permalinks</em>' containment reference list.
	 * @see org.soluvas.web.site.SitePackage#getPermalinkCatalog_Permalinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Permalink> getPermalinks();

} // PermalinkCatalog
