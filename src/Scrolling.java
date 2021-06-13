
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//scrolling_counting(driver);
		assignment(driver);
	}
	
	public static void scrolling_counting(WebDriver driver) throws InterruptedException 
	{
		
		//to run java script
		JavascriptExecutor js = (JavascriptExecutor)driver;
				
		//scroll on page
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000L);
				
		//scroll on component
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		//document.querySelector('.tableFixHead').scrolTop=5000
				
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i=0; i<values.size(); i++) 
		{
			sum = sum + Integer.parseInt(values.get(i).getText());
					
		}
		System.out.println(sum);
				
		int total =Integer.parseInt( driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
				
		Assert.assertEquals(sum, total);
	}
	
	
	public static void assignment(WebDriver driver) 
	{
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		int rowSize = rows.size();
		
		List<WebElement> col = driver.findElements(By.cssSelector(".table-display tr th"));
		int colSize = col.size();
		
		System.out.println("Column Size: " + colSize);
		System.out.println("Row Size: " + rowSize);

		WebElement table = driver.findElement(By.cssSelector(".table-display"));
		
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());
		
	}

	public static void assignment2(WebDriver driver) throws InterruptedException 
	{
		

	    driver.findElement(By.id("autocomplete")).sendKeys("ind");

	    Thread.sleep(2000);

	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

	    System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
		
	}

}
