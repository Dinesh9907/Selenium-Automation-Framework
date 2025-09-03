package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Product Search']")
	private WebElement productSearchField;
	@FindBy(xpath="//div[@class='input-group-button']/button[contains(text(),'Search')]")
	private WebElement productSearchButton;
	private WebElement ResultHeader;
	private List<WebElement> SearchProducts;
	
	public SearchProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void productSearchBox(String productName) {
		productSearchField.click();
		productSearchField.sendKeys(productName);
		productSearchButton.click();
	}
	public WebElement productResultHeader(String productName) {
		ResultHeader=driver.findElement(By.xpath("//h3[contains(text(),'"+productName+"')]"));
		return ResultHeader;
	}
	public List<WebElement> searchProducts(String productName) {
		SearchProducts=driver.findElements(By.xpath("//tr/td[contains(text(),'"+productName+"')]"));
		return SearchProducts;
	}
	
}
