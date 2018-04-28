package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage  extends TestBase{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	@FindBy(xpath="//img[@class='img-responsive' and @src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean ValidateCrmLogo(){
		return crmLogo.isDisplayed();
	}
	
	public Homepage login(String un,String pwd) throws InterruptedException{
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='un';", username);
		Thread.sleep(5000);
		js.executeScript("arguments[0].value='pwd';", password);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(10000);
		
		return new Homepage();
	}
}
