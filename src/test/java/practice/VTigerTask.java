package practice;


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


public class VTigerTask {

	public static void main(String[] args) throws InterruptedException, Throwable  {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
		Properties p = new Properties();//java util package
		p.load(f);
		String url= p.getProperty("url");

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();


		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		Random random = new Random();
		int rnum = random.nextInt(100);

		FileInputStream fis =new FileInputStream("./data/data.xlsx");

		Workbook wb = new WorkbookFactory().create(fis);
		String orgname = wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue()+rnum;

		driver.findElement(By.name("accountname")).sendKeys(orgname);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println(orgname);
		String actualSuccessfulMsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualSuccessfulMsg.contains(orgname))
		{
			System.out.println("PASS:organization name is successfully entered");
		}
		else
		{
			System.out.println("FAIL:organization name is not entered");
		}


		Actions a = new Actions(driver);

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
