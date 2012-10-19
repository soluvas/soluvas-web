/**
 */
package org.soluvas.web.site.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.soluvas.web.site.OpenGraphMeta;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Graph Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getAudio <em>Audio</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getDeterminer <em>Determiner</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getLocale <em>Locale</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getLocaleAlternates <em>Locale Alternates</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getSiteName <em>Site Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.OpenGraphMetaImpl#getVideo <em>Video</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenGraphMetaImpl extends EObjectImpl implements OpenGraphMeta {
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
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected String image = IMAGE_EDEFAULT;

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
	 * The default value of the '{@link #getAudio() <em>Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudio()
	 * @generated
	 * @ordered
	 */
	protected static final String AUDIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAudio() <em>Audio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudio()
	 * @generated
	 * @ordered
	 */
	protected String audio = AUDIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeterminer() <em>Determiner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeterminer()
	 * @generated
	 * @ordered
	 */
	protected static final String DETERMINER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeterminer() <em>Determiner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeterminer()
	 * @generated
	 * @ordered
	 */
	protected String determiner = DETERMINER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected String locale = LOCALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocaleAlternates() <em>Locale Alternates</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocaleAlternates()
	 * @generated
	 * @ordered
	 */
	protected EList<String> localeAlternates;

	/**
	 * The default value of the '{@link #getSiteName() <em>Site Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSiteName()
	 * @generated
	 * @ordered
	 */
	protected static final String SITE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSiteName() <em>Site Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSiteName()
	 * @generated
	 * @ordered
	 */
	protected String siteName = SITE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVideo() <em>Video</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVideo()
	 * @generated
	 * @ordered
	 */
	protected static final String VIDEO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVideo() <em>Video</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVideo()
	 * @generated
	 * @ordered
	 */
	protected String video = VIDEO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphMetaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.OPEN_GRAPH_META;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__TITLE, oldTitle, title));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(String newImage) {
		String oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__IMAGE, oldImage, image));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAudio() {
		return audio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudio(String newAudio) {
		String oldAudio = audio;
		audio = newAudio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__AUDIO, oldAudio, audio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeterminer() {
		return determiner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeterminer(String newDeterminer) {
		String oldDeterminer = determiner;
		determiner = newDeterminer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__DETERMINER, oldDeterminer, determiner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocale(String newLocale) {
		String oldLocale = locale;
		locale = newLocale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__LOCALE, oldLocale, locale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLocaleAlternates() {
		if (localeAlternates == null) {
			localeAlternates = new EDataTypeUniqueEList<String>(String.class, this, SitePackage.OPEN_GRAPH_META__LOCALE_ALTERNATES);
		}
		return localeAlternates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSiteName(String newSiteName) {
		String oldSiteName = siteName;
		siteName = newSiteName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__SITE_NAME, oldSiteName, siteName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVideo() {
		return video;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVideo(String newVideo) {
		String oldVideo = video;
		video = newVideo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.OPEN_GRAPH_META__VIDEO, oldVideo, video));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.OPEN_GRAPH_META__TITLE:
				return getTitle();
			case SitePackage.OPEN_GRAPH_META__TYPE:
				return getType();
			case SitePackage.OPEN_GRAPH_META__IMAGE:
				return getImage();
			case SitePackage.OPEN_GRAPH_META__URL:
				return getUrl();
			case SitePackage.OPEN_GRAPH_META__AUDIO:
				return getAudio();
			case SitePackage.OPEN_GRAPH_META__DESCRIPTION:
				return getDescription();
			case SitePackage.OPEN_GRAPH_META__DETERMINER:
				return getDeterminer();
			case SitePackage.OPEN_GRAPH_META__LOCALE:
				return getLocale();
			case SitePackage.OPEN_GRAPH_META__LOCALE_ALTERNATES:
				return getLocaleAlternates();
			case SitePackage.OPEN_GRAPH_META__SITE_NAME:
				return getSiteName();
			case SitePackage.OPEN_GRAPH_META__VIDEO:
				return getVideo();
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
			case SitePackage.OPEN_GRAPH_META__TITLE:
				setTitle((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__TYPE:
				setType((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__IMAGE:
				setImage((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__URL:
				setUrl((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__AUDIO:
				setAudio((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__DETERMINER:
				setDeterminer((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__LOCALE:
				setLocale((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__LOCALE_ALTERNATES:
				getLocaleAlternates().clear();
				getLocaleAlternates().addAll((Collection<? extends String>)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__SITE_NAME:
				setSiteName((String)newValue);
				return;
			case SitePackage.OPEN_GRAPH_META__VIDEO:
				setVideo((String)newValue);
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
			case SitePackage.OPEN_GRAPH_META__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__URL:
				setUrl(URL_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__AUDIO:
				setAudio(AUDIO_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__DETERMINER:
				setDeterminer(DETERMINER_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__LOCALE:
				setLocale(LOCALE_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__LOCALE_ALTERNATES:
				getLocaleAlternates().clear();
				return;
			case SitePackage.OPEN_GRAPH_META__SITE_NAME:
				setSiteName(SITE_NAME_EDEFAULT);
				return;
			case SitePackage.OPEN_GRAPH_META__VIDEO:
				setVideo(VIDEO_EDEFAULT);
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
			case SitePackage.OPEN_GRAPH_META__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case SitePackage.OPEN_GRAPH_META__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SitePackage.OPEN_GRAPH_META__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
			case SitePackage.OPEN_GRAPH_META__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case SitePackage.OPEN_GRAPH_META__AUDIO:
				return AUDIO_EDEFAULT == null ? audio != null : !AUDIO_EDEFAULT.equals(audio);
			case SitePackage.OPEN_GRAPH_META__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SitePackage.OPEN_GRAPH_META__DETERMINER:
				return DETERMINER_EDEFAULT == null ? determiner != null : !DETERMINER_EDEFAULT.equals(determiner);
			case SitePackage.OPEN_GRAPH_META__LOCALE:
				return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
			case SitePackage.OPEN_GRAPH_META__LOCALE_ALTERNATES:
				return localeAlternates != null && !localeAlternates.isEmpty();
			case SitePackage.OPEN_GRAPH_META__SITE_NAME:
				return SITE_NAME_EDEFAULT == null ? siteName != null : !SITE_NAME_EDEFAULT.equals(siteName);
			case SitePackage.OPEN_GRAPH_META__VIDEO:
				return VIDEO_EDEFAULT == null ? video != null : !VIDEO_EDEFAULT.equals(video);
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
		result.append(" (title: ");
		result.append(title);
		result.append(", type: ");
		result.append(type);
		result.append(", image: ");
		result.append(image);
		result.append(", url: ");
		result.append(url);
		result.append(", audio: ");
		result.append(audio);
		result.append(", description: ");
		result.append(description);
		result.append(", determiner: ");
		result.append(determiner);
		result.append(", locale: ");
		result.append(locale);
		result.append(", localeAlternates: ");
		result.append(localeAlternates);
		result.append(", siteName: ");
		result.append(siteName);
		result.append(", video: ");
		result.append(video);
		result.append(')');
		return result.toString();
	}

} //OpenGraphMetaImpl
