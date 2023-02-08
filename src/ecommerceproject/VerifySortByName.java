package ecommerceproject;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;
public class VerifySortByName {
	
	WebDriver driver;
	int scc=0;
	
	    @BeforeMethod
		public void setUp()
		{
	    	//step1
	    	String location="C:\\Users\\Dell\\Downloads\\drivers\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe";
	    	String baseUrl="http://live.techpanda.org/index.php/";
			System.setProperty("Webdriver.gecko.driver",location);
			driver=new FirefoxDriver();
			driver.get(baseUrl);
			
		}
	
		
		@Test
		public void VerifyTilte() throws Exception
		{
			
			//step2
			String title1=driver.getTitle();
			try {
				Assert.assertEquals(title1, "Home page");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			//step3 and step4
			driver.findElement(By.linkText("Mobile")).click();
			
			String title2=driver.getTitle();
			try {
				Assert.assertEquals(title2, "Mobile");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		      
			//step5
			
			WebElement selectMobile=driver.findElement(By.xpath(
			  "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"
			  ));
			  Select select=new Select(selectMobile);
			  select.selectByVisibleText("Name");
			
			  //step6
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
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./snap1.png"));
		//FileUtils.copyFile(s, new File("./google.png"));
		}
	
		@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
		

}
/*
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 * wait.until(ExpectedConditions.visibilityOfAllElements());
 * Assert.assertTrue(driver.getPageSource().contains("THIS IS DEMO SITE FOR"));
 */
