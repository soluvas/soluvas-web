/**
 */
package org.soluvas.web.olark;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	 * The meta object id for the '{@link org.soluvas.web.olark.impl.LiveChatManagerImpl <em>Live Chat Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.olark.impl.LiveChatManagerImpl
	 * @see org.soluvas.web.olark.impl.OlarkPackageImpl#getLiveChatManager()
	 * @generated
	 */
	int LIVE_CHAT_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Site Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_MANAGER__SITE_ID = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_MANAGER__ENABLED = 1;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_MANAGER__PROVIDER = 2;

	/**
	 * The number of structural features of the '<em>Live Chat Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_MANAGER_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link org.soluvas.web.olark.LiveChatProvider <em>Live Chat Provider</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.olark.LiveChatProvider
	 * @see org.soluvas.web.olark.impl.OlarkPackageImpl#getLiveChatProvider()
	 * @generated
	 */
	int LIVE_CHAT_PROVIDER = 1;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.olark.LiveChatManager <em>Live Chat Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Chat Manager</em>'.
	 * @see org.soluvas.web.olark.LiveChatManager
	 * @generated
	 */
	EClass getLiveChatManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.olark.LiveChatManager#getSiteId <em>Site Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Site Id</em>'.
	 * @see org.soluvas.web.olark.LiveChatManager#getSiteId()
	 * @see #getLiveChatManager()
	 * @generated
	 */
	EAttribute getLiveChatManager_SiteId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.olark.LiveChatManager#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.soluvas.web.olark.LiveChatManager#isEnabled()
	 * @see #getLiveChatManager()
	 * @generated
	 */
	EAttribute getLiveChatManager_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.olark.LiveChatManager#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.soluvas.web.olark.LiveChatManager#getProvider()
	 * @see #getLiveChatManager()
	 * @generated
	 */
	EAttribute getLiveChatManager_Provider();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.web.olark.LiveChatProvider <em>Live Chat Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Live Chat Provider</em>'.
	 * @see org.soluvas.web.olark.LiveChatProvider
	 * @generated
	 */
	EEnum getLiveChatProvider();

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
		 * The meta object literal for the '{@link org.soluvas.web.olark.impl.LiveChatManagerImpl <em>Live Chat Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.olark.impl.LiveChatManagerImpl
		 * @see org.soluvas.web.olark.impl.OlarkPackageImpl#getLiveChatManager()
		 * @generated
		 */
		EClass LIVE_CHAT_MANAGER = eINSTANCE.getLiveChatManager();

		/**
		 * The meta object literal for the '<em><b>Site Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_MANAGER__SITE_ID = eINSTANCE.getLiveChatManager_SiteId();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_MANAGER__ENABLED = eINSTANCE.getLiveChatManager_Enabled();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_MANAGER__PROVIDER = eINSTANCE.getLiveChatManager_Provider();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.olark.LiveChatProvider <em>Live Chat Provider</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.olark.LiveChatProvider
		 * @see org.soluvas.web.olark.impl.OlarkPackageImpl#getLiveChatProvider()
		 * @generated
		 */
		EEnum LIVE_CHAT_PROVIDER = eINSTANCE.getLiveChatProvider();

	}

} //OlarkPackage
