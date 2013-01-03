package org.soluvas.web.site.compose;

import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import org.apache.wicket.Page;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.SiteException;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

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

	@SuppressWarnings("unchecked")
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
		final Builder<EObject> eobjects = ImmutableList.builder();
		while (entries.hasMoreElements()) {
			final URL url = entries.nextElement();
			log.debug("Getting {} from {}", suppliedClassName, url);
			final XmiObjectLoader<ComposeCatalog> loader = new XmiObjectLoader<ComposeCatalog>(ePackage, url,
					bundle);
			final ComposeCatalog composeCatalog = loader.get();
			
			for (final Placeholder placeholder : ImmutableList.copyOf(composeCatalog.getPlaceholders())) {
				log.debug("Adding Placeholder {}/{} from {}", placeholder.getPageClassName(), placeholder.getPath(), url);
				final LivePlaceholder livePlaceholder = ComposeFactory.eINSTANCE.createLivePlaceholder();
				livePlaceholder.setPageClassName(placeholder.getPageClassName());
				livePlaceholder.setPath(placeholder.getPath());
				livePlaceholder.setModelClassName(placeholder.getModelClassName());
				livePlaceholder.setLiveBundle(bundle);
				final Class<Page> pageClass;
				try {
					pageClass = (Class<Page>) bundle.loadClass(placeholder.getPageClassName());
				} catch (ClassNotFoundException e) {
					throw new SiteException("Cannot load Page class " + placeholder.getPageClassName() + " in bundle " + bundle +
							" referenced from " + url, e);
				}
				livePlaceholder.setPageClass(pageClass);
				final LivePlaceholder added = placeholderRepo.add(livePlaceholder);
				eobjects.add(added);
			}
			
			for (final Slave slave : ImmutableList.copyOf(composeCatalog.getSlaves())) {
				log.debug("Adding Slave {}/{} from {}", slave.getPageClassName(), slave.getPath(), url);
				final LiveSlave liveSlave = ComposeFactory.eINSTANCE.createLiveSlave();
				liveSlave.setPageClassName(slave.getPageClassName());
				liveSlave.setPath(slave.getPath());
				liveSlave.setModelClassName(slave.getModelClassName());
				liveSlave.setLiveBundle(bundle);
				final Class<Page> pageClass;
				try {
					pageClass = (Class<Page>) bundle.loadClass(slave.getPageClassName());
				} catch (ClassNotFoundException e) {
					throw new SiteException("Cannot load Page class " + slave.getPageClassName() + " in bundle " + bundle +
							" referenced from " + url, e);
				}
				liveSlave.setPageClass(pageClass);
				final LiveSlave added = slaveRepo.add(liveSlave);
				eobjects.add(added);
			}
			
			for (final Contributor contributor : ImmutableList.copyOf(composeCatalog.getContributors())) {
				log.debug("Adding Contributor for {}/{} from {}", contributor.getPageClassName(), contributor.getTargetPath(), url);
				final LiveContributor liveContributor = contributor.createLive(bundle);
				liveContributor.setLiveBundle(bundle);
				final LiveContributor added = contributorRepo.add(liveContributor);
				eobjects.add(added);
			}
			
		}
		final List<EObject> eobjectList = eobjects.build();
		if (!eobjectList.isEmpty()) {
			log.info("Added {} EObjects from {} [{}]",
					eobjectList.size(), bundle.getSymbolicName(), bundle.getBundleId());
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
			List<EObject> eobjects) {
		if (eobjects.isEmpty())
			return;

		final Collection<LiveContributor> contribs = contributorRepo.findAll();
		log.debug("Removing {} EObjects provided by {} [{}]",
				eobjects.size(), bundle.getSymbolicName(), bundle.getBundleId());
		for (final EObject eobject : eobjects) {
			if (eobject instanceof LiveTarget) {
				for (LiveContributor contrib : contribs) {
					contrib.targetRemoved((LiveTarget) eobject);
				}
			}
			
			if (eobject instanceof LivePlaceholder) {
				final LivePlaceholder placeholder = (LivePlaceholder) eobject;
				log.debug("Removing Placeholder {}/{} from {} [{}]", placeholder.getPageClassName(), placeholder.getPath(),
						bundle.getSymbolicName(), bundle.getBundleId());
				placeholderRepo.delete(placeholder);
			} else if (eobject instanceof LiveSlave) {
				final LiveSlave slave = (LiveSlave) eobject;
				log.debug("Removing Slave {}/{} from {} [{}]", slave.getPageClassName(), slave.getPath(),
						bundle.getSymbolicName(), bundle.getBundleId());
				slaveRepo.delete(slave);
			} else if (eobject instanceof LiveContributor) {
				final LiveContributor contributor = (LiveContributor) eobject;
				log.debug("Removing Contributor {}/{} from {} [{}]", contributor.getPageClassName(), contributor.getTargetPath(),
						bundle.getSymbolicName(), bundle.getBundleId());
				contributorRepo.delete(contributor);
			} else {
				throw new SiteException("Unknown EObject " + eobject.getClass().getName() + " from " + 
						bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
			}
		}
		log.info("Removed {} EObjects from {} [{}]",
				eobjects.size(), bundle.getSymbolicName(), bundle.getBundleId());

		log.debug("Notifying {} contributors that bundle {} [{}] is removed",
				contribs.size(), bundle.getSymbolicName(), bundle.getBundleId());
		for (final LiveContributor contrib : contribs) {
			contrib.bundleRemoved(bundle);
		}
	}

}
