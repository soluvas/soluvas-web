package org.soluvas.web.site.osgi;

import java.util.List;

import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.soluvas.web.site.FederatingPageRulesSupplier;
import org.soluvas.web.site.PageRule;
import org.soluvas.web.site.PageRulesSupplier;

import com.google.common.base.Supplier;

/**
 * Monitors {@link PageRulesSupplier} instances in a {@link FederatingPageRulesSupplier}.
 * @author ceefour
 */
public class PageRulesSupplierTracker implements ServiceTrackerCustomizer {

	private FederatingPageRulesSupplier federator;
	
	public PageRulesSupplierTracker(FederatingPageRulesSupplier federator) {
		super();
		this.federator = federator;
	}

	/* (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#addingService(org.osgi.framework.ServiceReference)
	 */
	@Override
	public Object addingService(ServiceReference reference) {
		PageRulesSupplier supplier = reference.getBundle().getBundleContext().getService(reference);
		federator.add(supplier);
		return supplier;
	}

	/* (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#modifiedService(org.osgi.framework.ServiceReference, java.lang.Object)
	 */
	@Override
	public void modifiedService(ServiceReference reference, Object service) {
	}

	/* (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#removedService(org.osgi.framework.ServiceReference, java.lang.Object)
	 */
	@Override
	public void removedService(ServiceReference reference, Object service) {
		federator.remove((Supplier<List<PageRule>>) service);
		reference.getBundle().getBundleContext().ungetService(reference);
	}

}
