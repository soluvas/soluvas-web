package org.soluvas.web.login;

/** 
 * Get Client ID , Client Secret and API Key
 * @author haidar
 *
 */
public interface GoogleManager {
	
	public abstract String getClientId();
	
	public abstract String getClientSecret();
	
	public abstract String getApiKey();
	
}
