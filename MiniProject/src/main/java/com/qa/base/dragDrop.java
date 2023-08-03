package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragDrop {
	public static WebDriver driver;
	@BeforeTest
 public void setUp() {
	 WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
 }
	
	@Test(priority=0)
	public void linkTest() {
	driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");
			//driver.get("https://www.beecrowd.com.br/judge/en/login");
	}
	
	@Test(priority=1)
	public void drag()  {
		WebElement dragLeft=driver.findElement(By.xpath("//div[@class='drag left']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable1']"));
        Actions act=new Actions(driver);					

	//Dragged and dropped.		
        act.dragAndDrop(dragLeft, drop).build().perform();	
        
        WebElement p=driver.findElement(By.xpath("//*[@id=\"droppable1\"]/p"));
        String ex="Dropped!";
        String ac=p.getText();
        Assert.assertEquals(ac, ex);
        
	}
	
	@Test(priority=2)
	public void drag2()  {
		WebElement dragLeft=driver.findElement(By.xpath("//div[@class='drag right']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable1']"));
        Actions act=new Actions(driver);					

	//Dragged and dropped.		
        act.dragAndDrop(dragLeft, drop).build().perform();	
        
        WebElement p=driver.findElement(By.xpath("//*[@id=\"droppable1\"]/p"));
        String ex="Get Off Me!";
        String ac=p.getText();
        Assert.assertEquals(ac, ex);
        
	}
	
}
