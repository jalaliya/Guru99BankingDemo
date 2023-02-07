package ecommerceproject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySortByName {
	
	WebDriver driver;
	
	    @BeforeMethod
		public void openBrowser()
		{
			System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\drivers\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("http://live.techpanda.org/index.php/");
			
		}
	
		
		@Test
		public void VerifyTilte() throws InterruptedException
		{
			//Assert.assertTrue(driver.getPageSource().contains("THIS IS DEMO SITE FOR"));
			
			String title1=driver.getTitle();
			
			Assert.assertEquals(title1, "Home page");
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			 * wait.until(ExpectedConditions.visibilityOfAllElements());
			 * Assert.assertTrue(driver.getPageSource().contains("THIS IS DEMO SITE FOR"));
			 */
			driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
			//driver.findElement(By.linkText("Mobile")).click();
			String title2=driver.getTitle();
			Assert.assertEquals(title2, "Mobile");
		      WebElement selectMobile=driver.findElement(By.xpath(
			  "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"
			  ));
			  
			  
			  Select select=new Select(selectMobile);
			  select.selectByVisibleText("Name");
			
			  
			  System.out.println("After sorting by name");
			 System.out.println("----------------------");
			 
			 List<String> mobileList=new LinkedList<String>();
			 List<WebElement> Mobiles=driver.findElements(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li/a"));
			   for(WebElement mobile :Mobiles)
			   {
				  // System.out.println(mobile.getAttribute("title"));
				   mobileList.add(mobile.getAttribute("title"));
				   
			   }
		System.out.println(mobileList);
		Assert.assertEquals(mobileList.get(0),"IPhone");
		Assert.assertEquals(mobileList.get(1),"Samsung Galaxy");
		Assert.assertEquals(mobileList.get(2),"Xperia");
		}
	
	
		

}
