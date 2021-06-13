import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the  column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//tofial test
		//driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all veggie web elements in list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all elements in new (orignal) list using streams
		List<String> text = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the orignal the list
		List<String> sortedList = text.stream().sorted().collect(Collectors.toList());
		
		//compare orginal vs sorted listed
		Assert.assertTrue(text.equals(sortedList));
		
		
		
		List<String> price;
		
		do {
				//capture all veggie web elements in list
				List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
				
				//scan the veggi column with gettext-> Beans ->print price of the rice
				price = rows.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
				
				price.forEach(s->System.out.println(s));
				
				if (price.size()<1) 
				{
					driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}
			
			} 
		while (price.size()<1);
		
	}
	
	public static String getPriceVeggie(WebElement s) 
	{
		String piceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return piceValue;
	}

}
