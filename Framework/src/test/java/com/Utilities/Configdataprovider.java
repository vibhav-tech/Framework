package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

public class Configdataprovider 
{
	Properties pro;
	public Configdataprovider()
	{
		File src=new File("./Config/Config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		pro =new Properties();
        pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file >> "+e.getMessage());
		}
	}
	
	public String getbrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String gettestURL()
	{
		return pro.getProperty("testURL");
	}

}
