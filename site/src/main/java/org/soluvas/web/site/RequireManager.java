/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.RequireManager#getJavaScriptMode <em>Java Script Mode</em>}</li>
 *   <li>{@link org.soluvas.web.site.RequireManager#getCacheBust <em>Cache Bust</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getRequireManager()
 * @model
 * @generated
 */
public interface RequireManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Java Script Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.web.site.JavaScriptMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Script Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Script Mode</em>' attribute.
	 * @see org.soluvas.web.site.JavaScriptMode
	 * @see org.soluvas.web.site.SitePackage#getRequireManager_JavaScriptMode()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	JavaScriptMode getJavaScriptMode();

	/**
	 * Returns the value of the '<em><b>Cache Bust</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A string used to bust CDN cache, e.g. "2013-02-16 18:43:22+07:00".
	 * 
	 * This will be appended as a query string to "relative" js, skin, and img URIs. Relative here in reference to webAddres URIs. Absolute URIs won't be cache-busted.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cache Bust</em>' attribute.
	 * @see org.soluvas.web.site.SitePackage#getRequireManager_CacheBust()
	 * @model changeable="false"
	 * @generated
	 */
	String getCacheBust();

} // RequireManager
