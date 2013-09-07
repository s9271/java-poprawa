package com.example.jeedemo.admin;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("AuthenticationBean")
public class AuthenticationBean implements Serializable {
	private static final long serialVersionUID = 1L; // potrzebne do sesji

	static boolean zalogowany = false;

	// przy zmianie loginu/hasla nalezy zresetowac server
	private String admin_login = "admin";
	private String admin_password = "test";
	private String name;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLoggedIn() {
		if (zalogowany == false) {
			return false;
		} else {
			return true;
		}
	}

	public String login() {
		if (name.equals(admin_login) && password.equals(admin_password)) {
			zalogowany = true;
		}
		return "/home";
	}
	
	public String fastlogin() {
		zalogowany = true;
		return "/home";
	}

	public String logout() {
		zalogowany = false;
		return "/home";
	}
}
