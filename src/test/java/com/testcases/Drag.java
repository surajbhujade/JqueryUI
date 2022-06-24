package com.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {
	
	public static WebDriver driver;

	@Test
	public void dragElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		driver.findElement(By.linkText("Draggable")).click();
		
		Actions a = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement source=driver.findElement(By.id("draggable"));

		
		a.dragAndDropBy(source, 100, 100).build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	@Test
	public void dropElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		driver.findElement(By.linkText("Droppable")).click();
		
		Actions a = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	@Test
	public void resizeElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		driver.findElement(By.linkText("Resizable")).click();
		
		Actions a = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement source=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));		

		a.clickAndHold(source).moveByOffset(10, 50).release().build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
//	@Test
	public void selectElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		driver.findElement(By.linkText("Selectable")).click();
		
		Actions a = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement e1 = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
		
		WebElement e3 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
		
		a.click(e1).build().perform();
		
		a.click(e3).sendKeys(Keys.COMMAND).click(e1).build().perform();
		
		Thread.sleep(5000);
		
		driver.quit();
	}
	
//	@Test
	public void sortElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		driver.findElement(By.linkText("Sortable")).click();
		
		Actions a = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		List<WebElement> l=driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		String s="", s1="";
		
		for(WebElement e:l)
		{
			s=s1;
			System.out.println(e.getText());
			
			s1=e.getText();
			
		}
		
		Thread.sleep(5000);
		
		driver.quit();
	}
	
//	@Test
	public void defSlider() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		
		Actions a = new Actions(driver);
		
	
		
		driver.findElement(By.xpath("//*[@id='sidebar']/aside[2]/ul/li[11]/a")).click();
		
		driver.switchTo().frame(0);
		
		//WebElement def=driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));
		
		WebElement def=driver.findElement(By.id("slider"));
		
		a.dragAndDropBy(def, 50, 0).build().perform();

		
		//driver.findElement(By.xpath("//*[@id='content']/div[1]/ul/li[2]/a")).click();
		
		//WebElement red=driver.findElement(By.xpath("//*[@id='red']/span"));
		WebElement red=driver.findElement(By.cssSelector("#red > span"));
		WebElement green=driver.findElement(By.xpath("//*[@id='green']/span"));
		WebElement blue=driver.findElement(By.xpath("//*[@id='blue']/span"));
		
		
		
		
		a.clickAndHold(red).moveByOffset(-10, 0).release().build().perform();
		a.clickAndHold(green).moveByOffset(-20, 0).release().build().perform();
		a.clickAndHold(blue).moveByOffset(-30, 0).release().build().perform();
		
		
		Thread.sleep(5000);
		
		driver.quit();
	}

	//@Test
	public void colourPicker() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
		
		AssertJUnit.assertEquals("jQuery UI", driver.getTitle());
		
		
		Actions a = new Actions(driver);
		
	
		
		driver.findElement(By.xpath("//*[@id='sidebar']/aside[2]/ul/li[11]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='content']/div[1]/ul/li[2]/a")).click();

		
		driver.switchTo().frame(0);
		
		WebElement red=driver.findElement(By.xpath("//*[@id='red']/span"));
	//	WebElement red=driver.findElement(By.cssSelector("#red > span"));
		WebElement green=driver.findElement(By.xpath("//*[@id='green']/span"));
		WebElement blue=driver.findElement(By.xpath("//*[@id='blue']/span"));
		
		
		
		
		a.clickAndHold(red).moveByOffset(-10, 0).release().build().perform();
		a.clickAndHold(green).moveByOffset(-20, 0).release().build().perform();
		a.clickAndHold(blue).moveByOffset(-30, 0).release().build().perform();
		
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
