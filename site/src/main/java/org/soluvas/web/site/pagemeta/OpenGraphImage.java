/**
 */
package org.soluvas.web.site.pagemeta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Graph Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The og:image property has some optional structured properties:
 * 
 * og:image:url - Identical to og:image.
 * og:image:secure_url - An alternate url to use if the webpage requires HTTPS.
 * og:image:type - A MIME type for this image.
 * og:image:width - The number of pixels wide.
 * og:image:height - The number of pixels high.
 * A full image example:
 * 
 * <meta property="og:image" content="http://example.com/ogp.jpg" />
 * <meta property="og:image:secure_url" content="https://secure.example.com/ogp.jpg" />
 * <meta property="og:image:type" content="image/jpeg" />
 * <meta property="og:image:width" content="400" />
 * <meta property="og:image:height" content="300" />
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getUrl <em>Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getSecureUrl <em>Secure Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getType <em>Type</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphImage()
 * @model
 * @generated
 */
public interface OpenGraphImage extends EObject {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:url - Identical to og:image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphImage_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getUrl <em>Url</em>}' attribute.
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
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphImage_SecureUrl()
	 * @model
	 * @generated
	 */
	String getSecureUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getSecureUrl <em>Secure Url</em>}' attribute.
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
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphImage_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getType <em>Type</em>}' attribute.
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
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphImage_Width()
	 * @model
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getWidth <em>Width</em>}' attribute.
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
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getOpenGraphImage_Height()
	 * @model
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

} // OpenGraphImage
