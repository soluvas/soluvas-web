/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;
import java.util.List;
import org.apache.wicket.Page;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.web.site.compose.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComposeFactoryImpl extends EFactoryImpl implements ComposeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComposeFactory init() {
		try {
			ComposeFactory theComposeFactory = (ComposeFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/web.compose/1.0"); 
			if (theComposeFactory != null) {
				return theComposeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComposeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComposePackage.PLACEHOLDER: return createPlaceholder();
			case ComposePackage.LIVE_TARGET: return createLiveTarget();
			case ComposePackage.HIDE_CONTRIBUTOR: return createHideContributor();
			case ComposePackage.CHILD_CONTRIBUTOR: return createChildContributor();
			case ComposePackage.LIVE_CHILD_CONTRIBUTOR: return createLiveChildContributor();
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR: return createLiveReplaceContributor();
			case ComposePackage.REPLACE_CONTRIBUTOR: return createReplaceContributor();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR: return createLiveComponentContributor();
			case ComposePackage.LIVE_HIDE_CONTRIBUTOR: return createLiveHideContributor();
			case ComposePackage.COMPOSE_CATALOG: return createComposeCatalog();
			case ComposePackage.SLAVE: return createSlave();
			case ComposePackage.TARGET: return createTarget();
			case ComposePackage.PLACEHOLDER_COLLECTION: return createPlaceholderCollection();
			case ComposePackage.SLAVE_COLLECTION: return createSlaveCollection();
			case ComposePackage.LIVE_PLACEHOLDER: return createLivePlaceholder();
			case ComposePackage.LIVE_SLAVE: return createLiveSlave();
			case ComposePackage.LIVE_CONTRIBUTOR_COLLECTION: return createLiveContributorCollection();
			case ComposePackage.CONTRIBUTOR_COLLECTION: return createContributorCollection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ComposePackage.CONTRIBUTOR_STATE:
				return createContributorStateFromString(eDataType, initialValue);
			case ComposePackage.CREATION_MODE:
				return createCreationModeFromString(eDataType, initialValue);
			case ComposePackage.PAGE:
				return createPageFromString(eDataType, initialValue);
			case ComposePackage.COLLECTION:
				return createCollectionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ComposePackage.CONTRIBUTOR_STATE:
				return convertContributorStateToString(eDataType, instanceValue);
			case ComposePackage.CREATION_MODE:
				return convertCreationModeToString(eDataType, instanceValue);
			case ComposePackage.PAGE:
				return convertPageToString(eDataType, instanceValue);
			case ComposePackage.COLLECTION:
				return convertCollectionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Placeholder createPlaceholder() {
		PlaceholderImpl placeholder = new PlaceholderImpl();
		return placeholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveTarget createLiveTarget() {
		LiveTargetImpl liveTarget = new LiveTargetImpl();
		return liveTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HideContributor createHideContributor() {
		HideContributorImpl hideContributor = new HideContributorImpl();
		return hideContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildContributor createChildContributor() {
		ChildContributorImpl childContributor = new ChildContributorImpl();
		return childContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveChildContributor createLiveChildContributor() {
		LiveChildContributorImpl liveChildContributor = new LiveChildContributorImpl();
		return liveChildContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveReplaceContributor createLiveReplaceContributor() {
		LiveReplaceContributorImpl liveReplaceContributor = new LiveReplaceContributorImpl();
		return liveReplaceContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplaceContributor createReplaceContributor() {
		ReplaceContributorImpl replaceContributor = new ReplaceContributorImpl();
		return replaceContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveComponentContributor createLiveComponentContributor() {
		LiveComponentContributorImpl liveComponentContributor = new LiveComponentContributorImpl();
		return liveComponentContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveHideContributor createLiveHideContributor() {
		LiveHideContributorImpl liveHideContributor = new LiveHideContributorImpl();
		return liveHideContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeCatalog createComposeCatalog() {
		ComposeCatalogImpl composeCatalog = new ComposeCatalogImpl();
		return composeCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slave createSlave() {
		SlaveImpl slave = new SlaveImpl();
		return slave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlaceholderCollection createPlaceholderCollection() {
		PlaceholderCollectionImpl placeholderCollection = new PlaceholderCollectionImpl();
		return placeholderCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlaveCollection createSlaveCollection() {
		SlaveCollectionImpl slaveCollection = new SlaveCollectionImpl();
		return slaveCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LivePlaceholder createLivePlaceholder() {
		LivePlaceholderImpl livePlaceholder = new LivePlaceholderImpl();
		return livePlaceholder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveSlave createLiveSlave() {
		LiveSlaveImpl liveSlave = new LiveSlaveImpl();
		return liveSlave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveContributorCollection createLiveContributorCollection() {
		LiveContributorCollectionImpl liveContributorCollection = new LiveContributorCollectionImpl();
		return liveContributorCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContributorCollection createContributorCollection() {
		ContributorCollectionImpl contributorCollection = new ContributorCollectionImpl();
		return contributorCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContributorState createContributorStateFromString(EDataType eDataType, String initialValue) {
		ContributorState result = ContributorState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContributorStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreationMode createCreationModeFromString(EDataType eDataType, String initialValue) {
		CreationMode result = CreationMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCreationModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page createPageFromString(EDataType eDataType, String initialValue) {
		return (Page)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<?> createCollectionFromString(EDataType eDataType, String initialValue) {
		return (Collection<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposePackage getComposePackage() {
		return (ComposePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComposePackage getPackage() {
		return ComposePackage.eINSTANCE;
	}

} //ComposeFactoryImpl
