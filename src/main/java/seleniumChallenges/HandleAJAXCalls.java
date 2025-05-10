package seleniumChallenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAJAXCalls {
	
	@Test
	public void handleAJAXCalls() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='loadContent']")).click();
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']/h2")));
		
		WebElement loadedElement = driver.findElement(By.xpath("//div[@id='ajaxContent']/h2"));
		System.out.println(loadedElement.getText());
		
		driver.quit();
	}

}
