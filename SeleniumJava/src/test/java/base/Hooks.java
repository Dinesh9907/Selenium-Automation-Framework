package base;

import driver.DriverManager;
import driver.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ExtentReport;
import utilities.ScreenShot;

public class Hooks {
	private TestBase testBase;
	private ScreenShot screenShot=new ScreenShot();
	
	@Before
	public void setUpBrowser() {
		testBase=new TestBase();
		testBase.initialize();
	}
	
	@After
	public void tearDownBrowser(Scenario scenario) {
		if(scenario.isFailed()) {
			ExtentReport.getTest().addScreenCaptureFromPath(screenShot.takeScreenShot(DriverManager.getDriver()));
		}
		testBase.teardown();
	}
}
