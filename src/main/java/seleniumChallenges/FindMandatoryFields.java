package seleniumChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindMandatoryFields {
	
	@Test
	public void findMandatoryFieldsOnPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com.gr/index.php?route=account/register");
		driver.manage().window().maximize();
		
		List<WebElement> elements = driver.findElements(By.xpath("//form[@class='form-horizontal']//label"));
		
		for(WebElement ele: elements) {
//			System.out.println("Mandatory Fields: "+ ele.getText());
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String content = js.executeScript("return window.getComputedStyle(arguments[0], '::Before').getPropertyValue('content');", ele).toString();
			
			if(content.contains("*")) {
				System.out.println(ele.getText() +" is a Mandatory Fields");
			}
			else {
				System.out.println("Not Mandatory");
			}
			
		}
		
		driver.quit();
	}

}
