/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Rule Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.PageRuleCollection#getPageRules <em>Page Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getPageRuleCollection()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PageRuleCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Page Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.PageRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Rules</em>' containment reference list.
	 * @see org.soluvas.web.site.SitePackage#getPageRuleCollection_PageRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageRule> getPageRules();

} // PageRuleCollection
