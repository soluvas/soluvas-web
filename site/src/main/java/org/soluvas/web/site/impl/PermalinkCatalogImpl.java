/**
 */
package org.soluvas.web.site.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.site.Permalink;
import org.soluvas.web.site.PermalinkCatalog;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permalink Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.PermalinkCatalogImpl#getPermalinks <em>Permalinks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermalinkCatalogImpl extends EObjectImpl implements PermalinkCatalog {
	/**
	 * The cached value of the '{@link #getPermalinks() <em>Permalinks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermalinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Permalink> permalinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PermalinkCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.PERMALINK_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Permalink> getPermalinks() {
		if (permalinks == null) {
			permalinks = new EObjectContainmentEList<Permalink>(Permalink.class, this, SitePackage.PERMALINK_CATALOG__PERMALINKS);
		}
		return permalinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SitePackage.PERMALINK_CATALOG__PERMALINKS:
				return ((InternalEList<?>)getPermalinks()).basicRemove(otherEnd, msgs);
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
			case SitePackage.PERMALINK_CATALOG__PERMALINKS:
				return getPermalinks();
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
			case SitePackage.PERMALINK_CATALOG__PERMALINKS:
				getPermalinks().clear();
				getPermalinks().addAll((Collection<? extends Permalink>)newValue);
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
			case SitePackage.PERMALINK_CATALOG__PERMALINKS:
				getPermalinks().clear();
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
			case SitePackage.PERMALINK_CATALOG__PERMALINKS:
				return permalinks != null && !permalinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PermalinkCatalogImpl
