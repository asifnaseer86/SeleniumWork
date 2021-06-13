import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

public class Maximized_DeleCookies {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Maximise browser
		driver.manage().window().maximize();
		
		//Delete cookies
		driver.manage().deleteAllCookies();
		
		//delete one cookie
		//driver.manage().deleteCookieNamed("sessionkey");
		
		//add cookies
		//driver.manage().addCookie(null);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\Cyborg Tech\\Automation Testing Selenium\\ScreenShots\\test.png"));
	}

}
