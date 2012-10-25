/**
 */
package org.soluvas.web.site.webaddress;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Tenant-wide website URI configuration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getBaseUri <em>Base Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getBasePath <em>Base Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getApiPath <em>Api Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getImagesUri <em>Images Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getCssUri <em>Css Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getJsUri <em>Js Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getSecureBaseUri <em>Secure Base Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getSecureImagesUri <em>Secure Images Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getSecureCssUri <em>Secure Css Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.webaddress.WebAddress#getSecureJsUri <em>Secure Js Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress()
 * @model
 * @generated
 */
public interface WebAddress extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI of the website. Used by email notifications, external servers, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Uri</em>' attribute.
	 * @see #setBaseUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_BaseUri()
	 * @model required="true"
	 * @generated
	 */
	String getBaseUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getBaseUri <em>Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Uri</em>' attribute.
	 * @see #getBaseUri()
	 * @generated
	 */
	void setBaseUri(String value);

	/**
	 * Returns the value of the '<em><b>Base Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute path to website, e.g. /
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Path</em>' attribute.
	 * @see #setBasePath(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_BasePath()
	 * @model required="true"
	 * @generated
	 */
	String getBasePath();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getBasePath <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Path</em>' attribute.
	 * @see #getBasePath()
	 * @generated
	 */
	void setBasePath(String value);

	/**
	 * Returns the value of the '<em><b>Api Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute path to API, e.g. /api/
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Api Path</em>' attribute.
	 * @see #setApiPath(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_ApiPath()
	 * @model required="true"
	 * @generated
	 */
	String getApiPath();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getApiPath <em>Api Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Path</em>' attribute.
	 * @see #getApiPath()
	 * @generated
	 */
	void setApiPath(String value);

	/**
	 * Returns the value of the '<em><b>Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to image files, e.g. http://images.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Images Uri</em>' attribute.
	 * @see #setImagesUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_ImagesUri()
	 * @model required="true"
	 * @generated
	 */
	String getImagesUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getImagesUri <em>Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Images Uri</em>' attribute.
	 * @see #getImagesUri()
	 * @generated
	 */
	void setImagesUri(String value);

	/**
	 * Returns the value of the '<em><b>Css Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to CSS files, e.g. http://css.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Css Uri</em>' attribute.
	 * @see #setCssUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_CssUri()
	 * @model required="true"
	 * @generated
	 */
	String getCssUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getCssUri <em>Css Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Css Uri</em>' attribute.
	 * @see #getCssUri()
	 * @generated
	 */
	void setCssUri(String value);

	/**
	 * Returns the value of the '<em><b>Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to JavaScript files, e.g. http://js.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Js Uri</em>' attribute.
	 * @see #setJsUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_JsUri()
	 * @model required="true"
	 * @generated
	 */
	String getJsUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getJsUri <em>Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Js Uri</em>' attribute.
	 * @see #getJsUri()
	 * @generated
	 */
	void setJsUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to website, e.g. https://www.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Base Uri</em>' attribute.
	 * @see #setSecureBaseUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_SecureBaseUri()
	 * @model
	 * @generated
	 */
	String getSecureBaseUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureBaseUri <em>Secure Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Base Uri</em>' attribute.
	 * @see #getSecureBaseUri()
	 * @generated
	 */
	void setSecureBaseUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to secure image files, e.g. https://images.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Images Uri</em>' attribute.
	 * @see #setSecureImagesUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_SecureImagesUri()
	 * @model
	 * @generated
	 */
	String getSecureImagesUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureImagesUri <em>Secure Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Images Uri</em>' attribute.
	 * @see #getSecureImagesUri()
	 * @generated
	 */
	void setSecureImagesUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Css Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to secure CSS files, e.g. https://css.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Css Uri</em>' attribute.
	 * @see #setSecureCssUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_SecureCssUri()
	 * @model
	 * @generated
	 */
	String getSecureCssUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureCssUri <em>Secure Css Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Css Uri</em>' attribute.
	 * @see #getSecureCssUri()
	 * @generated
	 */
	void setSecureCssUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secure Js Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secure Js Uri</em>' attribute.
	 * @see #setSecureJsUri(String)
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#getWebAddress_SecureJsUri()
	 * @model
	 * @generated
	 */
	String getSecureJsUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureJsUri <em>Secure Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Js Uri</em>' attribute.
	 * @see #getSecureJsUri()
	 * @generated
	 */
	void setSecureJsUri(String value);

} // WebAddress
