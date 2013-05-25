/**
 */
package org.soluvas.web.banner;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Banner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.banner.Banner#getImageUri <em>Image Uri</em>}</li>
 *   <li>{@link org.soluvas.web.banner.Banner#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.web.banner.Banner#getLinkUri <em>Link Uri</em>}</li>
 *   <li>{@link org.soluvas.web.banner.Banner#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.web.banner.Banner#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.web.banner.Banner#getImageBase <em>Image Base</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.banner.BannerPackage#getBanner()
 * @model
 */
public interface Banner extends EObject {
	/**
	 * Returns the value of the '<em><b>Image Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Uri</em>' attribute.
	 * @see #setImageUri(String)
	 * @see org.soluvas.web.banner.BannerPackage#getBanner_ImageUri()
	 * @model required="true"
	 * @generated
	 */
	String getImageUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.banner.Banner#getImageUri <em>Image Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Uri</em>' attribute.
	 * @see #getImageUri()
	 * @generated
	 */
	void setImageUri(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.soluvas.web.banner.BannerPackage#getBanner_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.web.banner.Banner#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Uri</em>' attribute.
	 * @see #setLinkUri(String)
	 * @see org.soluvas.web.banner.BannerPackage#getBanner_LinkUri()
	 * @model
	 * @generated
	 */
	String getLinkUri();

	/**
	 * Sets the value of the '{@link org.soluvas.web.banner.Banner#getLinkUri <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Uri</em>' attribute.
	 * @see #getLinkUri()
	 * @generated
	 */
	void setLinkUri(String value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Integer)
	 * @see org.soluvas.web.banner.BannerPackage#getBanner_Width()
	 * @model
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.soluvas.web.banner.Banner#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(Integer)
	 * @see org.soluvas.web.banner.BannerPackage#getBanner_Height()
	 * @model
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.soluvas.web.banner.Banner#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

	/**
	 * Returns the value of the '<em><b>Image Base</b></em>' attribute.
	 * The default value is <code>"ABSOLUTE"</code>.
	 * The literals are from the enumeration {@link org.soluvas.web.banner.ImageBase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Base of the provided imageUri.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Image Base</em>' attribute.
	 * @see org.soluvas.web.banner.ImageBase
	 * @see #setImageBase(ImageBase)
	 * @see org.soluvas.web.banner.BannerPackage#getBanner_ImageBase()
	 * @model default="ABSOLUTE"
	 * @generated
	 */
	ImageBase getImageBase();

	/**
	 * Sets the value of the '{@link org.soluvas.web.banner.Banner#getImageBase <em>Image Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Base</em>' attribute.
	 * @see org.soluvas.web.banner.ImageBase
	 * @see #getImageBase()
	 * @generated
	 */
	void setImageBase(ImageBase value);

} // Banner
