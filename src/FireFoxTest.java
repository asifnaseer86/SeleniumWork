import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//selenium code
				//create diver object for chrome browser
				
				System.setProperty("webdriver.gecko.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\geckodriver.exe");
				WebDriver driver = new  FirefoxDriver();
				
				driver.get("http://google.com");
				System.out.println(driver.getTitle());
				driver.quit();
	}

}
