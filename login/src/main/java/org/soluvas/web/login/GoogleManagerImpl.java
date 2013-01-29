/**
 * 
 */
package org.soluvas.web.login;

/**
 * @author haidar
 *
 */
public class GoogleManagerImpl implements GoogleManager {

	private final String clientId;
	private final String clientSecret;
	private final String apiKey;
	
	
	public GoogleManagerImpl(String clientId, String clientSecret, String apiKey) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.apiKey = apiKey;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.GoogleManager#getClientId()
	 */
	@Override
	public String getClientId() {
		return clientId;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.GoogleManager#getClientSecret()
	 */
	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.GoogleManager#getApiKey()
	 */
	@Override
	public String getApiKey() {
		return apiKey;
	}
	
	
	
	

}
