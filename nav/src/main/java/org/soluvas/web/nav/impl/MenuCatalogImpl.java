/**
 */
package org.soluvas.web.nav.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuCatalog;
import org.soluvas.web.nav.MenuItem;
import org.soluvas.web.nav.NavPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.impl.MenuCatalogImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuCatalogImpl#getMenus <em>Menus</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuCatalogImpl extends EObjectImpl implements MenuCatalog {
	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuItem> items;

	/**
	 * The cached value of the '{@link #getMenus() <em>Menus</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenus()
	 * @generated
	 * @ordered
	 */
	protected EList<Menu> menus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavPackage.Literals.MENU_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<MenuItem>(MenuItem.class, this, NavPackage.MENU_CATALOG__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Menu> getMenus() {
		if (menus == null) {
			menus = new EObjectContainmentEList<Menu>(Menu.class, this, NavPackage.MENU_CATALOG__MENUS);
		}
		return menus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavPackage.MENU_CATALOG__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
			case NavPackage.MENU_CATALOG__MENUS:
				return ((InternalEList<?>)getMenus()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NavPackage.MENU_CATALOG__ITEMS:
				return getItems();
			case NavPackage.MENU_CATALOG__MENUS:
				return getMenus();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NavPackage.MENU_CATALOG__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends MenuItem>)newValue);
				return;
			case NavPackage.MENU_CATALOG__MENUS:
				getMenus().clear();
				getMenus().addAll((Collection<? extends Menu>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NavPackage.MENU_CATALOG__ITEMS:
				getItems().clear();
				return;
			case NavPackage.MENU_CATALOG__MENUS:
				getMenus().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NavPackage.MENU_CATALOG__ITEMS:
				return items != null && !items.isEmpty();
			case NavPackage.MENU_CATALOG__MENUS:
				return menus != null && !menus.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MenuCatalogImpl
