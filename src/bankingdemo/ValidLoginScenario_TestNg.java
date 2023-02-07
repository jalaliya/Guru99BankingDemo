package bankingdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidLoginScenario_TestNg {
	WebDriver driver;

	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\drivers\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void validLogin()
	{
		WebElement UserId=driver.findElement(By.name("uid"));
		UserId.sendKeys("mngr476895");
		
		//locating webElement for entering password
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("AmErEqu");
		
		
		//finding login button
		WebElement login=driver.findElement(By.name("btnLogin"));
		login.click();
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
		/*
		 * if(title.contains("HomePage")) { System.out.println("Login Successful"); }
		 * else { System.out.println("Invalid credentials"); }
		 */
	}
		
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
		
	}

