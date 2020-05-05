package tangerine_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testBase.TestBase;

public class ResellerHomePage extends TestBase {

	@FindBy(how = How.XPATH, using = "//*[@id=\"profileDropdown\"]/div[2]/p")
	WebElement userNameLable;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sidebar\"]/ul/li[5]/a")
	WebElement requestMainMenu;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[1]/a")
	WebElement stockRequests;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[2]/a")
	WebElement distributorEtopupWallet;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[3]/a")
	WebElement distributorPhysicalProductRequest;

	@FindBy(how = How.XPATH, using = "//*[@id=\"requests\"]/ul/li[4]/a")
	WebElement distributorVoucherRequest;

	public ResellerHomePage(WebDriver driver) {

		this.driver = driver;
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();

	}

	public void clickOnRequestTab() {

		requestMainMenu.click();

	}
//
//	public void ResellerRequests  clickOnstockRequestsSubTab() {
//
//		requestMainMenu.click();
//		
//		
//		
//		return new ResellerRequests(null);
//
//	}

}
