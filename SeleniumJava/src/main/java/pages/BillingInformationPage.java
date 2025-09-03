package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingInformationPage {
	WebDriver driver;
	
	@FindBy(xpath="//h3")
	WebElement Header;
	
	@FindBy(xpath="//select[@name='cardType']")
	WebElement cardTypeDrop;
	@FindBy(xpath="//input[@name='creditCard']")
	WebElement cardNumberField;
	@FindBy(xpath="//input[@name='expiryDate']")
	WebElement expiryDateField;
	
	WebElement FirstNameField;
	WebElement LastNameField;
	WebElement Address1Field;
	WebElement Address2Field;
	WebElement CityField;
	WebElement StateField;
	WebElement ZipField;
	WebElement CountryField;
	
	@FindBy(xpath="//input[@name='shippingAddressRequired']")
	WebElement shippingAddressRequiredCheckBox;
	@FindBy(xpath="//button[text()='Continue']")
	WebElement ContinueButton;
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement CancelButton;
	@FindBy(xpath="//button[text()='Back']")
	WebElement BackButton;
	
	public BillingInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement pageHeader() {
		return Header;
	}
	
	public void PaymentDetails(String cardTypeValue,String cardNumber,String expiryDate) {
		Select cardType=new Select(cardTypeDrop);
		cardType.selectByValue(cardTypeValue);
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);
		expiryDateField.clear();
		expiryDateField.sendKeys(expiryDate);
	}
	
	public void BillingAndShippingInformation(String firstName,String lastName,String Address1, String Address2, String city,String state,String zip,String country) {
		FirstNameField=driver.findElement(By.xpath("//input[contains(@name,'FirstName')]"));
		FirstNameField.clear();
		FirstNameField.sendKeys(firstName);
		LastNameField=driver.findElement(By.xpath("//input[contains(@name,'LastName')]"));
		LastNameField.clear();
		LastNameField.sendKeys(lastName);
		Address1Field=driver.findElement(By.xpath("//input[contains(@name,'Address1')]"));
		Address1Field.clear();
		Address1Field.sendKeys(Address1);
		Address2Field=driver.findElement(By.xpath("//input[contains(@name,'Address2')]"));
		Address2Field.clear();
		Address2Field.sendKeys(Address2);
		CityField=driver.findElement(By.xpath("//input[contains(@name,'City')]"));
		CityField.clear();
		CityField.sendKeys(city);
		StateField=driver.findElement(By.xpath("//input[contains(@name,'State')]"));
		StateField.clear();
		StateField.sendKeys(state);
		ZipField=driver.findElement(By.xpath("//input[contains(@name,'Zip')]"));
		ZipField.clear();
		ZipField.sendKeys(zip);
		CountryField=driver.findElement(By.xpath("//input[contains(@name,'Country')]"));
		CountryField.clear();
		CountryField.sendKeys(country);
	}
	
	public void shipToDifferentAddressCheckBox() {
		shippingAddressRequiredCheckBox.click();
	}
	
	public void clickContinue() {
		ContinueButton.click();
	}
	
	public void cancelButton() {
		CancelButton.click();
	}
	
	public void backButton() {
		BackButton.click();
	}
}
