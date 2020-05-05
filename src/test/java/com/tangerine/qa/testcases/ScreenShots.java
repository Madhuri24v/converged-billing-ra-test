package com.tangerine.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tangerine.qa.base.TestBase;
import com.tangerine.qa.pages.LoginPage;
import com.tangerine.qa.pages.ScreenshotsPage;
import com.tangerine.qa.utils.TestUtil;

import utils.TimeUtil;

public class ScreenShots extends TestBase {

	public static WebDriver driver;

	static String[] list = {
			"256726011190",
			"256726011191",
			"256726011193",
			"256726011196",
			"256726011198",
			"256726011201",
			"256726011203",
			"256726011205",
			"256726011206",
			"256726011208",
			"256726011210",
			"256726011212",
			"256726011214",
			"256726011216",
			"256726011218",
			"256726011221",
			"256726011222",
			"256726011223",
			"256726011227",
			"256726011228",
			"256726011229",
			"256726011231",
			"256726011233",
			"256726011234",
			"256726011235",
			"256726011236",
			"256726011237",
			"256726011240",
			"256726011242",
			"256726011244",
			"256726011246",
			"256726011247",
			"256726011249",
			"256726011260",
			"256726011262",
			"256726011264",
			"256726011265",
			"256726011269",
			"256726011270",
			"256726011271",
			"256726011273",
			"256726011274",
			"256726011282",
			"256726011283",
			"256726011284",
			"256726011285",
			"256726011288",
			"256726011292",
			"256726011295",
			"256726011296",
			"256726011298",
			"256726011299",
			"256726011300",
			"256726011304",
			"256726011305",
			"256726011311",
			"256726011312",
			"256726011313",
			"256726011320",
			"256726011322",
			"256726011323",
			"256726011327",
			"256726011330",
			"256726011334",
			"256726011335",
			"256726011338",
			"256726011340",
			"256726011341",
			"256726011342",
			"256726011346",
			"256726011348",
			"256726011349",
			"256726011351",
			"256726011353",
			"256726011357",
			"256726011366",
			"256726011371",
			"256726011372",
			"256726011380",
			"256726011381",
			"256726011391",
			"256726011395",
			"256726011397",
			"256726011405",
			"256726011410",
			"256726011411",
			"256726011412",
			"256726011414",
			"256726011419",
			"256726011421",
			"256726011426",
			"256726011427",
			"256726011431",
			"256726011439",
			"256726011440",
};
	static int lenght = list.length;

	static String workingDirectory = System.getProperty("user.dir");

	@Test
	public void login() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
			driver = new FirefoxDriver();

		// goto url
		driver.get("http://41.217.232.48/admin/");

		TimeUtil.timeDelay(2);
		driver.manage().window().maximize();

		driver.findElement(By.id("userNames")).sendKeys("lyca_ccagent");

		TimeUtil.timeDelay(2);
		driver.findElement(By.id("password")).sendKeys("Lyca@123");

		TimeUtil.timeDelay(2);
		driver.findElement(By.id("submit")).click();

		
		
		WebDriverWait wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerUser")));

		boolean image = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/img")).isDisplayed();
		Assert.assertTrue(image);

		TimeUtil.timeDelay(2);
		System.out.println("Login Successfully");

		TimeUtil.timeDelay(5);
		driver.findElement(By.id("customerUser")).click();

		// create directory
		for (int i = 0; i < lenght; i++) {

			CreateADirectory(list[i]);
		}

	}

	public void CreateADirectory(String DirectoryName) throws Exception

	{

		for (int j = 0; j <= lenght - 1; j++) {

			if (DirectoryName == list[j]) {

				// project directory
				String workingDirectory = System.getProperty("user.dir");
				String dir = workingDirectory + File.separator + DirectoryName;

				System.out.println("Final file directory : " + dir);

				// create a directory in the path

				File file = new File(dir);

				if (!file.exists()) {
					file.mkdir();
					System.out.println("Directory is created!");
				} else {
					System.out.println("Directory is already existed!");
				}

				TimeUtil.timeDelay(2);
				driver.findElement(By.xpath("//*[@id=\"customerUserBody\"]/ul/li[1]/a")).click();

				TimeUtil.timeDelay(2);
				driver.findElement(By.id("search")).sendKeys(list[j]);
				
				
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regionType\"]/tbody/tr/td[1]/a")));

				TimeUtil.timeDelay(2);
				driver.findElement(By.xpath("//*[@id=\"regionType\"]/tbody/tr/td[1]/a")).click();

				WebDriverWait wait2 = new WebDriverWait(driver,55);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/div[2]/label[2]")));
				
				TimeUtil.timeDelay(2);
				WebElement subscriptions=driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/div[2]/label[2]"));
				subscriptions.click();
				
				TimeUtil.timeDelay(5);
				ScreenShots.takeSnapShot(driver, dir + File.separator + list[j] + "-subscriptions");
				System.out.println(dir);
				
				

				TimeUtil.timeDelay(5);
				driver.findElement(By.id(list[j])).click();
				
				TimeUtil.timeDelay(5);
				driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[3]/label[3]")).click();
				
				
				WebDriverWait wait4 = new WebDriverWait(driver,40);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"postpaidRecharge\"]/div[2]/div/div/div/table/tbody/tr/td[2]")));

				TimeUtil.timeDelay(5);
				ScreenShots.takeSnapShot(driver, dir + File.separator + list[j] + "-Bundles");

				
				TimeUtil.timeDelay(5);
				driver.findElement(By.xpath("//*[@id=\"postpaidRecharge\"]/div[1]/span")).click();

				

				


				try {
					
					TimeUtil.timeDelay(5);
					
					WebDriverWait wait6 = new WebDriverWait(driver,40);
					wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("esc_button")));
					
					
					WebElement element = driver.findElement(By.id("esc_button"));

					element.isDisplayed();
					System.out.println("Close button has displayed");
					
					TimeUtil.timeDelay(10);
					ScreenShots.takeSnapShot(driver, dir + File.separator + list[j] + "-OldBundles");
					
					
					element.click();
				} catch (Exception e) {
					System.out.println("Close  button did not displayed");
				}

				TimeUtil.timeDelay(5);
				driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/button")).click();

			}

		}

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(fileWithPath);

		FileUtils.copyFile(SrcFile, DestFile);
	}

}

