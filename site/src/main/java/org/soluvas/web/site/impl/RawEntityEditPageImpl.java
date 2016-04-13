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

import org.soluvas.web.site.EntityPage;
import org.soluvas.web.site.PageParam;
import org.soluvas.web.site.RawEntityEditPage;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw Entity Edit Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.RawEntityEditPageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.RawEntityEditPageImpl#getMountPoint <em>Mount Point</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.RawEntityEditPageImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.RawEntityEditPageImpl#getSection <em>Section</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.RawEntityEditPageImpl#getEntityClass <em>Entity Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RawEntityEditPageImpl extends EObjectImpl implements RawEntityEditPage {
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
	 * The default value of the '{@link #getEntityClass() <em>Entity Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityClass()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITY_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntityClass() <em>Entity Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityClass()
	 * @generated
	 * @ordered
	 */
	protected String entityClass = ENTITY_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawEntityEditPageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.RAW_ENTITY_EDIT_PAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RAW_ENTITY_EDIT_PAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RAW_ENTITY_EDIT_PAGE__MOUNT_POINT, oldMountPoint, mountPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageParam> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<PageParam>(PageParam.class, this, SitePackage.RAW_ENTITY_EDIT_PAGE__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getSection() {
		if (eContainerFeatureID() != SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION) return null;
		return (Section)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSection(Section newSection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSection, SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(Section newSection) {
		if (newSection != eInternalContainer() || (eContainerFeatureID() != SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION && newSection != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION, newSection, newSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntityClass() {
		return entityClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntityClass(String newEntityClass) {
		String oldEntityClass = entityClass;
		entityClass = newEntityClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS, oldEntityClass, entityClass));
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__NAME:
				return getName();
			case SitePackage.RAW_ENTITY_EDIT_PAGE__MOUNT_POINT:
				return getMountPoint();
			case SitePackage.RAW_ENTITY_EDIT_PAGE__PARAMS:
				return getParams();
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
				return getSection();
			case SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS:
				return getEntityClass();
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__NAME:
				setName((String)newValue);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__MOUNT_POINT:
				setMountPoint((String)newValue);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends PageParam>)newValue);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
				setSection((Section)newValue);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS:
				setEntityClass((String)newValue);
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__MOUNT_POINT:
				setMountPoint(MOUNT_POINT_EDEFAULT);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__PARAMS:
				getParams().clear();
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
				setSection((Section)null);
				return;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS:
				setEntityClass(ENTITY_CLASS_EDEFAULT);
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
			case SitePackage.RAW_ENTITY_EDIT_PAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SitePackage.RAW_ENTITY_EDIT_PAGE__MOUNT_POINT:
				return MOUNT_POINT_EDEFAULT == null ? mountPoint != null : !MOUNT_POINT_EDEFAULT.equals(mountPoint);
			case SitePackage.RAW_ENTITY_EDIT_PAGE__PARAMS:
				return params != null && !params.isEmpty();
			case SitePackage.RAW_ENTITY_EDIT_PAGE__SECTION:
				return getSection() != null;
			case SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS:
				return ENTITY_CLASS_EDEFAULT == null ? entityClass != null : !ENTITY_CLASS_EDEFAULT.equals(entityClass);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EntityPage.class) {
			switch (derivedFeatureID) {
				case SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS: return SitePackage.ENTITY_PAGE__ENTITY_CLASS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EntityPage.class) {
			switch (baseFeatureID) {
				case SitePackage.ENTITY_PAGE__ENTITY_CLASS: return SitePackage.RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", entityClass: ");
		result.append(entityClass);
		result.append(')');
		return result.toString();
	}

} //RawEntityEditPageImpl
