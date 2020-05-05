package tangerine_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.TimeUtil;

public class ProductBundle {

	public static void ApproveInwardstock(WebDriver driver) throws IOException {

		Properties prop = new Properties();
		FileInputStream login = new FileInputStream(
				"/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/Inputs/SimInventoryInputs.properties");

		prop.load(login);

		TimeUtil.timeDelay(2);
		WebElement warehouse = driver.findElement(By.id("wareHouse"));
		warehouse.click();

		TimeUtil.timeDelay(2);
		WebElement stockMovement = driver.findElement(By.xpath("//*[@id=\"wareHouseBody\"]/ul/li[5]/a"));
		stockMovement.click();

		TimeUtil.timeDelay(2);
		WebElement search = driver.findElement(By.id("search"));
		search.sendKeys(prop.getProperty("productName"));

		TimeUtil.timeDelay(2);
		WebElement action = driver.findElement(By.id("action_11_button"));
		action.click();

		TimeUtil.timeDelay(2);
		WebElement approve = driver.findElement(By.xpath("//*[@id=\"generic-cluster-button-drop11\"]/div/ul/li/a"));
		approve.click();

	}

	public static void BundlingProduct(WebDriver driver) throws IOException {

		Properties prop = new Properties();
		FileInputStream login = new FileInputStream(
				"/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/Inputs/SimInventoryInputs.properties");

		prop.load(login);

		TimeUtil.timeDelay(2);
		WebElement warehouse = driver.findElement(By.id("wareHouse"));
		warehouse.click();

		TimeUtil.timeDelay(2);
		WebElement productBundles = driver.findElement(By.xpath("//*[@id=\"wareHouseBody\"]/ul/li[7]/a"));
		productBundles.click();

		TimeUtil.timeDelay(2);
		WebElement newproductBundles = driver.findElement(By.id("new-plans-button"));
		newproductBundles.click();

		TimeUtil.timeDelay(2);
		WebElement bundleName = driver.findElement(By.id("planType"));
		bundleName.sendKeys(prop.getProperty("productBundleName"));

		TimeUtil.timeDelay(2);
		WebElement description = driver.findElement(By.id("narration"));
		description.sendKeys(prop.getProperty("Description"));

		TimeUtil.timeDelay(2);
		WebElement bundlePrice = driver.findElement(By.id("bundlePrice"));
		bundlePrice.sendKeys(prop.getProperty("bundlePrice"));

		TimeUtil.timeDelay(2);
		WebElement bundleQuantity = driver.findElement(By.id("inwardQuantity"));
		bundleQuantity.sendKeys(prop.getProperty("bundleQuantity"));

		TimeUtil.timeDelay(2);
		Select baseServiceBundle = new Select(driver.findElement(By.id("bundlePrice")));
		baseServiceBundle.selectByVisibleText(prop.getProperty("basePlan"));

		TimeUtil.timeDelay(2);
		Select productCategory = new Select(driver.findElement(By.id("productCategory")));
		productCategory.selectByVisibleText(prop.getProperty("productCategory"));

		TimeUtil.timeDelay(2);
		Select product = new Select(driver.findElement(By.id("selectProduct")));
		product.selectByVisibleText(prop.getProperty("productName"));

		TimeUtil.timeDelay(2);
		WebElement saveAndContinue = driver.findElement(By.id("save-and-continue-foriegner"));
		saveAndContinue.click();

		TimeUtil.timeDelay(2);
		WebElement lotSelect = driver.findElement(By.xpath(
				"//*[@id=\"panel\"]/div[2]/div/div/accordion/div/div[1]/div[2]/div/table/tbody/tr/td[1]/div/label"));
		lotSelect.click();

		TimeUtil.timeDelay(2);
		WebElement saveAndContinue1 = driver.findElement(By.id("submit-docs"));
		saveAndContinue1.click();
		
		
		String text = driver.findElement(By.className("ng-toast")).getText();
		System.out.println(text);



		
		
	}
}
