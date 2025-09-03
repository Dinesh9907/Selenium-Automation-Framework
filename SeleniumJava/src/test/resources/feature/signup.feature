Feature: SignUp functionality

	Background:
		Given The user is on the jPetStore home page
		When The user clicks on "signUp" option
		
	@Functional @Positive
	Scenario: SignUp using valid details
		Given The user is on the jPetStore "signUp" page
		When The user enters valid details
		Then SignUp should be successful with a message
		
	@Functional	@Negative
	Scenario: SignUp using invalid details
		Given The user is on the jPetStore "signUp" page
		When The user enters invalid details
		Then SignUp should be failed with error message
	