package com.cg.oms.beans;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "product_info")
@Component("product")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	@Column(name = "product_name")
	private String productName;
	private String category;
	private int quantity;
	private double price;
	private String description;

	@Column(name = "search_keyword")
	private String searchKeyword;

	// for product images
	@Lob
	private byte[] image1;
	@Lob
	private byte[] image2;
	@Lob
	private byte[] image3;

	// @OneToMany(cascade=CascadeType.ALL)
	// @JoinColumn(name="product_id")
	// private List<Order> order;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product1_id")
	private List<Cart> cart1;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product2_id")
	private List<Cart> cart2;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product3_id")
	private List<Cart> cart3;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public byte[] getImage3() {
		return image3;
	}

	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}

	// public List<Order> getOrder() {
	// return order;
	// }
	//
	// public void setOrder(List<Order> order) {
	// this.order = order;
	// }

	public List<Cart> getCart1() {
		return cart1;
	}

	public void setCart1(List<Cart> cart1) {
		this.cart1 = cart1;
	}

	public List<Cart> getCart2() {
		return cart2;
	}

	public void setCart2(List<Cart> cart2) {
		this.cart2 = cart2;
	}

	public List<Cart> getCart3() {
		return cart3;
	}

	public void setCart3(List<Cart> cart3) {
		this.cart3 = cart3;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", quantity=" + quantity + ", price=" + price + ", description=" + description + ", searchKeyword="
				+ searchKeyword + ", image1=" + Arrays.toString(image1) + ", image2=" + Arrays.toString(image2)
				+ ", image3=" + Arrays.toString(image3) + ", cart1=" + cart1 + ", cart2=" + cart2 + ", cart3=" + cart3
				+ "]";
	}

}
