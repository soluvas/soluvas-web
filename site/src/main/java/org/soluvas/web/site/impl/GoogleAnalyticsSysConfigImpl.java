/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.GoogleAnalyticsSysConfig;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Google Analytics Sys Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.GoogleAnalyticsSysConfigImpl#getGoogleAnalyticsEnabled <em>Google Analytics Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleAnalyticsSysConfigImpl#getGoogleAnalyticsTrackingId <em>Google Analytics Tracking Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleAnalyticsSysConfigImpl#getGoogleAnalyticsCookieDomain <em>Google Analytics Cookie Domain</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleAnalyticsSysConfigImpl#isGoogleAnalyticsDisplayFeatures <em>Google Analytics Display Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoogleAnalyticsSysConfigImpl extends EObjectImpl implements GoogleAnalyticsSysConfig {
	/**
	 * The default value of the '{@link #getGoogleAnalyticsEnabled() <em>Google Analytics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleAnalyticsEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean GOOGLE_ANALYTICS_ENABLED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getGoogleAnalyticsEnabled() <em>Google Analytics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleAnalyticsEnabled()
	 * @generated
	 * @ordered
	 */
	protected Boolean googleAnalyticsEnabled = GOOGLE_ANALYTICS_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleAnalyticsTrackingId() <em>Google Analytics Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleAnalyticsTrackingId()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleAnalyticsTrackingId() <em>Google Analytics Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleAnalyticsTrackingId()
	 * @generated
	 * @ordered
	 */
	protected String googleAnalyticsTrackingId = GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleAnalyticsCookieDomain() <em>Google Analytics Cookie Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleAnalyticsCookieDomain()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleAnalyticsCookieDomain() <em>Google Analytics Cookie Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleAnalyticsCookieDomain()
	 * @generated
	 * @ordered
	 */
	protected String googleAnalyticsCookieDomain = GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #isGoogleAnalyticsDisplayFeatures() <em>Google Analytics Display Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGoogleAnalyticsDisplayFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GOOGLE_ANALYTICS_DISPLAY_FEATURES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGoogleAnalyticsDisplayFeatures() <em>Google Analytics Display Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGoogleAnalyticsDisplayFeatures()
	 * @generated
	 * @ordered
	 */
	protected boolean googleAnalyticsDisplayFeatures = GOOGLE_ANALYTICS_DISPLAY_FEATURES_EDEFAULT;

	/**
	 * This is true if the Google Analytics Display Features attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean googleAnalyticsDisplayFeaturesESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleAnalyticsSysConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.GOOGLE_ANALYTICS_SYS_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getGoogleAnalyticsEnabled() {
		return googleAnalyticsEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleAnalyticsEnabled(Boolean newGoogleAnalyticsEnabled) {
		Boolean oldGoogleAnalyticsEnabled = googleAnalyticsEnabled;
		googleAnalyticsEnabled = newGoogleAnalyticsEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED, oldGoogleAnalyticsEnabled, googleAnalyticsEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleAnalyticsTrackingId() {
		return googleAnalyticsTrackingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleAnalyticsTrackingId(String newGoogleAnalyticsTrackingId) {
		String oldGoogleAnalyticsTrackingId = googleAnalyticsTrackingId;
		googleAnalyticsTrackingId = newGoogleAnalyticsTrackingId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID, oldGoogleAnalyticsTrackingId, googleAnalyticsTrackingId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleAnalyticsCookieDomain() {
		return googleAnalyticsCookieDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleAnalyticsCookieDomain(String newGoogleAnalyticsCookieDomain) {
		String oldGoogleAnalyticsCookieDomain = googleAnalyticsCookieDomain;
		googleAnalyticsCookieDomain = newGoogleAnalyticsCookieDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN, oldGoogleAnalyticsCookieDomain, googleAnalyticsCookieDomain));
	}

	@Override
	public Boolean getGoogleAnalyticsDisplayFeatures() {
		return isGoogleAnalyticsDisplayFeatures();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGoogleAnalyticsDisplayFeatures() {
		return googleAnalyticsDisplayFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleAnalyticsDisplayFeatures(boolean newGoogleAnalyticsDisplayFeatures) {
		boolean oldGoogleAnalyticsDisplayFeatures = googleAnalyticsDisplayFeatures;
		googleAnalyticsDisplayFeatures = newGoogleAnalyticsDisplayFeatures;
		boolean oldGoogleAnalyticsDisplayFeaturesESet = googleAnalyticsDisplayFeaturesESet;
		googleAnalyticsDisplayFeaturesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES, oldGoogleAnalyticsDisplayFeatures, googleAnalyticsDisplayFeatures, !oldGoogleAnalyticsDisplayFeaturesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGoogleAnalyticsDisplayFeatures() {
		boolean oldGoogleAnalyticsDisplayFeatures = googleAnalyticsDisplayFeatures;
		boolean oldGoogleAnalyticsDisplayFeaturesESet = googleAnalyticsDisplayFeaturesESet;
		googleAnalyticsDisplayFeatures = GOOGLE_ANALYTICS_DISPLAY_FEATURES_EDEFAULT;
		googleAnalyticsDisplayFeaturesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES, oldGoogleAnalyticsDisplayFeatures, GOOGLE_ANALYTICS_DISPLAY_FEATURES_EDEFAULT, oldGoogleAnalyticsDisplayFeaturesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGoogleAnalyticsDisplayFeatures() {
		return googleAnalyticsDisplayFeaturesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				return getGoogleAnalyticsEnabled();
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				return getGoogleAnalyticsTrackingId();
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				return getGoogleAnalyticsCookieDomain();
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				return isGoogleAnalyticsDisplayFeatures();
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
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				setGoogleAnalyticsEnabled((Boolean)newValue);
				return;
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				setGoogleAnalyticsTrackingId((String)newValue);
				return;
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				setGoogleAnalyticsCookieDomain((String)newValue);
				return;
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				setGoogleAnalyticsDisplayFeatures((Boolean)newValue);
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
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				setGoogleAnalyticsEnabled(GOOGLE_ANALYTICS_ENABLED_EDEFAULT);
				return;
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				setGoogleAnalyticsTrackingId(GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT);
				return;
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				setGoogleAnalyticsCookieDomain(GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT);
				return;
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				unsetGoogleAnalyticsDisplayFeatures();
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
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				return GOOGLE_ANALYTICS_ENABLED_EDEFAULT == null ? googleAnalyticsEnabled != null : !GOOGLE_ANALYTICS_ENABLED_EDEFAULT.equals(googleAnalyticsEnabled);
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				return GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT == null ? googleAnalyticsTrackingId != null : !GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT.equals(googleAnalyticsTrackingId);
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				return GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT == null ? googleAnalyticsCookieDomain != null : !GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT.equals(googleAnalyticsCookieDomain);
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				return isSetGoogleAnalyticsDisplayFeatures();
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
		result.append(" (googleAnalyticsEnabled: ");
		result.append(googleAnalyticsEnabled);
		result.append(", googleAnalyticsTrackingId: ");
		result.append(googleAnalyticsTrackingId);
		result.append(", googleAnalyticsCookieDomain: ");
		result.append(googleAnalyticsCookieDomain);
		result.append(", googleAnalyticsDisplayFeatures: ");
		if (googleAnalyticsDisplayFeaturesESet) result.append(googleAnalyticsDisplayFeatures); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //GoogleAnalyticsSysConfigImpl
