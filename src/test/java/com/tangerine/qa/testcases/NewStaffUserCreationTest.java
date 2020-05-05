package com.tangerine.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.AdminHomePage;
import com.tangerine.qa.pages.HomePage;
import com.tangerine.qa.pages.LoginPage;
import com.tangerine.qa.pages.NewStaffUserCreationPage;
import com.tangerine.qa.pages.ResellerCreationPage;

import utils.TimeUtil;

public class NewStaffUserCreationTest extends TestBase {

	public NewStaffUserCreationTest() {

		super();
	}
	
	static ExtentTest test;
	static ExtentReports report;

	LoginPage loginPage;
	HomePage homePage;
	AdminHomePage adminHomePage;
	NewStaffUserCreationPage staffUserPage;

	@BeforeTest
	public void setUp() {

		adminInitialization();

		loginPage = new LoginPage();
		adminHomePage = new AdminHomePage();
		staffUserPage = new NewStaffUserCreationPage();

	}

	@Test(priority = 1)
	public void newStaffUserCreation() {

		loginPage.adminDashboardLogin(prop.getProperty("it_manager"), prop.getProperty("it_manager_password"));

		TimeUtil.timeDelay(5);
		adminHomePage.userManagemtclick();

		TimeUtil.timeDelay(3);
		adminHomePage.clickOnStaffUsers();

		TimeUtil.timeDelay(5);
		staffUserPage.staffUserCreation();

		TimeUtil.timeDelay(3);
		adminHomePage.userNameClick();

		TimeUtil.timeDelay(2);
		adminHomePage.logOutClick();
		
		

	}
	
	@AfterTest
	
	public void closeBrowser() {
		
		driver.quit();
	}

}
