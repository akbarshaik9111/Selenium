package _7_realtimeexcersises_scope;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calender_UI_Handling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("form-field-travel_comp_date")));
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		List<WebElement> days = driver.findElements(By.cssSelector("span[class*='flatpickr-day']"));
		
		for(int i = 0; i < days.size(); i++) {
			String day = days.get(i).getText();
			if(day.equalsIgnoreCase("25")) {
				days.get(i).click();
			}
		}
		
		
	}

}
