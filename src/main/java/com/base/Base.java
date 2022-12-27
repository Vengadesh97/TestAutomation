package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	static Properties prop;
	
	@BeforeSuite
	public void browserLaunch() throws IOException
	{
		
		readConfig();
		
		String browser1 = prop.getProperty("browser");
		
		if(browser1.equalsIgnoreCase("chrome"))
		{
			driver = WebDriverManager.chromedriver().create();
		}
		else if(browser1.equalsIgnoreCase("Firefox"))
		{
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if(browser1.equalsIgnoreCase("Edge"))
		{  
			driver=WebDriverManager.edgedriver().create();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void browserQuit() throws IOException
	{	
		driver.quit();
	}
	

	
	//Configure properties file
	public void readConfig() throws IOException
	
	{
		FileInputStream stream = new FileInputStream("C:\\Users\\Hello World\\eclipse-workspace\\VitaGistProd\\Configuration\\Config.properties");
		
		prop = new Properties();
		
		prop.load(stream);
		
	}

}
