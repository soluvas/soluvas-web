package org.soluvas.web.site;

import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * https://codepitbull.wordpress.com/2013/07/31/using-spring-security-3-with-wicket-6-authroles-and-javaconfig-and-a-little-servlet-3/
 *
 * <p>Now we have to change the WebApplication to extend {@link org.apache.wicket.authroles.authentication.AuthenticatedWebApplication} and override
 * {@link AuthenticatedWebApplication#init()}, {@link AuthenticatedWebApplication#getWebSessionClass()} and
 * {@link AuthenticatedWebApplication#getSignInPageClass()}:</p>
 *
 * <pre>
 * Override
 * public void init() {
 *  super.init();
 *  getComponentInstantiationListeners().add(new SpringComponentInjector(this));
 *  getSecuritySettings().setAuthorizationStrategy(new AnnotationsRoleAuthorizationStrategy(this));
 *  mountPages();
 * }
 * </pre>
 *
 * <p>How to get {@link SecurityContextHolderAwareRequestWrapper} in Wicket:</p>
 *
 * <pre>
 * final SecurityContextHolderAwareRequestWrapper request = (SecurityContextHolderAwareRequestWrapper) getRequest().getContainerRequest();
 * </pre>
 *
 * Created by ceefour on 6/20/15.
 */
public class SpringWebSession extends SoluvasWebSession {

    public SpringWebSession(Request request) {
        super(request);
    }

    /**
     * Returns Spring Security's {@link Authentication} object.
     * @return
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public Roles getRoles() {
        final Roles roles = new Roles();
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities().forEach(it -> roles.add(it.getAuthority()));
        return roles;
    }

    @Override
    protected void guessLocale() {
        // not supported!
    }
}
