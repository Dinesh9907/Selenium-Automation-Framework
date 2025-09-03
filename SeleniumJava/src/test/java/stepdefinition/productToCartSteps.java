package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductToCartPage;

public class productToCartSteps {
	WebDriver driver=DriverManager.getDriver();
	ProductToCartPage page=new ProductToCartPage(driver);
	String productCategory;
	String productName;
	
	@When("user selects a {string}")
	public void user_selects_a(String string) {
		List<WebElement> categoryList=page.selectCatagory();
		for(WebElement category:categoryList) {
			if(category.getText().equalsIgnoreCase(string)) {
				category.click();
				productCategory=string;
				break;
			}
		}
	}
	@Then("user moves to category specific page")
	public void user_moves_to_category_specific_page() {
		assertEquals(page.validateHeader().getText(), productCategory);
	}
	@When("user select a {string}")
	public void user_select_a(String string) {
		page.selectProduct(string);
		productName=string;
	}
	@Then("user moves to product specific page")
	public void user_moves_to_product_specific_page() {
		assertEquals(page.validateHeader().getText(), productName);
	}
	@When("user add a {string} to cart")
	public void user_add_a_to_cart(String string) {
		page.addToCart(string);
	}
	@Then("user moves to shopping cart")
	public void user_moves_to_shopping_cart() {
		assertEquals(page.validateHeader().getText(), "Shopping Cart");
	}
}
