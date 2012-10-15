package org.soluvas.web.site;

public class PageRuleContext {
	private String clientId;
	private String tenantId;
	private String tenantEnv;
	private String uri;
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantEnv() {
		return tenantEnv;
	}

	public void setTenantEnv(String tenantEnv) {
		this.tenantEnv = tenantEnv;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Context [clientId=" + clientId + ", tenantId=" + tenantId
				+ ", tenantEnv=" + tenantEnv + ", uri=" + uri + "]";
	}
	
}