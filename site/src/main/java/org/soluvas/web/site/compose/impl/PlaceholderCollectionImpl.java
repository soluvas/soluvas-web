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
import org.soluvas.web.site.compose.Placeholder;
import org.soluvas.web.site.compose.PlaceholderCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Placeholder Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.PlaceholderCollectionImpl#getPlaceholders <em>Placeholders</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaceholderCollectionImpl extends EObjectImpl implements PlaceholderCollection {
	/**
	 * The cached value of the '{@link #getPlaceholders() <em>Placeholders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceholders()
	 * @generated
	 * @ordered
	 */
	protected EList<Placeholder> placeholders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlaceholderCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.PLACEHOLDER_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Placeholder> getPlaceholders() {
		if (placeholders == null) {
			placeholders = new EObjectContainmentEList<Placeholder>(Placeholder.class, this, ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS);
		}
		return placeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS:
				return ((InternalEList<?>)getPlaceholders()).basicRemove(otherEnd, msgs);
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
			case ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS:
				return getPlaceholders();
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
			case ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS:
				getPlaceholders().clear();
				getPlaceholders().addAll((Collection<? extends Placeholder>)newValue);
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
			case ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS:
				getPlaceholders().clear();
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
			case ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS:
				return placeholders != null && !placeholders.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlaceholderCollectionImpl
