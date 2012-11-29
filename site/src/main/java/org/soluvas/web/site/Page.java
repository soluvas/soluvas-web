/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.Page#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getMountPoint <em>Mount Point</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getParams <em>Params</em>}</li>
 *   <li>{@link org.soluvas.web.site.Page#getSection <em>Section</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getPage()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Page extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The resulting simple name of the Wicket Page subclass, e.g. "ProductSysTable", without the "Page" suffix.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.soluvas.web.site.SitePackage#getPage_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Where the page is mounted, relative to application root, e.g. /product/sys, or a URI template with parameters: /product/sys/show/${productId}
	 * 
	 * mountPoint is highly recommended for SEO and easy URI typing, but not mandatory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mount Point</em>' attribute.
	 * @see #setMountPoint(String)
	 * @see org.soluvas.web.site.SitePackage#getPage_MountPoint()
	 * @model
	 * @generated
	 */
	String getMountPoint();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getMountPoint <em>Mount Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mount Point</em>' attribute.
	 * @see #getMountPoint()
	 * @generated
	 */
	void setMountPoint(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.web.site.PageParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.soluvas.web.site.SitePackage#getPage_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageParam> getParams();

	/**
	 * Returns the value of the '<em><b>Section</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.soluvas.web.site.Section#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section</em>' container reference.
	 * @see #setSection(Section)
	 * @see org.soluvas.web.site.SitePackage#getPage_Section()
	 * @see org.soluvas.web.site.Section#getPages
	 * @model opposite="pages" transient="false"
	 * @generated
	 */
	Section getSection();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.Page#getSection <em>Section</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section</em>' container reference.
	 * @see #getSection()
	 * @generated
	 */
	void setSection(Section value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the class simple name, which is simply the name + "Page" suffix.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getClassSimpleName();

} // Page
