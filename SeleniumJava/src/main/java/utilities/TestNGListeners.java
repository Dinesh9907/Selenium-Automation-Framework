package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestNGListeners implements ITestListener{
	WebDriver driver;
	ScreenShot screenShot=new ScreenShot();
	
	private static int totalTC;
	private static int passedTC;
	private static int failedTC;
	private static int skippedTC;
	
	public void onStart(ITestContext context) {
		ExtentReport.initReports();
	}
	
	public void onFinish(ITestContext context) {
		ExtentReport.flushReports();
	}
	
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed: "+result.getMethod().getMethodName());
		passedTC++;
	}
	
	public void onTestFailure(ITestResult result) {
		ExtentReport.getTest().log(Status.FAIL, "Test Failed: "+result.getMethod().getMethodName());
		ExtentReport.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		failedTC++;
	}
	
	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped: "+result.getMethod().getMethodName());
		skippedTC++;
	}
}
