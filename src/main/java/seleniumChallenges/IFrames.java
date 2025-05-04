package seleniumChallenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class IFrames {
	
	@Test
	public void handlingIFramesWithoutUsingSwitchTo() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.cssSelector("frame[src='frame_1.html']"));
		
		//Using SwitchTo
//		driver.switchTo().frame(frame);
//		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
		
		//Using Explicit Wait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		myWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("frame[src='frame_1.html']")));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
	}
}
