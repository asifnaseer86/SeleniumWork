
import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UI_Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.xpath("//input[@name='travel_date']")).click();
		
		//month
		
		
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("Dec"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
			
		}
		
		List<WebElement> allDates = driver.findElements(By.cssSelector(".day"));
		
		int count = driver.findElements(By.cssSelector(".day")).size();
		String text = "";
		for(int i=0; i<count; i++) 
		{
			text = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if(text.equalsIgnoreCase("23")) 
			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
				
		}

	}

}
