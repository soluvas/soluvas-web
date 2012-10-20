/**
 */
package org.soluvas.web.site.pagemeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Meta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Low-level meta-information about a HTML page.
 * 
 * For practical purposes, these are usually provided dynamically. However, some information, like favicon URIs and OpenGraph siteName are usually provided statically from application's site catalog XMI e.g. berbatik.SiteCatalog.xmi.
 * 
 * Note that PageMeta uses low-level HTML title, not a "CMS title" (which needs to be reformatted i.e. with prefix & suffix).
 * It also distinguishes between meta description and og:description.
 * So it doesn't fit well to be provided statically.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraph <em>Open Graph</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphImage <em>Open Graph Image</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphVideo <em>Open Graph Video</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphAudio <em>Open Graph Audio</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getCharset <em>Charset</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getViewport <em>Viewport</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageMeta#getAuthor <em>Author</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta()
 * @model
 * @generated
 */
public interface PageMeta extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' containment reference.
	 * @see #setIcon(PageIcon)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Icon()
	 * @model containment="true"
	 * @generated
	 */
	PageIcon getIcon();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getIcon <em>Icon</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' containment reference.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(PageIcon value);

	/**
	 * Returns the value of the '<em><b>Language Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used in "html" tag, recommended is "en".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language Code</em>' attribute.
	 * @see #setLanguageCode(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_LanguageCode()
	 * @model
	 * @generated
	 */
	String getLanguageCode();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getLanguageCode <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Code</em>' attribute.
	 * @see #getLanguageCode()
	 * @generated
	 */
	void setLanguageCode(String value);

	/**
	 * Returns the value of the '<em><b>Open Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Graph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Graph</em>' containment reference.
	 * @see #setOpenGraph(OpenGraphMeta)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_OpenGraph()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphMeta getOpenGraph();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraph <em>Open Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Graph</em>' containment reference.
	 * @see #getOpenGraph()
	 * @generated
	 */
	void setOpenGraph(OpenGraphMeta value);

	/**
	 * Returns the value of the '<em><b>Open Graph Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Graph Image</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Graph Image</em>' containment reference.
	 * @see #setOpenGraphImage(OpenGraphImage)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_OpenGraphImage()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphImage getOpenGraphImage();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphImage <em>Open Graph Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Graph Image</em>' containment reference.
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	void setOpenGraphImage(OpenGraphImage value);

	/**
	 * Returns the value of the '<em><b>Open Graph Video</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Graph Video</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Graph Video</em>' containment reference.
	 * @see #setOpenGraphVideo(OpenGraphVideo)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_OpenGraphVideo()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphVideo getOpenGraphVideo();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphVideo <em>Open Graph Video</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Graph Video</em>' containment reference.
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	void setOpenGraphVideo(OpenGraphVideo value);

	/**
	 * Returns the value of the '<em><b>Open Graph Audio</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Graph Audio</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Graph Audio</em>' containment reference.
	 * @see #setOpenGraphAudio(OpenGraphAudio)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_OpenGraphAudio()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphAudio getOpenGraphAudio();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphAudio <em>Open Graph Audio</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Graph Audio</em>' containment reference.
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	void setOpenGraphAudio(OpenGraphAudio value);

	/**
	 * Returns the value of the '<em><b>Charset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Recommended: utf-8.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Charset</em>' attribute.
	 * @see #setCharset(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Charset()
	 * @model
	 * @generated
	 */
	String getCharset();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getCharset <em>Charset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Charset</em>' attribute.
	 * @see #getCharset()
	 * @generated
	 */
	void setCharset(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Keywords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keywords</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keywords</em>' attribute.
	 * @see #setKeywords(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Keywords()
	 * @model
	 * @generated
	 */
	String getKeywords();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getKeywords <em>Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keywords</em>' attribute.
	 * @see #getKeywords()
	 * @generated
	 */
	void setKeywords(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Viewport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Recommended: width=device-width, initial-scale=1.0
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Viewport</em>' attribute.
	 * @see #setViewport(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Viewport()
	 * @model
	 * @generated
	 */
	String getViewport();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getViewport <em>Viewport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewport</em>' attribute.
	 * @see #getViewport()
	 * @generated
	 */
	void setViewport(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getPageMeta_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageMeta#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

} // PageMeta
