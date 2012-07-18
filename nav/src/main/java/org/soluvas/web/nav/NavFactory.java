/**
 */
package org.soluvas.web.nav;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.nav.NavPackage
 * @generated
 */
public interface NavFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NavFactory eINSTANCE = org.soluvas.web.nav.impl.NavFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menu Item</em>'.
	 * @generated
	 */
	MenuItem createMenuItem();

	/**
	 * Returns a new object of class '<em>Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menu</em>'.
	 * @generated
	 */
	Menu createMenu();

	/**
	 * Returns a new object of class '<em>Menu Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menu Catalog</em>'.
	 * @generated
	 */
	MenuCatalog createMenuCatalog();

	/**
	 * Returns a new object of class '<em>Page Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Menu Item</em>'.
	 * @generated
	 */
	PageMenuItem createPageMenuItem();

	/**
	 * Returns a new object of class '<em>Process Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Menu Item</em>'.
	 * @generated
	 */
	ProcessMenuItem createProcessMenuItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NavPackage getNavPackage();

} //NavFactory
