package org.soluvas.web.login;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * @author haidar
 *
 */
@Service("twitterMgr") @Lazy
public class TwitterManagerImpl implements TwitterManager  {

	private final String consumerKey;
	private final String consumerSecret;
	
	@Inject
	public TwitterManagerImpl(
			@Value("#{soluvasProps.authTwitterConsumerKey}") String consumerKey,
			@Value("#{soluvasProps.authTwitterConsumerSecret}") String consumerSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	@Override
	public Twitter createTwitter() {
		final Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		return twitter;
	}

	@Override
	public Twitter createTwitter(String accessToken, String accessTokenSecret) {
		final Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
		return twitter;
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
//	String redirectUri = "http://www.berbatik5.haidar.dev/fb_recipient/";
//	UUID state = UUID.randomUUID();
//	String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";

}
