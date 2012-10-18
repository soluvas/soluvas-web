/**
 */
package org.soluvas.web.banner.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.banner.Banner;
import org.soluvas.web.banner.BannerCatalog;
import org.soluvas.web.banner.BannerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.banner.impl.BannerCatalogImpl#getBanners <em>Banners</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BannerCatalogImpl extends EObjectImpl implements BannerCatalog {
	/**
	 * The cached value of the '{@link #getBanners() <em>Banners</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBanners()
	 * @generated
	 * @ordered
	 */
	protected EList<Banner> banners;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BannerCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BannerPackage.Literals.BANNER_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Banner> getBanners() {
		if (banners == null) {
			banners = new EObjectContainmentEList<Banner>(Banner.class, this, BannerPackage.BANNER_CATALOG__BANNERS);
		}
		return banners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BannerPackage.BANNER_CATALOG__BANNERS:
				return ((InternalEList<?>)getBanners()).basicRemove(otherEnd, msgs);
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
			case BannerPackage.BANNER_CATALOG__BANNERS:
				return getBanners();
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
			case BannerPackage.BANNER_CATALOG__BANNERS:
				getBanners().clear();
				getBanners().addAll((Collection<? extends Banner>)newValue);
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
			case BannerPackage.BANNER_CATALOG__BANNERS:
				getBanners().clear();
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
			case BannerPackage.BANNER_CATALOG__BANNERS:
				return banners != null && !banners.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BannerCatalogImpl
