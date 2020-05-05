package com.tangerine.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utils.TimeUtil;


public class ScreenshotsPage {
	
	
	
	  static String [] list= {"256726012045","256726012037","256726012989"};
      
      static  int lenght=list.length;

	
	
	
	    public static void main(String[] args)
	    {
	    	
	    	for (int i=0;i<lenght;i++) {
	        CreateADirectory(list[i]);
	    	
	    
	    	}
	    }
	    

		public static void CreateADirectory(String DirectoryName)
	    
	    
	    {
			
	        
	    	
	    	for(int j=1;j<=lenght;j++){  
	        //project directory
	        String workingDirectory = System.getProperty("user.dir");
	        String  dir = workingDirectory + File.separator + DirectoryName;

	        System.out.println("Final file directory : " + dir);

	        //create a directory in the path

	        File file = new File(dir);

	        if (!file.exists()) {
	            file.mkdir();
	            System.out.println("Directory is created!");
	        } else {
	            System.out.println("Directory is already existed!");
	        }

	    	}
	    	
			
	    	
	    }
}
	    

