package com.cg.oms.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.cg.oms.beans.Admin;
import com.cg.oms.beans.AdminMessage;
import com.cg.oms.beans.Card;
import com.cg.oms.beans.Cart;
import com.cg.oms.beans.Customer;
import com.cg.oms.beans.CustomerAddress;
import com.cg.oms.beans.CustomerMessage;
import com.cg.oms.beans.Order;
import com.cg.oms.beans.OrderInfo;
import com.cg.oms.beans.Product;
import com.cg.oms.dao.OnlineMedicalStoreDAO;
import com.cg.oms.dao.OnlineMedicalStoreDAOImpl;

@Service
public class OnlineMedicalStoreServicesImpl implements OnlineMedicalStoreServices {

	OnlineMedicalStoreDAO onlinemedicalstoredao = new OnlineMedicalStoreDAOImpl();

	@Override
	public Boolean registerCustomer(Customer customer) {
		return onlinemedicalstoredao.registerCustomer(customer);
	}

	@Override
	public Customer loginCustomer(int customerId, String password) {
		return onlinemedicalstoredao.loginCustomer(customerId, password);
	}

	@Override
	public Boolean updateCustomer(Customer customer) {
		return onlinemedicalstoredao.updateCustomer(customer);
	}

	@Override
	public Boolean deleteCustomer(int customerId) {
		return onlinemedicalstoredao.deleteCustomer(customerId);
	}

	@Override
	public Boolean updatePassword(int customerId, String oldPassword, String newPassword) {
		return onlinemedicalstoredao.updatePassword(customerId, oldPassword, newPassword);
	}

	@Override
	public Boolean addAddress(CustomerAddress address) {
		return onlinemedicalstoredao.addAddress(address);
	}

	@Override
	public Boolean updateAddress(CustomerAddress address) {
		return onlinemedicalstoredao.updateAddress(address);
	}

	@Override
	public Admin adminLogin(int adminId, String password) {
		return onlinemedicalstoredao.adminLogin(adminId, password);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return onlinemedicalstoredao.getAllCustomer();
	}

	@Override
	public Customer searchCustomer(int customerId) {
		return onlinemedicalstoredao.searchCustomer(customerId);
	}

	@Override
	public List<Product> getAllProduct() {
		return onlinemedicalstoredao.getAllProduct();
	}

	@Override
	public Product createProduct(Product product) {
		return onlinemedicalstoredao.createProduct(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return onlinemedicalstoredao.updateProduct(product);
	}

	@Override
	public Boolean deleteProduct(int productId) {
		return onlinemedicalstoredao.deleteProduct(productId);
	}

	@Override
	public Product searchProduct(int productId) {
		return onlinemedicalstoredao.searchProduct(productId);
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		List<Product> actualProduct = new ArrayList<Product>();

		List<Product> productList = onlinemedicalstoredao.searchProduct(keyword);
		if (productList.size() > 0) {
			for (Product product : productList) {
				if (product.getSearchKeyword().contains(keyword)) {
					actualProduct.add(product);
				}
			}
		}

		return actualProduct;
	}

	@Override
	public Order placeOrder(int cartId) {
		return onlinemedicalstoredao.placeOrder(cartId);
	}

	@Override
	public Boolean cancelOrder(int orderId, int customerId) {
		return onlinemedicalstoredao.cancelOrder(orderId, customerId);
	}

	@Override
	public Cart addToCart(int productId, int customerId) {
		return onlinemedicalstoredao.addToCart(productId, customerId);
	}

	@Override
	public Cart removeFromCart(int productId, int customerId) {
		return onlinemedicalstoredao.removeFromCart(productId, customerId);
	}

	@Override
	public Cart displayCart(int customerId) {
		return onlinemedicalstoredao.displayCart(customerId);
	}

	@Override
	public Boolean sendMessageToCustomer(AdminMessage msg) {
		return onlinemedicalstoredao.sendMessageToCustomer(msg);
	}

	@Override
	public List<CustomerMessage> getCustomerMSG() {
		return onlinemedicalstoredao.getCustomerMSG();
	}

	@Override
	public Boolean sendMessageToAdmin(CustomerMessage msg) {
		return onlinemedicalstoredao.sendMessageToAdmin(msg);
	}

	@Override
	public List<AdminMessage> getAdminMSG(int customerId) {
		return onlinemedicalstoredao.getAdminMSG(customerId);
	}

	@Override
	public Boolean validateCard(Card card) {
		String cardNumber = card.getCard_number();
		Pattern pattern = Pattern.compile("\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}"); // Pattern matching for 16 digits.
		Matcher matcher = pattern.matcher(cardNumber);
		if (matcher.matches()) {
			String cvvNumber = Integer.toString(card.getCvv_number());
			Pattern pattern1 = Pattern.compile("\\d{3}"); // Pattern Matching for cvv.
			Matcher matcher1 = pattern1.matcher(cvvNumber);
			if (matcher1.matches()) {
				Date date = card.getExpiry_date();
				DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				String stringdate = dateformat.format(date);

				String month = stringdate.substring(5, 7);
				String year = stringdate.substring(0, 4);

				System.out.println(month + " " + year + ".............");
				boolean validMonth = validateMonth(Integer.parseInt(month));
				boolean validYear = validateYear(Integer.parseInt(year));

				if (validMonth && validYear) {
					Date currentDate = new Date();
					if (card.getExpiry_date().after(currentDate))
						return true;

				}
			}

		}
		return false;
	}

	@Override
	public Double calculatePrice(Cart cart) {
		double price=0;
		Integer pr1 = cart.getProduct1Id();
		Integer pr2 = cart.getProduct2Id();
		Integer pr3 = cart.getProduct3Id();
		if (cart.getProduct1Id() != 0 && pr1!=null) {
			price += searchProduct(cart.getProduct1Id()).getPrice() * cart.getProduct1Count();
		}
		if (cart.getProduct2Id() != 0 && pr2!=null) {
			price += searchProduct(cart.getProduct2Id()).getPrice() * cart.getProduct2Count();
		}
		if (cart.getProduct3Id() != 0 && pr3!=null) {
			price += searchProduct(cart.getProduct3Id()).getPrice() * cart.getProduct3Count();
		}
		return price;
	}

	@Override
	public Boolean validateMonth(int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validateYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart updateCart(Cart cart) {
		return onlinemedicalstoredao.updateCart(cart);
	}

	@Override
	public List<OrderInfo> displayOrder(int customerId) {
		return onlinemedicalstoredao.displayOrder(customerId);
	}

	@Override
	public Cart searchCart(int cartId) {
		return onlinemedicalstoredao.searchCart(cartId);
	}
}
