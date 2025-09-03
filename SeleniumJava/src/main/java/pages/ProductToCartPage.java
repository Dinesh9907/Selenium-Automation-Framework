package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductToCartPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='Sidebar']//a")
	private List<WebElement> catagory;
	
	private WebElement productID;
	private WebElement itemID;
	private WebElement subProductLink;
	
	@FindBy(xpath="//tbody//strong//small")
	private WebElement subProductName;
	@FindBy(xpath="//tbody//img")
	private WebElement productDetails;
	@FindBy(xpath="//div/a[contains(text(),'Add')]")
	private WebElement addToCartButton;
	@FindBy(xpath="//h3")
	private WebElement pageHead;
	
	private String productItemId;
	
	public ProductToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> selectCatagory(){
		return catagory;
	}
	
	public WebElement validateHeader() {
		return pageHead;
	}
	
	public void selectProduct(String productName) {
		productID=driver.findElement(By.xpath("//tbody//td[contains(text(),'"+productName+"')]//preceding-sibling::td/a"));
		productID.click();
	}
	
	public void addToCart(String itemId) {
		itemID=driver.findElement(By.xpath("//tbody//a[contains(text(),'"+itemId+"')]//parent::td//following-sibling::td/a"));
		itemID.click();
	}
	
	public void selectSubProduct(String subProductName) {
		subProductLink=driver.findElement(By.xpath("//tbody//td[contains(text(),'"+subProductName+"')]//preceding-sibling::td/a"));
		productItemId=subProductLink.getText();
		subProductLink.click();
	}
	
	public String subProductItemId() {
		return productItemId;
	}
	
	public String subProductName() {
		return subProductName.getText();
	}
	
	public WebElement productDetails() {
		return productDetails;
	}
	
	public void addToCart() {
		addToCartButton.click();
	}
}
