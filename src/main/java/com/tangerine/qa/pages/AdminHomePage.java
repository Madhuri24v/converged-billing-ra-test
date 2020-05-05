package com.tangerine.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tangerine.qa.base.TestBase;

import utils.TimeUtil;

public class AdminHomePage extends TestBase {

	// -------------Main Tabs---------------------------//

	// *[@id="marketing"]

	@FindBy(how = How.ID, using = "marketing")
	WebElement salesAndMarketingTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"marketingBody\"]/ul/li[2]/a")
	WebElement productRequestsSubTab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"action_5_button\"]/i")
	WebElement actionButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"generic-cluster-button-drop5-conditional\"]/div/ul/li/a")
	WebElement approveRequest;

	@FindBy(how = How.XPATH, using = "//*[@id=\"marketingBody\"]/ul/li[1]/a")
	WebElement airTimeVoucherRequest;

	@FindBy(how = How.XPATH, using = "//*[@id=\"marketingBody\"]/ul/li[3]/a")
	WebElement etopupRequest;

	@FindBy(how = How.XPATH, using = "///*[@id=\"marketingBody\"]/ul/li[4]/a")
	WebElement evoucherRequest;

	@FindBy(how = How.ID, using = "newuser")
	WebElement userManagement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"newuserBody\"]/ul/li[1]/a")
	WebElement resellerUsers;

	@FindBy(how = How.ID, using = "resellerManagement")
	WebElement resellerManagement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"resellerManagementBody\"]/ul[1]/li[1]/a[1]")
	WebElement resellerApprovals;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"newuserBody\"]/ul/li[3]")
	WebElement staffUsers;
	

	@FindBy(how = How.ID, using = "userNameDashboard")
	WebElement userName;

	@FindBy(how = How.ID, using = "logout")
	WebElement logOut;

	public AdminHomePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnMarketingTab() {

		salesAndMarketingTab.click();
	}

	public void airtimevoucherRequestTab() {

		airTimeVoucherRequest.click();
	}

	public void productRequestTab() {

		productRequestsSubTab.click();
	}

	public void etopupRequestTab() {

		etopupRequest.click();
	}

	public void eVoucherRequestTab() {

		etopupRequest.click();
	}

	public void approveRequestTab() {

		approveRequest.click();
	}

	public void ActionButtonclick() {

		actionButton.click();
	}

	public void userManagemtclick() {

		userManagement.click();

	}

	public void resellerUsersClick() {

		resellerUsers.click();

	}

	public void resellerManagementClick() {

		resellerManagement.click();

	}

	public void resellerApprovalsClick() {

		resellerApprovals.click();

	}
	public void userNameClick() {

		userName.click();

	}
	public void logOutClick() {

		logOut.click();

	}
	public void clickOnStaffUsers() {
		
		staffUsers.click();
	}
}
