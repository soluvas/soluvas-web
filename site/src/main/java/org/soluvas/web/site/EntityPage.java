/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.EntityPage#getEntityClass <em>Entity Class</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getEntityPage()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EntityPage extends EObject {
	/**
	 * Returns the value of the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Full name of the class that represents the entity.
	 * 
	 * This is required for:
	 * 1. Getting the EntityRepository for the entity, scoped to the active tenant
	 * 2. Getting the EntityDescriptor which provides metadata about the entity, scoped to the active tenant
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entity Class</em>' attribute.
	 * @see #setEntityClass(String)
	 * @see org.soluvas.web.site.SitePackage#getEntityPage_EntityClass()
	 * @model required="true"
	 * @generated
	 */
	String getEntityClass();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.EntityPage#getEntityClass <em>Entity Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity Class</em>' attribute.
	 * @see #getEntityClass()
	 * @generated
	 */
	void setEntityClass(String value);

} // EntityPage
