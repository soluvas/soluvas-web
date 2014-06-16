/**
 */
package org.soluvas.web.site.compose.impl;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.blueprint.container.BlueprintContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.ComponentFactory;
import org.soluvas.web.site.SiteException;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.ContributorState;
import org.soluvas.web.site.compose.LiveComponentContributor;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.LiveReplaceContributor;
import org.soluvas.web.site.compose.LiveSlave;
import org.soluvas.web.site.compose.LiveTarget;

import com.google.common.base.Preconditions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Live Replace Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl#getState <em>State</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl#getLiveBundle <em>Live Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.LiveReplaceContributorImpl#getSlave <em>Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiveReplaceContributorImpl extends ReplaceContributorImpl implements LiveReplaceContributor {
	
	private static Logger log = LoggerFactory
			.getLogger(LiveReplaceContributorImpl.class);
	
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
	 * The default value of the '{@link #getLiveBundle() <em>Live Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiveBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle LIVE_BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLiveBundle() <em>Live Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiveBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle liveBundle = LIVE_BUNDLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSlave() <em>Slave</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlave()
	 * @generated
	 * @ordered
	 */
	protected LiveSlave slave;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveReplaceContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.LIVE_REPLACE_CONTRIBUTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle getLiveBundle() {
		return liveBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiveBundle(Bundle newLiveBundle) {
		Bundle oldLiveBundle = liveBundle;
		liveBundle = newLiveBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE, oldLiveBundle, liveBundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public ComponentFactory getFactory() {
		final String resourceContainer = bundle != null ? bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]"
				: getResourceUri();
		switch (getCreationMode()) {
		case CONSTRUCTOR:
			Preconditions.checkNotNull(getClassName(), "className for contributor %s/%s from %s must not be null",
					getPageClassName(), getTargetPath(), resourceContainer);
			try {
				final Class<?> componentClass = bundle != null ? bundle.loadClass(getClassName()) :
					LiveChildContributorImpl.class.getClassLoader().loadClass(getClassName());
				final Constructor<?> constructor = componentClass.getConstructor(String.class, IModel.class);
				return new ComponentFactory<Component, Serializable>() {
					@Override
					public Component create(String id,
							IModel<Serializable> model) {
						try {
							log.trace("Creating {} using {} for contributor {}/{} from {}", getClassName(), constructor,
									getPageClassName(), getTargetPath(), resourceContainer);
							return (Component) constructor.newInstance(id, model);
						} catch (Exception e) {
							throw new SiteException("Cannot create component " + getClassName() + " using " + constructor + " for contributor " +
									getPageClassName() + "/" + getTargetPath() + " from " + resourceContainer, e);
						}
					}
				};
			} catch (Exception e) {
				throw new SiteException("Cannot create component " + getClassName() + " for contributor " +
						getPageClassName() + "/" + getTargetPath() + " from " + resourceContainer, e);
			}
		case FACTORY_CLASS:
			Preconditions.checkNotNull(getClassName(), "className for contributor %s/%s from %s must not be null",
					getPageClassName(), getTargetPath(), resourceContainer);
			final String factoryClassName = getClassName() + "Factory";
			try {
				log.trace("Creating {} as factory for contributor {}/{} from {}", factoryClassName,
						getPageClassName(), getTargetPath(), resourceContainer);
				final Class<?> factoryClass = bundle != null ? bundle.loadClass(factoryClassName) :
					LiveChildContributorImpl.class.getClassLoader().loadClass(factoryClassName);
				return (ComponentFactory) factoryClass.newInstance();
			} catch (Exception e) {
				throw new SiteException("Cannot create " + factoryClassName + " as a factory for contributor " +
						getPageClassName() + "/" + getTargetPath() + " from " + resourceContainer, e);
			}
		case FACTORY_BEAN:
			try {
				log.debug("Getting bean {} as factory for contributor {}/{} from {}", factoryBean,
						getPageClassName(), getTargetPath(), resourceContainer);
				final BundleContext bundleContext = bundle.getBundleContext();
				final String filter = "(osgi.blueprint.container.symbolicname=" + bundle.getSymbolicName() + ")";
				final Collection<ServiceReference<BlueprintContainer>> refs = bundleContext.getServiceReferences(BlueprintContainer.class,
						filter);
				if (refs.isEmpty()) {
					throw new SiteException("Cannot find service " + BlueprintContainer.class.getName() + " with filter " + filter);
				}
				final ServiceReference<BlueprintContainer> bpRef = refs.iterator().next();
				final BlueprintContainer bp = bundleContext.getService(bpRef);
				try {
					return (ComponentFactory) bp.getComponentInstance(factoryBean);
				} finally {
					bundleContext.ungetService(bpRef);
				}
			} catch (Exception e) {
				throw new SiteException("Cannot get bean " + factoryBean + " as a factory for contributor " +
						getPageClassName() + "/" + getTargetPath() + " from " + resourceContainer, e);
			}
		default:
			throw new SiteException("Unknown CreationMode " + getCreationMode());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiveSlave getSlave() {
		if (slave != null && slave.eIsProxy()) {
			InternalEObject oldSlave = (InternalEObject)slave;
			slave = (LiveSlave)eResolveProxy(oldSlave);
			if (slave != oldSlave) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE, oldSlave, slave));
			}
		}
		return slave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveSlave basicGetSlave() {
		return slave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlave(LiveSlave newSlave) {
		LiveSlave oldSlave = slave;
		slave = newSlave;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE, oldSlave, slave));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public synchronized void resolve(Collection<LivePlaceholder> placeholders, Collection<LiveSlave> slaves) {
		if (state == ContributorState.UNRESOLVED) {
			for (LiveSlave slave : slaves) {
				if (slave.getPageClassName().equals(getPageClassName())) {
					setSlave(slave);
					setState(ContributorState.RESOLVED);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public synchronized void targetRemoved(LiveTarget target) {
		if (state == ContributorState.RESOLVED) {
			if (target == getSlave()) {
				setState(ContributorState.UNRESOLVED);
				setSlave(null);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				return getState();
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE:
				return getLiveBundle();
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				if (resolve) return getSlave();
				return basicGetSlave();
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
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				setState((ContributorState)newValue);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE:
				setLiveBundle((Bundle)newValue);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				setSlave((LiveSlave)newValue);
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
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				setState(STATE_EDEFAULT);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE:
				setLiveBundle(LIVE_BUNDLE_EDEFAULT);
				return;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				setSlave((LiveSlave)null);
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
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE:
				return state != STATE_EDEFAULT;
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE:
				return LIVE_BUNDLE_EDEFAULT == null ? liveBundle != null : !LIVE_BUNDLE_EDEFAULT.equals(liveBundle);
			case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__SLAVE:
				return slave != null;
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
		if (baseClass == LiveContributor.class) {
			switch (derivedFeatureID) {
				case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE: return ComposePackage.LIVE_CONTRIBUTOR__STATE;
				case ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE: return ComposePackage.LIVE_CONTRIBUTOR__LIVE_BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == LiveComponentContributor.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == LiveContributor.class) {
			switch (baseFeatureID) {
				case ComposePackage.LIVE_CONTRIBUTOR__STATE: return ComposePackage.LIVE_REPLACE_CONTRIBUTOR__STATE;
				case ComposePackage.LIVE_CONTRIBUTOR__LIVE_BUNDLE: return ComposePackage.LIVE_REPLACE_CONTRIBUTOR__LIVE_BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == LiveComponentContributor.class) {
			switch (baseFeatureID) {
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
		result.append(" (state: ");
		result.append(state);
		result.append(", liveBundle: ");
		result.append(liveBundle);
		result.append(')');
		return result.toString();
	}

} //LiveReplaceContributorImpl
