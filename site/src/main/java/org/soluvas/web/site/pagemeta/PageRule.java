/**
 */
package org.soluvas.web.site.pagemeta;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageRule#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageRule#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageRule#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageRule()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface PageRule extends SerializableEObject {
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
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageRule_Selector()
	 * @model containment="true"
	 * @generated
	 */
	PageSelector getSelector();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageRule#getSelector <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' containment reference.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(PageSelector value);

	/**
	 * Returns the value of the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Guide:
	 * 
	 * * -200 : org.soluvas core
	 * * -100 : coarse-grained
	 * * -50 : module-level fine-grained (e.g. bippo salesorder)
	 * * -10 : product-level fine-grained (e.g. bippo )
	 * * 0 or missing : application-level fine-grained (e.g. berbatik)
	 * * 10 : customizations
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Positioner</em>' attribute.
	 * @see #setPositioner(Integer)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageRule_Positioner()
	 * @model
	 * @generated
	 */
	Integer getPositioner();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageRule#getPositioner <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positioner</em>' attribute.
	 * @see #getPositioner()
	 * @generated
	 */
	void setPositioner(Integer value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * What to apply when the selector matches.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference.
	 * @see #setDeclaration(PageDeclaration)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageRule_Declaration()
	 * @model containment="true"
	 * @generated
	 */
	PageDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageRule#getDeclaration <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' containment reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(PageDeclaration value);

} // PageRule
