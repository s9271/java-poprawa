package com.example.jeedemo.service;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import com.example.jeedemo.domain.Car;
//import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Product;

@Stateless
public class ProductManager {

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked") //musi byc bo przy funkcji wyskakiwal error
	public List<Product> getAllProducts() {
		return em.createNamedQuery("product.all").getResultList();
	}
	
	public Query addProduct(Product product) {
		return em.createNamedQuery("addproduct")
				.setParameter("product_name",product.getProduct_name())
				.setParameter("product_count",product.getProduct_count())
				.setParameter("product_price",product.getProduct_price());
	}
	
	public Query deleteProduct(Product product) {
		return em.createNamedQuery("addproduct")
				.setParameter("product_id",product.getProduct_id());
	}
	
	/*public void addProduct(Product product) {
		product.setId(null);
		em.persist(product);
	}*/
	
	/*public void deleteProduct(Product product) {
		product = em.find(Product.class, product.getProduct_id());
		em.remove(product);
	}*/

	/*public void addPerson(Person person) {
		person.setId(null);
		em.persist(person);
	}

	public void deletePerson(Person person) {
		person = em.find(Person.class, person.getId());
		em.remove(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return em.createNamedQuery("person.all").getResultList();
	}

	public List<Car> getOwnedCars(Person person) {
		person = em.find(Person.class, person.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Car> cars = new ArrayList<Car>(person.getCars());
		return cars;
	}*/

}
