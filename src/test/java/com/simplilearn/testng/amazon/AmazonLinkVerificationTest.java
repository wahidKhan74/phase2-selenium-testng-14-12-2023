package com.simplilearn.testng.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrate test for amazon webpage. *
 * 
 * @author khanw
 */
public class AmazonLinkVerificationTest {

	// step1: formulate a test domain url & driver path
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/windows/geckodriver.exe";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new FirefoxDriver();

		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterMethod
	public void cleanUp() {
		driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
		// driver.close(); // the close() closes only the current window on which
		// Selenium is running automated tests.The WebDriver session, however, remains
		// active.
	}

	@Test(description = "Test Amazon Mobile Phones Title Match")
	public void linkTest1() throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));

		link.click();

		// add delay
		Thread.sleep(1000);

		String expectedTitle = "Amazon.in Bestsellers: The most popular items on Amazon";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test(description = "Verify the Todays deals link")
	public void linkTest2() throws InterruptedException {
		WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));

		link.click();

		// add delay
		Thread.sleep(1000);

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

}
