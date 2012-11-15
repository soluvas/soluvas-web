/**
 */
package org.soluvas.web.site.compose;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.ComponentContributor#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.ComponentContributor#getFactoryBean <em>Factory Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getComponentContributor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ComponentContributor extends Contributor {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The factory will be instantiated to create the component will be named {className}Factory in the same package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getComponentContributor_ClassName()
	 * @model default=""
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.ComponentContributor#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Factory Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory Bean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory Bean</em>' attribute.
	 * @see #setFactoryBean(String)
	 * @see org.soluvas.web.site.compose.ComposePackage#getComponentContributor_FactoryBean()
	 * @model
	 * @generated
	 */
	String getFactoryBean();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.ComponentContributor#getFactoryBean <em>Factory Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory Bean</em>' attribute.
	 * @see #getFactoryBean()
	 * @generated
	 */
	void setFactoryBean(String value);

} // ComponentContributor
