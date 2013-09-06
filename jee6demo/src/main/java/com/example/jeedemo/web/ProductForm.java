package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Product;
import com.example.jeedemo.service.ProductManager;

@SessionScoped
@Named("ProductForm")
public class ProductForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product = new Product();
	private ListDataModel<Product> products = new ListDataModel<Product>();

	@Inject
	private ProductManager pt;

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
	}
}
