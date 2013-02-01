package org.soluvas.web.login;

import java.util.List;
import java.util.Set;

import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.ldap.AbstractLdapRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.LdapUtils;
import org.soluvas.security.Permission;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * A realm implementation that uses LDAP repository.
 * 
 * It does not extend {@link AbstractLdapRealm} (it uses Apache Directory API).
 * 
 * @author ceefour
 */
public class SoluvasRealm extends AuthorizingRealm {

	transient Logger log = LoggerFactory.getLogger(SoluvasRealm.class);

	private final Supplier<SecurityCatalog> securityCatalogSupplier;
	private final SecurityRepository securityRepo;

	private final String usersDn;

	/**
	 * 
	 * @param securityCatalogSupplier Why not generics? See https://issues.apache.org/jira/browse/ARIES-960
	 * @param securityRepo
	 */
	public SoluvasRealm(Supplier securityCatalogSupplier,
			SecurityRepository securityRepo) {
		super();
		this.securityCatalogSupplier = securityCatalogSupplier;
		this.securityRepo = securityRepo;
		setName(securityRepo.getDomainBase());
		usersDn = securityRepo.getUsersRdn() + "," + securityRepo.getDomainBase();
		final CredentialsMatcher cm = new LdapBindCredentialsMatcher(securityRepo.getBindConfig(),
				usersDn);
		setCredentialsMatcher(cm);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			final PrincipalCollection principalCollection) {
		final String userName = (String) principalCollection.getPrimaryPrincipal();
		final Set<String> ldapRoles = securityRepo.getPersonRoles(userName);

		final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(ldapRoles);

		// TODO: permissions should be set somewhere else,
		// using EMF models

		final SecurityCatalog securityCatalog = securityCatalogSupplier.get();
		log.debug(
				"Processing security catalog for {} with {} roles, {} domains, {} actions, and {} permissions",
				userName, securityCatalog.getRoles().size(), securityCatalog
						.getDomains().size(), securityCatalog.getActions()
						.size(), securityCatalog.getPermissions().size());

		for (final Role role : securityCatalog.getRoles()) {
			switch (role.getAssignMode()) {
			case GUEST:
				log.debug("Assigning role {} to {} because assign mode {}",
						role.getName(), userName, role.getAssignMode());
				info.addRole(role.getName());
				break;
			case AUTHENTICATED:
				if (!principalCollection.isEmpty()) {
					log.debug(
							"Assigning role {} to {} because assign mode {} and principals={}",
							role.getName(), userName, role.getAssignMode(),
							principalCollection);
					info.addRole(role.getName());
				}
				break;
			case MANUAL:
				break;
			}
		}

		for (final Permission perm : securityCatalog.getPermissions()) {
			final Set<String> intersectingRoles = Sets.intersection(info.getRoles(),
					ImmutableSet.copyOf(perm.getRoles()));
			if (!intersectingRoles.isEmpty()) {
				log.debug("Assigning permission {} to {} due to role(s) {}",
						perm.toStringPermission(), userName, intersectingRoles);
				info.addStringPermission(perm.toStringPermission());
			}
		}

		// TODO: resource-level roles

		return info;
	}

	/**
	 * Always returns a {@link SimpleAuthenticationInfo} based on the principal
	 * (username).
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		final LdapConnectionConfig ldapConfig = securityRepo.getBindConfig();
		
		final String personId;
		
		if (token instanceof UsernamePasswordToken) {
			final String tokenUsername = ((UsernamePasswordToken) token).getUsername();
			if (tokenUsername != null && tokenUsername.contains("@")) {
				final LdapNetworkConnection conn = new LdapNetworkConnection(
						ldapConfig);
				try {
					Preconditions.checkState(conn.connect(),
							"Cannot connect to LDAP server %s", ldapConfig.getLdapHost());
					conn.bind();
					final String ldapFilter = "(&(mail=" + tokenUsername + ")(objectclass=person))";
					log.debug("Searching {} for {}", usersDn, ldapFilter);
					final List<Entry> users = LdapUtils.asList(conn.search(
							usersDn, ldapFilter, SearchScope.ONELEVEL, "uid"));
					if (users.size() != 1) {
						log.info("Found {} users matching email {}, expected 1", users.size(), tokenUsername);
						throw new AuthenticationException("No user matching email " + tokenUsername);
					}
					final Entry userEntry = Iterables.getOnlyElement(users);
					personId = userEntry.get("uid").getString();
					log.debug("User matching email {} is {}", tokenUsername, personId);
				} catch (Exception e) {
					throw new AuthenticationException("Cannot find user matching " + tokenUsername, e);
				}
			} else {
				personId = Strings.nullToEmpty(tokenUsername).toLowerCase();
			}
		} else {
			throw new AuthenticationException("Unsupported AuthenticationToken: "
					+ token.getClass() + " using " + token.getPrincipal());
		}
		
		return new SimpleAuthenticationInfo(personId, null, getName());
	}

}
