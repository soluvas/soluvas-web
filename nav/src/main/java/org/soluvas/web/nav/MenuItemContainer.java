/**
 */
package org.soluvas.web.nav;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Item Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.MenuItemContainer#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.nav.NavPackage#getMenuItemContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MenuItemContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.nav.MenuItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.soluvas.web.nav.NavPackage#getMenuItemContainer_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuItem> getItems();

} // MenuItemContainer
