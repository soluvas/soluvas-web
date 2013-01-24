/**
 * 
 */
package org.soluvas.web.login;


/**
 * @author haidar
 *
 */
public class TwitterManagerImpl implements TwitterManager  {

	private final String consumerKey;
	private final String consumerSecret;
	
	public TwitterManagerImpl(String consumerKey, String consumerSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.login.FacebookManager#getAppId()
	 */
	@Override
	public String getConsumerKey() {
		return consumerKey;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.login.FacebookManager#getAppSecret()
	 */
	@Override
	public String getConsumerSecret() {
		return consumerSecret;
	}
	
	
	
	
//	String appId = "260800077384280";
//	String appSecret = "21f77dcd8501b12354b889ff32f96fad";
//	String redirectUri = "http://www.berbatik5.haidar.dev/fb_recipient/";
//	UUID state = UUID.randomUUID();
//	String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";

}
