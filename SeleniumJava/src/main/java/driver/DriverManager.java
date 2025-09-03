package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static final ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public DriverManager() {
		super();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}
	
	public static void quit() {
		if(DriverManager.getDriver()!=null) {
			driver.remove();
		}
	}
}
