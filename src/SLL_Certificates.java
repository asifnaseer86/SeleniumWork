
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SLL_Certificates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Desired capabilities
		//General Chrome Profile
		DesiredCapabilities dCap = DesiredCapabilities.chrome();
		
		//accept ssl certificates
		//dCap.acceptInsecureCerts(); // currently not using
		
		//another gernalize way to add insecure and ssl certificates
		dCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // for insecure certificates
		dCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); // for ssl certificates
		
		//SSL Certificates
		ChromeOptions cOpt = new ChromeOptions();
		
		//merg gernal profile to local chrome browser
		cOpt.merge(dCap);
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(cOpt);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		

	}

}
