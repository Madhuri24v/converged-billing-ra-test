package tangerine_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utils.TimeUtil;

public class ResellerRequests extends TestBase{

	static WebDriver driver;

	public ResellerRequests(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/nav/ul/li[5]/a")
	WebElement mainMenuRequests;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/nav/ul/li[5]/div/ul/li[1]/a")
	WebElement submenuStockRequest;

	@FindBy(how = How.ID, using = "new-request-commission")
	WebElement newRequestButton;

	@FindBy(how = How.ID, using = "resellerRequestType")
	WebElement requestType;
	Select requestTypedropdown = new Select(requestType);

	@FindBy(how = How.ID, using = "resellerProductType")
	WebElement productType;
	Select productTypedropdown = new Select(productType);

	@FindBy(how = How.ID, using = "quantity")
	WebElement quantity;

	@FindBy(how = How.ID, using = "plan-group")
	WebElement service;
	Select servicedropdown = new Select(service);

	@FindBy(how = How.ID, using = "plan-group-start_0")
	WebElement serviceBundle;
	Select serviceBundledropdown = new Select(serviceBundle);

	@FindBy(how = How.ID, using = "airtimeVoucher")
	WebElement airTimeBundle;
	Select airTimeBundledropdown = new Select(airTimeBundle);

	@FindBy(how = How.ID, using = "tariffType") // same id
	WebElement productCategory;

	@FindBy(how = How.ID, using = "planD")
	WebElement productSubCategory;

	@FindBy(how = How.ID, using = "plan-gp-start_0") // same id
	WebElement selectProductMifi;

	@FindBy(how = How.XPATH, using = "//*[@id=\"add-application-container-add-port\"]/i")
	WebElement addMoreButton;

	@FindBy(how = How.ID, using = "new-plan-upload")
	WebElement cancelButton;

	@FindBy(how = How.ID, using = "new-plan-upload") // sameid
	WebElement uploadButton;

	public void SimWithAirtime(WebDriver driver2) throws IOException {

		
		mainMenuRequests.click();
		submenuStockRequest.click();
		requestTypedropdown.selectByVisibleText(prop.getProperty("Products"));
		productTypedropdown.selectByVisibleText(prop.getProperty("SIMwithAirtime"));
		airTimeBundledropdown.selectByVisibleText(prop.getProperty("addAirtimrBalance"));
		quantity.sendKeys(prop.getProperty("quantity"));
		uploadButton.click();

	}

	public void SimWithBundle() throws IOException {

		

		requestTypedropdown.selectByVisibleText(prop.getProperty(""));
		productTypedropdown.selectByVisibleText(prop.getProperty(""));
		quantity.sendKeys(prop.getProperty(""));
		servicedropdown.selectByVisibleText(prop.getProperty(""));
		service.sendKeys(prop.getProperty(""));
		serviceBundle.sendKeys(prop.getProperty(""));
		uploadButton.click();

	}

	public void SimWithAirtimeBundle() throws IOException {

		

		requestType.sendKeys(prop.getProperty(""));
		productType.sendKeys(prop.getProperty(""));
		quantity.sendKeys(prop.getProperty(""));
		airTimeBundle.sendKeys(prop.getProperty(""));
		service.sendKeys(prop.getProperty(""));
		serviceBundle.sendKeys(prop.getProperty(""));
		uploadButton.click();

	}

}
