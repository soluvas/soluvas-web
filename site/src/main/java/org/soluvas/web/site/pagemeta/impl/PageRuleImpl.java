/**
 */
package org.soluvas.web.site.pagemeta.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.pagemeta.PageDeclaration;
import org.soluvas.web.site.pagemeta.PagemetaPackage;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageRuleImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageRuleImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageRuleImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageRuleImpl extends EObjectImpl implements PageRule {
	/**
	 * The cached value of the '{@link #getSelector() <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelector()
	 * @generated
	 * @ordered
	 */
	protected PageSelector selector;

	/**
	 * The default value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected static final Integer POSITIONER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected Integer positioner = POSITIONER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected PageDeclaration declaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PagemetaPackage.Literals.PAGE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageSelector getSelector() {
		return selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelector(PageSelector newSelector, NotificationChain msgs) {
		PageSelector oldSelector = selector;
		selector = newSelector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_RULE__SELECTOR, oldSelector, newSelector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelector(PageSelector newSelector) {
		if (newSelector != selector) {
			NotificationChain msgs = null;
			if (selector != null)
				msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_RULE__SELECTOR, null, msgs);
			if (newSelector != null)
				msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_RULE__SELECTOR, null, msgs);
			msgs = basicSetSelector(newSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_RULE__SELECTOR, newSelector, newSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPositioner() {
		return positioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositioner(Integer newPositioner) {
		Integer oldPositioner = positioner;
		positioner = newPositioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_RULE__POSITIONER, oldPositioner, positioner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageDeclaration getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(PageDeclaration newDeclaration, NotificationChain msgs) {
		PageDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_RULE__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(PageDeclaration newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_RULE__DECLARATION, null, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PagemetaPackage.PAGE_RULE__DECLARATION, null, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_RULE__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PagemetaPackage.PAGE_RULE__SELECTOR:
				return basicSetSelector(null, msgs);
			case PagemetaPackage.PAGE_RULE__DECLARATION:
				return basicSetDeclaration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PagemetaPackage.PAGE_RULE__SELECTOR:
				return getSelector();
			case PagemetaPackage.PAGE_RULE__POSITIONER:
				return getPositioner();
			case PagemetaPackage.PAGE_RULE__DECLARATION:
				return getDeclaration();
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
			case PagemetaPackage.PAGE_RULE__SELECTOR:
				setSelector((PageSelector)newValue);
				return;
			case PagemetaPackage.PAGE_RULE__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case PagemetaPackage.PAGE_RULE__DECLARATION:
				setDeclaration((PageDeclaration)newValue);
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
			case PagemetaPackage.PAGE_RULE__SELECTOR:
				setSelector((PageSelector)null);
				return;
			case PagemetaPackage.PAGE_RULE__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_RULE__DECLARATION:
				setDeclaration((PageDeclaration)null);
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
			case PagemetaPackage.PAGE_RULE__SELECTOR:
				return selector != null;
			case PagemetaPackage.PAGE_RULE__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case PagemetaPackage.PAGE_RULE__DECLARATION:
				return declaration != null;
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
		result.append(" (positioner: ");
		result.append(positioner);
		result.append(')');
		return result.toString();
	}

} //PageRuleImpl
