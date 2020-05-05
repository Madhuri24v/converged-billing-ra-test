package com.tangerine.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;

import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.HomePage;
import com.tangerine.qa.pages.LoginPage;
import com.tangerine.qa.pages.RequestsPage;

import utils.TimeUtil;

public class HomePageTest extends TestBase {

	public HomePageTest() {

		super();
	}

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {

		resellerInitialization();

		loginPage = new LoginPage();

		homePage = loginPage.login(prop.getProperty("reseller_username"), prop.getProperty("reseller_password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleForReseller() {

		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Reseller Dashboard | Tangerine", "Home Page not Matched");
	}

	@AfterMethod
	public void close() {
		TimeUtil.timeDelay(3);
		driver.quit();

	}

}
