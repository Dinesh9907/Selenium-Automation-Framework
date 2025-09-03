Feature: User Login and Pet Category Navigation

	Background:
		Given The user is on the jPetStore home page
		When The user clicks on "signIn" option
	
	Scenario: Valid login and navigate to "<petCategory>"
		Given The user is on the jPetStore "signIn" page
		When The user logs in with "<userName>" and "<password>"
		And The user clicks on "<petCategory>" in the category menu
		Then The user navigates to "petCategory" page and validates it
	
	Examples:
	|petCategory|userName|password|
	|Fish       |j2ee    |j2ee    |