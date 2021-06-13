import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver , 5);
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//add explicit wait here
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
				
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//add explicit wait here
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());

	}
	
	
	
	
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
		List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));
		List arrayList = Arrays.asList(itemsNeeded);
		int j=0;
		
		for(int i=0; i<products.size();i++) {
			
			String name = products.get(i).getText().replace(" - 1 Kg", "");
			// 
			//check whether extracted names are present in arrylist or not
			//convert arry into array list for easy search
			
			if(arrayList.contains(name))
			{
				j++;
				//Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==arrayList.size()) 
				{break;}
			}
		}
	}

}
