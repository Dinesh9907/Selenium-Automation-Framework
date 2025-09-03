package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameTextBox;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextBox;
	@FindBy(xpath="//button[@class='button' and text()='Login']")
	private WebElement loginButton;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	@FindBy(xpath="//div[@class='panel failed']")
	private WebElement errorMessage;
	@FindBy(id="WelcomeContent")
	private WebElement greetingMessage;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void userName(String userName) {
		userNameTextBox.clear();
		userNameTextBox.sendKeys(userName);
	}
	
	public void password(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}
	
	public void login() {
		loginButton.click();
	}
	
	public void signOut() {
		signOutLink.click();
	}
	
	public WebElement validateSignOut() {
		return signOutLink;
	}
	
	public WebElement userNameField() {
		return userNameTextBox;
	}
	
	public WebElement signInFailed() {
		return errorMessage;
	}
	
	public WebElement greetingMessage() {
		return greetingMessage;
	}
}
