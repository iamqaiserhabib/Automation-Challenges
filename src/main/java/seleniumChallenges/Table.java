package seleniumChallenges;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Table {
	
	@Test
	public void handlingDynamicTable() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Number of rows:"+rows.size());
		
		for(int i=1; i<rows.size(); i++) {
			WebElement name = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[1]"));
			if(name.getText().equals("Chrome")) {
				String cpuLoad = driver.findElement(By.xpath("//td[normalize-space()='Chrome']/following-sibling::*[contains(text(),'%')]")).getText();
				String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				if(value.contains(cpuLoad)) {
					System.out.println("CPU loads of chrome are equal");
				}
				else {
					System.out.println("CPU loads of chrome are not equal");
				}
				break;
			}
		}
	}

}
