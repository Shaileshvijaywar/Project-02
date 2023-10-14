package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;


/**
 * this method will read data from property file
 */
public class PropertyFileUtility {
	public String propertyFile(String key) throws EncryptedDocumentException, IOException
	{
		FileInputStream  fis=new FileInputStream(CommonFilePath.propertiesFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj.getProperty(key);
	}

}
