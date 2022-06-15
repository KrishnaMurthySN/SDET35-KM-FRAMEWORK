package com.crm.comcast.contactTest;



import org.openqa.selenium.Alert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic_utilities.BaseClass;
import com.crm.comcast.generic_utilities.Excel_Utilities;
import com.crm.comcast.generic_utilities.Java_Utilities;
import com.crm.comcast.pomrepository.AddContactPage;
import com.crm.comcast.pomrepository.ContactInfoPage;
import com.crm.comcast.pomrepository.CreateContactPage;
import com.crm.comcast.pomrepository.HomePage;

@Listeners(com.crm.comcast.generic_utilities.ListenerImpClass.class)
public class CreateContactWithoutMandatoryTest extends BaseClass {


@Test(groups = "regressionTest")
public void createContact() throws Throwable {
	
		HomePage hp= new HomePage(driver);
		hp.contactLink();

		AddContactPage acp= new AddContactPage(driver);
		acp.addContact();

		
		

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.clicksave();
		
		Alert a = driver.switchTo().alert();
		
		
		String confirmationMsg = a.getText();
		
		if(confirmationMsg.contains("Last Name cannot be empty"))
		{
			System.out.println("PASS:Confirmation message is displayed");
		}
		else
		{
			System.out.println("FAIL:Confirmation messgae is not displayed");
		}
		a.accept();
		


	}

}







//public static void main(String[] args) throws InterruptedException, Throwable  {
////launching browser
////		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
////Fetching data from property file
//File_Utilities plib = new File_Utilities();
//String url = plib.getPropertyFile("url");
//String un = plib.getPropertyFile("un");
//String pwd = plib.getPropertyFile("pwd");
//driver.get(url);
//Webdriver_Utilities WU= new Webdriver_Utilities();
//WU.implicitWait(driver);
//LoginPage lp = new LoginPage(driver);
//lp.login(un, pwd);

//Thread.sleep(2000);
//hp.mouseOvering();
//Thread.sleep(2000);
//
//hp.clickLogout();
//




















//FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
//Properties p = new Properties();//java util package
//p.load(f);
//String url= p.getProperty("url");
//
//driver.get(url);
//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
//driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
//driver.findElement(By.id("submitButton")).click();



//driver.findElement(By.name("user_name")).sendKeys(un);
//driver.findElement(By.name("user_password")).sendKeys(pwd);
//driver.findElement(By.id("submitButton")).click();

//driver.findElement(By.xpath("//a[text()='Contacts']")).click();

//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

//Random random = new Random();
//int rnum = random.nextInt(100);

//FileInputStream fis =new FileInputStream("./data/data.xlsx");
//
//Workbook wb = new WorkbookFactory().create(fis);
//String lastname = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue()+rnum;

//Actions a = new Actions(driver);

//a.moveToElement(ele).perform();



//driver.findElement(By.name("lastname")).sendKeys(lastname);
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();



//String actualSuccessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
//if(actualSuccessfulMsg.contains(lastname))
//{
//	System.out.println("PASS:Contact name is successfully entered");
//}
//else
//{
//	System.out.println("FAIL:Contact name is not entered");
//}

//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//
//WU.mouseHover(driver, ele);
//Thread.sleep(2000);


//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();






