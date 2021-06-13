

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;

public class CheckBox_RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//check checkbox selected or not
		Boolean validatation = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		System.out.println(validatation);
		Assert.assertTrue(validatation);
		//count number of check boxes
		int chksize = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		Assert.assertEquals(chksize, 5);
		System.out.println(chksize);
		
	}

}
