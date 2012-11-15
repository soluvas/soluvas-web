/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.site.compose.ComposeCatalog;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.Contributor;
import org.soluvas.web.site.compose.ContributorCollection;
import org.soluvas.web.site.compose.Placeholder;
import org.soluvas.web.site.compose.PlaceholderCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.ComposeCatalogImpl#getPlaceholders <em>Placeholders</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.ComposeCatalogImpl#getContributors <em>Contributors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComposeCatalogImpl extends SlaveCollectionImpl implements ComposeCatalog {
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
	 * The cached value of the '{@link #getContributors() <em>Contributors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributors()
	 * @generated
	 * @ordered
	 */
	protected EList<Contributor> contributors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.COMPOSE_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Placeholder> getPlaceholders() {
		if (placeholders == null) {
			placeholders = new EObjectContainmentEList<Placeholder>(Placeholder.class, this, ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS);
		}
		return placeholders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contributor> getContributors() {
		if (contributors == null) {
			contributors = new EObjectContainmentEList<Contributor>(Contributor.class, this, ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS);
		}
		return contributors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS:
				return ((InternalEList<?>)getPlaceholders()).basicRemove(otherEnd, msgs);
			case ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS:
				return ((InternalEList<?>)getContributors()).basicRemove(otherEnd, msgs);
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
			case ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS:
				return getPlaceholders();
			case ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS:
				return getContributors();
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
			case ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS:
				getPlaceholders().clear();
				getPlaceholders().addAll((Collection<? extends Placeholder>)newValue);
				return;
			case ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS:
				getContributors().clear();
				getContributors().addAll((Collection<? extends Contributor>)newValue);
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
			case ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS:
				getPlaceholders().clear();
				return;
			case ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS:
				getContributors().clear();
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
			case ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS:
				return placeholders != null && !placeholders.isEmpty();
			case ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS:
				return contributors != null && !contributors.isEmpty();
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
		if (baseClass == PlaceholderCollection.class) {
			switch (derivedFeatureID) {
				case ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS: return ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS;
				default: return -1;
			}
		}
		if (baseClass == ContributorCollection.class) {
			switch (derivedFeatureID) {
				case ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS: return ComposePackage.CONTRIBUTOR_COLLECTION__CONTRIBUTORS;
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
		if (baseClass == PlaceholderCollection.class) {
			switch (baseFeatureID) {
				case ComposePackage.PLACEHOLDER_COLLECTION__PLACEHOLDERS: return ComposePackage.COMPOSE_CATALOG__PLACEHOLDERS;
				default: return -1;
			}
		}
		if (baseClass == ContributorCollection.class) {
			switch (baseFeatureID) {
				case ComposePackage.CONTRIBUTOR_COLLECTION__CONTRIBUTORS: return ComposePackage.COMPOSE_CATALOG__CONTRIBUTORS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ComposeCatalogImpl
