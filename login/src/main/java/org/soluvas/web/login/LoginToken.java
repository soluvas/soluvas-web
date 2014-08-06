package org.soluvas.web.login;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.Form;

/**
 * Data to be submitted by a login {@link Form}.
 * @author ceefour
 */
public class LoginToken implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean rememberMe = false;

	public LoginToken() {
		super();
	}
	
	public LoginToken(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "LoginFormData [username=" + username + ", password=" + password
				+ ", rememberMe=" + rememberMe + "]";
	}
	
}
