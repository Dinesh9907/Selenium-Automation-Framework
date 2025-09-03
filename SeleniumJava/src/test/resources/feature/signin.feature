Feature: Signin functionality

	Background:
		Given The user is on the jPetStore home page
		When The user clicks on "signIn" option
		
	@Positive @Functional
	Scenario: Valid login
		Given The user is on the jPetStore "signIn" page
		When The user logs in with "j2ee" and "j2ee"
		Then The user validates the successful login with welcome message and signout button
		
	@Negative @Functional
	Scenario Outline: Invalid login
		Given The user is on the jPetStore "signIn" page
		When The user logs in with invalid "<userName>" and "<password>"
		Then Signin should be failed with error message
	
	Examples:
	  |userName|password|
	  |j2ee    |1234    |