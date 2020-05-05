package com.tangerine.qa.pages;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.testInputs.ResellerConstants;

import utils.TimeUtil;

public class ResellerCreationPage extends TestBase {

	static ExtentTest test;
	static ExtentReports report;
	
	
	
	@FindBy(how = How.ID, using = "new-user-button")
	WebElement newResellerUserButton;

	@FindBy(how = How.ID, using = "new email Confirmation")
	WebElement email;

	@FindBy(how = How.ID, using = "user Confirmation")
	WebElement phoneNumber;

	@FindBy(how = How.ID, using = "company Confirmation")
	WebElement companyName;

	@FindBy(how = How.ID, using = "tin Confirmation")
	WebElement tinNumber;

	@FindBy(how = How.ID, using = "coi Confirmation")
	WebElement coiNumber;

	@FindBy(how = How.ID, using = "name Confirmation")
	WebElement primaryUserName;

	@FindBy(how = How.ID, using = "phone Confirmation")
	WebElement phoneConfirmation;

	@FindBy(how = How.ID, using = "primary email up Confirmation")
	WebElement primaryEmail;

	@FindBy(how = How.ID, using = "alernate name Confirmation")
	WebElement alternatePersonName;

	@FindBy(how = How.ID, using = "ph-number-Confirmation")
	WebElement alternatePhoneConfirmation;

	@FindBy(how = How.ID, using = "alternamte-email-Confirmation")
	WebElement alternateEmailConfirmation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
	WebElement billingAddressButton;

	@FindBy(how = How.ID, using = "land line 2 Confirmation")
	WebElement landLineNumber;

	@FindBy(how = How.ID, using = "alternate number Confirmation")
	WebElement alternateMobilenumber;

	@FindBy(how = How.ID, using = "address20")
	WebElement physicalAddress;

	@FindBy(how = How.ID, using = "user address postalAddress")
	WebElement postalAddress;

	@FindBy(how = How.ID, using = "select-city0")
	WebElement city;

	@FindBy(how = How.ID, using = "add-documents")
	WebElement AddDocumentsButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"accordion1\"]/div[1]/div[1]/h4/a")
	WebElement documentsUpload;

	@FindBy(how = How.ID, using = "imgInpincorporation_certificate-company-f")
	WebElement incorporation;

	@FindBy(how = How.ID, using = "imgInptax_clearance-company-f")
	WebElement taxClearence;

	@FindBy(how = How.ID, using = "imgInpDIN-company-f")
	WebElement directorIds;

	@FindBy(how = How.ID, using = "imgInpMOA-company-f")
	WebElement memorandom;

	@FindBy(how = How.ID, using = "imgInputility_bills-company-f")
	WebElement utilityBills;

	@FindBy(how = How.ID, using = "upload-documents")
	WebElement uploadDocumentsButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"accordion1\"]/div[2]/div[1]/h4/a")
	WebElement contractInformstion;

	@FindBy(how = How.ID, using = "periodNMonths")
	WebElement contractPeriod;

	@FindBy(how = How.ID, using = "additionalTerms")
	WebElement additionalTerms;

	@FindBy(how = How.ID, using = "additionalNotes")
	WebElement additionalNotes;

	@FindBy(how = How.ID, using = "submit-order")
	WebElement placeOrder;

	// ===============================resellerApprovals==================================//
	@FindBy(how = How.ID, using = "new-reseller-button")
	WebElement newResellerButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"selectReseller\"]/a/span[3]") // *[@id="selectReseller"]/a/span[3]
	WebElement selectResellerUser;

	@FindBy(how = How.XPATH, using = "//*[@id=\"selectReseller\"]/div/div/input")
	WebElement searchResellerUser;

	@FindBy(how = How.ID, using = "approve_0")
	WebElement utilityBillsApproval;

	@FindBy(how = How.ID, using = "approve_1")
	WebElement taxClearenceApproval;

	@FindBy(how = How.ID, using = "approve_2")
	WebElement MOAApproval;

	@FindBy(how = How.ID, using = "approve_3")
	WebElement DinApproval;

	@FindBy(how = How.ID, using = "approve_4")
	WebElement incorporationCertificateApproval;

	@FindBy(how = How.ID, using = "reseller_submit")
	WebElement resellerDetailsSubmitButton;

	// ==============================resellerActivation==============================//

	@FindBy(how = How.ID, using = "search")
	WebElement search;

	@FindBy(how = How.XPATH, using = "//*[@id=\"toggle_demand\"]/div")
	WebElement activateToggleButton;

	@FindBy(how = How.ID, using = "yesid")
	WebElement activationPopUp;

	// =============================ResellerPasswordChange==============================//

	@FindBy(how = How.XPATH, using = "//*[@id=\"subscriber\"]/tbody/tr[1]/td[2]/span/span/span/a")
	WebElement clickOnResellerName;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[3]/div[3]/div/div/div[2]/label[1]")
	WebElement clickOnTab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"resellerMarzen\"]/div[1]/div[3]/div[5]/div[2]/button/a")
	WebElement clickOnChangePassword;
	
	
	@FindBy(how = How.ID, using = "password")
	WebElement password;
	
	@FindBy(how = How.ID, using = "password_c")
	WebElement confirmPassword;
	
	
	@FindBy(how = How.ID, using = "password_update")
	WebElement clickOnSubmitButton;
	
	

	LocalDate localDate = LocalDate.now();

	public ResellerCreationPage() {

		PageFactory.initElements(driver, this);

	}

	public void newResellerUserCreation() {
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("Reseller Creation");

		TimeUtil.timeDelay(1);
		newResellerUserButton.click();

		TimeUtil.timeDelay(1);
		email.sendKeys(ResellerConstants.email);

		TimeUtil.timeDelay(1);
		phoneNumber.sendKeys(ResellerConstants.phoneNumber);

		TimeUtil.timeDelay(1);
		companyName.sendKeys(ResellerConstants.companyName);

		TimeUtil.timeDelay(1);
		tinNumber.sendKeys(ResellerConstants.tinNumber);

		TimeUtil.timeDelay(1);
		coiNumber.sendKeys(ResellerConstants.coiNumber);

		TimeUtil.timeDelay(1);
		primaryUserName.sendKeys(ResellerConstants.primaryUserName);

		TimeUtil.timeDelay(1);
		phoneConfirmation.sendKeys(ResellerConstants.phoneConfirmation);

		TimeUtil.timeDelay(1);
		primaryEmail.sendKeys(ResellerConstants.primaryEmail);

		TimeUtil.timeDelay(1);
		alternatePersonName.sendKeys(ResellerConstants.alternatePersonName);

		TimeUtil.timeDelay(1);
		alternatePhoneConfirmation.sendKeys(ResellerConstants.alternatePhoneConfirmation);

		TimeUtil.timeDelay(1);
		alternateEmailConfirmation.sendKeys(ResellerConstants.alternateEmailConfirmation);

		TimeUtil.timeDelay(1);
		billingAddressButton.click();

		TimeUtil.timeDelay(1);
		landLineNumber.sendKeys(ResellerConstants.landLineNumber);

		TimeUtil.timeDelay(1);
		alternateMobilenumber.sendKeys(ResellerConstants.alternateMobilenumber);

		TimeUtil.timeDelay(1);
		physicalAddress.sendKeys(ResellerConstants.physicalAddress);

		TimeUtil.timeDelay(1);
		postalAddress.sendKeys(ResellerConstants.postalAddress);

		TimeUtil.timeDelay(2);
		Select cityDropdown = new Select(city);
		cityDropdown.selectByVisibleText(ResellerConstants.cityDropdown);

		TimeUtil.timeDelay(1);
		AddDocumentsButton.click();

		TimeUtil.timeDelay(1);
		documentsUpload.click();

		TimeUtil.timeDelay(2);
		incorporation.sendKeys(ResellerConstants.incorporation);

		TimeUtil.timeDelay(2);
		taxClearence.sendKeys(ResellerConstants.taxClearence);

		TimeUtil.timeDelay(2);
		directorIds.sendKeys(ResellerConstants.directorIds);

		TimeUtil.timeDelay(2);
		memorandom.sendKeys(ResellerConstants.memorandom);

		TimeUtil.timeDelay(2);
		utilityBills.sendKeys(ResellerConstants.utilityBills);

		TimeUtil.timeDelay(5);
		uploadDocumentsButton.click();

		TimeUtil.timeDelay(2);
		contractInformstion.click();

		TimeUtil.timeDelay(1);
		contractPeriod.sendKeys(ResellerConstants.contractPeriod);

		TimeUtil.timeDelay(1);
		additionalTerms.sendKeys(ResellerConstants.additionalTerms);

		TimeUtil.timeDelay(1);
		additionalNotes.sendKeys(ResellerConstants.additionalNotes);

		TimeUtil.timeDelay(1);
		placeOrder.click();
		
		TimeUtil.timeDelay(3);
		String taoastTitle = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("Reseler User created : "+taoastTitle);
		test.log(LogStatus.INFO, taoastTitle);


		TimeUtil.timeDelay(5);
		search.sendKeys(ResellerConstants.companyName);

		TimeUtil.timeDelay(12);
		try {
			String resellerActive = driver
					.findElement(By.xpath("//*[@id=\"subscriber\"]/tbody/tr/td[2]/span/span/span/a")).getText();
			Assert.assertEquals(resellerActive, "Inactive");
			System.out.println(resellerActive);
			Reporter.log("Reseller Created SuccessFully, Reseller Name is " + ResellerConstants.companyName);
			test.log(LogStatus.PASS,"Reseller Created SuccessFully, Reseller Name is " + ResellerConstants.companyName );

		} catch (AssertionError e) {
			Reporter.log("Reseller Activation Failed ");
			test.log(LogStatus.FAIL,"Reason :"+taoastTitle );
		}

	}

	public void resellerDocumentApprovals() {

		TimeUtil.timeDelay(2);
		newResellerButton.click();

		TimeUtil.timeDelay(4);
		selectResellerUser.click();

		TimeUtil.timeDelay(2);
		searchResellerUser.sendKeys(ResellerConstants.companyName);

		TimeUtil.timeDelay(2);
		searchResellerUser.sendKeys(Keys.ENTER);

		TimeUtil.timeDelay(2);
		utilityBillsApproval.click();
		TimeUtil.timeDelay(2);
		String taoastTitle = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("utilityBillsApproval Document uploaded: "+taoastTitle);
		test.log(LogStatus.INFO, "utilityBillsApproval Document uploaded: "+taoastTitle);

		TimeUtil.timeDelay(2);
		taxClearenceApproval.click();
		TimeUtil.timeDelay(2);
		String taoastTitle1 = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("taxClearenceApproval Document uploaded: "+taoastTitle1);
		test.log(LogStatus.INFO, "taxClearenceApproval Document uploaded: "+taoastTitle1);

		TimeUtil.timeDelay(2);
		MOAApproval.click();
		TimeUtil.timeDelay(2);
		String taoastTitle3 = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("MOAApproval Document uploaded: "+taoastTitle3);
		test.log(LogStatus.INFO, "MOAApproval Document uploaded: "+taoastTitle3);

		TimeUtil.timeDelay(2);
		DinApproval.click();
		TimeUtil.timeDelay(2);
		String taoastTitle4 = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("DinApproval Document uploaded: "+taoastTitle4);
		test.log(LogStatus.INFO, "DinApproval Document uploaded: "+taoastTitle4);
		
		TimeUtil.timeDelay(2);
		incorporationCertificateApproval.click();
		TimeUtil.timeDelay(2);
		String taoastTitle5 = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("incorporationCertificateApproval Document uploaded: "+taoastTitle5);
		test.log(LogStatus.INFO, "incorporationCertificateApproval Document uploaded: "+taoastTitle5);
		
		TimeUtil.timeDelay(5);
		resellerDetailsSubmitButton.click();
		TimeUtil.timeDelay(2);
		String taoastTitle6 = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("All Documents uploaded: "+taoastTitle6);
		test.log(LogStatus.INFO, "All Documents uploaded: "+taoastTitle6);
		
		

	}

	public void resellerActivation() {

		TimeUtil.timeDelay(2);
		search.sendKeys(ResellerConstants.companyName);

		TimeUtil.timeDelay(3);
		activateToggleButton.click();

		TimeUtil.timeDelay(2);
		activationPopUp.click();

		TimeUtil.timeDelay(3);
		String taoastTitle = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		Reporter.log("Reseller Activation : "+taoastTitle);
		
		
		TimeUtil.timeDelay(5);
		

		try {
			String resellerActive = driver
					.findElement(
							By.xpath("//*[@id=\"subscriber\"]/tbody/tr/td[5]/span/span/span/ng-bind-angular-html/span"))
					.getText();
			Assert.assertEquals(resellerActive, "Active");
			System.out.println(resellerActive);
			Reporter.log("Reseller Activated SuccessFully, Reseller Name is " +ResellerConstants.companyName);
			test.log(LogStatus.INFO,"Reseller Activated SuccessFully, Reseller Name is "+ResellerConstants.companyName);

		} catch (AssertionError e) {
			Reporter.log("Reseller Activation Failed ");
			test.log(LogStatus.FAIL, "Reason :"+taoastTitle);
		}

	}

	public void passwordChange() {

		TimeUtil.timeDelay(7);
		search.sendKeys(ResellerConstants.companyName);

		TimeUtil.timeDelay(5);
		Actions action = new Actions(driver);
		action.moveToElement(clickOnResellerName).perform();
		action.moveToElement(clickOnResellerName).click().perform();
		
		TimeUtil.timeDelay(5);
		//clickOnResellerName.click();
		
		TimeUtil.timeDelay(2);
		clickOnTab.click();
		
		TimeUtil.timeDelay(2);
		clickOnChangePassword.click();

		TimeUtil.timeDelay(1);
		password.sendKeys(ResellerConstants.password);
		

		TimeUtil.timeDelay(1);
		confirmPassword.sendKeys(ResellerConstants.confirmPassword);

		TimeUtil.timeDelay(1);
		clickOnSubmitButton.click();
		

		
		TimeUtil.timeDelay(3);
		String name = driver.switchTo().alert().getText();
		test.log(LogStatus.INFO, name);
		TimeUtil.timeDelay(1);
		driver.switchTo().alert().accept();

		Reporter.log(name);
	}
}
