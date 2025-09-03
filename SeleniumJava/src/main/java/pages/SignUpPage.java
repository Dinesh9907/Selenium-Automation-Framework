package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userId;
	@FindBy(xpath="//input[@name='password']")
	private WebElement newPassword;
	@FindBy(xpath="//input[@name='repeatedPassword']")
	private WebElement confirmPassword;
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName;
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName;
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phone;
	@FindBy(xpath="//input[@name='address1']")
	private WebElement address1;
	@FindBy(xpath="//input[@name='address2']")
	private WebElement address2;
	@FindBy(xpath="//input[@name='city']")
	private WebElement city;
	@FindBy(xpath="//input[@name='state']")
	private WebElement state;
	@FindBy(xpath="//input[@name='zip']")
	private WebElement zip;
	@FindBy(xpath="//input[@name='country']")
	private WebElement country;
	@FindBy(xpath="//select[@name='languagePreference']")
	private WebElement langPref;
	@FindBy(xpath="//select[@name='favouriteCategoryId']")
	private WebElement favCatId;
	@FindBy(xpath="//input[@name='listOption']")
	private WebElement enableMyList;
	@FindBy(xpath="//input[@name='bannerOption']")
	private WebElement enableMyBanner;
	@FindBy(xpath="//button[@class='button' and contains(text(),'Save')]")
	private WebElement saveInfo;
	@FindBy(xpath="//div[contains(@id,'MessageBar')]/p")
	private WebElement messageBar;
	@FindBy(xpath="//span[@class='error-msg' and text()]")
	private WebElement errorMessage;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement userId(){
		return userId;
	}
	
	public void userInfo(String userId,String password) {
		this.userId.sendKeys(userId);
		newPassword.sendKeys(password);
		confirmPassword.sendKeys(password);
	}
	
	public void accountInfo(String firstname,String lastname,String email,String phone,String address1,String address2,String city,String state,String zip,String country) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		this.email.sendKeys(email);
		this.phone.sendKeys(phone);
		this.address1.sendKeys(address1);
		this.address2.sendKeys(address2);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.zip.sendKeys(zip);
		this.country.sendKeys(country);
	}
	
	public void languagePreference(String lang) {
		Select select=new Select(langPref);
		select.selectByVisibleText(lang);
	}
	
	public void favourtieCategory(String favCat) {
		Select select=new Select(favCatId);
		select.selectByVisibleText(favCat);
	}
	
	public void enableMyList() {
		enableMyList.click();
	}
	
	public void enableBanner() {
		enableMyBanner.click();
	}
	
	public void saveInfoButton() {
		saveInfo.click();
	}
	
	public WebElement successfulMessage() {
		return messageBar;
	}
	
	public WebElement errorMessage() {
		return errorMessage;
	}
}
