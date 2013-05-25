/**
 */
package org.soluvas.web.nav.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.nav.NavPackage;
import org.soluvas.web.nav.PageMenuItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.impl.PageMenuItemImpl#getPageClass <em>Page Class</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.PageMenuItemImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageMenuItemImpl extends MenuItemImpl implements PageMenuItem {
	/**
	 * The default value of the '{@link #getPageClass() <em>Page Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageClass()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageClass() <em>Page Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageClass()
	 * @generated
	 * @ordered
	 */
	protected String pageClass = PAGE_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMenuItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavPackage.Literals.PAGE_MENU_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPageClass() {
		return pageClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageClass(String newPageClass) {
		String oldPageClass = pageClass;
		pageClass = newPageClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.PAGE_MENU_ITEM__PAGE_CLASS, oldPageClass, pageClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getParameters() {
		if (parameters == null) {
			parameters = new EcoreEMap<String,String>(NavPackage.Literals.PAGE_PARAMETER, PageParameterImpl.class, this, NavPackage.PAGE_MENU_ITEM__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavPackage.PAGE_MENU_ITEM__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case NavPackage.PAGE_MENU_ITEM__PAGE_CLASS:
				return getPageClass();
			case NavPackage.PAGE_MENU_ITEM__PARAMETERS:
				if (coreType) return getParameters();
				else return getParameters().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NavPackage.PAGE_MENU_ITEM__PAGE_CLASS:
				setPageClass((String)newValue);
				return;
			case NavPackage.PAGE_MENU_ITEM__PARAMETERS:
				((EStructuralFeature.Setting)getParameters()).set(newValue);
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
			case NavPackage.PAGE_MENU_ITEM__PAGE_CLASS:
				setPageClass(PAGE_CLASS_EDEFAULT);
				return;
			case NavPackage.PAGE_MENU_ITEM__PARAMETERS:
				getParameters().clear();
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
			case NavPackage.PAGE_MENU_ITEM__PAGE_CLASS:
				return PAGE_CLASS_EDEFAULT == null ? pageClass != null : !PAGE_CLASS_EDEFAULT.equals(pageClass);
			case NavPackage.PAGE_MENU_ITEM__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (pageClass: ");
		result.append(pageClass);
		result.append(')');
		return result.toString();
	}

} //PageMenuItemImpl
