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

	@Inject
	private UserManager um;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}
