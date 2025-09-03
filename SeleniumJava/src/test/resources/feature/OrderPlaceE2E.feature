Feature: Complete user journey in jPetStore

	Background:
		Given The user is on the jPetStore home page
		When The user clicks on "signIn" option
		
	Scenario Outline: From login to order confirmation and logout
		Given The user is on the jPetStore "signIn" page
		When The user logs in with "<userName>" and "<password>"
		And The user clicks on "<petCategory>" in the category menu
		And The user selects an "<product>"
		And The user adds the item to the cart
		And The user updates the quantity to "<updateQuantity>"
		And The user clicks on checkout option
		And The user fills in valid billing and Shipping information
		And The user confirms the order
		And The user clicks on signout option
		Then the order should be submitted successfully
	  And The user should be redirected to the home page
	  
	  @E2E
	  Scenario Outline: From login to order confirmation
	  	Given The user is on the jPetStore "signin" page
	  	When The user logs in with "<userName>" and "<password>"
	  	Then The user validates the successful login with welcome message and signout button
	  	When The user clicks on "<petCategory>" in the category menu
	  	Then The user navigates to "petCategory" page and validates it
	  	When The user selects an "<product>" on "petCategory" page
	  	Then The user navigates to "product" page and validates it
	  	When The user selects an "<subProduct>" on "product" page
	  	Then The user navigates to "productDetails" page and validates it
	  	When The user adds the item to the cart
	  	When The user navigates to "shopping Cart" page and validates it
	  	When The user updates the quantity to "<updatedQuantity>"
	  	Then The user validates the updated cart
	  	When The user clicks on proceed to checkout
	  	And The user fills in valid billing and shipping information
	  	Then The user navigates to order confirmation page and validates it
	  	When The user clicks on confirm order
	  	Then The user navigates to Order success page and validates it
	  	When The user clicks on return to main menu
	  	Then The user navigates to home page
	  	When The user clicks on "MyOrders" option
	  	Then The user navigates to "MyOrders" page and validates it
	  	When The user clicks on "signOut" option
	  	Then The user should "signOut" successfully and validates it
	  	
	  Examples:
	  |userName|password|petCategory|product  |subProduct|updatedQuantity|
	  |j2ee   |j2ee   |Fish       |Angelfish|Large     |2              |
	  |j2ee   |j2ee   |Cats       |Manx     |Tailless   |3              |