package com.example.jeedemo.domain;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/*import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/
import javax.validation.constraints.Size;

@Entity //przy tym cos mi sie sypie
@NamedQueries({ 
	@NamedQuery(name = "product.all", query = "Select p from Product p")
	//@NamedQuery(name = "addproduct", query = "INSERT INTO products('NAME', 'COUNT_PRODUCT', 'PRICE' ) VALUES (':product_name', :product_count, :product_price)"),
	//@NamedQuery(name = "deleteproduct", query = "DELETE FROM WHERE id = :product_id")
	
})
public class Product {
	
	private Long product_id;
	private int product_count = 0;
	private String product_name = "";
	private double product_price = 0.00;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	@Size(min = 2, max = 20)
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	
	
	/*private List<Car> cars = new ArrayList<Car>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Size(min = 2)
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	@Temporal(TemporalType.DATE)
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}*/
}