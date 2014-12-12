/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bing Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This will serve {@code /BingSiteAuth.xml} with the following content (for example):
 * 
 * <pre>
 * &lt;?xml version="1.0"?>
 * &lt;users>
 * 	&lt;user>81F7B85A49DDECE76EB169D2EFA46809</user>
 * &lt;/users>
 * </pre>
 * 
 * Go to <a href="https://www.bing.com/webmaster/home/mysites">Bing Webmaster</a> to get Bing Verify ID for your website.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.BingSysConfig#getBingVerifyId <em>Bing Verify Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getBingSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface BingSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Bing Verify Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bing Verify Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bing Verify Id</em>' attribute.
	 * @see #setBingVerifyId(String)
	 * @see org.soluvas.web.site.SitePackage#getBingSysConfig_BingVerifyId()
	 * @model
	 * @generated
	 */
	String getBingVerifyId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.BingSysConfig#getBingVerifyId <em>Bing Verify Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bing Verify Id</em>' attribute.
	 * @see #getBingVerifyId()
	 * @generated
	 */
	void setBingVerifyId(String value);

} // BingSysConfig
