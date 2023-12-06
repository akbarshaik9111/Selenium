package _5_synchronization;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class _2_FluentWait {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		/*
		 * YOU CAN SEE MORE DETAILS - https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
		 */
		
		// WAIT FOR PARTICULAR ELEMENT IS DISPLAYING USING EXPLICIT WAIT (FLUENT WAIT MECHANISM)
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(3,	TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
			    if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()){
			    	return driver.findElement(By.cssSelector("div[id='finish'] h4"));
			    } else {
			    	return null;
			    }
			 }
		});
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed(), true);
		driver.close();
	}
}
