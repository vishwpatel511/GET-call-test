package com.qa.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RESTClient;

public class GET_Test{
	
	String finalURL;
		
	
	//RESTClient restclient;
//	RESTClient restclient;
	
//	TestBase testbase = new TestBase();
	 //String finalURL;
	
	  @BeforeMethod 
	  public void beforeMethod() throws ClientProtocolException,IOException {
			Properties prop;
		  prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\vishw\\Desktop\\Study Material\\APITesting_GETcall\\src\\main\\java\\com\\qa\\config\\prop.properties");
			prop.load(ip);
			 finalURL = prop.getProperty("URL") + prop.getProperty("service");
		 // 	testbase = new TestBase();
		//	finalURL = prop.getProperty("URL") + prop.getProperty("service"); 
	  
	  }
	 
  @Test
  public void getTest() throws ClientProtocolException, IOException {		
	  RESTClient restclient = new RESTClient();
	  restclient.GET(finalURL);
	  
  }
  

	/*
	 * @AfterMethod public void afterMethod() {
	 * 
	 * }
	 */

}
