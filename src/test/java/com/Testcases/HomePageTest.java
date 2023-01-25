package com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Pages.ContactsPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Utils.Utils;

public class HomePageTest extends BaseClass {

	LoginPage Login;
	HomePage homepage;
	Utils utils;
	ContactsPage Contacts ;
	

	public HomePageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser();
		Login = new LoginPage();
		utils = new Utils();
		homepage = Login.login(prop.getProperty("username"), prop.getProperty("password"));
		Contacts = new ContactsPage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {

		String HPTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(HPTitle, "CRMPRO");

	}

	@Test(priority = 2)
	public void verifyUserNameTest() {

		utils.switchToFrame();

		boolean flag = homepage.verifyUserName();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void clickContactsBtn() throws IOException {

		utils.switchToFrame();
		Contacts = homepage.clickContacts();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
