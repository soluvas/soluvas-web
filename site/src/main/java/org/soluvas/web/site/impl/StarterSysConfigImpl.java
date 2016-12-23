/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.MongoSysConfig;
import org.soluvas.commons.impl.GeneralSysConfigImpl;

import org.soluvas.web.site.GoogleAnalyticsSysConfig;
import org.soluvas.web.site.GoogleSysConfig;
import org.soluvas.web.site.SitePackage;
import org.soluvas.web.site.StarterSysConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Starter Sys Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleApiKey <em>Google Api Key</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleClientId <em>Google Client Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleClientSecret <em>Google Client Secret</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleVerifyId <em>Google Verify Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleAnalyticsEnabled <em>Google Analytics Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleAnalyticsTrackingId <em>Google Analytics Tracking Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getGoogleAnalyticsCookieDomain <em>Google Analytics Cookie Domain</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#isGoogleAnalyticsDisplayFeatures <em>Google Analytics Display Features</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.StarterSysConfigImpl#getMongoUri <em>Mongo Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StarterSysConfigImpl extends GeneralSysConfigImpl implements StarterSysConfig {
	/**
	 * The default value of the '{@link #getGoogleApiKey() <em>Google Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleApiKey()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_API_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleApiKey() <em>Google Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleApiKey()
	 * @generated
	 * @ordered
	 */
	protected String googleApiKey = GOOGLE_API_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleClientId() <em>Google Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleClientId()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_CLIENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleClientId() <em>Google Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleClientId()
	 * @generated
	 * @ordered
	 */
	protected String googleClientId = GOOGLE_CLIENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleClientSecret() <em>Google Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleClientSecret()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_CLIENT_SECRET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleClientSecret() <em>Google Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleClientSecret()
	 * @generated
	 * @ordered
	 */
	protected String googleClientSecret = GOOGLE_CLIENT_SECRET_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleVerifyId() <em>Google Verify Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleVerifyId()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_VERIFY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleVerifyId() <em>Google Verify Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleVerifyId()
	 * @generated
	 * @ordered
	 */
	protected String googleVerifyId = GOOGLE_VERIFY_ID_EDEFAULT;

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
	 * The default value of the '{@link #getMongoUri() <em>Mongo Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMongoUri()
	 * @generated
	 * @ordered
	 */
	protected static final String MONGO_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMongoUri() <em>Mongo Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMongoUri()
	 * @generated
	 * @ordered
	 */
	protected String mongoUri = MONGO_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StarterSysConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.STARTER_SYS_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleApiKey() {
		return googleApiKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleApiKey(String newGoogleApiKey) {
		String oldGoogleApiKey = googleApiKey;
		googleApiKey = newGoogleApiKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY, oldGoogleApiKey, googleApiKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleClientId() {
		return googleClientId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleClientId(String newGoogleClientId) {
		String oldGoogleClientId = googleClientId;
		googleClientId = newGoogleClientId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID, oldGoogleClientId, googleClientId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleClientSecret() {
		return googleClientSecret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleClientSecret(String newGoogleClientSecret) {
		String oldGoogleClientSecret = googleClientSecret;
		googleClientSecret = newGoogleClientSecret;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET, oldGoogleClientSecret, googleClientSecret));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleVerifyId() {
		return googleVerifyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleVerifyId(String newGoogleVerifyId) {
		String oldGoogleVerifyId = googleVerifyId;
		googleVerifyId = newGoogleVerifyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID, oldGoogleVerifyId, googleVerifyId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED, oldGoogleAnalyticsEnabled, googleAnalyticsEnabled));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID, oldGoogleAnalyticsTrackingId, googleAnalyticsTrackingId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN, oldGoogleAnalyticsCookieDomain, googleAnalyticsCookieDomain));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES, oldGoogleAnalyticsDisplayFeatures, googleAnalyticsDisplayFeatures, !oldGoogleAnalyticsDisplayFeaturesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES, oldGoogleAnalyticsDisplayFeatures, GOOGLE_ANALYTICS_DISPLAY_FEATURES_EDEFAULT, oldGoogleAnalyticsDisplayFeaturesESet));
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
	public String getMongoUri() {
		return mongoUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMongoUri(String newMongoUri) {
		String oldMongoUri = mongoUri;
		mongoUri = newMongoUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.STARTER_SYS_CONFIG__MONGO_URI, oldMongoUri, mongoUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY:
				return getGoogleApiKey();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID:
				return getGoogleClientId();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				return getGoogleClientSecret();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID:
				return getGoogleVerifyId();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				return getGoogleAnalyticsEnabled();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				return getGoogleAnalyticsTrackingId();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				return getGoogleAnalyticsCookieDomain();
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				return isGoogleAnalyticsDisplayFeatures();
			case SitePackage.STARTER_SYS_CONFIG__MONGO_URI:
				return getMongoUri();
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
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY:
				setGoogleApiKey((String)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID:
				setGoogleClientId((String)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				setGoogleClientSecret((String)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID:
				setGoogleVerifyId((String)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				setGoogleAnalyticsEnabled((Boolean)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				setGoogleAnalyticsTrackingId((String)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				setGoogleAnalyticsCookieDomain((String)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				setGoogleAnalyticsDisplayFeatures((Boolean)newValue);
				return;
			case SitePackage.STARTER_SYS_CONFIG__MONGO_URI:
				setMongoUri((String)newValue);
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
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY:
				setGoogleApiKey(GOOGLE_API_KEY_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID:
				setGoogleClientId(GOOGLE_CLIENT_ID_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				setGoogleClientSecret(GOOGLE_CLIENT_SECRET_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID:
				setGoogleVerifyId(GOOGLE_VERIFY_ID_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				setGoogleAnalyticsEnabled(GOOGLE_ANALYTICS_ENABLED_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				setGoogleAnalyticsTrackingId(GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				setGoogleAnalyticsCookieDomain(GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT);
				return;
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				unsetGoogleAnalyticsDisplayFeatures();
				return;
			case SitePackage.STARTER_SYS_CONFIG__MONGO_URI:
				setMongoUri(MONGO_URI_EDEFAULT);
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
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY:
				return GOOGLE_API_KEY_EDEFAULT == null ? googleApiKey != null : !GOOGLE_API_KEY_EDEFAULT.equals(googleApiKey);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID:
				return GOOGLE_CLIENT_ID_EDEFAULT == null ? googleClientId != null : !GOOGLE_CLIENT_ID_EDEFAULT.equals(googleClientId);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				return GOOGLE_CLIENT_SECRET_EDEFAULT == null ? googleClientSecret != null : !GOOGLE_CLIENT_SECRET_EDEFAULT.equals(googleClientSecret);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID:
				return GOOGLE_VERIFY_ID_EDEFAULT == null ? googleVerifyId != null : !GOOGLE_VERIFY_ID_EDEFAULT.equals(googleVerifyId);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED:
				return GOOGLE_ANALYTICS_ENABLED_EDEFAULT == null ? googleAnalyticsEnabled != null : !GOOGLE_ANALYTICS_ENABLED_EDEFAULT.equals(googleAnalyticsEnabled);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID:
				return GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT == null ? googleAnalyticsTrackingId != null : !GOOGLE_ANALYTICS_TRACKING_ID_EDEFAULT.equals(googleAnalyticsTrackingId);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN:
				return GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT == null ? googleAnalyticsCookieDomain != null : !GOOGLE_ANALYTICS_COOKIE_DOMAIN_EDEFAULT.equals(googleAnalyticsCookieDomain);
			case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES:
				return isSetGoogleAnalyticsDisplayFeatures();
			case SitePackage.STARTER_SYS_CONFIG__MONGO_URI:
				return MONGO_URI_EDEFAULT == null ? mongoUri != null : !MONGO_URI_EDEFAULT.equals(mongoUri);
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
		if (baseClass == GoogleSysConfig.class) {
			switch (derivedFeatureID) {
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY: return SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY;
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID: return SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID;
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET: return SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET;
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID: return SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID;
				default: return -1;
			}
		}
		if (baseClass == GoogleAnalyticsSysConfig.class) {
			switch (derivedFeatureID) {
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED: return SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED;
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID: return SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID;
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN: return SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN;
				case SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES: return SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == MongoSysConfig.class) {
			switch (derivedFeatureID) {
				case SitePackage.STARTER_SYS_CONFIG__MONGO_URI: return CommonsPackage.MONGO_SYS_CONFIG__MONGO_URI;
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
		if (baseClass == GoogleSysConfig.class) {
			switch (baseFeatureID) {
				case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_API_KEY;
				case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_ID;
				case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_CLIENT_SECRET;
				case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_VERIFY_ID;
				default: return -1;
			}
		}
		if (baseClass == GoogleAnalyticsSysConfig.class) {
			switch (baseFeatureID) {
				case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED;
				case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID;
				case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN;
				case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES: return SitePackage.STARTER_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == MongoSysConfig.class) {
			switch (baseFeatureID) {
				case CommonsPackage.MONGO_SYS_CONFIG__MONGO_URI: return SitePackage.STARTER_SYS_CONFIG__MONGO_URI;
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
		result.append(" (googleApiKey: ");
		result.append(googleApiKey);
		result.append(", googleClientId: ");
		result.append(googleClientId);
		result.append(", googleClientSecret: ");
		result.append(googleClientSecret);
		result.append(", googleVerifyId: ");
		result.append(googleVerifyId);
		result.append(", googleAnalyticsEnabled: ");
		result.append(googleAnalyticsEnabled);
		result.append(", googleAnalyticsTrackingId: ");
		result.append(googleAnalyticsTrackingId);
		result.append(", googleAnalyticsCookieDomain: ");
		result.append(googleAnalyticsCookieDomain);
		result.append(", googleAnalyticsDisplayFeatures: ");
		if (googleAnalyticsDisplayFeaturesESet) result.append(googleAnalyticsDisplayFeatures); else result.append("<unset>");
		result.append(", mongoUri: ");
		result.append(mongoUri);
		result.append(')');
		return result.toString();
	}

} //StarterSysConfigImpl
