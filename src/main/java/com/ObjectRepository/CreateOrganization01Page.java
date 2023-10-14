package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class CreateOrganization01Page extends WebDriverUtility {
	
	@FindBy(name="accountname")
	public WebElement OrgNameEdt01;
	
	@FindBy(xpath="//input[@style=\"width:74%;\"]")
	public WebElement WebSiteEdt01;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	public WebElement MemberLookupImageclick01;
	
	@FindBy(name="search_text")
	public WebElement SearchEdt01;
	
	@FindBy(name="search")
    public WebElement SearchBtn01;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	public WebElement SaveButtn01;
	
	public CreateOrganization01Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt01() {
		return OrgNameEdt01;
	}



	public WebElement getWebSiteEdt01() {
		return WebSiteEdt01;
	}



	public WebElement getMemberLookupImageclick01() {
		return MemberLookupImageclick01;
	}



	public WebElement getSearchEdt01() {
		return SearchEdt01;
	}



	public WebElement getSearchBtn01() {
		return SearchBtn01;
	}



	public WebElement getSaveButtn01() {
		return SaveButtn01;
	}
	
	public void createOrg01Page(WebDriver driver,String OrgName01, String Sample)
	{
		OrgNameEdt01.sendKeys(OrgName01);
	
		
		MemberLookupImageclick01.click();
		switchToWindow(driver, "Accounts");
		
		SearchEdt01.sendKeys(Sample);
		SearchBtn01.click();
		
		driver.findElement(By.xpath("//a[.='Sample']")).click();
		//switchToWindow(driver, "Accounts");
		switchToWindow(driver,"Accounts");
		SaveButtn01.click();
	}	
}