package org.soluvas.web.site;

import java.util.Locale;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.joda.time.DateTimeZone;
import org.soluvas.commons.locale.LocaleContext;

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
		// TODO: do not hardcode
		setLocale(Locale.forLanguageTag("id-ID"));
		if (getClientInfo().getProperties().getTimeZone() == null) {
			// TODO: do not hardcode
			getClientInfo().getProperties().setTimeZone(DateTimeZone.forID("Asia/Jakarta").toTimeZone());
		}
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
	
	public LocaleContext getLocaleContext() {
		// TODO: return actual settings
		return new LocaleContext();
	}
	
}
