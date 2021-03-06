/**
 */
package org.soluvas.web.site.compose;

import java.util.Collection;
import java.util.Comparator;

import org.osgi.framework.Bundle;

import com.google.common.base.Optional;


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
 *   <li>{@link org.soluvas.web.site.compose.LiveContributor#getLiveBundle <em>Live Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LiveContributor extends Contributor {
	
	public static final class PositionerComparator implements
			Comparator<LiveContributor> {
		@Override
		public int compare(LiveContributor arg0, LiveContributor arg1) {
			return Optional.fromNullable(arg0.getPositioner()).or(0)
					- Optional.fromNullable(arg1.getPositioner()).or(0);
		}
	}

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
	 * Returns the value of the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Live Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Live Bundle</em>' attribute.
	 * @see #setLiveBundle(Bundle)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveContributor_LiveBundle()
	 * @model dataType="org.soluvas.web.site.compose.Bundle" required="true" transient="true"
	 * @generated
	 */
	Bundle getLiveBundle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveContributor#getLiveBundle <em>Live Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Live Bundle</em>' attribute.
	 * @see #getLiveBundle()
	 * @generated
	 */
	void setLiveBundle(Bundle value);

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
	 * @model
	 * @generated
	 */
	void targetRemoved(LiveTarget target);

} // LiveContributor
