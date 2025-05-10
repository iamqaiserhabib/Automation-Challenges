package seleniumChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FindElements {
	
	@Test
	public void findElementOnScrollingPageInfinitly() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
		//Birds
//		WebElement book = driver.findElement(By.xpath("https://www.booksbykilo.in/new-books"));
		
//		Actions act = new Actions(driver);
//		act.scrollToElement(book);
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntooView();", book);
		
		boolean found = false;
		while(!found) {
			List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			
			for(WebElement book: books) {
				
				if(book.getText().equals("Birds")) {
					System.out.println("Book Found.");
					found = true;
					break;
				}
			}
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			Thread.sleep(5000);
		}
		
		driver.quit();
	}

}
