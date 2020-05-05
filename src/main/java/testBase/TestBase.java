package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.TimeUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	static String browserName;
	
	
	public TestBase() {
		
		try {
			
		prop = new Properties();
		FileInputStream login = new FileInputStream("/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/Inputs/SimInventoryInputs.properties");

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
	
	public static WebDriver initialization() {
		
		
		if (browserName.equals(prop.getProperty("browser"))) {
			
			 System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
			driver = new FirefoxDriver();	
			
		}
		
		else if (browserName.equals(prop.getProperty("browser"))) {
			
			 System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
			driver = new ChromeDriver();	
		}
		
		
		TimeUtil.timeDelay(5);
		driver.manage().window().maximize();
		
		TimeUtil.timeDelay(3);
		driver.get(prop.getProperty("url"));
		
		
		return driver;
	}


}
