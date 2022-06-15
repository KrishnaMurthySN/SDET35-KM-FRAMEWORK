package com.crm.comcast.campaignTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.BaseClass;
import com.crm.comcast.generic_utilities.Excel_Utilities;
import com.crm.comcast.generic_utilities.Java_Utilities;
import com.crm.comcast.pomrepository.AddCampaignPage;
import com.crm.comcast.pomrepository.AddProductPage;
import com.crm.comcast.pomrepository.CampaignInfoPage;
import com.crm.comcast.pomrepository.CreateCampaignPage;
import com.crm.comcast.pomrepository.CreateProductPage;
import com.crm.comcast.pomrepository.HomePage;



@Listeners(com.crm.comcast.generic_utilities.ListenerImpClass.class)
public class CreateCampaignWithProductTest extends BaseClass {

//	public static void main(String[] args) throws InterruptedException, Throwable  {

//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		File_Utilities plib = new File_Utilities();
//		String url = plib.getPropertyFile("url");
//		String un = plib.getPropertyFile("un");
//		String pwd = plib.getPropertyFile("pwd");
//		driver.get(url);
//		Webdriver_Utilities WU= new Webdriver_Utilities();
//		WU.implicitWait(driver);
//		LoginPage lp = new LoginPage(driver);
//		lp.login(un, pwd);
		@Test(groups = "regressionTest")
		public void createCampaignWithProdTest() throws Throwable {
		Java_Utilities rand = new Java_Utilities();
		int rnum = rand.randumNum(1000);
		
		Excel_Utilities Ex=new Excel_Utilities();
		String campaign = Ex.getExcelData("Sheet1", 1, 4);
		String product =Ex.getExcelData("Sheet1", 1, 5)+rnum;
		
		
		HomePage hp= new HomePage(driver);
		hp.productLink();
		
	
		AddProductPage app =new AddProductPage(driver);
		app.addProducts();
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.prodName(product);
		cpp.clicksave();
		
		hp.campaignLink();
		AddCampaignPage acp = new AddCampaignPage(driver);
		acp.addCampaign();
		
		
		
		
		CreateCampaignPage ccp= new CreateCampaignPage(driver);
		ccp.campName(campaign);
		ccp.addProd();
		ccp.searchTb(product);
		ccp.selectDropDown();
		ccp.serachNowBtn();
		ccp.selProd();
				
		ccp.clicksave();
		CampaignInfoPage cip = new CampaignInfoPage(driver);		
		String actualSuccessfulMsg = cip.getVerifyCampaign().getText();
		Assert.assertEquals(actualSuccessfulMsg.contains(campaign),true);
//		if(actualSuccessfulMsg.contains(campaign))
//		{
//			System.out.println("PASS:campaign with product name is successfully entered");
//		}
//		else
//		{
//			System.out.println("PASS:campaign with product name is successfully entered");
//		}
//		hp.mouseOvering();
//		hp.clickLogout();
	}

}
//File_Utilities plib = new File_Utilities();
//String url = plib.getPropertyFile("url");
//String un = plib.getPropertyFile("un");
//String pwd = plib.getPropertyFile("pwd");
////FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
////Properties p = new Properties();//java util package
////p.load(f);
////String url= p.getProperty("url");
//
//driver.get(url);
////driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
////driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
////driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
////driver.findElement(By.id("submitButton")).click();
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
////Random random = new Random();
////int rnum = random.nextInt(100);
//Java_Utilities rand = new Java_Utilities();
//int rnum = rand.randumNum(1000);
////FileInputStream fis =new FileInputStream("./data/data.xlsx");
////
////Workbook wb = new WorkbookFactory().create(fis);
////String campaign = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue()+rnum;
////String product = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue()+rnum;
//Excel_Utilities Ex=new Excel_Utilities();
//String campaign =Ex.getExcelData("Sheet1", 1, 4)+rnum;
//String product =Ex.getExcelData("Sheet1", 1, 5)+rnum;
//System.out.println(campaign);
//System.out.println(product);
////creating product
//driver.findElement(By.xpath("//a[text()='Products']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//driver.findElement(By.xpath("//input[@type='text' and @name='productname']")).sendKeys(product);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//
////Actions a1 = new Actions(driver);
//WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
////a1.moveToElement(more).perform();
//WU.mouseHover(driver, more);
////creating campaing with product
//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//driver.findElement(By.xpath("//input[@type='text' and @name='campaignname']")).sendKeys(campaign);
//driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//
//
////String parent = driver.getWindowHandle();
////System.out.println(parent);
////
////Set<String> Allid = driver.getWindowHandles();
////int count= Allid.size();
////System.out.println(count);
////
////for (String popup:Allid)
////{
////	if(!popup.equalsIgnoreCase(parent))
////	{
////		driver.switchTo().window(popup);
////		driver.findElement(By.xpath("//input[@type='text' and @name='search_text']")).sendKeys("laptop");
////
////		WebElement dd = driver.findElement(By.xpath("//select[@name='search_field' and @class='txtBox']"));
////		Select s = new Select(dd);
////		s.selectByVisibleText("Product Name");
////
//////						Robot r = new Robot();
//////						r.keyPress(KeyEvent.VK_ENTER);
//////						r.keyRelease(KeyEvent.VK_ENTER);
////					
////		driver.findElement(By.xpath("//input[@class='crmbutton small create' and @type='button']")).click();
////		driver.findElement(By.xpath("//a[text()='laptop19']")).click();
////		driver.switchTo().window(parent);
////
////		Thread.sleep(2000);
////
////	}
////
////}
//
//WU.switchToWindow(driver,"Products&action");
//
////Set<String> set1 = driver.getWindowHandles();
////Iterator<String> it1 = set1.iterator();
////
////while(it1.hasNext())
////{
////	String Cid = it1.next();
////	driver.switchTo().window(Cid);
////	String title = driver.getCurrentUrl();
////	if(title.contains("Products&action"))
////	{
////		break;
////	}
////}
//
//driver.findElement(By.xpath("//input[@type='text' and @name='search_text']")).sendKeys("laptop");
//WebElement dd = driver.findElement(By.xpath("//select[@name='search_field' and @class='txtBox']"));
//
////Select s = new Select(dd);
////s.selectByVisibleText("Product Name");
//
//WU.select(dd,"Product Name");
//driver.findElement(By.xpath("//input[@class='crmbutton small create' and @type='button']")).click();
//driver.findElement(By.xpath("//a[text()='laptop19']")).click();
//
////WebDriverWait wait = new WebDriverWait(driver,7);
////wait.until(ExpectedConditions.urlContains("Campaigns&action"));
//
//
//WU.switchToWindow(driver,"Campaigns&action");
//
////Set<String> set2 = driver.getWindowHandles();
////Iterator<String> it2 = set2.iterator();
////
////while(it2.hasNext())
////{
////	String Cid = it2.next();
////	driver.switchTo().window(Cid);
////	String title2 = driver.getCurrentUrl();
////	if(title2.contains("Campaign&action"))
////	{
////		break;
////	}
////}
////
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//String actualSuccessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
//if(actualSuccessfulMsg.contains(campaign))
//{
//	System.out.println("PASS:campaign with product name is successfully entered");
//}
//else
//{
//	System.out.println("FAIL:campaign with product name is not entered");
//}
//
////Actions a = new Actions(driver);
//
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//
//WU.mouseHover(driver, ele);
////a.moveToElement(ele).perform();
//Thread.sleep(2000);
//
//
//
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
