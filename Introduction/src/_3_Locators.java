import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _3_Locators {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * findElement() - FIND THE FIRST WEBELEMENT USING THE GIVEN METHOD.
		 * @Return - The first matching element on the current page
		 * 
		 * sendKeys() - ENTERING VALUES IN INPUT BOXES EXPLICITLY USING SENDKEYS() METHOD
		 */
		driver.findElement(By.id("inputUsername")).sendKeys("akbar");
		driver.findElement(By.name("inputPassword")).sendKeys("Akbar@0326");
		driver.findElement(By.className("signInBtn")).click();
		String error = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(error);
		driver.close();
	}

}