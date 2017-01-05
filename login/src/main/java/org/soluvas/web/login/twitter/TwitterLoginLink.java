package org.soluvas.web.login.twitter;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.twitter.TwitterManager;
import org.soluvas.web.login.LoginException;
import org.soluvas.web.login.TwitterRecipient;
import org.soluvas.web.site.SoluvasWebSession;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

@SuppressWarnings("serial")
public class TwitterLoginLink extends StatelessLink<Void> {
			
	private static final Logger log = LoggerFactory
			.getLogger(TwitterLoginLink.class);
	
	@Autowired(required=false)
	private TwitterManager twitterMgr;
	@Autowired(required=false)
	private WebAddress webAddress;

	private final Class<? extends Page> recipientPage;

	public TwitterLoginLink(String id) {
		this(id, TwitterRecipient.class);
	}

	public TwitterLoginLink(String id, Class<? extends Page> recipientPage) {
		super(id);
		this.recipientPage = recipientPage;
		if (twitterMgr == null || Strings.isNullOrEmpty(twitterMgr.getAppAccessToken()) ||
				Strings.isNullOrEmpty(twitterMgr.getAppAccessTokenSecret())) {
			log.debug("Disabling Twitter login because appAccessToken/appAccessTokenSecret is empty");
			setVisible(false);
		}
	}
	
	@Override
	public void onClick() {
		Preconditions.checkNotNull(webAddress, "TwitterLoginLink requires webAddress");
//		final String redirectUri = webAddress.getBaseUri() + "twitter_recipient/";
		final String redirectUri = webAddress.getBaseUri() + 
				getRequestCycle().mapUrlFor(recipientPage, new PageParameters()).toString();
		final Twitter twitter = twitterMgr.createTwitter();
	    try {
	        final RequestToken requestToken = twitter.getOAuthRequestToken(redirectUri);
	        final SoluvasWebSession session = (SoluvasWebSession) getSession();
	        session.setTwitterRequestToken(requestToken.getToken());
	        session.setTwitterRequestTokenSecret(requestToken.getTokenSecret());
			log.trace("Twitter login uri {}", requestToken.getAuthenticationURL());
			throw new RedirectToUrlException(requestToken.getAuthenticationURL());
	    } catch (final TwitterException e) {
	        throw new LoginException("Error when building a uri using consumerKey=" + twitterMgr.getConsumerKey() +
	        		" redirectUri=" + redirectUri, e);
	    }
	}

}