package com.tangerine.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.testng.Assert;


import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.HomePage;
import com.tangerine.qa.pages.LoginPage;
import com.tangerine.qa.pages.RequestsPage;
import com.tangerine.qa.testInputs.ResellerConstants;

import utils.TimeUtil;

public class ResellerRequestsTest extends TestBase {

	public ResellerRequestsTest() {

		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	RequestsPage requestsPage;
	
	@BeforeMethod
	public void setUp() {

		resellerInitialization();
		
		TimeUtil.timeDelay(60);

		loginPage = new LoginPage();
		requestsPage =new RequestsPage();

		//homePage = loginPage.login(prop.getProperty(ResellerConstants.companyName), prop.getProperty(ResellerConstants.password));
		homePage = loginPage.login(prop.getProperty("madhuri412"), prop.getProperty(("Tangerine123")));

	}

	@Test(priority=1)
	public void simWithAirtime() {

		homePage.clickOnStockRequestSubTab();
		TimeUtil.timeDelay(2);
		requestsPage.simWithAirtimeRequest("Products","SIM with Airtime","5000","1");
		
	}
	
	@Test(priority=2)
	public void eVoucherRequests() {

		TimeUtil.timeDelay(5);
		homePage.clickOnStockRequestSubTab();
		TimeUtil.timeDelay(5);
		requestsPage.eVoucherRequest("E-Voucher", "Africa", "10000-Africa", "10");
	}
	
	 
	
	@AfterMethod
	public void close() {
		TimeUtil.timeDelay(3);
		driver.quit();
		
	}
	

}
