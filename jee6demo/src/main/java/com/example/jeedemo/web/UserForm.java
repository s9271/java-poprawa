package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.User;
import com.example.jeedemo.service.UserManager;

@SessionScoped
@Named("UserForm")
public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();
	private ListDataModel<User> users = new ListDataModel<User>();

	// zmienic na false !!! (true tylko przy testach)
	static boolean logged = false;
	private String loginForm;
	private String passwordForm;
	private Long loginCount;

	@Inject
	private UserManager um;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(String loginForm) {
		this.loginForm = loginForm;
	}

	public String getPasswordForm() {
		return passwordForm;
	}

	public void setPasswordForm(String passwordForm) {
		this.passwordForm = passwordForm;
	}

	public ListDataModel<User> getAllUsers() {
		users.setWrappedData(um.getAllUsers());
		return users;
	}

	public String addUser() {
		um.addUser(user);
		um.clearUser(user);
		return "adminShowUsers";
	}

	public String deleteUser() {
		User userToDelete = users.getRowData();
		um.deleteUser(userToDelete);
		return null;
	}

	public String editUser() {
		um.editUser(user);
		return "adminShowUsers";
	}

	public String showUserDetails() {
		user = users.getRowData();
		return "adminEditUser";
	}

	// potrzebny "is" na poczatku aby metoda byla pobierana bez koniecznosci
	// robienia zmiennej
	public boolean isLoggedIn() {
		if (logged == false) {
			return false;
		} else {
			return true;
		}
	}

	public String login() {
		loginCount = um.searchUser(loginForm, passwordForm);

		if (loginCount == 1) {
			user.setId(um.getUserId(loginForm, passwordForm));
			logged = true;
			return "/home";
		} else {
			return "null";
		}
	}

	public String fastlogin() {
		user.setId((long) 1);
		logged = true;
		return "/home";
	}

	public String logout() {
		logged = false;
		return "/home";
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}
}
