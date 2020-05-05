package com.tangerine.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tangerine.qa.utils.TestUtil;

import utils.TimeUtil;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public TestBase() {
		
		
		
		try {
			
			prop = new Properties();
			FileInputStream login = new FileInputStream("/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/com/tangerine/qa/config/config.properties");

			try {
				prop.load(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		
	}
	
	
	public static void resellerInitialization() {
		
		
		String browserName=prop.getProperty("browser");
		

		if (browserName.equals("firefox")) {
			
			 System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
			driver = new FirefoxDriver();	
			
		}
		
		else if (browserName.equals("chrome")) {
			
			 System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
			driver = new ChromeDriver();	
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		TimeUtil.timeDelay(10);
		
		driver.get(prop.getProperty("reseller_url"));
		
		TimeUtil.timeDelay(10);
				
	}
	
	
public static void adminInitialization() {
		
		
		String browserName=prop.getProperty("browser");
		

		if (browserName.equals("firefox")) {
			
			 System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
			driver = new FirefoxDriver();	
			
		}
		
		else if (browserName.equals("chrome")) {
			
			 System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
			driver = new ChromeDriver();	
		}
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("admin_url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		
				
	}
}
