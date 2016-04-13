/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

import org.soluvas.web.olark.LiveChatProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Chat Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatEnabled <em>Live Chat Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatProviderId <em>Live Chat Provider Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatProvider <em>Live Chat Provider</em>}</li>
 *   <li>{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatSiteId <em>Live Chat Site Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getLiveChatSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LiveChatSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Live Chat Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether live chat feature is enabled.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Live Chat Enabled</em>' attribute.
	 * @see #setLiveChatEnabled(Boolean)
	 * @see org.soluvas.web.site.SitePackage#getLiveChatSysConfig_LiveChatEnabled()
	 * @model default="false"
	 * @generated
	 */
	Boolean getLiveChatEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatEnabled <em>Live Chat Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Live Chat Enabled</em>' attribute.
	 * @see #getLiveChatEnabled()
	 * @generated
	 */
	void setLiveChatEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Live Chat Provider Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Live chat provider, if enabled. Available choices: OLARK, LIVECHATINC.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Live Chat Provider Id</em>' attribute.
	 * @see #setLiveChatProviderId(String)
	 * @see org.soluvas.web.site.SitePackage#getLiveChatSysConfig_LiveChatProviderId()
	 * @model
	 * @generated
	 */
	String getLiveChatProviderId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatProviderId <em>Live Chat Provider Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Live Chat Provider Id</em>' attribute.
	 * @see #getLiveChatProviderId()
	 * @generated
	 */
	void setLiveChatProviderId(String value);

	/**
	 * Returns the value of the '<em><b>Live Chat Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Live chat provider, if enabled. Available choices: OLARK, LIVECHATINC.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Live Chat Provider</em>' attribute.
	 * @see org.soluvas.web.site.SitePackage#getLiveChatSysConfig_LiveChatProvider()
	 * @model dataType="org.soluvas.web.site.LiveChatProvider" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	LiveChatProvider getLiveChatProvider();

	/**
	 * Returns the value of the '<em><b>Live Chat Site Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Live chat site ID, if enabled. This is provider-specific.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Live Chat Site Id</em>' attribute.
	 * @see #setLiveChatSiteId(String)
	 * @see org.soluvas.web.site.SitePackage#getLiveChatSysConfig_LiveChatSiteId()
	 * @model
	 * @generated
	 */
	String getLiveChatSiteId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatSiteId <em>Live Chat Site Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Live Chat Site Id</em>' attribute.
	 * @see #getLiveChatSiteId()
	 * @generated
	 */
	void setLiveChatSiteId(String value);

} // LiveChatSysConfig
