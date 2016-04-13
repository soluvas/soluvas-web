/**
 */
package org.soluvas.web.site;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Login Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Login page, that also serves as a SSO register page for Facebook, Twitter, Google, etc.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.LoginPage#getRegisterPage <em>Register Page</em>}</li>
 *   <li>{@link org.soluvas.web.site.LoginPage#getResetPasswordPage <em>Reset Password Page</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getLoginPage()
 * @model
 * @generated
 */
public interface LoginPage extends Page {
	/**
	 * Returns the value of the '<em><b>Register Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Register Page</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Register Page</em>' reference.
	 * @see #setRegisterPage(RegisterPage)
	 * @see org.soluvas.web.site.SitePackage#getLoginPage_RegisterPage()
	 * @model
	 * @generated
	 */
	RegisterPage getRegisterPage();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.LoginPage#getRegisterPage <em>Register Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Register Page</em>' reference.
	 * @see #getRegisterPage()
	 * @generated
	 */
	void setRegisterPage(RegisterPage value);

	/**
	 * Returns the value of the '<em><b>Reset Password Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset Password Page</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Password Page</em>' reference.
	 * @see #setResetPasswordPage(ResetPasswordPage)
	 * @see org.soluvas.web.site.SitePackage#getLoginPage_ResetPasswordPage()
	 * @model
	 * @generated
	 */
	ResetPasswordPage getResetPasswordPage();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.LoginPage#getResetPasswordPage <em>Reset Password Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Password Page</em>' reference.
	 * @see #getResetPasswordPage()
	 * @generated
	 */
	void setResetPasswordPage(ResetPasswordPage value);

} // LoginPage
