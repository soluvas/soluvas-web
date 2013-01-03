/**
 */
package org.soluvas.web.site.compose;

import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.Contributor#getPageClassName <em>Page Class Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.Contributor#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getContributor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Contributor extends BundleAware, ResourceAware {
	/**
	 * Returns the value of the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Class name of the page that hosts this.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Class Name</em>' attribute.
	 * @see #setPageClassName(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getContributor_PageClassName()
	 * @model required="true"
	 * @generated
	 */
	String getPageClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.Contributor#getPageClassName <em>Page Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Class Name</em>' attribute.
	 * @see #getPageClassName()
	 * @generated
	 */
	void setPageClassName(String value);

	/**
	 * Returns the value of the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Path</em>' attribute.
	 * @see #setTargetPath(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getContributor_TargetPath()
	 * @model required="true"
	 * @generated
	 */
	String getTargetPath();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.Contributor#getTargetPath <em>Target Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Path</em>' attribute.
	 * @see #getTargetPath()
	 * @generated
	 */
	void setTargetPath(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" bundleDataType="org.soluvas.web.site.compose.Bundle" bundleRequired="true"
	 * @generated
	 */
	LiveContributor createLive(Bundle bundle);

} // Contributor
