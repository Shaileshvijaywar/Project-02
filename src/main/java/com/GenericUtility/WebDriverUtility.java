package com.GenericUtility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
    /**
     * This method will minimize the window
     * @param driver
     */
	public void minimizeWindow(WebDriver driver)
	{
	   driver.manage().window().minimize();	
	}
	
	/**
	 * This method will work implicitly wait
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * this method will perform explicitly wait
	 * @param driver
	 * @param element
	 */
	public void explicitlyWait(WebDriver driver, WebElement element)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will use to select drop down by index
	 * @param element
	 * @param Index
	 */
	public void dropDownByIndex(WebElement element, int Index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(Index);
	}
	/**
	 * This method will perform drop down by visible  text
	 * @param element
	 * @param Text
	 */
	public void dropDownbyText(WebElement element, String Text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(Text);
		
	}
	/**
	 * this method will perform drop down by value
	 * @param element
	 * @param value
	 */
	public void dropDownByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * this method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
   public void mouseHover(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
   }
   
   /**
    * this method will perform double click on anywhere in webpage
    * @param driver
    */
   public void doubleClickOnWebPage(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.doubleClick().perform();
   }
   /**
    * this method will perform double click on specified web element
    * @param driver
    * @param element
    */
   public void doubleClickWebElement(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.doubleClick(element).perform();
   }
   /**
    * this method will perform right click on anywhere on webpage
    * @param driver
    */
   public void rightClickOnWebPage(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.contextClick().perform();
   }
   
   /**
    * this method will perform right click on specified webelement
    * @param driver
    * @param element
    */
   public void rightClickOnWebElement(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.contextClick(element).perform();
   }
   /**
    * This  method will take screenshot
    * @param driver
    * @param ScreenshotName
    * @return
    * @throws IOException
    */
   public String screenShot(WebDriver driver, String ScreenshotName) throws IOException
   {
	   TakesScreenshot sc=(TakesScreenshot) driver;
	   File src = sc.getScreenshotAs(OutputType.FILE);
	   File dst = new File(".\\screenshot\\"+ScreenshotName+".png");
	   Files.copy(src, dst);
	   return dst.getAbsolutePath();   
   }
   /**
    * this will perform window switch
    * @param driver
    * @param PartialTitle
    */
   public void switchToWindow(WebDriver driver,String PartialTitle)
    {
	 Set<String> Allwin = driver.getWindowHandles();
	 for(String cwin :Allwin)
	    {
		String actTitle = driver.switchTo().window(cwin).getTitle();
		if(actTitle.contains(PartialTitle))
		{
			break;
		}
	   }
   }
   }