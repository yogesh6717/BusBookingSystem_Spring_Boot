package com.cg.oms.stepdefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDefination {

	static WebDriver driver;

	// Admin login case with invalid credentials

	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Software/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login");
		driver.manage().window().maximize();
	}

	@When("^Admin enter invalid AdminId and invalid password$")
	public void admin_enter_invalid_AdminId_and_invalid_password() {
		driver.findElement(By.name("adminId")).sendKeys("1000");
		driver.findElement(By.id("password")).sendKeys("gfgdgdf");
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn  btn-info float-left']")).click();
	}

	@Then("^admin should get the error message$")
	public void admin_should_get_the_error_message() {

		List<WebElement> error = driver.findElements(By.xpath("//p[@style='color: red']"));

		for (WebElement element : error) {

			System.out.println(element.getText());

			driver.close();
		}
	}

	// Admin login case with invalid credentials

	@When("^Admin enter valid AdminId and valid password$")
	public void admin_enter_valid_AdminId_and_valid_password() {
		driver.findElement(By.name("adminId")).sendKeys("10");
		driver.findElement(By.id("password")).sendKeys("yogi");
	}

	@Then("^admin should get navigated to admin home page$")
	public void admin_should_get_navigated_to_admin_home_page() throws InterruptedException {
		System.out.println("admin home page");
		Thread.sleep(1500);
		// driver.close();
	}

	// valid seacrh product by product ID case

	@When("^Admin clicks on link search product by id$")
	public void admin_clicks_on_link_search_product_by_id() throws Throwable {
		driver.findElement(By.xpath("//a[@href='/searchproduct']")).click();
		Thread.sleep(1000);
	}

	@When("^On search product page enters the product id$")
	public void on_search_product_page_enters_the_product_id() throws Throwable {
		driver.findElement(By.name("productId")).sendKeys("3");

	}

	@When("^click on search button$")
	public void click_on_search_button() throws Throwable {
		driver.findElement(By.xpath("//div[@class='form-group']")).click();
	}

	@Then("^It should show the product for that id$")
	public void it_should_show_the_product_for_that_id() throws Throwable {
		System.out.println("Product");
		Thread.sleep(1000);
	}

	// valid search product by product name

	@When("^Admin clicks on link search product by name$")
	public void admin_clicks_on_link_search_product_by_name() throws Throwable {
		driver.findElement(By.xpath("//a[@routerlink='/searchproductbykey']")).click();
		Thread.sleep(1000);
	}

	@When("^On search product page enters the product name$")
	public void on_search_product_page_enters_the_product_name() throws Throwable {
		driver.findElement(By.name("productname")).sendKeys("Aspirin");
	}

	@When("^click on search product button$")
	public void click_on_search_product_button() throws Throwable {
		driver.findElement(By.xpath("//a[@routerlink='/searchproduct']")).click();
	}

	@Then("^It should show the product for that name$")
	public void it_should_show_the_product_for_that_name() throws Throwable {
		System.out.println("product");
		Thread.sleep(1000);
	}

	// valid get all product

	@When("^Admin clicks on get all product link$")
	public void admin_clicks_on_get_all_product_link() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.linkText("Get All Products")).click();

	}

	@Then("^It should show all the product$")
	public void it_should_show_all_the_product() throws Throwable {
		System.out.println("Get all Product");
		Thread.sleep(1000);
	}

	// valid add product
	@When("^Admin clicks on add product link$")
	public void admin_clicks_on_add_product_link() throws Throwable {
		driver.findElement(By.linkText("Add Product")).click();
	}

	@When("^Admin Adds all the product Info$")
	public void admin_Adds_all_the_product_Info() throws Throwable {
		driver.findElement(By.id("productName")).sendKeys("Dcold Total");
		Thread.sleep(1000);

		driver.findElement(By.id("category")).sendKeys("HealthCare");
		Thread.sleep(1000);

		driver.findElement(By.id("quantity")).sendKeys("2000");
		Thread.sleep(1000);

		driver.findElement(By.id("price")).sendKeys("3");
		Thread.sleep(1000);

		driver.findElement(By.id("description")).sendKeys("For HeadAches");
		Thread.sleep(1000);

		driver.findElement(By.id("searchKeyword")).sendKeys("Dcold");
		Thread.sleep(1000);

	}

	@When("^Admin then Clicks on add product button$")
	public void admin_then_Clicks_on_add_product_button() throws Throwable {

		driver.findElement(By.xpath("//button[@class='btn btn-primary float-left']")).click();
		Thread.sleep(1000);
	}

	// remove a product from list (valid)

	@When("^Admin clicks on remove button for a particular product$")
	public void admin_clicks_on_remove_button_for_a_particular_product() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-danger ']")).click();
		Thread.sleep(1000);
	}

	@Then("^The product info should get removed$")
	public void the_product_info_should_get_removed() throws Throwable {
		System.out.println("Removed");
		Thread.sleep(1000);

	}

	// valid update product
	@When("^Admin clicks on update product link$")
	public void admin_clicks_on_update_product_link() throws Throwable {
		driver.findElement(By.xpath("//a[@routerlink='/updateproduct']")).click();
	}

	@When("^Add info to update a particular product$")
	public void add_info_to_update_a_particular_product() throws Throwable {

		driver.findElement(By.id("productId")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.id("productName")).sendKeys("Aspirin");
		Thread.sleep(1000);

		driver.findElement(By.id("category")).sendKeys("HealthCare");
		Thread.sleep(1000);

		driver.findElement(By.id("quantity")).sendKeys("2000");
		Thread.sleep(1000);

		driver.findElement(By.id("price")).sendKeys("10");
		Thread.sleep(1000);

		driver.findElement(By.id("description")).sendKeys("For Headaches");
		Thread.sleep(1000);

		driver.findElement(By.id("searchKeyword")).sendKeys("aspirin");
		Thread.sleep(1000);
	}

	@When("^Click on update button$")
	public void click_on_update_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-primary float-left']")).click();
	}

	// ======================================================================

	// invalid search product by product id
	@When("^On search product page enters the invalid product id$")
	public void on_search_product_page_enters_the_invalid_product_id() throws Throwable {
		driver.findElement(By.xpath("//input[contains(@name,'productId')]")).sendKeys("5");
		Thread.sleep(1000);

	}

	@Then("^It should show the product ID error message$")
	public void it_should_show_the_product_ID_error_message() throws Throwable {
		List<WebElement> error = driver.findElements(By.xpath("//div/div[.='Cant Find Product By product Id']"));

		for (WebElement element : error) {

			System.out.println(element.getText());

			driver.close();
		}
	}

	@When("^On search product page enters invalid product name$")
	public void on_search_product_page_enters_invalid_product_name() throws Throwable {
		driver.findElement(By.name("productname")).sendKeys("Syrup");

	}

	@Then("^It should show the product name error message$")
	public void it_should_show_the_product_name_error_message() throws Throwable {
		List<WebElement> error = driver.findElements(By.xpath("//div/div[.='Cant Find Product By product Id']"));

		for (WebElement element : error) {

			System.out.println(element.getText());

			driver.close();
		}
	}

	@When("^Admin clicks on change the details link$")
	public void admin_clicks_on_change_the_details_link() throws Throwable {
		driver.findElement(By.xpath("//a[.=' Change Product Details ']")).click();
	}

	@When("^inserts non existing id to update a particular product$")
	public void inserts_non_existing_id_to_update_a_particular_product() throws Throwable {
		driver.findElement(By.id("productId")).sendKeys("7");
		Thread.sleep(1000);
		driver.findElement(By.id("productName")).sendKeys("sha");
		Thread.sleep(1000);

		driver.findElement(By.id("category")).sendKeys("HealthCare");
		Thread.sleep(1000);

		driver.findElement(By.id("quantity")).sendKeys("2000");
		Thread.sleep(1000);

		driver.findElement(By.id("price")).sendKeys("10");
		Thread.sleep(1000);

		driver.findElement(By.id("description")).sendKeys("For Headaches");
		Thread.sleep(1000);

		driver.findElement(By.id("searchKeyword")).sendKeys("aspirin");
		Thread.sleep(1000);

	}

	@Then("^Admin clicks on get all product link to check the updated product$")
	public void admin_clicks_on_get_all_product_link_to_check_the_updated_product() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.linkText("Get All Products")).click();
		System.out.println("product could not be updated");

	}

}
