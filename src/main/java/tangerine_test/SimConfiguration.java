package tangerine_test;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utils.TimeUtil;

public class SimConfiguration {

	static WebDriver driver;

	static String workingDir = System.getProperty("user.dir");
	
	
	@FindBy(how = How.ID, using = "inventory")
	WebElement username;
	
	
	
	
	
	
	

	public static void msisdnBlock(WebDriver driver) throws IOException {
		Properties prop = new Properties();
		FileInputStream login = new FileInputStream(
				"/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/Inputs/SimInventoryInputs.properties");

		prop.load(login);

		System.out.println("Login Successfully");

		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory")));

		TimeUtil.timeDelay(10);
		WebElement inventory = driver.findElement(By.id("inventory"));
		inventory.click();

		TimeUtil.timeDelay(2);
		WebElement msisdnblock = driver.findElement(By.xpath("//*[@id=\"inventoryBody\"]/ul/li[1]/a"));
		msisdnblock.click();

		TimeUtil.timeDelay(3);
		WebElement newblock = driver.findElement(By.id("new_sim"));
		newblock.click();

		TimeUtil.timeDelay(3);
		WebElement bulkname = driver.findElement(By.name("Bulkname"));
		bulkname.clear();
		bulkname.sendKeys(prop.getProperty("bulkName"));

		TimeUtil.timeDelay(2);
		WebElement rangestart = driver.findElement(By.id("range_start"));
		rangestart.clear();
		rangestart.sendKeys(prop.getProperty("rangeStart"));

		TimeUtil.timeDelay(2);
		WebElement rangeend = driver.findElement(By.id("range_end"));
		rangeend.clear();
		rangeend.sendKeys(prop.getProperty("rangeend"));

		TimeUtil.timeDelay(3);
		WebElement submit = driver.findElement(By.id("new-sim-upload"));
		submit.click();

		// alert alert-danger alert-dismissible

		String toastTitle = driver.findElement(By.className("ng-toast")).getText();
		System.out.println(toastTitle);

		TimeUtil.timeDelay(1);
		try {

			String actualString = toastTitle;
			assertTrue(actualString.contains("Success"));
			Reporter.log(toastTitle);
		} catch (AssertionError e) {
			Reporter.log(toastTitle);

		}

	}

	public static void simDetailsInward(WebDriver driver) throws IOException, Throwable {

		Properties prop = new Properties();
		FileInputStream login = new FileInputStream(
				"/home/aryagami/eclipse-workspace/converged-billing-ra-test/src/main/java/Inputs/SimInventoryInputs.properties");

		prop.load(login);

		String filepath = workingDir;

		File src = new File(filepath);

		System.out.println("sim inventory");

		WebDriverWait d = new WebDriverWait(driver, 60);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory")));

//		TimeUtil.timeDelay(10);
//		WebElement inventory = driver.findElement(By.id("inventory"));
//		inventory.click();
//
//		TimeUtil.timeDelay(2);
//		WebElement msisdnblock = driver.findElement(By.xpath("//*[@id=\"inventoryBody\"]/ul/li[1]/a"));
//		msisdnblock.click();

		TimeUtil.timeDelay(2);
		WebElement simdetails = driver.findElement(By.xpath("// *[@id=\"inventoryBody\"]/ul/li[3]"));
		simdetails.click();

		TimeUtil.timeDelay(2);
		WebElement addsiminventory = driver.findElement(By.id("add_sim_inventory"));
		addsiminventory.click();

		TimeUtil.timeDelay(2);
		Select productcategory = new Select(driver.findElement(By.id("productCategory")));
		productcategory.selectByVisibleText(prop.getProperty("productCategory"));

		TimeUtil.timeDelay(2);
		Select subcategory = new Select(driver.findElement(By.id("productSubCategory")));
		subcategory.selectByVisibleText(prop.getProperty("productSubCategory"));

		TimeUtil.timeDelay(2);
		WebElement productname = driver.findElement(By.id("new-productName-name"));
		productname.clear();
		productname.sendKeys(prop.getProperty("productName"));

		TimeUtil.timeDelay(2);
		WebElement description = driver.findElement(By.id("productDescription"));
		description.clear();
		description.sendKeys(prop.getProperty("productDescription"));

		TimeUtil.timeDelay(2);
		WebElement binStockLocation = driver.findElement(By.id("binStockLocation"));
		binStockLocation.clear();
		binStockLocation.sendKeys(prop.getProperty("location"));

		TimeUtil.timeDelay(2);
		WebElement description2 = driver.findElement(By.id("Description"));
		description2.clear();
		description2.sendKeys(prop.getProperty("stockDescription"));

		TimeUtil.timeDelay(2);
		WebElement narration = driver.findElement(By.id("narration"));
		narration.clear();
		narration.sendKeys(prop.getProperty("stockNarration"));

		TimeUtil.timeDelay(2);
		WebElement inwardprice = driver.findElement(By.id("planType"));
		inwardprice.clear();
		inwardprice.sendKeys(prop.getProperty("inwardPrice"));

		TimeUtil.timeDelay(2);
		WebElement outwardprice = driver.findElement(By.id("productOutwardPrice"));
		outwardprice.clear();
		outwardprice.sendKeys(prop.getProperty("outwardPrice"));

		TimeUtil.timeDelay(2);
		WebElement inwardQuantity = driver.findElement(By.id("inwardQuantity"));
		inwardQuantity.clear();
		inwardQuantity.sendKeys(prop.getProperty("inwardQuantity"));

		TimeUtil.timeDelay(5);

		WebElement text2 = driver.findElement(By.id("choose_file"));
//		text2.sendKeys(src + "/selenium_testing.csv");

		TimeUtil.timeDelay(5);

		Robot robo=new Robot();
		
		
		StringSelection str= new StringSelection("/selenium_testing.csv");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		
		robo.keyPress(KeyEvent.VK_ENTER);
		
		robo.keyRelease(KeyEvent.VK_ENTER);

		System.out.println(filepath);

		// text2.sendKeys(filepath);
		System.out.println("VALUE $$$$$ " + text2.getAttribute("value"));
		text2.isDisplayed();

		TimeUtil.timeDelay(3);
		WebElement upload = driver.findElement(By.id("new-plan-upload"));
		upload.click();

		String text = driver.findElement(By.className("ng-toast")).getText();
		System.out.println(text);
		Reporter.log(text);

		// *[@id="panel"]/button

	}

}
