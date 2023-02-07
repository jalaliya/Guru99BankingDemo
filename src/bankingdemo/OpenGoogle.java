package bankingdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenGoogle {

	public static void main(String[] args) {
		System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\drivers\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com/");

	}

}
