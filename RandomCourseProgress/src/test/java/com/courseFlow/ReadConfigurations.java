package com.courseFlow;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigurations
{

	Properties pro;
	//Constructor for initializing all data when creating objects without calling method
	public ReadConfigurations() 
		{
		File src=new File("./TestData/Config.properties");
		try {
		FileInputStream input=new FileInputStream(src);
		pro=new Properties();
		pro.load(input);
		} 
		catch (Exception e) {e.printStackTrace();}
		}
	
	    //Chrome Key
		public String getChromeKey() 
		{
			String chromeKey=pro.getProperty("ChromeKey");
			return chromeKey;
		}
		
		//Chrome Value
		public String getChromeValue() 
		{
			String chromeValue=pro.getProperty("ChromeValue");
			return chromeValue;
		}
		
		//Author user name 1
		public String getAuthor1UserName() 
		{
			String userName=pro.getProperty("authorUN");
			return userName;
		}
		
		//Author password
		public String getAuthorPassWord() 
		{
			String password=pro.getProperty("authorPWD");
			return password;
		}
		
		//Author QA4 login url
		public String getAuthorQa4LoginUrl() 
		{
			String loginUrl=pro.getProperty("authorQa4LoginURL");
			return loginUrl;
		}
}
