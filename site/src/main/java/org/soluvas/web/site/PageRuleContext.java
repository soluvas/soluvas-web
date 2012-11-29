package org.soluvas.web.site;

public class PageRuleContext {
	private final String clientId;
	private final String tenantId;
	private final String tenantEnv;
	private final org.apache.wicket.Page page;
	private final String uri;
	
	/**
	 * @param clientId
	 * @param tenantId
	 * @param tenantEnv
	 * @param page
	 * @param uri
	 */
	public PageRuleContext(String clientId, String tenantId, String tenantEnv,
			org.apache.wicket.Page page, String uri) {
		super();
		this.clientId = clientId;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
		this.page = page;
		this.uri = uri;
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
	public org.apache.wicket.Page getPage() {
		return page;
	}
	
	public String getUri() {
		return uri;
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