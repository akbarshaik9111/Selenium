package _1_introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _3_Window_Activities {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//To maximize the browser window page
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.close();
		
		/*
		 * Q: difference between get and navigate
		 * get- Selenium will wait til all the components will load into this page
		 * navigate - Selenium won't wait to load all the components.
		 */
	}

}
