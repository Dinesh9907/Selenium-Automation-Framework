package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverManager;

public class MyOrderPage {
	WebDriver driver;
	
	@FindBy(xpath="//div//a[contains(text(),'My Orders')]")
	WebElement MyOrderLink;
	@FindBy(xpath="//h3")
	WebElement Header;
	@FindBy(xpath="//table//td[1]")
	List<WebElement> orderIDField;
	
	public MyOrderPage() {
		this.driver=DriverManager.getDriver();
	}
	
	public MyOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void myOrderLink() {
		MyOrderLink.click();
	}
	
	public WebElement headerPage() {
		return Header;
	}
	
	public List<WebElement> OrderList(){
		return orderIDField;
	}
}
