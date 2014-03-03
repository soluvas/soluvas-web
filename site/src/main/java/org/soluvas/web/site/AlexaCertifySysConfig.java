/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alexa Certify Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyEnabled <em>Alexa Certify Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyAccount <em>Alexa Certify Account</em>}</li>
 *   <li>{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyDomain <em>Alexa Certify Domain</em>}</li>
 *   <li>{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyJsCdn <em>Alexa Certify Js Cdn</em>}</li>
 *   <li>{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyImageCdn <em>Alexa Certify Image Cdn</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getAlexaCertifySysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AlexaCertifySysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Alexa Certify Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether Alexa Certify feature is enabled.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alexa Certify Enabled</em>' attribute.
	 * @see #setAlexaCertifyEnabled(Boolean)
	 * @see org.soluvas.web.site.SitePackage#getAlexaCertifySysConfig_AlexaCertifyEnabled()
	 * @model default="false"
	 * @generated
	 */
	Boolean getAlexaCertifyEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyEnabled <em>Alexa Certify Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alexa Certify Enabled</em>' attribute.
	 * @see #getAlexaCertifyEnabled()
	 * @generated
	 */
	void setAlexaCertifyEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Alexa Certify Account</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Account ID for Alexa Certify.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alexa Certify Account</em>' attribute.
	 * @see #setAlexaCertifyAccount(String)
	 * @see org.soluvas.web.site.SitePackage#getAlexaCertifySysConfig_AlexaCertifyAccount()
	 * @model
	 * @generated
	 */
	String getAlexaCertifyAccount();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyAccount <em>Alexa Certify Account</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alexa Certify Account</em>' attribute.
	 * @see #getAlexaCertifyAccount()
	 * @generated
	 */
	void setAlexaCertifyAccount(String value);

	/**
	 * Returns the value of the '<em><b>Alexa Certify Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Domain for Alexa Certify, e.g. "berbatik.com".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alexa Certify Domain</em>' attribute.
	 * @see #setAlexaCertifyDomain(String)
	 * @see org.soluvas.web.site.SitePackage#getAlexaCertifySysConfig_AlexaCertifyDomain()
	 * @model
	 * @generated
	 */
	String getAlexaCertifyDomain();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyDomain <em>Alexa Certify Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alexa Certify Domain</em>' attribute.
	 * @see #getAlexaCertifyDomain()
	 * @generated
	 */
	void setAlexaCertifyDomain(String value);

	/**
	 * Returns the value of the '<em><b>Alexa Certify Js Cdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Alexa Certify JavaScript CDN, embedded inside Alexa's script, which will be used to dynamically generate the script. e.g. "d31qbv1cthcecs.cloudfront.net"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alexa Certify Js Cdn</em>' attribute.
	 * @see #setAlexaCertifyJsCdn(String)
	 * @see org.soluvas.web.site.SitePackage#getAlexaCertifySysConfig_AlexaCertifyJsCdn()
	 * @model
	 * @generated
	 */
	String getAlexaCertifyJsCdn();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyJsCdn <em>Alexa Certify Js Cdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alexa Certify Js Cdn</em>' attribute.
	 * @see #getAlexaCertifyJsCdn()
	 * @generated
	 */
	void setAlexaCertifyJsCdn(String value);

	/**
	 * Returns the value of the '<em><b>Alexa Certify Image Cdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Alexa Certify Image CDN, embedded inside Alexa's script, which will be used to dynamically generate the script. e.g. "d5nxst8fruw4z.cloudfront.net"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alexa Certify Image Cdn</em>' attribute.
	 * @see #setAlexaCertifyImageCdn(String)
	 * @see org.soluvas.web.site.SitePackage#getAlexaCertifySysConfig_AlexaCertifyImageCdn()
	 * @model
	 * @generated
	 */
	String getAlexaCertifyImageCdn();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.AlexaCertifySysConfig#getAlexaCertifyImageCdn <em>Alexa Certify Image Cdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alexa Certify Image Cdn</em>' attribute.
	 * @see #getAlexaCertifyImageCdn()
	 * @generated
	 */
	void setAlexaCertifyImageCdn(String value);

} // AlexaCertifySysConfig
