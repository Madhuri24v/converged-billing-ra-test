package com.tangerine.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.HomePage;
import com.tangerine.qa.pages.LoginPage;

import utils.TimeUtil;

public class LoginPageTest extends TestBase {

	
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp() {
		
		
		resellerInitialization();
		
		loginPage = new LoginPage();
		
			
	}
	
	
	@Test(priority=1)
	public void titilePageValidateTest() {
		
		String title=loginPage.validateLoginPage();
		
		Assert.assertEquals(title, "Reseller Login | Lycamobile");
	}
	
	@Test(priority=2)
	public void titilePageLogoTest() {
		
		boolean flag=loginPage.validateLycaLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		
		TimeUtil.timeDelay(5);
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void close() {
		TimeUtil.timeDelay(3);
		driver.quit();
		
	}
	
}
