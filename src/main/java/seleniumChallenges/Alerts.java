package seleniumChallenges;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alerts {
	
	@Test
	public void handlingAlertsWithoutUsingSwitchTo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(3000);
		
		//Using SwtichTo 
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
		//Using explicit wait
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(3000));
//		Alert alert1 = myWait.until(ExpectedConditions.alertIsPresent());
//		alert1.accept();
		
		//Using JavascriptExecuter
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {
			js.executeScript("window.alert = function{};");
		}
		catch(Exception e) {
			
		}
		
	}

}
