/**
 */
package org.soluvas.web.site.compose;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.compose.ComposePackage
 * @generated
 */
public interface ComposeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComposeFactory eINSTANCE = org.soluvas.web.site.compose.impl.ComposeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Placeholder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placeholder</em>'.
	 * @generated
	 */
	Placeholder createPlaceholder();

	/**
	 * Returns a new object of class '<em>Live Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Target</em>'.
	 * @generated
	 */
	LiveTarget createLiveTarget();

	/**
	 * Returns a new object of class '<em>Hide Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hide Contributor</em>'.
	 * @generated
	 */
	HideContributor createHideContributor();

	/**
	 * Returns a new object of class '<em>Child Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Contributor</em>'.
	 * @generated
	 */
	ChildContributor createChildContributor();

	/**
	 * Returns a new object of class '<em>Live Child Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Child Contributor</em>'.
	 * @generated
	 */
	LiveChildContributor createLiveChildContributor();

	/**
	 * Returns a new object of class '<em>Live Replace Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Replace Contributor</em>'.
	 * @generated
	 */
	LiveReplaceContributor createLiveReplaceContributor();

	/**
	 * Returns a new object of class '<em>Replace Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace Contributor</em>'.
	 * @generated
	 */
	ReplaceContributor createReplaceContributor();

	/**
	 * Returns a new object of class '<em>Live Component Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Component Contributor</em>'.
	 * @generated
	 */
	LiveComponentContributor createLiveComponentContributor();

	/**
	 * Returns a new object of class '<em>Live Hide Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Hide Contributor</em>'.
	 * @generated
	 */
	LiveHideContributor createLiveHideContributor();

	/**
	 * Returns a new object of class '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catalog</em>'.
	 * @generated
	 */
	ComposeCatalog createComposeCatalog();

	/**
	 * Returns a new object of class '<em>Slave</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slave</em>'.
	 * @generated
	 */
	Slave createSlave();

	/**
	 * Returns a new object of class '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target</em>'.
	 * @generated
	 */
	Target createTarget();

	/**
	 * Returns a new object of class '<em>Placeholder Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placeholder Collection</em>'.
	 * @generated
	 */
	PlaceholderCollection createPlaceholderCollection();

	/**
	 * Returns a new object of class '<em>Slave Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slave Collection</em>'.
	 * @generated
	 */
	SlaveCollection createSlaveCollection();

	/**
	 * Returns a new object of class '<em>Live Placeholder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Placeholder</em>'.
	 * @generated
	 */
	LivePlaceholder createLivePlaceholder();

	/**
	 * Returns a new object of class '<em>Live Slave</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Slave</em>'.
	 * @generated
	 */
	LiveSlave createLiveSlave();

	/**
	 * Returns a new object of class '<em>Live Contributor Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Contributor Collection</em>'.
	 * @generated
	 */
	LiveContributorCollection createLiveContributorCollection();

	/**
	 * Returns a new object of class '<em>Contributor Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contributor Collection</em>'.
	 * @generated
	 */
	ContributorCollection createContributorCollection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComposePackage getComposePackage();

} //ComposeFactory
