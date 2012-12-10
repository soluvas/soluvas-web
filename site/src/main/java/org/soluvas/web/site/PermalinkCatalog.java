/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permalink Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.PermalinkCatalog#getPermalinks <em>Permalinks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getPermalinkCatalog()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface PermalinkCatalog extends SerializableEObject {
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
