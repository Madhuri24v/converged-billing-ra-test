package com.tangerine.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.tangerine.qa.base.TestBase;

import utils.TimeUtil;

public class HomePage extends TestBase {

	// ----------------Main Tabls -------------------------------------//
	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[4]/a")
	WebElement staffManagementTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[5]/a")
	WebElement requestsTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[6]/a")
	WebElement productManagementTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[7]/a")
	WebElement eTopupTab;
	
	
	

	// --------------subTabs-------------------------------------------//

	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-basic\"]/ul/li/a")
	WebElement staffUsersSubTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[1]/a")
	WebElement stockRequestsSubTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[2]/a")
	WebElement distribuorEtopupRequestsSubTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[3]/a")
	WebElement distribuorPhysicalProductRequestsSubTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[4]/a")
	WebElement distribuorVoucherRequestsSubTab;
	
	
	


	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	public RequestsPage clickOnStockRequestSubTab() {

		TimeUtil.timeDelay(3);

		requestsTab.click();

		TimeUtil.timeDelay(3);

		stockRequestsSubTab.click();
		
		TimeUtil.timeDelay(3);
		
	
		

		return new RequestsPage();

	}
	
	
	

}
