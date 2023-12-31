package _7_realtimeexcersises_scope;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _1_LimitingWebDriver {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		//FIND THE TOTAL LINKS PRESENT IN THE WEB PAGE
		int total_links = driver.findElements(By.tagName("a")).size();
		System.out.println("TOTAL LINKS PRESENT IN THE WEB PAGE : "+total_links);
		
		
		//LIMITING THE DRIVER AND FIND OUT THE TOTAL LINKS PRESENT IN FOOTER SECTION
		WebElement footerSection = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		total_links = footerSection.findElements(By.tagName("a")).size();
		System.out.println("TOTAL LINKS PRESENT IN THE FOOTER SECTION : "+total_links);
		
		// LIMITING THE DRIVER AND FIND OUT THE TOTAL LINKS PRESENT IN FOOTER SECTION COLUMN
		WebElement firstFooterColumn = footerSection.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
		total_links = firstFooterColumn.findElements(By.tagName("a")).size();
		System.out.println("TOTAL LINKS PRESENT IN THE FOOTER SECTION FIRST COLUMN: "+total_links);
		
		for(int i = 1; i < firstFooterColumn.findElements(By.tagName("a")).size(); i++) {
			String clickLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstFooterColumn.findElements(By.tagName("a")).get(i).sendKeys(clickLinks);
		}
		
		//ITERATE EACH AND EVERY WINDOW AND GET THE TITLE
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
