package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration 
	@FindBy(name="user_name")
	private WebElement UN;
	
	@FindBy(name="user_password")
	private WebElement PW;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	//initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getUN() {
		return UN;
	}

	public WebElement getPW() {
		return PW;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Library
	
	public void clickOnLoginPage(String USERNAME, String PASSWORD)
	{
		UN.sendKeys(USERNAME);
		PW.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
	

}
