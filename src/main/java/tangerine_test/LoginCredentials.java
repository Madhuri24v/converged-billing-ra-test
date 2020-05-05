package tangerine_test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import testBase.TestBase;
import utils.TimeUtil;

public class LoginCredentials extends TestBase{

	static WebDriver driver;
	static Properties prop;

	public LoginCredentials() {

		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "userNames")
	WebElement username;
	@FindBy(how = How.ID, using = "password")
	WebElement password;
	@FindBy(how = How.ID, using = "submit")
	WebElement submit;
	@FindBy(how = How.ID, using = "username")
	WebElement resellerUsername;
	@FindBy(how = How.ID, using = "password")
	WebElement resellerPassword;
	@FindBy(how = How.ID, using = "submit")
	WebElement resellerlogin;

	public  void login() throws IOException {

		username.sendKeys(prop.getProperty("resellerAggregatorUsername"));
		password.sendKeys(prop.getProperty("resellerAggregatorPassword"));
		submit.click();

		
		
		return ;
	}
	
	public void resellerLogin(String user, String pass)throws IOException {
		
		resellerUsername.sendKeys(user);
		resellerPassword.sendKeys(pass);
		resellerlogin.click();
		System.out.println("Login Successfully");
		
	}

	public static void LogOut(WebDriver driver) throws IOException {

		Properties prop = new Properties();
		FileInputStream login = new FileInputStream(
				"/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/Inputs/LoginCredentials.properties");

		prop.load(login);

		WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNameDashboard\"]"));
		logout.click();

		WebElement logout1 = driver.findElement(By.id("logout"));
		logout1.click();

		TimeUtil.timeDelay(1);

	}

}
