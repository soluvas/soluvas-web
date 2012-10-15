/**
 */
package org.soluvas.web.site;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Page Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Loads the file from the specified bundle and the specified resource path.
 * 
 * This is handy to load from classpath in OSGi environments, but cannot handle overrides properly. You need a proper federating repository for that.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.ResourcePageDeclaration#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.site.ResourcePageDeclaration#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getResourcePageDeclaration()
 * @model
 * @generated
 */
public interface ResourcePageDeclaration extends PageDeclaration {
	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bundle symbolic name that hosts the Page XMI file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(String)
	 * @see org.soluvas.web.site.SitePackage#getResourcePageDeclaration_Bundle()
	 * @model
	 * @generated
	 */
	String getBundle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ResourcePageDeclaration#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Full path to the Page XMI in the bundle, including the leading '/' and the '.xmi' extension.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.soluvas.web.site.SitePackage#getResourcePageDeclaration_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ResourcePageDeclaration#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // ResourcePageDeclaration
