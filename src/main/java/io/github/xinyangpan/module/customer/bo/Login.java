package io.github.xinyangpan.module.customer.bo;

import javax.validation.constraints.NotNull;

public class Login {
	@NotNull
	private String login;
	@NotNull
	private String rawPassword;

	public Login() {
	}

	public Login(String login, String rawPassword) {
		this.login = login;
		this.rawPassword = rawPassword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [login=");
		builder.append(login);
		builder.append(", rawPassword=");
		builder.append(rawPassword);
		builder.append("]");
		return builder.toString();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String password) {
		this.rawPassword = password;
	}
	
}
