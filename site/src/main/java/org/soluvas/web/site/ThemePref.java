/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Theme Pref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Theme Preference, usable by App, Tenant, Shop, Person, and possibly Article/Category/Product.
 * 
 * <p>Should be extended, e.g. {@link id.co.bippo.common.BippoThemePref} contains bippo-specific theme preferences in additional to Soluvas Web's.
 * 
 * <p><b>Notes:</b> These may be disabled for a tenant by FeatureSet, which has veto power.
 * A ThemePref feature usually requires data from AppManifest/Mall/SysConfig, so without the data, the theme won't be able to show it anyway.
 * Not all Themes support all ThemePref features.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.ThemePref#getNavbarColor <em>Navbar Color</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#getNavbarTextColor <em>Navbar Text Color</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#getOutlineColor <em>Outline Color</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#getHighlightColor <em>Highlight Color</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#isTwitterLinkVisible <em>Twitter Link Visible</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#isFacebookLinkVisible <em>Facebook Link Visible</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#isYouTubeLinkVisible <em>You Tube Link Visible</em>}</li>
 *   <li>{@link org.soluvas.web.site.ThemePref#isFootnoteVisible <em>Footnote Visible</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getThemePref()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ThemePref extends EObject {
	/**
	 * Returns the value of the '<em><b>Navbar Text Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color that is usually used for the navbar text color (color 2), but depends on theme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Navbar Text Color</em>' attribute.
	 * @see #setNavbarTextColor(String)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_NavbarTextColor()
	 * @model
	 * @generated
	 */
	String getNavbarTextColor();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#getNavbarTextColor <em>Navbar Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navbar Text Color</em>' attribute.
	 * @see #getNavbarTextColor()
	 * @generated
	 */
	void setNavbarTextColor(String value);

	/**
	 * Returns the value of the '<em><b>Outline Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color usually used for link or button outlines (color 3), but it depends on theme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outline Color</em>' attribute.
	 * @see #setOutlineColor(String)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_OutlineColor()
	 * @model
	 * @generated
	 */
	String getOutlineColor();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#getOutlineColor <em>Outline Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outline Color</em>' attribute.
	 * @see #getOutlineColor()
	 * @generated
	 */
	void setOutlineColor(String value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color usually used for the overall page background color (color 4), but it depends on theme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Background Color</em>' attribute.
	 * @see #setBackgroundColor(String)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_BackgroundColor()
	 * @model
	 * @generated
	 */
	String getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#getBackgroundColor <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' attribute.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(String value);

	/**
	 * Returns the value of the '<em><b>Highlight Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color usually used for highlight background color selected/active elements (color 5), but it depends on theme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Highlight Color</em>' attribute.
	 * @see #setHighlightColor(String)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_HighlightColor()
	 * @model
	 * @generated
	 */
	String getHighlightColor();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#getHighlightColor <em>Highlight Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highlight Color</em>' attribute.
	 * @see #getHighlightColor()
	 * @generated
	 */
	void setHighlightColor(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Link Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Link Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Link Visible</em>' attribute.
	 * @see #setTwitterLinkVisible(boolean)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_TwitterLinkVisible()
	 * @model default="true"
	 * @generated
	 */
	boolean isTwitterLinkVisible();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#isTwitterLinkVisible <em>Twitter Link Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Link Visible</em>' attribute.
	 * @see #isTwitterLinkVisible()
	 * @generated
	 */
	void setTwitterLinkVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Facebook Link Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Link Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Link Visible</em>' attribute.
	 * @see #setFacebookLinkVisible(boolean)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_FacebookLinkVisible()
	 * @model default="true"
	 * @generated
	 */
	boolean isFacebookLinkVisible();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#isFacebookLinkVisible <em>Facebook Link Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Link Visible</em>' attribute.
	 * @see #isFacebookLinkVisible()
	 * @generated
	 */
	void setFacebookLinkVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>You Tube Link Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>You Tube Link Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>You Tube Link Visible</em>' attribute.
	 * @see #setYouTubeLinkVisible(boolean)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_YouTubeLinkVisible()
	 * @model default="true"
	 * @generated
	 */
	boolean isYouTubeLinkVisible();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#isYouTubeLinkVisible <em>You Tube Link Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>You Tube Link Visible</em>' attribute.
	 * @see #isYouTubeLinkVisible()
	 * @generated
	 */
	void setYouTubeLinkVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Footnote Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Displays the footnote specified in {@link org.soluvas.commons.AppManifest#getFootnote()}.
	 * The footnote is shown on all frontend pages, usually positioned below the main content, but above the footer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Footnote Visible</em>' attribute.
	 * @see #setFootnoteVisible(boolean)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_FootnoteVisible()
	 * @model default="true"
	 * @generated
	 */
	boolean isFootnoteVisible();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#isFootnoteVisible <em>Footnote Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footnote Visible</em>' attribute.
	 * @see #isFootnoteVisible()
	 * @generated
	 */
	void setFootnoteVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Navbar Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color that is usually used for the navbar background color (color 1), but depends on theme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Navbar Color</em>' attribute.
	 * @see #setNavbarColor(String)
	 * @see org.soluvas.web.site.SitePackage#getThemePref_NavbarColor()
	 * @model
	 * @generated
	 */
	String getNavbarColor();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.ThemePref#getNavbarColor <em>Navbar Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navbar Color</em>' attribute.
	 * @see #getNavbarColor()
	 * @generated
	 */
	void setNavbarColor(String value);

} // ThemePref
