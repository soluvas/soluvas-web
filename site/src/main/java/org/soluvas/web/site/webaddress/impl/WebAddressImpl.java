/**
 */
package org.soluvas.web.site.webaddress.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.webaddress.WebAddress;
import org.soluvas.web.site.webaddress.WebaddressPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getBaseUri <em>Base Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getBasePath <em>Base Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getApiPath <em>Api Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getImagesUri <em>Images Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getSkinUri <em>Skin Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getJsUri <em>Js Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getSecureBaseUri <em>Secure Base Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getSecureImagesUri <em>Secure Images Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getSecureSkinUri <em>Secure Skin Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl#getSecureJsUri <em>Secure Js Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebAddressImpl extends EObjectImpl implements WebAddress {
	/**
	 * The default value of the '{@link #getBaseUri() <em>Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUri()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseUri() <em>Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUri()
	 * @generated
	 * @ordered
	 */
	protected String baseUri = BASE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getBasePath() <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePath()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasePath() <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePath()
	 * @generated
	 * @ordered
	 */
	protected String basePath = BASE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getApiPath() <em>Api Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiPath()
	 * @generated
	 * @ordered
	 */
	protected static final String API_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApiPath() <em>Api Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiPath()
	 * @generated
	 * @ordered
	 */
	protected String apiPath = API_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getImagesUri() <em>Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagesUri()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGES_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImagesUri() <em>Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagesUri()
	 * @generated
	 * @ordered
	 */
	protected String imagesUri = IMAGES_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSkinUri() <em>Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkinUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SKIN_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSkinUri() <em>Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkinUri()
	 * @generated
	 * @ordered
	 */
	protected String skinUri = SKIN_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getJsUri() <em>Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsUri()
	 * @generated
	 * @ordered
	 */
	protected static final String JS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJsUri() <em>Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsUri()
	 * @generated
	 * @ordered
	 */
	protected String jsUri = JS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureBaseUri() <em>Secure Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureBaseUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_BASE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureBaseUri() <em>Secure Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureBaseUri()
	 * @generated
	 * @ordered
	 */
	protected String secureBaseUri = SECURE_BASE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureImagesUri() <em>Secure Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureImagesUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_IMAGES_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureImagesUri() <em>Secure Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureImagesUri()
	 * @generated
	 * @ordered
	 */
	protected String secureImagesUri = SECURE_IMAGES_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureSkinUri() <em>Secure Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureSkinUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_SKIN_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureSkinUri() <em>Secure Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureSkinUri()
	 * @generated
	 * @ordered
	 */
	protected String secureSkinUri = SECURE_SKIN_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureJsUri() <em>Secure Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureJsUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_JS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureJsUri() <em>Secure Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureJsUri()
	 * @generated
	 * @ordered
	 */
	protected String secureJsUri = SECURE_JS_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WebaddressPackage.Literals.WEB_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseUri() {
		return baseUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseUri(String newBaseUri) {
		String oldBaseUri = baseUri;
		baseUri = newBaseUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__BASE_URI, oldBaseUri, baseUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasePath() {
		return basePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasePath(String newBasePath) {
		String oldBasePath = basePath;
		basePath = newBasePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__BASE_PATH, oldBasePath, basePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiPath() {
		return apiPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiPath(String newApiPath) {
		String oldApiPath = apiPath;
		apiPath = newApiPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__API_PATH, oldApiPath, apiPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImagesUri() {
		return imagesUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImagesUri(String newImagesUri) {
		String oldImagesUri = imagesUri;
		imagesUri = newImagesUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__IMAGES_URI, oldImagesUri, imagesUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSkinUri() {
		return skinUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkinUri(String newSkinUri) {
		String oldSkinUri = skinUri;
		skinUri = newSkinUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__SKIN_URI, oldSkinUri, skinUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJsUri() {
		return jsUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJsUri(String newJsUri) {
		String oldJsUri = jsUri;
		jsUri = newJsUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__JS_URI, oldJsUri, jsUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecureBaseUri() {
		return secureBaseUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureBaseUri(String newSecureBaseUri) {
		String oldSecureBaseUri = secureBaseUri;
		secureBaseUri = newSecureBaseUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__SECURE_BASE_URI, oldSecureBaseUri, secureBaseUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecureImagesUri() {
		return secureImagesUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureImagesUri(String newSecureImagesUri) {
		String oldSecureImagesUri = secureImagesUri;
		secureImagesUri = newSecureImagesUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__SECURE_IMAGES_URI, oldSecureImagesUri, secureImagesUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecureSkinUri() {
		return secureSkinUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureSkinUri(String newSecureSkinUri) {
		String oldSecureSkinUri = secureSkinUri;
		secureSkinUri = newSecureSkinUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__SECURE_SKIN_URI, oldSecureSkinUri, secureSkinUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecureJsUri() {
		return secureJsUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureJsUri(String newSecureJsUri) {
		String oldSecureJsUri = secureJsUri;
		secureJsUri = newSecureJsUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebaddressPackage.WEB_ADDRESS__SECURE_JS_URI, oldSecureJsUri, secureJsUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WebaddressPackage.WEB_ADDRESS__BASE_URI:
				return getBaseUri();
			case WebaddressPackage.WEB_ADDRESS__BASE_PATH:
				return getBasePath();
			case WebaddressPackage.WEB_ADDRESS__API_PATH:
				return getApiPath();
			case WebaddressPackage.WEB_ADDRESS__IMAGES_URI:
				return getImagesUri();
			case WebaddressPackage.WEB_ADDRESS__SKIN_URI:
				return getSkinUri();
			case WebaddressPackage.WEB_ADDRESS__JS_URI:
				return getJsUri();
			case WebaddressPackage.WEB_ADDRESS__SECURE_BASE_URI:
				return getSecureBaseUri();
			case WebaddressPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				return getSecureImagesUri();
			case WebaddressPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				return getSecureSkinUri();
			case WebaddressPackage.WEB_ADDRESS__SECURE_JS_URI:
				return getSecureJsUri();
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
			case WebaddressPackage.WEB_ADDRESS__BASE_URI:
				setBaseUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__BASE_PATH:
				setBasePath((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__API_PATH:
				setApiPath((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__IMAGES_URI:
				setImagesUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__SKIN_URI:
				setSkinUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__JS_URI:
				setJsUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_BASE_URI:
				setSecureBaseUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				setSecureImagesUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				setSecureSkinUri((String)newValue);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_JS_URI:
				setSecureJsUri((String)newValue);
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
			case WebaddressPackage.WEB_ADDRESS__BASE_URI:
				setBaseUri(BASE_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__BASE_PATH:
				setBasePath(BASE_PATH_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__API_PATH:
				setApiPath(API_PATH_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__IMAGES_URI:
				setImagesUri(IMAGES_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__SKIN_URI:
				setSkinUri(SKIN_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__JS_URI:
				setJsUri(JS_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_BASE_URI:
				setSecureBaseUri(SECURE_BASE_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				setSecureImagesUri(SECURE_IMAGES_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				setSecureSkinUri(SECURE_SKIN_URI_EDEFAULT);
				return;
			case WebaddressPackage.WEB_ADDRESS__SECURE_JS_URI:
				setSecureJsUri(SECURE_JS_URI_EDEFAULT);
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
			case WebaddressPackage.WEB_ADDRESS__BASE_URI:
				return BASE_URI_EDEFAULT == null ? baseUri != null : !BASE_URI_EDEFAULT.equals(baseUri);
			case WebaddressPackage.WEB_ADDRESS__BASE_PATH:
				return BASE_PATH_EDEFAULT == null ? basePath != null : !BASE_PATH_EDEFAULT.equals(basePath);
			case WebaddressPackage.WEB_ADDRESS__API_PATH:
				return API_PATH_EDEFAULT == null ? apiPath != null : !API_PATH_EDEFAULT.equals(apiPath);
			case WebaddressPackage.WEB_ADDRESS__IMAGES_URI:
				return IMAGES_URI_EDEFAULT == null ? imagesUri != null : !IMAGES_URI_EDEFAULT.equals(imagesUri);
			case WebaddressPackage.WEB_ADDRESS__SKIN_URI:
				return SKIN_URI_EDEFAULT == null ? skinUri != null : !SKIN_URI_EDEFAULT.equals(skinUri);
			case WebaddressPackage.WEB_ADDRESS__JS_URI:
				return JS_URI_EDEFAULT == null ? jsUri != null : !JS_URI_EDEFAULT.equals(jsUri);
			case WebaddressPackage.WEB_ADDRESS__SECURE_BASE_URI:
				return SECURE_BASE_URI_EDEFAULT == null ? secureBaseUri != null : !SECURE_BASE_URI_EDEFAULT.equals(secureBaseUri);
			case WebaddressPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				return SECURE_IMAGES_URI_EDEFAULT == null ? secureImagesUri != null : !SECURE_IMAGES_URI_EDEFAULT.equals(secureImagesUri);
			case WebaddressPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				return SECURE_SKIN_URI_EDEFAULT == null ? secureSkinUri != null : !SECURE_SKIN_URI_EDEFAULT.equals(secureSkinUri);
			case WebaddressPackage.WEB_ADDRESS__SECURE_JS_URI:
				return SECURE_JS_URI_EDEFAULT == null ? secureJsUri != null : !SECURE_JS_URI_EDEFAULT.equals(secureJsUri);
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
		result.append(" (baseUri: ");
		result.append(baseUri);
		result.append(", basePath: ");
		result.append(basePath);
		result.append(", apiPath: ");
		result.append(apiPath);
		result.append(", imagesUri: ");
		result.append(imagesUri);
		result.append(", skinUri: ");
		result.append(skinUri);
		result.append(", jsUri: ");
		result.append(jsUri);
		result.append(", secureBaseUri: ");
		result.append(secureBaseUri);
		result.append(", secureImagesUri: ");
		result.append(secureImagesUri);
		result.append(", secureSkinUri: ");
		result.append(secureSkinUri);
		result.append(", secureJsUri: ");
		result.append(secureJsUri);
		result.append(')');
		return result.toString();
	}

} //WebAddressImpl
