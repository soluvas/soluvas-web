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
 *   <li>{@link org.soluvas.web.olark.OlarkManager#getSiteId <em>Site Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.olark.OlarkPackage#getOlarkManager()
 * @model
 * @generated
 */
public interface OlarkManager extends EObject {
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
	 * @see org.soluvas.web.olark.OlarkPackage#getOlarkManager_SiteId()
	 * @model default="" required="true" changeable="false"
	 * @generated
	 */
	String getSiteId();

} // OlarkManager
