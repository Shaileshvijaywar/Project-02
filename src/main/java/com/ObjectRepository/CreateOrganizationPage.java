package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	//declaration
	
	@FindBy(name="accountname")
	private WebElement OragnizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement NewOrgSaveBtn;
	
	//initialization
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//	//Utilization
	
	public WebElement getOragnizationNameEdt() {
		return OragnizationNameEdt;
	}


	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}


	public WebElement getNewOrgSaveBtn() {
		return NewOrgSaveBtn;
	}

	  
		//Business Library
	/**
	 * this method will create with organization name
	 * @param OrgName
	 */
	public void createNewOrganizationPage(String OrgName)
	{
		
		OragnizationNameEdt.sendKeys(OrgName);
		 NewOrgSaveBtn.click();
	}
	/**
	 * This method will  create organization with industry 
	 * @param OrgName
	 * @param Industry
	 */
	public void createNewOrganizationPage(String OrgName, String Industry)
	{
		
		OragnizationNameEdt.sendKeys(OrgName);
		dropDownbyText(IndustryDropDown, Industry);
		 NewOrgSaveBtn.click();
	}
	
	
}
