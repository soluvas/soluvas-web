package org.soluvas.web.login;

import java.io.IOException;

import org.apache.directory.api.ldap.model.exception.LdapAuthenticationException;
import org.apache.directory.api.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.api.ldap.model.name.Rdn;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * Match credentials using LDAP bind operation.
 * 
 * @author ceefour
 */
public class LdapBindCredentialsMatcher implements CredentialsMatcher {

	private static final Logger log = LoggerFactory
			.getLogger(LdapBindCredentialsMatcher.class);
	private final LdapConnectionConfig ldapConfig;
	private final String usersDn;

	public LdapBindCredentialsMatcher(final LdapConnectionConfig ldapConfig,
			String usersDn) {
		super();
		this.ldapConfig = ldapConfig;
		this.usersDn = usersDn;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.credential.CredentialsMatcher#doCredentialsMatch(org.apache.shiro.authc.AuthenticationToken, org.apache.shiro.authc.AuthenticationInfo)
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		final Dn userDn;
		final String personId = (String) info.getPrincipals().getPrimaryPrincipal();
		try {
			userDn = new Dn(new Rdn("uid", personId), new Dn(usersDn));
		} catch (LdapInvalidDnException e) {
			log.error("Cannot generate DN for " + personId, e);
			return false;
		}
		
		final LdapNetworkConnection conn = new LdapNetworkConnection(
				ldapConfig);
		try {
			Preconditions.checkState(conn.connect(),
					"Cannot connect to LDAP server %s", ldapConfig.getLdapHost());
			conn.bind(userDn, String
					.valueOf(((UsernamePasswordToken) token).getPassword()));
			return true;
		} catch (LdapAuthenticationException e) {
			log.info("Invalid credentials supplied for "
							+ token.getPrincipal(), e);
			return false;
		} catch (Exception e) {
			log.error("Error authenticating to LDAP Server "
							+ ldapConfig.getLdapHost() + " using "
							+ token.getPrincipal(), e);
			throw new RuntimeException(
					"Error authenticating to LDAP Server "
							+ ldapConfig.getLdapHost() + " using "
							+ token.getPrincipal(), e);
		} finally {
			if (conn.isConnected()) {
				try {
					conn.close();
				} catch (IOException e) {
					log.warn(
							"Cannot close LDAP connection to "
									+ ldapConfig.getLdapHost()
									+ " after authenticating "
									+ token.getPrincipal(), e);
				}
			}
		}
	}

}
