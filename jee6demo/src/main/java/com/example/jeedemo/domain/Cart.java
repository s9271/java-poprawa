package com.example.jeedemo.domain;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*import javax.persistence.OneToMany;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;*/
//import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "order.all", query = "Select p from Cart p"),
		@NamedQuery(name = "productnot.all", query = "Select p from Product p where p.product_id not in(Select c.product_id from Cart c)"),
		@NamedQuery(name = "countproduct.all", query = "Select count(c) from Cart c where user_id=:user") })
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

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) public
	 * List<Product> getProducts() { return products; } public void
	 * setProducts(List<Product> products) { this.products = products; }
	 */

	/*
	 * private List<Car> cars = new ArrayList<Car>();
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) public Long getId() {
	 * return id; } public void setId(Long id) { this.id = id; }
	 * 
	 * @Size(min = 2, max = 20) public String getFirstName() { return firstName;
	 * } public void setFirstName(String firstName) { this.firstName =
	 * firstName; }
	 * 
	 * @Size(min = 2) public String getPin() { return pin; } public void
	 * setPin(String pin) { this.pin = pin; }
	 * 
	 * @Temporal(TemporalType.DATE) public Date getRegistrationDate() { return
	 * registrationDate; } public void setRegistrationDate(Date
	 * registrationDate) { this.registrationDate = registrationDate; }
	 * 
	 * // Be careful here, both with lazy and eager fetch type
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) public
	 * List<Car> getCars() { return cars; } public void setCars(List<Car> cars)
	 * { this.cars = cars; }
	 */
}