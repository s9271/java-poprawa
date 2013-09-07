package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "order.all", query = "Select p from Cart p"),
		@NamedQuery(name = "productnot.all", query = "Select p from Product p where p.product_id not in(Select c.product_id from Cart c)"),
		@NamedQuery(name = "countproduct.all", query = "Select count(c) from Cart c where user_id=:user"),
		@NamedQuery(name = "productin.all", query = "Select p from Product p, Cart c where p.product_id = c.product_id"),
		@NamedQuery(name = "productfromcart.all", query = "Select c.id from Cart c where c.product_id=:product") })
public class Cart {

	private Long id;
	private Long product_id;
	private Long user_id;
	private int countProduct;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public int getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}