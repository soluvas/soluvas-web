/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EFactory;
import org.soluvas.web.site.pagemeta.OpenGraphAudio;
import org.soluvas.web.site.pagemeta.OpenGraphVideo;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.SitePackage
 * @generated
 */
public interface SiteFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SiteFactory eINSTANCE = org.soluvas.web.site.impl.SiteFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section</em>'.
	 * @generated
	 */
	Section createSection();

	/**
	 * Returns a new object of class '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catalog</em>'.
	 * @generated
	 */
	SiteCatalog createSiteCatalog();

	/**
	 * Returns a new object of class '<em>Section Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section Collection</em>'.
	 * @generated
	 */
	SectionCollection createSectionCollection();

	/**
	 * Returns a new object of class '<em>Generic Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Page</em>'.
	 * @generated
	 */
	GenericPage createGenericPage();

	/**
	 * Returns a new object of class '<em>Raw Entity Table Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Raw Entity Table Page</em>'.
	 * @generated
	 */
	RawEntityTablePage createRawEntityTablePage();

	/**
	 * Returns a new object of class '<em>Entity Table Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Table Page</em>'.
	 * @generated
	 */
	EntityTablePage createEntityTablePage();

	/**
	 * Returns a new object of class '<em>Entity Edit Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Edit Page</em>'.
	 * @generated
	 */
	EntityEditPage createEntityEditPage();

	/**
	 * Returns a new object of class '<em>Raw Entity Edit Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Raw Entity Edit Page</em>'.
	 * @generated
	 */
	RawEntityEditPage createRawEntityEditPage();

	/**
	 * Returns a new object of class '<em>Raw Entity New Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Raw Entity New Page</em>'.
	 * @generated
	 */
	RawEntityNewPage createRawEntityNewPage();

	/**
	 * Returns a new object of class '<em>Entity New Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity New Page</em>'.
	 * @generated
	 */
	EntityNewPage createEntityNewPage();

	/**
	 * Returns a new object of class '<em>Content Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Page</em>'.
	 * @generated
	 */
	ContentPage createContentPage();

	/**
	 * Returns a new object of class '<em>Dashboard Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dashboard Page</em>'.
	 * @generated
	 */
	DashboardPage createDashboardPage();

	/**
	 * Returns a new object of class '<em>Page Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Param</em>'.
	 * @generated
	 */
	PageParam createPageParam();

	/**
	 * Returns a new object of class '<em>Login Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Login Page</em>'.
	 * @generated
	 */
	LoginPage createLoginPage();

	/**
	 * Returns a new object of class '<em>Register Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Register Page</em>'.
	 * @generated
	 */
	RegisterPage createRegisterPage();

	/**
	 * Returns a new object of class '<em>Reset Password Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reset Password Page</em>'.
	 * @generated
	 */
	ResetPasswordPage createResetPasswordPage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SitePackage getSitePackage();

} //SiteFactory
