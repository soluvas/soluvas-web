/**
 */
package org.soluvas.web.site.pagemeta;

import javax.annotation.Nonnull;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Icon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getBrandingBundleName <em>Branding Bundle Name</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getFaviconPath <em>Favicon Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getFaviconUri <em>Favicon Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon57Path <em>Icon57 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon57Uri <em>Icon57 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon72Path <em>Icon72 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon72Uri <em>Icon72 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon114Path <em>Icon114 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon114Uri <em>Icon114 Uri</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon144Path <em>Icon144 Path</em>}</li>
 *   <li>{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon144Uri <em>Icon144 Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface PageIcon extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Branding Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to calculate the absolute URI of icons, relative to Image URI and bundle name.
	 * 
	 * This will be used only if any of *Uri is not set.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Branding Bundle Name</em>' attribute.
	 * @see #setBrandingBundleName(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_BrandingBundleName()
	 * @model
	 * @generated
	 */
	String getBrandingBundleName();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getBrandingBundleName <em>Branding Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branding Bundle Name</em>' attribute.
	 * @see #getBrandingBundleName()
	 * @generated
	 */
	void setBrandingBundleName(String value);

	/**
	 * Returns the value of the '<em><b>Favicon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favicon Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favicon Path</em>' attribute.
	 * @see #setFaviconPath(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_FaviconPath()
	 * @model
	 * @generated
	 */
	String getFaviconPath();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getFaviconPath <em>Favicon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favicon Path</em>' attribute.
	 * @see #getFaviconPath()
	 * @generated
	 */
	void setFaviconPath(String value);

	/**
	 * Returns the value of the '<em><b>Favicon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favicon Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favicon Uri</em>' attribute.
	 * @see #setFaviconUri(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_FaviconUri()
	 * @model
	 * @generated
	 */
	String getFaviconUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getFaviconUri <em>Favicon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favicon Uri</em>' attribute.
	 * @see #getFaviconUri()
	 * @generated
	 */
	void setFaviconUri(String value);

	/**
	 * Returns the value of the '<em><b>Icon57 Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon57 Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon57 Path</em>' attribute.
	 * @see #setIcon57Path(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon57Path()
	 * @model
	 * @generated
	 */
	String getIcon57Path();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon57Path <em>Icon57 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon57 Path</em>' attribute.
	 * @see #getIcon57Path()
	 * @generated
	 */
	void setIcon57Path(String value);

	/**
	 * Returns the value of the '<em><b>Icon57 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon57 Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon57 Uri</em>' attribute.
	 * @see #setIcon57Uri(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon57Uri()
	 * @model
	 * @generated
	 */
	String getIcon57Uri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon57Uri <em>Icon57 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon57 Uri</em>' attribute.
	 * @see #getIcon57Uri()
	 * @generated
	 */
	void setIcon57Uri(String value);

	/**
	 * Returns the value of the '<em><b>Icon72 Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon72 Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon72 Path</em>' attribute.
	 * @see #setIcon72Path(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon72Path()
	 * @model
	 * @generated
	 */
	String getIcon72Path();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon72Path <em>Icon72 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon72 Path</em>' attribute.
	 * @see #getIcon72Path()
	 * @generated
	 */
	void setIcon72Path(String value);

	/**
	 * Returns the value of the '<em><b>Icon72 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon72 Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon72 Uri</em>' attribute.
	 * @see #setIcon72Uri(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon72Uri()
	 * @model
	 * @generated
	 */
	String getIcon72Uri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon72Uri <em>Icon72 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon72 Uri</em>' attribute.
	 * @see #getIcon72Uri()
	 * @generated
	 */
	void setIcon72Uri(String value);

	/**
	 * Returns the value of the '<em><b>Icon114 Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon114 Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon114 Path</em>' attribute.
	 * @see #setIcon114Path(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon114Path()
	 * @model
	 * @generated
	 */
	String getIcon114Path();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon114Path <em>Icon114 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon114 Path</em>' attribute.
	 * @see #getIcon114Path()
	 * @generated
	 */
	void setIcon114Path(String value);

	/**
	 * Returns the value of the '<em><b>Icon114 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon114 Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon114 Uri</em>' attribute.
	 * @see #setIcon114Uri(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon114Uri()
	 * @model
	 * @generated
	 */
	String getIcon114Uri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon114Uri <em>Icon114 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon114 Uri</em>' attribute.
	 * @see #getIcon114Uri()
	 * @generated
	 */
	void setIcon114Uri(String value);

	/**
	 * Returns the value of the '<em><b>Icon144 Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon144 Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon144 Path</em>' attribute.
	 * @see #setIcon144Path(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon144Path()
	 * @model
	 * @generated
	 */
	String getIcon144Path();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon144Path <em>Icon144 Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon144 Path</em>' attribute.
	 * @see #getIcon144Path()
	 * @generated
	 */
	void setIcon144Path(String value);

	/**
	 * Returns the value of the '<em><b>Icon144 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon144 Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon144 Uri</em>' attribute.
	 * @see #setIcon144Uri(String)
	 * @see org.soluvas.web.site.pagemeta.PagemetaPackage#getPageIcon_Icon144Uri()
	 * @model
	 * @generated
	 */
	String getIcon144Uri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon144Uri <em>Icon144 Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon144 Uri</em>' attribute.
	 * @see #getIcon144Uri()
	 * @generated
	 */
	void setIcon144Uri(String value);

	/**
	 * <!-- begin-user-doc -->
	 * @param imagesUri Images URI (may be insecure or secure), must end in trailing slash.
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a PageIcon containing absolute URIs.
	 * <!-- end-model-doc -->
	 * @model
	 */
	PageIcon toAbsolute(String imagesUri);

} // PageIcon
