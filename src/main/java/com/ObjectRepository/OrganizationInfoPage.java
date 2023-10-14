package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement OrgInfoText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgInfoText() {
		return OrgInfoText;
	}
  
	public String getOrgInfoPageHeader()
	{
		return OrgInfoText.getText();
	}
}
