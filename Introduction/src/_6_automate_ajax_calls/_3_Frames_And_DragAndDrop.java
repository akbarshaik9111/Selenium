package _6_automate_ajax_calls;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class _3_Frames_And_DragAndDrop {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "E:\\Testing\\Selenium\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
		
		//SWITCH TO FRAME BY USING WEBELEMENT (OTHER WAYS ARE BY ID AND INDEX)
		driver.switchTo().frame(frame);
		
		//driver.switchTo().frame(0); --> SWITCH THE FRAME USING INDEX
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
	
		//CREATING OBJECT FOR ACTIONS CLASS
		Actions action = new Actions(driver);
		
		//HANDLING DRAG AND DROP
		action.dragAndDrop(drag, drop).build().perform();
		
		//IT COMES TO NORMAL WINDOW MEANS OUT OF FRAME
		driver.switchTo().defaultContent();
		
		driver.close();
	}
}
