package _2_locators;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _1_Locators {
	public static void main(String[] args) throws InterruptedException {
		
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
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("akbar");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("akb@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("akbarshaik911@gmail.com");
		driver.findElement(By.xpath("//div/div/form/input[3]")).sendKeys("9492667682");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password = getPassword(driver);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Malin");
		//String password = getPassword(driver);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		driver.close();
	}
	
	private static String getPassword(WebDriver driver) {
		String pwdMsg = driver.findElement(By.xpath("//p[@class= 'infoMsg']")).getText();
		String password = pwdMsg.split("'")[1].split("'")[0];
		return password;
	}
}
