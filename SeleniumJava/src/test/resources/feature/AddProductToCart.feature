Feature: User Login and Adding Product to Cart

	Background:
		Given The user is on the jPetStore home page
		When The user clicks on "signIn" option
		
	Scenario Outline: Add a product to shopping cart and verify item
		Given The user is on the jPetStore "signIn" page
		When The user logs in with "<userName>" and "<password>"
		And The user clicks on "<petCategory>" in the category menu
		And The user selects an "<product>" on "petCategory" page
		And The user selects an "<subProduct>" on "product" page
		And The user adds the item to the cart
		And The user navigates to "shopping Cart" page and validates it
		When The user updates the quantity to "<updatedQuantity>"
	  Then The user validates the updated cart
		
	Examples:
	|userName|password|petCategory|product  |subProduct|updatedQuantity|
	|j2ee    |j2ee    |Fish       |Angelfish|Large     |2              |
	