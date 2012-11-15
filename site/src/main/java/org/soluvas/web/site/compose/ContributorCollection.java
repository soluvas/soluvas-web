/**
 */
package org.soluvas.web.site.compose;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contributor Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.ContributorCollection#getContributors <em>Contributors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getContributorCollection()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface ContributorCollection extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Contributors</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.compose.Contributor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributors</em>' containment reference list.
	 * @see org.soluvas.web.site.compose.ComposePackage#getContributorCollection_Contributors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contributor> getContributors();

} // ContributorCollection
