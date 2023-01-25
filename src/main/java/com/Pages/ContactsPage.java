package com.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BaseClass.BaseClass;

public class ContactsPage extends BaseClass {

	@FindBy(xpath = "//td[@class='datacardtitle'][normalize-space()='']")
	WebElement contactsLable;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement Fname;

	@FindBy(xpath = "//input[@id='surname']")
	WebElement Lname;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement SaveBtn;

	public ContactsPage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public boolean verifyLable() {

		return contactsLable.isDisplayed();

	}

	public void selectName(String name) {

		driver.findElement(By.xpath("//a[normalize-space()='" + name + "']")).click();

	}

	public void createNewContacts(String title , String first , String last , String comp) {

		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));

		select.selectByVisibleText(title);

		Fname.sendKeys(first);

		Lname.sendKeys(last);

		company.sendKeys(comp);

		SaveBtn.click();

	}

}
