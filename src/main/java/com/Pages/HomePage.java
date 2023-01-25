package com.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement contactBtn;

	@FindBy(xpath = "//a[normalize-space()='New Contact']")
	WebElement newContacts;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {

		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickContacts() throws IOException {
		contactBtn.click();
		return new ContactsPage();

	}

	public void clickNewContacts() throws IOException {
		Actions action = new Actions(driver);

		action.moveToElement(contactBtn).build().perform();

		newContacts.click();
		
	}

}
