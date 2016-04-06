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

import org.soluvas.web.site.PageParam;
import org.soluvas.web.site.ResetPasswordPage;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reset Password Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.ResetPasswordPageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.ResetPasswordPageImpl#getMountPoint <em>Mount Point</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.ResetPasswordPageImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.ResetPasswordPageImpl#getSection <em>Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResetPasswordPageImpl extends EObjectImpl implements ResetPasswordPage {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetPasswordPageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.RESET_PASSWORD_PAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RESET_PASSWORD_PAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RESET_PASSWORD_PAGE__MOUNT_POINT, oldMountPoint, mountPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageParam> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<PageParam>(PageParam.class, this, SitePackage.RESET_PASSWORD_PAGE__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getSection() {
		if (eContainerFeatureID() != SitePackage.RESET_PASSWORD_PAGE__SECTION) return null;
		return (Section)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSection(Section newSection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSection, SitePackage.RESET_PASSWORD_PAGE__SECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(Section newSection) {
		if (newSection != eInternalContainer() || (eContainerFeatureID() != SitePackage.RESET_PASSWORD_PAGE__SECTION && newSection != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RESET_PASSWORD_PAGE__SECTION, newSection, newSection));
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
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
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
			case SitePackage.RESET_PASSWORD_PAGE__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
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
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
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
			case SitePackage.RESET_PASSWORD_PAGE__NAME:
				return getName();
			case SitePackage.RESET_PASSWORD_PAGE__MOUNT_POINT:
				return getMountPoint();
			case SitePackage.RESET_PASSWORD_PAGE__PARAMS:
				return getParams();
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
				return getSection();
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
			case SitePackage.RESET_PASSWORD_PAGE__NAME:
				setName((String)newValue);
				return;
			case SitePackage.RESET_PASSWORD_PAGE__MOUNT_POINT:
				setMountPoint((String)newValue);
				return;
			case SitePackage.RESET_PASSWORD_PAGE__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends PageParam>)newValue);
				return;
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
				setSection((Section)newValue);
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
			case SitePackage.RESET_PASSWORD_PAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SitePackage.RESET_PASSWORD_PAGE__MOUNT_POINT:
				setMountPoint(MOUNT_POINT_EDEFAULT);
				return;
			case SitePackage.RESET_PASSWORD_PAGE__PARAMS:
				getParams().clear();
				return;
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
				setSection((Section)null);
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
			case SitePackage.RESET_PASSWORD_PAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SitePackage.RESET_PASSWORD_PAGE__MOUNT_POINT:
				return MOUNT_POINT_EDEFAULT == null ? mountPoint != null : !MOUNT_POINT_EDEFAULT.equals(mountPoint);
			case SitePackage.RESET_PASSWORD_PAGE__PARAMS:
				return params != null && !params.isEmpty();
			case SitePackage.RESET_PASSWORD_PAGE__SECTION:
				return getSection() != null;
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

} //ResetPasswordPageImpl
