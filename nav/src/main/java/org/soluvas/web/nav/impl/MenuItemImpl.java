/**
 */
package org.soluvas.web.nav.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.framework.Bundle;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.soluvas.web.nav.MenuItem;
import org.soluvas.web.nav.NavPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getParentId <em>Parent Id</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.nav.impl.MenuItemImpl#getIconName <em>Icon Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuItemImpl extends EObjectImpl implements MenuItem {
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentId() <em>Parent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentId() <em>Parent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentId()
	 * @generated
	 * @ordered
	 */
	protected String parentId = PARENT_ID_EDEFAULT;

	/**
	 * This is true if the Parent Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean parentIdESet;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconName() <em>Icon Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconName()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconName() <em>Icon Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconName()
	 * @generated
	 * @ordered
	 */
	protected String iconName = ICON_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavPackage.Literals.MENU_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<MenuItem>(MenuItem.class, this, NavPackage.MENU_ITEM__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.MENU_ITEM__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentId(String newParentId) {
		String oldParentId = parentId;
		parentId = newParentId;
		boolean oldParentIdESet = parentIdESet;
		parentIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.MENU_ITEM__PARENT_ID, oldParentId, parentId, !oldParentIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetParentId() {
		String oldParentId = parentId;
		boolean oldParentIdESet = parentIdESet;
		parentId = PARENT_ID_EDEFAULT;
		parentIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NavPackage.MENU_ITEM__PARENT_ID, oldParentId, PARENT_ID_EDEFAULT, oldParentIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParentId() {
		return parentIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.MENU_ITEM__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.MENU_ITEM__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.MENU_ITEM__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconName() {
		return iconName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconName(String newIconName) {
		String oldIconName = iconName;
		iconName = newIconName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavPackage.MENU_ITEM__ICON_NAME, oldIconName, iconName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavPackage.MENU_ITEM__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
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
			case NavPackage.MENU_ITEM__ITEMS:
				return getItems();
			case NavPackage.MENU_ITEM__ID:
				return getId();
			case NavPackage.MENU_ITEM__PARENT_ID:
				return getParentId();
			case NavPackage.MENU_ITEM__LABEL:
				return getLabel();
			case NavPackage.MENU_ITEM__WEIGHT:
				return getWeight();
			case NavPackage.MENU_ITEM__BUNDLE:
				return getBundle();
			case NavPackage.MENU_ITEM__ICON_NAME:
				return getIconName();
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
			case NavPackage.MENU_ITEM__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends MenuItem>)newValue);
				return;
			case NavPackage.MENU_ITEM__ID:
				setId((String)newValue);
				return;
			case NavPackage.MENU_ITEM__PARENT_ID:
				setParentId((String)newValue);
				return;
			case NavPackage.MENU_ITEM__LABEL:
				setLabel((String)newValue);
				return;
			case NavPackage.MENU_ITEM__WEIGHT:
				setWeight((Integer)newValue);
				return;
			case NavPackage.MENU_ITEM__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case NavPackage.MENU_ITEM__ICON_NAME:
				setIconName((String)newValue);
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
			case NavPackage.MENU_ITEM__ITEMS:
				getItems().clear();
				return;
			case NavPackage.MENU_ITEM__ID:
				setId(ID_EDEFAULT);
				return;
			case NavPackage.MENU_ITEM__PARENT_ID:
				unsetParentId();
				return;
			case NavPackage.MENU_ITEM__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case NavPackage.MENU_ITEM__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case NavPackage.MENU_ITEM__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case NavPackage.MENU_ITEM__ICON_NAME:
				setIconName(ICON_NAME_EDEFAULT);
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
			case NavPackage.MENU_ITEM__ITEMS:
				return items != null && !items.isEmpty();
			case NavPackage.MENU_ITEM__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NavPackage.MENU_ITEM__PARENT_ID:
				return isSetParentId();
			case NavPackage.MENU_ITEM__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case NavPackage.MENU_ITEM__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case NavPackage.MENU_ITEM__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case NavPackage.MENU_ITEM__ICON_NAME:
				return ICON_NAME_EDEFAULT == null ? iconName != null : !ICON_NAME_EDEFAULT.equals(iconName);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", parentId: ");
		if (parentIdESet) result.append(parentId); else result.append("<unset>");
		result.append(", label: ");
		result.append(label);
		result.append(", weight: ");
		result.append(weight);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", iconName: ");
		result.append(iconName);
		result.append(')');
		return result.toString();
	}

} //MenuItemImpl
