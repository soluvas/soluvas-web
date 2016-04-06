/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Perfect Audience Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.PerfectAudienceSysConfig#getPerfectAudienceId <em>Perfect Audience Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.PerfectAudienceSysConfig#getPerfectAudienceEnabled <em>Perfect Audience Enabled</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getPerfectAudienceSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PerfectAudienceSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Perfect Audience Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perfect Audience Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perfect Audience Id</em>' attribute.
	 * @see #setPerfectAudienceId(String)
	 * @see org.soluvas.web.site.SitePackage#getPerfectAudienceSysConfig_PerfectAudienceId()
	 * @model id="true"
	 * @generated
	 */
	String getPerfectAudienceId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PerfectAudienceSysConfig#getPerfectAudienceId <em>Perfect Audience Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perfect Audience Id</em>' attribute.
	 * @see #getPerfectAudienceId()
	 * @generated
	 */
	void setPerfectAudienceId(String value);

	/**
	 * Returns the value of the '<em><b>Perfect Audience Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perfect Audience Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perfect Audience Enabled</em>' attribute.
	 * @see #setPerfectAudienceEnabled(Boolean)
	 * @see org.soluvas.web.site.SitePackage#getPerfectAudienceSysConfig_PerfectAudienceEnabled()
	 * @model default="false"
	 * @generated
	 */
	Boolean getPerfectAudienceEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PerfectAudienceSysConfig#getPerfectAudienceEnabled <em>Perfect Audience Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perfect Audience Enabled</em>' attribute.
	 * @see #getPerfectAudienceEnabled()
	 * @generated
	 */
	void setPerfectAudienceEnabled(Boolean value);

} // PerfectAudienceSysConfig
