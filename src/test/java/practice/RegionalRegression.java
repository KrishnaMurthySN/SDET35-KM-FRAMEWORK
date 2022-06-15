package practice;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.DriverAction;
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
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.BaseClass;
import com.crm.comcast.generic_utilities.Excel_Utilities;
import com.crm.comcast.generic_utilities.File_Utilities;
import com.crm.comcast.generic_utilities.Java_Utilities;
import com.crm.comcast.generic_utilities.Webdriver_Utilities;
import com.crm.comcast.pomrepository.AddCampaignPage;
import com.crm.comcast.pomrepository.AddOrganizePage;
import com.crm.comcast.pomrepository.CampaignInfoPage;
import com.crm.comcast.pomrepository.CreateCampaignPage;
import com.crm.comcast.pomrepository.CreateOrganizePage;
import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.LoginPage;
import com.crm.comcast.pomrepository.OrganizeInfoPage;


public class RegionalRegression extends BaseClass {
	

		Webdriver_Utilities WU= new Webdriver_Utilities();

		@Test(groups = "smokeTest")
		public void createOrgTest() throws Throwable{
		HomePage hp= new HomePage(driver);
		hp.orgLink();
		
		AddOrganizePage add= new AddOrganizePage(driver);
		add.addOrganize();
		
		Java_Utilities rand = new Java_Utilities();
		int rnum = rand.randumNum(1000);
		Excel_Utilities Ex=new Excel_Utilities();
		String orgname =Ex.getExcelData("Sheet1", 3, 1)+rnum;
		CreateOrganizePage orgp= new CreateOrganizePage(driver);
		orgp.orgName(orgname);
		System.out.println(orgname);
		orgp.clicksave();
		OrganizeInfoPage orgInfo = new OrganizeInfoPage(driver);
		
		WU.waitForElement(driver,orgInfo.getOrgInfo());
		
		System.out.println(orgInfo.getOrgInfo().getText());
		//String actualSuccessfulMsg = orgInfo.getOrgInfo().getText();
		
		
			if(( orgInfo.getOrgInfo().getText()).contains(orgname))
			{
				System.out.println("PASS:organization name is successfully entered");
			}
			else
			{
				System.out.println("FAIL:organization name is not entered");
			}
		
		
		

	}
		@Test(groups = "regressionTest")
		public void createCampaignTest() throws Throwable {

			HomePage hp= new HomePage(driver);
			hp.campaignLink();

			AddCampaignPage acp = new AddCampaignPage(driver);
			acp.addCampaign();

			Java_Utilities rand = new Java_Utilities();
			int rnum = rand.randumNum(1000);

			Excel_Utilities Ex=new Excel_Utilities();
			String campaign = Ex.getExcelData("Sheet1", 1, 4);

			CreateCampaignPage ccp= new CreateCampaignPage(driver);
			ccp.campName(campaign);

			ccp.clicksave();
			CampaignInfoPage cip = new CampaignInfoPage(driver);		
			String actualSuccessfulMsg = cip.getVerifyCampaign().getText();
			if(actualSuccessfulMsg.contains(campaign))
			{
				System.out.println("PASS:campaign name is successfully entered");
			}
			else
			{
				System.out.println("FAIL:campaign name is not entered");
			}
			
		}

	}







//public static void main(String[] args) throws InterruptedException, Throwable  {

//WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
//
//File_Utilities plib = new File_Utilities();
//String url = plib.getPropertyFile("url");
//String un = plib.getPropertyFile("un");
//String pwd = plib.getPropertyFile("pwd");
//driver.get(url);
//Webdriver_Utilities WU= new Webdriver_Utilities();
//WU.implicitWait(driver);
//LoginPage lp = new LoginPage(driver);
//lp.login(un, pwd);


////hp.mouseOvering();
////hp.clickLogout();
//Thread.sleep(10000);

















////FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
////Properties p = new Properties();//java util package
////p.load(f);
////String url= p.getProperty("url");
//
//driver.get(url);
//Webdriver_Utilities WU= new Webdriver_Utilities();
//WU.implicitWait(driver);
//driver.findElement(By.name("user_name")).sendKeys(un);
//driver.findElement(By.name("user_password")).sendKeys(pwd);
//driver.findElement(By.id("submitButton")).click();
//
//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
////driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
////Thread.sleep(2000);
////driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
////Thread.sleep(2000);
////driver.findElement(By.id("submitButton")).click();
//
//
//driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//
////Random random = new Random();
////int rnum = random.nextInt(100);
//Java_Utilities rand = new Java_Utilities();
//int rnum = rand.randumNum(1000);
//
//Excel_Utilities Ex=new Excel_Utilities();
//String orgname =Ex.getExcelData("Sheet1", 3, 1)+rnum;
//
////FileInputStream fis =new FileInputStream("./data/data.xlsx");
////
////Workbook wb = new WorkbookFactory().create(fis);
////String orgname = wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue()+rnum;
//
//driver.findElement(By.name("accountname")).sendKeys(orgname);
//
//Thread.sleep(2000);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//System.out.println(orgname);
//


//
//
////Actions a = new Actions(driver);
//
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//WU.mouseHover(driver, ele);
////a.moveToElement(ele).perform();
//Thread.sleep(2000);
//
//
//
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
