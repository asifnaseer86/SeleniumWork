
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.asserts.SoftAssert;


public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Maximise browser
		driver.manage().window().maximize();
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//singleBrokenLink(driver);
		
		getWebPageAllBrokenLinks(driver);
	}
	
	public static void singleBrokenLink(WebDriver driver) throws IOException
	{
		//Get all urls tied up to the link  using selenium
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		//JAVA METHODS WILL CALL URLS AND GETS THE STATUS CODE
		//call open connection method which is present in url class
		// and method return type is httpurl connection so cast it accordingly
		HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD"); // to get just status and header information use this method
		conn.connect();
		int statusCode = conn.getResponseCode(); // to get status code
			
		//if status code is greater then 400 then link is broken
		System.out.println(statusCode);
	}

	public static void getWebPageAllBrokenLinks(WebDriver driver) throws MalformedURLException, IOException 
	{
		//Soft Assertion 
		SoftAssert sfAssert = new SoftAssert();
		
		//Get all urls using selenium
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		String url ="";
		
		for(WebElement link : links) 
		{
			url = link.getAttribute("href");
			
			//JAVA METHODS WILL CALL URLS AND GETS THE STATUS CODE
			//call open connection method which is present in url class
			// and method return type is httpurl connection so cast it accordingly
			HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD"); // to get just status and header information use this method
			conn.connect();
			int statusCode = conn.getResponseCode(); // to get status code
			
			System.out.println(statusCode);		
			//if status code is greater then 400 then link is broken
			sfAssert.assertTrue(statusCode < 400, "Link with text: " + link.getText() + " is broken with code " + statusCode);
	
		}
		
		sfAssert.assertAll();
	}
}
