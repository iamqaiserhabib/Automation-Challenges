package seleniumChallenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecutionWithDataProviderInTestNG {
	
	@Test(dataProvider="loginData")
	public void loginTest(String email, String password) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		boolean loginStatus;
		try {
			loginStatus = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
			Assert.assertTrue(loginStatus);
		}
		catch(Exception e) {
			loginStatus = false;
			Assert.assertTrue(loginStatus);
		}
		finally {
			driver.quit();
		}
		
	}
	
	@DataProvider(parallel=true, indices= {0,1,2})
	public String[][] loginData(){
		String[][] data = {
				{
					"sajidali@yopmail.com", "123456"
				},
				{
					"sajidali1@yopmail.com", "123456"
				},
				{
					"sajidali2@yopmail.com", "123456"
				}
		};
		return data;
	}

}
