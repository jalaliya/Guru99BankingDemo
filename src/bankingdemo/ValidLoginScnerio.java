package bankingdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidLoginScnerio {

	public static void main(String[] args) {
	
		
		
		
		//Testing the valid login 
		//using gecko driver
		try {
		System.setProperty("Webdriver.gecko.driver",util.location);
		WebDriver driver=new FirefoxDriver();
	
	
		driver.get(util.baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//locating webElement for entering userid
		WebElement UserId=driver.findElement(By.name("uid"));
		
		UserId.sendKeys(util.uid);
		
		//locating webElement for entering password
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys(util.pwd);
		
		
		//finding login button
		WebElement login=driver.findElement(By.name("btnLogin"));
		login.click();
		
		String title=driver.getTitle();
		if(title.contains("HomePage"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Invalid credentials");
		}
		}
		
		
		 catch(Exception e)
		{
			System.out.println("oops....!Something went wrong...Try again!!");
		}
	}

}
