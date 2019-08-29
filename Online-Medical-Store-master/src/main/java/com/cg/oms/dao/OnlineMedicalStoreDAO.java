package com.cg.oms.dao;

import java.util.List;

import com.cg.oms.beans.Admin;
import com.cg.oms.beans.AdminMessage;
import com.cg.oms.beans.Cart;
import com.cg.oms.beans.Customer;
import com.cg.oms.beans.CustomerAddress;
import com.cg.oms.beans.CustomerMessage;
import com.cg.oms.beans.Order;
import com.cg.oms.beans.OrderInfo;
import com.cg.oms.beans.Product;

public interface OnlineMedicalStoreDAO {

	// Customer
	public Boolean registerCustomer(Customer customer);

	public Customer loginCustomer(int customerId, String password);

	public Boolean updateCustomer(Customer customer);

	public Boolean deleteCustomer(int customerId);

	public Boolean updatePassword(int customerId, String oldPassword, String newPassword);

	public Boolean addAddress(CustomerAddress address);

	public Boolean updateAddress(CustomerAddress address);

	// Admin
	public Admin adminLogin(int adminId, String password);

	// public Boolean deleteCustomer(int customerId);
	public List<Customer> getAllCustomer();

	public Customer searchCustomer(int customerId);

	public List<Product> getAllProduct();

	// Product
	public Product createProduct(Product product);

	public Product updateProduct(Product product);

	public Boolean deleteProduct(int productId);

	public Product searchProduct(int productId);

	public List<Product> searchProduct(String keyword);

	// Orders and Bill
	public Order placeOrder(int cartId);

	public Boolean cancelOrder(int orderId, int customerId);

	public Cart addToCart(int productId, int customerId);

	public Cart removeFromCart(int productId, int customerId);

	public Cart displayCart(int customerId);

	public Integer getCartAvailability(int customerId);

	public Cart updateCart(Cart cart);

	public List<OrderInfo> displayOrder(int customerId);

	public Cart searchCart(int cartId);

	// payment

	// Helpdesk
	// admin sec
	public Boolean sendMessageToCustomer(AdminMessage msg);

	public List<CustomerMessage> getCustomerMSG();

	// customer sec
	public Boolean sendMessageToAdmin(CustomerMessage msg);

	public List<AdminMessage> getAdminMSG(int customerId);

}
