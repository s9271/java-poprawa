package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
// bez klasy UserManager wyskakuje blad
@NamedQueries({ @NamedQuery(name = "user.all", query = "Select p from User p") })
public class User {

	private Long id;
	private String name;
	private String surname;
	private String mail;
	private String phone;
	private String login;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(min = 2, max = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(min = 2, max = 20)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Size(min = 2, max = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Size(min = 2, max = 20)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Size(min = 2, max = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}