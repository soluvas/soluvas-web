package org.soluvas.web.site;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.Person;
import org.soluvas.commons.config.DefaultsConfig;
import org.soluvas.commons.locale.LocaleContext;
import org.soluvas.data.person.PersonRepository;
import org.springframework.beans.factory.BeanCreationException;

/**
 * @author ceefour
 *
 */
public class SoluvasWebSession extends WebSession {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory
		.getLogger(SoluvasWebSession.class);
	@Deprecated
	private String userId;
	private String twitterRequestToken;
	private String twitterRequestTokenSecret;
	private Url originalUrl;
	private boolean tokenFlow;
	/**
	 * Used by token flow authentication.
	 */
	private String redirectUri;
	/**
	 * Used by token flow. Won't work with {@link Person}.
	 */
	@SpringBean
	private PersonRepository personRepo;
	@SpringBean(required=false)
	private AppManifest appManifest;
	@SpringBean
	private DefaultsConfig defaultsConfig;
	
	public SoluvasWebSession(Request request) {
		super(request);
		Injector.get().inject(this);
		try {
			setLocale(appManifest.getDefaultLocale());
			if (getClientInfo().getProperties().getTimeZone() == null) {
				getClientInfo().getProperties().setTimeZone(appManifest.getDefaultTimeZone().toTimeZone());
			}
		} catch (BeanCreationException e) {
			log.debug("Using application defaults, we're probably not in tenant page", e);
			setLocale(defaultsConfig.getDefaultLocale());
			if (getClientInfo().getProperties().getTimeZone() == null) {
				getClientInfo().getProperties().setTimeZone(defaultsConfig.getDefaultTimeZone().toTimeZone());
			}
		} catch (NullPointerException e) {
			throw new IllegalStateException("appManifest bean is required, please configure MultiTenantWebConfig/SingleTenantWebConfig properly");
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
	
	public boolean isTokenFlow() {
		return tokenFlow;
	}

	public void setTokenFlow(boolean tokenFlow) {
		this.tokenFlow = tokenFlow;
	}
	
	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	/**
	 * Login handlers and recipient pages (Facebook, Twitter, token)
	 * should call this method after login is successful ({@link Subject#getPrincipal()} is properly set).
	 * It will redirect either to:
	 * <ol>
	 * 	<li>{@link TokenRecipientPage}, if {@link #isTokenFlow()} != {@code true}</li>
	 * 	<li>{@link #getOriginalUrl()}, if set</li>
	 *  <li>{@link WebApplication#getHomePage()} otherwise</li>
	 * </ol>
	 */
	public void postLoginSuccess() {
		final RequestCycle requestCycle = RequestCycle.get();
		if (isTokenFlow()) {
			// get or create access token
			final Person person = personRepo.findOne((String) SecurityUtils.getSubject().getPrincipal());
			if (person.getClientAccessToken() == null) {
				person.setClientAccessToken(UUID.randomUUID().toString());
				personRepo.modify(person.getId(), person);
			}
			
//			final Url relativeUrl = requestCycle.mapUrlFor(TokenRecipientPage.class, new PageParameters());
//			final String destUri = requestCycle.getRequest().getFilterPath() + "/" + relativeUrl.toString() + 
//					"#access_token=" + person.getClientAccessToken();
//			final String destUri = "about:blank" +"#access_token=" + person.getClientAccessToken();
			final String destUri = getRedirectUri()  +"#access_token=" + person.getClientAccessToken();
			setTokenFlow(false);
			setRedirectUri(null);
			log.debug("Redirecting to token recipient page: {}", destUri);
			throw new RedirectToUrlException(destUri);
		} else if (getOriginalUrl() != null) {
//			final String redirectUri = new RedirectByUserType(mallManager, webAddress, shopRepo, personLookup).apply(personId);
			final String destUri = requestCycle.getRequest().getContextPath() + "/" + getOriginalUrl().toString();
			setOriginalUrl(null);
			log.debug("Session has originalUrl, redirecting to {}", destUri);
			throw new RedirectToUrlException(destUri);
		} else {
			// If Regular User
			final Class<? extends Page> homePage = getApplication().getHomePage();
//			RedirectByUserTyperType;
			
			log.debug("Session has no original URI, redirecting to {}", homePage.getName()); 
			throw new RestartResponseException(homePage);
		}
	}
	
}
