/**
 */
package org.soluvas.web.site;

import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.MongoSysConfig;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Starter Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Typical SysConfig for "Starter" style apps.
 * This is a temporary quick workaround before rethinking SysConfig mechanism,
 * which should be JSON-based (not requiring Eclipse/EMF), and supports app-, env-, hotel-, tenant-, person- and entity- levels of SysConfigs.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.web.site.SitePackage#getStarterSysConfig()
 * @model
 * @generated
 */
public interface StarterSysConfig extends GeneralSysConfig, GoogleSysConfig, GoogleAnalyticsSysConfig, MongoSysConfig {
} // StarterSysConfig
