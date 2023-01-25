package com.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class LoginPage extends BaseClass {

	// Page Factory - OR
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement Logo;

	// Initializing the Page Objects
	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return Logo.isDisplayed();
	}

	public HomePage login(String uname, String pwd) throws IOException {

		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();

	}

}
