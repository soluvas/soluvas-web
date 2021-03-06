package org.soluvas.web.site;

import java.util.Locale;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.core.request.handler.IPageRequestHandler;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.ClientProperties;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.DefaultsConfig;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.locale.LocaleContext;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.geo.Country;
import org.soluvas.geo.IpLocationRepository;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.base.Optional;

/**
 * To use it, override {@link WebApplication#newSession(Request, Response)}
 * to return an instance of {@link SoluvasWebSession}.
 * @author ceefour
 */
public class SoluvasWebSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = 1L;
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Deprecated
	protected String userId;
	protected String twitterRequestToken;
	protected String twitterRequestTokenSecret;
	protected Url originalUrl;
	protected boolean tokenFlow;
	/**
	 * Used by token flow authentication.
	 */
	protected String redirectUri;
	@SpringBean(required=false)
	protected AppManifest appManifest;
	@Inject
	protected DefaultsConfig defaultsConfig;
	@SpringBean(required=false) @Nullable // Bippo uses this, but other clients usually don't
	protected IpLocationRepository ipLocationRepo;
	
	public SoluvasWebSession(Request request) {
		super(request);
		Injector.get().inject(this);
		guessLocale();
	}

	/**
	 * @deprecated Hendy's note: We CANNOT access RequestCycle during constructor of WebSession!
	 * I think we can move this logic into RequestCycleListener instead.
	 */
	@Deprecated
	protected void guessLocale() {
		try {
			// FIXME: Hendy's note - we're breaking Wicket's contract here!
			// We CANNOT access RequestCycle during constructor of WebSession!
			final RequestCycle requestCycle = RequestCycle.get();
			@Nullable
			String localePrefId = null;
			if (requestCycle.getActiveRequestHandler() instanceof IPageRequestHandler) {
				final IPageRequestHandler pageHandler = (IPageRequestHandler) requestCycle.getActiveRequestHandler();
				if (pageHandler.isPageInstanceCreated()) {
					final PageParameters params = pageHandler.getPageParameters();
					if (params != null) {
						localePrefId = params.get(SeoBookmarkableMapper.LOCALE_PREF_ID_PARAMETER).toOptionalString();
					}
				}
			}

			final Locale locale;
			if (localePrefId != null) {
				if (SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.containsKey(localePrefId)) {
					locale = SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.get(localePrefId);
					log.debug("Locale pref id '{}' for locale: {}", localePrefId, locale.toLanguageTag());
				} else {
					final ClientProperties properties = getClientInfo().getProperties();
					if (ipLocationRepo != null) {
						final String remoteAddress = properties.getRemoteAddress();
						final Optional<Country> optCountry = ipLocationRepo.getCountryByIp(remoteAddress);
						if (optCountry.isPresent() && optCountry.get().getIso().equals("ID")) {
							locale = SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.get(SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID);
						} else {
//							locale = SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.get(SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_EN);
							locale = appManifest.getDefaultLocale();
						}
						log.warn(String.format("Locale pref id '%s' not supported. Locales have been supported are %s. So use get by ip '%s' --> country %s, it is %s",
								localePrefId, SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS, remoteAddress,
								optCountry.isPresent() ? optCountry.get() : null, locale.toLanguageTag()));
					} else {
						locale = appManifest.getDefaultLocale();
					}
				}
			} else {
				if (ipLocationRepo != null) {
					final ClientProperties properties = getClientInfo().getProperties();
					final String remoteAddress = properties.getRemoteAddress();
					final Optional<Country> optCountry = ipLocationRepo.getCountryByIp(remoteAddress);
					if (optCountry.isPresent() && optCountry.get().getIso().equals("ID")) {
						locale = SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.get("id");
					} else {
//						locale = SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.get("en");
						locale = appManifest.getDefaultLocale();
					}
					log.warn(String.format("Locale pref id is null. So use get by ip '%s' --> country %s, it is %s",
							remoteAddress, optCountry.isPresent() ? optCountry.get() : null, locale.toLanguageTag()));
				} else {
					locale = appManifest.getDefaultLocale();
				}
			}
			log.debug("Set locale to session: {}", locale.toLanguageTag());
			setLocale(locale);

			if (getClientInfo().getProperties().getTimeZone() == null) {
				getClientInfo().getProperties().setTimeZone(appManifest.getDefaultTimeZone().toTimeZone());
			}
		} catch (BeanCreationException e) {
			log.debug("Using application defaults, we're probably not in tenant page", e);
			setLocale(defaultsConfig.getDefaultLocale());
			if (getClientInfo().getProperties().getTimeZone() == null) {
				getClientInfo().getProperties().setTimeZone(defaultsConfig.getDefaultTimeZone().toTimeZone());
			}
		} /*catch (NullPointerException e) {
			throw new IllegalStateException("appManifest bean is required, please configure MultiTenantWebConfig/SingleTenantWebConfig properly");
		}*/
	}

	@Override
	public Roles getRoles() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean authenticate(String username, String password) {
		throw new UnsupportedOperationException("Please use SpringWebSession/ShiroWebSession if you want to use Wicket auth roles.");
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

	public WebApplicationContext getApplicationContext() {
		return WebApplicationContextUtils.getRequiredWebApplicationContext(
				((HttpServletRequest) RequestCycle.get().getRequest().getContainerRequest()).getServletContext() );
	}

	/**
	 * Will be called by {@link #postLoginSuccess()} before redirecting, you can override this.
	 */
	protected void beforeLoginSuccess() {
	}

	/**
	 * Login handlers and recipient pages (Facebook, Twitter, token)
	 * should call this method after login is successful ({@link Subject#getPrincipal()} is properly set).
	 * It will redirect either to:
	 * <ol>
	 * 	<li>{@link TokenRecipientPage}, if {@link #isTokenFlow()} != {@code true}</li>
	 * 	<li>{@link #getOriginalUrl()}, if set</li>
	 *  <li>{@link #getAfterLoginPage()} otherwise</li>
	 * </ol>
	 */
	public final void postLoginSuccess() {
		beforeLoginSuccess();
		log.trace("postLoginSuccess() will redirect to token or to original URI or to home page");
		if (isTokenFlow()) {
			// get or create access token
			// Used by token flow. Won't work with {@link Person}.
			// http://stackoverflow.com/a/9823467/1343587
			final PersonRepository personRepo = getApplicationContext().getBean(PersonRepository.class);
			final Person2 person = personRepo.findOne((String) SecurityUtils.getSubject().getPrincipal());
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
			final String destUri = RequestCycle.get().getRequest().getContextPath() + "/" + getOriginalUrl().toString();
			setOriginalUrl(null);
			log.debug("Session has originalUrl, redirecting to {}", destUri);
			throw new RedirectToUrlException(destUri);
		} else {
			// If Regular User
			final Class<? extends Page> homePage = getAfterLoginPage();
//			RedirectByUserTyperType;
			log.debug("Session has no original URI, redirecting to {}", homePage.getName());
			throw new RestartResponseException(homePage);
		}
	}

	/**
	 * Override this if your after login page is not {@link Application#getHomePage()}.
	 * @return
	 */
	public Class<? extends Page> getAfterLoginPage() {
		return getApplication().getHomePage();
	}
	
}
