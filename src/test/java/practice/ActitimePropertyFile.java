package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

public class ActitimePropertyFile {

	public static void main(String[] args) throws Throwable  {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream f = new FileInputStream("./data/Data.properties");  //java io package
		Properties p = new Properties();//java util package
		p.load(f);
		String urlAct= p.getProperty("urlAct");
		
		
		driver.get(urlAct);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(p.getProperty("unAct"));
		driver.findElement(By.name("pwd")).sendKeys(p.getProperty("pwdAct"));
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.close();



	}

}
