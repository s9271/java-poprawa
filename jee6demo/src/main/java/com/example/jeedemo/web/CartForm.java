package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Cart;
import com.example.jeedemo.domain.Product;
import com.example.jeedemo.service.CartManager;

@SessionScoped
@Named("CartForm")
public class CartForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private ListDataModel<Product> products = new ListDataModel<Product>();
	private Cart cart = new Cart();
	private Long countCart = (long) 0;

	@Inject
	private CartManager ct;

	public ListDataModel<Product> getAllProducts() {
		products.setWrappedData(ct.getAllProducts());
		return products;
	}

	public ListDataModel<Product> getAllProductsInCart() {
		products.setWrappedData(ct.getAllProductsInCart());
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
		setCountCart(ct.countProductInCart());
		return "null";
	}

	public String cartDeleteProduct() {
		Product productDeleteFromCart = products.getRowData();
		ct.cartDeleteProduct(productDeleteFromCart);
		setCountCart(ct.countProductInCart());
		return "null";
	}
	
	public boolean isCountIn() {
		if (countCart < 1) {
			return false;
		} else {
			return true;
		}
	}
}
