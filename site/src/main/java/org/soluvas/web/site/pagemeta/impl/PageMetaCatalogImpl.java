/**
 */
package org.soluvas.web.site.pagemeta.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaCatalog;
import org.soluvas.web.site.pagemeta.PagemetaPackage;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl#getPageMetas <em>Page Metas</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl#getResourceName <em>Resource Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageMetaCatalogImpl extends EObjectImpl implements PageMetaCatalog {
	/**
	 * The cached value of the '{@link #getPageMetas() <em>Page Metas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageMetas()
	 * @generated
	 * @ordered
	 */
	protected EList<PageMeta> pageMetas;
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<PageRule> rules;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMetaCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PagemetaPackage.Literals.PAGE_META_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageMeta> getPageMetas() {
		if (pageMetas == null) {
			pageMetas = new EObjectContainmentEList<PageMeta>(PageMeta.class, this, PagemetaPackage.PAGE_META_CATALOG__PAGE_METAS);
		}
		return pageMetas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<PageRule>(PageRule.class, this, PagemetaPackage.PAGE_META_CATALOG__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META_CATALOG__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PagemetaPackage.PAGE_META_CATALOG__PAGE_METAS:
				return ((InternalEList<?>)getPageMetas()).basicRemove(otherEnd, msgs);
			case PagemetaPackage.PAGE_META_CATALOG__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case PagemetaPackage.PAGE_META_CATALOG__PAGE_METAS:
				return getPageMetas();
			case PagemetaPackage.PAGE_META_CATALOG__RULES:
				return getRules();
			case PagemetaPackage.PAGE_META_CATALOG__BUNDLE:
				return getBundle();
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE:
				return getResourceType();
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI:
				return getResourceUri();
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME:
				return getResourceName();
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
			case PagemetaPackage.PAGE_META_CATALOG__PAGE_METAS:
				getPageMetas().clear();
				getPageMetas().addAll((Collection<? extends PageMeta>)newValue);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends PageRule>)newValue);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME:
				setResourceName((String)newValue);
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
			case PagemetaPackage.PAGE_META_CATALOG__PAGE_METAS:
				getPageMetas().clear();
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RULES:
				getRules().clear();
				return;
			case PagemetaPackage.PAGE_META_CATALOG__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
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
			case PagemetaPackage.PAGE_META_CATALOG__PAGE_METAS:
				return pageMetas != null && !pageMetas.isEmpty();
			case PagemetaPackage.PAGE_META_CATALOG__RULES:
				return rules != null && !rules.isEmpty();
			case PagemetaPackage.PAGE_META_CATALOG__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
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
		if (baseClass == PageRuleCollection.class) {
			switch (derivedFeatureID) {
				case PagemetaPackage.PAGE_META_CATALOG__RULES: return PagemetaPackage.PAGE_RULE_COLLECTION__RULES;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case PagemetaPackage.PAGE_META_CATALOG__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
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
		if (baseClass == PageRuleCollection.class) {
			switch (baseFeatureID) {
				case PagemetaPackage.PAGE_RULE_COLLECTION__RULES: return PagemetaPackage.PAGE_META_CATALOG__RULES;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return PagemetaPackage.PAGE_META_CATALOG__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return PagemetaPackage.PAGE_META_CATALOG__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return PagemetaPackage.PAGE_META_CATALOG__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return PagemetaPackage.PAGE_META_CATALOG__RESOURCE_NAME;
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
		result.append(" (bundle: ");
		result.append(bundle);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(')');
		return result.toString();
	}

} //PageMetaCatalogImpl
