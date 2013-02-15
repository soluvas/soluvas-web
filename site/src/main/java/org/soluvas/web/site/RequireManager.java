/**
 */
package org.soluvas.web.site;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.RequireManager#getJavaScriptMode <em>Java Script Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getRequireManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface RequireManager extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Java Script Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.web.site.JavaScriptMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Script Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Script Mode</em>' attribute.
	 * @see org.soluvas.web.site.JavaScriptMode
	 * @see org.soluvas.web.site.SitePackage#getRequireManager_JavaScriptMode()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	JavaScriptMode getJavaScriptMode();

} // RequireManager
