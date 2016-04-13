/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.SectionCollection#getSections <em>Sections</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getSectionCollection()
 * @model
 * @generated
 */
public interface SectionCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' containment reference list.
	 * @see org.soluvas.web.site.SitePackage#getSectionCollection_Sections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Section> getSections();

} // SectionCollection
