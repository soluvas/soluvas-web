/**
 */
package org.soluvas.web.site.compose;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Contributor Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Used to inspect the live state of contributors.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.LiveContributorCollection#getLiveContributors <em>Live Contributors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributorCollection()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface LiveContributorCollection extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Live Contributors</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.web.site.compose.LiveContributor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Live Contributors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Live Contributors</em>' reference list.
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributorCollection_LiveContributors()
	 * @model
	 * @generated
	 */
	EList<LiveContributor> getLiveContributors();

} // LiveContributorCollection
