/**
 */
package org.soluvas.web.site.compose;

import java.util.Collection;
import java.util.List;
import org.osgi.framework.Bundle;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Runtime state, if state is resolved then it is resolved with actual Page class and Factory instance.
 * Otherwise it may be unresolved or partially resolved.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.LiveContributor#getState <em>State</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.LiveContributor#getBundle <em>Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LiveContributor extends Contributor {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.web.site.compose.ContributorState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.soluvas.web.site.compose.ContributorState
	 * @see #setState(ContributorState)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributor_State()
	 * @model required="true"
	 * @generated
	 */
	ContributorState getState();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveContributor#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.soluvas.web.site.compose.ContributorState
	 * @see #getState()
	 * @generated
	 */
	void setState(ContributorState value);

	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(Bundle)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributor_Bundle()
	 * @model dataType="org.soluvas.web.site.compose.Bundle" required="true" transient="true"
	 * @generated
	 */
	Bundle getBundle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveContributor#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(Bundle value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model placeholdersDataType="org.soluvas.web.site.compose.Collection<org.soluvas.web.site.compose.LivePlaceholder>" slavesDataType="org.soluvas.web.site.compose.Collection<org.soluvas.web.site.compose.LiveSlave>"
	 * @generated
	 */
	void resolve(Collection<LivePlaceholder> placeholders, Collection<LiveSlave> slaves);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model bundleDataType="org.soluvas.web.site.compose.Bundle"
	 * @generated
	 */
	void bundleAdded(Bundle bundle);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void targetRemoved(LiveTarget target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model bundleDataType="org.soluvas.web.site.compose.Bundle"
	 * @generated
	 */
	void bundleRemoved(Bundle bundle);

} // LiveContributor
