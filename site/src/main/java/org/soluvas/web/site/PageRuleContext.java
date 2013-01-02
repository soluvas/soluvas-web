package org.soluvas.web.site;

import javax.annotation.Nonnull;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

public class PageRuleContext {
	private final String clientId;
	private final String tenantId;
	private final String tenantEnv;
	private final ExtensiblePage page;
	private final String uri;
	private final WebAddress webAddress;
	private final AppManifest appManifest;
	
	/**
	 * @param clientId
	 * @param tenantId
	 * @param tenantEnv
	 * @param page
	 * @param uri
	 */
	public PageRuleContext(@Nonnull final String clientId, @Nonnull final String tenantId, @Nonnull final String tenantEnv,
			@Nonnull final ExtensiblePage page, String uri, @Nonnull final WebAddress webAddress,
			@Nonnull final AppManifest appManifest) {
		super();
		this.clientId = clientId;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
		this.page = page;
		this.uri = uri;
		this.webAddress = webAddress;
		this.appManifest = appManifest;
	}

	public String getClientId() {
		return clientId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public String getTenantEnv() {
		return tenantEnv;
	}

	/**
	 * @return the page
	 */
	public ExtensiblePage getPage() {
		return page;
	}
	
	public String getUri() {
		return uri;
	}
	
	/**
	 * @return the webAddress
	 */
	public WebAddress getWebAddress() {
		return webAddress;
	}

	public AppManifest getAppManifest() {
		return appManifest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageRuleContext ["
				+ (clientId != null ? "clientId=" + clientId + ", " : "")
				+ (tenantId != null ? "tenantId=" + tenantId + ", " : "")
				+ (tenantEnv != null ? "tenantEnv=" + tenantEnv + ", " : "")
				+ (page != null ? "page=" + page + ", " : "")
				+ (uri != null ? "uri=" + uri : "") + "]";
	}
	
}