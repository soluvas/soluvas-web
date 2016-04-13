/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.GoogleSysConfig;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Google Sys Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.GoogleSysConfigImpl#getGoogleApiKey <em>Google Api Key</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleSysConfigImpl#getGoogleClientId <em>Google Client Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleSysConfigImpl#getGoogleClientSecret <em>Google Client Secret</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleSysConfigImpl#getGoogleVerifyId <em>Google Verify Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoogleSysConfigImpl extends EObjectImpl implements GoogleSysConfig {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleSysConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.GOOGLE_SYS_CONFIG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY, oldGoogleApiKey, googleApiKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID, oldGoogleClientId, googleClientId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET, oldGoogleClientSecret, googleClientSecret));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID, oldGoogleVerifyId, googleVerifyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY:
				return getGoogleApiKey();
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID:
				return getGoogleClientId();
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				return getGoogleClientSecret();
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID:
				return getGoogleVerifyId();
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
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY:
				setGoogleApiKey((String)newValue);
				return;
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID:
				setGoogleClientId((String)newValue);
				return;
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				setGoogleClientSecret((String)newValue);
				return;
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID:
				setGoogleVerifyId((String)newValue);
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
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY:
				setGoogleApiKey(GOOGLE_API_KEY_EDEFAULT);
				return;
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID:
				setGoogleClientId(GOOGLE_CLIENT_ID_EDEFAULT);
				return;
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				setGoogleClientSecret(GOOGLE_CLIENT_SECRET_EDEFAULT);
				return;
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID:
				setGoogleVerifyId(GOOGLE_VERIFY_ID_EDEFAULT);
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
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_API_KEY:
				return GOOGLE_API_KEY_EDEFAULT == null ? googleApiKey != null : !GOOGLE_API_KEY_EDEFAULT.equals(googleApiKey);
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID:
				return GOOGLE_CLIENT_ID_EDEFAULT == null ? googleClientId != null : !GOOGLE_CLIENT_ID_EDEFAULT.equals(googleClientId);
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET:
				return GOOGLE_CLIENT_SECRET_EDEFAULT == null ? googleClientSecret != null : !GOOGLE_CLIENT_SECRET_EDEFAULT.equals(googleClientSecret);
			case SitePackage.GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID:
				return GOOGLE_VERIFY_ID_EDEFAULT == null ? googleVerifyId != null : !GOOGLE_VERIFY_ID_EDEFAULT.equals(googleVerifyId);
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
		result.append(" (googleApiKey: ");
		result.append(googleApiKey);
		result.append(", googleClientId: ");
		result.append(googleClientId);
		result.append(", googleClientSecret: ");
		result.append(googleClientSecret);
		result.append(", googleVerifyId: ");
		result.append(googleVerifyId);
		result.append(')');
		return result.toString();
	}

} //GoogleSysConfigImpl
