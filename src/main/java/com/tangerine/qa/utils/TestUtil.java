package com.tangerine.qa.utils;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITLY_WAIT=40;
	public static long WAIT=1;
	
	private static long randomNumber;
	
	public static void timeWait(int sec) {
		try {
			Thread.sleep(randomNumber * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
