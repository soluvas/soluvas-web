/**
 */
package org.soluvas.web.site.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.StyleConfiguration;
import org.soluvas.web.site.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.SitePackage
 * @generated
 */
public class SiteAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SitePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiteAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SitePackage.eINSTANCE;
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
	protected SiteSwitch<Adapter> modelSwitch =
		new SiteSwitch<Adapter>() {
			@Override
			public Adapter caseSection(Section object) {
				return createSectionAdapter();
			}
			@Override
			public Adapter caseSiteCatalog(SiteCatalog object) {
				return createSiteCatalogAdapter();
			}
			@Override
			public Adapter caseSectionCollection(SectionCollection object) {
				return createSectionCollectionAdapter();
			}
			@Override
			public Adapter casePage(Page object) {
				return createPageAdapter();
			}
			@Override
			public Adapter caseGenericPage(GenericPage object) {
				return createGenericPageAdapter();
			}
			@Override
			public Adapter caseRawEntityTablePage(RawEntityTablePage object) {
				return createRawEntityTablePageAdapter();
			}
			@Override
			public Adapter caseEntityTablePage(EntityTablePage object) {
				return createEntityTablePageAdapter();
			}
			@Override
			public Adapter caseEntityEditPage(EntityEditPage object) {
				return createEntityEditPageAdapter();
			}
			@Override
			public Adapter caseRawEntityEditPage(RawEntityEditPage object) {
				return createRawEntityEditPageAdapter();
			}
			@Override
			public Adapter caseRawEntityNewPage(RawEntityNewPage object) {
				return createRawEntityNewPageAdapter();
			}
			@Override
			public Adapter caseEntityNewPage(EntityNewPage object) {
				return createEntityNewPageAdapter();
			}
			@Override
			public Adapter caseContentPage(ContentPage object) {
				return createContentPageAdapter();
			}
			@Override
			public Adapter caseDashboardPage(DashboardPage object) {
				return createDashboardPageAdapter();
			}
			@Override
			public Adapter casePageParam(PageParam object) {
				return createPageParamAdapter();
			}
			@Override
			public Adapter caseLoginPage(LoginPage object) {
				return createLoginPageAdapter();
			}
			@Override
			public Adapter caseRegisterPage(RegisterPage object) {
				return createRegisterPageAdapter();
			}
			@Override
			public Adapter caseResetPasswordPage(ResetPasswordPage object) {
				return createResetPasswordPageAdapter();
			}
			@Override
			public Adapter caseEntityPage(EntityPage object) {
				return createEntityPageAdapter();
			}
			@Override
			public Adapter casePermalinkCatalog(PermalinkCatalog object) {
				return createPermalinkCatalogAdapter();
			}
			@Override
			public Adapter casePermalink(Permalink object) {
				return createPermalinkAdapter();
			}
			@Override
			public Adapter casePermalinkManager(PermalinkManager object) {
				return createPermalinkManagerAdapter();
			}
			@Override
			public Adapter caseRequireManager(RequireManager object) {
				return createRequireManagerAdapter();
			}
			@Override
			public Adapter caseAlexaSysConfig(AlexaSysConfig object) {
				return createAlexaSysConfigAdapter();
			}
			@Override
			public Adapter caseLiveChatSysConfig(LiveChatSysConfig object) {
				return createLiveChatSysConfigAdapter();
			}
			@Override
			public Adapter caseGoogleAnalyticsSysConfig(GoogleAnalyticsSysConfig object) {
				return createGoogleAnalyticsSysConfigAdapter();
			}
			@Override
			public Adapter caseThemePref(ThemePref object) {
				return createThemePrefAdapter();
			}
			@Override
			public Adapter caseGoogleSysConfig(GoogleSysConfig object) {
				return createGoogleSysConfigAdapter();
			}
			@Override
			public Adapter caseGooglePlusSysConfig(GooglePlusSysConfig object) {
				return createGooglePlusSysConfigAdapter();
			}
			@Override
			public Adapter caseBingSysConfig(BingSysConfig object) {
				return createBingSysConfigAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.Section
	 * @generated
	 */
	public Adapter createSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.SiteCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.SiteCatalog
	 * @generated
	 */
	public Adapter createSiteCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.SectionCollection <em>Section Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.SectionCollection
	 * @generated
	 */
	public Adapter createSectionCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.Page
	 * @generated
	 */
	public Adapter createPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.GenericPage <em>Generic Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.GenericPage
	 * @generated
	 */
	public Adapter createGenericPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.RawEntityTablePage <em>Raw Entity Table Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.RawEntityTablePage
	 * @generated
	 */
	public Adapter createRawEntityTablePageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.EntityTablePage <em>Entity Table Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.EntityTablePage
	 * @generated
	 */
	public Adapter createEntityTablePageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.EntityEditPage <em>Entity Edit Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.EntityEditPage
	 * @generated
	 */
	public Adapter createEntityEditPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.RawEntityEditPage <em>Raw Entity Edit Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.RawEntityEditPage
	 * @generated
	 */
	public Adapter createRawEntityEditPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.RawEntityNewPage <em>Raw Entity New Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.RawEntityNewPage
	 * @generated
	 */
	public Adapter createRawEntityNewPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.EntityNewPage <em>Entity New Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.EntityNewPage
	 * @generated
	 */
	public Adapter createEntityNewPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.ContentPage <em>Content Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.ContentPage
	 * @generated
	 */
	public Adapter createContentPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.DashboardPage <em>Dashboard Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.DashboardPage
	 * @generated
	 */
	public Adapter createDashboardPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageParam <em>Page Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageParam
	 * @generated
	 */
	public Adapter createPageParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.LoginPage <em>Login Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.LoginPage
	 * @generated
	 */
	public Adapter createLoginPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.RegisterPage <em>Register Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.RegisterPage
	 * @generated
	 */
	public Adapter createRegisterPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.ResetPasswordPage <em>Reset Password Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.ResetPasswordPage
	 * @generated
	 */
	public Adapter createResetPasswordPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.EntityPage <em>Entity Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.EntityPage
	 * @generated
	 */
	public Adapter createEntityPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PermalinkCatalog <em>Permalink Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PermalinkCatalog
	 * @generated
	 */
	public Adapter createPermalinkCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.Permalink <em>Permalink</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.Permalink
	 * @generated
	 */
	public Adapter createPermalinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PermalinkManager <em>Permalink Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PermalinkManager
	 * @generated
	 */
	public Adapter createPermalinkManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.RequireManager <em>Require Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.RequireManager
	 * @generated
	 */
	public Adapter createRequireManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.AlexaSysConfig <em>Alexa Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.AlexaSysConfig
	 * @generated
	 */
	public Adapter createAlexaSysConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.LiveChatSysConfig <em>Live Chat Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.LiveChatSysConfig
	 * @generated
	 */
	public Adapter createLiveChatSysConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig <em>Google Analytics Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig
	 * @generated
	 */
	public Adapter createGoogleAnalyticsSysConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.ThemePref <em>Theme Pref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.ThemePref
	 * @generated
	 */
	public Adapter createThemePrefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.GoogleSysConfig <em>Google Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.GoogleSysConfig
	 * @generated
	 */
	public Adapter createGoogleSysConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.GooglePlusSysConfig <em>Google Plus Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.GooglePlusSysConfig
	 * @generated
	 */
	public Adapter createGooglePlusSysConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.BingSysConfig <em>Bing Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.BingSysConfig
	 * @generated
	 */
	public Adapter createBingSysConfigAdapter() {
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

} //SiteAdapterFactory
