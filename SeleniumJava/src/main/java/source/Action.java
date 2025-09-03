package source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
	public static Actions actions;
	
	public static void scrollTo(WebDriver driver) {
		actions=new Actions(driver);
		actions.scrollByAmount(0, 1000);
	}
}
