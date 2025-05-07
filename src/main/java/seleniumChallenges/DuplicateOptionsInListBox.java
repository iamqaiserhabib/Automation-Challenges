package seleniumChallenges;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DuplicateOptionsInListBox {

	@Test
	public void duplicateItemInListBox() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement listBoxElement = driver.findElement(By.xpath("//select[@id='colors']"));
		Select listBox = new Select(listBoxElement);
		
		Set<String> uniqueOptions = new HashSet<String>();
		
		boolean flag = false;
		for(WebElement option: listBox.getOptions()) {
			String optionText = option.getText();
			if(!uniqueOptions.add(optionText)) {
				System.out.println("Duplicate option found: "+ optionText);
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("No Duplicates found");
		}
		
		driver.quit();
	}
}
