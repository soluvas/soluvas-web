/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.Page#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getOpenGraph <em>Open Graph</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getOpenGraphImage <em>Open Graph Image</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getOpenGraphVideo <em>Open Graph Video</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getOpenGraphAudio <em>Open Graph Audio</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getPage()
 * @model
 * @generated
 */
public interface Page extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' containment reference.
	 * @see #setMeta(PageMeta)
	 * @see org.soluvas.web.site.SitePackage#getPage_Meta()
	 * @model containment="true"
	 * @generated
	 */
	PageMeta getMeta();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getMeta <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' containment reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(PageMeta value);

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
	 * @see org.soluvas.web.site.SitePackage#getPage_Icon()
	 * @model containment="true"
	 * @generated
	 */
	PageIcon getIcon();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getIcon <em>Icon</em>}' containment reference.
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
	 * @see org.soluvas.web.site.SitePackage#getPage_LanguageCode()
	 * @model
	 * @generated
	 */
	String getLanguageCode();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getLanguageCode <em>Language Code</em>}' attribute.
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
	 * @see org.soluvas.web.site.SitePackage#getPage_OpenGraph()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphMeta getOpenGraph();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getOpenGraph <em>Open Graph</em>}' containment reference.
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
	 * @see org.soluvas.web.site.SitePackage#getPage_OpenGraphImage()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphImage getOpenGraphImage();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getOpenGraphImage <em>Open Graph Image</em>}' containment reference.
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
	 * @see org.soluvas.web.site.SitePackage#getPage_OpenGraphVideo()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphVideo getOpenGraphVideo();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getOpenGraphVideo <em>Open Graph Video</em>}' containment reference.
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
	 * @see org.soluvas.web.site.SitePackage#getPage_OpenGraphAudio()
	 * @model containment="true"
	 * @generated
	 */
	OpenGraphAudio getOpenGraphAudio();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getOpenGraphAudio <em>Open Graph Audio</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Graph Audio</em>' containment reference.
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	void setOpenGraphAudio(OpenGraphAudio value);

} // Page
