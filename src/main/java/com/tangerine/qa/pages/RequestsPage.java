package com.tangerine.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tangerine.qa.base.TestBase;

import utils.TimeUtil;

public class RequestsPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//*[@id=\"new-request-commission\"]/span")
	WebElement newRequestBtn;

	@FindBy(how = How.ID, using = "resellerRequestType")
	WebElement requestType;

	@FindBy(how = How.ID, using = "selectVoucherBundle")
	WebElement voucherBundle;

	@FindBy(how = How.ID, using = "plan-group-start_0")
	WebElement bundle;

	@FindBy(how = How.ID, using = "resellerProductType")
	WebElement resellerProductType;

	@FindBy(how = How.ID, using = "airtimeVoucher")
	WebElement airtimeVoucher;

	@FindBy(how = How.ID, using = "quantity")
	WebElement quantity;

	@FindBy(how = How.ID, using = "submitRequest")
	WebElement submitRequest;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/div[5]/div/div[1]/div/div[2]/div/div/table/tbody/tr[1]/td[3]")
	WebElement creationTime;

	public RequestsPage() {

		PageFactory.initElements(driver, this);

	}

	public void simWithAirtimeRequest(String req, String productType, String airtime, String qn) {

		TimeUtil.timeDelay(3);
		System.out.println("entered");
		newRequestBtn.click();
		System.out.println("entered");
		TimeUtil.timeDelay(1);
		Select requestTypedropdown = new Select(requestType);
		requestTypedropdown.selectByVisibleText(req);
		TimeUtil.timeDelay(1);
		Select resellerProductTypedropdown = new Select(resellerProductType);
		resellerProductTypedropdown.selectByVisibleText(productType);
		TimeUtil.timeDelay(1);
		Select airtimeVoucherdropdown = new Select(airtimeVoucher);
		airtimeVoucherdropdown.selectByVisibleText(airtime);
		TimeUtil.timeDelay(1);
		quantity.sendKeys(qn);
		TimeUtil.timeDelay(1);
		submitRequest.click();

//		String time = driver.findElement(By
//				.xpath("/html/body/div[1]/div/div/div[2]/div[5]/div/div[1]/div/div[2]/div/div/table/tbody/tr[1]/td[3]"))
//				.getText();

	}

	public void eVoucherRequest(String req, String voucherbundle, String vbundle, String qn) {

		TimeUtil.timeDelay(3);
		newRequestBtn.click();

		TimeUtil.timeDelay(1);
		Select requestTypedropdown = new Select(requestType);
		requestTypedropdown.selectByVisibleText(req);

		TimeUtil.timeDelay(1);
		Select voucherBundleDropdown = new Select(voucherBundle);
		voucherBundleDropdown.selectByVisibleText(voucherbundle);

		TimeUtil.timeDelay(1);
		Select bundledropdown = new Select(bundle);
		bundledropdown.selectByVisibleText(vbundle);

		TimeUtil.timeDelay(1);
		quantity.sendKeys(qn);
		TimeUtil.timeDelay(1);
		submitRequest.click();

	}

}