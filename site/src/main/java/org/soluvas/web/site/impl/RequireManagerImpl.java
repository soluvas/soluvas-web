/**
 */
package org.soluvas.web.site.impl;

import javax.annotation.Nonnull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.RequireManager;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Require Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.RequireManagerImpl#getJavaScriptMode <em>Java Script Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
public class RequireManagerImpl extends EObjectImpl implements RequireManager {
	/**
	 * The default value of the '{@link #getJavaScriptMode() <em>Java Script Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaScriptMode()
	 * @generated
	 * @ordered
	 */
	protected static final JavaScriptMode JAVA_SCRIPT_MODE_EDEFAULT = JavaScriptMode.DEVELOPMENT;

	/**
	 * The cached value of the '{@link #getJavaScriptMode() <em>Java Script Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaScriptMode()
	 * @generated
	 * @ordered
	 */
	protected JavaScriptMode javaScriptMode = JAVA_SCRIPT_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public RequireManagerImpl() {
		throw new UnsupportedOperationException("Please use constructor with arguments.");
	}
	
	public RequireManagerImpl(@Nonnull final JavaScriptMode javaScriptMode) {
		super();
		this.javaScriptMode = javaScriptMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.REQUIRE_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaScriptMode getJavaScriptMode() {
		return javaScriptMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.REQUIRE_MANAGER__JAVA_SCRIPT_MODE:
				return getJavaScriptMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SitePackage.REQUIRE_MANAGER__JAVA_SCRIPT_MODE:
				return javaScriptMode != JAVA_SCRIPT_MODE_EDEFAULT;
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
		result.append(" (javaScriptMode: ");
		result.append(javaScriptMode);
		result.append(')');
		return result.toString();
	}

} //RequireManagerImpl
