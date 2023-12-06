package _6_automate_ajax_calls;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class _1_MouseHover {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement signIn = driver.findElement(By.cssSelector("#nav-link-accountList"));
		WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		//CREATE THE OBJECT FOR ACTIONS CLASS
		Actions action = new Actions(driver);
		
		//ENTER TEXT IN UPPER-CASE FORMAT AND SELECT THE ENTERED TEXT
		action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		// MOVE TO SPECIFIC ELEMENT AND CLICK THE RIGHT CLICK
		action.moveToElement(signIn).contextClick().build().perform();
		
		driver.close();
	}

}