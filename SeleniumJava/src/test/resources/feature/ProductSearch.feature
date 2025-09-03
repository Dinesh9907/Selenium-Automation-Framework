Feature: Product Search functionality

	Scenario Outline: Search a product using name
		Given The user is on the jPetStore home page
		When The user enters the "<product name>" in search field
		Then The search result will displays and validates it
		
	Examples:
	|product name|
	|Fish        |
	|Koi         |