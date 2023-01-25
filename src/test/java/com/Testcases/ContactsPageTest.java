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

public class ContactsPageTest extends BaseClass {

	LoginPage Login;
	HomePage homepage;
	Utils utils;
	ContactsPage Contacts;

	public ContactsPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser();
		Login = new LoginPage();
		utils = new Utils();
		Contacts = new ContactsPage();
		homepage = Login.login(prop.getProperty("username"), prop.getProperty("password"));
		utils.switchToFrame();
		homepage.clickContacts();

	}

	@Test(priority = 1)
	public void verifyLabel() {

		boolean falg = Contacts.verifyLable();
		Assert.assertTrue(falg);
	}

	@Test(priority = 2)
	public void selectContacts() {

		Contacts.selectName("Navneet Jha");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
