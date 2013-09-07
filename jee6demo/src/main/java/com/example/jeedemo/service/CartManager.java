package com.example.jeedemo.service;

//import java.util.ArrayList;
//import java.util.List;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Cart;
import com.example.jeedemo.domain.User;
//import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Product;

@Stateless
public class CartManager {
	private Cart cart = new Cart();
	private User user = new User();

	@PersistenceContext
	EntityManager em;
	
	public void addToCart(Product product) {
		user.setId((long) 1); //dla testow
		cart.setId(null);
		cart.setProduct_id(product.getProduct_id());
		cart.setUser_id(user.getId());
		cart.setCountProduct(1);
		em.persist(cart);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return em.createNamedQuery("productnot.all").getResultList();
	}
	
	public Long countProductInCart() {
		return (Long) em.createNamedQuery("countproduct.all")
				.setParameter("user", user.getId()).getSingleResult();
	}
	
	

	/*@SuppressWarnings("unchecked")
	// musi byc bo przy funkcji wyskakiwal error
	public List<Product> getAllProducts() {
		return em.createNamedQuery("product.all").getResultList();
	}

	public void addProduct(Product product) {
		product.setProduct_id(null);
		em.persist(product);
	}

	public void deleteProduct(Product product) {
		product = em.find(Product.class, product.getProduct_id());
		em.remove(product);
	}

	public void clearProduct(Product product) {
		product.setProduct_name("");
		product.setProduct_price(0);
		product.setProduct_count(0);
	}

	public void editProduct(Product product) {
		em.merge(product);
	}*/
	
	/*public List<Product> getCartProduct(Cart cart) {
		cart = em.find(Cart.class, cart.getCart_id());
		// lazy loading here - try this code without this (shallow) copying
		List<Product> products = new ArrayList<Product>(cart.getProducts());
		return products;
	}*/
}
