package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.User;

@Stateless
public class UserManager {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	// musi byc bo przy funkcji wyskakiwal error
	public List<User> getAllUsers() {
		return em.createNamedQuery("user.all").getResultList();
	}

	public void addUser(User user) {
		user.setId(null);
		em.persist(user);
	}

	public void deleteUser(User user) {
		user = em.find(User.class, user.getId());
		em.remove(user);
	}

	public void clearUser(User user) {
		user.setLogin("");
		user.setMail("");
		user.setName("");
		user.setPassword("");
		user.setPhone(null);
	}

	public void editUser(User user) {
		em.merge(user);
	}
}
