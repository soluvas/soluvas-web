/**
 */
package org.soluvas.web.googleanalytics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.web.googleanalytics.GoogleAnalyticsManager;
import org.soluvas.web.googleanalytics.GoogleanalyticsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Google Analytics Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl#getTrackingId <em>Tracking Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GoogleAnalyticsManagerImpl extends EObjectImpl implements GoogleAnalyticsManager {
	/**
	 * The default value of the '{@link #getTrackingId() <em>Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrackingId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACKING_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrackingId() <em>Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrackingId()
	 * @generated
	 * @ordered
	 */
	protected String trackingId = TRACKING_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected GoogleAnalyticsManagerImpl() {
		throw new UnsupportedOperationException("Please use the constructor with arguments");
	}
	
	public GoogleAnalyticsManagerImpl(String trackingId) {
		super();
		this.trackingId = trackingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GoogleanalyticsPackage.Literals.GOOGLE_ANALYTICS_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GoogleanalyticsPackage.GOOGLE_ANALYTICS_MANAGER__TRACKING_ID:
				return getTrackingId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GoogleanalyticsPackage.GOOGLE_ANALYTICS_MANAGER__TRACKING_ID:
				return TRACKING_ID_EDEFAULT == null ? trackingId != null : !TRACKING_ID_EDEFAULT.equals(trackingId);
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
		result.append(" (trackingId: ");
		result.append(trackingId);
		result.append(')');
		return result.toString();
	}

} //GoogleAnalyticsManagerImpl
