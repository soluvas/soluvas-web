/**
 */
package org.soluvas.web.site.pagemeta.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.web.site.pagemeta.*;

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
 * @see org.soluvas.web.site.pagemeta.PagemetaPackage
 * @generated
 */
public class PagemetaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PagemetaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PagemetaSwitch() {
		if (modelPackage == null) {
			modelPackage = PagemetaPackage.eINSTANCE;
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
			case PagemetaPackage.PAGE_META: {
				PageMeta pageMeta = (PageMeta)theEObject;
				T result = casePageMeta(pageMeta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_ICON: {
				PageIcon pageIcon = (PageIcon)theEObject;
				T result = casePageIcon(pageIcon);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.OPEN_GRAPH_META: {
				OpenGraphMeta openGraphMeta = (OpenGraphMeta)theEObject;
				T result = caseOpenGraphMeta(openGraphMeta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.OPEN_GRAPH_IMAGE: {
				OpenGraphImage openGraphImage = (OpenGraphImage)theEObject;
				T result = caseOpenGraphImage(openGraphImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.OPEN_GRAPH_VIDEO: {
				OpenGraphVideo openGraphVideo = (OpenGraphVideo)theEObject;
				T result = caseOpenGraphVideo(openGraphVideo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.OPEN_GRAPH_AUDIO: {
				OpenGraphAudio openGraphAudio = (OpenGraphAudio)theEObject;
				T result = caseOpenGraphAudio(openGraphAudio);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_SELECTOR: {
				PageSelector pageSelector = (PageSelector)theEObject;
				T result = casePageSelector(pageSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.URI_PATTERN_PAGE_SELECTOR: {
				UriPatternPageSelector uriPatternPageSelector = (UriPatternPageSelector)theEObject;
				T result = caseUriPatternPageSelector(uriPatternPageSelector);
				if (result == null) result = casePageSelector(uriPatternPageSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_RULE: {
				PageRule pageRule = (PageRule)theEObject;
				T result = casePageRule(pageRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_DECLARATION: {
				PageDeclaration pageDeclaration = (PageDeclaration)theEObject;
				T result = casePageDeclaration(pageDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.SOURCE_PAGE_DECLARATION: {
				SourcePageDeclaration sourcePageDeclaration = (SourcePageDeclaration)theEObject;
				T result = caseSourcePageDeclaration(sourcePageDeclaration);
				if (result == null) result = casePageDeclaration(sourcePageDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PROCESSOR_PAGE_DECLARATION: {
				ProcessorPageDeclaration processorPageDeclaration = (ProcessorPageDeclaration)theEObject;
				T result = caseProcessorPageDeclaration(processorPageDeclaration);
				if (result == null) result = casePageDeclaration(processorPageDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.RESOURCE_PAGE_DECLARATION: {
				ResourcePageDeclaration resourcePageDeclaration = (ResourcePageDeclaration)theEObject;
				T result = caseResourcePageDeclaration(resourcePageDeclaration);
				if (result == null) result = casePageDeclaration(resourcePageDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.REPOSITORY_PAGE_DECLARATION: {
				RepositoryPageDeclaration repositoryPageDeclaration = (RepositoryPageDeclaration)theEObject;
				T result = caseRepositoryPageDeclaration(repositoryPageDeclaration);
				if (result == null) result = casePageDeclaration(repositoryPageDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_META_CATALOG: {
				PageMetaCatalog pageMetaCatalog = (PageMetaCatalog)theEObject;
				T result = casePageMetaCatalog(pageMetaCatalog);
				if (result == null) result = casePageMetaCollection(pageMetaCatalog);
				if (result == null) result = casePageRuleCollection(pageMetaCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_META_COLLECTION: {
				PageMetaCollection pageMetaCollection = (PageMetaCollection)theEObject;
				T result = casePageMetaCollection(pageMetaCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_RULE_COLLECTION: {
				PageRuleCollection pageRuleCollection = (PageRuleCollection)theEObject;
				T result = casePageRuleCollection(pageRuleCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PagemetaPackage.PAGE_TITLE: {
				PageTitle pageTitle = (PageTitle)theEObject;
				T result = casePageTitle(pageTitle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Meta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Meta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageMeta(PageMeta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Icon</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Icon</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageIcon(PageIcon object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Graph Meta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Graph Meta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenGraphMeta(OpenGraphMeta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Graph Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Graph Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenGraphImage(OpenGraphImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Graph Video</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Graph Video</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenGraphVideo(OpenGraphVideo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Graph Audio</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Graph Audio</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenGraphAudio(OpenGraphAudio object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageSelector(PageSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uri Pattern Page Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uri Pattern Page Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUriPatternPageSelector(UriPatternPageSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageRule(PageRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageDeclaration(PageDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Page Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Page Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourcePageDeclaration(SourcePageDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Page Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Page Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorPageDeclaration(ProcessorPageDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Page Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Page Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourcePageDeclaration(ResourcePageDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository Page Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository Page Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepositoryPageDeclaration(RepositoryPageDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Meta Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Meta Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageMetaCatalog(PageMetaCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Meta Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Meta Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageMetaCollection(PageMetaCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Rule Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Rule Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageRuleCollection(PageRuleCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Title</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Title</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageTitle(PageTitle object) {
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

} //PagemetaSwitch
