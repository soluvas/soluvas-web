/**
 */
package org.soluvas.web.site.compose;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.Target#getPageClassName <em>Page Class Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.Target#getPath <em>Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.Target#getModelClassName <em>Model Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends ResourceAware, BundleAware {
	/**
	 * Returns the value of the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Class Name</em>' attribute.
	 * @see #setPageClassName(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getTarget_PageClassName()
	 * @model required="true"
	 * @generated
	 */
	String getPageClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.Target#getPageClassName <em>Page Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Class Name</em>' attribute.
	 * @see #getPageClassName()
	 * @generated
	 */
	void setPageClassName(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Path of the Component IDs from the Page.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getTarget_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.Target#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This model will be passed to the Contributor Factory to create the Component.
	 * 
	 * If it is null, that means the target IModel type is unknown, this can happen when it's a 'hide' contributor,
	 * Target EObject is created dynamically based on runtime reflection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Class Name</em>' attribute.
	 * @see #setModelClassName(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getTarget_ModelClassName()
	 * @model
	 * @generated
	 */
	String getModelClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.Target#getModelClassName <em>Model Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Class Name</em>' attribute.
	 * @see #getModelClassName()
	 * @generated
	 */
	void setModelClassName(String value);

} // Target
