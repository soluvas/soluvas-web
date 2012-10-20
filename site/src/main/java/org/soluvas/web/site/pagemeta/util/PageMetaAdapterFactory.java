/**
 */
package org.soluvas.web.site.pagemeta.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.soluvas.web.site.pagemeta.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.pagemeta.PageMetaPackage
 * @generated
 */
public class PageMetaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PageMetaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMetaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PageMetaPackage.eINSTANCE;
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
	protected PageMetaSwitch<Adapter> modelSwitch =
		new PageMetaSwitch<Adapter>() {
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
			public Adapter casePageMetaCatalog(PageMetaCatalog object) {
				return createPageMetaCatalogAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageMeta <em>Page Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageMeta
	 * @generated
	 */
	public Adapter createPageMetaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageIcon <em>Page Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageIcon
	 * @generated
	 */
	public Adapter createPageIconAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta <em>Open Graph Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta
	 * @generated
	 */
	public Adapter createOpenGraphMetaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.OpenGraphImage <em>Open Graph Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage
	 * @generated
	 */
	public Adapter createOpenGraphImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo <em>Open Graph Video</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo
	 * @generated
	 */
	public Adapter createOpenGraphVideoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio <em>Open Graph Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphAudio
	 * @generated
	 */
	public Adapter createOpenGraphAudioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageSelector <em>Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageSelector
	 * @generated
	 */
	public Adapter createPageSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.UriPatternPageSelector <em>Uri Pattern Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.UriPatternPageSelector
	 * @generated
	 */
	public Adapter createUriPatternPageSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageRule <em>Page Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageRule
	 * @generated
	 */
	public Adapter createPageRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageDeclaration <em>Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageDeclaration
	 * @generated
	 */
	public Adapter createPageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.SourcePageDeclaration <em>Source Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.SourcePageDeclaration
	 * @generated
	 */
	public Adapter createSourcePageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.ProcessorPageDeclaration <em>Processor Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.ProcessorPageDeclaration
	 * @generated
	 */
	public Adapter createProcessorPageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.ResourcePageDeclaration <em>Resource Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.ResourcePageDeclaration
	 * @generated
	 */
	public Adapter createResourcePageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.RepositoryPageDeclaration <em>Repository Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.RepositoryPageDeclaration
	 * @generated
	 */
	public Adapter createRepositoryPageDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageMetaCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageMetaCatalog
	 * @generated
	 */
	public Adapter createPageMetaCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageMetaCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageMetaCollection
	 * @generated
	 */
	public Adapter createPageMetaCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageRuleCollection <em>Page Rule Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageRuleCollection
	 * @generated
	 */
	public Adapter createPageRuleCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.web.site.pagemeta.PageTitle <em>Page Title</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.web.site.pagemeta.PageTitle
	 * @generated
	 */
	public Adapter createPageTitleAdapter() {
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

} //PageMetaAdapterFactory
