package com.cg.oms.beans;

public class OrderInfo {

	private int orderId;
	private int cartId;
	private String product1Name;
	private String product2Name;
	private String product3Name;
	private double totalPrice;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProduct1Name() {
		return product1Name;
	}

	public void setProduct1Name(String product1Name) {
		this.product1Name = product1Name;
	}

	public String getProduct2Name() {
		return product2Name;
	}

	public void setProduct2Name(String product2Name) {
		this.product2Name = product2Name;
	}

	public String getProduct3Name() {
		return product3Name;
	}

	public void setProduct3Name(String product3Name) {
		this.product3Name = product3Name;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", cartId=" + cartId + ", product1Name=" + product1Name
				+ ", product2Name=" + product2Name + ", product3Name=" + product3Name + ", totalPrice=" + totalPrice
				+ "]";
	}

}
