/**
 */
package org.soluvas.web.site.pagemeta.impl;

import javax.annotation.Nonnull;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PagemetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Icon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getBrandingBundleName <em>Branding Bundle Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getFaviconPath <em>Favicon Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getFaviconUri <em>Favicon Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon57Path <em>Icon57 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon57Uri <em>Icon57 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon72Path <em>Icon72 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon72Uri <em>Icon72 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon114Path <em>Icon114 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon114Uri <em>Icon114 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon144Path <em>Icon144 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl#getIcon144Uri <em>Icon144 Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageIconImpl extends EObjectImpl implements PageIcon {
	/**
	 * The default value of the '{@link #getBrandingBundleName() <em>Branding Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrandingBundleName()
	 * @generated
	 * @ordered
	 */
	protected static final String BRANDING_BUNDLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrandingBundleName() <em>Branding Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrandingBundleName()
	 * @generated
	 * @ordered
	 */
	protected String brandingBundleName = BRANDING_BUNDLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaviconPath() <em>Favicon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaviconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FAVICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaviconPath() <em>Favicon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaviconPath()
	 * @generated
	 * @ordered
	 */
	protected String faviconPath = FAVICON_PATH_EDEFAULT;

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
	 * The default value of the '{@link #getIcon57Path() <em>Icon57 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon57Path()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON57_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon57Path() <em>Icon57 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon57Path()
	 * @generated
	 * @ordered
	 */
	protected String icon57Path = ICON57_PATH_EDEFAULT;

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
	 * The default value of the '{@link #getIcon72Path() <em>Icon72 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon72Path()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON72_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon72Path() <em>Icon72 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon72Path()
	 * @generated
	 * @ordered
	 */
	protected String icon72Path = ICON72_PATH_EDEFAULT;

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
	 * The default value of the '{@link #getIcon114Path() <em>Icon114 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon114Path()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON114_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon114Path() <em>Icon114 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon114Path()
	 * @generated
	 * @ordered
	 */
	protected String icon114Path = ICON114_PATH_EDEFAULT;

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
	 * The default value of the '{@link #getIcon144Path() <em>Icon144 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon144Path()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON144_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon144Path() <em>Icon144 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon144Path()
	 * @generated
	 * @ordered
	 */
	protected String icon144Path = ICON144_PATH_EDEFAULT;

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
	@Override
	public String getBrandingBundleName() {
		return brandingBundleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBrandingBundleName(String newBrandingBundleName) {
		String oldBrandingBundleName = brandingBundleName;
		brandingBundleName = newBrandingBundleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__BRANDING_BUNDLE_NAME, oldBrandingBundleName, brandingBundleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFaviconPath() {
		return faviconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFaviconPath(String newFaviconPath) {
		String oldFaviconPath = faviconPath;
		faviconPath = newFaviconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__FAVICON_PATH, oldFaviconPath, faviconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFaviconUri() {
		return faviconUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getIcon57Path() {
		return icon57Path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon57Path(String newIcon57Path) {
		String oldIcon57Path = icon57Path;
		icon57Path = newIcon57Path;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON57_PATH, oldIcon57Path, icon57Path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIcon57Uri() {
		return icon57Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getIcon72Path() {
		return icon72Path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon72Path(String newIcon72Path) {
		String oldIcon72Path = icon72Path;
		icon72Path = newIcon72Path;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON72_PATH, oldIcon72Path, icon72Path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIcon72Uri() {
		return icon72Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getIcon114Path() {
		return icon114Path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon114Path(String newIcon114Path) {
		String oldIcon114Path = icon114Path;
		icon114Path = newIcon114Path;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON114_PATH, oldIcon114Path, icon114Path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIcon114Uri() {
		return icon114Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getIcon144Path() {
		return icon144Path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon144Path(String newIcon144Path) {
		String oldIcon144Path = icon144Path;
		icon144Path = newIcon144Path;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON144_PATH, oldIcon144Path, icon144Path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIcon144Uri() {
		return icon144Uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon144Uri(String newIcon144Uri) {
		String oldIcon144Uri = icon144Uri;
		icon144Uri = newIcon144Uri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_ICON__ICON144_URI, oldIcon144Uri, icon144Uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public PageIcon toAbsolute(final String imagesUri) {
		final PageIcon result = EcoreUtil.copy(this);
		if (result.getFaviconUri() == null)
			result.setFaviconUri(imagesUri + getBrandingBundleName() + "/" + getFaviconPath());
		if (result.getIcon57Uri() == null)
			result.setIcon57Uri(imagesUri + getBrandingBundleName() + "/" + getIcon57Path());
		if (result.getIcon72Uri() == null)
			result.setIcon72Uri(imagesUri + getBrandingBundleName() + "/" + getIcon72Path());
		if (result.getIcon114Uri() == null)
			result.setIcon114Uri(imagesUri + getBrandingBundleName() + "/" + getIcon114Path());
		if (result.getIcon144Uri() == null)
			result.setIcon144Uri(imagesUri + getBrandingBundleName() + "/" + getIcon144Path());
		return result;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PagemetaPackage.PAGE_ICON__BRANDING_BUNDLE_NAME:
				return getBrandingBundleName();
			case PagemetaPackage.PAGE_ICON__FAVICON_PATH:
				return getFaviconPath();
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				return getFaviconUri();
			case PagemetaPackage.PAGE_ICON__ICON57_PATH:
				return getIcon57Path();
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				return getIcon57Uri();
			case PagemetaPackage.PAGE_ICON__ICON72_PATH:
				return getIcon72Path();
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				return getIcon72Uri();
			case PagemetaPackage.PAGE_ICON__ICON114_PATH:
				return getIcon114Path();
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				return getIcon114Uri();
			case PagemetaPackage.PAGE_ICON__ICON144_PATH:
				return getIcon144Path();
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
			case PagemetaPackage.PAGE_ICON__BRANDING_BUNDLE_NAME:
				setBrandingBundleName((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__FAVICON_PATH:
				setFaviconPath((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				setFaviconUri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON57_PATH:
				setIcon57Path((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				setIcon57Uri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON72_PATH:
				setIcon72Path((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				setIcon72Uri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON114_PATH:
				setIcon114Path((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				setIcon114Uri((String)newValue);
				return;
			case PagemetaPackage.PAGE_ICON__ICON144_PATH:
				setIcon144Path((String)newValue);
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
			case PagemetaPackage.PAGE_ICON__BRANDING_BUNDLE_NAME:
				setBrandingBundleName(BRANDING_BUNDLE_NAME_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__FAVICON_PATH:
				setFaviconPath(FAVICON_PATH_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				setFaviconUri(FAVICON_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON57_PATH:
				setIcon57Path(ICON57_PATH_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				setIcon57Uri(ICON57_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON72_PATH:
				setIcon72Path(ICON72_PATH_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				setIcon72Uri(ICON72_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON114_PATH:
				setIcon114Path(ICON114_PATH_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				setIcon114Uri(ICON114_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_ICON__ICON144_PATH:
				setIcon144Path(ICON144_PATH_EDEFAULT);
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
			case PagemetaPackage.PAGE_ICON__BRANDING_BUNDLE_NAME:
				return BRANDING_BUNDLE_NAME_EDEFAULT == null ? brandingBundleName != null : !BRANDING_BUNDLE_NAME_EDEFAULT.equals(brandingBundleName);
			case PagemetaPackage.PAGE_ICON__FAVICON_PATH:
				return FAVICON_PATH_EDEFAULT == null ? faviconPath != null : !FAVICON_PATH_EDEFAULT.equals(faviconPath);
			case PagemetaPackage.PAGE_ICON__FAVICON_URI:
				return FAVICON_URI_EDEFAULT == null ? faviconUri != null : !FAVICON_URI_EDEFAULT.equals(faviconUri);
			case PagemetaPackage.PAGE_ICON__ICON57_PATH:
				return ICON57_PATH_EDEFAULT == null ? icon57Path != null : !ICON57_PATH_EDEFAULT.equals(icon57Path);
			case PagemetaPackage.PAGE_ICON__ICON57_URI:
				return ICON57_URI_EDEFAULT == null ? icon57Uri != null : !ICON57_URI_EDEFAULT.equals(icon57Uri);
			case PagemetaPackage.PAGE_ICON__ICON72_PATH:
				return ICON72_PATH_EDEFAULT == null ? icon72Path != null : !ICON72_PATH_EDEFAULT.equals(icon72Path);
			case PagemetaPackage.PAGE_ICON__ICON72_URI:
				return ICON72_URI_EDEFAULT == null ? icon72Uri != null : !ICON72_URI_EDEFAULT.equals(icon72Uri);
			case PagemetaPackage.PAGE_ICON__ICON114_PATH:
				return ICON114_PATH_EDEFAULT == null ? icon114Path != null : !ICON114_PATH_EDEFAULT.equals(icon114Path);
			case PagemetaPackage.PAGE_ICON__ICON114_URI:
				return ICON114_URI_EDEFAULT == null ? icon114Uri != null : !ICON114_URI_EDEFAULT.equals(icon114Uri);
			case PagemetaPackage.PAGE_ICON__ICON144_PATH:
				return ICON144_PATH_EDEFAULT == null ? icon144Path != null : !ICON144_PATH_EDEFAULT.equals(icon144Path);
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
		result.append(" (brandingBundleName: ");
		result.append(brandingBundleName);
		result.append(", faviconPath: ");
		result.append(faviconPath);
		result.append(", faviconUri: ");
		result.append(faviconUri);
		result.append(", icon57Path: ");
		result.append(icon57Path);
		result.append(", icon57Uri: ");
		result.append(icon57Uri);
		result.append(", icon72Path: ");
		result.append(icon72Path);
		result.append(", icon72Uri: ");
		result.append(icon72Uri);
		result.append(", icon114Path: ");
		result.append(icon114Path);
		result.append(", icon114Uri: ");
		result.append(icon114Uri);
		result.append(", icon144Path: ");
		result.append(icon144Path);
		result.append(", icon144Uri: ");
		result.append(icon144Uri);
		result.append(')');
		return result.toString();
	}

} //PageIconImpl
