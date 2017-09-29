/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Zendesk Chat Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.ZendeskChatSysConfig#isZendeskChatEnabled <em>Zendesk Chat Enabled</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getZendeskChatSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ZendeskChatSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Zendesk Chat Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zendesk Chat Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zendesk Chat Enabled</em>' attribute.
	 * @see #setZendeskChatEnabled(boolean)
	 * @see org.soluvas.web.site.SitePackage#getZendeskChatSysConfig_ZendeskChatEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isZendeskChatEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ZendeskChatSysConfig#isZendeskChatEnabled <em>Zendesk Chat Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zendesk Chat Enabled</em>' attribute.
	 * @see #isZendeskChatEnabled()
	 * @generated
	 */
	void setZendeskChatEnabled(boolean value);

} // ZendeskChatSysConfig
