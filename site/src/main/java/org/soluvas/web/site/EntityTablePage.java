/**
 */
package org.soluvas.web.site;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Table Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Lists normal entities in a page using Backbone and jQuery DataTables.
 * 
 * For raw entities see RawEntity TablePage.
 * 
 * Supported folders:
 * 1. Published (virtual; published only)
 * 2. All Items (virtual; except deleted)
 * 3. Drafts (virtual)
 * 4. Trash (virtual)
 * 
 * Actions on entities:
 * 1. add
 * 2. show
 * 3. delete
 * 4. undelete
 * 5. publish (draft->published)
 * 6. unpublish (published->draft; some entities may not support this)
 * 
 * Features:
 * * client-side paging support
 * * client-side quick search
 * * client-side table column sorting
 * 
 * TODO: support push for dynamic add/remove and show status.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.web.site.SitePackage#getEntityTablePage()
 * @model
 * @generated
 */
public interface EntityTablePage extends Page {
} // EntityTablePage
