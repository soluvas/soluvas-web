/**
 */
package org.soluvas.web.site.compose;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Placeholder Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.PlaceholderCollection#getPlaceholders <em>Placeholders</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getPlaceholderCollection()
 * @model
 * @generated
 */
public interface PlaceholderCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Placeholders</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.compose.Placeholder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placeholders</em>' containment reference list.
	 * @see org.soluvas.web.site.compose.ComposePackage#getPlaceholderCollection_Placeholders()
	 * @model containment="true"
	 * @generated
	 */
	EList<Placeholder> getPlaceholders();

} // PlaceholderCollection
