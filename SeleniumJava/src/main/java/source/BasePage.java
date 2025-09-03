package source;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions=new Actions(driver);
	}
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void type(WebElement element,String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	
	public void clear(WebElement element,String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
	}
	
	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean isEnabled(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean isSelected(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public void selectByVisibleText(WebElement element,String text) {
		new Select(element).selectByVisibleText(text);
	}
	public void selectByValue(WebElement element,String value) {
		new Select(element).selectByValue(value);
	}
	public void selectByIndex(WebElement element,int index) {
		new Select(element).selectByIndex(index);
	}
	
	public void hoverOver(WebElement element) {
		actions.moveToElement(element).perform();
	}
	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}
	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}
	public void drapAndDrop(WebElement src,WebElement dest) {
		actions.dragAndDrop(src, dest).perform();
	}
	public void scrollToElement(WebElement element) {
		actions.scrollToElement(element).perform();
	}
	public void KeyUp(Keys keys) {
		actions.keyUp(keys).perform();
	}
	public void KeyDown(Keys keys) {
		actions.keyDown(keys);
	}
	
	public void scrollToElementUsingJS(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void ClickUsingJS(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	public void setValueUsingJS(WebElement element,String value) {
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+value+"';", element);
	}
	public String getValueUsingJS(WebElement element) {
		return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].value;", element);
	}
	public void highlightElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("return arguments[0].style.border='3px solid red';", element);
	}
	public void scrollToBottom() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	public void scrollToTop() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
	}
	public void scrollToMiddle() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,(document.body.scrollHeight)/2);");
	}
	public void reloadPageUsingJS() {
		((JavascriptExecutor)driver).executeScript("location.reload();");
	}
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(String windowTitle) {
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equalsIgnoreCase(windowTitle)) {
				break;
			}
		}
	}
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	public void goBack() {
		driver.navigate().back();
	}
	public void goForward() {
		driver.navigate().forward();
	}
	public void openURL(String url) {
		driver.get(url);
	}
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
}