package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage login;
	Homepage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		TestBase.initialization();
		login=new LoginPage();
	}
	@Test
	public void loginPageTitletest(){
	String title=	login.validateLoginPageTitle();
	Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	
		
	}
	@Test
	public void crmLogotest(){
		boolean flag=login.ValidateCrmLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		
	homepage=login.login("naveenk","test@123");
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
