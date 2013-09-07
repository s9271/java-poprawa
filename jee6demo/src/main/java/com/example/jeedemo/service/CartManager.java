package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Cart;
import com.example.jeedemo.domain.User;
import com.example.jeedemo.domain.Product;

@Stateless
public class CartManager {
	private Cart cart = new Cart();
	private User user = new User();

	@PersistenceContext
	EntityManager em;

	public void addToCart(Product product) {
		user.setId((long) 1); // dla testow
		cart.setId(null);
		cart.setProduct_id(product.getProduct_id());
		cart.setUser_id(user.getId());
		cart.setCountProduct(1);
		em.persist(cart);
	}

	public void cartDeleteProduct(Product product) {
		Object cart_id = em.createNamedQuery("productfromcart.all")
				.setParameter("product", product.getProduct_id())
				.getSingleResult();

		cart = em.find(Cart.class, cart_id);
		em.remove(cart);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return em.createNamedQuery("productnot.all").getResultList();
	}

	public Long countProductInCart() {
		return (Long) em.createNamedQuery("countproduct.all")
				.setParameter("user", user.getId()).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProductsInCart() {
		return em.createNamedQuery("productin.all").getResultList();
	}
}
