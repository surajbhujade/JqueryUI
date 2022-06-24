package com.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	public static WebDriver driver ;
	public  static void setup()
	{
	WebDriverManager.chromedriver().setup();	
	driver = new ChromeDriver();
	driver.get("https://lyka.com.au/plan/create");	
	driver.manage().window().maximize();
	}

}
