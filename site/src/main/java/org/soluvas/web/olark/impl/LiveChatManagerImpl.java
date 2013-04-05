/**
 */
package org.soluvas.web.olark.impl;

import javax.inject.Inject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.web.olark.LiveChatManager;
import org.soluvas.web.olark.LiveChatProvider;
import org.soluvas.web.olark.OlarkPackage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.olark.impl.LiveChatManagerImpl#getSiteId <em>Site Id</em>}</li>
 *   <li>{@link org.soluvas.web.olark.impl.LiveChatManagerImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.olark.impl.LiveChatManagerImpl#getProvider <em>Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@Service("olarkMgr") @Lazy
public class LiveChatManagerImpl extends EObjectImpl implements LiveChatManager {
	/**
	 * The default value of the '{@link #getSiteId() <em>Site Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSiteId()
	 * @generated
	 * @ordered
	 */
	protected static final String SITE_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSiteId() <em>Site Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSiteId()
	 * @generated
	 * @ordered
	 */
	protected String siteId = SITE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final LiveChatProvider PROVIDER_EDEFAULT = LiveChatProvider.OLARK;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected LiveChatProvider provider = PROVIDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected LiveChatManagerImpl() {
		throw new UnsupportedOperationException("Please use constructor with arguments");
	}
	
	@Inject
	public LiveChatManagerImpl(
			@Value("#{soluvasProps.liveChatSiteId}") String siteId,
			@Value("#{soluvasProps.liveChatEnabled}") boolean enabled,
			@Value("#{soluvasProps.liveChatProvider}") LiveChatProvider provider) {
		super();
		this.siteId = siteId;
		this.enabled = enabled;
		this.provider = provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OlarkPackage.Literals.LIVE_CHAT_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSiteId() {
		return siteId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiveChatProvider getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvider(LiveChatProvider newProvider) {
		LiveChatProvider oldProvider = provider;
		provider = newProvider == null ? PROVIDER_EDEFAULT : newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OlarkPackage.LIVE_CHAT_MANAGER__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OlarkPackage.LIVE_CHAT_MANAGER__SITE_ID:
				return getSiteId();
			case OlarkPackage.LIVE_CHAT_MANAGER__ENABLED:
				return isEnabled();
			case OlarkPackage.LIVE_CHAT_MANAGER__PROVIDER:
				return getProvider();
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
			case OlarkPackage.LIVE_CHAT_MANAGER__PROVIDER:
				setProvider((LiveChatProvider)newValue);
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
			case OlarkPackage.LIVE_CHAT_MANAGER__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
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
			case OlarkPackage.LIVE_CHAT_MANAGER__SITE_ID:
				return SITE_ID_EDEFAULT == null ? siteId != null : !SITE_ID_EDEFAULT.equals(siteId);
			case OlarkPackage.LIVE_CHAT_MANAGER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case OlarkPackage.LIVE_CHAT_MANAGER__PROVIDER:
				return provider != PROVIDER_EDEFAULT;
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
		result.append(" (siteId: ");
		result.append(siteId);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", provider: ");
		result.append(provider);
		result.append(')');
		return result.toString();
	}

} //OlarkManagerImpl
