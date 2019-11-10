package com.spectate.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.spectate.utilities.Utilities;

import org.testng.Reporter;

public class BasePage {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties config = new Properties(), or = new Properties();
	public static FileInputStream fis_config, fis_or;
	
	
	public BasePage() {
		if(driver==null) {
			
			try {
				fis_config = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				config.load(fis_config);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis_or = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
				or.load(fis_or);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(config.getProperty("browser").equalsIgnoreCase("ie")) {
				// for IE
			}
			else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
				// for firefox
			}

		}
		wait = new WebDriverWait(driver, 10);
		System.setProperty("org.uncommons.reportng.escape-output","false");
	}
	@BeforeSuite
	public void setUp() {
		driver.get(config.getProperty("test_site_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit_wait")), TimeUnit.SECONDS);		
	}
	@BeforeTest
	public void refreshBrowser() {
		driver.get(config.getProperty("test_site_url"));
	}
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

	public void click(String identifier) {

		if (identifier.endsWith("CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(identifier))).click();
		} else if (identifier.endsWith("XPATH")) {
			driver.findElement(By.xpath(or.getProperty(identifier))).click();
		}
		Reporter.log("<br>"+"Clicking on : " + identifier+"<br>");
	}

	public void type(String identifier, String value) {
		
		if (identifier.endsWith("CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(identifier))).sendKeys(value);
		} else if (identifier.endsWith("XPATH")) {
			driver.findElement(By.xpath(or.getProperty(identifier))).sendKeys(value);
		}

		Reporter.log("<br>"+"Typing in : " + identifier + " entered value as " + value + "<br>");
	
	}
	public void type(String identifier, Keys value) {

		if (identifier.endsWith("CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(identifier))).sendKeys(value);
		} else if (identifier.endsWith("XPATH")) {
			driver.findElement(By.xpath(or.getProperty(identifier))).sendKeys(value);
		}
		Reporter.log("<br>"+"Typing in : " + identifier + " entered value as " + value+"<br>");
		
	}

	public static void validateEquals(String actual, String expected) throws IOException {

		try {

			Assert.assertEquals(actual, expected);
			Reporter.log("<br>" + "Verification Passed: The Actual Value "+ actual +" matches with the Expected value "+ expected + "<br>");
		} catch (Throwable t) {

			Utilities.captureScreenshot();
			Reporter.log("<br>" + "Verification Failed: The Actual Value "+ actual +" does not match with the Expected value "+ expected + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotPath + "><img src=" + Utilities.screenshotPath
					+ " height=200 width=300></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

		}

	}
}
