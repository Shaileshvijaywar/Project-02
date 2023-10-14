package com.GenericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public  ExcelUtility eutil=new ExcelUtility();
	public JavaUtility jutil=new JavaUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver sDriver;//use for listener class
	public WebDriver driver;
	
	
	//Before suite- This method will established the connection with database
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void  bsconfiguration()
	{
		System.out.println("DataBase Connection Sucessfully");
	}
	
	//Before Class- This Method will open the browser 
	//@Parameters("browser")//cross browser only
	//@BeforeTest() //cross browser 
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void bcconfiguration(/*String BROWSER*/) throws EncryptedDocumentException, IOException
	{
		String BROWSER = putil.propertyFile("browser");
		String URL = putil.propertyFile("url");
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else 
		{
			System.out.println("Browser Empty");
		}
		
		sDriver=driver;
		wutil.maximizeWindow(driver);
		wutil.implicitlyWait(driver);
		driver.get(URL);
		
	  }
	
	
	//Before Method- this method will perform login operation
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmconfiguration() throws EncryptedDocumentException, IOException
	{
		String USERNAME = putil.propertyFile("username");
		String PASSWORD = putil.propertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.clickOnLoginPage(USERNAME, PASSWORD);
		System.out.println("Login the Page sucessfully");
	}
	
	
	//After Method- this method will perform logout operation
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amconfiguration()
	{
		HomePage hp=new HomePage(driver);
		hp.clickonSignOut(driver);
		System.out.println("Signout the Page sucessfully");
	}
	
	
	//After Class- This method will close the browser
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acconfiguration()
	{
		driver.quit();
		System.out.println("close the browser sucessfully");
	}
	
	;
	//After Suite- This method will disconnect from database
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asconfiguration()
	{
		System.out.println("disconnect from database sucessfully");
	}
	
	

}
