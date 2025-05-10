package seleniumChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CountElements {
	
	@Test
	public void countElementsOnScrollingPageInfinitly() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		//Using Size
//		List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
//		System.out.println("Number of books: "+ books.size());
		
		//Using JavascriptExcutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//		List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
//		System.out.println("Number of books: "+ books.size());
		
		//
		int previousCount = 0;
		int currentCount = 0;
		
		while(true) {
			List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			currentCount = books.size();
			
			if(currentCount==previousCount) {
				break;
			}
			
			previousCount = currentCount;
//			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			Thread.sleep(5000);
		}
		
		System.out.println("Total Number of books: "+ currentCount);
		
		driver.quit();
	}

}
