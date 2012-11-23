/**
 */
package org.soluvas.web.site.pagemeta.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PagemetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Icon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getFaviconUri <em>Favicon Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon57Uri <em>Icon57 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon72Uri <em>Icon72 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon114Uri <em>Icon114 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon144Uri <em>Icon144 Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageIconImpl extends EObjectImpl implements PageIcon {
	/**
	 * The default value of the '{@link #getFaviconUri() <em>Favicon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaviconUri()
	 * @generated
	 * @ordered
	 */
	protected static final String FAVICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaviconUri() <em>Favicon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaviconUri()
	 * @generated
	 * @ordered
	 */
	protected String faviconUri = FAVICON_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon57Uri() <em>Icon57 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon57Uri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON57_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon57Uri() <em>Icon57 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon57Uri()
	 * @generated
	 * @ordered
	 */
	protected String icon57Uri = ICON57_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon72Uri() <em>Icon72 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon72Uri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON72_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon72Uri() <em>Icon72 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon72Uri()
	 * @generated
	 * @ordered
	 */
	protected String icon72Uri = ICON72_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon114Uri() <em>Icon114 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon114Uri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON114_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon114Uri() <em>Icon114 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon114Uri()
	 * @generated
	 * @ordered
	 */
	protected String icon114Uri = ICON114_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon144Uri() <em>Icon144 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon144Uri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON144_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon144Uri() <em>Icon144 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon144Uri()
	 * @generated
	 * @ordered
	 */
	protected String icon144Uri = ICON144_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageIconImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PagemetaPackage.Literals.PAGE_ICON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaviconUri() {
		return faviconUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaviconUri(String newFaviconUri) {
		String oldFaviconUri = faviconUri;
		faviconUri = newFaviconUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__FAVICON_URI, oldFaviconUri, faviconUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon57Uri() {
		return icon57Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon57Uri(String newIcon57Uri) {
		String oldIcon57Uri = icon57Uri;
		icon57Uri = newIcon57Uri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON57_URI, oldIcon57Uri, icon57Uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon72Uri() {
		return icon72Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon72Uri(String newIcon72Uri) {
		String oldIcon72Uri = icon72Uri;
		icon72Uri = newIcon72Uri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON72_URI, oldIcon72Uri, icon72Uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon114Uri() {
		return icon114Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon114Uri(String newIcon114Uri) {
		String oldIcon114Uri = icon114Uri;
		icon114Uri = newIcon114Uri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON114_URI, oldIcon114Uri, icon114Uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon144Uri() {
		return icon144Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon144Uri(String newIcon144Uri) {
		String oldIcon144Uri = icon144Uri;
		icon144Uri = newIcon144Uri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON144_URI, oldIcon144Uri, icon144Uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				return getFaviconUri();
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				return getIcon57Uri();
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				return getIcon72Uri();
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				return getIcon114Uri();
			case PagemetaPackage.PAGE_ICON__ICON144_URI:
				return getIcon144Uri();
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
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				setFaviconUri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				setIcon57Uri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				setIcon72Uri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				setIcon114Uri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON144_URI:
				setIcon144Uri((String)newValue);
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
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				setFaviconUri(FAVICON_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				setIcon57Uri(ICON57_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				setIcon72Uri(ICON72_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				setIcon114Uri(ICON114_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON144_URI:
				setIcon144Uri(ICON144_URI_EDEFAULT);
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
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				return FAVICON_URI_EDEFAULT == null ? faviconUri != null : !FAVICON_URI_EDEFAULT.equals(faviconUri);
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				return ICON57_URI_EDEFAULT == null ? icon57Uri != null : !ICON57_URI_EDEFAULT.equals(icon57Uri);
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				return ICON72_URI_EDEFAULT == null ? icon72Uri != null : !ICON72_URI_EDEFAULT.equals(icon72Uri);
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				return ICON114_URI_EDEFAULT == null ? icon114Uri != null : !ICON114_URI_EDEFAULT.equals(icon114Uri);
			case PagemetaPackage.PAGE_ICON__ICON144_URI:
				return ICON144_URI_EDEFAULT == null ? icon144Uri != null : !ICON144_URI_EDEFAULT.equals(icon144Uri);
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
		result.append(" (faviconUri: ");
		result.append(faviconUri);
		result.append(", icon57Uri: ");
		result.append(icon57Uri);
		result.append(", icon72Uri: ");
		result.append(icon72Uri);
		result.append(", icon114Uri: ");
		result.append(icon114Uri);
		result.append(", icon144Uri: ");
		result.append(icon144Uri);
		result.append(')');
		return result.toString();
	}

} //PageIconImpl
