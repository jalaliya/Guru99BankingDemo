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
	public void openBrowserAndUrl() {
		System.setProperty("Webdriver.gecko.driver",
			util.location);
		driver = new FirefoxDriver();
		driver.get(util.baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void validLogin() {
		WebElement UserId = driver.findElement(By.name("uid"));
		UserId.sendKeys(util.uid);

		// locating webElement for entering password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(util.pwd);

		// finding login button
		WebElement login = driver.findElement(By.name("btnLogin"));
		login.click();

		String title = driver.getTitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
		/*
		 * if(title.contains("HomePage")) { System.out.println("Login Successful"); }
		 * else { System.out.println("Invalid credentials"); }
		 */
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	}
	/*
	 * String projectPath=System.getProperty("user.dir");
	 * 
	 * System.out.println("User Directory:" +projectPath); //Using Relative path
	 * 
	 * System.setProperty("Webdriver.gecko.driver",projectPath+
	 * "/resources/drivers/geckodriver.exe");
	 * System.out.println("Complete path is: "+projectPath+
	 * "/resources/drivers/geckodriver.exe");
	 */

