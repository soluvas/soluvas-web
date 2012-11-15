/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.LiveContributorCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Live Contributor Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveContributorCollectionImpl#getLiveContributors <em>Live Contributors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiveContributorCollectionImpl extends EObjectImpl implements LiveContributorCollection {
	/**
	 * The cached value of the '{@link #getLiveContributors() <em>Live Contributors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiveContributors()
	 * @generated
	 * @ordered
	 */
	protected EList<LiveContributor> liveContributors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveContributorCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.LIVE_CONTRIBUTOR_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LiveContributor> getLiveContributors() {
		if (liveContributors == null) {
			liveContributors = new EObjectResolvingEList<LiveContributor>(LiveContributor.class, this, ComposePackage.LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS);
		}
		return liveContributors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComposePackage.LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS:
				return getLiveContributors();
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
			case ComposePackage.LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS:
				getLiveContributors().clear();
				getLiveContributors().addAll((Collection<? extends LiveContributor>)newValue);
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
			case ComposePackage.LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS:
				getLiveContributors().clear();
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
			case ComposePackage.LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS:
				return liveContributors != null && !liveContributors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LiveContributorCollectionImpl
