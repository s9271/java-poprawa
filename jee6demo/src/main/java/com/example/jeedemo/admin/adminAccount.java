package com.example.jeedemo.admin;

public class adminAccount{
	private String login = "admin";
	private String password = "test";
	
	public adminAccount (String login, String password){
		this.login = login;
		this.password = password;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public String getPassword(){
		return this.password;
	}
}
