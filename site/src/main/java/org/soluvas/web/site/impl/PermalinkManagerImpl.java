/**
 */
package org.soluvas.web.site.impl;

import java.util.NoSuchElementException;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.commons.EntityKind;
import org.soluvas.web.site.Permalink;
import org.soluvas.web.site.PermalinkCatalog;
import org.soluvas.web.site.PermalinkManager;
import org.soluvas.web.site.SiteException;
import org.soluvas.web.site.SitePackage;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permalink Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PermalinkManagerImpl extends EObjectImpl implements PermalinkManager {
	
	private PermalinkCatalog catalog;
	
	/**
	 * @param catalog
	 */
	public PermalinkManagerImpl(PermalinkCatalog catalog) {
		super();
		this.catalog = catalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PermalinkManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SitePackage.Literals.PERMALINK_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String relative(final EntityKind kind, String slugPath) {
		try {
			final Permalink permalink = Iterables.find( catalog.getPermalinks(),  new Predicate<Permalink>() {
				@Override
				public boolean apply(@Nullable Permalink input) {
					return kind.getLiteral().equals(input.getNamespace());
				};
			});
			try {
				return UriTemplate.fromTemplate(permalink.getTemplate()).expand(
						ImmutableMap.<String, Object>of("namespace", kind.getLiteral(), "slug", slugPath,
							"slugPath", slugPath, "baseUri", "/"));
			} catch (VariableExpansionException | MalformedUriTemplateException e) {
				throw new SiteException(e, "Permalink URI template '%' is invalid", permalink.getTemplate());
			}
		} catch (NoSuchElementException e) {
			final Iterable<String> permalinkNamespaces = Iterables.transform(catalog.getPermalinks(), new Function<Permalink, String>() {
				@Override @Nullable
				public String apply(@Nullable Permalink input) {
					return input.getNamespace();
				}
			});
			throw new SiteException(e, "Cannot find kind %s. PermalinkCatalog has %d permalinks: %s",
					kind, catalog.getPermalinks().size(), permalinkNamespaces);
		}	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * @todo Support switch http/https.
	 * <!-- end-user-doc -->
	 */
	@Override
	public String absolute(String webHost, EntityKind kind, String slugPath) {
		return unsecureAbsolute(webHost, kind, slugPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String unsecureAbsolute(String webHost, final EntityKind kind, String slugPath) {
		try {
			final Permalink permalink = Iterables.find( catalog.getPermalinks(),  new Predicate<Permalink>() {
				@Override
				public boolean apply(@Nullable Permalink input) {
					return kind.getLiteral().equals(input.getNamespace());
				};
			});
			try {
				return UriTemplate.fromTemplate(permalink.getTemplate()).expand(
						ImmutableMap.<String, Object>of("namespace", kind.getLiteral(), "slug", slugPath,
							"slugPath", slugPath, "baseUri", "http://" + webHost + "/"));
			} catch (VariableExpansionException | MalformedUriTemplateException e) {
				throw new SiteException(e, "Permalink URI template '%' is invalid", permalink.getTemplate());
			}
		} catch (NoSuchElementException e) {
			final Iterable<String> permalinkNamespaces = Iterables.transform(catalog.getPermalinks(), new Function<Permalink, String>() {
				@Override @Nullable
				public String apply(@Nullable Permalink input) {
					return input.getNamespace();
				}
			});
			throw new SiteException(e, "Cannot find kind %s. PermalinkCatalog has %d permalinks: %s",
					kind, catalog.getPermalinks().size(), permalinkNamespaces);
		}	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String secureAbsolute(String webHost, final EntityKind kind, String slugPath) {
		try {
			final Permalink permalink = Iterables.find( catalog.getPermalinks(),  new Predicate<Permalink>() {
				@Override
				public boolean apply(@Nullable Permalink input) {
					return kind.getLiteral().equals(input.getNamespace());
				};
			});
			try {
				return UriTemplate.fromTemplate(permalink.getTemplate()).expand(
						ImmutableMap.<String, Object>of("namespace", kind.getLiteral(), "slug", slugPath,
							"slugPath", slugPath, "baseUri", "https://" + webHost + "/"));
			} catch (VariableExpansionException | MalformedUriTemplateException e) {
				throw new SiteException(e, "Permalink URI template '%' is invalid", permalink.getTemplate());
			}
		} catch (NoSuchElementException e) {
			final Iterable<String> permalinkNamespaces = Iterables.transform(catalog.getPermalinks(), new Function<Permalink, String>() {
				@Override @Nullable
				public String apply(@Nullable Permalink input) {
					return input.getNamespace();
				}
			});
			throw new SiteException(e, "Cannot find kind %s. PermalinkCatalog has %d permalinks: %s",
					kind, catalog.getPermalinks().size(), permalinkNamespaces);
		}	
	}

} //PermalinkManagerImpl
