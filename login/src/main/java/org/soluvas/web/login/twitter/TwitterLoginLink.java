package org.soluvas.web.login.twitter;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.web.login.TwitterManager;
import org.soluvas.web.site.SoluvasWebSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

@SuppressWarnings("serial")
public class TwitterLoginLink extends IndicatingAjaxLink<Void> {
			
	private static final Logger log = LoggerFactory
			.getLogger(TwitterLoginLink.class);
	
	@PaxWicketBean(name="twitterMgr")
	private TwitterManager twitterMgr;
	@Inject @Supplied
	private WebAddress webAddress;

	public TwitterLoginLink(String id) {
		super(id);
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		/** just config test **/
		final String redirectUri = webAddress.getBaseUri() + "twitter_recipient/";
		final Twitter twitter = twitterMgr.createTwitter();
	    try {
	        final RequestToken requestToken = twitter.getOAuthRequestToken(redirectUri);
	        final SoluvasWebSession session = (SoluvasWebSession) getSession();
	        session.setTwitterRequestToken(requestToken.getToken());
	        session.setTwitterRequestTokenSecret(requestToken.getTokenSecret());
			log.debug("Twitter login uri {}", requestToken.getAuthenticationURL());
			throw new RedirectToUrlException(requestToken.getAuthenticationURL());
	    } catch (final TwitterException e) {
	        throw new  RuntimeException("Error when building a uri using consumerKey=" + twitterMgr.getConsumerKey() +
	        		" redirectUri=" + redirectUri, e);
	    }
	}

}