/**
 */
package org.soluvas.web.site.impl;

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
 *   <li>{@link org.soluvas.web.site.impl.RequireManagerImpl#getCacheBust <em>Cache Bust</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequireManagerImpl extends EObjectImpl implements RequireManager {
	
	public static final String CURRENT_TIME = "__CURRENT_TIME__";
	
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
	 * The default value of the '{@link #getCacheBust() <em>Cache Bust</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheBust()
	 * @generated
	 * @ordered
	 */
	protected static final String CACHE_BUST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCacheBust() <em>Cache Bust</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheBust()
	 * @generated
	 * @ordered
	 */
	protected String cacheBust = CACHE_BUST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public RequireManagerImpl() {
		throw new UnsupportedOperationException("Please use constructor with arguments.");
	}
	
	/**
	 * @param javaScriptMode
	 * @param cacheBust Use {@link #CURRENT_TIME} for dynamic {@code cacheBust}.
	 */
	public RequireManagerImpl(final JavaScriptMode javaScriptMode,
			final String cacheBust) {
		super();
		this.javaScriptMode = javaScriptMode;
		this.cacheBust = CURRENT_TIME.equals(cacheBust) ? String.valueOf(System.currentTimeMillis()) : cacheBust;
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
	public String getCacheBust() {
		return cacheBust;
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
			case SitePackage.REQUIRE_MANAGER__CACHE_BUST:
				return getCacheBust();
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
			case SitePackage.REQUIRE_MANAGER__CACHE_BUST:
				return CACHE_BUST_EDEFAULT == null ? cacheBust != null : !CACHE_BUST_EDEFAULT.equals(cacheBust);
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
		result.append(", cacheBust: ");
		result.append(cacheBust);
		result.append(')');
		return result.toString();
	}

} //RequireManagerImpl
