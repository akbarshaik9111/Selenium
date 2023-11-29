package _1_introduction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class _4_Handling_WEB_UI {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		/*
		 * HANDLE THE AUTO-SUGGESTIVE DROP-DOWN
		 */
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		/*
		 *  HANDLE THE CHECKBOXES
		 */
		WebElement friendsAndFamily = driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']"));
		Assert.assertFalse(friendsAndFamily.isSelected());
		friendsAndFamily.click();
		Assert.assertTrue(friendsAndFamily.isSelected());
		
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		/*
		 * HANDLE DYNAMIC DROP-DOWN
		 */
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		//NOT RECOMMENDED
		//driver.findElement(By.xpath("(//a[@value='GAU'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GAU']")).click();
		
		/*
		 * HANDLE THE LOOP DROP-DOWN
		//
		WebElement passengers = driver.findElement(By.id("divpaxinfo"));
		System.out.println(passengers.getText());
		passengers.click();
		
		WebElement adult = driver.findElement(By.id("hrefIncAdt"));
		WebElement child = driver.findElement(By.id("hrefIncChd"));
		WebElement infant = driver.findElement(By.id("hrefIncInf"));
		
		int alt = 1;
		while(alt < 2) {
			adult.click();
			alt++;
		}
		
		for(int i = 1; i <=2; i++) {
			child.click();
		}
		
		for(int i = 1; i <=2; i++) {
			infant.click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(passengers.getText());
		
		//HANDLE THE STATIC DROP-DOWNS
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		*/
		
		//driver.close();
	}

}
