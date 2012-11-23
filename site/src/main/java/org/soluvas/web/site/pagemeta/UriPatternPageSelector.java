/**
 */
package org.soluvas.web.site.pagemeta;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uri Pattern Page Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Matches web requests using http://code.google.com/p/wo-furi/
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.UriPatternPageSelector#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getUriPatternPageSelector()
 * @model
 * @generated
 */
public interface UriPatternPageSelector extends PageSelector {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getUriPatternPageSelector_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.UriPatternPageSelector#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // UriPatternPageSelector
