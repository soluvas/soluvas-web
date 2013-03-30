package org.soluvas.web.login;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author haidar
 *
 */
@Service("googleMgr") @Lazy
public class GoogleManagerImpl implements GoogleManager {

	private final String clientId;
	private final String clientSecret;
	private final String apiKey;
	
	@Inject
	public GoogleManagerImpl(
			@Value("#{soluvasProps.authGoogleClientId}") String clientId,
			@Value("#{soluvasProps.authGoogleClientSecret}") String clientSecret,
			@Value("#{soluvasProps.authGoogleApiKey}") String apiKey) {
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
