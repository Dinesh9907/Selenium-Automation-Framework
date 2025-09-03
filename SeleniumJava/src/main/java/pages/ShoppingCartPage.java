package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver driver;
	
	@FindBy(xpath="//h3")
	private WebElement pageHeader;
	
	private WebElement QuantityField;
	
	@FindBy(xpath="//td/button[@class='button']")
	private WebElement UpdateCartButton;
	@FindBy(xpath="th/b[contains(text(),'Des')]//ancestor::tbody//tr[position()>1 and position()<4]//td[3]")
	private List<WebElement> subProductNameList;
	
	private WebElement productPrice;
	private WebElement productTotalPrice;
	
	@FindBy(xpath="//tbody//td/strong[contains(text(),'Sub')]//parent::td//following-sibling::td//strong")
	private WebElement cartSubTotal;
	
	private WebElement removeButton;
	@FindBy(xpath="//table//td/a[contains(text(),'Remove All')]")
	private WebElement removeAllButton;
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	private WebElement checkOutButton;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void removeButton(String subProductName) {
		removeButton=driver.findElement(By.xpath("//table//td[contains(text(),'"+subProductName+"')]//ancestor::tr//td//a[text()='Remove']"));
		removeButton.click();
	}
	
	public void removeAllButton() {
		removeAllButton.click();
	}
	
	public void updateQuantity(String subProductName,String quantity) {
		QuantityField=driver.findElement(By.xpath("//table//td[contains(text(),'"+subProductName+"')]//following-sibling::td//input[@type='number']"));
		QuantityField.clear();
		QuantityField.sendKeys(quantity);
	}
	
	public void updateCartButton() {
		UpdateCartButton.click();
	}
	
	public List<WebElement> subProductNameList(){
		return subProductNameList;
	}
	
	public String productPrice(String subProductName) {
		productPrice=driver.findElement(By.xpath("//td[contains(text(),'"+subProductName+"')]//following-sibling::td[3]"));
		return productPrice.getText();
	}
	
	public String totalProductPrice(String subProductName) {
		productTotalPrice=driver.findElement(By.xpath("//td[contains(text(),'"+subProductName+"')]//following-sibling::td[4]"));
		return productTotalPrice.getText();
	}
	
	public String cartSubTotal() {
		return cartSubTotal.getText();
	}
	
	public void checkOutButton() {
		checkOutButton.click();
	}
	
	public String Header() {
		return pageHeader.getText();
	}
}
