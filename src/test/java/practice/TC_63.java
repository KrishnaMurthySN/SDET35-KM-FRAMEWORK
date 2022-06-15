//package practice;
//
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Properties;
//import java.util.Random;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//
//import com.graphbuilder.curve.Point;
//
//import generic_utilities.Excel_Utilities;
//import generic_utilities.File_Utilities;
//import generic_utilities.Java_Utilities;
//import generic_utilities.Webdriver_Utilities;
//
//
//public class TC_63 {
//
//	public static void main(String[] args) throws InterruptedException, Throwable  {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//		File_Utilities plib = new File_Utilities();
//		String url = plib.getPropertyFile("url");
//		String un = plib.getPropertyFile("un");
//		String pwd = plib.getPropertyFile("pwd");
//		driver.get(url);
//		
//		Webdriver_Utilities WU= new Webdriver_Utilities();
//		WU.implicitWait(driver);
//		
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		
//		driver.findElement(By.id("submitButton")).click();
//		
//		Java_Utilities rand = new Java_Utilities();
//	    int rnum = rand.randumNum(1000);
//	    
//	    Excel_Utilities Ex=new Excel_Utilities();
//		String subject =Ex.getExcelData("Sheet1", 1, 8)+rnum;
//		
//		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
//		
//		WU.mouseHover(driver,more);
//
//		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//		driver.findElement(By.xpath("//input[@type='text' and @name='subject']")).sendKeys(subject);
//		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//		WU.switchToWindow(driver,"Vendors&action");
//		driver.findElement(By.xpath("//input[@type='text' and @name='search_text']")).sendKeys("acer");
//		WebElement dd = driver.findElement(By.xpath("//select[@name='search_field' and @class='txtBox']"));
//		
//		WU.select(dd,"Vendor Name");
//		driver.findElement(By.xpath("//input[@class='crmbutton small create' and @type='button']")).click();
//    	driver.findElement(By.xpath("//a[text()='acer']")).click();
//    	
////    	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
////		WU.swithToWindow(driver,"Vendors&action");
////		driver.findElement(By.xpath("//input[@type='text' and @name='search_text']")).sendKeys(" Yadav86");
////		WebElement dd2 = driver.findElement(By.xpath("//select[@name='search_field' and @class='txtBox']"));
////		
////		WU.select(dd2,"Last Name");
////		driver.findElement(By.xpath("//input[@class='crmbutton small create' and @type='button']")).click();
////    	driver.findElement(By.xpath("//a[text()=' Yadav86']")).click();
//    	//WebElement dd3 = driver.findElement(By.xpath("//select[@name='postatus']"));
//		
//		//WU.select(dd3,"\r\n"
//		//		+ "                                                Created\r\n"
//		//		+ "                                        ");
//		//driver.findElement(By.xpath("//input[@type='radio' and @value='U']")).click();
//    	
//    	//billing address
//    			driver.findElement(By.name("bill_street")).sendKeys("bangalore");
//
//    			//shipping address
//    			driver.findElement(By.name("ship_street")).sendKeys("Bangalore rural");
//
//    			//to scroll to element
//    			
//    			JavascriptExecutor jse=(JavascriptExecutor)driver;
//    			jse.executeScript("window.scrollBy(0,500)");
//    	
//    			
//    			//switch control to child
//    			Set<String> all2 = driver.getWindowHandles();
//    			ArrayList<String> list2=new ArrayList<String>(all2);
//    			driver.switchTo().window(list2.get(1));
//    			Thread.sleep(4000);
//    			
//    			//selected product
//    			driver.findElement(By.xpath("//a[.='zayn']")).click();
//    			driver.switchTo().window(list2.get(0));
//    			Thread.sleep(2000);
//    			
//    			//purchase done
//    			driver.findElement(By.name("qty1")).sendKeys("1");
//    			//driver.findElement(By.name("qty1")).sendKeys("1");
//    			driver.findElement(By.xpath("//input[@type='submit']")).click();
//    			wait.until(ExpectedConditions.titleContains(title));
//    			driver.findElement(By.name("Delete")).click();
//    			
//    			//handling popup
//    			Alert pop = driver.switchTo().alert();
//    			pop.dismiss();
//    			Thread.sleep(2000);
//    			
//    		
//    		//signout
//    		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//    		act.moveToElement(element).perform();
//    		Thread.sleep(2000);
//    		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
//    		wait.until(ExpectedConditions.titleContains(logtitle));
//    		
//    		//login page
//    		if((driver.getTitle()).contains(logtitle))
//    		{
//    			System.out.println("login page is displayed");
//    		}else {
//    			System.out.println("testcase failed");
//    		}
////		driver.findElement(By.name("bill_street")).sendKeys("Bangalore");
////		driver.findElement(By.name("ship_street")).sendKeys("Bangalore Rural");
////
////		
////		driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
////		
////		driver.findElement(By.xpath("//input[@type='text' and @name='search_text']")).sendKeys("laptop19");
////		driver.findElement(By.xpath("//a[text()='laptop19']")).click();
////		driver.findElement(By.id("qty1")).sendKeys("2");
////		driver.findElement(By.id("listPrice1")).sendKeys("200");
////		
////		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//	}
//}
