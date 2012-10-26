/**
 */
package org.soluvas.web.site.webaddress;

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
 * @see org.soluvas.web.site.webaddress.WebaddressFactory
 * @model kind="package"
 * @generated
 */
public interface WebaddressPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "webaddress";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/web.site.webaddress/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "webaddress";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WebaddressPackage eINSTANCE = org.soluvas.web.site.webaddress.impl.WebaddressPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl <em>Web Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.webaddress.impl.WebAddressImpl
	 * @see org.soluvas.web.site.webaddress.impl.WebaddressPackageImpl#getWebAddress()
	 * @generated
	 */
	int WEB_ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__BASE_URI = 0;

	/**
	 * The feature id for the '<em><b>Base Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__BASE_PATH = 1;

	/**
	 * The feature id for the '<em><b>Api Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__API_PATH = 2;

	/**
	 * The feature id for the '<em><b>Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__IMAGES_URI = 3;

	/**
	 * The feature id for the '<em><b>Skin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SKIN_URI = 4;

	/**
	 * The feature id for the '<em><b>Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__JS_URI = 5;

	/**
	 * The feature id for the '<em><b>Secure Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_BASE_URI = 6;

	/**
	 * The feature id for the '<em><b>Secure Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_IMAGES_URI = 7;

	/**
	 * The feature id for the '<em><b>Secure Skin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_SKIN_URI = 8;

	/**
	 * The feature id for the '<em><b>Secure Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_JS_URI = 9;

	/**
	 * The number of structural features of the '<em>Web Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS_FEATURE_COUNT = 10;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.webaddress.WebAddress <em>Web Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Address</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress
	 * @generated
	 */
	EClass getWebAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getBaseUri <em>Base Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getBaseUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_BaseUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getBasePath <em>Base Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Path</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getBasePath()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_BasePath();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getApiPath <em>Api Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Path</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getApiPath()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_ApiPath();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getImagesUri <em>Images Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Images Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getImagesUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_ImagesUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getSkinUri <em>Skin Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skin Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getSkinUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SkinUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getJsUri <em>Js Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Js Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getJsUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_JsUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureBaseUri <em>Secure Base Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Base Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getSecureBaseUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureBaseUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureImagesUri <em>Secure Images Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Images Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getSecureImagesUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureImagesUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureSkinUri <em>Secure Skin Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Skin Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getSecureSkinUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureSkinUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.webaddress.WebAddress#getSecureJsUri <em>Secure Js Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Js Uri</em>'.
	 * @see org.soluvas.web.site.webaddress.WebAddress#getSecureJsUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureJsUri();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WebaddressFactory getWebaddressFactory();

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
		 * The meta object literal for the '{@link org.soluvas.web.site.webaddress.impl.WebAddressImpl <em>Web Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.webaddress.impl.WebAddressImpl
		 * @see org.soluvas.web.site.webaddress.impl.WebaddressPackageImpl#getWebAddress()
		 * @generated
		 */
		EClass WEB_ADDRESS = eINSTANCE.getWebAddress();

		/**
		 * The meta object literal for the '<em><b>Base Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__BASE_URI = eINSTANCE.getWebAddress_BaseUri();

		/**
		 * The meta object literal for the '<em><b>Base Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__BASE_PATH = eINSTANCE.getWebAddress_BasePath();

		/**
		 * The meta object literal for the '<em><b>Api Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__API_PATH = eINSTANCE.getWebAddress_ApiPath();

		/**
		 * The meta object literal for the '<em><b>Images Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__IMAGES_URI = eINSTANCE.getWebAddress_ImagesUri();

		/**
		 * The meta object literal for the '<em><b>Skin Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SKIN_URI = eINSTANCE.getWebAddress_SkinUri();

		/**
		 * The meta object literal for the '<em><b>Js Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__JS_URI = eINSTANCE.getWebAddress_JsUri();

		/**
		 * The meta object literal for the '<em><b>Secure Base Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_BASE_URI = eINSTANCE.getWebAddress_SecureBaseUri();

		/**
		 * The meta object literal for the '<em><b>Secure Images Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_IMAGES_URI = eINSTANCE.getWebAddress_SecureImagesUri();

		/**
		 * The meta object literal for the '<em><b>Secure Skin Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_SKIN_URI = eINSTANCE.getWebAddress_SecureSkinUri();

		/**
		 * The meta object literal for the '<em><b>Secure Js Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_JS_URI = eINSTANCE.getWebAddress_SecureJsUri();

	}

} //WebaddressPackage
