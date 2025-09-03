package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;
import utilities.ConfigReader;

public class TestBase {
	private WebDriver driver;
	ConfigReader propReader=new ConfigReader(FrameworkConstants.CONFIG_FILE_PATH);
	String browser=propReader.getValue("browser");
	String url=propReader.getValue("url");
	int implicitlyWait=Integer.parseInt(propReader.getValue("implicitlyWait"));
	
	public void initialize() {
		DriverSetup.setWebDriver(browser);
		DriverManager.setDriver(DriverSetup.getWebDriver());
		driver=DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
	}
	
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			DriverManager.quit();
		}
	}
}
