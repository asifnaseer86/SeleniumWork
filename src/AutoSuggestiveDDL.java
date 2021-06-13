import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSuggestiveDDL {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		
		Thread.sleep(2000);
		List<WebElement> ddloptions =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for (WebElement ddloption : ddloptions)
		{
			if(ddloption.getText().equalsIgnoreCase("india"))
			{
				ddloption.click();
				break;
			}
		}
		

	}

}
