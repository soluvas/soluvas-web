/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Zendesk Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.ZendeskConfig#isZendeskEnabled <em>Zendesk Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.ZendeskConfig#getZendeskUrl <em>Zendesk Url</em>}</li>
 *   <li>{@link org.soluvas.web.site.ZendeskConfig#getZendeskToken <em>Zendesk Token</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getZendeskConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ZendeskConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Zendesk Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zendesk Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zendesk Enabled</em>' attribute.
	 * @see #setZendeskEnabled(boolean)
	 * @see org.soluvas.web.site.SitePackage#getZendeskConfig_ZendeskEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isZendeskEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ZendeskConfig#isZendeskEnabled <em>Zendesk Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zendesk Enabled</em>' attribute.
	 * @see #isZendeskEnabled()
	 * @generated
	 */
	void setZendeskEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Zendesk Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zendesk Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zendesk Url</em>' attribute.
	 * @see #setZendeskUrl(String)
	 * @see org.soluvas.web.site.SitePackage#getZendeskConfig_ZendeskUrl()
	 * @model
	 * @generated
	 */
	String getZendeskUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ZendeskConfig#getZendeskUrl <em>Zendesk Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zendesk Url</em>' attribute.
	 * @see #getZendeskUrl()
	 * @generated
	 */
	void setZendeskUrl(String value);

	/**
	 * Returns the value of the '<em><b>Zendesk Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zendesk Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zendesk Token</em>' attribute.
	 * @see #setZendeskToken(String)
	 * @see org.soluvas.web.site.SitePackage#getZendeskConfig_ZendeskToken()
	 * @model
	 * @generated
	 */
	String getZendeskToken();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ZendeskConfig#getZendeskToken <em>Zendesk Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zendesk Token</em>' attribute.
	 * @see #getZendeskToken()
	 * @generated
	 */
	void setZendeskToken(String value);

} // ZendeskConfig
