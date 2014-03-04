package org.soluvas.web.site;

import javax.annotation.Nullable;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * Holder {@link ResourceReference} for {@code favicon.ico}. Please set it's {@link #INSTANCE} to during your
 * {@link WebApplication}'s {@code mountResources()}.
 * 
 * <p>Usage:
 * 
 * <pre>
 * private void mountResources() {
 * 	FaviconResourceReference.INSTANCE = new FaviconResourceReference() {
 * 		private static final long serialVersionUID = 1L;
 * 
 * 		{@code @Override}
 * 		public IResource getResource() {
 * 			return new FaviconImageResource();
 * 		}
 * 	};
 * 	mountResource("favicon.ico", FaviconResourceReference.INSTANCE);
 * }
 * </pre>
 * 
 * @author ceefour
 */
public abstract class FaviconResourceReference extends ResourceReference {
	
	private static final long serialVersionUID = 1L;
	@Nullable
	public static FaviconResourceReference INSTANCE;

	protected FaviconResourceReference() {
		super("favicon.ico");
	}

}
