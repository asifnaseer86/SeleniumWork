import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//selenium code
		//create diver object for chrome browser
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		String currenturl = driver.getCurrentUrl();
		String pagesource = driver.getPageSource();
		
		driver.navigate().to("http://yahoo.com");
		driver.navigate().back();
		driver.navigate().forward();
		TimeUnit.MILLISECONDS.toSeconds(5000);
		
		driver.quit();
		
	}

}
