package _2_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _3_locators {
	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header//div/button/following-sibling::button")).getText());
		System.out.println(driver.findElement(By.xpath("//header//div/button/following-sibling::button/parent::div/button[2]")).getText());
		driver.close();
	}
}
