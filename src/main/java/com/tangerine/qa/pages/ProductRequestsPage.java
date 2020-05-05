package com.tangerine.qa.pages;

import java.sql.Time;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.tangerine.qa.base.TestBase;

import utils.TimeUtil;

public class ProductRequestsPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//*[@id=\"action_5_button\"]/i")
	WebElement actionButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"generic-cluster-button-drop5-conditional\"]/div/ul/li/a")
	WebElement verifyRequest;

	@FindBy(how = How.ID, using = "deviceDiscount")
	WebElement deviceDiscount;

	@FindBy(how = How.ID, using = "SIM_Airtime_Disc")
	WebElement airtimeDiscount;

	@FindBy(how = How.ID, using = "MIFI_SIM_Airtime")
	WebElement mifiSimAirtime;

	@FindBy(how = How.ID, using = "SIM_Bundle")
	WebElement bundleDiscount;

	@FindBy(how = How.ID, using = "MIFI_SIM_Bundle")
	WebElement mifiSimWithBundle;

	@FindBy(how = How.ID, using = "SIM_Airtime_Bundle_AirtimeDisc")
	WebElement simWithAirTimeBundleAT;

	@FindBy(how = How.ID, using = "SIM_Airtime_Bundle_BundleDisc")
	WebElement simWithAirTimeBundleBU;

	@FindBy(how = How.ID, using = "MIFI_SIM_Airtime_Bundle_AirtimeDisc")
	WebElement mifiSimWithAirTimeBundleAT;

	@FindBy(how = How.ID, using = "MIFI_SIM_Airtime_Bundle_BundleDisc")
	WebElement mifiSimWithAirTimeBundleBU;

	@FindBy(how = How.ID, using = "save-and-continue-foriegner")
	WebElement saveAndContinue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"m_wizard_form_step_2\"]/div/div/div/div/accordion/div/div/div[1]/h4/a/span")
	WebElement productBundleFullfill;

	@FindBy(how = How.XPATH, using = "//*[@id=\"m_wizard_form_step_2\"]/div/div/div/div/accordion/div/div/div[2]/div/table/tbody/tr[4]/td[1]/div/label")
	WebElement lotSelection;

	@FindBy(how = How.ID, using = "preview")
	WebElement preview;

	@FindBy(how = How.ID, using = "sharingMemberLimit")
	WebElement orderCount;

	@FindBy(how = How.XPATH, using = "//*[@id=\"m_wizard_form_step_3\"]/div/div/div/table/tbody/tr/td[1]")
	WebElement serialStart;

	@FindBy(how = How.XPATH, using = "//*[@id=\"m_wizard_form_step_3\"]/div/div/div/table/tbody/tr/td[2]")
	WebElement serialEnd;

	@FindBy(how = How.ID, using = "submit-docs")
	WebElement submit;
	
	
	
	
	
	@FindBy(how = How.ID, using = "search")
	WebElement search;

	public ProductRequestsPage() {

		PageFactory.initElements(driver, this);

	}

	public void physicalStockVerification(String deDiscount, String ATDiscount, String odcount) {

		TimeUtil.timeDelay(2);
		search.sendKeys(prop.getProperty("reseller_username"));
		
		TimeUtil.timeDelay(2);
		actionButton.click();
		TimeUtil.timeDelay(2);
		verifyRequest.click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("save-and-continue-foriegner")));
		deviceDiscount.sendKeys(deDiscount);
		airtimeDiscount.sendKeys(ATDiscount);
		saveAndContinue.click();
		productBundleFullfill.click();

		WebElement lot = driver.findElement(By.xpath(
				"//*[@id=\"m_wizard_form_step_2\"]/div/div/div/div/accordion/div/div/div[2]/div/table/tbody/tr[4]/td[1]"));
		lot.click();
		TimeUtil.timeDelay(2);

//		WebElement orddercount = driver.findElement(By.xpath(
//				"//*[@id=\"m_wizard_form_step_2\"]/div[1]/div[1]/div[1]/div[1]/accordion[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]"));
//		TimeUtil.timeDelay(2);
//
//		String before_xpath = "//*[@id=\"m_wizard_form_step_2\"]/div[1]/div[1]/div[1]/div[1]/accordion[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[";
//		String after_xpath = "]/td[2]";
//
//		for (int i = 3; i <= 4; i++) {
//
//			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			System.out.println(name);
//			
//			if (name.contains("SIM with Base plan-5512166212")) {
//				
//				
//				driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_2\"]/div[1]/div[1]/div[1]/div[1]/accordion[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/label[1]")).click();
//				TimeUtil.timeDelay(4);
//				
//			}
//
//		}
//		
//		
		
		
		TimeUtil.timeDelay(2);
		driver.findElement(By.id("sharingMemberLimit_3")).sendKeys("1");

		preview.click();
		TimeUtil.timeDelay(2);
		submit.click();
		
		
		TimeUtil.timeDelay(3);
		
		String taoastTitle = driver.findElement(By.cssSelector("ng-toast")).getText();
		Reporter.log(taoastTitle);

	}
	
	
	

	public void evoucherVerification(String deDiscount, String ATDiscount, String odcount) {

		TimeUtil.timeDelay(2);
		actionButton.click();
		TimeUtil.timeDelay(2);
		verifyRequest.click();

	}

}
