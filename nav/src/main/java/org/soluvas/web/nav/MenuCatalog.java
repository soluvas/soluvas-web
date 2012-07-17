/**
 */
package org.soluvas.web.nav;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.MenuCatalog#getMenus <em>Menus</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.nav.NavPackage#getMenuCatalog()
 * @model
 * @generated
 */
public interface MenuCatalog extends MenuItemContainer {
	/**
	 * Returns the value of the '<em><b>Menus</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.nav.Menu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menus</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menus</em>' containment reference list.
	 * @see org.soluvas.web.nav.NavPackage#getMenuCatalog_Menus()
	 * @model containment="true"
	 * @generated
	 */
	EList<Menu> getMenus();

} // MenuCatalog
