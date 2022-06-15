package com.crm.comcast.contactTest;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.BaseClass;
import com.crm.comcast.generic_utilities.Excel_Utilities;
import com.crm.comcast.generic_utilities.File_Utilities;
import com.crm.comcast.generic_utilities.Java_Utilities;
import com.crm.comcast.generic_utilities.Webdriver_Utilities;
import com.crm.comcast.pomrepository.AddContactPage;
import com.crm.comcast.pomrepository.ContactInfoPage;
import com.crm.comcast.pomrepository.CreateContactPage;
import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.LoginPage;

@Listeners(com.crm.comcast.generic_utilities.ListenerImpClass.class)
public class DeleteContactTest extends BaseClass {

//	public static void main(String[] args) throws Throwable  {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		
//		File_Utilities plib = new File_Utilities();
//		String url = plib.getPropertyFile("url");
//		String un = plib.getPropertyFile("un");
//		String pwd = plib.getPropertyFile("pwd");
//		driver.get(url);
//		Webdriver_Utilities WU= new Webdriver_Utilities();
//		WU.implicitWait(driver);
//		LoginPage lp = new LoginPage(driver);
//		lp.login(un, pwd);
@Test(groups = "smokeTest")
public void deleteContactTest() throws Throwable {
		HomePage hp= new HomePage(driver);
		hp.contactLink();

		AddContactPage acp= new AddContactPage(driver);
		acp.addContact();

		Java_Utilities rand = new Java_Utilities();
		int rnum = rand.randumNum(1000);

		Excel_Utilities Ex=new Excel_Utilities();
		String lastname =Ex.getExcelData("Sheet1", 1, 3)+rnum;

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.lastname(lastname);
		ccp.clicksave();
		System.out.println(lastname);

		ContactInfoPage cip = new ContactInfoPage(driver);
		
		String actualSuccessfulMsg = cip.getcInfo().getText();
		Assert.assertEquals(actualSuccessfulMsg.contains(lastname),true);
//				if(actualSuccessfulMsg.contains(lastname))
//		{
//			System.out.println("PASS:Contact name is successfully entered");
//		}
//		else
//		{
//			System.out.println("FAIL:Contact name is not entered");
//		}

        cip.deleteBtn();

		
		
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		
//		hp.mouseOvering();
//		hp.clickLogout();

	

		
	}
}



////FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
////Properties p = new Properties();//java util package
////p.load(f);
////String url= p.getProperty("url");
//File_Utilities plib = new File_Utilities();
//String url = plib.getPropertyFile("url");
//String un = plib.getPropertyFile("un");
//String pwd = plib.getPropertyFile("pwd");
//
//driver.get(url);
//Webdriver_Utilities WU= new Webdriver_Utilities();
//WU.implicitWait(driver);
////driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
////driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
////driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
////driver.findElement(By.id("submitButton")).click();
//driver.findElement(By.name("user_name")).sendKeys(un);
//driver.findElement(By.name("user_password")).sendKeys(pwd);
//driver.findElement(By.id("submitButton")).click();
//
//
////driver.findElement(By.xpath("//a[text()='Contacts']")).click();
////driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
////
////Random random = new Random();
////int rnum = random.nextInt(100);
////
////FileInputStream fis =new FileInputStream("./data/data.xlsx");
////
////Workbook wb = new WorkbookFactory().create(fis);
////String lastname = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue()+rnum;
////
////driver.findElement(By.name("lastname")).sendKeys(lastname);
////
////Thread.sleep(2000);
////driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//
//driver.findElement(By.xpath("//input[@type='text' and @name='search_text']")).sendKeys("yadav3");
//
//WebElement dd = driver.findElement(By.xpath("//select[@name='search_field' and @class='txtBox']"));
//WU.select(dd,"Last Name");
////Select s = new Select(dd);
////s.selectByVisibleText("Last Name");
//driver.findElement(By.xpath("//input[@class='crmbutton small create' and @type='button']")).click();
//
//
//
//driver.findElement(By.xpath("//input[@type='checkbox' and @id='39']")).click();
//WebDriverWait wait = new WebDriverWait(driver,7);
////wait.until(ExpectedConditions.urlContains("Contacts&action"));
//WU.switchToWindow(driver,"Contacts&action");
////Actions a2 = new Actions(driver);
//
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
////a2.moveToElement(ele).perform();
//WU.mouseHover(driver, ele);
//Thread.sleep(2000);
//
//
//
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();