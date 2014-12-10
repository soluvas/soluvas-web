package org.soluvas.web.bootstrap;

import java.util.UUID;

import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.soluvas.commons.tenant.CommandRequestAttributes;

/**
 * Should be added as the <b>last</b> {@link WebApplication#getRequestCycleListeners()},
 * which will log {@link Logger#error(String)} and exception then show {@link FriendlyErrorPage}.
 * @author ceefour
 */
public class FriendlyErrorRequestListener extends AbstractRequestCycleListener {

	private static final Logger log = LoggerFactory
			.getLogger(FriendlyErrorRequestListener.class);
	private static final String MDC_INCIDENT_ID = "incidentId";

	/* (non-Javadoc)
	 * @see org.apache.wicket.request.cycle.IRequestCycleListener#onException(org.apache.wicket.request.cycle.RequestCycle, java.lang.Exception)
	 */
	@Override
	public IRequestHandler onException(RequestCycle cycle, Exception ex) {
		final UUID incidentId = UUID.randomUUID();
		MDC.put(MDC_INCIDENT_ID, incidentId.toString());
		try {
			log.error(MDC.get(CommandRequestAttributes.MDC_TENANT_ID) + " " + incidentId + " " + cycle.getRequest().getUrl() + "» " + ex, ex);
			return new RenderPageRequestHandler(new PageProvider(new FriendlyErrorPage(incidentId, ex)), RedirectPolicy.NEVER_REDIRECT);
		} finally {
			MDC.remove(MDC_INCIDENT_ID);
		}
	}

}
