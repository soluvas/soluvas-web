/**
 */
package org.soluvas.web.site.compose.impl;

import org.apache.wicket.Page;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osgi.framework.Bundle;

import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.LiveTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Live Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveTargetImpl#getPageClass <em>Page Class</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveTargetImpl#getLiveBundle <em>Live Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiveTargetImpl extends TargetImpl implements LiveTarget {
	/**
	 * The cached value of the '{@link #getPageClass() <em>Page Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageClass()
	 * @generated
	 * @ordered
	 */
	protected Class<Page> pageClass;

	/**
	 * The default value of the '{@link #getLiveBundle() <em>Live Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiveBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle LIVE_BUNDLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLiveBundle() <em>Live Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiveBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle liveBundle = LIVE_BUNDLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.LIVE_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<Page> getPageClass() {
		return pageClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageClass(Class<Page> newPageClass) {
		Class<Page> oldPageClass = pageClass;
		pageClass = newPageClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_TARGET__PAGE_CLASS, oldPageClass, pageClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getLiveBundle() {
		return liveBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiveBundle(Bundle newLiveBundle) {
		Bundle oldLiveBundle = liveBundle;
		liveBundle = newLiveBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_TARGET__LIVE_BUNDLE, oldLiveBundle, liveBundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComposePackage.LIVE_TARGET__PAGE_CLASS:
				return getPageClass();
			case ComposePackage.LIVE_TARGET__LIVE_BUNDLE:
				return getLiveBundle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComposePackage.LIVE_TARGET__PAGE_CLASS:
				setPageClass((Class<Page>)newValue);
				return;
			case ComposePackage.LIVE_TARGET__LIVE_BUNDLE:
				setLiveBundle((Bundle)newValue);
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
			case ComposePackage.LIVE_TARGET__PAGE_CLASS:
				setPageClass((Class<Page>)null);
				return;
			case ComposePackage.LIVE_TARGET__LIVE_BUNDLE:
				setLiveBundle(LIVE_BUNDLE_EDEFAULT);
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
			case ComposePackage.LIVE_TARGET__PAGE_CLASS:
				return pageClass != null;
			case ComposePackage.LIVE_TARGET__LIVE_BUNDLE:
				return LIVE_BUNDLE_EDEFAULT == null ? liveBundle != null : !LIVE_BUNDLE_EDEFAULT.equals(liveBundle);
		}
		return super.eIsSet(featureID);
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
		result.append(" (pageClass: ");
		result.append(pageClass);
		result.append(", liveBundle: ");
		result.append(liveBundle);
		result.append(')');
		return result.toString();
	}

} //LiveTargetImpl
