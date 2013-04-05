/**
 */
package org.soluvas.web.olark;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.olark.LiveChatManager#getSiteId <em>Site Id</em>}</li>
 *   <li>{@link org.soluvas.web.olark.LiveChatManager#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.olark.LiveChatManager#getProvider <em>Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.olark.OlarkPackage#getLiveChatManager()
 * @model
 * @generated
 */
public interface LiveChatManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Site Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Site Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site Id</em>' attribute.
	 * @see org.soluvas.web.olark.OlarkPackage#getLiveChatManager_SiteId()
	 * @model default="" required="true" changeable="false"
	 * @generated
	 */
	String getSiteId();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see org.soluvas.web.olark.OlarkPackage#getLiveChatManager_Enabled()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.web.olark.LiveChatProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see org.soluvas.web.olark.LiveChatProvider
	 * @see #setProvider(LiveChatProvider)
	 * @see org.soluvas.web.olark.OlarkPackage#getLiveChatManager_Provider()
	 * @model
	 * @generated
	 */
	LiveChatProvider getProvider();

	/**
	 * Sets the value of the '{@link org.soluvas.web.olark.LiveChatManager#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see org.soluvas.web.olark.LiveChatProvider
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(LiveChatProvider value);

} // OlarkManager
