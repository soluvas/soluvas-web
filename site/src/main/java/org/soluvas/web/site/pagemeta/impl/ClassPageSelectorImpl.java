/**
 */
package org.soluvas.web.site.pagemeta.impl;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.wicket.Page;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.PageRequestContext;
import org.soluvas.web.site.pagemeta.ClassPageSelector;
import org.soluvas.web.site.pagemeta.PagemetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Page Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.ClassPageSelectorImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassPageSelectorImpl extends EObjectImpl implements ClassPageSelector {
	
	private static Logger log = LoggerFactory
			.getLogger(ClassPageSelectorImpl.class);
	
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPageSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PagemetaPackage.Literals.CLASS_PAGE_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.CLASS_PAGE_SELECTOR__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public boolean matches(PageRequestContext context) {
		final Class<? extends Page> pageClass = context.getPage().getClass();
		if (getClassName().equals(pageClass.getName())) {
			log.trace("Page {} matches selector {} because className is {}", context, this, getClassName());
			return true;
		}
		final List<Class<?>> superclasses = ClassUtils.getAllSuperclasses(pageClass);
		log.trace("Page {} has {} superclasses: {}", context.getPage(), superclasses.size(), superclasses);
		for (final Class<?> superclass : superclasses) {
			if (getClassName().equals(superclass.getName())) {
				log.trace("Page {} matches selector {} because {} extends superclass {}", context, this,
						pageClass.getName(), getClassName());
				return true;
			}
		}
		final List<Class<?>> interfaces = ClassUtils.getAllInterfaces(pageClass);
		log.trace("Page {} has {} interfaces: {}", context.getPage(), interfaces.size(), interfaces);
		for (final Class<?> iface : interfaces) {
			if (getClassName().equals(iface.getName())) {
				log.trace("Page {} matches selector {} because {} implements interface {}", context, this,
						pageClass.getName(), getClassName());
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PagemetaPackage.CLASS_PAGE_SELECTOR__CLASS_NAME:
				return getClassName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PagemetaPackage.CLASS_PAGE_SELECTOR__CLASS_NAME:
				setClassName((String)newValue);
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
			case PagemetaPackage.CLASS_PAGE_SELECTOR__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
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
			case PagemetaPackage.CLASS_PAGE_SELECTOR__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
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
		result.append(" (className: ");
		result.append(className);
		result.append(')');
		return result.toString();
	}

} //ClassPageSelectorImpl
