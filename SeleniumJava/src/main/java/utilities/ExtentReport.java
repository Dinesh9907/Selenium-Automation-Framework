package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public class ExtentReport {
	private static ExtentReports extentReports;
	
	private static ThreadLocal<ExtentTest> testThreadLocal=new ThreadLocal<>();
	
	public static void initReports() {
		if(extentReports==null) {
			String reportPath=FrameworkConstants.REPORTS_PATH+"ExtentReports.html";
			ExtentSparkReporter sparkReporter=new ExtentSparkReporter(reportPath);
			sparkReporter.config().setDocumentTitle("Automation Extent Report");
			sparkReporter.config().setReportName("Functional Tests");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extentReports=new ExtentReports();
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("Software Quality Assurance", "Di");
			extentReports.setSystemInfo("Environment", "stg");
		}
	}
	
	public static void createTest(String testName) {
		if(extentReports==null) {
			initReports();
		}
		ExtentTest test=extentReports.createTest(testName);
		testThreadLocal.set(test);
	}
	
	public static ExtentTest getTest() {
		return testThreadLocal.get();
	}
	
	public static void flushReports() {
		if(extentReports!=null) {
			extentReports.flush();
		}
	}
}
