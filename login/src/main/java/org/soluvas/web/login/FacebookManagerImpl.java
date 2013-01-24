/**
 * 
 */
package org.soluvas.web.login;


/**
 * @author haidar
 *
 */
public class FacebookManagerImpl implements FacebookManager  {

	private final String appId;
	private final String appSecret;
	
	public FacebookManagerImpl(String appId, String appSecret) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.login.FacebookManager#getAppId()
	 */
	@Override
	public String getAppId() {
		return appId;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.login.FacebookManager#getAppSecret()
	 */
	@Override
	public String getAppSecret() {
		return appSecret;
	}
	
	
	
	
//	String appId = "260800077384280";
//	String appSecret = "21f77dcd8501b12354b889ff32f96fad";
//	String redirectUri = "http://www.berbatik5.haidar.dev/fb_recipient/";
//	UUID state = UUID.randomUUID();
//	String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";

}
