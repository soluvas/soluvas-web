/**
 */
package org.soluvas.web.site.pagemeta.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.pagemeta.OpenGraphAudio;
import org.soluvas.web.site.pagemeta.OpenGraphImage;
import org.soluvas.web.site.pagemeta.OpenGraphMeta;
import org.soluvas.web.site.pagemeta.OpenGraphVideo;
import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getOpenGraph <em>Open Graph</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getOpenGraphImage <em>Open Graph Image</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getOpenGraphVideo <em>Open Graph Video</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getOpenGraphAudio <em>Open Graph Audio</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getCharset <em>Charset</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getViewport <em>Viewport</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getAuthor <em>Author</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageMetaImpl extends EObjectImpl implements PageMeta {
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
	 * The default value of the '{@link #getCharset() <em>Charset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharset()
	 * @generated
	 * @ordered
	 */
	protected static final String CHARSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCharset() <em>Charset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharset()
	 * @generated
	 * @ordered
	 */
	protected String charset = CHARSET_EDEFAULT;

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
	 * The default value of the '{@link #getKeywords() <em>Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeywords()
	 * @generated
	 * @ordered
	 */
	protected static final String KEYWORDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeywords() <em>Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeywords()
	 * @generated
	 * @ordered
	 */
	protected String keywords = KEYWORDS_EDEFAULT;

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
	 * The default value of the '{@link #getViewport() <em>Viewport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewport()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEWPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewport() <em>Viewport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewport()
	 * @generated
	 * @ordered
	 */
	protected String viewport = VIEWPORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMetaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PageMetaPackage.Literals.PAGE_META;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__ICON, oldIcon, newIcon);
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
				msgs = ((InternalEObject)icon).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__ICON, null, msgs);
			if (newIcon != null)
				msgs = ((InternalEObject)newIcon).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__ICON, null, msgs);
			msgs = basicSetIcon(newIcon, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__ICON, newIcon, newIcon));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__LANGUAGE_CODE, oldLanguageCode, languageCode));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH, oldOpenGraph, newOpenGraph);
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
				msgs = ((InternalEObject)openGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH, null, msgs);
			if (newOpenGraph != null)
				msgs = ((InternalEObject)newOpenGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH, null, msgs);
			msgs = basicSetOpenGraph(newOpenGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH, newOpenGraph, newOpenGraph));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, oldOpenGraphImage, newOpenGraphImage);
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
				msgs = ((InternalEObject)openGraphImage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, null, msgs);
			if (newOpenGraphImage != null)
				msgs = ((InternalEObject)newOpenGraphImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, null, msgs);
			msgs = basicSetOpenGraphImage(newOpenGraphImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, newOpenGraphImage, newOpenGraphImage));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, oldOpenGraphVideo, newOpenGraphVideo);
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
				msgs = ((InternalEObject)openGraphVideo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, null, msgs);
			if (newOpenGraphVideo != null)
				msgs = ((InternalEObject)newOpenGraphVideo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, null, msgs);
			msgs = basicSetOpenGraphVideo(newOpenGraphVideo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, newOpenGraphVideo, newOpenGraphVideo));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, oldOpenGraphAudio, newOpenGraphAudio);
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
				msgs = ((InternalEObject)openGraphAudio).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, null, msgs);
			if (newOpenGraphAudio != null)
				msgs = ((InternalEObject)newOpenGraphAudio).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, null, msgs);
			msgs = basicSetOpenGraphAudio(newOpenGraphAudio, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, newOpenGraphAudio, newOpenGraphAudio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharset(String newCharset) {
		String oldCharset = charset;
		charset = newCharset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__CHARSET, oldCharset, charset));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeywords(String newKeywords) {
		String oldKeywords = keywords;
		keywords = newKeywords;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__KEYWORDS, oldKeywords, keywords));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewport() {
		return viewport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewport(String newViewport) {
		String oldViewport = viewport;
		viewport = newViewport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__VIEWPORT, oldViewport, viewport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_META__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PageMetaPackage.PAGE_META__ICON:
				return basicSetIcon(null, msgs);
			case PageMetaPackage.PAGE_META__OPEN_GRAPH:
				return basicSetOpenGraph(null, msgs);
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				return basicSetOpenGraphImage(null, msgs);
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				return basicSetOpenGraphVideo(null, msgs);
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
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
			case PageMetaPackage.PAGE_META__ICON:
				return getIcon();
			case PageMetaPackage.PAGE_META__LANGUAGE_CODE:
				return getLanguageCode();
			case PageMetaPackage.PAGE_META__OPEN_GRAPH:
				return getOpenGraph();
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				return getOpenGraphImage();
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				return getOpenGraphVideo();
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				return getOpenGraphAudio();
			case PageMetaPackage.PAGE_META__CHARSET:
				return getCharset();
			case PageMetaPackage.PAGE_META__TITLE:
				return getTitle();
			case PageMetaPackage.PAGE_META__KEYWORDS:
				return getKeywords();
			case PageMetaPackage.PAGE_META__DESCRIPTION:
				return getDescription();
			case PageMetaPackage.PAGE_META__VIEWPORT:
				return getViewport();
			case PageMetaPackage.PAGE_META__AUTHOR:
				return getAuthor();
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
			case PageMetaPackage.PAGE_META__ICON:
				setIcon((PageIcon)newValue);
				return;
			case PageMetaPackage.PAGE_META__LANGUAGE_CODE:
				setLanguageCode((String)newValue);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH:
				setOpenGraph((OpenGraphMeta)newValue);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				setOpenGraphImage((OpenGraphImage)newValue);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				setOpenGraphVideo((OpenGraphVideo)newValue);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				setOpenGraphAudio((OpenGraphAudio)newValue);
				return;
			case PageMetaPackage.PAGE_META__CHARSET:
				setCharset((String)newValue);
				return;
			case PageMetaPackage.PAGE_META__TITLE:
				setTitle((String)newValue);
				return;
			case PageMetaPackage.PAGE_META__KEYWORDS:
				setKeywords((String)newValue);
				return;
			case PageMetaPackage.PAGE_META__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PageMetaPackage.PAGE_META__VIEWPORT:
				setViewport((String)newValue);
				return;
			case PageMetaPackage.PAGE_META__AUTHOR:
				setAuthor((String)newValue);
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
			case PageMetaPackage.PAGE_META__ICON:
				setIcon((PageIcon)null);
				return;
			case PageMetaPackage.PAGE_META__LANGUAGE_CODE:
				setLanguageCode(LANGUAGE_CODE_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH:
				setOpenGraph((OpenGraphMeta)null);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				setOpenGraphImage((OpenGraphImage)null);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				setOpenGraphVideo((OpenGraphVideo)null);
				return;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				setOpenGraphAudio((OpenGraphAudio)null);
				return;
			case PageMetaPackage.PAGE_META__CHARSET:
				setCharset(CHARSET_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_META__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_META__KEYWORDS:
				setKeywords(KEYWORDS_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_META__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_META__VIEWPORT:
				setViewport(VIEWPORT_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_META__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
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
			case PageMetaPackage.PAGE_META__ICON:
				return icon != null;
			case PageMetaPackage.PAGE_META__LANGUAGE_CODE:
				return LANGUAGE_CODE_EDEFAULT == null ? languageCode != null : !LANGUAGE_CODE_EDEFAULT.equals(languageCode);
			case PageMetaPackage.PAGE_META__OPEN_GRAPH:
				return openGraph != null;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				return openGraphImage != null;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				return openGraphVideo != null;
			case PageMetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				return openGraphAudio != null;
			case PageMetaPackage.PAGE_META__CHARSET:
				return CHARSET_EDEFAULT == null ? charset != null : !CHARSET_EDEFAULT.equals(charset);
			case PageMetaPackage.PAGE_META__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case PageMetaPackage.PAGE_META__KEYWORDS:
				return KEYWORDS_EDEFAULT == null ? keywords != null : !KEYWORDS_EDEFAULT.equals(keywords);
			case PageMetaPackage.PAGE_META__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PageMetaPackage.PAGE_META__VIEWPORT:
				return VIEWPORT_EDEFAULT == null ? viewport != null : !VIEWPORT_EDEFAULT.equals(viewport);
			case PageMetaPackage.PAGE_META__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
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
		result.append(", charset: ");
		result.append(charset);
		result.append(", title: ");
		result.append(title);
		result.append(", keywords: ");
		result.append(keywords);
		result.append(", description: ");
		result.append(description);
		result.append(", viewport: ");
		result.append(viewport);
		result.append(", author: ");
		result.append(author);
		result.append(')');
		return result.toString();
	}

} //PageMetaImpl
