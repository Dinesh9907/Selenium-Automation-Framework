package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(features="src/test/resources/feature/AddProductToCart.feature",
glue= {"stepdefinition","base"},
plugin= {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"},
monochrome=true)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
