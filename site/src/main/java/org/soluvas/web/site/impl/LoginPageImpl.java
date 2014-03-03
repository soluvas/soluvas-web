/**
 */
package org.soluvas.web.site.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.web.site.LoginPage;
import org.soluvas.web.site.PageParam;
import org.soluvas.web.site.RegisterPage;
import org.soluvas.web.site.ResetPasswordPage;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Login Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.LoginPageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.LoginPageImpl#getMountPoint <em>Mount Point</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.LoginPageImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.LoginPageImpl#getSection <em>Section</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.LoginPageImpl#getRegisterPage <em>Register Page</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.LoginPageImpl#getResetPasswordPage <em>Reset Password Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoginPageImpl extends EObjectImpl implements LoginPage {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMountPoint() <em>Mount Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String MOUNT_POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMountPoint() <em>Mount Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMountPoint()
	 * @generated
	 * @ordered
	 */
	protected String mountPoint=MOUNT_POINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<PageParam> params;

	/**
	 * The cached value of the '{@link #getRegisterPage() <em>Register Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisterPage()
	 * @generated
	 * @ordered
	 */
	protected RegisterPage registerPage;

	/**
	 * The cached value of the '{@link #getResetPasswordPage() <em>Reset Password Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResetPasswordPage()
	 * @generated
	 * @ordered
	 */
	protected ResetPasswordPage resetPasswordPage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoginPageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.LOGIN_PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.LOGIN_PAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMountPoint() {
		return mountPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMountPoint(String newMountPoint) {
		String oldMountPoint = mountPoint;
		mountPoint = newMountPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.LOGIN_PAGE__MOUNT_POINT, oldMountPoint, mountPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageParam> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<PageParam>(PageParam.class, this, SitePackage.LOGIN_PAGE__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getSection() {
		if (eContainerFeatureID() != SitePackage.LOGIN_PAGE__SECTION) return null;
		return (Section)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSection(Section newSection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSection, SitePackage.LOGIN_PAGE__SECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(Section newSection) {
		if (newSection != eInternalContainer() || (eContainerFeatureID() != SitePackage.LOGIN_PAGE__SECTION && newSection != null)) {
			if (EcoreUtil.isAncestor(this, newSection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSection != null)
				msgs = ((InternalEObject)newSection).eInverseAdd(this, SitePackage.SECTION__PAGES, Section.class, msgs);
			msgs = basicSetSection(newSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.LOGIN_PAGE__SECTION, newSection, newSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisterPage getRegisterPage() {
		if (registerPage != null && registerPage.eIsProxy()) {
			InternalEObject oldRegisterPage = (InternalEObject)registerPage;
			registerPage = (RegisterPage)eResolveProxy(oldRegisterPage);
			if (registerPage != oldRegisterPage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SitePackage.LOGIN_PAGE__REGISTER_PAGE, oldRegisterPage, registerPage));
			}
		}
		return registerPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisterPage basicGetRegisterPage() {
		return registerPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegisterPage(RegisterPage newRegisterPage) {
		RegisterPage oldRegisterPage = registerPage;
		registerPage = newRegisterPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.LOGIN_PAGE__REGISTER_PAGE, oldRegisterPage, registerPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetPasswordPage getResetPasswordPage() {
		if (resetPasswordPage != null && resetPasswordPage.eIsProxy()) {
			InternalEObject oldResetPasswordPage = (InternalEObject)resetPasswordPage;
			resetPasswordPage = (ResetPasswordPage)eResolveProxy(oldResetPasswordPage);
			if (resetPasswordPage != oldResetPasswordPage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SitePackage.LOGIN_PAGE__RESET_PASSWORD_PAGE, oldResetPasswordPage, resetPasswordPage));
			}
		}
		return resetPasswordPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetPasswordPage basicGetResetPasswordPage() {
		return resetPasswordPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetPasswordPage(ResetPasswordPage newResetPasswordPage) {
		ResetPasswordPage oldResetPasswordPage = resetPasswordPage;
		resetPasswordPage = newResetPasswordPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.LOGIN_PAGE__RESET_PASSWORD_PAGE, oldResetPasswordPage, resetPasswordPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassSimpleName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SitePackage.LOGIN_PAGE__SECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSection((Section)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SitePackage.LOGIN_PAGE__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
			case SitePackage.LOGIN_PAGE__SECTION:
				return basicSetSection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SitePackage.LOGIN_PAGE__SECTION:
				return eInternalContainer().eInverseRemove(this, SitePackage.SECTION__PAGES, Section.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.LOGIN_PAGE__NAME:
				return getName();
			case SitePackage.LOGIN_PAGE__MOUNT_POINT:
				return getMountPoint();
			case SitePackage.LOGIN_PAGE__PARAMS:
				return getParams();
			case SitePackage.LOGIN_PAGE__SECTION:
				return getSection();
			case SitePackage.LOGIN_PAGE__REGISTER_PAGE:
				if (resolve) return getRegisterPage();
				return basicGetRegisterPage();
			case SitePackage.LOGIN_PAGE__RESET_PASSWORD_PAGE:
				if (resolve) return getResetPasswordPage();
				return basicGetResetPasswordPage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SitePackage.LOGIN_PAGE__NAME:
				setName((String)newValue);
				return;
			case SitePackage.LOGIN_PAGE__MOUNT_POINT:
				setMountPoint((String)newValue);
				return;
			case SitePackage.LOGIN_PAGE__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends PageParam>)newValue);
				return;
			case SitePackage.LOGIN_PAGE__SECTION:
				setSection((Section)newValue);
				return;
			case SitePackage.LOGIN_PAGE__REGISTER_PAGE:
				setRegisterPage((RegisterPage)newValue);
				return;
			case SitePackage.LOGIN_PAGE__RESET_PASSWORD_PAGE:
				setResetPasswordPage((ResetPasswordPage)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SitePackage.LOGIN_PAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SitePackage.LOGIN_PAGE__MOUNT_POINT:
				setMountPoint(MOUNT_POINT_EDEFAULT);
				return;
			case SitePackage.LOGIN_PAGE__PARAMS:
				getParams().clear();
				return;
			case SitePackage.LOGIN_PAGE__SECTION:
				setSection((Section)null);
				return;
			case SitePackage.LOGIN_PAGE__REGISTER_PAGE:
				setRegisterPage((RegisterPage)null);
				return;
			case SitePackage.LOGIN_PAGE__RESET_PASSWORD_PAGE:
				setResetPasswordPage((ResetPasswordPage)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SitePackage.LOGIN_PAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SitePackage.LOGIN_PAGE__MOUNT_POINT:
				return MOUNT_POINT_EDEFAULT == null ? mountPoint != null : !MOUNT_POINT_EDEFAULT.equals(mountPoint);
			case SitePackage.LOGIN_PAGE__PARAMS:
				return params != null && !params.isEmpty();
			case SitePackage.LOGIN_PAGE__SECTION:
				return getSection() != null;
			case SitePackage.LOGIN_PAGE__REGISTER_PAGE:
				return registerPage != null;
			case SitePackage.LOGIN_PAGE__RESET_PASSWORD_PAGE:
				return resetPasswordPage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", mountPoint: ");
		result.append(mountPoint);
		result.append(')');
		return result.toString();
	}

} //LoginPageImpl
