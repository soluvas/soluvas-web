/**
 */
package org.soluvas.web.olark;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.olark.OlarkPackage
 * @generated
 */
public interface OlarkFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OlarkFactory eINSTANCE = org.soluvas.web.olark.impl.OlarkFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Live Chat Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Chat Manager</em>'.
	 * @generated
	 */
	LiveChatManager createLiveChatManager();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OlarkPackage getOlarkPackage();

} //OlarkFactory
