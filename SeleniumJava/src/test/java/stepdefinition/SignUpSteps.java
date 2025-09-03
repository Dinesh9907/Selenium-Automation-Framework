package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;
import source.BasePage;
import utilities.ExcelReader;
import utilities.RandomData;

public class SignUpSteps {
	WebDriver driver = DriverManager.getDriver();
	SignUpPage signUpPage = new SignUpPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	ExcelReader excelReader = new ExcelReader(FrameworkConstants.TEST_DATA_PATH + "UserData.xlsx");
	Map<String, Object> value = new HashMap<>();
	RandomData randomData = new RandomData();
	BasePage basePage=new BasePage(driver);
	
	@When("The user enters valid details")
	public void the_user_enters_valid_details() throws IOException {
		value=excelReader.getRow("signup", 1);
		signUpPage.userInfo(randomData.randomAlphaNum(5), randomData.randomInteger(4));
		signUpPage.accountInfo(value.get("FirstName").toString(), value.get("LastName").toString(), value.get("Email").toString(), value.get("Phone").toString(), value.get("Address1").toString(), value.get("Address2").toString(), value.get("City").toString(), value.get("State").toString(), value.get("Zip").toString(), value.get("Country").toString());
		signUpPage.languagePreference("German");
		signUpPage.favourtieCategory("Dogs");
		signUpPage.enableBanner();
		signUpPage.enableMyList();
		signUpPage.saveInfoButton();
	}
	@Then("SignUp should be successful with a message")
	public void sign_up_should_be_successful_with_a_message() {
		wait.until(ExpectedConditions.visibilityOf(signUpPage.successfulMessage()));
		assertTrue(signUpPage.successfulMessage().isDisplayed());
		basePage.scrollToElement(signUpPage.successfulMessage());
	}
	@When("The user enters invalid details")
	public void user_enters_invalid_details() {
		signUpPage.userInfo("DD13gvwy", "1234");
		signUpPage.accountInfo("D122ss", "EE", "123", "23020", "2edd", "err", "ed", "23dccc", "23dwds", "uhu000");
		signUpPage.languagePreference("German");
		signUpPage.favourtieCategory("Dogs");
		signUpPage.enableMyList();
		signUpPage.enableBanner();
		signUpPage.saveInfoButton();
	}
	@Then("SignUp should be failed with error message")
	public void signup_should_be_failed() {
		basePage.scrollToElement(signUpPage.errorMessage());
		assertTrue(signUpPage.errorMessage().isDisplayed());
	}
}
