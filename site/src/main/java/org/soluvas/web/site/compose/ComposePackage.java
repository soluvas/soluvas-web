/**
 */
package org.soluvas.web.site.compose;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.soluvas.commons.CommonsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.compose.ComposeFactory
 * @model kind="package"
 * @generated
 */
public interface ComposePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "compose";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/web.compose/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "compose";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComposePackage eINSTANCE = org.soluvas.web.site.compose.impl.ComposePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.TargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.TargetImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 14;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__BUNDLE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__PAGE_CLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__PATH = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__MODEL_CLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.PlaceholderImpl <em>Placeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.PlaceholderImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getPlaceholder()
	 * @generated
	 */
	int PLACEHOLDER = 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__RESOURCE_TYPE = TARGET__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__RESOURCE_URI = TARGET__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__RESOURCE_NAME = TARGET__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__BUNDLE = TARGET__BUNDLE;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__PAGE_CLASS_NAME = TARGET__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__PATH = TARGET__PATH;

	/**
	 * The feature id for the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__MODEL_CLASS_NAME = TARGET__MODEL_CLASS_NAME;

	/**
	 * The number of structural features of the '<em>Placeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_FEATURE_COUNT = TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.Contributor <em>Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.Contributor
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getContributor()
	 * @generated
	 */
	int CONTRIBUTOR = 1;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__BUNDLE = CommonsPackage.BUNDLE_AWARE__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__RESOURCE_TYPE = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__RESOURCE_URI = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__RESOURCE_NAME = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__PAGE_CLASS_NAME = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__TARGET_PATH = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR_FEATURE_COUNT = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveTargetImpl <em>Live Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveTargetImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveTarget()
	 * @generated
	 */
	int LIVE_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__RESOURCE_TYPE = TARGET__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__RESOURCE_URI = TARGET__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__RESOURCE_NAME = TARGET__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__BUNDLE = TARGET__BUNDLE;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__PAGE_CLASS_NAME = TARGET__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__PATH = TARGET__PATH;

	/**
	 * The feature id for the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__MODEL_CLASS_NAME = TARGET__MODEL_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Page Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__PAGE_CLASS = TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET__LIVE_BUNDLE = TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Live Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_TARGET_FEATURE_COUNT = TARGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.LiveContributor <em>Live Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.LiveContributor
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveContributor()
	 * @generated
	 */
	int LIVE_CONTRIBUTOR = 3;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__BUNDLE = CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__RESOURCE_TYPE = CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__RESOURCE_URI = CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__RESOURCE_NAME = CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__PAGE_CLASS_NAME = CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__TARGET_PATH = CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__STATE = CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR__LIVE_BUNDLE = CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Live Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR_FEATURE_COUNT = CONTRIBUTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.HideContributorImpl <em>Hide Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.HideContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getHideContributor()
	 * @generated
	 */
	int HIDE_CONTRIBUTOR = 4;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR__BUNDLE = CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR__RESOURCE_TYPE = CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR__RESOURCE_URI = CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR__RESOURCE_NAME = CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR__PAGE_CLASS_NAME = CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR__TARGET_PATH = CONTRIBUTOR__TARGET_PATH;

	/**
	 * The number of structural features of the '<em>Hide Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_CONTRIBUTOR_FEATURE_COUNT = CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.ComponentContributor <em>Component Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.ComponentContributor
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getComponentContributor()
	 * @generated
	 */
	int COMPONENT_CONTRIBUTOR = 5;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__BUNDLE = CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__RESOURCE_TYPE = CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__RESOURCE_URI = CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__RESOURCE_NAME = CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME = CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__TARGET_PATH = CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__CLASS_NAME = CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__FACTORY_BEAN = CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR__CREATION_MODE = CONTRIBUTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONTRIBUTOR_FEATURE_COUNT = CONTRIBUTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.ChildContributorImpl <em>Child Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.ChildContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getChildContributor()
	 * @generated
	 */
	int CHILD_CONTRIBUTOR = 6;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__BUNDLE = COMPONENT_CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__RESOURCE_TYPE = COMPONENT_CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__RESOURCE_URI = COMPONENT_CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__RESOURCE_NAME = COMPONENT_CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__PAGE_CLASS_NAME = COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__TARGET_PATH = COMPONENT_CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__CLASS_NAME = COMPONENT_CONTRIBUTOR__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__FACTORY_BEAN = COMPONENT_CONTRIBUTOR__FACTORY_BEAN;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__CREATION_MODE = COMPONENT_CONTRIBUTOR__CREATION_MODE;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR__POSITIONER = COMPONENT_CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Child Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONTRIBUTOR_FEATURE_COUNT = COMPONENT_CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveChildContributorImpl <em>Live Child Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveChildContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveChildContributor()
	 * @generated
	 */
	int LIVE_CHILD_CONTRIBUTOR = 7;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__BUNDLE = CHILD_CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__RESOURCE_TYPE = CHILD_CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__RESOURCE_URI = CHILD_CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__RESOURCE_NAME = CHILD_CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__PAGE_CLASS_NAME = CHILD_CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__TARGET_PATH = CHILD_CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__CLASS_NAME = CHILD_CONTRIBUTOR__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__FACTORY_BEAN = CHILD_CONTRIBUTOR__FACTORY_BEAN;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__CREATION_MODE = CHILD_CONTRIBUTOR__CREATION_MODE;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__POSITIONER = CHILD_CONTRIBUTOR__POSITIONER;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__STATE = CHILD_CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__LIVE_BUNDLE = CHILD_CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Placeholder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR__PLACEHOLDER = CHILD_CONTRIBUTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Live Child Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHILD_CONTRIBUTOR_FEATURE_COUNT = CHILD_CONTRIBUTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.ReplaceContributorImpl <em>Replace Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.ReplaceContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getReplaceContributor()
	 * @generated
	 */
	int REPLACE_CONTRIBUTOR = 9;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__BUNDLE = COMPONENT_CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__RESOURCE_TYPE = COMPONENT_CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__RESOURCE_URI = COMPONENT_CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__RESOURCE_NAME = COMPONENT_CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__PAGE_CLASS_NAME = COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__TARGET_PATH = COMPONENT_CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__CLASS_NAME = COMPONENT_CONTRIBUTOR__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__FACTORY_BEAN = COMPONENT_CONTRIBUTOR__FACTORY_BEAN;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR__CREATION_MODE = COMPONENT_CONTRIBUTOR__CREATION_MODE;

	/**
	 * The number of structural features of the '<em>Replace Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_CONTRIBUTOR_FEATURE_COUNT = COMPONENT_CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl <em>Live Replace Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveReplaceContributor()
	 * @generated
	 */
	int LIVE_REPLACE_CONTRIBUTOR = 8;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__BUNDLE = REPLACE_CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__RESOURCE_TYPE = REPLACE_CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__RESOURCE_URI = REPLACE_CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__RESOURCE_NAME = REPLACE_CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__PAGE_CLASS_NAME = REPLACE_CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__TARGET_PATH = REPLACE_CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__CLASS_NAME = REPLACE_CONTRIBUTOR__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__FACTORY_BEAN = REPLACE_CONTRIBUTOR__FACTORY_BEAN;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__CREATION_MODE = REPLACE_CONTRIBUTOR__CREATION_MODE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__STATE = REPLACE_CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE = REPLACE_CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Slave</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR__SLAVE = REPLACE_CONTRIBUTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Live Replace Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_REPLACE_CONTRIBUTOR_FEATURE_COUNT = REPLACE_CONTRIBUTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl <em>Live Component Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveComponentContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveComponentContributor()
	 * @generated
	 */
	int LIVE_COMPONENT_CONTRIBUTOR = 10;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__BUNDLE = LIVE_CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__RESOURCE_TYPE = LIVE_CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__RESOURCE_URI = LIVE_CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__RESOURCE_NAME = LIVE_CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME = LIVE_CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__TARGET_PATH = LIVE_CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__STATE = LIVE_CONTRIBUTOR__STATE;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__LIVE_BUNDLE = LIVE_CONTRIBUTOR__LIVE_BUNDLE;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME = LIVE_CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN = LIVE_CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE = LIVE_CONTRIBUTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Live Component Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_COMPONENT_CONTRIBUTOR_FEATURE_COUNT = LIVE_CONTRIBUTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveHideContributorImpl <em>Live Hide Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveHideContributorImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveHideContributor()
	 * @generated
	 */
	int LIVE_HIDE_CONTRIBUTOR = 11;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__BUNDLE = LIVE_CONTRIBUTOR__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__RESOURCE_TYPE = LIVE_CONTRIBUTOR__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__RESOURCE_URI = LIVE_CONTRIBUTOR__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__RESOURCE_NAME = LIVE_CONTRIBUTOR__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__PAGE_CLASS_NAME = LIVE_CONTRIBUTOR__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__TARGET_PATH = LIVE_CONTRIBUTOR__TARGET_PATH;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__STATE = LIVE_CONTRIBUTOR__STATE;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__LIVE_BUNDLE = LIVE_CONTRIBUTOR__LIVE_BUNDLE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR__TARGET = LIVE_CONTRIBUTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Live Hide Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_HIDE_CONTRIBUTOR_FEATURE_COUNT = LIVE_CONTRIBUTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.SlaveCollectionImpl <em>Slave Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.SlaveCollectionImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getSlaveCollection()
	 * @generated
	 */
	int SLAVE_COLLECTION = 16;

	/**
	 * The feature id for the '<em><b>Slaves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE_COLLECTION__SLAVES = 0;

	/**
	 * The number of structural features of the '<em>Slave Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.ComposeCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.ComposeCatalogImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getComposeCatalog()
	 * @generated
	 */
	int COMPOSE_CATALOG = 12;

	/**
	 * The feature id for the '<em><b>Slaves</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSE_CATALOG__SLAVES = SLAVE_COLLECTION__SLAVES;

	/**
	 * The feature id for the '<em><b>Placeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSE_CATALOG__PLACEHOLDERS = SLAVE_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contributors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSE_CATALOG__CONTRIBUTORS = SLAVE_COLLECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSE_CATALOG_FEATURE_COUNT = SLAVE_COLLECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.SlaveImpl <em>Slave</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.SlaveImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getSlave()
	 * @generated
	 */
	int SLAVE = 13;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__RESOURCE_TYPE = TARGET__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__RESOURCE_URI = TARGET__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__RESOURCE_NAME = TARGET__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__BUNDLE = TARGET__BUNDLE;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__PAGE_CLASS_NAME = TARGET__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__PATH = TARGET__PATH;

	/**
	 * The feature id for the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE__MODEL_CLASS_NAME = TARGET__MODEL_CLASS_NAME;

	/**
	 * The number of structural features of the '<em>Slave</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAVE_FEATURE_COUNT = TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.PlaceholderCollectionImpl <em>Placeholder Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.PlaceholderCollectionImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getPlaceholderCollection()
	 * @generated
	 */
	int PLACEHOLDER_COLLECTION = 15;

	/**
	 * The feature id for the '<em><b>Placeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_COLLECTION__PLACEHOLDERS = 0;

	/**
	 * The number of structural features of the '<em>Placeholder Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LivePlaceholderImpl <em>Live Placeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LivePlaceholderImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLivePlaceholder()
	 * @generated
	 */
	int LIVE_PLACEHOLDER = 17;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__RESOURCE_TYPE = LIVE_TARGET__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__RESOURCE_URI = LIVE_TARGET__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__RESOURCE_NAME = LIVE_TARGET__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__BUNDLE = LIVE_TARGET__BUNDLE;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__PAGE_CLASS_NAME = LIVE_TARGET__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__PATH = LIVE_TARGET__PATH;

	/**
	 * The feature id for the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__MODEL_CLASS_NAME = LIVE_TARGET__MODEL_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Page Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__PAGE_CLASS = LIVE_TARGET__PAGE_CLASS;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER__LIVE_BUNDLE = LIVE_TARGET__LIVE_BUNDLE;

	/**
	 * The number of structural features of the '<em>Live Placeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_PLACEHOLDER_FEATURE_COUNT = LIVE_TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveSlaveImpl <em>Live Slave</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveSlaveImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveSlave()
	 * @generated
	 */
	int LIVE_SLAVE = 18;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__RESOURCE_TYPE = LIVE_TARGET__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__RESOURCE_URI = LIVE_TARGET__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__RESOURCE_NAME = LIVE_TARGET__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__BUNDLE = LIVE_TARGET__BUNDLE;

	/**
	 * The feature id for the '<em><b>Page Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__PAGE_CLASS_NAME = LIVE_TARGET__PAGE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__PATH = LIVE_TARGET__PATH;

	/**
	 * The feature id for the '<em><b>Model Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__MODEL_CLASS_NAME = LIVE_TARGET__MODEL_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Page Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__PAGE_CLASS = LIVE_TARGET__PAGE_CLASS;

	/**
	 * The feature id for the '<em><b>Live Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE__LIVE_BUNDLE = LIVE_TARGET__LIVE_BUNDLE;

	/**
	 * The number of structural features of the '<em>Live Slave</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_SLAVE_FEATURE_COUNT = LIVE_TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.LiveContributorCollectionImpl <em>Live Contributor Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.LiveContributorCollectionImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveContributorCollection()
	 * @generated
	 */
	int LIVE_CONTRIBUTOR_COLLECTION = 19;

	/**
	 * The feature id for the '<em><b>Live Contributors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS = 0;

	/**
	 * The number of structural features of the '<em>Live Contributor Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CONTRIBUTOR_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.impl.ContributorCollectionImpl <em>Contributor Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.impl.ContributorCollectionImpl
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getContributorCollection()
	 * @generated
	 */
	int CONTRIBUTOR_COLLECTION = 20;

	/**
	 * The feature id for the '<em><b>Contributors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR_COLLECTION__CONTRIBUTORS = 0;

	/**
	 * The number of structural features of the '<em>Contributor Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.ContributorState <em>Contributor State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.ContributorState
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getContributorState()
	 * @generated
	 */
	int CONTRIBUTOR_STATE = 21;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.compose.CreationMode <em>Creation Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.compose.CreationMode
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getCreationMode()
	 * @generated
	 */
	int CREATION_MODE = 22;

	/**
	 * The meta object id for the '<em>Component Factory</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.ComponentFactory
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getComponentFactory()
	 * @generated
	 */
	int COMPONENT_FACTORY = 23;

	/**
	 * The meta object id for the '<em>Bundle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osgi.framework.Bundle
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 24;

	/**
	 * The meta object id for the '<em>Page</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.wicket.Page
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 25;


	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 26;

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.Placeholder <em>Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder</em>'.
	 * @see org.soluvas.web.site.compose.Placeholder
	 * @generated
	 */
	EClass getPlaceholder();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.Contributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contributor</em>'.
	 * @see org.soluvas.web.site.compose.Contributor
	 * @generated
	 */
	EClass getContributor();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.Contributor#getPageClassName <em>Page Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Class Name</em>'.
	 * @see org.soluvas.web.site.compose.Contributor#getPageClassName()
	 * @see #getContributor()
	 * @generated
	 */
	EAttribute getContributor_PageClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.Contributor#getTargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Path</em>'.
	 * @see org.soluvas.web.site.compose.Contributor#getTargetPath()
	 * @see #getContributor()
	 * @generated
	 */
	EAttribute getContributor_TargetPath();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveTarget <em>Live Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Target</em>'.
	 * @see org.soluvas.web.site.compose.LiveTarget
	 * @generated
	 */
	EClass getLiveTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.LiveTarget#getPageClass <em>Page Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Class</em>'.
	 * @see org.soluvas.web.site.compose.LiveTarget#getPageClass()
	 * @see #getLiveTarget()
	 * @generated
	 */
	EAttribute getLiveTarget_PageClass();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.LiveTarget#getLiveBundle <em>Live Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Live Bundle</em>'.
	 * @see org.soluvas.web.site.compose.LiveTarget#getLiveBundle()
	 * @see #getLiveTarget()
	 * @generated
	 */
	EAttribute getLiveTarget_LiveBundle();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveContributor <em>Live Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Contributor</em>'.
	 * @see org.soluvas.web.site.compose.LiveContributor
	 * @generated
	 */
	EClass getLiveContributor();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.LiveContributor#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.soluvas.web.site.compose.LiveContributor#getState()
	 * @see #getLiveContributor()
	 * @generated
	 */
	EAttribute getLiveContributor_State();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.LiveContributor#getLiveBundle <em>Live Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Live Bundle</em>'.
	 * @see org.soluvas.web.site.compose.LiveContributor#getLiveBundle()
	 * @see #getLiveContributor()
	 * @generated
	 */
	EAttribute getLiveContributor_LiveBundle();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.HideContributor <em>Hide Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hide Contributor</em>'.
	 * @see org.soluvas.web.site.compose.HideContributor
	 * @generated
	 */
	EClass getHideContributor();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.ComponentContributor <em>Component Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Contributor</em>'.
	 * @see org.soluvas.web.site.compose.ComponentContributor
	 * @generated
	 */
	EClass getComponentContributor();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.ComponentContributor#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.soluvas.web.site.compose.ComponentContributor#getClassName()
	 * @see #getComponentContributor()
	 * @generated
	 */
	EAttribute getComponentContributor_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.ComponentContributor#getFactoryBean <em>Factory Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Bean</em>'.
	 * @see org.soluvas.web.site.compose.ComponentContributor#getFactoryBean()
	 * @see #getComponentContributor()
	 * @generated
	 */
	EAttribute getComponentContributor_FactoryBean();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.ComponentContributor#getCreationMode <em>Creation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Mode</em>'.
	 * @see org.soluvas.web.site.compose.ComponentContributor#getCreationMode()
	 * @see #getComponentContributor()
	 * @generated
	 */
	EAttribute getComponentContributor_CreationMode();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.ChildContributor <em>Child Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Contributor</em>'.
	 * @see org.soluvas.web.site.compose.ChildContributor
	 * @generated
	 */
	EClass getChildContributor();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveChildContributor <em>Live Child Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Child Contributor</em>'.
	 * @see org.soluvas.web.site.compose.LiveChildContributor
	 * @generated
	 */
	EClass getLiveChildContributor();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.compose.LiveChildContributor#getPlaceholder <em>Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Placeholder</em>'.
	 * @see org.soluvas.web.site.compose.LiveChildContributor#getPlaceholder()
	 * @see #getLiveChildContributor()
	 * @generated
	 */
	EReference getLiveChildContributor_Placeholder();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveReplaceContributor <em>Live Replace Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Replace Contributor</em>'.
	 * @see org.soluvas.web.site.compose.LiveReplaceContributor
	 * @generated
	 */
	EClass getLiveReplaceContributor();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.compose.LiveReplaceContributor#getSlave <em>Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Slave</em>'.
	 * @see org.soluvas.web.site.compose.LiveReplaceContributor#getSlave()
	 * @see #getLiveReplaceContributor()
	 * @generated
	 */
	EReference getLiveReplaceContributor_Slave();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.ReplaceContributor <em>Replace Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace Contributor</em>'.
	 * @see org.soluvas.web.site.compose.ReplaceContributor
	 * @generated
	 */
	EClass getReplaceContributor();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveComponentContributor <em>Live Component Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Component Contributor</em>'.
	 * @see org.soluvas.web.site.compose.LiveComponentContributor
	 * @generated
	 */
	EClass getLiveComponentContributor();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveHideContributor <em>Live Hide Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Hide Contributor</em>'.
	 * @see org.soluvas.web.site.compose.LiveHideContributor
	 * @generated
	 */
	EClass getLiveHideContributor();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.compose.LiveHideContributor#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.soluvas.web.site.compose.LiveHideContributor#getTarget()
	 * @see #getLiveHideContributor()
	 * @generated
	 */
	EReference getLiveHideContributor_Target();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.ComposeCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.web.site.compose.ComposeCatalog
	 * @generated
	 */
	EClass getComposeCatalog();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.Slave <em>Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slave</em>'.
	 * @see org.soluvas.web.site.compose.Slave
	 * @generated
	 */
	EClass getSlave();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see org.soluvas.web.site.compose.Target
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.Target#getPageClassName <em>Page Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Class Name</em>'.
	 * @see org.soluvas.web.site.compose.Target#getPageClassName()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_PageClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.Target#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.soluvas.web.site.compose.Target#getPath()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.compose.Target#getModelClassName <em>Model Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Class Name</em>'.
	 * @see org.soluvas.web.site.compose.Target#getModelClassName()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_ModelClassName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.PlaceholderCollection <em>Placeholder Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder Collection</em>'.
	 * @see org.soluvas.web.site.compose.PlaceholderCollection
	 * @generated
	 */
	EClass getPlaceholderCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.compose.PlaceholderCollection#getPlaceholders <em>Placeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Placeholders</em>'.
	 * @see org.soluvas.web.site.compose.PlaceholderCollection#getPlaceholders()
	 * @see #getPlaceholderCollection()
	 * @generated
	 */
	EReference getPlaceholderCollection_Placeholders();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.SlaveCollection <em>Slave Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slave Collection</em>'.
	 * @see org.soluvas.web.site.compose.SlaveCollection
	 * @generated
	 */
	EClass getSlaveCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.compose.SlaveCollection#getSlaves <em>Slaves</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slaves</em>'.
	 * @see org.soluvas.web.site.compose.SlaveCollection#getSlaves()
	 * @see #getSlaveCollection()
	 * @generated
	 */
	EReference getSlaveCollection_Slaves();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LivePlaceholder <em>Live Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Placeholder</em>'.
	 * @see org.soluvas.web.site.compose.LivePlaceholder
	 * @generated
	 */
	EClass getLivePlaceholder();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveSlave <em>Live Slave</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Slave</em>'.
	 * @see org.soluvas.web.site.compose.LiveSlave
	 * @generated
	 */
	EClass getLiveSlave();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.LiveContributorCollection <em>Live Contributor Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Contributor Collection</em>'.
	 * @see org.soluvas.web.site.compose.LiveContributorCollection
	 * @generated
	 */
	EClass getLiveContributorCollection();

	/**
	 * Returns the meta object for the reference list '{@link org.soluvas.web.site.compose.LiveContributorCollection#getLiveContributors <em>Live Contributors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Live Contributors</em>'.
	 * @see org.soluvas.web.site.compose.LiveContributorCollection#getLiveContributors()
	 * @see #getLiveContributorCollection()
	 * @generated
	 */
	EReference getLiveContributorCollection_LiveContributors();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.compose.ContributorCollection <em>Contributor Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contributor Collection</em>'.
	 * @see org.soluvas.web.site.compose.ContributorCollection
	 * @generated
	 */
	EClass getContributorCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.compose.ContributorCollection#getContributors <em>Contributors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributors</em>'.
	 * @see org.soluvas.web.site.compose.ContributorCollection#getContributors()
	 * @see #getContributorCollection()
	 * @generated
	 */
	EReference getContributorCollection_Contributors();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.web.site.compose.ContributorState <em>Contributor State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contributor State</em>'.
	 * @see org.soluvas.web.site.compose.ContributorState
	 * @generated
	 */
	EEnum getContributorState();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.web.site.compose.CreationMode <em>Creation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Creation Mode</em>'.
	 * @see org.soluvas.web.site.compose.CreationMode
	 * @generated
	 */
	EEnum getCreationMode();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.web.site.ComponentFactory <em>Component Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Component Factory</em>'.
	 * @see org.soluvas.web.site.ComponentFactory
	 * @model instanceClass="org.soluvas.web.site.ComponentFactory" serializeable="false"
	 * @generated
	 */
	EDataType getComponentFactory();

	/**
	 * Returns the meta object for data type '{@link org.osgi.framework.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bundle</em>'.
	 * @see org.osgi.framework.Bundle
	 * @model instanceClass="org.osgi.framework.Bundle" serializeable="false"
	 * @generated
	 */
	EDataType getBundle();

	/**
	 * Returns the meta object for data type '{@link org.apache.wicket.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Page</em>'.
	 * @see org.apache.wicket.Page
	 * @model instanceClass="org.apache.wicket.Page"
	 * @generated
	 */
	EDataType getPage();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection" typeParameters="T"
	 * @generated
	 */
	EDataType getCollection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComposeFactory getComposeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.PlaceholderImpl <em>Placeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.PlaceholderImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getPlaceholder()
		 * @generated
		 */
		EClass PLACEHOLDER = eINSTANCE.getPlaceholder();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.Contributor <em>Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.Contributor
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getContributor()
		 * @generated
		 */
		EClass CONTRIBUTOR = eINSTANCE.getContributor();

		/**
		 * The meta object literal for the '<em><b>Page Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTOR__PAGE_CLASS_NAME = eINSTANCE.getContributor_PageClassName();

		/**
		 * The meta object literal for the '<em><b>Target Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTOR__TARGET_PATH = eINSTANCE.getContributor_TargetPath();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveTargetImpl <em>Live Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveTargetImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveTarget()
		 * @generated
		 */
		EClass LIVE_TARGET = eINSTANCE.getLiveTarget();

		/**
		 * The meta object literal for the '<em><b>Page Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_TARGET__PAGE_CLASS = eINSTANCE.getLiveTarget_PageClass();

		/**
		 * The meta object literal for the '<em><b>Live Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_TARGET__LIVE_BUNDLE = eINSTANCE.getLiveTarget_LiveBundle();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.LiveContributor <em>Live Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.LiveContributor
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveContributor()
		 * @generated
		 */
		EClass LIVE_CONTRIBUTOR = eINSTANCE.getLiveContributor();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CONTRIBUTOR__STATE = eINSTANCE.getLiveContributor_State();

		/**
		 * The meta object literal for the '<em><b>Live Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CONTRIBUTOR__LIVE_BUNDLE = eINSTANCE.getLiveContributor_LiveBundle();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.HideContributorImpl <em>Hide Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.HideContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getHideContributor()
		 * @generated
		 */
		EClass HIDE_CONTRIBUTOR = eINSTANCE.getHideContributor();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.ComponentContributor <em>Component Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.ComponentContributor
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getComponentContributor()
		 * @generated
		 */
		EClass COMPONENT_CONTRIBUTOR = eINSTANCE.getComponentContributor();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_CONTRIBUTOR__CLASS_NAME = eINSTANCE.getComponentContributor_ClassName();

		/**
		 * The meta object literal for the '<em><b>Factory Bean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_CONTRIBUTOR__FACTORY_BEAN = eINSTANCE.getComponentContributor_FactoryBean();

		/**
		 * The meta object literal for the '<em><b>Creation Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_CONTRIBUTOR__CREATION_MODE = eINSTANCE.getComponentContributor_CreationMode();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.ChildContributorImpl <em>Child Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.ChildContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getChildContributor()
		 * @generated
		 */
		EClass CHILD_CONTRIBUTOR = eINSTANCE.getChildContributor();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveChildContributorImpl <em>Live Child Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveChildContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveChildContributor()
		 * @generated
		 */
		EClass LIVE_CHILD_CONTRIBUTOR = eINSTANCE.getLiveChildContributor();

		/**
		 * The meta object literal for the '<em><b>Placeholder</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIVE_CHILD_CONTRIBUTOR__PLACEHOLDER = eINSTANCE.getLiveChildContributor_Placeholder();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl <em>Live Replace Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveReplaceContributor()
		 * @generated
		 */
		EClass LIVE_REPLACE_CONTRIBUTOR = eINSTANCE.getLiveReplaceContributor();

		/**
		 * The meta object literal for the '<em><b>Slave</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIVE_REPLACE_CONTRIBUTOR__SLAVE = eINSTANCE.getLiveReplaceContributor_Slave();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.ReplaceContributorImpl <em>Replace Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.ReplaceContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getReplaceContributor()
		 * @generated
		 */
		EClass REPLACE_CONTRIBUTOR = eINSTANCE.getReplaceContributor();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl <em>Live Component Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveComponentContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveComponentContributor()
		 * @generated
		 */
		EClass LIVE_COMPONENT_CONTRIBUTOR = eINSTANCE.getLiveComponentContributor();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveHideContributorImpl <em>Live Hide Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveHideContributorImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveHideContributor()
		 * @generated
		 */
		EClass LIVE_HIDE_CONTRIBUTOR = eINSTANCE.getLiveHideContributor();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIVE_HIDE_CONTRIBUTOR__TARGET = eINSTANCE.getLiveHideContributor_Target();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.ComposeCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.ComposeCatalogImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getComposeCatalog()
		 * @generated
		 */
		EClass COMPOSE_CATALOG = eINSTANCE.getComposeCatalog();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.SlaveImpl <em>Slave</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.SlaveImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getSlave()
		 * @generated
		 */
		EClass SLAVE = eINSTANCE.getSlave();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.TargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.TargetImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getTarget()
		 * @generated
		 */
		EClass TARGET = eINSTANCE.getTarget();

		/**
		 * The meta object literal for the '<em><b>Page Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__PAGE_CLASS_NAME = eINSTANCE.getTarget_PageClassName();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__PATH = eINSTANCE.getTarget_Path();

		/**
		 * The meta object literal for the '<em><b>Model Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__MODEL_CLASS_NAME = eINSTANCE.getTarget_ModelClassName();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.PlaceholderCollectionImpl <em>Placeholder Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.PlaceholderCollectionImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getPlaceholderCollection()
		 * @generated
		 */
		EClass PLACEHOLDER_COLLECTION = eINSTANCE.getPlaceholderCollection();

		/**
		 * The meta object literal for the '<em><b>Placeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEHOLDER_COLLECTION__PLACEHOLDERS = eINSTANCE.getPlaceholderCollection_Placeholders();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.SlaveCollectionImpl <em>Slave Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.SlaveCollectionImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getSlaveCollection()
		 * @generated
		 */
		EClass SLAVE_COLLECTION = eINSTANCE.getSlaveCollection();

		/**
		 * The meta object literal for the '<em><b>Slaves</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLAVE_COLLECTION__SLAVES = eINSTANCE.getSlaveCollection_Slaves();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LivePlaceholderImpl <em>Live Placeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LivePlaceholderImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLivePlaceholder()
		 * @generated
		 */
		EClass LIVE_PLACEHOLDER = eINSTANCE.getLivePlaceholder();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveSlaveImpl <em>Live Slave</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveSlaveImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveSlave()
		 * @generated
		 */
		EClass LIVE_SLAVE = eINSTANCE.getLiveSlave();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.LiveContributorCollectionImpl <em>Live Contributor Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.LiveContributorCollectionImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getLiveContributorCollection()
		 * @generated
		 */
		EClass LIVE_CONTRIBUTOR_COLLECTION = eINSTANCE.getLiveContributorCollection();

		/**
		 * The meta object literal for the '<em><b>Live Contributors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIVE_CONTRIBUTOR_COLLECTION__LIVE_CONTRIBUTORS = eINSTANCE.getLiveContributorCollection_LiveContributors();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.impl.ContributorCollectionImpl <em>Contributor Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.impl.ContributorCollectionImpl
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getContributorCollection()
		 * @generated
		 */
		EClass CONTRIBUTOR_COLLECTION = eINSTANCE.getContributorCollection();

		/**
		 * The meta object literal for the '<em><b>Contributors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTOR_COLLECTION__CONTRIBUTORS = eINSTANCE.getContributorCollection_Contributors();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.ContributorState <em>Contributor State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.ContributorState
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getContributorState()
		 * @generated
		 */
		EEnum CONTRIBUTOR_STATE = eINSTANCE.getContributorState();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.compose.CreationMode <em>Creation Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.compose.CreationMode
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getCreationMode()
		 * @generated
		 */
		EEnum CREATION_MODE = eINSTANCE.getCreationMode();

		/**
		 * The meta object literal for the '<em>Component Factory</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.ComponentFactory
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getComponentFactory()
		 * @generated
		 */
		EDataType COMPONENT_FACTORY = eINSTANCE.getComponentFactory();

		/**
		 * The meta object literal for the '<em>Bundle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osgi.framework.Bundle
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getBundle()
		 * @generated
		 */
		EDataType BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em>Page</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.wicket.Page
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getPage()
		 * @generated
		 */
		EDataType PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em>Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.soluvas.web.site.compose.impl.ComposePackageImpl#getCollection()
		 * @generated
		 */
		EDataType COLLECTION = eINSTANCE.getCollection();

	}

} //ComposePackage
