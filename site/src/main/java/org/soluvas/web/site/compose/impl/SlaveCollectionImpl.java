/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.Slave;
import org.soluvas.web.site.compose.SlaveCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slave Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.SlaveCollectionImpl#getSlaves <em>Slaves</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlaveCollectionImpl extends EObjectImpl implements SlaveCollection {
	/**
	 * The cached value of the '{@link #getSlaves() <em>Slaves</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlaves()
	 * @generated
	 * @ordered
	 */
	protected EList<Slave> slaves;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlaveCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.SLAVE_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Slave> getSlaves() {
		if (slaves == null) {
			slaves = new EObjectContainmentEList<Slave>(Slave.class, this, ComposePackage.SLAVE_COLLECTION__SLAVES);
		}
		return slaves;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComposePackage.SLAVE_COLLECTION__SLAVES:
				return ((InternalEList<?>)getSlaves()).basicRemove(otherEnd, msgs);
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
			case ComposePackage.SLAVE_COLLECTION__SLAVES:
				return getSlaves();
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
			case ComposePackage.SLAVE_COLLECTION__SLAVES:
				getSlaves().clear();
				getSlaves().addAll((Collection<? extends Slave>)newValue);
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
			case ComposePackage.SLAVE_COLLECTION__SLAVES:
				getSlaves().clear();
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
			case ComposePackage.SLAVE_COLLECTION__SLAVES:
				return slaves != null && !slaves.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SlaveCollectionImpl
