package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Product;

@Stateless
public class ProductManager {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
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
	}
}
