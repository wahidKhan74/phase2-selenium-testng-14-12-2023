package com.simplilearn.testng.amazon;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrate test Xpath *
 * 
 * @author khanw
 */
public class AmazonLinkVerificationXpathTest {

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
	public void xpathLinkTest1() throws InterruptedException {
		WebElement mobileLink = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[6]"));

		System.out.println("Is link loaded :: " + mobileLink.isDisplayed());
		System.out.println("Is link is enabled :: " + mobileLink.isEnabled());

		mobileLink.click();

		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test(description = "Test Today deals Title Match")
	public void xpathLinkTest2() throws InterruptedException {
		WebElement tdLink = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[5]"));

		System.out.println("Is link loaded :: " + tdLink.isDisplayed());
		System.out.println("Is link is enabled :: " + tdLink.isEnabled());

		tdLink.click();

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

}
