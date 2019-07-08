package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EchoEcho {
	
public WebDriver driver;
	
	@Before
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://echoecho.com/htmlforms10.htm");
	}
	
	@After
	public void tearDown() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
	
	@Test
	public void radioButtonTest() {
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
		
		for(int i =0; i<count; i++ ) {
			//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

			String text=driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

			if(text.equals("Cheese"))

			{

			driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

			}
			
		}
		
	}
	

}
