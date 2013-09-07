package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

//import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Cart;
//import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Product;
import com.example.jeedemo.service.CartManager;
//import com.example.jeedemo.service.ProductManager;
import com.example.jeedemo.service.ProductManager;

@SessionScoped
@Named("CartForm")
public class CartForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ListDataModel<Product> products = new ListDataModel<Product>();
	//private Cart cartToShow = new Cart();
	private Cart cart = new Cart();
	//private Product product = new Product();
	private Long countCart = (long) 0;
	
	@Inject
	private CartManager ct;
	
	@Inject
	private ProductManager pt;
	
	public ListDataModel<Product> getAllProducts() {
		products.setWrappedData(ct.getAllProducts());
		return products;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Long getCountCart() {
		return countCart;
	}

	public void setCountCart(Long countCart) {
		this.countCart = countCart;
	}
	
	public String addToCart() {
		Product productToCart = products.getRowData();
		ct.addToCart(productToCart);
		countCart = ct.countProductInCart();
		return "null";
	}

	/*private Product product = new Product();
	private ListDataModel<Product> products = new ListDataModel<Product>();

	@Inject
	private CartManager ct;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ListDataModel<Product> getAllProducts() {
		products.setWrappedData(pt.getAllProducts());
		return products;
	}

	public String addProduct() {
		pt.addProduct(product);
		pt.clearProduct(product);
		return "adminShowProducts";
	}

	public String deleteProduct() {
		Product productToDelete = products.getRowData();
		pt.deleteProduct(productToDelete);
		return null;
	}

	public String editProduct() {
		pt.editProduct(product);
		return "adminShowProducts";
	}

	public String showProductDetails() {
		product = products.getRowData();
		return "adminEditProduct";
	}*/
}
