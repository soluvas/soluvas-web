/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Title</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Used to compose a title string.
 * 
 * This will set the :
 * - page meta title : prefixes.join(prefixSeparator) + main + suffixes.join(suffixSeparator)
 * - open graph meta : title <= main (TODO: needs to be more configurable), e.g. we want to display "Zalova Bag - Bags" or "Zalova Bag - O Batiks" or even "Zalova Bag - Bags - O Batiks"
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.PageTitle#getMain <em>Main</em>}</li>
 *   <li>{@link org.soluvas.web.site.PageTitle#getPrefixes <em>Prefixes</em>}</li>
 *   <li>{@link org.soluvas.web.site.PageTitle#getSuffixes <em>Suffixes</em>}</li>
 *   <li>{@link org.soluvas.web.site.PageTitle#getPrefixSeparator <em>Prefix Separator</em>}</li>
 *   <li>{@link org.soluvas.web.site.PageTitle#getSuffixSeparator <em>Suffix Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getPageTitle()
 * @model
 * @generated
 */
public interface PageTitle extends EObject {
	/**
	 * Returns the value of the '<em><b>Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main</em>' attribute.
	 * @see #setMain(String)
	 * @see org.soluvas.web.site.SitePackage#getPageTitle_Main()
	 * @model
	 * @generated
	 */
	String getMain();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PageTitle#getMain <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' attribute.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(String value);

	/**
	 * Returns the value of the '<em><b>Prefixes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefixes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefixes</em>' attribute list.
	 * @see org.soluvas.web.site.SitePackage#getPageTitle_Prefixes()
	 * @model
	 * @generated
	 */
	EList<String> getPrefixes();

	/**
	 * Returns the value of the '<em><b>Suffixes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffixes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffixes</em>' attribute list.
	 * @see org.soluvas.web.site.SitePackage#getPageTitle_Suffixes()
	 * @model
	 * @generated
	 */
	EList<String> getSuffixes();

	/**
	 * Returns the value of the '<em><b>Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix Separator</em>' attribute.
	 * @see #setPrefixSeparator(String)
	 * @see org.soluvas.web.site.SitePackage#getPageTitle_PrefixSeparator()
	 * @model
	 * @generated
	 */
	String getPrefixSeparator();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PageTitle#getPrefixSeparator <em>Prefix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix Separator</em>' attribute.
	 * @see #getPrefixSeparator()
	 * @generated
	 */
	void setPrefixSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Suffix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix Separator</em>' attribute.
	 * @see #setSuffixSeparator(String)
	 * @see org.soluvas.web.site.SitePackage#getPageTitle_SuffixSeparator()
	 * @model
	 * @generated
	 */
	String getSuffixSeparator();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.PageTitle#getSuffixSeparator <em>Suffix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix Separator</em>' attribute.
	 * @see #getSuffixSeparator()
	 * @generated
	 */
	void setSuffixSeparator(String value);

} // PageTitle
