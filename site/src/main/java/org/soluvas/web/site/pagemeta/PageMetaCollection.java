/**
 */
package org.soluvas.web.site.pagemeta;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMetaCollection#getPageMetas <em>Page Metas</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMetaCollection()
 * @model
 * @generated
 */
public interface PageMetaCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Page Metas</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.pagemeta.PageMeta}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Metas</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Metas</em>' containment reference list.
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMetaCollection_PageMetas()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageMeta> getPageMetas();

} // PageMetaCollection
