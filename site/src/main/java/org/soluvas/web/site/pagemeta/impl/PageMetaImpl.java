/**
 */
package org.soluvas.web.site.pagemeta.impl;

import java.io.StringReader;
import java.io.StringWriter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.SiteException;
import org.soluvas.web.site.pagemeta.OpenGraphAudio;
import org.soluvas.web.site.pagemeta.OpenGraphImage;
import org.soluvas.web.site.pagemeta.OpenGraphMeta;
import org.soluvas.web.site.pagemeta.OpenGraphVideo;
import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaPhase;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.pagemeta.PagemetaPackage;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;

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
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl#getRobots <em>Robots</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageMetaImpl extends EObjectImpl implements PageMeta {
	
	private static Logger log = LoggerFactory.getLogger(PageMetaImpl.class);
	
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
	 * The default value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected static final PageMetaPhase PHASE_EDEFAULT = PageMetaPhase.TEMPLATE;

	/**
	 * The cached value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected PageMetaPhase phase = PHASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRobots() <em>Robots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobots()
	 * @generated
	 * @ordered
	 */
	protected static final String ROBOTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRobots() <em>Robots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobots()
	 * @generated
	 * @ordered
	 */
	protected String robots = ROBOTS_EDEFAULT;

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
		return PagemetaPackage.Literals.PAGE_META;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__ICON, oldIcon, newIcon);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon(PageIcon newIcon) {
		if (newIcon != icon) {
			NotificationChain msgs = null;
			if (icon != null)
				msgs = ((InternalEObject)icon).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__ICON, null, msgs);
			if (newIcon != null)
				msgs = ((InternalEObject)newIcon).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__ICON, null, msgs);
			msgs = basicSetIcon(newIcon, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__ICON, newIcon, newIcon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguageCode(String newLanguageCode) {
		String oldLanguageCode = languageCode;
		languageCode = newLanguageCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__LANGUAGE_CODE, oldLanguageCode, languageCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH, oldOpenGraph, newOpenGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenGraph(OpenGraphMeta newOpenGraph) {
		if (newOpenGraph != openGraph) {
			NotificationChain msgs = null;
			if (openGraph != null)
				msgs = ((InternalEObject)openGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH, null, msgs);
			if (newOpenGraph != null)
				msgs = ((InternalEObject)newOpenGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH, null, msgs);
			msgs = basicSetOpenGraph(newOpenGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH, newOpenGraph, newOpenGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, oldOpenGraphImage, newOpenGraphImage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenGraphImage(OpenGraphImage newOpenGraphImage) {
		if (newOpenGraphImage != openGraphImage) {
			NotificationChain msgs = null;
			if (openGraphImage != null)
				msgs = ((InternalEObject)openGraphImage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, null, msgs);
			if (newOpenGraphImage != null)
				msgs = ((InternalEObject)newOpenGraphImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, null, msgs);
			msgs = basicSetOpenGraphImage(newOpenGraphImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE, newOpenGraphImage, newOpenGraphImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, oldOpenGraphVideo, newOpenGraphVideo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenGraphVideo(OpenGraphVideo newOpenGraphVideo) {
		if (newOpenGraphVideo != openGraphVideo) {
			NotificationChain msgs = null;
			if (openGraphVideo != null)
				msgs = ((InternalEObject)openGraphVideo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, null, msgs);
			if (newOpenGraphVideo != null)
				msgs = ((InternalEObject)newOpenGraphVideo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, null, msgs);
			msgs = basicSetOpenGraphVideo(newOpenGraphVideo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO, newOpenGraphVideo, newOpenGraphVideo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, oldOpenGraphAudio, newOpenGraphAudio);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenGraphAudio(OpenGraphAudio newOpenGraphAudio) {
		if (newOpenGraphAudio != openGraphAudio) {
			NotificationChain msgs = null;
			if (openGraphAudio != null)
				msgs = ((InternalEObject)openGraphAudio).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, null, msgs);
			if (newOpenGraphAudio != null)
				msgs = ((InternalEObject)newOpenGraphAudio).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, null, msgs);
			msgs = basicSetOpenGraphAudio(newOpenGraphAudio, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO, newOpenGraphAudio, newOpenGraphAudio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCharset() {
		return charset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCharset(String newCharset) {
		String oldCharset = charset;
		charset = newCharset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__CHARSET, oldCharset, charset));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKeywords() {
		return keywords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKeywords(String newKeywords) {
		String oldKeywords = keywords;
		keywords = newKeywords;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__KEYWORDS, oldKeywords, keywords));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getViewport() {
		return viewport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setViewport(String newViewport) {
		String oldViewport = viewport;
		viewport = newViewport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__VIEWPORT, oldViewport, viewport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageMetaPhase getPhase() {
		return phase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhase(PageMetaPhase newPhase) {
		PageMetaPhase oldPhase = phase;
		phase = newPhase == null ? PHASE_EDEFAULT : newPhase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__PHASE, oldPhase, phase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRobots() {
		return robots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRobots(String newRobots) {
		String oldRobots = robots;
		robots = newRobots;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META__ROBOTS, oldRobots, robots));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public PageMeta toText(final Object context) {
//		log.debug("toText..");
		switch (phase) {
		case TEMPLATE:
//			log.debug("Masuk sini gan :O");
			final PageMetaImpl result = EcoreUtil.copy(this);
			final DefaultMustacheFactory mf = new DefaultMustacheFactory();
			renderMustache(mf, PagemetaPackage.eINSTANCE.getPageMeta_Title(), result, context);
			renderMustache(mf, PagemetaPackage.eINSTANCE.getPageMeta_Description(), result, context);
			renderMustache(mf, PagemetaPackage.eINSTANCE.getPageMeta_Keywords(), result, context);
			renderMustache(mf, PagemetaPackage.eINSTANCE.getPageMeta_Author(), result, context);
			final OpenGraphMeta openGraph = result.getOpenGraph();
			if (openGraph != null) {
				renderMustache(mf, PagemetaPackage.eINSTANCE.getOpenGraphMeta_Title(), openGraph, context);
				renderMustache(mf, PagemetaPackage.eINSTANCE.getOpenGraphMeta_Type(), openGraph, context);
				renderMustache(mf, PagemetaPackage.eINSTANCE.getOpenGraphMeta_Url(), openGraph, context);
				renderMustache(mf, PagemetaPackage.eINSTANCE.getOpenGraphMeta_Image(), openGraph, context);
			}
			result.setPhase(PageMetaPhase.TEXT);
			return result;
		case TEXT:
			return EcoreUtil.copy(this);
		default:
			throw new IllegalStateException("Invalid phase " + phase + " to call toText()");
		}
	}

	/**
	 * @param context
	 * @param mf
	 */
	protected void renderMustache(final DefaultMustacheFactory mf, final EAttribute attr,
			final EObject target, final Object scope) {
		final String template = (String) target.eGet(attr);
		if (template == null)
			return;
		final Mustache tpl = mf.compile(new StringReader(template), attr.getName());
		final StringWriter writer = new StringWriter();
		try {
			tpl.execute(writer, scope);
		} catch (Throwable e) {
			throw new SiteException(e, "Cannot render mustache for %s.%s: %s",
					target.eClass().getName(), attr.getName(), template);
		}
		final String rendered = writer.toString();
		log.trace("Setting {}.{}='{}' from template: {}", target.eClass().getName(),
				attr.getName(), rendered, template);
		target.eSet(attr, rendered);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public PageMeta toFinal(String appTitle) {
//		log.debug("PageMeta toFinal..");
		log.debug("OpenGraphMeta: {}", this.getOpenGraph());
		switch (phase) {
		case TEXT:
			final PageMetaImpl result = EcoreUtil.copy(this);
			result.setTitle(result.getTitle() != null ? result.getTitle() + " | " + appTitle : appTitle);
			
			//open graph
			final OpenGraphMeta ogMeta;
			if (result.getOpenGraph() == null) {
				ogMeta = PagemetaFactory.eINSTANCE.createOpenGraphMeta();
				result.setOpenGraph(ogMeta);
			} else {
				ogMeta = result.getOpenGraph();
			}
			ogMeta.setTitle(ogMeta.getTitle() != null ? ogMeta.getTitle() : result.getTitle());
			ogMeta.setType(ogMeta.getType() != null ? ogMeta.getType() : "website");
			
			return result;
		case FINAL:
			return EcoreUtil.copy(this);
		default:
			throw new IllegalStateException("Invalid phase " + phase + " to call toFinal()");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PagemetaPackage.PAGE_META__ICON:
				return basicSetIcon(null, msgs);
			case PagemetaPackage.PAGE_META__OPEN_GRAPH:
				return basicSetOpenGraph(null, msgs);
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				return basicSetOpenGraphImage(null, msgs);
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				return basicSetOpenGraphVideo(null, msgs);
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
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
			case PagemetaPackage.PAGE_META__ICON:
				return getIcon();
			case PagemetaPackage.PAGE_META__LANGUAGE_CODE:
				return getLanguageCode();
			case PagemetaPackage.PAGE_META__OPEN_GRAPH:
				return getOpenGraph();
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				return getOpenGraphImage();
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				return getOpenGraphVideo();
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				return getOpenGraphAudio();
			case PagemetaPackage.PAGE_META__CHARSET:
				return getCharset();
			case PagemetaPackage.PAGE_META__TITLE:
				return getTitle();
			case PagemetaPackage.PAGE_META__KEYWORDS:
				return getKeywords();
			case PagemetaPackage.PAGE_META__DESCRIPTION:
				return getDescription();
			case PagemetaPackage.PAGE_META__VIEWPORT:
				return getViewport();
			case PagemetaPackage.PAGE_META__AUTHOR:
				return getAuthor();
			case PagemetaPackage.PAGE_META__PHASE:
				return getPhase();
			case PagemetaPackage.PAGE_META__ROBOTS:
				return getRobots();
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
			case PagemetaPackage.PAGE_META__ICON:
				setIcon((PageIcon)newValue);
				return;
			case PagemetaPackage.PAGE_META__LANGUAGE_CODE:
				setLanguageCode((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH:
				setOpenGraph((OpenGraphMeta)newValue);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				setOpenGraphImage((OpenGraphImage)newValue);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				setOpenGraphVideo((OpenGraphVideo)newValue);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				setOpenGraphAudio((OpenGraphAudio)newValue);
				return;
			case PagemetaPackage.PAGE_META__CHARSET:
				setCharset((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__TITLE:
				setTitle((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__KEYWORDS:
				setKeywords((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__VIEWPORT:
				setViewport((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__AUTHOR:
				setAuthor((String)newValue);
				return;
			case PagemetaPackage.PAGE_META__PHASE:
				setPhase((PageMetaPhase)newValue);
				return;
			case PagemetaPackage.PAGE_META__ROBOTS:
				setRobots((String)newValue);
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
			case PagemetaPackage.PAGE_META__ICON:
				setIcon((PageIcon)null);
				return;
			case PagemetaPackage.PAGE_META__LANGUAGE_CODE:
				setLanguageCode(LANGUAGE_CODE_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH:
				setOpenGraph((OpenGraphMeta)null);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				setOpenGraphImage((OpenGraphImage)null);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				setOpenGraphVideo((OpenGraphVideo)null);
				return;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				setOpenGraphAudio((OpenGraphAudio)null);
				return;
			case PagemetaPackage.PAGE_META__CHARSET:
				setCharset(CHARSET_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__KEYWORDS:
				setKeywords(KEYWORDS_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__VIEWPORT:
				setViewport(VIEWPORT_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__PHASE:
				setPhase(PHASE_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META__ROBOTS:
				setRobots(ROBOTS_EDEFAULT);
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
			case PagemetaPackage.PAGE_META__ICON:
				return icon != null;
			case PagemetaPackage.PAGE_META__LANGUAGE_CODE:
				return LANGUAGE_CODE_EDEFAULT == null ? languageCode != null : !LANGUAGE_CODE_EDEFAULT.equals(languageCode);
			case PagemetaPackage.PAGE_META__OPEN_GRAPH:
				return openGraph != null;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_IMAGE:
				return openGraphImage != null;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_VIDEO:
				return openGraphVideo != null;
			case PagemetaPackage.PAGE_META__OPEN_GRAPH_AUDIO:
				return openGraphAudio != null;
			case PagemetaPackage.PAGE_META__CHARSET:
				return CHARSET_EDEFAULT == null ? charset != null : !CHARSET_EDEFAULT.equals(charset);
			case PagemetaPackage.PAGE_META__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case PagemetaPackage.PAGE_META__KEYWORDS:
				return KEYWORDS_EDEFAULT == null ? keywords != null : !KEYWORDS_EDEFAULT.equals(keywords);
			case PagemetaPackage.PAGE_META__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PagemetaPackage.PAGE_META__VIEWPORT:
				return VIEWPORT_EDEFAULT == null ? viewport != null : !VIEWPORT_EDEFAULT.equals(viewport);
			case PagemetaPackage.PAGE_META__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case PagemetaPackage.PAGE_META__PHASE:
				return phase != PHASE_EDEFAULT;
			case PagemetaPackage.PAGE_META__ROBOTS:
				return ROBOTS_EDEFAULT == null ? robots != null : !ROBOTS_EDEFAULT.equals(robots);
		}
		return super.eIsSet(featureID);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageMetaImpl ["
				+ (icon != null ? "icon=" + icon + ", " : "")
				+ (languageCode != null ? "languageCode=" + languageCode + ", "
						: "")
				+ (openGraph != null ? "openGraph=" + openGraph + ", " : "")
				+ (openGraphImage != null ? "openGraphImage=" + openGraphImage
						+ ", " : "")
				+ (openGraphVideo != null ? "openGraphVideo=" + openGraphVideo
						+ ", " : "")
				+ (openGraphAudio != null ? "openGraphAudio=" + openGraphAudio
						+ ", " : "")
				+ (charset != null ? "charset=" + charset + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ (keywords != null ? "keywords=" + keywords + ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "")
				+ (viewport != null ? "viewport=" + viewport + ", " : "")
				+ (author != null ? "author=" + author : "") + "]";
	}

} //PageMetaImpl
