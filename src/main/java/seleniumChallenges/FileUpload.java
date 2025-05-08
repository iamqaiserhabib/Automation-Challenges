package seleniumChallenges;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	
	@Test
	public void fileUpload() throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.foundit.in/upload");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		Thread.sleep(3000);
		
		//Using sendKeys method
//		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\admin\\Downloads\\New Text Document.txt");
		
		//Using Robot Class
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='file-upload']")));
		
		StringSelection filePathSelection = new StringSelection("C:\\Users\\admin\\Downloads\\New Text Document.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		
		Thread.sleep(3000);
		Robot rb = new Robot(); 
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
//		driver.quit();
	}

}
