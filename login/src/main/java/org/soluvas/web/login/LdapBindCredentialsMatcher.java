package org.soluvas.web.login;

import java.io.IOException;

import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.shared.ldap.model.exception.LdapAuthenticationException;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.apache.directory.shared.ldap.model.name.Rdn;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	public LdapBindCredentialsMatcher(LdapConnectionConfig ldapConfig,
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
		if (token instanceof UsernamePasswordToken) {
			final LdapNetworkConnection conn = new LdapNetworkConnection(
					ldapConfig);
			try {
				final Dn userDn = new Dn(new Rdn("uid",
						((UsernamePasswordToken) token).getUsername()), new Dn(
						usersDn));
				if (!conn.connect())
					throw new RuntimeException("Cannot connect to LDAP Server "
							+ ldapConfig.getLdapHost());
				conn.bind(userDn, String
						.valueOf(((UsernamePasswordToken) token).getPassword()));
				return true;
			} catch (LdapAuthenticationException e) {
				log.debug(
						"Invalid credentials supplied for "
								+ token.getPrincipal(), e);
				return false;
			} catch (Exception e) {
				log.error(
						"Error authenticating to LDAP Server "
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
		} else {
			log.error("Unsupported AuthenticationToken: {} using {}",
					token.getClass(), token.getPrincipal());
			throw new RuntimeException("Unsupported AuthenticationToken: "
					+ token.getClass() + " using " + token.getPrincipal());
		}
	}

}
