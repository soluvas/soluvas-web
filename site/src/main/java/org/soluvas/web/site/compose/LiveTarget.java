/**
 */
package org.soluvas.web.site.compose;

import org.apache.wicket.Page;

import org.osgi.framework.Bundle;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.LiveTarget#getPageClass <em>Page Class</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.LiveTarget#getBundle <em>Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveTarget()
 * @model
 * @generated
 */
public interface LiveTarget extends Target {
	/**
	 * Returns the value of the '<em><b>Page Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Note that since bundles that provide a Page and/or ComponentFactory can come and go, a LinkedContributor can be gone at any time as well.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Class</em>' attribute.
	 * @see #setPageClass(Class)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveTarget_PageClass()
	 * @model required="true"
	 * @generated
	 */
	Class<Page> getPageClass();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveTarget#getPageClass <em>Page Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Class</em>' attribute.
	 * @see #getPageClass()
	 * @generated
	 */
	void setPageClass(Class<Page> value);

	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(Bundle)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveTarget_Bundle()
	 * @model dataType="org.soluvas.web.site.compose.Bundle" required="true" transient="true"
	 * @generated
	 */
	Bundle getBundle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveTarget#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(Bundle value);

} // LiveTarget
