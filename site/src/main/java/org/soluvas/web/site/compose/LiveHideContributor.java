/**
 */
package org.soluvas.web.site.compose;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Hide Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.LiveHideContributor#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveHideContributor()
 * @model
 * @generated
 */
public interface LiveHideContributor extends LiveContributor, HideContributor {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(LiveTarget)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveHideContributor_Target()
	 * @model
	 * @generated
	 */
	LiveTarget getTarget();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveHideContributor#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(LiveTarget value);

} // LiveHideContributor
