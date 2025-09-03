package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignInPage;
import source.BasePage;

public class SigninSteps {
	WebDriver driver=DriverManager.getDriver();
	SignInPage signInPage=new SignInPage(driver);
	BasePage basePage=new BasePage(driver);
	
	@When("The user logs in with {string} and {string}")
	public void the_user_logs_in_with_and(String userName,String password) throws InterruptedException {
		signInPage.userName(userName);
		signInPage.password(password);
		signInPage.login();
		Thread.sleep(2000);
	}
	@Then("The user validates the successful login with welcome message and signout button")
	public void the_user_validates_the_successful_login_with_welcome_message_and_signout_button() throws InterruptedException {
		basePage.scrollToElement(signInPage.greetingMessage());
		assertTrue(signInPage.greetingMessage().getText().contains("Welcome"));
		assertTrue(signInPage.validateSignOut().isDisplayed());
	}
	@When("The user logs in with invalid {string} and {string}")
	public void the_user_logs_in_with_invalid_and(String userName,String password) throws InterruptedException {
		signInPage.userName(userName);
		signInPage.password(password);
		signInPage.login();
		Thread.sleep(2000);
	}
	@Then("Signin should be failed with error message")
	public void signin_should_be_failed_with_error_message() throws InterruptedException {
		basePage.scrollToElement(signInPage.signInFailed());
		assertTrue(signInPage.signInFailed().isDisplayed());
	}
}
