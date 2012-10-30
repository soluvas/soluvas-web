package org.soluvas.web.login;

import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.apache.directory.shared.ldap.model.name.Rdn;
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
import org.soluvas.ldap.LdapUtils;

import com.google.common.base.Function;

/**
 * A realm implementation that uses LDAP repository.
 * 
 * It does not extend {@link AbstractLdapRealm} (it uses Apache Directory API).
 * 
 * @author ceefour
 */
public class SoluvasRealm extends AuthorizingRealm {

	private transient Logger log = LoggerFactory.getLogger(SoluvasRealm.class);

	/**
	 * {@link LdapConnection} pool which full access used to read entries.
	 */
	private final ObjectPool<LdapConnection> ldapPool;
	/**
	 * (Context) Entry which acts as the root of the application.
	 */
	private final String domainBase;
	/**
	 * Entry which contains the <tt>person</tt> entries, relative to
	 * <tt>domainBase</tt>.
	 */
	private final String usersRdn = "ou=users";
	/**
	 * Entry which contains the <tt>groupOfUniqueNames</tt> entries, relative to
	 * <tt>domainBase</tt>. These will be mapped to Shiro roles.
	 */
	private final String groupsRdn = "ou=groups";

	/**
	 * 
	 * @param ldapPool
	 * @param domainBase
	 * @param bindConfig
	 *            LDAP configuration used to perform bind-based authentication.
	 */
	public SoluvasRealm(final ObjectPool<LdapConnection> ldapPool,
			String domainBase, LdapConnectionConfig bindConfig) {
		super();
		this.ldapPool = ldapPool;
		this.domainBase = domainBase;
		setName(domainBase);
		CredentialsMatcher cm = new LdapBindCredentialsMatcher(bindConfig,
				usersRdn + "," + domainBase);
		setCredentialsMatcher(cm);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		final String userName = (String) principalCollection.getPrimaryPrincipal();
		AuthorizationInfo info = LdapUtils.withConnection(ldapPool, new Function<LdapConnection, AuthorizationInfo>() {
			@Override @Nullable
			public AuthorizationInfo apply(@Nullable LdapConnection ldap) {
						try {
							final Dn userDn = new Dn(new Rdn("uid", userName),
									new Dn(usersRdn, domainBase));
							final Dn groupsDn = new Dn(groupsRdn, domainBase);
							Set<String> roles = LdapUtils.transformSet(
									ldap.search(groupsDn, "(uniqueMember="
											+ userDn.getName() + ")",
											SearchScope.ONELEVEL),
									new Function<Entry, String>() {
										@Override
										@Nullable
										public String apply(
												@Nullable Entry input) {
											return input.getDn().getRdn()
													.getValue().getString();
										}
									});
							log.debug("User {} has {} roles: {}", userName,
									roles.size(), roles);
							SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
							info.addRoles(roles);

							// TODO: permissions should be set somewhere else,
							// using EMF models
							if (roles.contains("admin")) {
								info.addStringPermission("mall:*:*");
								info.addStringPermission("shop:*:*");
								info.addStringPermission("product:*:*");
								info.addStringPermission("person:*:*");
								info.addStringPermission("comment:*:*");
								info.addStringPermission("story:*:*");
								info.addStringPermission("like:*:*");
								info.addStringPermission("salesorder:*:*");
							}

							// TODO: resource-level roles

							return info;
						} catch (Exception e) {
							log.error("Cannot get authorization info for "
									+ userName, e);
							throw new RuntimeException(
									"Cannot get authorization info for "
											+ userName, e);
				}
			}
		});
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
