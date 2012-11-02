/**
 */
package org.soluvas.web.banner.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.web.banner.Banner;
import org.soluvas.web.banner.BannerPackage;
import org.soluvas.web.banner.ImageBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Banner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.banner.impl.BannerImpl#getImageUri <em>Image Uri</em>}</li>
 *   <li>{@link org.soluvas.web.banner.impl.BannerImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.web.banner.impl.BannerImpl#getLinkUri <em>Link Uri</em>}</li>
 *   <li>{@link org.soluvas.web.banner.impl.BannerImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.web.banner.impl.BannerImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.web.banner.impl.BannerImpl#getImageBase <em>Image Base</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BannerImpl extends EObjectImpl implements Banner {

	private static final long serialVersionUID = 1L;

	/**
	 * The default value of the '{@link #getImageUri() <em>Image Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageUri()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageUri() <em>Image Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageUri()
	 * @generated
	 * @ordered
	 */
	protected String imageUri = IMAGE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkUri() <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUri()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkUri() <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUri()
	 * @generated
	 * @ordered
	 */
	protected String linkUri = LINK_URI_EDEFAULT;

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
	 * The default value of the '{@link #getImageBase() <em>Image Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageBase()
	 * @generated
	 * @ordered
	 */
	protected static final ImageBase IMAGE_BASE_EDEFAULT = ImageBase.ABSOLUTE;

	/**
	 * The cached value of the '{@link #getImageBase() <em>Image Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageBase()
	 * @generated
	 * @ordered
	 */
	protected ImageBase imageBase = IMAGE_BASE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BannerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BannerPackage.Literals.BANNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImageUri() {
		return imageUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageUri(String newImageUri) {
		String oldImageUri = imageUri;
		imageUri = newImageUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BannerPackage.BANNER__IMAGE_URI, oldImageUri, imageUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BannerPackage.BANNER__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinkUri() {
		return linkUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinkUri(String newLinkUri) {
		String oldLinkUri = linkUri;
		linkUri = newLinkUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BannerPackage.BANNER__LINK_URI, oldLinkUri, linkUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(Integer newWidth) {
		Integer oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BannerPackage.BANNER__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(Integer newHeight) {
		Integer oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BannerPackage.BANNER__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageBase getImageBase() {
		return imageBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageBase(ImageBase newImageBase) {
		ImageBase oldImageBase = imageBase;
		imageBase = newImageBase == null ? IMAGE_BASE_EDEFAULT : newImageBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BannerPackage.BANNER__IMAGE_BASE, oldImageBase, imageBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BannerPackage.BANNER__IMAGE_URI:
				return getImageUri();
			case BannerPackage.BANNER__TITLE:
				return getTitle();
			case BannerPackage.BANNER__LINK_URI:
				return getLinkUri();
			case BannerPackage.BANNER__WIDTH:
				return getWidth();
			case BannerPackage.BANNER__HEIGHT:
				return getHeight();
			case BannerPackage.BANNER__IMAGE_BASE:
				return getImageBase();
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
			case BannerPackage.BANNER__IMAGE_URI:
				setImageUri((String)newValue);
				return;
			case BannerPackage.BANNER__TITLE:
				setTitle((String)newValue);
				return;
			case BannerPackage.BANNER__LINK_URI:
				setLinkUri((String)newValue);
				return;
			case BannerPackage.BANNER__WIDTH:
				setWidth((Integer)newValue);
				return;
			case BannerPackage.BANNER__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case BannerPackage.BANNER__IMAGE_BASE:
				setImageBase((ImageBase)newValue);
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
			case BannerPackage.BANNER__IMAGE_URI:
				setImageUri(IMAGE_URI_EDEFAULT);
				return;
			case BannerPackage.BANNER__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case BannerPackage.BANNER__LINK_URI:
				setLinkUri(LINK_URI_EDEFAULT);
				return;
			case BannerPackage.BANNER__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case BannerPackage.BANNER__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case BannerPackage.BANNER__IMAGE_BASE:
				setImageBase(IMAGE_BASE_EDEFAULT);
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
			case BannerPackage.BANNER__IMAGE_URI:
				return IMAGE_URI_EDEFAULT == null ? imageUri != null : !IMAGE_URI_EDEFAULT.equals(imageUri);
			case BannerPackage.BANNER__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case BannerPackage.BANNER__LINK_URI:
				return LINK_URI_EDEFAULT == null ? linkUri != null : !LINK_URI_EDEFAULT.equals(linkUri);
			case BannerPackage.BANNER__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case BannerPackage.BANNER__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case BannerPackage.BANNER__IMAGE_BASE:
				return imageBase != IMAGE_BASE_EDEFAULT;
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
		result.append(" (imageUri: ");
		result.append(imageUri);
		result.append(", title: ");
		result.append(title);
		result.append(", linkUri: ");
		result.append(linkUri);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", imageBase: ");
		result.append(imageBase);
		result.append(')');
		return result.toString();
	}

} //BannerImpl
