import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class MyClass {
	WebDriver driver = new ChromeDriver();
	String WebsiteUrl = "https://global.almosafer.com/en";

	@BeforeTest 
	public void Setup () {
		driver.manage().window().maximize();
		driver.get(WebsiteUrl);
		WebElement CurrencyButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		CurrencyButton.click();
	} 
	
	
	
	
	
	
	
	@Test (priority=1)
	public void CheckLanguage () {
		String ActualLanguage= driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";
		org.testng.Assert.assertEquals(ActualLanguage,ExpectedLanguage);
	} 
	
	@Test (priority=2)
	public void CheckTheCurrencyIsSAR () {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		String ExpectedCurrency = "SAR";
		org.testng.Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		
	}
	
	@Test(priority=3)
	public void CheckContactNumber () {
		
		String ActualNumber= driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedNumber="+966554400000";
		org.testng.Assert.assertEquals(ActualNumber,ExpectedNumber);
	//	driver.findElement(By.id("action-button")).click();
	}
	
	
	@Test (priority=4)
	public void CheckQitaf () {
	Boolean ActualResult=driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		String ExpectedResult = "true";
		org.testng.Assert.assertEquals(ActualResult, ExpectedResult);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void ok () {} 
}
