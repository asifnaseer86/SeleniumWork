
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Action_Frame_ChildWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		//click_doubleClick_rightClick(driver);
		
		//handle_childWindows_parentWindows(driver);
		
		//handle_franes(driver);
		
		handle_nestedfranes(driver);
		
	}
	
	public static void click_doubleClick_rightClick(WebDriver driver) throws InterruptedException 
	{
		 driver.get("https://www.amazon.com/");
		Thread.sleep(3000);
		
		
		Actions a = new Actions(driver);
		
		//enter keys in caps
		WebElement enterKeys = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(enterKeys).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//double click
		a.moveToElement(enterKeys).doubleClick().build().perform();
		
		//Mouse hover
		WebElement move = driver.findElement(By.xpath("//div[@class='layoutToolbarPadding']/a[@id='nav-link-accountList']"));
		a.moveToElement(move).build().perform();
		
		//right click
		a.moveToElement(move).contextClick().build().perform(); 
	}

	public static void handle_childWindows_parentWindows(WebDriver driver) 
	{
		//handle child windows
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				
		driver.findElement(By.xpath("//a[contains(text(),'Free Access to InterviewQues/ResumeAssistance/Mate')]")).click();

		Set<String> windows = driver.getWindowHandles(); //parent child windows
		Iterator<String> it = windows.iterator(); // it will get id of the browser windows
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
				
		String emailDetails = driver.findElement(By.cssSelector(".im-para.red")).getText();
				
		System.out.println(emailDetails);
				
		emailDetails = emailDetails.split("at")[1].trim().split(" ")[0];
		System.out.println(emailDetails);
				
		driver.switchTo().window(parentId);
				
		driver.findElement(By.cssSelector("#username")).sendKeys(emailDetails);
	}

	public static void handle_franes(WebDriver driver) 
	{
		driver.get("https://jqueryui.com/droppable/");
		
		// check number of frame	
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameCount);
		
		//frame switching
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		driver.findElement(By.id("draggable")).click();
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		//come out from frame should switch back to content
		driver.switchTo().defaultContent();
	}

	public static void handle_nestedfranes(WebDriver driver) 
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		
		//first nested top frames switching
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		
		//middle from of inner from of nested top frames switching
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		
		String text = driver.findElement(By.id("content")).getText();
		System.out.println(text);
		
		//come out from frame should switch back to content
		driver.switchTo().defaultContent();
		
	}
}
