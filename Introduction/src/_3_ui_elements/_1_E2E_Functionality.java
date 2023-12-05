package _3_ui_elements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class _1_E2E_Functionality {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		/*
		 * HANDLE THE RADIO BUTTON
		 */
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		/*
		 * HANDLE THE AUTO-SUGGESTIVE DROP-DOWN
		 */
		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		/*
		 * HANDLE THE CHECKBOX
		 */
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);
		
		/*
		 * HANDLE THE DYNAMIC DROP-DOWN
		 */
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VTZ']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		/*
		 * HANDLE THE MULTIPLE SELECTION DROP-DOWNS
		 */
		WebElement passengers = driver.findElement(By.id("divpaxinfo"));
		passengers.click();
		Assert.assertEquals(passengers.getText(), "1 Adult");
		WebElement adult = driver.findElement(By.id("hrefIncAdt"));
		WebElement child = driver.findElement(By.id("hrefIncChd"));
		WebElement infant = driver.findElement(By.id("hrefIncInf"));
		
		int adt = 1;
		while(adt < 2) {
			adult.click();
			adt++;
		}
		
		for(int i = 0; i <= 2; i++) {
			child.click();
		}
		
		for(int i = 0; i <= 2; i++) {
			infant.click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(passengers.getText(), "2 Adult, 3 Child, 3 Infant");
		
		/*
		 * HANDLE THE STATIC DROP-DOWNS
		 */
		WebElement static_dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(static_dropdown);
		dropdown.selectByIndex(3);
		dropdown.selectByVisibleText("AED");
		dropdown.selectByValue("INR");
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "INR");
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		driver.close();
	}
}
