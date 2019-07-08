package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	
public WebDriver driver;
	
	@Before
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
	}
	
	@After
	public void tearDown() {
		//driver.quit();
		
	}
	
	@Test
	public void autoSugestiveDropdownTest() {
		
		
	}

}
