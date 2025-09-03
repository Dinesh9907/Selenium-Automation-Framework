package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchProductPage;
import source.BasePage;

public class ProductSearchSteps {
	WebDriver driver=DriverManager.getDriver();
	SearchProductPage page=new SearchProductPage(driver);
	String product;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	BasePage basePage=new BasePage(driver);
	
	@When("The user enters the {string} in search field")
	public void the_user_enters_the_in_search_field(String product) {
		page.productSearchBox(product);
		this.product=product;
	}
	@Then("The search result will displays and validates it")
	public void the_search_result_will_displays_and_validates_it() throws InterruptedException {
		Thread.sleep(5000);
		basePage.scrollToElement(page.productResultHeader(product));
		assertTrue(page.productResultHeader(product).isDisplayed());
		List<WebElement> searchProduct=page.searchProducts(product);
		for(WebElement result:searchProduct) {
			basePage.scrollToElement(result);
			assertTrue((result.getText().toLowerCase()).contains(product.toLowerCase()));
		}
	}
}
