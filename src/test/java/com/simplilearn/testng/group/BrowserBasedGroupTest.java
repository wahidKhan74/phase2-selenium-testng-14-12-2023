package com.simplilearn.testng.group;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * This class will demonstrate group test
 * 
 * @author khanw
 *
 */
public class BrowserBasedGroupTest {

	// step1: formulate a test domain url & driver path
	String amazonUrl = "https://www.amazon.in/";
	String facebookUrl = "https://www.facebook.com/";

	String firefoxPath = "drivers/windows/geckodriver.exe";
	String chromePath = "drivers/windows/chromedriver.exe";

	WebDriver driverOne;
	WebDriver driverTwo;
	WebDriverWait driverTwoWait;

	@Test(groups = "ChromeOnly")
	public void launchChrome() {
		
		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", chromePath);

		// step3: instantiate selenium webdriver
		driverOne = new ChromeDriver();

		// step4: launch browser
		driverOne.get(amazonUrl);
	}
	
	@Test(groups = "ChromeOnly", description = "Test Amazon Home Page Title Match", dependsOnMethods="launchChrome", priority=1)
	public void testHomePageTitle() {
		String expectedTitle  = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle  = driverOne.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(groups = "ChromeOnly", description = "Test Amazon Home Page Title Invalid Match", dependsOnMethods="launchChrome", priority=3)
	public void testAmazonHomePageTitle2() {
		String expectedTitle  = "OOnline SShopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle  = driverOne.getTitle();
		assertNotEquals(actualTitle, expectedTitle);
	}
	
	@Test(groups = "ChromeOnly", description = "Test Amazon Home Page Source Url", dependsOnMethods="launchChrome", priority=2)
	public void testHomePageSourceUrl() {
		assertEquals(driverOne.getCurrentUrl(), amazonUrl);
	}
	
	@Test (groups = "ChromeOnly", description = "Search Iphone 15 pro max", dependsOnMethods="launchChrome", priority=4)
	public void testSearch1() throws InterruptedException {
		WebElement searchBox = driverOne.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 15 pro max");
		searchBox.submit();

		// add delay 
		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : Iphone 15 pro max";
		String actualTitle = driverOne.getTitle();
		
		assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dependsOnGroups="ChromeOnly")
	public void closeChrome() {
		driverOne.close();
	}
	
	
	@Test(groups = "FireFoxOnly")
	public void launchFireFoxTest() {
		
		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", firefoxPath);

		// step3: instantiate selenium webdriver
		driverTwo = new FirefoxDriver();
		driverTwoWait = new WebDriverWait(driverTwo, Duration.ofSeconds(50));
		// step4: launch browser
		driverTwo.get(facebookUrl);
	}
	
	@Test(groups = "FireFoxOnly", dependsOnMethods="launchFireFoxTest", priority=1)
	public void testFaceBookHomePage() {
		String expected = "Facebook – log in or sign up";
		assertEquals(driverTwo.getTitle(), expected);
	}
	
	@Test(groups = "FireFoxOnly", dependsOnMethods="launchFireFoxTest", priority=2)
	public void testFailureLogin() {
		driverTwo.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driverTwo.findElement(By.id("pass")).sendKeys("abc@123");
		driverTwo.findElement(By.name("login")).submit();
		
		// evaluate a failure login test
		WebElement errorMsg = driverTwoWait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#loginform > div:nth-child(12) > div._9ay7")));
		
		String errorText = "The password that you've entered is incorrect. Forgotten password?";
		assertEquals(errorText, errorMsg.getText());
	}
	
	@Test(dependsOnGroups="FireFoxOnly")
	public void closeFireFox() {
		driverTwo.close();
	}
}
