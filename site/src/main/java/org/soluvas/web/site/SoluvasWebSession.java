package org.soluvas.web.site;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class SoluvasWebSession extends WebSession {

	@Deprecated
	private String userId;
	private String twitterRequestToken;
	private String twitterRequestTokenSecret;
	private Url originalUrl;
	
	public SoluvasWebSession(Request request) {
		super(request);
	}
	
	@Deprecated
	public String getUserId() {
		return userId;
	}

	@Deprecated
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getTwitterRequestToken() {
		return twitterRequestToken;
	}

	public void setTwitterRequestToken(String twitterRequestToken) {
		this.twitterRequestToken = twitterRequestToken;
	}
	
	public String getTwitterRequestTokenSecret() {
		return twitterRequestTokenSecret;
	}

	public void setTwitterRequestTokenSecret(String twitterRequestTokenSecret) {
		this.twitterRequestTokenSecret = twitterRequestTokenSecret;
	}
	
	public Url getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(Url originalUrl) {
		this.originalUrl = originalUrl;
	}

	@Override
	public String toString() {
		return String.format("SoluvasWebSession [userId=%s]", userId);
	}

}
