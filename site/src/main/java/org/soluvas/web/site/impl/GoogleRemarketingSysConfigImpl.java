/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.web.site.GoogleRemarketingSysConfig;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Google Remarketing Sys Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.impl.GoogleRemarketingSysConfigImpl#isGoogleRemarketingEnabled <em>Google Remarketing Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.impl.GoogleRemarketingSysConfigImpl#getGoogleRemarketingTagId <em>Google Remarketing Tag Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoogleRemarketingSysConfigImpl extends EObjectImpl implements GoogleRemarketingSysConfig {
	/**
	 * The default value of the '{@link #isGoogleRemarketingEnabled() <em>Google Remarketing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGoogleRemarketingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GOOGLE_REMARKETING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGoogleRemarketingEnabled() <em>Google Remarketing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGoogleRemarketingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean googleRemarketingEnabled = GOOGLE_REMARKETING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleRemarketingTagId() <em>Google Remarketing Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleRemarketingTagId()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_REMARKETING_TAG_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleRemarketingTagId() <em>Google Remarketing Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleRemarketingTagId()
	 * @generated
	 * @ordered
	 */
	protected String googleRemarketingTagId = GOOGLE_REMARKETING_TAG_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleRemarketingSysConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.GOOGLE_REMARKETING_SYS_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGoogleRemarketingEnabled() {
		return googleRemarketingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleRemarketingEnabled(boolean newGoogleRemarketingEnabled) {
		boolean oldGoogleRemarketingEnabled = googleRemarketingEnabled;
		googleRemarketingEnabled = newGoogleRemarketingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_ENABLED, oldGoogleRemarketingEnabled, googleRemarketingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoogleRemarketingTagId() {
		return googleRemarketingTagId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoogleRemarketingTagId(String newGoogleRemarketingTagId) {
		String oldGoogleRemarketingTagId = googleRemarketingTagId;
		googleRemarketingTagId = newGoogleRemarketingTagId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_TAG_ID, oldGoogleRemarketingTagId, googleRemarketingTagId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_ENABLED:
				return isGoogleRemarketingEnabled();
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_TAG_ID:
				return getGoogleRemarketingTagId();
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
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_ENABLED:
				setGoogleRemarketingEnabled((Boolean)newValue);
				return;
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_TAG_ID:
				setGoogleRemarketingTagId((String)newValue);
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
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_ENABLED:
				setGoogleRemarketingEnabled(GOOGLE_REMARKETING_ENABLED_EDEFAULT);
				return;
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_TAG_ID:
				setGoogleRemarketingTagId(GOOGLE_REMARKETING_TAG_ID_EDEFAULT);
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
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_ENABLED:
				return googleRemarketingEnabled != GOOGLE_REMARKETING_ENABLED_EDEFAULT;
			case SitePackage.GOOGLE_REMARKETING_SYS_CONFIG__GOOGLE_REMARKETING_TAG_ID:
				return GOOGLE_REMARKETING_TAG_ID_EDEFAULT == null ? googleRemarketingTagId != null : !GOOGLE_REMARKETING_TAG_ID_EDEFAULT.equals(googleRemarketingTagId);
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
		result.append(" (googleRemarketingEnabled: ");
		result.append(googleRemarketingEnabled);
		result.append(", googleRemarketingTagId: ");
		result.append(googleRemarketingTagId);
		result.append(')');
		return result.toString();
	}

} //GoogleRemarketingSysConfigImpl
