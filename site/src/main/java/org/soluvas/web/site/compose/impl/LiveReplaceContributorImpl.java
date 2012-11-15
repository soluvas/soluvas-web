/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osgi.framework.Bundle;
import org.soluvas.web.site.ComponentFactory;

import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.ContributorState;
import org.soluvas.web.site.compose.LiveComponentContributor;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.LiveReplaceContributor;
import org.soluvas.web.site.compose.LiveSlave;
import org.soluvas.web.site.compose.LiveTarget;
import org.soluvas.web.site.compose.PlaceholderCollection;
import org.soluvas.web.site.compose.SlaveCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Live Replace Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl#getState <em>State</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl#getSlave <em>Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiveReplaceContributorImpl extends ReplaceContributorImpl implements LiveReplaceContributor {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ContributorState STATE_EDEFAULT = ContributorState.UNRESOLVED;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ContributorState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSlave() <em>Slave</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlave()
	 * @generated
	 * @ordered
	 */
	protected LiveSlave slave;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveReplaceContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.LIVE_REPLACE_CONTRIBUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContributorState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ContributorState newState) {
		ContributorState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentFactory getFactory() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveSlave getSlave() {
		if (slave != null && ((EObject)slave).eIsProxy()) {
			InternalEObject oldSlave = (InternalEObject)slave;
			slave = (LiveSlave)eResolveProxy(oldSlave);
			if (slave != oldSlave) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE, oldSlave, slave));
			}
		}
		return slave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveSlave basicGetSlave() {
		return slave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlave(LiveSlave newSlave) {
		LiveSlave oldSlave = slave;
		slave = newSlave;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE, oldSlave, slave));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void resolve(Collection<LivePlaceholder> placeholders, Collection<LiveSlave> slaves) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void bundleAdded(Bundle bundle) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void targetRemoved(LiveTarget target) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void bundleRemoved(Bundle bundle) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				return getState();
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE:
				return getBundle();
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				if (resolve) return getSlave();
				return basicGetSlave();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				setState((ContributorState)newValue);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				setSlave((LiveSlave)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				setState(STATE_EDEFAULT);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				setSlave((LiveSlave)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				return state != STATE_EDEFAULT;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				return slave != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == LiveContributor.class) {
			switch (derivedFeatureID) {
				case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE: return ComposePackage.LIVE_CONTRIBUTOR__STATE;
				case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE: return ComposePackage.LIVE_CONTRIBUTOR__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == LiveComponentContributor.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == LiveContributor.class) {
			switch (baseFeatureID) {
				case ComposePackage.LIVE_CONTRIBUTOR__STATE: return ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE;
				case ComposePackage.LIVE_CONTRIBUTOR__BUNDLE: return ComposePackage.LIVE_REPLACE_CONTRIBUTOR__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == LiveComponentContributor.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (state: ");
		result.append(state);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(')');
		return result.toString();
	}

} //LiveReplaceContributorImpl
