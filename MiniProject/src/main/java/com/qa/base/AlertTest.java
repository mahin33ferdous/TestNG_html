package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {
	public static WebDriver driver;
	@BeforeTest
 public void setUp() {
	 WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
 }
	
	@Test(priority=0)
	public void linkTest() {
	driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
			//driver.get("https://www.beecrowd.com.br/judge/en/login");
	}
	
	@Test(priority=1)
	public void showAlertBox() throws InterruptedException {
		WebElement alertButton=driver.findElement(By.id("alertexamples"));
		alertButton.click();
		
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		
	}
	
	@Test(priority=2)
	public void showConfirmBox()  {
		WebElement confirmButton=driver.findElement(By.id("confirmexample"));
		confirmButton.click();
		//Alert alert=driver.switchTo().alert();
	}
	
	@Test(priority=3,dependsOnMethods="showConfirmBox")
	public void acceptConfirm() throws InterruptedException {
		
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		
	}
	
	@Test(priority=4)
	public void cancelConfirm() throws InterruptedException {
		Thread.sleep(3000);
		showConfirmBox();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
		
	}
	
	@Test(priority=5)
	public void showProptBox()  {
		WebElement proptButton=driver.findElement(By.id("promptexample"));
		proptButton.click();
		//Alert alert=driver.switchTo().alert();
	}
	
	@Test(priority=6,dependsOnMethods="showProptBox")
	public void acceptpropt() throws InterruptedException {
		
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		
		alert.sendKeys("Selenium");
		Thread.sleep(3000);
		alert.accept();
		
	}
	
	@Test(priority=7)
	public void cancelpropt() throws InterruptedException {
		Thread.sleep(3000);
		showProptBox();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
		
	}
	
	
	@AfterTest
	 public void tearDown() {

		   
        if (driver != null) {
        driver.quit();
        }
 
	}	     
}
