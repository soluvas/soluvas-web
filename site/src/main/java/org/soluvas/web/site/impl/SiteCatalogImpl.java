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

import org.soluvas.web.site.PageMeta;
import org.soluvas.web.site.PageMetaCollection;
import org.soluvas.web.site.PageRule;
import org.soluvas.web.site.PageRuleCollection;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SiteCatalog;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.SiteCatalogImpl#getPageMetas <em>Page Metas</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.SiteCatalogImpl#getPageRules <em>Page Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SiteCatalogImpl extends SectionCollectionImpl implements SiteCatalog {
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
	 * The cached value of the '{@link #getPageRules() <em>Page Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageRules()
	 * @generated
	 * @ordered
	 */
	protected EList<PageRule> pageRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiteCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.SITE_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageMeta> getPageMetas() {
		if (pageMetas == null) {
			pageMetas = new EObjectContainmentEList<PageMeta>(PageMeta.class, this, SitePackage.SITE_CATALOG__PAGE_METAS);
		}
		return pageMetas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageRule> getPageRules() {
		if (pageRules == null) {
			pageRules = new EObjectContainmentEList<PageRule>(PageRule.class, this, SitePackage.SITE_CATALOG__PAGE_RULES);
		}
		return pageRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SitePackage.SITE_CATALOG__PAGE_METAS:
				return ((InternalEList<?>)getPageMetas()).basicRemove(otherEnd, msgs);
			case SitePackage.SITE_CATALOG__PAGE_RULES:
				return ((InternalEList<?>)getPageRules()).basicRemove(otherEnd, msgs);
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
			case SitePackage.SITE_CATALOG__PAGE_METAS:
				return getPageMetas();
			case SitePackage.SITE_CATALOG__PAGE_RULES:
				return getPageRules();
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
			case SitePackage.SITE_CATALOG__PAGE_METAS:
				getPageMetas().clear();
				getPageMetas().addAll((Collection<? extends PageMeta>)newValue);
				return;
			case SitePackage.SITE_CATALOG__PAGE_RULES:
				getPageRules().clear();
				getPageRules().addAll((Collection<? extends PageRule>)newValue);
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
			case SitePackage.SITE_CATALOG__PAGE_METAS:
				getPageMetas().clear();
				return;
			case SitePackage.SITE_CATALOG__PAGE_RULES:
				getPageRules().clear();
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
			case SitePackage.SITE_CATALOG__PAGE_METAS:
				return pageMetas != null && !pageMetas.isEmpty();
			case SitePackage.SITE_CATALOG__PAGE_RULES:
				return pageRules != null && !pageRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PageMetaCollection.class) {
			switch (derivedFeatureID) {
				case SitePackage.SITE_CATALOG__PAGE_METAS: return SitePackage.PAGE_META_COLLECTION__PAGE_METAS;
				default: return -1;
			}
		}
		if (baseClass == PageRuleCollection.class) {
			switch (derivedFeatureID) {
				case SitePackage.SITE_CATALOG__PAGE_RULES: return SitePackage.PAGE_RULE_COLLECTION__PAGE_RULES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PageMetaCollection.class) {
			switch (baseFeatureID) {
				case SitePackage.PAGE_META_COLLECTION__PAGE_METAS: return SitePackage.SITE_CATALOG__PAGE_METAS;
				default: return -1;
			}
		}
		if (baseClass == PageRuleCollection.class) {
			switch (baseFeatureID) {
				case SitePackage.PAGE_RULE_COLLECTION__PAGE_RULES: return SitePackage.SITE_CATALOG__PAGE_RULES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SiteCatalogImpl
