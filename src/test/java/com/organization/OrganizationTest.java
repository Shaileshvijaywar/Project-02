package com.organization;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

import com.ObjectRepository.CreateOrganizationPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationInfoPage;
import com.ObjectRepository.OrganizationPage;

@Listeners(com.GenericUtility.Listeners.class)
public class OrganizationTest extends BaseClass{
	
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void OrganizationPage1() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String Eread=eutil.excelRead("Organization", 4, 2)+jutil.randomnum();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnHomePageOrgLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationLookUPImage();
		//Assert.fail();
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrganizationPage(Eread);
		
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgInfoHead = oip.getOrgInfoPageHeader();
		Assert.assertTrue(OrgInfoHead.contains(OrgInfoHead));
		//System.out.println(OrgInfoHead);
		Reporter.log(Eread);
	}

}
