/**
 */
package org.soluvas.web.site.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
			public Adapter casePageMeta(PageMeta object) {
				return createPageMetaAdapter();
			}
			@Override
			public Adapter casePageIcon(PageIcon object) {
				return createPageIconAdapter();
			}
			@Override
			public Adapter caseOpenGraphMeta(OpenGraphMeta object) {
				return createOpenGraphMetaAdapter();
			}
			@Override
			public Adapter caseOpenGraphImage(OpenGraphImage object) {
				return createOpenGraphImageAdapter();
			}
			@Override
			public Adapter caseOpenGraphVideo(OpenGraphVideo object) {
				return createOpenGraphVideoAdapter();
			}
			@Override
			public Adapter caseOpenGraphAudio(OpenGraphAudio object) {
				return createOpenGraphAudioAdapter();
			}
			@Override
			public Adapter casePageSelector(PageSelector object) {
				return createPageSelectorAdapter();
			}
			@Override
			public Adapter caseUriPatternPageSelector(UriPatternPageSelector object) {
				return createUriPatternPageSelectorAdapter();
			}
			@Override
			public Adapter casePageRule(PageRule object) {
				return createPageRuleAdapter();
			}
			@Override
			public Adapter casePageDeclaration(PageDeclaration object) {
				return createPageDeclarationAdapter();
			}
			@Override
			public Adapter caseSourcePageDeclaration(SourcePageDeclaration object) {
				return createSourcePageDeclarationAdapter();
			}
			@Override
			public Adapter caseProcessorPageDeclaration(ProcessorPageDeclaration object) {
				return createProcessorPageDeclarationAdapter();
			}
			@Override
			public Adapter caseResourcePageDeclaration(ResourcePageDeclaration object) {
				return createResourcePageDeclarationAdapter();
			}
			@Override
			public Adapter caseRepositoryPageDeclaration(RepositoryPageDeclaration object) {
				return createRepositoryPageDeclarationAdapter();
			}
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
			public Adapter casePageMetaCollection(PageMetaCollection object) {
				return createPageMetaCollectionAdapter();
			}
			@Override
			public Adapter casePageRuleCollection(PageRuleCollection object) {
				return createPageRuleCollectionAdapter();
			}
			@Override
			public Adapter casePageTitle(PageTitle object) {
				return createPageTitleAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageMeta <em>Page Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageMeta
	 * @generated
	 */
	public Adapter createPageMetaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageIcon <em>Page Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageIcon
	 * @generated
	 */
	public Adapter createPageIconAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.OpenGraphMeta <em>Open Graph Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.OpenGraphMeta
	 * @generated
	 */
	public Adapter createOpenGraphMetaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.OpenGraphImage <em>Open Graph Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.OpenGraphImage
	 * @generated
	 */
	public Adapter createOpenGraphImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.OpenGraphVideo <em>Open Graph Video</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.OpenGraphVideo
	 * @generated
	 */
	public Adapter createOpenGraphVideoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.OpenGraphAudio <em>Open Graph Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.OpenGraphAudio
	 * @generated
	 */
	public Adapter createOpenGraphAudioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageSelector <em>Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageSelector
	 * @generated
	 */
	public Adapter createPageSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.UriPatternPageSelector <em>Uri Pattern Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.UriPatternPageSelector
	 * @generated
	 */
	public Adapter createUriPatternPageSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageRule <em>Page Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageRule
	 * @generated
	 */
	public Adapter createPageRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageDeclaration <em>Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageDeclaration
	 * @generated
	 */
	public Adapter createPageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.SourcePageDeclaration <em>Source Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.SourcePageDeclaration
	 * @generated
	 */
	public Adapter createSourcePageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.ProcessorPageDeclaration <em>Processor Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.ProcessorPageDeclaration
	 * @generated
	 */
	public Adapter createProcessorPageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.ResourcePageDeclaration <em>Resource Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.ResourcePageDeclaration
	 * @generated
	 */
	public Adapter createResourcePageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.RepositoryPageDeclaration <em>Repository Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.RepositoryPageDeclaration
	 * @generated
	 */
	public Adapter createRepositoryPageDeclarationAdapter() {
		return null;
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
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageMetaCollection <em>Page Meta Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageMetaCollection
	 * @generated
	 */
	public Adapter createPageMetaCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageRuleCollection <em>Page Rule Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageRuleCollection
	 * @generated
	 */
	public Adapter createPageRuleCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.PageTitle <em>Page Title</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.PageTitle
	 * @generated
	 */
	public Adapter createPageTitleAdapter() {
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
