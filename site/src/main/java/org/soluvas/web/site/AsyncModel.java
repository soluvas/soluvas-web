package org.soluvas.web.site;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.wicket.model.IModel;
import org.apache.wicket.request.cycle.RequestCycle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * Usage:
 * 
 * <pre>{@literal
 * //Find all product
 * final IModel<List<Product>> productEntities = new LoadableDetachableModel<List<Product>>() {
 * 	@Override
 * 	public List<Product> load() {
 * 		return ImmutableList.copyOf(Iterables.limit(productRepo.findAll(), 16));
 * 	}
 * });
 * }</pre>
 * 
 * <p>{@link #onAttach()} doesn't work as I imagined. What we need is onBeforeRequest...
 * 
 * <p>This model is thread-safe.
 * 
 * @deprecated DO NOT USE! AsyncModel is "bad" because Wicket does not support it explicitly.
 * 		Among other lesser problems, the biggest problem is IT SEEMS when an Exception is thrown
 * 		from an AsyncModel, it doesn't propagate well into the Wicket exception handler and thus,
 * 		the page rendering hangs and then you get 504 Gateway Timeout.
 * 		Maybe this even has to do with AsyncModel having a default timeout value of 15 seconds.
 * 		I'm not exactly sure why all this happens, but for now LoadableDetachableModel is
 * 		the supported Wicket mechanism (and even Wicket/Pax Wicket/Pax Web/Blueprint/Felix
 * 		still has bugs so it's better not to complicate matters).
 * 		I already tried fixing the timeout mechanism & decreasing the timeout to two seconds but still occuring. 
 * @author ceefour
 */
@SuppressWarnings("serial")
@Deprecated
public abstract class AsyncModel<T> implements IModel<T> {

	private static final Logger log = LoggerFactory.getLogger(AsyncModel.class);
	/** keeps track of whether this model is attached or detached */
	private transient volatile boolean attached = false;
	/** temporary, transient object. */
	private transient volatile T transientModelObject;
	public static final int timeoutValue = 2000;
	public static final TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;
	private volatile transient Future<T> future;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final AtomicInteger scheduledLoads = new AtomicInteger();

	public AsyncModel() {
		super();
		resubmit();
	}
	
	/**
	 * @see org.apache.wicket.model.IDetachable#detach()
	 */
	@Override
	public synchronized void detach()
	{
		if (attached || scheduledLoads.get() > 0)
		{
			try
			{
				onDetach();
			}
			finally
			{
				// wait loads
				while (scheduledLoads.get() > 0) {
					try {
						// TODO: find more efficient waiting algorithm
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
					}
				}
				
				final Lock writeLock = lock.writeLock();
				try {
					boolean locked = writeLock.tryLock(50, TimeUnit.MILLISECONDS);
					if (locked) {
						try {
							attached = false;
							transientModelObject = null;

							log.trace("removed transient object for {}, requestCycle {}", this,
								RequestCycle.get());
						} finally {
							writeLock.unlock();
						}
					}
				} catch (InterruptedException e) {
					log.warn("Interrupted while trying write lock " + getClass().getName(), e);
				}
			}
		}
	}

	/**
	 * @see org.apache.wicket.model.IModel#getObject()
	 */
	@Override
	public T getObject()
	{
		while (!attached) {
			try {
				final Lock writeLock = lock.writeLock();
				final boolean locked = writeLock.tryLock(10, TimeUnit.MILLISECONDS);
				if (locked) {
					try {
						if (future == null) {
							log.info("future is null, resubmitting");
							// FIXME: this is sync!! need onBeforeRequest
							resubmit();
						}
						transientModelObject = future.get(timeoutValue, timeoutUnit);
						attached = true;
						future = null;
	//					if (futureResult == null)
	//						log.warn("AsyncModel returns null!");
						
						if (log.isDebugEnabled())
						{
							log.debug("loaded transient object " + transientModelObject + " for " + this +
								", requestCycle " + RequestCycle.get());
						}
	
						onAttach();
					} catch (final InterruptedException e) {
						throw new SiteException(e, "Cannot load model %s", getClass().getName());
					} catch (final ExecutionException e) {
	//					Throwables.propagate(e.getCause());
						throw new SiteException(e, "Cannot load model %s", getClass().getName());
					} catch (final TimeoutException e) {
						transientModelObject = null;
						attached = true;
						future = null;
						log.error("Timed out (%d %s) waiting for model %s", timeoutValue, timeoutUnit, getClass().getName());
					} finally {
						writeLock.unlock();
					}
				}
			} catch (InterruptedException e) {
				log.warn("Interrupted while trying write lock " + getClass().getName(), e);
			}
		}
		return transientModelObject;
	}

	/**
	 * Gets the attached status of this model instance
	 * 
	 * @return true if the model is attached, false otherwise
	 */
	public final boolean isAttached()
	{
		return attached;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
	 StringBuilder sb = new StringBuilder(super.toString());
		sb.append(":attached=").append(attached).append(":tempModelObject=[").append(
			this.transientModelObject).append("]");
		return sb.toString();
	}

	/**
	 * Loads and returns the (temporary) model object.
	 * 
	 * @return the (temporary) model object
	 */
	protected abstract T load() throws Exception;

	/**
	 * Attaches to the current request. Implement this method with custom behavior, such as loading
	 * the model object.
	 */
	protected void onAttach()
	{
	}

	/**
	 * Detaches from the current request. Implement this method with custom behavior, such as
	 * setting the model object to null.
	 */
	protected void onDetach()
	{
	}


	/**
	 * Manually loads the model with the specified object. Subsequent calls to {@link #getObject()}
	 * will return {@code object} until {@link #detach()} is called.
	 * 
	 * @param object
	 *            The object to set into the model
	 */
	@Override
	public void setObject(final T object)
	{
		final Lock writeLock = lock.writeLock();
		writeLock.lock();
		try {
			attached = true;
			transientModelObject = object;
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * @param loader
	 */
	protected void resubmit() {
		scheduledLoads.incrementAndGet();
		final BundleContext bundleContext = Preconditions.checkNotNull(FrameworkUtil.getBundle(AsyncModel.class).getBundleContext(),
				"Cannot get bundleContext for %s", AsyncModel.class);
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
					final T loaded = load();
					scheduledLoads.decrementAndGet();
					return loaded;
				}
			});
		} finally {
			bundleContext.ungetService(executorRef);
		}
	}

}
