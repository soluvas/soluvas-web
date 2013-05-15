/**
 */
package org.soluvas.web.site.pagemeta;

import org.soluvas.commons.SerializableEObject;
import org.soluvas.web.site.PageRequestContext;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Matches a web request against a rule and modifies the current Page object.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageSelector()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface PageSelector extends SerializableEObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines if this selector matches the provided page.
	 * <!-- end-model-doc -->
	 * @model contextDataType="org.soluvas.web.site.pagemeta.PageRuleContext"
	 * @generated
	 */
	boolean matches(PageRequestContext context);
} // PageSelector
