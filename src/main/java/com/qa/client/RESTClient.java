package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.qa.base.TestBase;

public class RESTClient{

	// Let's make the GET Method which accepts url as a parameter
	
	public void GET(String url) throws ClientProtocolException, IOException {
		
		 // STEP 1: Create the get request to the URL.
		 // Now create the get request with the url.
		 // If we were working in POSTMAN, our first step would have been to select GET from the dropdown.
		 HttpGet httpget = new HttpGet(url);
		 
		// STEP 2 : Create the connection to the client
		//Creates the client connection by HttpClients interface which has a createDefault method.
		// In a very very formal way to remember, secondly, we enter the URL in the textbox if we were working in POSTMAN.
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 
		
		 
		 //STEP 3: execute the httpget request we created.
		 // formal way: That is just like pressing the send button in POSTMAN. So the below line will return the result.
		 
		 CloseableHttpResponse httpresponse = httpclient.execute(httpget);
		 
		 //STEP 4: GET the status code as we have the result stored in the above interface.
		 // formal way: as we have the result now, we can play with it. Firstly, let's find out if request is successful or not
		 // So get the status code.
		 System.out.println("Status code: " + httpresponse.getStatusLine().getStatusCode());
		 
		 //STEP 5: Get the entity now.
		 // formal way, It will not return the simple readable string. It will rather return the entity (header + body)
		 
		 HttpEntity entity = httpresponse.getEntity();
		 
		 // STEP 6: Now is the time to segregate the body and header.
		 // Formal way: to convert the body into string, Let us use the toString() method from EntituUtil class. (Remember it's the entity which was returned)
		 
		String responseString = EntityUtils.toString(entity);
		 
		System.out.println(responseString);
		
		// STEP 7: Now let us convert the responseString into JSON format.
		JSONObject jsonobject = new JSONObject(responseString);
		
		System.out.println(jsonobject);
		
		// STEP 8: Now let us get the headers response. Headers come in the key and value pair.
		Header[] headersArray = httpresponse.getAllHeaders();
		
		// STEP 9: Create the hashmap of <String, String> as the headers come in a form of key and value. And it is easy to iterate the hashmap.
		/*
		for(Header i : headersArray) {
			System.out.println(i);
		}
		*/
		
	//	HashMap<String, String> headersHashmap = new HashMap<String, String>();
		
		// STEP 10: Let's fill the HashMap with the headersArray elements.
		
		for(Header i : headersArray) {
		//	headersHashmap.put(i.getName(), i.getValue());
			System.out.println(i);
		}
		
		// Print the headersHashmap
	//	System.out.println(headersHashmap);
	}
	
	
	
	
}
