/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.OpenGraphVideo;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Graph Video</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphVideoImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphVideoImpl#getSecureUrl <em>Secure Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphVideoImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphVideoImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphVideoImpl#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenGraphVideoImpl extends EObjectImpl implements OpenGraphVideo {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureUrl() <em>Secure Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureUrl() <em>Secure Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureUrl()
	 * @generated
	 * @ordered
	 */
	protected String secureUrl = SECURE_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected Integer width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final Integer HEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected Integer height = HEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphVideoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.OPEN_GRAPH_VIDEO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_VIDEO__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecureUrl() {
		return secureUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecureUrl(String newSecureUrl) {
		String oldSecureUrl = secureUrl;
		secureUrl = newSecureUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_VIDEO__SECURE_URL, oldSecureUrl, secureUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_VIDEO__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(Integer newWidth) {
		Integer oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_VIDEO__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(Integer newHeight) {
		Integer oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_VIDEO__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.OPEN_GRAPH_VIDEO__URL:
				return getUrl();
			case SitePackage.OPEN_GRAPH_VIDEO__SECURE_URL:
				return getSecureUrl();
			case SitePackage.OPEN_GRAPH_VIDEO__TYPE:
				return getType();
			case SitePackage.OPEN_GRAPH_VIDEO__WIDTH:
				return getWidth();
			case SitePackage.OPEN_GRAPH_VIDEO__HEIGHT:
				return getHeight();
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
			case SitePackage.OPEN_GRAPH_VIDEO__URL:
				setUrl((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__SECURE_URL:
				setSecureUrl((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__TYPE:
				setType((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__WIDTH:
				setWidth((Integer)newValue);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__HEIGHT:
				setHeight((Integer)newValue);
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
			case SitePackage.OPEN_GRAPH_VIDEO__URL:
				setUrl(URL_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__SECURE_URL:
				setSecureUrl(SECURE_URL_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_VIDEO__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
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
			case SitePackage.OPEN_GRAPH_VIDEO__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case SitePackage.OPEN_GRAPH_VIDEO__SECURE_URL:
				return SECURE_URL_EDEFAULT == null ? secureUrl != null : !SECURE_URL_EDEFAULT.equals(secureUrl);
			case SitePackage.OPEN_GRAPH_VIDEO__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SitePackage.OPEN_GRAPH_VIDEO__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case SitePackage.OPEN_GRAPH_VIDEO__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
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
		result.append(" (url: ");
		result.append(url);
		result.append(", secureUrl: ");
		result.append(secureUrl);
		result.append(", type: ");
		result.append(type);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //OpenGraphVideoImpl
