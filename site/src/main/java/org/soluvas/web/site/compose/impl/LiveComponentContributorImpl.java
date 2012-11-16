/**
 */
package org.soluvas.web.site.compose.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.osgi.framework.Bundle;
import org.soluvas.web.site.ComponentFactory;
import org.soluvas.web.site.compose.ComponentContributor;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.ContributorState;
import org.soluvas.web.site.compose.CreationMode;
import org.soluvas.web.site.compose.LiveComponentContributor;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.LiveSlave;
import org.soluvas.web.site.compose.LiveTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Live Component Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getPageClassName <em>Page Class Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getTargetPath <em>Target Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getState <em>State</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getFactoryBean <em>Factory Bean</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveComponentContributorImpl#getCreationMode <em>Creation Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiveComponentContributorImpl extends EObjectImpl implements LiveComponentContributor {
	
	/**
	 * The default value of the '{@link #getPageClassName() <em>Page Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageClassName() <em>Page Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageClassName()
	 * @generated
	 * @ordered
	 */
	protected String pageClassName = PAGE_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetPath() <em>Target Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPath()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetPath() <em>Target Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPath()
	 * @generated
	 * @ordered
	 */
	protected String targetPath = TARGET_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ContributorState STATE_EDEFAULT = ContributorState.UNRESOLVED;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ContributorState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = "";

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
	 * The default value of the '{@link #getFactoryBean() <em>Factory Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryBean()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_BEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactoryBean() <em>Factory Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryBean()
	 * @generated
	 * @ordered
	 */
	protected String factoryBean = FACTORY_BEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationMode() <em>Creation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationMode()
	 * @generated
	 * @ordered
	 */
	protected static final CreationMode CREATION_MODE_EDEFAULT = CreationMode.CONSTRUCTOR;

	/**
	 * The cached value of the '{@link #getCreationMode() <em>Creation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationMode()
	 * @generated
	 * @ordered
	 */
	protected CreationMode creationMode = CREATION_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveComponentContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.LIVE_COMPONENT_CONTRIBUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPageClassName() {
		return pageClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPageClassName(String newPageClassName) {
		String oldPageClassName = pageClassName;
		pageClassName = newPageClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME, oldPageClassName, pageClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTargetPath() {
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetPath(String newTargetPath) {
		String oldTargetPath = targetPath;
		targetPath = newTargetPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__TARGET_PATH, oldTargetPath, targetPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContributorState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(ContributorState newState) {
		ContributorState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__BUNDLE, oldBundle, bundle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFactoryBean() {
		return factoryBean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactoryBean(String newFactoryBean) {
		String oldFactoryBean = factoryBean;
		factoryBean = newFactoryBean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN, oldFactoryBean, factoryBean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreationMode getCreationMode() {
		return creationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationMode(CreationMode newCreationMode) {
		CreationMode oldCreationMode = creationMode;
		creationMode = newCreationMode == null ? CREATION_MODE_EDEFAULT : newCreationMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE, oldCreationMode, creationMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentFactory getFactory() {
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
	public void resolve(Collection<LivePlaceholder> placeholders, Collection<LiveSlave> slaves) {
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
	public void bundleAdded(Bundle bundle) {
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
	public void targetRemoved(LiveTarget target) {
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
	public LiveContributor createLive(Bundle bundle) {
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
	public void bundleRemoved(Bundle bundle) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME:
				return getPageClassName();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__TARGET_PATH:
				return getTargetPath();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__STATE:
				return getState();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__BUNDLE:
				return getBundle();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME:
				return getClassName();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN:
				return getFactoryBean();
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE:
				return getCreationMode();
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
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME:
				setPageClassName((String)newValue);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__TARGET_PATH:
				setTargetPath((String)newValue);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__STATE:
				setState((ContributorState)newValue);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN:
				setFactoryBean((String)newValue);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE:
				setCreationMode((CreationMode)newValue);
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
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME:
				setPageClassName(PAGE_CLASS_NAME_EDEFAULT);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__TARGET_PATH:
				setTargetPath(TARGET_PATH_EDEFAULT);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__STATE:
				setState(STATE_EDEFAULT);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN:
				setFactoryBean(FACTORY_BEAN_EDEFAULT);
				return;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE:
				setCreationMode(CREATION_MODE_EDEFAULT);
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
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__PAGE_CLASS_NAME:
				return PAGE_CLASS_NAME_EDEFAULT == null ? pageClassName != null : !PAGE_CLASS_NAME_EDEFAULT.equals(pageClassName);
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__TARGET_PATH:
				return TARGET_PATH_EDEFAULT == null ? targetPath != null : !TARGET_PATH_EDEFAULT.equals(targetPath);
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__STATE:
				return state != STATE_EDEFAULT;
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN:
				return FACTORY_BEAN_EDEFAULT == null ? factoryBean != null : !FACTORY_BEAN_EDEFAULT.equals(factoryBean);
			case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE:
				return creationMode != CREATION_MODE_EDEFAULT;
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
		if (baseClass == ComponentContributor.class) {
			switch (derivedFeatureID) {
				case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME: return ComposePackage.COMPONENT_CONTRIBUTOR__CLASS_NAME;
				case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN: return ComposePackage.COMPONENT_CONTRIBUTOR__FACTORY_BEAN;
				case ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE: return ComposePackage.COMPONENT_CONTRIBUTOR__CREATION_MODE;
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
		if (baseClass == ComponentContributor.class) {
			switch (baseFeatureID) {
				case ComposePackage.COMPONENT_CONTRIBUTOR__CLASS_NAME: return ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CLASS_NAME;
				case ComposePackage.COMPONENT_CONTRIBUTOR__FACTORY_BEAN: return ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__FACTORY_BEAN;
				case ComposePackage.COMPONENT_CONTRIBUTOR__CREATION_MODE: return ComposePackage.LIVE_COMPONENT_CONTRIBUTOR__CREATION_MODE;
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
		result.append(" (pageClassName: ");
		result.append(pageClassName);
		result.append(", targetPath: ");
		result.append(targetPath);
		result.append(", state: ");
		result.append(state);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", className: ");
		result.append(className);
		result.append(", factoryBean: ");
		result.append(factoryBean);
		result.append(", creationMode: ");
		result.append(creationMode);
		result.append(')');
		return result.toString();
	}

} //LiveComponentContributorImpl
