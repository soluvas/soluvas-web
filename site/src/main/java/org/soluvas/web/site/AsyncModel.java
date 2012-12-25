package org.soluvas.web.site;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.wicket.model.LoadableDetachableModel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;

/**
 * Usage:
 * 
 * <pre>{@literal
 * //Find all product
 * final IModel<List<Product>> productEntities = new AsyncModel<List<Product>>(executor, new Callable<List<Product>>() {
 * 	@Override
 * 	public List<Product> call() throws Exception {
 * 		return ImmutableList.copyOf(Iterables.limit(productRepo.findAll(), 16));
 * 	}
 * });
 * }</pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public abstract class AsyncModel<T> extends LoadableDetachableModel<T> {

	private static final Logger log = LoggerFactory.getLogger(AsyncModel.class);
	public static final int timeoutValue = 15;
	public static final TimeUnit timeoutUnit = TimeUnit.SECONDS;
	private transient Future<T> future;
	private transient T futureResult;
	private transient boolean hasResult = false;

	public AsyncModel() {
		super();
		resubmit();
	}
	
	/**
	 * @param loader
	 */
	protected void resubmit() {
		final BundleContext bundleContext = FrameworkUtil.getBundle(AsyncModel.class).getBundleContext();
		final ServiceReference<ExecutorService> executorRef;
		try {
			executorRef = Iterables.getFirst(
					bundleContext.getServiceReferences(ExecutorService.class, "(tenantId=*)"), null);
			Preconditions.checkNotNull(executorRef, "Cannot find ExecutorService");
		} catch (InvalidSyntaxException e) {
			throw new SiteException("Cannot get global ExecutorService", e);
		}
		final ExecutorService executor = bundleContext.getService(executorRef);
		try {
			future = executor.submit(new Callable<T>() {
				@Override
				public T call() throws Exception {
					return doLoad();
				}
			});
		} finally {
			bundleContext.ungetService(executorRef);
		}
	}
	
	@Override
	protected void onAttach() {
		super.onAttach();
		if (future == null) {
			resubmit();
		}
	}
	
	@Override
	protected void onDetach() {
		future = null;
		futureResult = null;
		hasResult = false;
		super.onDetach();
	}
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.model.LoadableDetachableModel#load()
	 */
	@Override
	protected T load() {
		if (!hasResult) {
			try {
				if (future == null) {
					log.warn("future is null, resubmitting");
					// FIXME: this is sync!!
					resubmit();
				}
				Preconditions.checkNotNull(future, "future cannot be null");
				futureResult = future.get(timeoutValue, timeoutUnit);
				if (futureResult == null)
					log.warn("AsyncModel returns null!");
				setObject(futureResult);
				hasResult = true;
			} catch (InterruptedException e) {
				throw new SiteException(e, "Cannot load model %s", getClass().getName());
			} catch (ExecutionException e) {
				Throwables.propagate(e.getCause());
				futureResult = null;
	//			throw new SiteException(e, "Cannot load model %s", getClass().getName());
			} catch (TimeoutException e) {
				log.error("Timed out (%d %s) waiting for model %s", timeoutValue, timeoutUnit, getClass().getName());
				futureResult = null;
			}
		}
		return futureResult;
	}

	protected abstract T doLoad() throws Exception;
	
}
