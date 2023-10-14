package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath=" //input[@name=\"account_id\"]/following-sibling:: img[@alt=\"Select\"]")
	private WebElement ContactPageOrganizationNameLookUpImage;
	
	@FindBy(name="search_text")
	private WebElement OrganizationSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrganizationSearchBtn;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement ContactSaveBtn;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}


	public WebElement getContactPageOrganizationNameLookUpImage() {
		return ContactPageOrganizationNameLookUpImage;
	}


	public WebElement getOrganizationSearchEdt() {
		return OrganizationSearchEdt;
	}


	public WebElement getOrganizationSearchBtn() {
		return OrganizationSearchBtn;
	}


	public WebElement getContactSaveBtn() {
		return ContactSaveBtn;
	}


	public void createNewContact(WebDriver driver,String LASTNAME, String OrgName)
	{
		LastNameEdt.sendKeys(LASTNAME);
		ContactPageOrganizationNameLookUpImage.click();
		
		switchToWindow(driver, "Accounts");//takes partial title of child window current open
		OrganizationSearchEdt.sendKeys(OrgName);
		OrganizationSearchBtn.click();
		
		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");// takes partial title of main/parents window..switching action"most imp"
		ContactSaveBtn.click();
		
		
	}

}
