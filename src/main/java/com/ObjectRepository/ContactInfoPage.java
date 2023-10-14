package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement ContactInfoHeader;
    
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactInfoHeader() {
		return ContactInfoHeader;
	}
	
	public String getContactPageInfoPageHeader()
	{
		return ContactInfoHeader.getText();
	}
}
