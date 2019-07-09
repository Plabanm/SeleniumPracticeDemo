package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {
	
public WebDriver driver;
	
	@Before
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
	}
	
	@After
	public void tearDown() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		
	}
	
	@Test
	public void checkBoxTest() {
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
	}
	
	@Test
	public void calenderTest() {
		
	}
	
	@Test
	public void dynamicDropdownTesting() {
		driver.findElement(By.cssSelector(".select_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Chennai (MAA)')]")).click();
		driver.findElement(By.cssSelector(".select_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		//driver.findElement(By.linkText("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT'] //a[@value='HYD']]")).click();


		

	}
	
	
	@Test
	public void StaticDropDownTest() {
		Select select = new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency")));
		select.selectByValue("USD");
		select.selectByIndex(2); //Index starts from 1
		select.selectByVisibleText("INR");
		
		// also possible to deSelect 
		
	}
	
	@Test
	public void optionDropDownTest() {
		driver.findElement(By.cssSelector(".paxinfo")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		
		/*
		int i = 1;
		while(i<5){
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			i++;
		}*/
		
		for(int i =1; i<5; i++) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		}
		
		driver.findElement(By.cssSelector("#hrefIncChd")).click();
		driver.findElement(By.cssSelector("#hrefIncInf")).click();
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		
	}


}
