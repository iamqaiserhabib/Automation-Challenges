package seleniumChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SortedDropdownList {
	
	@Test
	public void listBoxIsSorted() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
//		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		List<WebElement> options= dropdown.getOptions();
		
		for(WebElement option: options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		
		System.out.println("Before Sorting");
		System.out.println("Original Array"+ originalList);
		System.out.println("Temp Array"+ tempList);
		
		Collections.sort(tempList);
		
		System.out.println("After Sorting");
		System.out.println("Original Array"+ originalList);
		System.out.println("Temp Array"+ tempList);
		
		if(originalList.equals(tempList)) {
			System.out.println("List box is sorted");
		}
		else {
			System.out.println("List box is not sorted");
		}
		
		driver.quit();
	}

}
