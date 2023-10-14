package com.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.ObjectRepository.ContactPage;
import com.ObjectRepository.CreateContactPage;
import com.ObjectRepository.CreateOrganizationPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationInfoPage;
import com.ObjectRepository.OrganizationPage;

public class ReadMultipleDataProviderTest extends BaseClass {
	
	@Test(dataProvider="getData")
	public void readmultipledata(String ORGNAME, String INDUSTRYTYPE) throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnHomePageOrgLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationLookUPImage();
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrganizationPage(ORGNAME, INDUSTRYTYPE);
		
		OrganizationInfoPage cip=new OrganizationInfoPage(driver);
		String OrgHeader = cip.getOrgInfoPageHeader();
		Assert.assertTrue(OrgHeader.contains(OrgHeader));
		Reporter.log(INDUSTRYTYPE);	
		hp.clickOnHomePageContactLink();
		
		ContactPage cp=new ContactPage(driver);
		cp.clickOnContactLookupImage();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(driver, OrgHeader, ORGNAME);
		
		
	}
    @DataProvider
    public Object[][]getData() throws EncryptedDocumentException, IOException
    {
	Object[][] data = eutil.readMultipleDataFromExcel("Multiple");
	return data;
	}
    
  }
