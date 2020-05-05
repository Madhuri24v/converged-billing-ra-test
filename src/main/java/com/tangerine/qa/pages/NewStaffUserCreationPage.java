package com.tangerine.qa.pages;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.testInputs.ResellerConstants;
import com.tangerine.qa.testInputs.UserConstants;

import utils.TimeUtil;

public class NewStaffUserCreationPage extends TestBase {

	static ExtentTest test;
	static ExtentReports report;

	@FindBy(how = How.ID, using = "new-user-button")
	WebElement newStaffButton;

	@FindBy(how = How.ID, using = "customRadio4")
	WebElement foreignerRadioButton;

	@FindBy(how = How.ID, using = "given name")
	WebElement givenName;

	@FindBy(how = How.ID, using = "sure name")
	WebElement surName;

	@FindBy(how = How.ID, using = "new email")
	WebElement email;

	@FindBy(how = How.ID, using = "user-group")
	WebElement userGroup;

	@FindBy(how = How.ID, using = "allowedIpAddress")
	WebElement allowedIP;

	@FindBy(how = How.ID, using = "user")
	WebElement phoneNumber;

	@FindBy(how = How.ID, using = "user date of birth")
	WebElement dob;

	@FindBy(how = How.ID, using = "foreigner-passport-number")
	WebElement passportNumber;

	@FindBy(how = How.ID, using = "passport-type")
	WebElement passportType;

	@FindBy(how = How.ID, using = "visa exp Confirmation")
	WebElement visaExpiry;

	@FindBy(how = How.ID, using = "user-group nationality")
	WebElement nationality;

	@FindBy(how = How.ID, using = "land line 2")
	WebElement landLineNumber;

	@FindBy(how = How.ID, using = "alternate number")
	WebElement alternateNumber;

	@FindBy(how = How.ID, using = "address20")
	WebElement physicalAddress;

	@FindBy(how = How.ID, using = "user address")
	WebElement postalAddress;

	@FindBy(how = How.ID, using = "select-city0")
	WebElement city;

	@FindBy(how = How.ID, using = "imgInppassport-persanol-f")
	WebElement passportDoc;

	@FindBy(how = How.ID, using = "imgInpprofile-persanol-f")
	WebElement profileDoc;

	@FindBy(how = How.ID, using = "imgInpvisa-persanol-f")
	WebElement visaDoc;

	@FindBy(how = How.ID, using = "imgInpactivation-persanol-f")
	WebElement activationDoc;

	@FindBy(how = How.ID, using = "submit-docs")
	WebElement submit;

	@FindBy(how = How.ID, using = "save-and-continue-foriegner")
	WebElement saveAndContinue;

	@FindBy(how = How.ID, using = "save-and-continue-docs")
	WebElement addDocuments;

	LocalDate localDate = LocalDate.now();

	public NewStaffUserCreationPage() {

		PageFactory.initElements(driver, this);

	}

	public void staffUserCreation() {

		TimeUtil.timeDelay(5);
		newStaffButton.click();

		TimeUtil.timeDelay(2);
		foreignerRadioButton.click();

		TimeUtil.timeDelay(2);
		givenName.sendKeys(UserConstants.givenName);

		TimeUtil.timeDelay(2);
		surName.sendKeys(UserConstants.surName);

		TimeUtil.timeDelay(2);
		email.sendKeys(UserConstants.email);

		TimeUtil.timeDelay(2);
		TimeUtil.timeDelay(2);
		Select userGroupDropdown = new Select(userGroup);
		userGroupDropdown.selectByVisibleText(UserConstants.userGroup);

		TimeUtil.timeDelay(2);
		allowedIP.sendKeys(UserConstants.allowedIP);

		TimeUtil.timeDelay(2);
		phoneNumber.sendKeys(UserConstants.phoneNumber);

		TimeUtil.timeDelay(2);
		dob.sendKeys(UserConstants.dob);

		TimeUtil.timeDelay(2);
		passportNumber.sendKeys(UserConstants.passportNumber);

		TimeUtil.timeDelay(2);
		Select passportTypeDropdown = new Select(passportType);
		passportTypeDropdown.selectByVisibleText(UserConstants.passportType);

		TimeUtil.timeDelay(2);
		visaExpiry.sendKeys(UserConstants.visaExpiry);

		TimeUtil.timeDelay(2);
		Select nationalityDropdown = new Select(nationality);
		nationalityDropdown.selectByVisibleText(UserConstants.nationality);

		TimeUtil.timeDelay(2);
		saveAndContinue.click();

		TimeUtil.timeDelay(2);
		landLineNumber.sendKeys(UserConstants.landLineNumber);

		TimeUtil.timeDelay(2);
		alternateNumber.sendKeys(UserConstants.alternateNumber);

		TimeUtil.timeDelay(2);
		physicalAddress.sendKeys(UserConstants.physicalAddress);

		TimeUtil.timeDelay(2);
		postalAddress.sendKeys(UserConstants.postalAddress);

		TimeUtil.timeDelay(2);
		Select cityDropdown = new Select(city);
		cityDropdown.selectByVisibleText(UserConstants.city);

		TimeUtil.timeDelay(2);
		addDocuments.click();

		TimeUtil.timeDelay(2);
		profileDoc.sendKeys(UserConstants.profileDoc);

		TimeUtil.timeDelay(2);
		passportDoc.sendKeys(UserConstants.passportDoc);

		TimeUtil.timeDelay(2);
		visaDoc.sendKeys(UserConstants.visaDoc);

		TimeUtil.timeDelay(2);
		activationDoc.sendKeys(UserConstants.activationDoc);

		TimeUtil.timeDelay(2);
		submit.click();

		TimeUtil.timeDelay(5);
		String taoastTitle = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("Staff User Created : " + taoastTitle);
		test.log(LogStatus.INFO,"staff User Creared :"+ taoastTitle);

	}
}
