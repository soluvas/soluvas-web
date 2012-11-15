/**
 */
package org.soluvas.web.site.compose;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Live Child Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.LiveChildContributor#getPlaceholder <em>Placeholder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.compose.ComposePackage#getLiveChildContributor()
 * @model
 * @generated
 */
public interface LiveChildContributor extends ChildContributor, LiveComponentContributor {
	/**
	 * Returns the value of the '<em><b>Placeholder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placeholder</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placeholder</em>' reference.
	 * @see #setPlaceholder(LivePlaceholder)
	 * @see org.soluvas.web.site.compose.ComposePackage#getLiveChildContributor_Placeholder()
	 * @model
	 * @generated
	 */
	LivePlaceholder getPlaceholder();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.compose.LiveChildContributor#getPlaceholder <em>Placeholder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placeholder</em>' reference.
	 * @see #getPlaceholder()
	 * @generated
	 */
	void setPlaceholder(LivePlaceholder value);

} // LiveChildContributor
