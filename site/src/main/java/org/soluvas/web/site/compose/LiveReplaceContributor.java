/**
 */
package org.soluvas.web.site.compose;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Replace Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.LiveReplaceContributor#getSlave <em>Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveReplaceContributor()
 * @model
 * @generated
 */
public interface LiveReplaceContributor extends ReplaceContributor, LiveComponentContributor {
	/**
	 * Returns the value of the '<em><b>Slave</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slave</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slave</em>' reference.
	 * @see #setSlave(LiveSlave)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveReplaceContributor_Slave()
	 * @model
	 * @generated
	 */
	LiveSlave getSlave();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveReplaceContributor#getSlave <em>Slave</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slave</em>' reference.
	 * @see #getSlave()
	 * @generated
	 */
	void setSlave(LiveSlave value);

} // LiveReplaceContributor
