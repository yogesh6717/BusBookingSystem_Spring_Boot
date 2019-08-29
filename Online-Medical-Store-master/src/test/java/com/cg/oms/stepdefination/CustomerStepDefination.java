package com.cg.oms.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerStepDefination {

	static WebDriver driver;
	

	@Given("^Customer is on Homepage$")
	public void customer_is_on_Homepage() {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^Customer Clicks on New Register Link$")
	public void customer_Clicks_on_New_Register_Link() {
		driver.findElement(By.partialLinkText("New User ? Register Here")).click();
	}

	@Then("^Customer Should navigate to Register Page$")
	public void customer_Should_navigate_to_Register_Page() {
		System.out.println("Customer is on register page");
	}

	@Given("^Customer is on register page$")
	public void customer_is_on_register_page() {

		System.out.println("Customer is on register page");

	}

	@When("^Customer enters information to register$")
	public void customer_enters_information_to_register() throws InterruptedException {

		driver.findElement(By.id("userid")).sendKeys("11");
		driver.findElement(By.id("username")).sendKeys("Prajyot");
		driver.findElement(By.id("email")).sendKeys("prajyot@gmail.com");
		driver.findElement(By.id("moble")).sendKeys("9814324938");
		driver.findElement(By.id("age")).sendKeys("21");
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.xpath("//select/option[1]")).click();
		driver.findElement(By.id("password")).sendKeys("root");
		Thread.sleep(4000);

	}

	@When("^click on submit button to register$")
	public void click_on_submit_button_to_register() throws InterruptedException {

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}

	@Then("^Customer should be navigate to customer login page$")
	public void customer_should_be_navigate_to_customer_login_page() {
		System.out.println("user is on login page");
	}

	@When("^Customer enters valid customerId and password$")
	public void customer_enters_valid_customerId_and_password() throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(By.id("userid")).sendKeys("11");
		driver.findElement(By.id("password")).sendKeys("root");

	}

	@When("^click on the login button$")
	public void click_on_the_login_button() {

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

	}

	@Then("^Customer should be navigated to homepage$")
	public void customer_should_be_navigated_to_homepage() throws Throwable {

		System.out.println("Customer is On Customer Home Page");
		Thread.sleep(2000);
	}

	@Given("^click on the element to be added$")
	public void click_on_the_element_to_be_added() throws InterruptedException {
		driver.findElement(By.xpath("//div/p/button[@class=' btn btn-block btn-primary '][1]")).click();
		// driver.findElement(By.linkText("Add to Cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/p/button[@class=' btn btn-block btn-primary '][1]")).click();
		Thread.sleep(1000);

	}

	// @When("^click on add to cart button$")
	// public void click_on_add_to_cart_button() throws Throwable {
	// driver.findElement(By.xpath("//button[@class='btn btn-danger navbar-btn
	// ']")).click();
	// Thread.sleep(4000);
	//
	//
	// }

	@When("^Customer should navigate to cart$")
	public void customer_should_navigate_to_cart() throws Throwable {

		// driver.get("http://localhost:4200/cart");
		driver.findElement(By.xpath("//button[@class='btn btn-danger navbar-btn ']")).click();
		Thread.sleep(3000);
	}

	@Then("^Customer should click on place order button$")
	public void customer_should_click_on_place_order_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
		Thread.sleep(2000);
	}

	@Given("^Customer is on payment page$")
	public void customer_is_on_payment_page() {
		// driver.get("http://localhost:4200/payment");
		System.out.println("Customer is on payment page");
		// Thread.sleep(2000);
	}

	@When("^Customer  should enter valid cardNumber and cvv and expiry Date$")
	public void customer_should_enter_valid_cardNumber_and_cvv_and_expiry_Date() throws InterruptedException {
		driver.findElement(By.id("CardNumber")).sendKeys("4213567895672342");
		driver.findElement(By.name("month")).click();
		driver.findElement(By.xpath("//select[@name='month']/option[6]")).click();
		driver.findElement(By.name("year")).click();
		driver.findElement(By.xpath("//select[@name='year']/option[6]")).click();
		driver.findElement(By.id("cvv")).sendKeys("123");
		// driver.findElement(By.id("expirydate")).sendKeys("02-28-2020");
		Thread.sleep(2000);

	}

	@When("^click on payment button$")
	public void click_on_payment_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-info float-right ']")).click();
		Thread.sleep(2000);
	}

	@Then("^Customer should navigate to bill page$")
	public void customer_should_navigate_to_bill_page() {
		// Thread.sleep(17000);
		// driver.get("http://localhost:4200/bill");
		System.out.println("Bill generated");

	}

	@Given("^Customer is on bill page$")
	public void customer_is_on_bill_page() {
		System.out.println("Bill ");
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^customer clicks on myorders$")
	public void customer_clicks_on_myorders() {
		driver.findElement(By.partialLinkText("My Orders")).click();

	}

	@Then("^Customer should be navigated to order page$")
	public void customer_should_be_navigated_to_order_page() {
		System.out.println("customers orders");
		// Write code here that turns the phrase above into concrete actions
	}

}
