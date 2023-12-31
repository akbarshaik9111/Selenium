package _2_locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class _2_Locators {
	public static void main(String[] args) throws InterruptedException {
		String username = "akbar";
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String msg = driver.findElement(By.tagName("p")).getText();
		System.out.println(msg);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+username+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
}
