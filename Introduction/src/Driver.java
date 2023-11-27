import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {
	public static void main(String[] args) {
		//PROVIDED THE LOCATION OF EDGE DRIVER
		System.setProperty("webdriver.edge.driver", "E:\\Selenium\\msedgedriver.exe");
		
		//EDGE DRIVER INVOKED
		WebDriver driver = new EdgeDriver();
		
		driver.close();
		driver.equals("");
		//driver.findElement(null);
		//driver.findElements(null)
		driver.get(null);
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.getTitle();
		driver.getWindowHandle();
		driver.getWindowHandles();
		driver.manage();
		//driver.navigate()
		driver.quit();
		//driver.switchTo()
	}

}
