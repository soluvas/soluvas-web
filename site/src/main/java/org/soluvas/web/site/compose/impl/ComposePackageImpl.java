/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;

import org.apache.wicket.Page;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osgi.framework.Bundle;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.web.site.ComponentFactory;
import org.soluvas.web.site.compose.ChildContributor;
import org.soluvas.web.site.compose.ComponentContributor;
import org.soluvas.web.site.compose.ComposeCatalog;
import org.soluvas.web.site.compose.ComposeFactory;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.Contributor;
import org.soluvas.web.site.compose.ContributorCollection;
import org.soluvas.web.site.compose.ContributorState;
import org.soluvas.web.site.compose.CreationMode;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComposePackageImpl extends EPackageImpl implements ComposePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hideContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveChildContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveReplaceContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replaceContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveComponentContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveHideContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composeCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slaveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slaveCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass livePlaceholderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveSlaveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveContributorCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributorCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contributorStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum creationModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType componentFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bundleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType collectionEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.soluvas.web.site.compose.ComposePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComposePackageImpl() {
		super(eNS_URI, ComposeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ComposePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComposePackage init() {
		if (isInited) return (ComposePackage)EPackage.Registry.INSTANCE.getEPackage(ComposePackage.eNS_URI);

		// Obtain or create and register package
		ComposePackageImpl theComposePackage = (ComposePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ComposePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ComposePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theComposePackage.createPackageContents();

		// Initialize created meta-data
		theComposePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComposePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComposePackage.eNS_URI, theComposePackage);
		return theComposePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlaceholder() {
		return placeholderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContributor() {
		return contributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContributor_PageClassName() {
		return (EAttribute)contributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContributor_TargetPath() {
		return (EAttribute)contributorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveTarget() {
		return liveTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveTarget_PageClass() {
		return (EAttribute)liveTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiveTarget_LiveBundle() {
		return (EAttribute)liveTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveContributor() {
		return liveContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveContributor_State() {
		return (EAttribute)liveContributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveContributor_LiveBundle() {
		return (EAttribute)liveContributorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHideContributor() {
		return hideContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponentContributor() {
		return componentContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComponentContributor_ClassName() {
		return (EAttribute)componentContributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComponentContributor_FactoryBean() {
		return (EAttribute)componentContributorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComponentContributor_CreationMode() {
		return (EAttribute)componentContributorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChildContributor() {
		return childContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveChildContributor() {
		return liveChildContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiveChildContributor_Placeholder() {
		return (EReference)liveChildContributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveReplaceContributor() {
		return liveReplaceContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiveReplaceContributor_Slave() {
		return (EReference)liveReplaceContributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReplaceContributor() {
		return replaceContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveComponentContributor() {
		return liveComponentContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveHideContributor() {
		return liveHideContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiveHideContributor_Target() {
		return (EReference)liveHideContributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComposeCatalog() {
		return composeCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSlave() {
		return slaveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTarget_PageClassName() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTarget_Path() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTarget_ModelClassName() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlaceholderCollection() {
		return placeholderCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlaceholderCollection_Placeholders() {
		return (EReference)placeholderCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSlaveCollection() {
		return slaveCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSlaveCollection_Slaves() {
		return (EReference)slaveCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLivePlaceholder() {
		return livePlaceholderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveSlave() {
		return liveSlaveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveContributorCollection() {
		return liveContributorCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiveContributorCollection_LiveContributors() {
		return (EReference)liveContributorCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContributorCollection() {
		return contributorCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContributorCollection_Contributors() {
		return (EReference)contributorCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getContributorState() {
		return contributorStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCreationMode() {
		return creationModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getComponentFactory() {
		return componentFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getBundle() {
		return bundleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPage() {
		return pageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCollection() {
		return collectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeFactory getComposeFactory() {
		return (ComposeFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		placeholderEClass = createEClass(PLACEHOLDER);

		contributorEClass = createEClass(CONTRIBUTOR);
		createEAttribute(contributorEClass, CONTRIBUTOR__PAGE_CLASS_NAME);
		createEAttribute(contributorEClass, CONTRIBUTOR__TARGET_PATH);

		liveTargetEClass = createEClass(LIVE_TARGET);
		createEAttribute(liveTargetEClass, LIVE_TARGET__PAGE_CLASS);
		createEAttribute(liveTargetEClass, LIVE_TARGET__LIVE_BUNDLE);

		liveContributorEClass = createEClass(LIVE_CONTRIBUTOR);
		createEAttribute(liveContributorEClass, LIVE_CONTRIBUTOR__STATE);
		createEAttribute(liveContributorEClass, LIVE_CONTRIBUTOR__LIVE_BUNDLE);

		hideContributorEClass = createEClass(HIDE_CONTRIBUTOR);

		componentContributorEClass = createEClass(COMPONENT_CONTRIBUTOR);
		createEAttribute(componentContributorEClass, COMPONENT_CONTRIBUTOR__CLASS_NAME);
		createEAttribute(componentContributorEClass, COMPONENT_CONTRIBUTOR__FACTORY_BEAN);
		createEAttribute(componentContributorEClass, COMPONENT_CONTRIBUTOR__CREATION_MODE);

		childContributorEClass = createEClass(CHILD_CONTRIBUTOR);

		liveChildContributorEClass = createEClass(LIVE_CHILD_CONTRIBUTOR);
		createEReference(liveChildContributorEClass, LIVE_CHILD_CONTRIBUTOR__PLACEHOLDER);

		liveReplaceContributorEClass = createEClass(LIVE_REPLACE_CONTRIBUTOR);
		createEReference(liveReplaceContributorEClass, LIVE_REPLACE_CONTRIBUTOR__SLAVE);

		replaceContributorEClass = createEClass(REPLACE_CONTRIBUTOR);

		liveComponentContributorEClass = createEClass(LIVE_COMPONENT_CONTRIBUTOR);

		liveHideContributorEClass = createEClass(LIVE_HIDE_CONTRIBUTOR);
		createEReference(liveHideContributorEClass, LIVE_HIDE_CONTRIBUTOR__TARGET);

		composeCatalogEClass = createEClass(COMPOSE_CATALOG);

		slaveEClass = createEClass(SLAVE);

		targetEClass = createEClass(TARGET);
		createEAttribute(targetEClass, TARGET__PAGE_CLASS_NAME);
		createEAttribute(targetEClass, TARGET__PATH);
		createEAttribute(targetEClass, TARGET__MODEL_CLASS_NAME);

		placeholderCollectionEClass = createEClass(PLACEHOLDER_COLLECTION);
		createEReference(placeholderCollectionEClass, PLACEHOLDER_COLLECTION__PLACEHOLDERS);

		slaveCollectionEClass = createEClass(SLAVE_COLLECTION);
		createEReference(slaveCollectionEClass, SLAVE_COLLECTION__SLAVES);

		livePlaceholderEClass = createEClass(LIVE_PLACEHOLDER);

		liveSlaveEClass = createEClass(LIVE_SLAVE);

		liveContributorCollectionEClass = createEClass(LIVE_CONTRIBUTOR_COLLECTION);
		createEReference(liveContributorCollectionEClass, LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS);

		contributorCollectionEClass = createEClass(CONTRIBUTOR_COLLECTION);
		createEReference(contributorCollectionEClass, CONTRIBUTOR_COLLECTION__CONTRIBUTORS);

		// Create enums
		contributorStateEEnum = createEEnum(CONTRIBUTOR_STATE);
		creationModeEEnum = createEEnum(CREATION_MODE);

		// Create data types
		componentFactoryEDataType = createEDataType(COMPONENT_FACTORY);
		bundleEDataType = createEDataType(BUNDLE);
		pageEDataType = createEDataType(PAGE);
		collectionEDataType = createEDataType(COLLECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(collectionEDataType, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		placeholderEClass.getESuperTypes().add(this.getTarget());
		contributorEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		contributorEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		liveTargetEClass.getESuperTypes().add(this.getTarget());
		liveContributorEClass.getESuperTypes().add(this.getContributor());
		hideContributorEClass.getESuperTypes().add(this.getContributor());
		componentContributorEClass.getESuperTypes().add(this.getContributor());
		childContributorEClass.getESuperTypes().add(this.getComponentContributor());
		childContributorEClass.getESuperTypes().add(theCommonsPackage.getPositionable());
		liveChildContributorEClass.getESuperTypes().add(this.getChildContributor());
		liveChildContributorEClass.getESuperTypes().add(this.getLiveComponentContributor());
		liveReplaceContributorEClass.getESuperTypes().add(this.getReplaceContributor());
		liveReplaceContributorEClass.getESuperTypes().add(this.getLiveComponentContributor());
		replaceContributorEClass.getESuperTypes().add(this.getComponentContributor());
		liveComponentContributorEClass.getESuperTypes().add(this.getLiveContributor());
		liveComponentContributorEClass.getESuperTypes().add(this.getComponentContributor());
		liveHideContributorEClass.getESuperTypes().add(this.getLiveContributor());
		liveHideContributorEClass.getESuperTypes().add(this.getHideContributor());
		composeCatalogEClass.getESuperTypes().add(this.getSlaveCollection());
		composeCatalogEClass.getESuperTypes().add(this.getPlaceholderCollection());
		composeCatalogEClass.getESuperTypes().add(this.getContributorCollection());
		slaveEClass.getESuperTypes().add(this.getTarget());
		targetEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		targetEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		livePlaceholderEClass.getESuperTypes().add(this.getLiveTarget());
		livePlaceholderEClass.getESuperTypes().add(this.getPlaceholder());
		liveSlaveEClass.getESuperTypes().add(this.getLiveTarget());
		liveSlaveEClass.getESuperTypes().add(this.getSlave());

		// Initialize classes and features; add operations and parameters
		initEClass(placeholderEClass, Placeholder.class, "Placeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contributorEClass, Contributor.class, "Contributor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContributor_PageClassName(), ecorePackage.getEString(), "pageClassName", null, 1, 1, Contributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContributor_TargetPath(), ecorePackage.getEString(), "targetPath", null, 1, 1, Contributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(contributorEClass, this.getLiveContributor(), "createLive", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBundle(), "bundle", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(liveTargetEClass, LiveTarget.class, "LiveTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType(this.getPage());
		g1.getETypeArguments().add(g2);
		initEAttribute(getLiveTarget_PageClass(), g1, "pageClass", null, 1, 1, LiveTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiveTarget_LiveBundle(), this.getBundle(), "liveBundle", null, 0, 1, LiveTarget.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(liveContributorEClass, LiveContributor.class, "LiveContributor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiveContributor_State(), this.getContributorState(), "state", null, 1, 1, LiveContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiveContributor_LiveBundle(), this.getBundle(), "liveBundle", null, 1, 1, LiveContributor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(liveContributorEClass, null, "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getCollection());
		g2 = createEGenericType(this.getLivePlaceholder());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "placeholders", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getCollection());
		g2 = createEGenericType(this.getLiveSlave());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "slaves", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(liveContributorEClass, null, "bundleAdded", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBundle(), "bundle", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(liveContributorEClass, null, "bundleRemoved", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBundle(), "bundle", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(liveContributorEClass, null, "targetRemoved", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLiveTarget(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hideContributorEClass, HideContributor.class, "HideContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentContributorEClass, ComponentContributor.class, "ComponentContributor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentContributor_ClassName(), ecorePackage.getEString(), "className", "", 0, 1, ComponentContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentContributor_FactoryBean(), ecorePackage.getEString(), "factoryBean", null, 0, 1, ComponentContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentContributor_CreationMode(), this.getCreationMode(), "creationMode", "constructor", 0, 1, ComponentContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childContributorEClass, ChildContributor.class, "ChildContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liveChildContributorEClass, LiveChildContributor.class, "LiveChildContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiveChildContributor_Placeholder(), this.getLivePlaceholder(), null, "placeholder", null, 0, 1, LiveChildContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(liveReplaceContributorEClass, LiveReplaceContributor.class, "LiveReplaceContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiveReplaceContributor_Slave(), this.getLiveSlave(), null, "slave", null, 0, 1, LiveReplaceContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(replaceContributorEClass, ReplaceContributor.class, "ReplaceContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liveComponentContributorEClass, LiveComponentContributor.class, "LiveComponentContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(liveComponentContributorEClass, this.getComponentFactory(), "getFactory", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(liveHideContributorEClass, LiveHideContributor.class, "LiveHideContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiveHideContributor_Target(), this.getLiveTarget(), null, "target", null, 0, 1, LiveHideContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(composeCatalogEClass, ComposeCatalog.class, "ComposeCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(slaveEClass, Slave.class, "Slave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTarget_PageClassName(), ecorePackage.getEString(), "pageClassName", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTarget_Path(), ecorePackage.getEString(), "path", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTarget_ModelClassName(), ecorePackage.getEString(), "modelClassName", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placeholderCollectionEClass, PlaceholderCollection.class, "PlaceholderCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaceholderCollection_Placeholders(), this.getPlaceholder(), null, "placeholders", null, 0, -1, PlaceholderCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(slaveCollectionEClass, SlaveCollection.class, "SlaveCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSlaveCollection_Slaves(), this.getSlave(), null, "slaves", null, 0, -1, SlaveCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(livePlaceholderEClass, LivePlaceholder.class, "LivePlaceholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liveSlaveEClass, LiveSlave.class, "LiveSlave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liveContributorCollectionEClass, LiveContributorCollection.class, "LiveContributorCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiveContributorCollection_LiveContributors(), this.getLiveContributor(), null, "liveContributors", null, 0, -1, LiveContributorCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contributorCollectionEClass, ContributorCollection.class, "ContributorCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContributorCollection_Contributors(), this.getContributor(), null, "contributors", null, 0, -1, ContributorCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(contributorStateEEnum, ContributorState.class, "ContributorState");
		addEEnumLiteral(contributorStateEEnum, ContributorState.UNRESOLVED);
		addEEnumLiteral(contributorStateEEnum, ContributorState.FAILED);
		addEEnumLiteral(contributorStateEEnum, ContributorState.RESOLVED);

		initEEnum(creationModeEEnum, CreationMode.class, "CreationMode");
		addEEnumLiteral(creationModeEEnum, CreationMode.CONSTRUCTOR);
		addEEnumLiteral(creationModeEEnum, CreationMode.FACTORY_CLASS);
		addEEnumLiteral(creationModeEEnum, CreationMode.FACTORY_BEAN);

		// Initialize data types
		initEDataType(componentFactoryEDataType, ComponentFactory.class, "ComponentFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(bundleEDataType, Bundle.class, "Bundle", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pageEDataType, Page.class, "Page", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (placeholderEClass, 
		   source, 
		   new String[] {
			 "documentation", "Declares a parent component that can be contributed with children."
		   });		
		addAnnotation
		  (getContributor_PageClassName(), 
		   source, 
		   new String[] {
			 "documentation", "Class name of the page that hosts this."
		   });		
		addAnnotation
		  (getLiveTarget_PageClass(), 
		   source, 
		   new String[] {
			 "documentation", "Note that since bundles that provide a Page and/or ComponentFactory can come and go, a LinkedContributor can be gone at any time as well."
		   });		
		addAnnotation
		  (liveContributorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Runtime state, if state is resolved then it is resolved with actual Page class and Factory instance.\nOtherwise it may be unresolved or partially resolved."
		   });		
		addAnnotation
		  (getComponentContributor_ClassName(), 
		   source, 
		   new String[] {
			 "documentation", "The factory will be instantiated to create the component will be named {className}Factory in the same package."
		   });		
		addAnnotation
		  (contributorStateEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Means the mentioned Bundle is not available."
		   });		
		addAnnotation
		  (contributorStateEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Means the bundle is available, but either the Page or the LiveTarget is not found. (LiveTarget must exist for Page class to be found)"
		   });		
		addAnnotation
		  (slaveEClass, 
		   source, 
		   new String[] {
			 "documentation", "Replaceable component."
		   });		
		addAnnotation
		  (getTarget_Path(), 
		   source, 
		   new String[] {
			 "documentation", "Path of the Component IDs from the Page."
		   });		
		addAnnotation
		  (getTarget_ModelClassName(), 
		   source, 
		   new String[] {
			 "documentation", "This model will be passed to the Contributor Factory to create the Component.\n\nIf it is null, that means the target IModel type is unknown, this can happen when it\'s a \'hide\' contributor,\nTarget EObject is created dynamically based on runtime reflection."
		   });		
		addAnnotation
		  (liveContributorCollectionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Used to inspect the live state of contributors."
		   });		
		addAnnotation
		  (creationModeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "How to create ComponentContributor."
		   });
	}

} //ComposePackageImpl
