package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginContainerPO {

	final WebDriver driver;
	
	@FindBy(how = How.ID_OR_NAME, using = "username")
	public WebElement username;
	
	@FindBy(how = How.ID_OR_NAME, using = "password")
	public WebElement password;
	
	@FindBy(how = How.CLASS_NAME, using = "login-button")
	public WebElement login_button;
	
	public LoginContainerPO (WebDriver driver) {
		this.driver = driver;
	}
	
	public void LogInUser(String userLogin, String userPassword) {
		username.sendKeys(userLogin);
		password.sendKeys(userPassword);
		login_button.submit();
	}
}
