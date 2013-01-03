/**
 */
package org.soluvas.web.site.compose.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ResourceType;
import org.soluvas.web.site.compose.ComposePackage;
import org.soluvas.web.site.compose.Target;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getPageClassName <em>Page Class Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.compose.impl.TargetImpl#getModelClassName <em>Model Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetImpl extends EObjectImpl implements Target {
	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.BUNDLE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelClassName() <em>Model Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelClassName() <em>Model Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelClassName()
	 * @generated
	 * @ordered
	 */
	protected String modelClassName = MODEL_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComposePackage.Literals.TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__BUNDLE, oldBundle, bundle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__PAGE_CLASS_NAME, oldPageClassName, pageClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelClassName() {
		return modelClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelClassName(String newModelClassName) {
		String oldModelClassName = modelClassName;
		modelClassName = newModelClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComposePackage.TARGET__MODEL_CLASS_NAME, oldModelClassName, modelClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComposePackage.TARGET__RESOURCE_TYPE:
				return getResourceType();
			case ComposePackage.TARGET__RESOURCE_URI:
				return getResourceUri();
			case ComposePackage.TARGET__RESOURCE_NAME:
				return getResourceName();
			case ComposePackage.TARGET__BUNDLE:
				return getBundle();
			case ComposePackage.TARGET__PAGE_CLASS_NAME:
				return getPageClassName();
			case ComposePackage.TARGET__PATH:
				return getPath();
			case ComposePackage.TARGET__MODEL_CLASS_NAME:
				return getModelClassName();
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
			case ComposePackage.TARGET__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case ComposePackage.TARGET__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case ComposePackage.TARGET__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case ComposePackage.TARGET__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case ComposePackage.TARGET__PAGE_CLASS_NAME:
				setPageClassName((String)newValue);
				return;
			case ComposePackage.TARGET__PATH:
				setPath((String)newValue);
				return;
			case ComposePackage.TARGET__MODEL_CLASS_NAME:
				setModelClassName((String)newValue);
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
			case ComposePackage.TARGET__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case ComposePackage.TARGET__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case ComposePackage.TARGET__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case ComposePackage.TARGET__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case ComposePackage.TARGET__PAGE_CLASS_NAME:
				setPageClassName(PAGE_CLASS_NAME_EDEFAULT);
				return;
			case ComposePackage.TARGET__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ComposePackage.TARGET__MODEL_CLASS_NAME:
				setModelClassName(MODEL_CLASS_NAME_EDEFAULT);
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
			case ComposePackage.TARGET__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case ComposePackage.TARGET__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case ComposePackage.TARGET__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case ComposePackage.TARGET__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case ComposePackage.TARGET__PAGE_CLASS_NAME:
				return PAGE_CLASS_NAME_EDEFAULT == null ? pageClassName != null : !PAGE_CLASS_NAME_EDEFAULT.equals(pageClassName);
			case ComposePackage.TARGET__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ComposePackage.TARGET__MODEL_CLASS_NAME:
				return MODEL_CLASS_NAME_EDEFAULT == null ? modelClassName != null : !MODEL_CLASS_NAME_EDEFAULT.equals(modelClassName);
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
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case ComposePackage.TARGET__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
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
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return ComposePackage.TARGET__BUNDLE;
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
		result.append(" (resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", pageClassName: ");
		result.append(pageClassName);
		result.append(", path: ");
		result.append(path);
		result.append(", modelClassName: ");
		result.append(modelClassName);
		result.append(')');
		return result.toString();
	}

} //TargetImpl
