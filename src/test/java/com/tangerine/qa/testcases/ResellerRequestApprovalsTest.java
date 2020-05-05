package com.tangerine.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.AdminHomePage;
import com.tangerine.qa.pages.HomePage;
import com.tangerine.qa.pages.LoginPage;
import com.tangerine.qa.pages.ProductRequestsPage;
import com.tangerine.qa.pages.RequestsPage;

import utils.TimeUtil;

public class ResellerRequestApprovalsTest extends TestBase {

	public ResellerRequestApprovalsTest() {

		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	AdminHomePage adminHomePage;
	ProductRequestsPage productsRequestsPage;

	@BeforeTest
	public void setUp() {

		adminInitialization();

		loginPage = new LoginPage();
		adminHomePage = new AdminHomePage();
		productsRequestsPage = new ProductRequestsPage();

	}

	@Test(priority = 1)

	public void approvingProductRequest() {

		loginPage.adminDashboardLogin(prop.getProperty("warehouse_admin"),
				prop.getProperty("warehouse_admin_password"));
		TimeUtil.timeDelay(2);
		adminHomePage.clickOnMarketingTab();
		TimeUtil.timeDelay(2);
		adminHomePage.productRequestTab();
		TimeUtil.timeDelay(5);
		productsRequestsPage.physicalStockVerification("2", "2", "1");
		String taoastTitle = driver.findElement(By.cssSelector("ng-toast")).getText();
		Reporter.log(taoastTitle);

	}

//	@Test(priority = 1)
//
//	public void eVoucherRequests() {
//
//		loginPage.adminDashboardLogin(prop.getProperty("sales_admin"),
//				prop.getProperty("sales_admin_password"));
//		TimeUtil.timeDelay(2);
//		adminHomePage.clickOnMarketingTab();
//		TimeUtil.timeDelay(2);
//		adminHomePage.eVoucherRequestTab();
//		TimeUtil.timeDelay(5);
//		productsRequestsPage.physicalStockVerification("2", "2", "1");
//		String taoastTitle = driver.findElement(By.cssSelector("ng-toast")).getText();
//		Reporter.log(taoastTitle);
//
//	}

//	@AfterTest
//
//	public void teardown() {
//
//		driver.quit();
//	}

}
