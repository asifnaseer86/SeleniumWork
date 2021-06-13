

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;

public class Calender_DateSelection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		driver.findElement(By.name("ctl00$mainContent$rbtnl_Trip")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("Its Enabled");	
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			
		}

	}

}
