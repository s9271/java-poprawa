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
	
	private ListDataModel<Product> cartProduct = new ListDataModel<Product>();
	private Cart cartToShow = new Cart();
	
	@Inject
	private CartManager ct;
	
	@Inject
	private ProductManager pt;
	
	public ListDataModel<Product> getCartProduct() {
		cartProduct.setWrappedData(ct.getCartProduct(cartToShow));
		return cartProduct;
	}
	
	public ListDataModel<Product> getAllProducts() {
		cartProduct.setWrappedData(pt.getAllProducts());
		return cartProduct;
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
