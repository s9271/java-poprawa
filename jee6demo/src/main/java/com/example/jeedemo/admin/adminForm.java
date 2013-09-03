package com.example.jeedemo.admin;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
//import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named("adminForm")
public class adminForm implements Serializable{
	private static final long serialVersionUID = 1L; //ni uja nie wiem co to
	private String loginForm = "admin";
	private String passwordForm = "test";
	private String login;
	private String password;	
	private String test;

	
	/*private adminAccount adminAccount = new adminAccount();
	
	public adminAccount getadminAccount() {
		return adminAccount;
	}
	public void setadminAccount(adminAccount adminAccount) {
		this.adminAccount = adminAccount;
	}*/
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	//Akcje
	public String signin() {
		if(this.loginForm.equals(login) && this.passwordForm.equals(password)){
			setTest("zalogowano");
			return "showPersons";
		}else{
			setTest("dupa");
			return null;
		}
	}

	
}