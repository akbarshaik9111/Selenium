package _1_introduction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _1_WebDriverMethods {
	public static void main(String[] args) {
		
		//PROVIDED THE LOCATION OF EDGE DRIVER
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		
		/*
		 * EdgeDriver() --> IT HELPS YOU TO EXECUTE SELENIUM SCRIPTS ON EDGE BROWSER.
		 */
		WebDriver driver = new EdgeDriver();
		
		/*
		 * 1. get() - THIS METHOD WILL LAUNCH A NEW BROWSER AND OPENS THE GIVEN URL IN THE BROWSER INSTANCE.
		 */
		driver.get("https://rahulshettyacademy.com/");
		
		/*
		 * 2. getTitle() - THIS METHOD IS USED TO RETRIEVE THE TITLE OF THE WEB PAGE THE USER CURRENTLY WORKING ON.
		 */
		String title = driver.getTitle();
		System.out.println(title);
		
		/*
		 * 3. getCurrentUrl() - GET CURRENT URL FROM BROWSER
		 */
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		/*
		 * 4. close() - THIS COMMAND IS USED TO CLOSE THE CURRENT BROWSER WINDOW WHICH IS CURRENTLY IN FOCUS.
		 */
		driver.close();
		
		/*
		 * 5. quit() - QUITS THIS DRIVER, CLOSING EVERY ASSOCIATED WINDOW.
		 */
		driver.quit();
		
		
		/*
		//driver.findElement(null);
		//driver.findElements(null)
		driver.getPageSource();
		driver.getWindowHandle();
		driver.getWindowHandles();
		driver.manage();
		//driver.navigate()
		driver.quit();
		//driver.switchTo()*/
	}

}
