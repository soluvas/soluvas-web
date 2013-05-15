package org.soluvas.web.site;

import java.io.Serializable;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.web.site.pagemeta.PageMeta;

/**
 * General information about the current web page request. 
 * <p>Usages:
 * <ol>
 * 	<li>Passed to {@link PageMetaProvider#get(PageRuleContext)}
 * 		in order to provide a {@link PageMeta}.</li>
 * </ol>
 * @author ceefour
 */
public class PageRequestContext implements Serializable {
	/**
	 * First schema version.
	 */
	private static final long serialVersionUID = 1L;
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
	public PageRequestContext(final String clientId, final String tenantId, final String tenantEnv,
			final ExtensiblePage page, String uri, final WebAddress webAddress,
			final AppManifest appManifest) {
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