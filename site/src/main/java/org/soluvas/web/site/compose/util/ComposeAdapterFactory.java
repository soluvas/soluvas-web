/**
 */
package org.soluvas.web.site.compose.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.web.site.compose.*;
import org.soluvas.web.site.compose.ChildContributor;
import org.soluvas.web.site.compose.ComponentContributor;
import org.soluvas.web.site.compose.ComposeCatalog;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.Contributor;
import org.soluvas.web.site.compose.ContributorCollection;
import org.soluvas.web.site.compose.HideContributor;
import org.soluvas.web.site.compose.LiveChildContributor;
import org.soluvas.web.site.compose.LiveComponentContributor;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.LiveContributorCollection;
import org.soluvas.web.site.compose.LiveHideContributor;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.LiveReplaceContributor;
import org.soluvas.web.site.compose.LiveSlave;
import org.soluvas.web.site.compose.LiveTarget;
import org.soluvas.web.site.compose.Placeholder;
import org.soluvas.web.site.compose.PlaceholderCollection;
import org.soluvas.web.site.compose.ReplaceContributor;
import org.soluvas.web.site.compose.Slave;
import org.soluvas.web.site.compose.SlaveCollection;
import org.soluvas.web.site.compose.Target;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.compose.ComposePackage
 * @generated
 */
public class ComposeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComposePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ComposePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposeSwitch<Adapter> modelSwitch =
		new ComposeSwitch<Adapter>() {
			@Override
			public Adapter casePlaceholder(Placeholder object) {
				return createPlaceholderAdapter();
			}
			@Override
			public Adapter caseContributor(Contributor object) {
				return createContributorAdapter();
			}
			@Override
			public Adapter caseLiveTarget(LiveTarget object) {
				return createLiveTargetAdapter();
			}
			@Override
			public Adapter caseLiveContributor(LiveContributor object) {
				return createLiveContributorAdapter();
			}
			@Override
			public Adapter caseHideContributor(HideContributor object) {
				return createHideContributorAdapter();
			}
			@Override
			public Adapter caseComponentContributor(ComponentContributor object) {
				return createComponentContributorAdapter();
			}
			@Override
			public Adapter caseChildContributor(ChildContributor object) {
				return createChildContributorAdapter();
			}
			@Override
			public Adapter caseLiveChildContributor(LiveChildContributor object) {
				return createLiveChildContributorAdapter();
			}
			@Override
			public Adapter caseLiveReplaceContributor(LiveReplaceContributor object) {
				return createLiveReplaceContributorAdapter();
			}
			@Override
			public Adapter caseReplaceContributor(ReplaceContributor object) {
				return createReplaceContributorAdapter();
			}
			@Override
			public Adapter caseLiveComponentContributor(LiveComponentContributor object) {
				return createLiveComponentContributorAdapter();
			}
			@Override
			public Adapter caseLiveHideContributor(LiveHideContributor object) {
				return createLiveHideContributorAdapter();
			}
			@Override
			public Adapter caseComposeCatalog(ComposeCatalog object) {
				return createComposeCatalogAdapter();
			}
			@Override
			public Adapter caseSlave(Slave object) {
				return createSlaveAdapter();
			}
			@Override
			public Adapter caseTarget(Target object) {
				return createTargetAdapter();
			}
			@Override
			public Adapter casePlaceholderCollection(PlaceholderCollection object) {
				return createPlaceholderCollectionAdapter();
			}
			@Override
			public Adapter caseSlaveCollection(SlaveCollection object) {
				return createSlaveCollectionAdapter();
			}
			@Override
			public Adapter caseLivePlaceholder(LivePlaceholder object) {
				return createLivePlaceholderAdapter();
			}
			@Override
			public Adapter caseLiveSlave(LiveSlave object) {
				return createLiveSlaveAdapter();
			}
			@Override
			public Adapter caseLiveContributorCollection(LiveContributorCollection object) {
				return createLiveContributorCollectionAdapter();
			}
			@Override
			public Adapter caseContributorCollection(ContributorCollection object) {
				return createContributorCollectionAdapter();
			}
			@Override
			public Adapter caseResourceAware(ResourceAware object) {
				return createResourceAwareAdapter();
			}
			@Override
			public Adapter caseBundleAware(BundleAware object) {
				return createBundleAwareAdapter();
			}
			@Override
			public Adapter casePositionable(Positionable object) {
				return createPositionableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.Placeholder <em>Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.Placeholder
	 * @generated
	 */
	public Adapter createPlaceholderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.Contributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.Contributor
	 * @generated
	 */
	public Adapter createContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveTarget <em>Live Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveTarget
	 * @generated
	 */
	public Adapter createLiveTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveContributor <em>Live Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveContributor
	 * @generated
	 */
	public Adapter createLiveContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.HideContributor <em>Hide Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.HideContributor
	 * @generated
	 */
	public Adapter createHideContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.ComponentContributor <em>Component Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.ComponentContributor
	 * @generated
	 */
	public Adapter createComponentContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.ChildContributor <em>Child Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.ChildContributor
	 * @generated
	 */
	public Adapter createChildContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveChildContributor <em>Live Child Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveChildContributor
	 * @generated
	 */
	public Adapter createLiveChildContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveReplaceContributor <em>Live Replace Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveReplaceContributor
	 * @generated
	 */
	public Adapter createLiveReplaceContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.ReplaceContributor <em>Replace Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.ReplaceContributor
	 * @generated
	 */
	public Adapter createReplaceContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveComponentContributor <em>Live Component Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveComponentContributor
	 * @generated
	 */
	public Adapter createLiveComponentContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveHideContributor <em>Live Hide Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveHideContributor
	 * @generated
	 */
	public Adapter createLiveHideContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.ComposeCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.ComposeCatalog
	 * @generated
	 */
	public Adapter createComposeCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.Slave <em>Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.Slave
	 * @generated
	 */
	public Adapter createSlaveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.Target
	 * @generated
	 */
	public Adapter createTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.PlaceholderCollection <em>Placeholder Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.PlaceholderCollection
	 * @generated
	 */
	public Adapter createPlaceholderCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.SlaveCollection <em>Slave Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.SlaveCollection
	 * @generated
	 */
	public Adapter createSlaveCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LivePlaceholder <em>Live Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LivePlaceholder
	 * @generated
	 */
	public Adapter createLivePlaceholderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveSlave <em>Live Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveSlave
	 * @generated
	 */
	public Adapter createLiveSlaveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.LiveContributorCollection <em>Live Contributor Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.LiveContributorCollection
	 * @generated
	 */
	public Adapter createLiveContributorCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.compose.ContributorCollection <em>Contributor Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.compose.ContributorCollection
	 * @generated
	 */
	public Adapter createContributorCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ResourceAware <em>Resource Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ResourceAware
	 * @generated
	 */
	public Adapter createResourceAwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.BundleAware <em>Bundle Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.BundleAware
	 * @generated
	 */
	public Adapter createBundleAwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Positionable <em>Positionable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Positionable
	 * @generated
	 */
	public Adapter createPositionableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ComposeAdapterFactory
