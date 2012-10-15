/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.OpenGraphAudio;
import org.soluvas.web.site.OpenGraphImage;
import org.soluvas.web.site.OpenGraphMeta;
import org.soluvas.web.site.OpenGraphVideo;
import org.soluvas.web.site.Page;
import org.soluvas.web.site.PageIcon;
import org.soluvas.web.site.PageMeta;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getOpenGraph <em>Open Graph</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getOpenGraphImage <em>Open Graph Image</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getOpenGraphVideo <em>Open Graph Video</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.PageImpl#getOpenGraphAudio <em>Open Graph Audio</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageImpl extends EObjectImpl implements Page {
	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected PageMeta meta;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected PageIcon icon;

	/**
	 * The default value of the '{@link #getLanguageCode() <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageCode()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguageCode() <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageCode()
	 * @generated
	 * @ordered
	 */
	protected String languageCode = LANGUAGE_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOpenGraph() <em>Open Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenGraph()
	 * @generated
	 * @ordered
	 */
	protected OpenGraphMeta openGraph;

	/**
	 * The cached value of the '{@link #getOpenGraphImage() <em>Open Graph Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenGraphImage()
	 * @generated
	 * @ordered
	 */
	protected OpenGraphImage openGraphImage;

	/**
	 * The cached value of the '{@link #getOpenGraphVideo() <em>Open Graph Video</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenGraphVideo()
	 * @generated
	 * @ordered
	 */
	protected OpenGraphVideo openGraphVideo;

	/**
	 * The cached value of the '{@link #getOpenGraphAudio() <em>Open Graph Audio</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenGraphAudio()
	 * @generated
	 * @ordered
	 */
	protected OpenGraphAudio openGraphAudio;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMeta getMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeta(PageMeta newMeta, NotificationChain msgs) {
		PageMeta oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__META, oldMeta, newMeta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(PageMeta newMeta) {
		if (newMeta != meta) {
			NotificationChain msgs = null;
			if (meta != null)
				msgs = ((InternalEObject)meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__META, null, msgs);
			if (newMeta != null)
				msgs = ((InternalEObject)newMeta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__META, null, msgs);
			msgs = basicSetMeta(newMeta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__META, newMeta, newMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageIcon getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIcon(PageIcon newIcon, NotificationChain msgs) {
		PageIcon oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__ICON, oldIcon, newIcon);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(PageIcon newIcon) {
		if (newIcon != icon) {
			NotificationChain msgs = null;
			if (icon != null)
				msgs = ((InternalEObject)icon).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__ICON, null, msgs);
			if (newIcon != null)
				msgs = ((InternalEObject)newIcon).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__ICON, null, msgs);
			msgs = basicSetIcon(newIcon, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__ICON, newIcon, newIcon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageCode(String newLanguageCode) {
		String oldLanguageCode = languageCode;
		languageCode = newLanguageCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__LANGUAGE_CODE, oldLanguageCode, languageCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphMeta getOpenGraph() {
		return openGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpenGraph(OpenGraphMeta newOpenGraph, NotificationChain msgs) {
		OpenGraphMeta oldOpenGraph = openGraph;
		openGraph = newOpenGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH, oldOpenGraph, newOpenGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpenGraph(OpenGraphMeta newOpenGraph) {
		if (newOpenGraph != openGraph) {
			NotificationChain msgs = null;
			if (openGraph != null)
				msgs = ((InternalEObject)openGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH, null, msgs);
			if (newOpenGraph != null)
				msgs = ((InternalEObject)newOpenGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH, null, msgs);
			msgs = basicSetOpenGraph(newOpenGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH, newOpenGraph, newOpenGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphImage getOpenGraphImage() {
		return openGraphImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpenGraphImage(OpenGraphImage newOpenGraphImage, NotificationChain msgs) {
		OpenGraphImage oldOpenGraphImage = openGraphImage;
		openGraphImage = newOpenGraphImage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH_IMAGE, oldOpenGraphImage, newOpenGraphImage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpenGraphImage(OpenGraphImage newOpenGraphImage) {
		if (newOpenGraphImage != openGraphImage) {
			NotificationChain msgs = null;
			if (openGraphImage != null)
				msgs = ((InternalEObject)openGraphImage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH_IMAGE, null, msgs);
			if (newOpenGraphImage != null)
				msgs = ((InternalEObject)newOpenGraphImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH_IMAGE, null, msgs);
			msgs = basicSetOpenGraphImage(newOpenGraphImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH_IMAGE, newOpenGraphImage, newOpenGraphImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphVideo getOpenGraphVideo() {
		return openGraphVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpenGraphVideo(OpenGraphVideo newOpenGraphVideo, NotificationChain msgs) {
		OpenGraphVideo oldOpenGraphVideo = openGraphVideo;
		openGraphVideo = newOpenGraphVideo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH_VIDEO, oldOpenGraphVideo, newOpenGraphVideo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpenGraphVideo(OpenGraphVideo newOpenGraphVideo) {
		if (newOpenGraphVideo != openGraphVideo) {
			NotificationChain msgs = null;
			if (openGraphVideo != null)
				msgs = ((InternalEObject)openGraphVideo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH_VIDEO, null, msgs);
			if (newOpenGraphVideo != null)
				msgs = ((InternalEObject)newOpenGraphVideo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH_VIDEO, null, msgs);
			msgs = basicSetOpenGraphVideo(newOpenGraphVideo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH_VIDEO, newOpenGraphVideo, newOpenGraphVideo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphAudio getOpenGraphAudio() {
		return openGraphAudio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpenGraphAudio(OpenGraphAudio newOpenGraphAudio, NotificationChain msgs) {
		OpenGraphAudio oldOpenGraphAudio = openGraphAudio;
		openGraphAudio = newOpenGraphAudio;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH_AUDIO, oldOpenGraphAudio, newOpenGraphAudio);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpenGraphAudio(OpenGraphAudio newOpenGraphAudio) {
		if (newOpenGraphAudio != openGraphAudio) {
			NotificationChain msgs = null;
			if (openGraphAudio != null)
				msgs = ((InternalEObject)openGraphAudio).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH_AUDIO, null, msgs);
			if (newOpenGraphAudio != null)
				msgs = ((InternalEObject)newOpenGraphAudio).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SitePackage.PAGE__OPEN_GRAPH_AUDIO, null, msgs);
			msgs = basicSetOpenGraphAudio(newOpenGraphAudio, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.PAGE__OPEN_GRAPH_AUDIO, newOpenGraphAudio, newOpenGraphAudio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SitePackage.PAGE__META:
				return basicSetMeta(null, msgs);
			case SitePackage.PAGE__ICON:
				return basicSetIcon(null, msgs);
			case SitePackage.PAGE__OPEN_GRAPH:
				return basicSetOpenGraph(null, msgs);
			case SitePackage.PAGE__OPEN_GRAPH_IMAGE:
				return basicSetOpenGraphImage(null, msgs);
			case SitePackage.PAGE__OPEN_GRAPH_VIDEO:
				return basicSetOpenGraphVideo(null, msgs);
			case SitePackage.PAGE__OPEN_GRAPH_AUDIO:
				return basicSetOpenGraphAudio(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.PAGE__META:
				return getMeta();
			case SitePackage.PAGE__ICON:
				return getIcon();
			case SitePackage.PAGE__LANGUAGE_CODE:
				return getLanguageCode();
			case SitePackage.PAGE__OPEN_GRAPH:
				return getOpenGraph();
			case SitePackage.PAGE__OPEN_GRAPH_IMAGE:
				return getOpenGraphImage();
			case SitePackage.PAGE__OPEN_GRAPH_VIDEO:
				return getOpenGraphVideo();
			case SitePackage.PAGE__OPEN_GRAPH_AUDIO:
				return getOpenGraphAudio();
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
			case SitePackage.PAGE__META:
				setMeta((PageMeta)newValue);
				return;
			case SitePackage.PAGE__ICON:
				setIcon((PageIcon)newValue);
				return;
			case SitePackage.PAGE__LANGUAGE_CODE:
				setLanguageCode((String)newValue);
				return;
			case SitePackage.PAGE__OPEN_GRAPH:
				setOpenGraph((OpenGraphMeta)newValue);
				return;
			case SitePackage.PAGE__OPEN_GRAPH_IMAGE:
				setOpenGraphImage((OpenGraphImage)newValue);
				return;
			case SitePackage.PAGE__OPEN_GRAPH_VIDEO:
				setOpenGraphVideo((OpenGraphVideo)newValue);
				return;
			case SitePackage.PAGE__OPEN_GRAPH_AUDIO:
				setOpenGraphAudio((OpenGraphAudio)newValue);
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
			case SitePackage.PAGE__META:
				setMeta((PageMeta)null);
				return;
			case SitePackage.PAGE__ICON:
				setIcon((PageIcon)null);
				return;
			case SitePackage.PAGE__LANGUAGE_CODE:
				setLanguageCode(LANGUAGE_CODE_EDEFAULT);
				return;
			case SitePackage.PAGE__OPEN_GRAPH:
				setOpenGraph((OpenGraphMeta)null);
				return;
			case SitePackage.PAGE__OPEN_GRAPH_IMAGE:
				setOpenGraphImage((OpenGraphImage)null);
				return;
			case SitePackage.PAGE__OPEN_GRAPH_VIDEO:
				setOpenGraphVideo((OpenGraphVideo)null);
				return;
			case SitePackage.PAGE__OPEN_GRAPH_AUDIO:
				setOpenGraphAudio((OpenGraphAudio)null);
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
			case SitePackage.PAGE__META:
				return meta != null;
			case SitePackage.PAGE__ICON:
				return icon != null;
			case SitePackage.PAGE__LANGUAGE_CODE:
				return LANGUAGE_CODE_EDEFAULT == null ? languageCode != null : !LANGUAGE_CODE_EDEFAULT.equals(languageCode);
			case SitePackage.PAGE__OPEN_GRAPH:
				return openGraph != null;
			case SitePackage.PAGE__OPEN_GRAPH_IMAGE:
				return openGraphImage != null;
			case SitePackage.PAGE__OPEN_GRAPH_VIDEO:
				return openGraphVideo != null;
			case SitePackage.PAGE__OPEN_GRAPH_AUDIO:
				return openGraphAudio != null;
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
		result.append(" (languageCode: ");
		result.append(languageCode);
		result.append(')');
		return result.toString();
	}

} //PageImpl
