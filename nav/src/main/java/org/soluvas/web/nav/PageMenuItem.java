/**
 */
package org.soluvas.web.nav;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.PageMenuItem#getPageClass <em>Page Class</em>}</li>
 *   <li>{@link org.soluvas.web.nav.PageMenuItem#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.nav.NavPackage#getPageMenuItem()
 * @model
 * @generated
 */
public interface PageMenuItem extends MenuItem {
	/**
	 * Returns the value of the '<em><b>Page Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Class</em>' attribute.
	 * @see #setPageClass(String)
	 * @see org.soluvas.web.nav.NavPackage#getPageMenuItem_PageClass()
	 * @model required="true"
	 * @generated
	 */
	String getPageClass();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.PageMenuItem#getPageClass <em>Page Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Class</em>' attribute.
	 * @see #getPageClass()
	 * @generated
	 */
	void setPageClass(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' map.
	 * @see org.soluvas.web.nav.NavPackage#getPageMenuItem_Parameters()
	 * @model mapType="org.soluvas.web.nav.PageParameter<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getParameters();

} // PageMenuItem
