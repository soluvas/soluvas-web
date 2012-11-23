/**
 */
package org.soluvas.web.site.pagemeta;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Graph Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The og:audio tag only has the first 3 properties available (since size doesn't make sense for sound):
 * 
 * <meta property="og:audio" content="http://example.com/sound.mp3" />
 * <meta property="og:audio:secure_url" content="https://secure.example.com/sound.mp3" />
 * <meta property="og:audio:type" content="audio/mpeg" />
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getUrl <em>Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getSecureUrl <em>Secure Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getOpenGraphAudio()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface OpenGraphAudio extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * og:image:url - Identical to og:image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getOpenGraphAudio_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getUrl <em>Url</em>}' attribute.
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
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getOpenGraphAudio_SecureUrl()
	 * @model
	 * @generated
	 */
	String getSecureUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getSecureUrl <em>Secure Url</em>}' attribute.
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
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getOpenGraphAudio_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // OpenGraphAudio
