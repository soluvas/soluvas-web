/**
 */
package org.soluvas.web.site.pagemeta.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.soluvas.web.site.pagemeta.PageMetaPackage;
import org.soluvas.web.site.pagemeta.PageTitle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Title</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl#getMain <em>Main</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl#getPrefixes <em>Prefixes</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl#getSuffixes <em>Suffixes</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl#getPrefixSeparator <em>Prefix Separator</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl#getSuffixSeparator <em>Suffix Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageTitleImpl extends EObjectImpl implements PageTitle {
	/**
	 * The default value of the '{@link #getMain() <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected static final String MAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMain() <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected String main = MAIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrefixes() <em>Prefixes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefixes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> prefixes;

	/**
	 * The cached value of the '{@link #getSuffixes() <em>Suffixes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffixes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> suffixes;

	/**
	 * The default value of the '{@link #getPrefixSeparator() <em>Prefix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefixSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrefixSeparator() <em>Prefix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefixSeparator()
	 * @generated
	 * @ordered
	 */
	protected String prefixSeparator = PREFIX_SEPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuffixSeparator() <em>Suffix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffixSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String SUFFIX_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuffixSeparator() <em>Suffix Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffixSeparator()
	 * @generated
	 * @ordered
	 */
	protected String suffixSeparator = SUFFIX_SEPARATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageTitleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PageMetaPackage.Literals.PAGE_TITLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMain() {
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMain(String newMain) {
		String oldMain = main;
		main = newMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_TITLE__MAIN, oldMain, main));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPrefixes() {
		if (prefixes == null) {
			prefixes = new EDataTypeUniqueEList<String>(String.class, this, PageMetaPackage.PAGE_TITLE__PREFIXES);
		}
		return prefixes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSuffixes() {
		if (suffixes == null) {
			suffixes = new EDataTypeUniqueEList<String>(String.class, this, PageMetaPackage.PAGE_TITLE__SUFFIXES);
		}
		return suffixes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefixSeparator() {
		return prefixSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefixSeparator(String newPrefixSeparator) {
		String oldPrefixSeparator = prefixSeparator;
		prefixSeparator = newPrefixSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_TITLE__PREFIX_SEPARATOR, oldPrefixSeparator, prefixSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuffixSeparator() {
		return suffixSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuffixSeparator(String newSuffixSeparator) {
		String oldSuffixSeparator = suffixSeparator;
		suffixSeparator = newSuffixSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PageMetaPackage.PAGE_TITLE__SUFFIX_SEPARATOR, oldSuffixSeparator, suffixSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PageMetaPackage.PAGE_TITLE__MAIN:
				return getMain();
			case PageMetaPackage.PAGE_TITLE__PREFIXES:
				return getPrefixes();
			case PageMetaPackage.PAGE_TITLE__SUFFIXES:
				return getSuffixes();
			case PageMetaPackage.PAGE_TITLE__PREFIX_SEPARATOR:
				return getPrefixSeparator();
			case PageMetaPackage.PAGE_TITLE__SUFFIX_SEPARATOR:
				return getSuffixSeparator();
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
			case PageMetaPackage.PAGE_TITLE__MAIN:
				setMain((String)newValue);
				return;
			case PageMetaPackage.PAGE_TITLE__PREFIXES:
				getPrefixes().clear();
				getPrefixes().addAll((Collection<? extends String>)newValue);
				return;
			case PageMetaPackage.PAGE_TITLE__SUFFIXES:
				getSuffixes().clear();
				getSuffixes().addAll((Collection<? extends String>)newValue);
				return;
			case PageMetaPackage.PAGE_TITLE__PREFIX_SEPARATOR:
				setPrefixSeparator((String)newValue);
				return;
			case PageMetaPackage.PAGE_TITLE__SUFFIX_SEPARATOR:
				setSuffixSeparator((String)newValue);
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
			case PageMetaPackage.PAGE_TITLE__MAIN:
				setMain(MAIN_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_TITLE__PREFIXES:
				getPrefixes().clear();
				return;
			case PageMetaPackage.PAGE_TITLE__SUFFIXES:
				getSuffixes().clear();
				return;
			case PageMetaPackage.PAGE_TITLE__PREFIX_SEPARATOR:
				setPrefixSeparator(PREFIX_SEPARATOR_EDEFAULT);
				return;
			case PageMetaPackage.PAGE_TITLE__SUFFIX_SEPARATOR:
				setSuffixSeparator(SUFFIX_SEPARATOR_EDEFAULT);
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
			case PageMetaPackage.PAGE_TITLE__MAIN:
				return MAIN_EDEFAULT == null ? main != null : !MAIN_EDEFAULT.equals(main);
			case PageMetaPackage.PAGE_TITLE__PREFIXES:
				return prefixes != null && !prefixes.isEmpty();
			case PageMetaPackage.PAGE_TITLE__SUFFIXES:
				return suffixes != null && !suffixes.isEmpty();
			case PageMetaPackage.PAGE_TITLE__PREFIX_SEPARATOR:
				return PREFIX_SEPARATOR_EDEFAULT == null ? prefixSeparator != null : !PREFIX_SEPARATOR_EDEFAULT.equals(prefixSeparator);
			case PageMetaPackage.PAGE_TITLE__SUFFIX_SEPARATOR:
				return SUFFIX_SEPARATOR_EDEFAULT == null ? suffixSeparator != null : !SUFFIX_SEPARATOR_EDEFAULT.equals(suffixSeparator);
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
		result.append(" (main: ");
		result.append(main);
		result.append(", prefixes: ");
		result.append(prefixes);
		result.append(", suffixes: ");
		result.append(suffixes);
		result.append(", prefixSeparator: ");
		result.append(prefixSeparator);
		result.append(", suffixSeparator: ");
		result.append(suffixSeparator);
		result.append(')');
		return result.toString();
	}

} //PageTitleImpl
