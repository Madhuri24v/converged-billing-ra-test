package utils;

import org.openqa.selenium.WebDriver;

public class TimeUtil {

	static WebDriver driver;
	
	private static long randomNumber;

	public static void timeDelay(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void timeWait(int sec) {
		try {
			Thread.sleep(randomNumber * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
}