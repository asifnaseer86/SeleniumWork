
import java.util.Iterator;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;


public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//getLinkSpecificScope_getMultipleChildWindowsTile(driver);
		
		dynamicSelection(driver);
		
	}
	
	public static void getLinkSpecificScope_getMultipleChildWindowsTile(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//give link count all links should be in a tag
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		// get count of links abailable in footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
		linkCount = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		// get links of first column in footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		linkCount = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		//click on each links in new window of column and check if links are working
		String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(int i=1; i<linkCount ; i++)
		{
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000L);
		}
		
		//get each windows title
		Set<String> windos = driver.getWindowHandles();
		Iterator<String> it = windos.iterator();
		
		while (it.hasNext())
		{			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
	
	
	public static void dynamicSelection(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input[name='checkBoxOption2']")).click();
		
		String text = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText().trim();
		
		WebElement DropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdown = new Select(DropDown);
		
		dropdown.selectByVisibleText(text);
		
		driver.findElement(By.cssSelector("#name")).sendKeys(text);
		
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String validation = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		String[] test = validation.split(",");
		test[0] = test[0].replace("Hello", "").trim();
		
		Assert.assertEquals(text, test[0]);
		

	}

}
