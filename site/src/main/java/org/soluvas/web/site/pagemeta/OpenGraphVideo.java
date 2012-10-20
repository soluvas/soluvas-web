/**
 */
package org.soluvas.web.site.pagemeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Graph Video</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The og:video tag has the identical tags as og:image. Here is an example:
 * 
 * <meta property="og:video" content="http://example.com/movie.swf" />
 * <meta property="og:video:secure_url" content="https://secure.example.com/movie.swf" />
 * <meta property="og:video:type" content="application/x-shockwave-flash" />
 * <meta property="og:video:width" content="400" />
 * <meta property="og:video:height" content="300" />
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getUrl <em>Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getSecureUrl <em>Secure Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getType <em>Type</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphVideo()
 * @model
 * @generated
 */
public interface OpenGraphVideo extends EObject {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:url - Identical to og:image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphVideo_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Secure Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:secure_url - An alternate url to use if the webpage requires HTTPS.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Url</em>' attribute.
	 * @see #setSecureUrl(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphVideo_SecureUrl()
	 * @model
	 * @generated
	 */
	String getSecureUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getSecureUrl <em>Secure Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Url</em>' attribute.
	 * @see #getSecureUrl()
	 * @generated
	 */
	void setSecureUrl(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:type - A MIME type for this image.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphVideo_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:width - The number of pixels wide.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Integer)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphVideo_Width()
	 * @model
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:height - The number of pixels high.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(Integer)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphVideo_Height()
	 * @model
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

} // OpenGraphVideo
