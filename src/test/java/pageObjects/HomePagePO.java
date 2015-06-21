package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePagePO {
	
	final WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using = "sign-in-label")
	public WebElement sign_in_label;
	
	public HomePagePO(WebDriver driver) {
		this.driver = driver;
	}
}
