/**
 */
package org.soluvas.web.site.pagemeta;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor Page Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Uses a PageProcessor implementation to modify the Page for current web request.
 * 
 * It will be looked up in OSGi (scoped for the current tenant) using the given filters.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.ProcessorPageDeclaration#getFilter <em>Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getProcessorPageDeclaration()
 * @model
 * @generated
 */
public interface ProcessorPageDeclaration extends PageDeclaration {
	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Filter in LDAP syntax.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see #setFilter(String)
	 * @see org.soluvas.web.site.pagemeta.PageMetaPackage#getProcessorPageDeclaration_Filter()
	 * @model
	 * @generated
	 */
	String getFilter();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.ProcessorPageDeclaration#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

} // ProcessorPageDeclaration
