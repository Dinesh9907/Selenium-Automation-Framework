package stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BillingInformationPage;
import pages.HomePage;
import pages.MyOrderPage;
import pages.OrderConfirmationPage;
import pages.ProductToCartPage;
import pages.ShoppingCartPage;
import pages.SignInPage;
import source.BasePage;

public class OrderPlaceSteps {
	WebDriver driver=DriverManager.getDriver();
	HomePage homePage=new HomePage(driver);
	SignInPage signInPage=new SignInPage(driver);
	ProductToCartPage productPage=new ProductToCartPage(driver);
	ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
	MyOrderPage myOrderPage=new MyOrderPage(driver);
	BasePage basePage=new BasePage(driver);
	String productCategory;
	String product;
	String subProduct;
	String itemID;
	int Quantity;
	String OrderID;
	BillingInformationPage billingInformationPage=new BillingInformationPage(driver);
	OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage(driver);
	
	@When("The user clicks on {string} in the category menu")
	public void the_user_clicks_on_in_the_category_menu(String productCategory) {
		List<WebElement> categoryList=productPage.selectCatagory();
		for(WebElement category:categoryList) {
			if(category.getText().equalsIgnoreCase(productCategory)) {
				basePage.scrollToElement(homePage.aspectranLink());
				category.click();
				this.productCategory=productCategory;
				break;
			}
		}
	}
	@Then("The user navigates to {string} page and validates it")
	public void the_user_navigates_to_page_and_validates_it(String Header) {
		basePage.scrollToElement(homePage.aspectranLink());
		if("petCategory".equalsIgnoreCase(Header)) {
			assertTrue(productPage.validateHeader().getText().equalsIgnoreCase(productCategory));
		}
		else if("product".equalsIgnoreCase(Header)) {
			assertTrue(productPage.validateHeader().getText().equalsIgnoreCase(product));
		}
		else if("productDetails".equalsIgnoreCase(Header)) {
			assertTrue(productPage.validateHeader().getText().equalsIgnoreCase(product));
			assertTrue(productPage.productDetails().isDisplayed());
			assertTrue(productPage.subProductName().contains(subProduct));
		}
		else if("shopping Cart".equalsIgnoreCase(Header)) {
			assertTrue(shoppingCartPage.Header().equalsIgnoreCase(Header));
		}
		else if("MyOrders".equalsIgnoreCase(Header)) {
			assertTrue(myOrderPage.headerPage().isDisplayed());
			boolean result=false;
			for(WebElement orderNo:myOrderPage.OrderList()) {
				if(orderNo.getText().equals(OrderID)) {
					result=true;
					break;
				}
			}
			assertTrue(result);
		}
	}
	@When("The user selects an {string} on {string} page")
	public void the_user_selects_an_on_page(String product,String Header) {
		basePage.scrollToElement(homePage.aspectranLink());
		if("petCategory".equalsIgnoreCase(Header)) {
			productPage.selectProduct(product);
			this.product=product;
		}
		else if("product".equalsIgnoreCase(Header)) {
			productPage.selectSubProduct(product);
			this.subProduct=product;
			this.itemID=productPage.subProductItemId();
		}
	}
	@When("The user adds the item to the cart")
	public void the_user_adds_the_item_to_the_cart() {
		productPage.addToCart();
	}
	@When("The user updates the quantity to {string}")
	public void the_user_updates_the_quantity_to(String quantity) throws InterruptedException {
		Quantity=Integer.parseInt(quantity);
		if(Quantity>1) {
			shoppingCartPage.updateQuantity(subProduct, quantity);
			shoppingCartPage.updateCartButton();
			Thread.sleep(3000);
		}
	}
	@Then("The user validates the updated cart")
	public void the_user_validates_the_updated_cart() {
		double productPrice=Double.parseDouble(shoppingCartPage.productPrice(subProduct).substring(1));
		double totalCost=Double.parseDouble(shoppingCartPage.totalProductPrice(subProduct).substring(1));
		assertEquals(totalCost,productPrice*Quantity);
		double subTotal=Double.parseDouble(shoppingCartPage.cartSubTotal().substring(1));
		assertEquals(subTotal, totalCost);
	}
	@When("The user clicks on proceed to checkout")
	public void the_user_clicks_on_proceed_to_checkout() {
		shoppingCartPage.checkOutButton();
	}
	@When("The user fills in valid billing and shipping information")
	public void the_user_fills_in_valid_billing_and_shipping_information() throws InterruptedException {
		
		assertEquals("Payment Details",billingInformationPage.pageHeader().getText());
		billingInformationPage.PaymentDetails("Visa", "5454545454545454", "022012");
		billingInformationPage.BillingAndShippingInformation("Dinesh", "Din", "12,23233dd", "ABC", "XYZ", "ST", "123123", "CT");
		billingInformationPage.shipToDifferentAddressCheckBox();
		billingInformationPage.clickContinue();
		Thread.sleep(2000);
		
		billingInformationPage.BillingAndShippingInformation("Din", "Dinesh", "12,23232a", "XYZ", "ABC", "MX", "239230", "KTT");
		billingInformationPage.clickContinue();
	}
	@Then("The user navigates to order confirmation page and validates it")
	public void the_user_navigates_to_order_confirmation_page_and_validates_it() {
		basePage.scrollToElement(orderConfirmationPage.orderDate());
		assertEquals("Please confirm the information below and then press continue...", orderConfirmationPage.messageBar().getText());
		assertTrue(orderConfirmationPage.Header().isDisplayed());
		assertTrue(orderConfirmationPage.orderDate().isDisplayed());
	}
	@When("The user clicks on confirm order")
	public void the_user_clicks_on_confirm_order() {
		orderConfirmationPage.ConfirmButton();
	}
	@Then("The user navigates to Order success page and validates it")
	public void the_user_navigates_to_order_success_page_and_validates_it() {
		basePage.scrollToElement(orderConfirmationPage.OrderNumber());
		assertEquals("Thank you, your order has been submitted.",orderConfirmationPage.messageBar().getText());
		assertTrue(orderConfirmationPage.OrderNumber().isDisplayed());
		OrderID=orderConfirmationPage.OrderNumber().getText().substring(1);
	}
	@When("The user clicks on return to main menu")
	public void the_user_clicks_on_return_to_main_menu() {
		orderConfirmationPage.returnToMainMenu();
	}
	@Then("The user navigates to home page")
	public void the_user_navigates_to_home_page() throws InterruptedException {
		basePage.scrollToElement(signInPage.greetingMessage());
		assertTrue(signInPage.greetingMessage().getText().contains("Welcome"));
		Thread.sleep(2000);
	}
	@Then("The user should {string} successfully and validates it")
	public void the_user_should_successfully_and_validates_it(String Header) {
		assertTrue(homePage.signInValidation().isDisplayed());
	}

}
