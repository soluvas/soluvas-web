/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Google Webmasters Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SysConfig for <a href="https://www.google.com/webmasters/tools/home">Google Webmasters Toolkit</a>.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.GoogleWebmastersSysConfig#getGoogleWebmastersVerifyId <em>Google Webmasters Verify Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getGoogleWebmastersSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GoogleWebmastersSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Google Webmasters Verify Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Google site verification ID, e.g. {@code google187974e610426105}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Webmasters Verify Id</em>' attribute.
	 * @see #setGoogleWebmastersVerifyId(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleWebmastersSysConfig_GoogleWebmastersVerifyId()
	 * @model
	 * @generated
	 */
	String getGoogleWebmastersVerifyId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleWebmastersSysConfig#getGoogleWebmastersVerifyId <em>Google Webmasters Verify Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Webmasters Verify Id</em>' attribute.
	 * @see #getGoogleWebmastersVerifyId()
	 * @generated
	 */
	void setGoogleWebmastersVerifyId(String value);

} // GoogleWebmastersSysConfig
