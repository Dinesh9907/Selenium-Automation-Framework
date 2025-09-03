package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	WebDriver driver;
	
	WebElement messageBar;
	@FindBy(xpath="//h3")
	WebElement Header;
	
	@FindBy(xpath="//td[contains(text(),'Order Date')]//following-sibling::td")
	WebElement OrderDate;
	@FindBy(xpath="//td[contains(text(),'First name:')]//following-sibling::td")
	List<WebElement> FirstName;
	@FindBy(xpath="//td[contains(text(),'Last name:')]//following-sibling::td")
	List<WebElement> LastName;
	@FindBy(xpath="//td[contains(text(),'Address 1:')]//following-sibling::td")
	List<WebElement> Address1;
	@FindBy(xpath="//td[contains(text(),'Address 2:')]//following-sibling::td")
	List<WebElement> Address2;
	@FindBy(xpath="//td[contains(text(),'City:')]//following-sibling::td")
	List<WebElement> City;
	@FindBy(xpath="//td[contains(text(),'State:')]//following-sibling::td")
	List<WebElement> State;
	@FindBy(xpath="//td[contains(text(),'Country:')]//following-sibling::td")
	List<WebElement> Country;
	@FindBy(xpath="//td[contains(text(),'Zip:')]//following-sibling::td")
	List<WebElement> Zip;
	
	@FindBy(xpath="//div//button[contains(text(),'Confirm')]")
	WebElement ConfirmButton;
	@FindBy(xpath="//div//button[contains(text(),'Back')]")
	WebElement BackButton;
	
	@FindBy(xpath="//td[contains(text(),'Order No.')]//following-sibling::td")
	WebElement OrderNo;
	@FindBy(xpath="//td[contains(text(),'Card Type')]//following-sibling::td")
	WebElement CardType;
	@FindBy(xpath="//td[contains(text(),'Card Number')]//following-sibling::td")
	WebElement CardNumber;
	@FindBy(xpath="//td[contains(text(),'Expiry Date')]//following-sibling::td")
	WebElement ExpiryDate;
	@FindBy(xpath="//td[contains(text(),'Description')]//ancestor::tbody//td[2]")
	WebElement subProductName;
	@FindBy(xpath="//td[contains(text(),'Quantity')]//ancestor::tbody//td[2]")
	WebElement productQuantity;
	@FindBy(xpath="//td[contains(text(),'Price')]//ancestor::tbody//td[2]")
	WebElement productPrice;
	@FindBy(xpath="//td[contains(text(),'Total Cost')]//ancestor::tbody//td[5]")
	WebElement totalProductPrice;
	@FindBy(xpath="//td[contains(text(),'Total')]//following-sibling::th")
	WebElement totalCartPrice;
	
	@FindBy(xpath="//div//button[contains(text(),'Delete Order')]")
	WebElement deleteOrder;
	@FindBy(xpath="//div//a[contains(text(),'Return')]")
	WebElement returnToMainMenuButton;
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement messageBar() {
		 messageBar=driver.findElement(By.xpath("//div[@id='MessageBar']/p"));
		 return messageBar;
	}
	
	public WebElement Header() {
		return Header;
	}
	
	public WebElement orderDate() {
		return OrderDate;
	}
	
	public Map<String,String> BillingInformation() {
		Map<String,String> data=new HashMap<>();
		data.put("FirstName", FirstName.get(0).getText());
		data.put("LastName", LastName.get(0).getText());
		data.put("Address1", Address1.get(0).getText());
		data.put("Address2", Address2.get(0).getText());
		data.put("City", City.get(0).getText());
		data.put("State", State.get(0).getText());
		data.put("Zip", Zip.get(0).getText());
		data.put("Country", Country.get(0).getText());
		
		return data;
	}
	
	public Map<String,String> ShippingInformation(){
		Map<String,String> data=new HashMap<>();
		data.put("FirstName", FirstName.get(1).getText());
		data.put("LastName", LastName.get(1).getText());
		data.put("Address1", Address1.get(1).getText());
		data.put("Address2", Address2.get(1).getText());
		data.put("City", City.get(1).getText());
		data.put("State", State.get(1).getText());
		data.put("Zip", Zip.get(1).getText());
		data.put("Country", Country.get(1).getText());
		
		return data;
	}
	
	public void ConfirmButton() {
		ConfirmButton.click();
	}
	
	public void backButton() {
		BackButton.click();
	}
	
	public WebElement OrderNumber() {
		return OrderNo;
	}
	
	public List<String> cardDetails(){
		List<String> card=new ArrayList<>();
		card.add(CardType.getText());
		card.add(CardNumber.getText());
		card.add(ExpiryDate.getText());
		return card;
	}
	
	public String subProductDescription() {
		return subProductName.getText();
	}
	
	public void deleteOrder() {
		deleteOrder.click();
	}
	
	public void returnToMainMenu() {
		returnToMainMenuButton.click();
	}
	
	public String Quantity() {
		return productQuantity.getText();
	}
	
	public String productPrice() {
		return productPrice.getText().substring(1);
	}
	
	public String totalProductPrice() {
		return totalProductPrice.getText().substring(1);
	}
	
	public String totalCart() {
		return totalCartPrice.getText().substring(1);
	}
}
