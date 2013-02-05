/**
 */
package org.soluvas.web.site.compose.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.web.site.compose.*;
import org.soluvas.web.site.compose.ChildContributor;
import org.soluvas.web.site.compose.ComponentContributor;
import org.soluvas.web.site.compose.ComposeCatalog;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.Contributor;
import org.soluvas.web.site.compose.ContributorCollection;
import org.soluvas.web.site.compose.HideContributor;
import org.soluvas.web.site.compose.LiveChildContributor;
import org.soluvas.web.site.compose.LiveComponentContributor;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.LiveContributorCollection;
import org.soluvas.web.site.compose.LiveHideContributor;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.LiveReplaceContributor;
import org.soluvas.web.site.compose.LiveSlave;
import org.soluvas.web.site.compose.LiveTarget;
import org.soluvas.web.site.compose.Placeholder;
import org.soluvas.web.site.compose.PlaceholderCollection;
import org.soluvas.web.site.compose.ReplaceContributor;
import org.soluvas.web.site.compose.Slave;
import org.soluvas.web.site.compose.SlaveCollection;
import org.soluvas.web.site.compose.Target;

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
 * @see org.soluvas.web.site.compose.ComposePackage
 * @generated
 */
public class ComposeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComposePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeSwitch() {
		if (modelPackage == null) {
			modelPackage = ComposePackage.eINSTANCE;
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
			case ComposePackage.PLACEHOLDER: {
				Placeholder placeholder = (Placeholder)theEObject;
				T result = casePlaceholder(placeholder);
				if (result == null) result = caseTarget(placeholder);
				if (result == null) result = caseResourceAware(placeholder);
				if (result == null) result = caseBundleAware(placeholder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.CONTRIBUTOR: {
				Contributor contributor = (Contributor)theEObject;
				T result = caseContributor(contributor);
				if (result == null) result = caseBundleAware(contributor);
				if (result == null) result = caseResourceAware(contributor);
				if (result == null) result = casePositionable(contributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_TARGET: {
				LiveTarget liveTarget = (LiveTarget)theEObject;
				T result = caseLiveTarget(liveTarget);
				if (result == null) result = caseTarget(liveTarget);
				if (result == null) result = caseResourceAware(liveTarget);
				if (result == null) result = caseBundleAware(liveTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_CONTRIBUTOR: {
				LiveContributor liveContributor = (LiveContributor)theEObject;
				T result = caseLiveContributor(liveContributor);
				if (result == null) result = caseContributor(liveContributor);
				if (result == null) result = caseBundleAware(liveContributor);
				if (result == null) result = caseResourceAware(liveContributor);
				if (result == null) result = casePositionable(liveContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.HIDE_CONTRIBUTOR: {
				HideContributor hideContributor = (HideContributor)theEObject;
				T result = caseHideContributor(hideContributor);
				if (result == null) result = caseContributor(hideContributor);
				if (result == null) result = caseBundleAware(hideContributor);
				if (result == null) result = caseResourceAware(hideContributor);
				if (result == null) result = casePositionable(hideContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.COMPONENT_CONTRIBUTOR: {
				ComponentContributor componentContributor = (ComponentContributor)theEObject;
				T result = caseComponentContributor(componentContributor);
				if (result == null) result = caseContributor(componentContributor);
				if (result == null) result = caseBundleAware(componentContributor);
				if (result == null) result = caseResourceAware(componentContributor);
				if (result == null) result = casePositionable(componentContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.CHILD_CONTRIBUTOR: {
				ChildContributor childContributor = (ChildContributor)theEObject;
				T result = caseChildContributor(childContributor);
				if (result == null) result = caseComponentContributor(childContributor);
				if (result == null) result = caseContributor(childContributor);
				if (result == null) result = caseBundleAware(childContributor);
				if (result == null) result = caseResourceAware(childContributor);
				if (result == null) result = casePositionable(childContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_CHILD_CONTRIBUTOR: {
				LiveChildContributor liveChildContributor = (LiveChildContributor)theEObject;
				T result = caseLiveChildContributor(liveChildContributor);
				if (result == null) result = caseChildContributor(liveChildContributor);
				if (result == null) result = caseLiveComponentContributor(liveChildContributor);
				if (result == null) result = caseComponentContributor(liveChildContributor);
				if (result == null) result = caseLiveContributor(liveChildContributor);
				if (result == null) result = caseContributor(liveChildContributor);
				if (result == null) result = caseBundleAware(liveChildContributor);
				if (result == null) result = caseResourceAware(liveChildContributor);
				if (result == null) result = casePositionable(liveChildContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR: {
				LiveReplaceContributor liveReplaceContributor = (LiveReplaceContributor)theEObject;
				T result = caseLiveReplaceContributor(liveReplaceContributor);
				if (result == null) result = caseReplaceContributor(liveReplaceContributor);
				if (result == null) result = caseLiveComponentContributor(liveReplaceContributor);
				if (result == null) result = caseComponentContributor(liveReplaceContributor);
				if (result == null) result = caseLiveContributor(liveReplaceContributor);
				if (result == null) result = caseContributor(liveReplaceContributor);
				if (result == null) result = caseBundleAware(liveReplaceContributor);
				if (result == null) result = caseResourceAware(liveReplaceContributor);
				if (result == null) result = casePositionable(liveReplaceContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.REPLACE_CONTRIBUTOR: {
				ReplaceContributor replaceContributor = (ReplaceContributor)theEObject;
				T result = caseReplaceContributor(replaceContributor);
				if (result == null) result = caseComponentContributor(replaceContributor);
				if (result == null) result = caseContributor(replaceContributor);
				if (result == null) result = caseBundleAware(replaceContributor);
				if (result == null) result = caseResourceAware(replaceContributor);
				if (result == null) result = casePositionable(replaceContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR: {
				LiveComponentContributor liveComponentContributor = (LiveComponentContributor)theEObject;
				T result = caseLiveComponentContributor(liveComponentContributor);
				if (result == null) result = caseLiveContributor(liveComponentContributor);
				if (result == null) result = caseComponentContributor(liveComponentContributor);
				if (result == null) result = caseContributor(liveComponentContributor);
				if (result == null) result = caseBundleAware(liveComponentContributor);
				if (result == null) result = caseResourceAware(liveComponentContributor);
				if (result == null) result = casePositionable(liveComponentContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_HIDE_CONTRIBUTOR: {
				LiveHideContributor liveHideContributor = (LiveHideContributor)theEObject;
				T result = caseLiveHideContributor(liveHideContributor);
				if (result == null) result = caseLiveContributor(liveHideContributor);
				if (result == null) result = caseHideContributor(liveHideContributor);
				if (result == null) result = caseContributor(liveHideContributor);
				if (result == null) result = caseBundleAware(liveHideContributor);
				if (result == null) result = caseResourceAware(liveHideContributor);
				if (result == null) result = casePositionable(liveHideContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.COMPOSE_CATALOG: {
				ComposeCatalog composeCatalog = (ComposeCatalog)theEObject;
				T result = caseComposeCatalog(composeCatalog);
				if (result == null) result = caseSlaveCollection(composeCatalog);
				if (result == null) result = casePlaceholderCollection(composeCatalog);
				if (result == null) result = caseContributorCollection(composeCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.SLAVE: {
				Slave slave = (Slave)theEObject;
				T result = caseSlave(slave);
				if (result == null) result = caseTarget(slave);
				if (result == null) result = caseResourceAware(slave);
				if (result == null) result = caseBundleAware(slave);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.TARGET: {
				Target target = (Target)theEObject;
				T result = caseTarget(target);
				if (result == null) result = caseResourceAware(target);
				if (result == null) result = caseBundleAware(target);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.PLACEHOLDER_COLLECTION: {
				PlaceholderCollection placeholderCollection = (PlaceholderCollection)theEObject;
				T result = casePlaceholderCollection(placeholderCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.SLAVE_COLLECTION: {
				SlaveCollection slaveCollection = (SlaveCollection)theEObject;
				T result = caseSlaveCollection(slaveCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_PLACEHOLDER: {
				LivePlaceholder livePlaceholder = (LivePlaceholder)theEObject;
				T result = caseLivePlaceholder(livePlaceholder);
				if (result == null) result = caseLiveTarget(livePlaceholder);
				if (result == null) result = casePlaceholder(livePlaceholder);
				if (result == null) result = caseTarget(livePlaceholder);
				if (result == null) result = caseResourceAware(livePlaceholder);
				if (result == null) result = caseBundleAware(livePlaceholder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_SLAVE: {
				LiveSlave liveSlave = (LiveSlave)theEObject;
				T result = caseLiveSlave(liveSlave);
				if (result == null) result = caseLiveTarget(liveSlave);
				if (result == null) result = caseSlave(liveSlave);
				if (result == null) result = caseTarget(liveSlave);
				if (result == null) result = caseResourceAware(liveSlave);
				if (result == null) result = caseBundleAware(liveSlave);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.LIVE_CONTRIBUTOR_COLLECTION: {
				LiveContributorCollection liveContributorCollection = (LiveContributorCollection)theEObject;
				T result = caseLiveContributorCollection(liveContributorCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComposePackage.CONTRIBUTOR_COLLECTION: {
				ContributorCollection contributorCollection = (ContributorCollection)theEObject;
				T result = caseContributorCollection(contributorCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholder(Placeholder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContributor(Contributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveTarget(LiveTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveContributor(LiveContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hide Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hide Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHideContributor(HideContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentContributor(ComponentContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildContributor(ChildContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Child Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Child Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveChildContributor(LiveChildContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Replace Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Replace Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveReplaceContributor(LiveReplaceContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replace Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replace Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplaceContributor(ReplaceContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Component Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Component Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveComponentContributor(LiveComponentContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Hide Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Hide Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveHideContributor(LiveHideContributor object) {
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
	public T caseComposeCatalog(ComposeCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slave</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slave</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlave(Slave object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTarget(Target object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholderCollection(PlaceholderCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slave Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slave Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlaveCollection(SlaveCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Placeholder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Placeholder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLivePlaceholder(LivePlaceholder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Slave</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Slave</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveSlave(LiveSlave object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Contributor Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Contributor Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveContributorCollection(LiveContributorCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contributor Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contributor Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContributorCollection(ContributorCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceAware(ResourceAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBundleAware(BundleAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Positionable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Positionable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositionable(Positionable object) {
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

} //ComposeSwitch
