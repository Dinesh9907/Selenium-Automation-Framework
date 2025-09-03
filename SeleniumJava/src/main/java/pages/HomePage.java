package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	private By signUpLink=By.xpath("//a[text()='Sign Up']");
	private By signInLink=By.xpath("//a[text()='Sign In']");
	private By HomePageImage=By.id("MainImage");
	private By signOutLink=By.xpath("//a[text()='Sign Out']");
	private By MyOrdersLink=By.xpath("//a[contains(text(),'My Orders')]");
	private By AspectranLink=By.xpath("//div/a[contains(text(),'aspectran.com')]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement homePageImage() {
		return driver.findElement(HomePageImage);
	}
	
	public void signIn() {
		driver.findElement(signInLink).click();
	}
	
	public void signOut() {
		driver.findElement(signOutLink).click();
	}
	
	public void signUp() {
		driver.findElement(signUpLink).click();
	}
	
	public void myOrders() {
		driver.findElement(MyOrdersLink).click();
	}
	
	public WebElement signInValidation() {
		return driver.findElement(signInLink);
	}
	
	public WebElement aspectranLink() {
		return driver.findElement(AspectranLink);
	}
}
