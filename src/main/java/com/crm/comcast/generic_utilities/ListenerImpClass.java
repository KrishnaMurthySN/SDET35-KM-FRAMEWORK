package com.crm.comcast.generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.out.println("Failure");
		Java_Utilities jlib = new Java_Utilities();
		
		String testName = result.getMethod().getMethodName();
		
		 EventFiringWebDriver eDriver =new EventFiringWebDriver(BaseClass.sdriver);
		  File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		  File destFile = new File("./screenshot/"+testName+"_"+jlib.getSystemDateInIST()+".png");
		  try {
			  FileUtils.copyFile(srcFile, destFile);
		  } catch (IOException e) {
			
		}
		 

	}

}
