/**
 */
package org.soluvas.web.site.pagemeta.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaCollection;
import org.soluvas.web.site.pagemeta.PageMetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCollectionImpl#getPageMetas <em>Page Metas</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageMetaCollectionImpl extends EObjectImpl implements PageMetaCollection {
	/**
	 * The cached value of the '{@link #getPageMetas() <em>Page Metas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageMetas()
	 * @generated
	 * @ordered
	 */
	protected EList<PageMeta> pageMetas;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMetaCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PageMetaPackage.Literals.PAGE_META_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageMeta> getPageMetas() {
		if (pageMetas == null) {
			pageMetas = new EObjectContainmentEList<PageMeta>(PageMeta.class, this, PageMetaPackage.PAGE_META_COLLECTION__PAGE_METAS);
		}
		return pageMetas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PageMetaPackage.PAGE_META_COLLECTION__PAGE_METAS:
				return ((InternalEList<?>)getPageMetas()).basicRemove(otherEnd, msgs);
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
			case PageMetaPackage.PAGE_META_COLLECTION__PAGE_METAS:
				return getPageMetas();
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
			case PageMetaPackage.PAGE_META_COLLECTION__PAGE_METAS:
				getPageMetas().clear();
				getPageMetas().addAll((Collection<? extends PageMeta>)newValue);
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
			case PageMetaPackage.PAGE_META_COLLECTION__PAGE_METAS:
				getPageMetas().clear();
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
			case PageMetaPackage.PAGE_META_COLLECTION__PAGE_METAS:
				return pageMetas != null && !pageMetas.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PageMetaCollectionImpl
