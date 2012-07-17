/**
 */
package org.soluvas.web.nav;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.web.nav.NavFactory
 * @model kind="package"
 * @generated
 */
public interface NavPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nav";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/nav/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nav";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NavPackage eINSTANCE = org.soluvas.web.nav.impl.NavPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.nav.MenuItemContainer <em>Menu Item Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.nav.MenuItemContainer
	 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenuItemContainer()
	 * @generated
	 */
	int MENU_ITEM_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_CONTAINER__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Menu Item Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.nav.impl.MenuItemImpl <em>Menu Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.nav.impl.MenuItemImpl
	 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenuItem()
	 * @generated
	 */
	int MENU_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__ITEMS = MENU_ITEM_CONTAINER__ITEMS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__ID = MENU_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__PARENT_ID = MENU_ITEM_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__LABEL = MENU_ITEM_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__WEIGHT = MENU_ITEM_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Menu Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_FEATURE_COUNT = MENU_ITEM_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.web.nav.impl.MenuImpl <em>Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.nav.impl.MenuImpl
	 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenu()
	 * @generated
	 */
	int MENU = 1;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ITEMS = MENU_ITEM_CONTAINER__ITEMS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ID = MENU_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_FEATURE_COUNT = MENU_ITEM_CONTAINER_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.soluvas.web.nav.impl.MenuCatalogImpl <em>Menu Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.nav.impl.MenuCatalogImpl
	 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenuCatalog()
	 * @generated
	 */
	int MENU_CATALOG = 3;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_CATALOG__ITEMS = MENU_ITEM_CONTAINER__ITEMS;

	/**
	 * The feature id for the '<em><b>Menus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_CATALOG__MENUS = MENU_ITEM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Menu Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_CATALOG_FEATURE_COUNT = MENU_ITEM_CONTAINER_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.nav.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Item</em>'.
	 * @see org.soluvas.web.nav.MenuItem
	 * @generated
	 */
	EClass getMenuItem();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.nav.MenuItem#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.soluvas.web.nav.MenuItem#getId()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.nav.MenuItem#getParentId <em>Parent Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Id</em>'.
	 * @see org.soluvas.web.nav.MenuItem#getParentId()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_ParentId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.nav.MenuItem#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.soluvas.web.nav.MenuItem#getLabel()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.nav.MenuItem#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.soluvas.web.nav.MenuItem#getWeight()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Weight();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.nav.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu</em>'.
	 * @see org.soluvas.web.nav.Menu
	 * @generated
	 */
	EClass getMenu();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.nav.Menu#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.soluvas.web.nav.Menu#getId()
	 * @see #getMenu()
	 * @generated
	 */
	EAttribute getMenu_Id();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.nav.MenuItemContainer <em>Menu Item Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Item Container</em>'.
	 * @see org.soluvas.web.nav.MenuItemContainer
	 * @generated
	 */
	EClass getMenuItemContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.nav.MenuItemContainer#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.soluvas.web.nav.MenuItemContainer#getItems()
	 * @see #getMenuItemContainer()
	 * @generated
	 */
	EReference getMenuItemContainer_Items();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.nav.MenuCatalog <em>Menu Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Catalog</em>'.
	 * @see org.soluvas.web.nav.MenuCatalog
	 * @generated
	 */
	EClass getMenuCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.nav.MenuCatalog#getMenus <em>Menus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Menus</em>'.
	 * @see org.soluvas.web.nav.MenuCatalog#getMenus()
	 * @see #getMenuCatalog()
	 * @generated
	 */
	EReference getMenuCatalog_Menus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NavFactory getNavFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.web.nav.impl.MenuItemImpl <em>Menu Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.nav.impl.MenuItemImpl
		 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenuItem()
		 * @generated
		 */
		EClass MENU_ITEM = eINSTANCE.getMenuItem();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__ID = eINSTANCE.getMenuItem_Id();

		/**
		 * The meta object literal for the '<em><b>Parent Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__PARENT_ID = eINSTANCE.getMenuItem_ParentId();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__LABEL = eINSTANCE.getMenuItem_Label();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__WEIGHT = eINSTANCE.getMenuItem_Weight();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.nav.impl.MenuImpl <em>Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.nav.impl.MenuImpl
		 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenu()
		 * @generated
		 */
		EClass MENU = eINSTANCE.getMenu();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU__ID = eINSTANCE.getMenu_Id();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.nav.MenuItemContainer <em>Menu Item Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.nav.MenuItemContainer
		 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenuItemContainer()
		 * @generated
		 */
		EClass MENU_ITEM_CONTAINER = eINSTANCE.getMenuItemContainer();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_ITEM_CONTAINER__ITEMS = eINSTANCE.getMenuItemContainer_Items();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.nav.impl.MenuCatalogImpl <em>Menu Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.nav.impl.MenuCatalogImpl
		 * @see org.soluvas.web.nav.impl.NavPackageImpl#getMenuCatalog()
		 * @generated
		 */
		EClass MENU_CATALOG = eINSTANCE.getMenuCatalog();

		/**
		 * The meta object literal for the '<em><b>Menus</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU_CATALOG__MENUS = eINSTANCE.getMenuCatalog_Menus();

	}

} //NavPackage
