/**
 */
package org.soluvas.web.olark;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.soluvas.web.olark.OlarkFactory
 * @model kind="package"
 * @generated
 */
public interface OlarkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "olark";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/web.olark/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "olark";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OlarkPackage eINSTANCE = org.soluvas.web.olark.impl.OlarkPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.olark.impl.OlarkManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.olark.impl.OlarkManagerImpl
	 * @see org.soluvas.web.olark.impl.OlarkPackageImpl#getOlarkManager()
	 * @generated
	 */
	int OLARK_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Site Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLARK_MANAGER__SITE_ID = 0;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLARK_MANAGER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.olark.OlarkManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.soluvas.web.olark.OlarkManager
	 * @generated
	 */
	EClass getOlarkManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.olark.OlarkManager#getSiteId <em>Site Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Site Id</em>'.
	 * @see org.soluvas.web.olark.OlarkManager#getSiteId()
	 * @see #getOlarkManager()
	 * @generated
	 */
	EAttribute getOlarkManager_SiteId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OlarkFactory getOlarkFactory();

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
		 * The meta object literal for the '{@link org.soluvas.web.olark.impl.OlarkManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.olark.impl.OlarkManagerImpl
		 * @see org.soluvas.web.olark.impl.OlarkPackageImpl#getOlarkManager()
		 * @generated
		 */
		EClass OLARK_MANAGER = eINSTANCE.getOlarkManager();

		/**
		 * The meta object literal for the '<em><b>Site Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OLARK_MANAGER__SITE_ID = eINSTANCE.getOlarkManager_SiteId();

	}

} //OlarkPackage
