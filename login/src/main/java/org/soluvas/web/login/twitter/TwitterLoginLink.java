package org.soluvas.web.login.twitter;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.web.login.LoginException;
import org.soluvas.web.login.TwitterManager;
import org.soluvas.web.login.TwitterRecipient;
import org.soluvas.web.site.SoluvasWebSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

@SuppressWarnings("serial")
public class TwitterLoginLink extends IndicatingAjaxLink<Void> {
			
	private static final Logger log = LoggerFactory
			.getLogger(TwitterLoginLink.class);
	
	@SpringBean(name="twitterMgr")
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
	public void onClick(AjaxRequestTarget target) {
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