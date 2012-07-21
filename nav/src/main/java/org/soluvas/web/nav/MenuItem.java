/**
 */
package org.soluvas.web.nav;

import org.osgi.framework.Bundle;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.nav.MenuItem#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.web.nav.MenuItem#getParentId <em>Parent Id</em>}</li>
 *   <li>{@link org.soluvas.web.nav.MenuItem#getLabel <em>Label</em>}</li>
 *   <li>{@link org.soluvas.web.nav.MenuItem#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.soluvas.web.nav.MenuItem#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.nav.MenuItem#getIconName <em>Icon Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.nav.NavPackage#getMenuItem()
 * @model
 * @generated
 */
public interface MenuItem extends MenuItemContainer {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.soluvas.web.nav.NavPackage#getMenuItem_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.MenuItem#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Parent Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set, will attach to other Menu.
	 * If not set, will attach to the parent (container).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent Id</em>' attribute.
	 * @see #isSetParentId()
	 * @see #unsetParentId()
	 * @see #setParentId(String)
	 * @see org.soluvas.web.nav.NavPackage#getMenuItem_ParentId()
	 * @model unsettable="true"
	 * @generated
	 */
	String getParentId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.MenuItem#getParentId <em>Parent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Id</em>' attribute.
	 * @see #isSetParentId()
	 * @see #unsetParentId()
	 * @see #getParentId()
	 * @generated
	 */
	void setParentId(String value);

	/**
	 * Unsets the value of the '{@link org.soluvas.web.nav.MenuItem#getParentId <em>Parent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParentId()
	 * @see #getParentId()
	 * @see #setParentId(String)
	 * @generated
	 */
	void unsetParentId();

	/**
	 * Returns whether the value of the '{@link org.soluvas.web.nav.MenuItem#getParentId <em>Parent Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parent Id</em>' attribute is set.
	 * @see #unsetParentId()
	 * @see #getParentId()
	 * @see #setParentId(String)
	 * @generated
	 */
	boolean isSetParentId();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.soluvas.web.nav.NavPackage#getMenuItem_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.MenuItem#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see org.soluvas.web.nav.NavPackage#getMenuItem_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.MenuItem#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(Bundle)
	 * @see org.soluvas.web.nav.NavPackage#getMenuItem_Bundle()
	 * @model dataType="org.soluvas.web.nav.Bundle"
	 */
	@JsonIgnore
	Bundle getBundle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.MenuItem#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 */
	@JsonIgnore
	void setBundle(Bundle value);

	/**
	 * Returns the value of the '<em><b>Icon Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Name</em>' attribute.
	 * @see #setIconName(String)
	 * @see org.soluvas.web.nav.NavPackage#getMenuItem_IconName()
	 * @model
	 * @generated
	 */
	String getIconName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.nav.MenuItem#getIconName <em>Icon Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Name</em>' attribute.
	 * @see #getIconName()
	 * @generated
	 */
	void setIconName(String value);

} // MenuItem
