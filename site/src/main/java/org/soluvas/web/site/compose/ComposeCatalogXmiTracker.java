package org.soluvas.web.site.compose;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.wicket.Page;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.SiteException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 *
 */
public class ComposeCatalogXmiTracker implements BundleTrackerCustomizer<List<EObject>> {
	
	private static Logger log = LoggerFactory
			.getLogger(ComposeCatalogXmiTracker.class);
	private static final String suppliedClassSimpleName = ComposeCatalog.class.getSimpleName();
	private static final String suppliedClassName = ComposeCatalog.class.getName();
	private static final ComposePackage ePackage = ComposePackage.eINSTANCE;
	private final CrudRepository<LivePlaceholder, Integer> placeholderRepo;
	private final CrudRepository<LiveSlave, Integer> slaveRepo;
	private final CrudRepository<LiveContributor, Integer> contributorRepo;
	private final Map<String, List<EObject>> eObjects = new HashMap<>(); 
	
	/**
	 * @param placeholderRepo
	 * @param tenantId
	 * @param tenantEnv
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ComposeCatalogXmiTracker(CrudRepository placeholderRepo, CrudRepository slaveRepo,
			CrudRepository contributorRepo) {
		super();
		this.placeholderRepo = placeholderRepo;
		this.slaveRepo = slaveRepo;
		this.contributorRepo = contributorRepo;
	}

	@PreDestroy
	public void destroy() {
		for (final Entry<String, List<EObject>> entry : eObjects.entrySet()) {
			removedBundle(entry.getValue(), entry.getKey());
		}
	}
	
	@Override
	public List<EObject> addingBundle(Bundle bundle, BundleEvent event) {
		final String path = bundle.getSymbolicName().replace('.', '/');
		final String filePattern = "*." + suppliedClassSimpleName + ".xmi";
		log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
				path , filePattern);
		final Enumeration<URL> entries = bundle.findEntries(path, filePattern, false);
		if (entries == null) {
			return null;
		}
		final List<URL> xmiFiles = ImmutableList.copyOf(Iterators.forEnumeration(entries));
		return extractObjects(xmiFiles, bundle, null);
	}
	
	/**
	 * Scan using classpath.
	 */
	public void scan(ClassLoader classLoader) {
		final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		// Due to JDK limitation, scanning of root won't work in webapp classpath,
		// at least the root folder must be specified before wildcard
		final List<String> locationPatterns = ImmutableList.of("classpath*:org/**/*.ComposeCatalog.xmi",
				"classpath*:com/**/*.ComposeCatalog.xmi", "classpath*:id/**/*.ComposeCatalog.xmi");
		log.trace("Scanning {} for {}", classLoader, locationPatterns);
		try {
			final List<Resource> allResources = new ArrayList<>();
			for (String locationPattern : locationPatterns) {
				final Resource[] resources = resolver.getResources(locationPattern);
				allResources.addAll(ImmutableList.copyOf(resources));
			}
			log.info("Scanned {} returned {} resources: {}",
					locationPatterns, allResources.size(), allResources);
			final List<URL> xmiUrls = ImmutableList.copyOf(Lists.transform(
					allResources, new Function<Resource, URL>() {
				@Override @Nullable
				public URL apply(@Nullable Resource input) {
					try {
						return input.getURL();
					} catch (IOException e) {
						throw new SiteException("Cannot get URL for " + input, e);
					}
				}
			}));
			for (URL xmiUrl : xmiUrls) {
				final List<EObject> objs = extractObjects(ImmutableList.of(xmiUrl), null, classLoader);
				eObjects.put(xmiUrl.toString(), objs);
			}
		} catch (IOException e) {
			throw new SiteException(e, "Cannot scan %s for %s",
					classLoader, locationPatterns);
		}
	}

	private List<EObject> extractObjects(final List<URL> xmiFiles, @Nullable Bundle bundle, ClassLoader classLoader) {
		final String resourceContainer = bundle != null ? bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]" : "classpath";
		
		final Builder<EObject> eobjects = ImmutableList.builder();
		for (final URL url : xmiFiles) {
			log.debug("Getting {} from {}", suppliedClassName, url);
			final XmiObjectLoader<ComposeCatalog> loader = bundle != null ?
					new XmiObjectLoader<ComposeCatalog>(ePackage, url, bundle) :
						new XmiObjectLoader<ComposeCatalog>(ePackage, url, ResourceType.CLASSPATH);
			final ComposeCatalog composeCatalog = loader.get();
			
			for (final Placeholder placeholder : ImmutableList.copyOf(composeCatalog.getPlaceholders())) {
				log.debug("Adding Placeholder {}/{} from {}", placeholder.getPageClassName(), placeholder.getPath(), url);
				final LivePlaceholder livePlaceholder = ComposeFactory.eINSTANCE.createLivePlaceholder();
				livePlaceholder.setBundle(placeholder.getBundle());
				livePlaceholder.setResourceName(placeholder.getResourceName());
				livePlaceholder.setResourceType(placeholder.getResourceType());
				livePlaceholder.setResourceUri(placeholder.getResourceUri());
				livePlaceholder.setPageClassName(placeholder.getPageClassName());
				livePlaceholder.setPath(placeholder.getPath());
				livePlaceholder.setModelClassName(placeholder.getModelClassName());
				final Class<Page> pageClass;
				try {
					pageClass = (Class<Page>) (bundle != null ? bundle.loadClass(placeholder.getPageClassName()) : classLoader.loadClass(placeholder.getPageClassName()));
				} catch (ClassNotFoundException e) {
					throw new SiteException("Cannot load Page class " + placeholder.getPageClassName() + " in " + resourceContainer +
							" referenced from " + url, e);
				}
				livePlaceholder.setPageClass(pageClass);
				final LivePlaceholder added = placeholderRepo.add(livePlaceholder);
				eobjects.add(added);
			}
			
			for (final Slave slave : ImmutableList.copyOf(composeCatalog.getSlaves())) {
				log.debug("Adding Slave {}/{} from {}", slave.getPageClassName(), slave.getPath(), url);
				final LiveSlave liveSlave = ComposeFactory.eINSTANCE.createLiveSlave();
				liveSlave.setBundle(slave.getBundle());
				liveSlave.setResourceName(slave.getResourceName());
				liveSlave.setResourceType(slave.getResourceType());
				liveSlave.setResourceUri(slave.getResourceUri());
				liveSlave.setPageClassName(slave.getPageClassName());
				liveSlave.setPath(slave.getPath());
				liveSlave.setModelClassName(slave.getModelClassName());
				final Class<Page> pageClass;
				try {
					pageClass = (Class<Page>) (bundle != null ? bundle.loadClass(slave.getPageClassName()) : classLoader.loadClass(slave.getPageClassName()));
				} catch (ClassNotFoundException e) {
					throw new SiteException("Cannot load Page class " + slave.getPageClassName() + " in " + resourceContainer +
							" referenced from " + url, e);
				}
				liveSlave.setPageClass(pageClass);
				final LiveSlave added = slaveRepo.add(liveSlave);
				eobjects.add(added);
			}
			
			for (final Contributor contributor : ImmutableList.copyOf(composeCatalog.getContributors())) {
				final String contributorName;
				if (contributor instanceof ChildContributor) {
					contributorName = ((ChildContributor) contributor).getClassName();
				} else if (contributor instanceof ReplaceContributor) {
					contributorName = ((ReplaceContributor) contributor).getClassName();
				} else {
					contributorName = "unknown";
				}
				log.debug("Adding Contributor {} for {}/{} from {}", contributorName,
						contributor.getPageClassName(), contributor.getTargetPath(), url);
				final LiveContributor liveContributor = contributor.createLive();
				final LiveContributor added = contributorRepo.add(liveContributor);
				eobjects.add(added);
			}
		}
		final List<EObject> eobjectList = eobjects.build();
		if (!eobjectList.isEmpty()) {
			log.info("Added {} EObjects from {}",
					eobjectList.size(), resourceContainer);
		}
		
		final Collection<LiveContributor> contribs = contributorRepo.findAll();
		for (LiveContributor contrib : contribs) {
			contrib.resolve(placeholderRepo.findAll(), slaveRepo.findAll());
		}
		
		return eobjectList;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<EObject> object) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			List<EObject> objects) {
		removedBundle(objects, bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
	}
	
	private void removedBundle(@Nonnull final List<EObject> eobjects,
			String resourceContainer) {
		if (eobjects.isEmpty())
			return;

		final Collection<LiveContributor> contribs = contributorRepo.findAll();
		log.debug("Removing {} EObjects provided by {}",
				eobjects.size(), resourceContainer);
		for (final EObject eobject : eobjects) {
			if (eobject instanceof LiveTarget) {
				for (LiveContributor contrib : contribs) {
					contrib.targetRemoved((LiveTarget) eobject);
				}
			}
			
			if (eobject instanceof LivePlaceholder) {
				final LivePlaceholder placeholder = (LivePlaceholder) eobject;
				log.debug("Removing Placeholder {}/{} from {}", placeholder.getPageClassName(), placeholder.getPath(),
						resourceContainer);
				placeholderRepo.delete(placeholder);
			} else if (eobject instanceof LiveSlave) {
				final LiveSlave slave = (LiveSlave) eobject;
				log.debug("Removing Slave {}/{} from {}", slave.getPageClassName(), slave.getPath(),
						resourceContainer);
				slaveRepo.delete(slave);
			} else if (eobject instanceof LiveContributor) {
				final LiveContributor contributor = (LiveContributor) eobject;
				log.debug("Removing Contributor {}/{} from {}", contributor.getPageClassName(), contributor.getTargetPath(),
						resourceContainer);
				contributorRepo.delete(contributor);
			} else {
				throw new SiteException("Unknown EObject " + eobject.getClass().getName() + " from " + 
						resourceContainer);
			}
		}
		log.info("Removed {} EObjects from {}",
				eobjects.size(), resourceContainer);
	}

}
