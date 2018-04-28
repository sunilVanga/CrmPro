package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public TestBase(){
	 prop=new Properties();
	 try {
		FileInputStream fis=new FileInputStream("D:\\sunil\\java\\sunilWorkSpace1\\com.qa.crm1\\src\\main\\java\\com\\qa\\cofig\\config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
		
	}
	public static void initialization(){
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\sunil\\java\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\sunil\\java\\geckodriver-v_12_0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
	}

}
