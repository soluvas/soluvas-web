/**
 */
package org.soluvas.web.site;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Page Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Applies the contents of the specified "source" Page to current web request.
 * 
 * The Page instance must be linked via EMF, which is sometimes handy but not very flexible for runtime purposes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.SourcePageDeclaration#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getSourcePageDeclaration()
 * @model
 * @generated
 */
public interface SourcePageDeclaration extends PageDeclaration {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PageMeta)
	 * @see org.soluvas.web.site.SitePackage#getSourcePageDeclaration_Source()
	 * @model
	 * @generated
	 */
	PageMeta getSource();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.SourcePageDeclaration#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PageMeta value);

} // SourcePageDeclaration
