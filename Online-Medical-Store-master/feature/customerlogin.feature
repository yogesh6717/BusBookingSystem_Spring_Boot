Feature: Customer feature 

Scenario: Home Page 

	Given Customer is on Homepage 
	When Customer Clicks on New Register Link 
	Then Customer Should navigate to Register Page 
	
	
Scenario: register customer 

	Given Customer is on register page 
	When Customer enters information to register 
	And click on submit button to register 
	Then Customer should be navigate to customer login page 
	
Scenario: login with valid credentials 
	When Customer enters valid customerId and password 
	And click on the login button 
	Then Customer should be navigated to homepage 
	
Scenario: User is able to add products to cart 
	Given click on the element to be added 
	And Customer should navigate to cart 
	Then Customer should click on place order button 
	
	
	
Scenario: User should be able to place the orders 
	Given Customer is on payment page 
	When Customer  should enter valid cardNumber and cvv and expiry Date 
	And click on payment button 
	Then Customer should navigate to bill page 
	
Scenario: My orders 
	Given Customer is on bill page 
	When  customer clicks on myorders 
	Then Customer should be navigated to order page 