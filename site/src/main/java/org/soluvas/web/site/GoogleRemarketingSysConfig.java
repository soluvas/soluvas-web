/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Google Remarketing Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.GoogleRemarketingSysConfig#isGoogleRemarketingEnabled <em>Google Remarketing Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.GoogleRemarketingSysConfig#getGoogleRemarketingTagId <em>Google Remarketing Tag Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getGoogleRemarketingSysConfig()
 * @model
 * @generated
 */
public interface GoogleRemarketingSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Google Remarketing Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Google Remarketing Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Google Remarketing Enabled</em>' attribute.
	 * @see #setGoogleRemarketingEnabled(boolean)
	 * @see org.soluvas.web.site.SitePackage#getGoogleRemarketingSysConfig_GoogleRemarketingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isGoogleRemarketingEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleRemarketingSysConfig#isGoogleRemarketingEnabled <em>Google Remarketing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Remarketing Enabled</em>' attribute.
	 * @see #isGoogleRemarketingEnabled()
	 * @generated
	 */
	void setGoogleRemarketingEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Google Remarketing Tag Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Google Remarketing Tag Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Google Remarketing Tag Id</em>' attribute.
	 * @see #setGoogleRemarketingTagId(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleRemarketingSysConfig_GoogleRemarketingTagId()
	 * @model
	 * @generated
	 */
	String getGoogleRemarketingTagId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleRemarketingSysConfig#getGoogleRemarketingTagId <em>Google Remarketing Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Remarketing Tag Id</em>' attribute.
	 * @see #getGoogleRemarketingTagId()
	 * @generated
	 */
	void setGoogleRemarketingTagId(String value);

} // GoogleRemarketingSysConfig
