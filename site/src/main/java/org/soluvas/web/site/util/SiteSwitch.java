/**
 */
package org.soluvas.web.site.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.commons.StyleConfiguration;
import org.soluvas.web.site.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.SitePackage
 * @generated
 */
public class SiteSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SitePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiteSwitch() {
		if (modelPackage == null) {
			modelPackage = SitePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SitePackage.SECTION: {
				Section section = (Section)theEObject;
				T result = caseSection(section);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.SITE_CATALOG: {
				SiteCatalog siteCatalog = (SiteCatalog)theEObject;
				T result = caseSiteCatalog(siteCatalog);
				if (result == null) result = caseSectionCollection(siteCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.SECTION_COLLECTION: {
				SectionCollection sectionCollection = (SectionCollection)theEObject;
				T result = caseSectionCollection(sectionCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.PAGE: {
				Page page = (Page)theEObject;
				T result = casePage(page);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.GENERIC_PAGE: {
				GenericPage genericPage = (GenericPage)theEObject;
				T result = caseGenericPage(genericPage);
				if (result == null) result = casePage(genericPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.RAW_ENTITY_TABLE_PAGE: {
				RawEntityTablePage rawEntityTablePage = (RawEntityTablePage)theEObject;
				T result = caseRawEntityTablePage(rawEntityTablePage);
				if (result == null) result = casePage(rawEntityTablePage);
				if (result == null) result = caseEntityPage(rawEntityTablePage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.ENTITY_TABLE_PAGE: {
				EntityTablePage entityTablePage = (EntityTablePage)theEObject;
				T result = caseEntityTablePage(entityTablePage);
				if (result == null) result = casePage(entityTablePage);
				if (result == null) result = caseEntityPage(entityTablePage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.ENTITY_EDIT_PAGE: {
				EntityEditPage entityEditPage = (EntityEditPage)theEObject;
				T result = caseEntityEditPage(entityEditPage);
				if (result == null) result = casePage(entityEditPage);
				if (result == null) result = caseEntityPage(entityEditPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.RAW_ENTITY_EDIT_PAGE: {
				RawEntityEditPage rawEntityEditPage = (RawEntityEditPage)theEObject;
				T result = caseRawEntityEditPage(rawEntityEditPage);
				if (result == null) result = casePage(rawEntityEditPage);
				if (result == null) result = caseEntityPage(rawEntityEditPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.RAW_ENTITY_NEW_PAGE: {
				RawEntityNewPage rawEntityNewPage = (RawEntityNewPage)theEObject;
				T result = caseRawEntityNewPage(rawEntityNewPage);
				if (result == null) result = casePage(rawEntityNewPage);
				if (result == null) result = caseEntityPage(rawEntityNewPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.ENTITY_NEW_PAGE: {
				EntityNewPage entityNewPage = (EntityNewPage)theEObject;
				T result = caseEntityNewPage(entityNewPage);
				if (result == null) result = casePage(entityNewPage);
				if (result == null) result = caseEntityPage(entityNewPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.CONTENT_PAGE: {
				ContentPage contentPage = (ContentPage)theEObject;
				T result = caseContentPage(contentPage);
				if (result == null) result = casePage(contentPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.DASHBOARD_PAGE: {
				DashboardPage dashboardPage = (DashboardPage)theEObject;
				T result = caseDashboardPage(dashboardPage);
				if (result == null) result = casePage(dashboardPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.PAGE_PARAM: {
				PageParam pageParam = (PageParam)theEObject;
				T result = casePageParam(pageParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.LOGIN_PAGE: {
				LoginPage loginPage = (LoginPage)theEObject;
				T result = caseLoginPage(loginPage);
				if (result == null) result = casePage(loginPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.REGISTER_PAGE: {
				RegisterPage registerPage = (RegisterPage)theEObject;
				T result = caseRegisterPage(registerPage);
				if (result == null) result = casePage(registerPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.RESET_PASSWORD_PAGE: {
				ResetPasswordPage resetPasswordPage = (ResetPasswordPage)theEObject;
				T result = caseResetPasswordPage(resetPasswordPage);
				if (result == null) result = casePage(resetPasswordPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.ENTITY_PAGE: {
				EntityPage entityPage = (EntityPage)theEObject;
				T result = caseEntityPage(entityPage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.PERMALINK_CATALOG: {
				PermalinkCatalog permalinkCatalog = (PermalinkCatalog)theEObject;
				T result = casePermalinkCatalog(permalinkCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.PERMALINK: {
				Permalink permalink = (Permalink)theEObject;
				T result = casePermalink(permalink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.PERMALINK_MANAGER: {
				PermalinkManager permalinkManager = (PermalinkManager)theEObject;
				T result = casePermalinkManager(permalinkManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.REQUIRE_MANAGER: {
				RequireManager requireManager = (RequireManager)theEObject;
				T result = caseRequireManager(requireManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.ALEXA_SYS_CONFIG: {
				AlexaSysConfig alexaSysConfig = (AlexaSysConfig)theEObject;
				T result = caseAlexaSysConfig(alexaSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.LIVE_CHAT_SYS_CONFIG: {
				LiveChatSysConfig liveChatSysConfig = (LiveChatSysConfig)theEObject;
				T result = caseLiveChatSysConfig(liveChatSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.GOOGLE_ANALYTICS_SYS_CONFIG: {
				GoogleAnalyticsSysConfig googleAnalyticsSysConfig = (GoogleAnalyticsSysConfig)theEObject;
				T result = caseGoogleAnalyticsSysConfig(googleAnalyticsSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.THEME_PREF: {
				ThemePref themePref = (ThemePref)theEObject;
				T result = caseThemePref(themePref);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SitePackage.GOOGLE_WEBMASTERS_SYS_CONFIG: {
				GoogleWebmastersSysConfig googleWebmastersSysConfig = (GoogleWebmastersSysConfig)theEObject;
				T result = caseGoogleWebmastersSysConfig(googleWebmastersSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSection(Section object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSiteCatalog(SiteCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSectionCollection(SectionCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePage(Page object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericPage(GenericPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Entity Table Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Entity Table Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawEntityTablePage(RawEntityTablePage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Table Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Table Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityTablePage(EntityTablePage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Edit Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Edit Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityEditPage(EntityEditPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Entity Edit Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Entity Edit Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawEntityEditPage(RawEntityEditPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Entity New Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Entity New Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawEntityNewPage(RawEntityNewPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity New Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity New Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityNewPage(EntityNewPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContentPage(ContentPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dashboard Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dashboard Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDashboardPage(DashboardPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageParam(PageParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Login Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Login Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoginPage(LoginPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Register Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Register Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegisterPage(RegisterPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reset Password Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reset Password Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResetPasswordPage(ResetPasswordPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityPage(EntityPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Permalink Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Permalink Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePermalinkCatalog(PermalinkCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Permalink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Permalink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePermalink(Permalink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Permalink Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Permalink Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePermalinkManager(PermalinkManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Require Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Require Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequireManager(RequireManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alexa Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alexa Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlexaSysConfig(AlexaSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Chat Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Chat Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveChatSysConfig(LiveChatSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Google Analytics Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Google Analytics Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoogleAnalyticsSysConfig(GoogleAnalyticsSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Theme Pref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Theme Pref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThemePref(ThemePref object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Google Webmasters Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Google Webmasters Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoogleWebmastersSysConfig(GoogleWebmastersSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SiteSwitch
