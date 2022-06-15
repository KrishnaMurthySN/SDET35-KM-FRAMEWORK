package practice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HardCodeInput {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
       System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    	driver.get("http://localhost:8888");
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	driver.findElement(By.name("user_name")).sendKeys("admin");
    	driver.findElement(By.name("user_password")).sendKeys("admin");
    	driver.findElement(By.id("submitButton")).click();
    	
    	driver.close();
       
       
       
	}

}
