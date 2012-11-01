package org.soluvas.web.login;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.ldap.AbstractLdapRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.Permission;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
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

	/**
	 * 
	 * @param ldapPool
	 * @param domainBase
	 * @param bindConfig
	 *            LDAP configuration used to perform bind-based authentication.
	 */
	public SoluvasRealm(Supplier<SecurityCatalog> securityCatalogSupplier,
			SecurityRepository securityRepo) {
		super();
		this.securityCatalogSupplier = securityCatalogSupplier;
		this.securityRepo = securityRepo;
		setName(securityRepo.getDomainBase());
		CredentialsMatcher cm = new LdapBindCredentialsMatcher(securityRepo.getBindConfig(),
				securityRepo.getUsersRdn() + "," + securityRepo.getDomainBase());
		setCredentialsMatcher(cm);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			final PrincipalCollection principalCollection) {
		final String userName = (String) principalCollection.getPrimaryPrincipal();
		final Set<String> ldapRoles = securityRepo.getPersonRoles(userName);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(ldapRoles);

		// TODO: permissions should be set somewhere else,
		// using EMF models

		SecurityCatalog securityCatalog = securityCatalogSupplier.get();
		log.debug(
				"Processing security catalog for {} with {} roles, {} domains, {} actions, and {} permissions",
				userName, securityCatalog.getRoles().size(), securityCatalog
						.getDomains().size(), securityCatalog.getActions()
						.size(), securityCatalog.getPermissions().size());

		for (Role role : securityCatalog.getRoles()) {
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

		for (Permission perm : securityCatalog.getPermissions()) {
			Set<String> intersectingRoles = Sets.intersection(info.getRoles(),
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
			AuthenticationToken authToken) throws AuthenticationException {
		String userName = (String) authToken.getPrincipal();
		return new SimpleAuthenticationInfo(userName.toLowerCase(), null,
				getName());
	}

}
