package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiffBrowsers {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		// get java representation of the object for physical file

		FileInputStream f = new FileInputStream("./data/Dat.properties");  //java io package
		Properties p = new Properties();//java util package
		p.load(f);
		String url= p.getProperty("url");
		String browser = p.getProperty("browser");

		if(browser.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		}
		else
		{
			driver = new ChromeDriver();
		}
			
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("un"));
		
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));
		driver.findElement(By.id("submitButton")).click();
		
		System.out.println(url);
		System.out.println(p.getProperty("un"));
		System.out.println(p.getProperty("pwd"));


		driver.close();



	}

}
