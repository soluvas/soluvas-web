/**
 */
package org.soluvas.web.site;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The site catalog is used to define all *logical* sections and pages in a site.
 * 
 * It is used in 2 ways:
 * 1. at generation time, to generate concrete page classes, Wicket HTML markup, and JS files.
 * 2. at runtime, to inspect *logical* sections and pages in the site.
 * 
 * Note that information about actual concrete page classes etc. are not visible here, and if needed, then it should be described using another schema.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.web.site.SitePackage#getSiteCatalog()
 * @model
 * @generated
 */
public interface SiteCatalog extends SectionCollection, PageMetaCollection, PageRuleCollection {
} // SiteCatalog
