package com.wikia.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePagePO;
import pageObjects.LoginContainerPO;

public class LoginSuccessfulTest {

	private static final String WEBSITE_ADDRESS = "http://qm-homework.wikia.com";
	private static final String VALID_USER_NAME = "kasia_suszczynska";
	private static final String VALID_USER_PASSWORD = "wikia";
	private static WebDriver driver;
	private static HomePagePO HomePage;
	private static LoginContainerPO LoginContainer;
	
	@FindBy(how=How.CLASS_NAME,using="ajaxLogin")
	static WebElement linksContainer;

	@BeforeMethod
	public void setUp() {
		
		// New instance of FirefoxDriver
		driver = new FirefoxDriver();
		
		// Launch the wikia.com web site
		driver.get(WEBSITE_ADDRESS);
		HomePage = PageFactory.initElements(driver, HomePagePO.class);
		LoginContainer = PageFactory.initElements(driver, LoginContainerPO.class);
	}

	@Test
	public void loginSuccessful() {
		
		// Log user by valid user name and password
		HomePage.sign_in_label.click();
		LoginContainer.LogInUser(VALID_USER_NAME, VALID_USER_PASSWORD);
		
		// Wait for page to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("links-container")));
		
		//Check if proper page is loaded
		PageFactory.initElements(driver, LoginSuccessfulTest.class);
		Assert.assertEquals(linksContainer.getAttribute("title"), "Kasia suszczynska - My page", "Links container title");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}