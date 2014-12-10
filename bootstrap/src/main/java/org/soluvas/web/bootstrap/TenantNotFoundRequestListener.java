package org.soluvas.web.bootstrap;

import java.util.List;

import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantNotFoundException;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.FluentIterable;

/**
 * Should be added as the <b>last</b> {@link WebApplication#getRequestCycleListeners()},
 * which will log {@link Logger#error(String)} and exception then show {@link TenantNotFoundPage}.
 * @author ceefour
 * @see TenantNotFoundPage
 */
public class TenantNotFoundRequestListener extends AbstractRequestCycleListener {

	private static final Logger log = LoggerFactory
			.getLogger(TenantNotFoundRequestListener.class);

	/* (non-Javadoc)
	 * @see org.apache.wicket.request.cycle.IRequestCycleListener#onException(org.apache.wicket.request.cycle.RequestCycle, java.lang.Exception)
	 */
	@Override
	public IRequestHandler onException(RequestCycle cycle, Exception ex) {
		final List<Throwable> chain = Throwables.getCausalChain(ex);
		final Optional<Throwable> tenantNotFound = FluentIterable.from(chain).firstMatch(new Predicate<Throwable>() {
			@Override
			public boolean apply(Throwable input) {
				return input instanceof TenantNotFoundException;
			}
		});
		if (tenantNotFound.isPresent()) {
			return new RenderPageRequestHandler(new PageProvider(new TenantNotFoundPage(ex)), RedirectPolicy.NEVER_REDIRECT);
		} else {
			return super.onException(cycle, ex);
		}
	}

}
