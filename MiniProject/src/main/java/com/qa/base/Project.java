package com.qa.base;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project {
	public static WebDriver driver;
	@BeforeTest
 public void setUp() {
	 WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
 }
	
	@Test(priority=0)
	public void linkTest() {
	driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
			//driver.get("https://www.beecrowd.com.br/judge/en/login");
	}
	
	@Test(priority=1)
	//@Test (dependsOnMethods="linkTest")
	public void getName() throws InterruptedException {
//		driver.findElement(By.id("email")).sendKeys("Shoily9192@gmail.com");
//	    driver.findElement(By.id("password")).sendKeys("Code$919#");
		//Thread.sleep(3);
		WebElement user= driver.findElement(By.xpath("//*[@name='username']"));
		user.sendKeys("Mahin");
		
		
	}
	@Test(priority=2)
	//@Test (dependsOnMethods="linkTest")
	public void getPassword() {
		WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("123");
	}
	
	//*[@id="HTMLFormElements"]/table/tbody/tr[3]/td/textarea
	@Test(priority=3)
	public void cleanComment() {
		WebElement comment= driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
		comment.clear();
		
		
	}
	
	@Test(priority=4)
	public void getComment() {
		WebElement comment= driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
		comment.sendKeys("hiii writting comment");
		
		
	}
	
	@Test(priority=5)
	public void radiobutton(){
		List <WebElement> radiobutton= driver.findElements(By.xpath("//*[@type='radio']"));
		int totalButton=radiobutton.size();
		System.out.println("total radio button"+totalButton);
		int exp=3;
		int act=totalButton;
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=6)
	public void radioClick() throws InterruptedException {
		//driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		WebElement button=driver.findElement(By.xpath("//*[@type='radio']"));
		button.click(); 
		boolean exp=true;
		boolean act=button.isSelected();
		Assert.assertEquals(act, exp);
		Thread.sleep(3000);
		
	}
	
	@Test(priority=7)
	public void checkBox() {
		List <WebElement> checkBox= driver.findElements(By.xpath("//*[@type='checkbox']"));
		int totalcheckBox=checkBox.size();
		System.out.println("total check button"+totalcheckBox);
		int exp=3;
		int act=totalcheckBox;
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=8)
	public void checkboxClick(){
		WebElement check=driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
		check.click();
		boolean exp=true;
		boolean act=check.isSelected();
		Assert.assertEquals(act, exp);
		
	}
	@Test(priority=13)
	public void file() throws InterruptedException {
		WebElement fileUp=driver.findElement(By.xpath("//input[@type='file']"));
	fileUp.submit();
	
	}
//	
	@Test(priority=9)
	public void dropDowns() {
		WebElement dropDown=driver.findElement(By.xpath("//*[@name='dropdown']"));
		Select select=new Select(dropDown);
		List<WebElement>list=select.getOptions();
		int totalOption=list.size();
		System.out.println("total option:"+totalOption);
		int exp=6;
		int act=totalOption;
		Assert.assertEquals(act, exp);
		
	}
	
	@Test(priority=10)
	public void dropdown() {
		WebElement dropDown=driver.findElement(By.xpath("//*[@name='dropdown']"));
		Select select=new Select(dropDown);
		select.selectByIndex(5);
	}
	
	@Test(priority=11)
	public void selectMultiple() {
		WebElement selectMult=driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select=new Select(selectMult);
		List<WebElement>list=select.getOptions();
		int totalOption=list.size();
		System.out.println("total option:"+totalOption);
		int exp=4;
		int act=totalOption;
		Assert.assertEquals(act, exp);
		
	}
	
	@Test(priority=12)
	public void selectMul() {
		WebElement selectMultiple=driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select=new Select(selectMultiple);
		select.selectByValue("ms1");
	}
	
	@Test(priority=12)
	
	public void submit() {
		WebElement submit=driver.findElement(By.xpath("//input[@name='submitbutton'][2]"));
		submit.submit();
	}
 @AfterTest
 public void tearDown() {

	         
	        if (driver != null) {
            driver.quit();
	        }
    
 }
}
