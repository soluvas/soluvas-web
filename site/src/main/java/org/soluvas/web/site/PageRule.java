/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.PageRule#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.soluvas.web.site.PageRule#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.soluvas.web.site.PageRule#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getPageRule()
 * @model
 * @generated
 */
public interface PageRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selector</em>' containment reference.
	 * @see #setSelector(PageSelector)
	 * @see org.soluvas.web.site.SitePackage#getPageRule_Selector()
	 * @model containment="true"
	 * @generated
	 */
	PageSelector getSelector();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PageRule#getSelector <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' containment reference.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(PageSelector value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(Integer)
	 * @see org.soluvas.web.site.SitePackage#getPageRule_Weight()
	 * @model
	 * @generated
	 */
	Integer getWeight();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PageRule#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(Integer value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * What to apply when the selector matches.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference.
	 * @see #setDeclaration(PageDeclaration)
	 * @see org.soluvas.web.site.SitePackage#getPageRule_Declaration()
	 * @model containment="true"
	 * @generated
	 */
	PageDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PageRule#getDeclaration <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' containment reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(PageDeclaration value);

} // PageRule
