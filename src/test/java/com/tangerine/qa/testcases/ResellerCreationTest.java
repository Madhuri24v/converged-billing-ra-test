package com.tangerine.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.AdminHomePage;
import com.tangerine.qa.pages.HomePage;
import com.tangerine.qa.pages.LoginPage;
import com.tangerine.qa.pages.ProductRequestsPage;
import com.tangerine.qa.pages.ResellerCreationPage;

import utils.TimeUtil;

public class ResellerCreationTest extends TestBase {

	public ResellerCreationTest() {

		super();
	}
	
	
	LoginPage loginPage;
	HomePage homePage;
	AdminHomePage adminHomePage;
	ResellerCreationPage resellerCreationPage;
	



	@BeforeTest
	public void setUp() {

		adminInitialization();

		loginPage = new LoginPage();
		adminHomePage = new AdminHomePage();
		resellerCreationPage = new ResellerCreationPage();
		

	}

	
	@Test(priority = 1)

	public void createNewResellerUser() {

		
		loginPage.adminDashboardLogin(prop.getProperty("finance_assistant"),
				prop.getProperty("finance_assistant_password"));
		
	    TimeUtil.timeDelay(2);
		adminHomePage.userManagemtclick();
		TimeUtil.timeDelay(2);
		adminHomePage.resellerUsersClick();
		TimeUtil.timeDelay(5);
		resellerCreationPage.newResellerUserCreation();
		TimeUtil.timeDelay(3);
		adminHomePage.userNameClick();
		TimeUtil.timeDelay(2);
		adminHomePage.logOutClick();
		
	
	
	}

	@Test(priority = 2)

	public void approveResellerDocuments() {

		

		
		TimeUtil.timeDelay(15);

		loginPage.adminDashboardLogin(prop.getProperty("anti_money"),
				prop.getProperty("anti_money_password"));
		
		TimeUtil.timeDelay(5);
		adminHomePage.resellerManagementClick();
		TimeUtil.timeDelay(2);
		adminHomePage.resellerApprovalsClick();
		TimeUtil.timeDelay(7);
		resellerCreationPage.resellerDocumentApprovals();
		TimeUtil.timeDelay(10);
		adminHomePage.userNameClick();
		TimeUtil.timeDelay(2);
		adminHomePage.logOutClick();
	}
	
	@Test(priority = 3)

	public void activateReseller() {

		TimeUtil.timeDelay(10);
		

		loginPage.adminDashboardLogin(prop.getProperty("finance_manager"),
				prop.getProperty("finance_manager_password"));
		
		TimeUtil.timeDelay(5);
		adminHomePage.resellerManagementClick();
		TimeUtil.timeDelay(2);
		adminHomePage.resellerApprovalsClick();
		TimeUtil.timeDelay(5);
		resellerCreationPage.resellerActivation();
		TimeUtil.timeDelay(3);
		adminHomePage.userNameClick();
		TimeUtil.timeDelay(2);
		adminHomePage.logOutClick();

	}
	
	@Test(priority = 4)

	public void resellerPasswordChange() {

		TimeUtil.timeDelay(10);
		

		loginPage.adminDashboardLogin(prop.getProperty("finance_assistant"),
				prop.getProperty("finance_assistant_password"));
		
		TimeUtil.timeDelay(5);
		adminHomePage.userManagemtclick();
		TimeUtil.timeDelay(2);
		adminHomePage.resellerUsersClick();
		TimeUtil.timeDelay(5);
		resellerCreationPage.passwordChange();
		TimeUtil.timeDelay(3);
		adminHomePage.userNameClick();
		TimeUtil.timeDelay(2);
		adminHomePage.logOutClick();

	}
	
	
	@AfterTest
	
	public void closeBrowser() {
		
		
		TimeUtil.timeDelay(2);
		driver.quit();
	}

}
