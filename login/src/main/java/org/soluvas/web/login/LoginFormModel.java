package org.soluvas.web.login;

import java.io.Serializable;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LoginFormModel implements Serializable {
	
	private String username;
	private String password;
	private Boolean rememberMe = false;

	public LoginFormModel() {
		super();
	}
	
	public LoginFormModel(String username, String password) {
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

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "LoginFormData [username=" + username + ", password=" + password
				+ ", rememberMe=" + rememberMe + "]";
	}
	
}
