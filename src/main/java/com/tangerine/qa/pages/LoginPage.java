package com.tangerine.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.utils.TestUtil;

import utils.TimeUtil;

public class LoginPage extends TestBase {

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
	@FindBy(how = How.XPATH, using = "/html/body/div/nav/div/a/img")
	WebElement lycaLogo;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div[1]/div[1]/img")
	WebElement lycaLogoinAdmin;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"profileDropdown\"]/div[2]/p")
	WebElement userNameVerification;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"userNameDashboard\"]/span/small/b")
	WebElement userNameVerificationInAdminDashboard;
	
	
	

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateLoginPage() {

		return driver.getTitle();
	}

	public boolean validateLycaLogo() {

		return lycaLogo.isDisplayed();
	}
	

	public HomePage login(String un, String pw) {

		resellerUsername.sendKeys(un);
		resellerPassword.sendKeys(pw);
		resellerlogin.click();
		
	

		
//		
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"profileDropdown\"]/div[2]/p")));
//
//		
//		try {
//			
//			String UsernameVerify = userNameVerification.getText();
//			Assert.assertEquals(UsernameVerify, prop.getProperty(un));
//
//			Reporter.log("Login Successfully");
//
//		} catch (AssertionError e) {
//			Reporter.log("Login failed");
//		}

		return new HomePage();

	}

	public AdminHomePage adminDashboardLogin(String uname, String pwd) {

		username.sendKeys(uname);
		password.sendKeys(pwd);
		TimeUtil.timeDelay(1);
		submit.click();
		
		
		TimeUtil.timeDelay(60);
		
//		try {
//			String UsernameVerify = userNameVerificationInAdminDashboard.getText();
//			Assert.assertEquals(UsernameVerify, prop.getProperty(uname));
//
//			Reporter.log("Login Successfully as "+uname);
//
//		} catch (AssertionError e) {
//			Reporter.log("Login failed");
//		}
		
		return new AdminHomePage();
	}

	

}
