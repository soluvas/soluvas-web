/**
 */
package org.soluvas.web.nav;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.ProcessMenuItem#getProcessId <em>Process Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.nav.NavPackage#getProcessMenuItem()
 * @model
 * @generated
 */
public interface ProcessMenuItem extends MenuItem {
	/**
	 * Returns the value of the '<em><b>Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Id</em>' attribute.
	 * @see #setProcessId(String)
	 * @see org.soluvas.web.nav.NavPackage#getProcessMenuItem_ProcessId()
	 * @model
	 * @generated
	 */
	String getProcessId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.ProcessMenuItem#getProcessId <em>Process Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Id</em>' attribute.
	 * @see #getProcessId()
	 * @generated
	 */
	void setProcessId(String value);

} // ProcessMenuItem
