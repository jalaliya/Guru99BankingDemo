package bankingdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidLoginScnerio {

	public static void main(String[] args) {
	
		//Testing the valid login 
		//using gecko driver
		try {
		System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\drivers\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://www.demo.guru99.com/v4/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//locating webElement for entering userid
		WebElement UserId=driver.findElement(By.name("uid"));
		UserId.sendKeys("mngr476895");
		
		//locating webElement for entering password
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("AmErEqu");
		
		
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
