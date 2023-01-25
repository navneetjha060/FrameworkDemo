package com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Pages.HomePage;
import com.Pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {

		launchBrowser();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void logotest() {
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag, null);

	}

	@Test(priority = 3)
	public void loginTest() throws IOException {

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
