package source;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWait {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BaseWait(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	public WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public boolean waitFroElementToDisppear(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public boolean waitForTextToBePresent(WebElement element,String text) {
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void waitForAlertAndAccept() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void waitForAlertAndDismiss() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}
	public void waitForAlertAndGetText() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().getText();
	}
	public void waitForPageLoadComplete() {
		wait.until(WebDriver->((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
	}
}
