package org.soluvas.web.site;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class SoluvasWebSession extends WebSession {

	private String userId;
	private String twitterRequestToken;
	private String twitterRequestTokenSecret;
	
	public SoluvasWebSession(Request request) {
		super(request);
	}
	
	public String getUserId() {
		return userId;
	}

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

	@Override
	public String toString() {
		return String.format("SoluvasWebSession [userId=%s]", userId);
	}

}
