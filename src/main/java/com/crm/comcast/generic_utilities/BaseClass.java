package com.crm.comcast.generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public File_Utilities flib = new File_Utilities();
//public Excel_Utilities elib = new Excel_Utilities();
public Webdriver_Utilities wlib = new Webdriver_Utilities();
public WebDriver driver;

public static WebDriver sdriver=null;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bs() {
		System.out.println("database connection"); 
			
		}
		
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void bt()
	{
		System.out.println("Execute script in parallel mode");
	}
	//@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//public void bc(@Optional  String Browser) throws Throwable
	public void bc() throws Throwable
	{
		String Browser= flib.getPropertyFile("browser");
	//	Reporter.log(Browser,true);
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}else
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		sdriver=driver;
		String url = flib.getPropertyFile("url");
		driver.get(url);
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bm() throws Throwable
	{
		String username= flib.getPropertyFile("un");
		String password = flib.getPropertyFile("pwd");
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void am()
	{
		HomePage hp = new HomePage(driver);
		hp.mouseOvering();
 
		
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void ac()
	{
		driver.quit();
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void at()
	{
		System.out.println("Parallel execution is completed");
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void as()
	{
		System.out.println("Database connection removed");
	}
}
