package org.soluvas.web.login.twitter;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.twitter.TwitterManager;
import org.soluvas.web.login.LoginException;
import org.soluvas.web.login.TwitterRecipient;
import org.soluvas.web.site.SoluvasWebSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

import com.google.common.base.Strings;

@SuppressWarnings("serial")
public class TwitterLoginLink extends StatelessLink<Void> {
			
	private static final Logger log = LoggerFactory
			.getLogger(TwitterLoginLink.class);
	
	@SpringBean(name="twitterMgr", required=false)
	private TwitterManager twitterMgr;
	@SpringBean
	private WebAddress webAddress;

	private final Class<? extends Page> recipientPage;

	public TwitterLoginLink(String id) {
		this(id, TwitterRecipient.class);
	}

	public TwitterLoginLink(String id, Class<? extends Page> recipientPage) {
		super(id);
		this.recipientPage = recipientPage;
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		if (twitterMgr == null || Strings.isNullOrEmpty(twitterMgr.getAppAccessToken()) ||
				Strings.isNullOrEmpty(twitterMgr.getAppAccessTokenSecret())) {
			log.debug("Disabling Twitter login because appAccessToken/appAccessTokenSecret is empty");
			setVisible(false);
		}
	}

	@Override
	public void onClick() {
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