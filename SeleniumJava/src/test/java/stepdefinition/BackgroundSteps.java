package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;
import source.BasePage;

public class BackgroundSteps {
	WebDriver driver=DriverManager.getDriver();
	HomePage homePage=new HomePage(driver);
	SignUpPage signUpPage=new SignUpPage(driver);
	SignInPage signInPage=new SignInPage(driver);
	BasePage basePage=new BasePage(driver);
	
	@Given("The user is on the jPetStore home page")
	public void the_user_is_on_the_j_pet_store_home_page() {
		basePage.scrollToElement(homePage.homePageImage());
		assertTrue(homePage.homePageImage().isDisplayed());
	}
	@When("The user clicks on {string} option")
	public void the_userclicks_on_option(String string) {
		basePage.scrollToTop();
		if("signin".equalsIgnoreCase(string)) {
			homePage.signIn();
		}
		else if("signout".equalsIgnoreCase(string)){
			homePage.signOut();
		}
		else if("myorders".equalsIgnoreCase(string)) {
			homePage.myOrders();
		}
		else if("signup".equalsIgnoreCase(string)) {
			homePage.signUp();
		}
	}
	@Given("The user is on the jPetStore {string} page")
	public void the_user_is_on_the_j_pet_store_page(String string) {

		if("signin".equalsIgnoreCase(string)) {
			assertTrue(signInPage.userNameField().isDisplayed());
		}
		else if("signup".equalsIgnoreCase(string)) {
			assertTrue(signUpPage.userId().isDisplayed());
		}
	}
}
