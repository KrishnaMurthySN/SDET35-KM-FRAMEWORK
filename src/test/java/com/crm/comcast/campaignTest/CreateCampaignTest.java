package com.crm.comcast.campaignTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.BaseClass;
import com.crm.comcast.generic_utilities.Excel_Utilities;
import com.crm.comcast.generic_utilities.Java_Utilities;
import com.crm.comcast.pomrepository.AddCampaignPage;
import com.crm.comcast.pomrepository.CampaignInfoPage;
import com.crm.comcast.pomrepository.CreateCampaignPage;
import com.crm.comcast.pomrepository.HomePage;

@Listeners(com.crm.comcast.generic_utilities.ListenerImpClass.class)
public class CreateCampaignTest extends BaseClass {


	@Test(groups = "smokeTest")
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
		Assert.assertEquals(actualSuccessfulMsg.contains(campaign),true);
//		if(actualSuccessfulMsg.contains(campaign))
//		{
//			System.out.println("PASS:campaign name is successfully entered");
//		}
//		else
//		{
//			System.out.println("FAIL:campaign name is not entered");
//		}
//		
	}
}

	//public static void main(String[] args) throws InterruptedException, Throwable  {

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
	//		lp.login(un, pwd);}

























////FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
////		Properties p = new Properties();//java util package
////		p.load(f);
////		String url= p.getProperty("url");
////
////		driver.get(url);
////		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
////		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
////		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
////		driver.findElement(By.id("submitButton")).click();
//File_Utilities plib = new File_Utilities();
//String url = plib.getPropertyFile("url");
//String un = plib.getPropertyFile("un");
//String pwd = plib.getPropertyFile("pwd");
//driver.get(url);
//
//
//Webdriver_Utilities WU= new Webdriver_Utilities();
//WU.implicitWait(driver);
//
//driver.findElement(By.name("user_name")).sendKeys(un);
//driver.findElement(By.name("user_password")).sendKeys(pwd);
//
//driver.findElement(By.id("submitButton")).click();
//
//
//
//
//
////Random random = new Random();
////int rnum = random.nextInt(100);
//Java_Utilities rand = new Java_Utilities();
//int rnum = rand.randumNum(1000);
//
//Excel_Utilities Ex=new Excel_Utilities();
//String campaign = Ex.getExcelData("Sheet1", 1, 4);
////FileInputStream fis =new FileInputStream("./data/data.xlsx");
////
////Workbook wb = new WorkbookFactory().create(fis);
////String campaign = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue()+rnum;
////System.out.println(campaign);
////Actions a1 = new Actions(driver);
//WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
////a1.moveToElement(more).perform();
//WU.mouseHover(driver, more);
//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//driver.findElement(By.xpath("//input[@type='text' and @name='campaignname']")).sendKeys(campaign);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//String actualSuccessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
//if(actualSuccessfulMsg.contains(campaign))
//{
//	System.out.println("PASS:campaign name is successfully entered");
//}
//else
//{
//	System.out.println("FAIL:campaign name is not entered");
//}
//
////Actions a = new Actions(driver);
//
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
////a.moveToElement(ele).perform();
//WU.mouseHover(driver, ele);
//Thread.sleep(2000);
//
//
//
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
