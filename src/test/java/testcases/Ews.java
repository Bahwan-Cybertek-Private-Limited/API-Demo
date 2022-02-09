package testcases;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Ews extends BaseTest{
	
	
public String id;
	
	public String OAuthToken=null;
	public String wsrToken=null;
	
	
	public String getWSRToken() 
	{		
		try
		{
			test.log(LogStatus.INFO, "My test is starting.....");	
			
			//RestAssured.baseURI = "http://192.168.1.77:8280";
			  
			RequestSpecification request = RestAssured.given();
			  
			request.header("Content-Type","application/x-www-form-urlencoded");
			request.header("Accept-Encoding", "gzip, deflate, br");
			request.header("Accept-Language","en-US,en;q=0.9");
			request.header("Connection","keep-alive");
			request.header("Authorization","Basic czVPYXkzUXNJbWdMSE5scGxhenl6Q2hTRWVzYTpxVWY1U3JPYXdpV1VKV1VycExJa0RreTFQck1h");
					
			Response response = request.post("/token?grant_type=client_credentials");
			//System.out.println(response.getBody().asString());
					  
			JSONObject json = new JSONObject(response.getBody().asString());
			System.out.println(json.get("access_token"));
			
			if(response.getStatusCode() == 200)
			{			
				test.log(LogStatus.PASS,"Response Code is : "+response.getStatusCode());
				test.log(LogStatus.PASS,"WSR TOken Response Time : "+response.getTime());
				test.log(LogStatus.INFO,"Full Response : "+response.getBody().asString());
			}
			
			test.log(LogStatus.INFO, "Successfully received WSR Token");	
			wsrToken = json.get("access_token").toString();
					
			test.log(LogStatus.INFO, "WSR test has been ended.....");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Exception occured"+ex);
		}
		
		return wsrToken;	
	
	}
	
	
	public String getOAuthToken()
	{
		String Tokens = null;
		String wsr = null;
		try
		{
			
			wsr = getWSRToken();		
			
			test.log(LogStatus.INFO, "My test is starting.....");	
			
			//RestAssured.baseURI = "http://192.168.1.77:8280";
			  
			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type","application/x-www-form-urlencoded");
			request.header("Accept-Encoding", "gzip, deflate, br");
			request.header("Connection","keep-alive");
			request.header("Authorization","Bearer "+ wsr);			
			request.header("Authorization","Basic YmN0YmZzaTpiY3RiZnNpQDEyMw==");
			
			request.queryParams("grant_type","password","username","Admin","password","$2a$10$g6S5Ljco1ULYlrjW3oW9R.o9AzthM2ctiU0rGLpjML924lQQ/VXA2");
		
			Response response = request.post("/ews/server_uat/1/oauth/token");
			System.out.println(response.getBody().asString());	
				  
			APIVerification api = new APIVerification();
			api.responseCodeValiddation(response,200);
			
			if(response.getStatusCode() == 200)
			{			
				test.log(LogStatus.PASS,"Response Code is : "+response.getStatusCode());
				test.log(LogStatus.PASS,"OAUTH Token API Response Time : "+response.getTime());
				test.log(LogStatus.INFO,"Full Response : "+response.getBody().asString());
			}
			
			test.log(LogStatus.INFO, "Successfully received OAUTH Token");	
			
			JSONObject json = new JSONObject(response.getBody().asString());
			System.out.println(json.get("access_token"));
			OAuthToken = json.get("access_token").toString();
			
			test.log(LogStatus.INFO, "OAUTH test has been ended.....");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Exception occured"+ex);
		}	
		
		//Returning WSR and OAUth TOkents.....
		return wsr+","+OAuthToken;
		
	}
		
	@Test(priority=1)
	public void getAlertDetails()
	{

		try
		{			
			String Tokens = getOAuthToken();
			String arr[] = Tokens.split(",");
			String WSR = arr[0];
			String OAuth = arr[1];
			
			test.log(LogStatus.INFO, "My test is starting.....");	
			
			//RestAssured.baseURI = "http://192.168.1.77:8280";
			  
			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type","application/x-www-form-urlencoded");
			request.header("Accept-Encoding", "gzip, deflate, br");
			request.header("Connection","keep-alive");
			request.header("Authorization","Bearer "+WSR);
			request.header("Authorization","Bearer "+OAuth );
						
			//Response response = request.get("/EWS/Workflow_uat/1.0/alertDetails/");
			//above endpoint with /..actual one
			
			Response response = request.get("/EWS/Workflow_uat/1.0/alertDetails");
			System.out.println(response.getBody().asString());	
			
			if(response.getStatusCode() == 200)
			{			
				test.log(LogStatus.PASS,"Response Code is : "+response.getStatusCode());
				test.log(LogStatus.PASS,"AlertDetails API Response Time : "+response.getTime());
				test.log(LogStatus.INFO,"Full Response : "+response.getBody().prettyPrint());
			}
			else
			{
				test.log(LogStatus.PASS,"Response Code is Not Expected: "+response.getStatusCode());
				test.log(LogStatus.FAIL,"Full Response : "+response.getBody().prettyPrint());
			}
			
			
			//JSONObject json = new JSONObject(response.getBody().asString());
			//System.out.println(json.get("access_token"));
			//OAuthToken = json.get("access_token").toString();
			
			test.log(LogStatus.INFO, "My test has been ended.....");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Exception occured"+ex);
		}	
	}
	
	
	
	
	@Test(priority=2)
	public void getGroupDetails()
	{
		
		try
		{
			
			String Tokens = getOAuthToken();
			String arr[] = Tokens.split(",");
			String WSR = arr[0];
			String OAuth = arr[1];
			
			test.log(LogStatus.INFO, "My test is starting.....");	
			
			//RestAssured.baseURI = "http://192.168.1.77:8280";
			  
			RequestSpecification request = RestAssured.given();
								
			request.header("Content-Type","application/x-www-form-urlencoded");
			request.header("Accept-Encoding", "gzip, deflate, br");
			request.header("Connection","keep-alive");
			request.header("Authorization","Bearer "+WSR);
			request.header("Authorization","Bearer "+OAuth );
						
			Response response = request.get("/usermgmt_uat/1/groups/group");
			System.out.println(response.getBody().asString());	
			System.out.println("Group details ........"+response.getBody().prettyPrint());
			
			if(response.getStatusCode() == 200)
			{			
				test.log(LogStatus.PASS,"Response Code is : "+response.getStatusCode());
				test.log(LogStatus.PASS,"Group API Response Time : "+response.getTime());
				test.log(LogStatus.INFO,"Group API Full Response : "+response.getBody().prettyPrint());
			}
			else
			{
				test.log(LogStatus.PASS,"Response Code is Not Expected: "+response.getStatusCode());
				test.log(LogStatus.FAIL,"Group API Full Response : "+response.getBody().prettyPrint());
			}
			
			
			//System.out.println(response.getBody().prettyPrint());	
			//JSONObject json = new JSONObject(response.getBody().asString());
			//System.out.println(json.get("access_token"));
			//OAuthToken = json.get("access_token").toString();
			
			test.log(LogStatus.INFO, "My test has been ended.....");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Exception occured"+ex);
		}	
	}
	
	

	@Test(priority=3)
	public void getAlertConfiguration_Details()
	{		
		
		try
		{
			
			String Tokens = getOAuthToken();
			String arr[] = Tokens.split(",");
			String WSR = arr[0];
			String OAuth = arr[1];
			
			test.log(LogStatus.INFO, "My test is starting.....");	
			
			//RestAssured.baseURI = "http://192.168.1.77:8280";
			  
			RequestSpecification request = RestAssured.given();
			
			request.header("Content-Type","application/x-www-form-urlencoded");
			request.header("Accept-Encoding", "gzip, deflate, br");
			//request.header("Accept-Language","en-US,en;q=0.9");
			request.header("Connection","keep-alive");
			request.header("Authorization","Bearer "+WSR);
			request.header("Authorization","Bearer "+OAuth );
			//request.header("Authorization","Basic YmN0YmZzaTpiY3RiZnNpQDEyMw==");
			
			//request.queryParams("grant_type","password","username","Admin","password","$2a$10$g6S5Ljco1ULYlrjW3oW9R.o9AzthM2ctiU0rGLpjML924lQQ/VXA2");
		//	request.body(params.toString());
			Response response = request.get("/EWSR/AlertLibrary_uat/1.0/alertParams");
			System.out.println(response.getBody().asString());	
				  
			if(response.getStatusCode() == 200)
			{			
				test.log(LogStatus.PASS,"Response Code is : "+response.getStatusCode());
				test.log(LogStatus.PASS,"Alert Configuration API Response Time : "+response.getTime());
				test.log(LogStatus.INFO,"Alert Configuration API Full Response : "+response.getBody().prettyPrint());
			}
			else
			{
				test.log(LogStatus.PASS,"Response Code is Not Expected: "+response.getStatusCode());
				test.log(LogStatus.FAIL,"Alert Configuration API Full Response : "+response.getBody().prettyPrint());
			}
			
			
			//JSONObject json = new JSONObject(response.getBody().asString());
			//System.out.println(json.get("access_token"));
			//OAuthToken = json.get("access_token").toString();
			
			test.log(LogStatus.INFO, "My test has been ended....."," response is "+response.getBody().asString());
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Exception occured"+ex);
		}	
	}
	
	
	@Test(priority=4)
	public void getAlertStatus()
	{		
		
		try
		{
			
			String Tokens = getOAuthToken();
			String arr[] = Tokens.split(",");
			String WSR = arr[0];
			String OAuth = arr[1];
			
			test.log(LogStatus.INFO, "My test is starting.....");	
			
			//RestAssured.baseURI = "http://192.168.1.77:8280";
			  
			RequestSpecification request = RestAssured.given();
			
			/*
			 * JSONObject params = new JSONObject(); params.put("grant_type","password");
			 * params.put("username", "msd20"); params.put("password",
			 * "$2a$10$g6S5Ljco1ULYlrjW3oW9R.o9AzthM2ctiU0rGLpjML924lQQ/VXA2");
			 */
			
			request.header("Content-Type","application/x-www-form-urlencoded");
			request.header("Accept-Encoding", "gzip, deflate, br");
			//request.header("Accept-Language","en-US,en;q=0.9");
			request.header("Connection","keep-alive");
			request.header("Authorization","Bearer "+WSR);
			request.header("Authorization","Bearer "+OAuth );
			//request.header("Authorization","Basic YmN0YmZzaTpiY3RiZnNpQDEyMw==");
			
			//request.queryParams("grant_type","password","username","Admin","password","$2a$10$g6S5Ljco1ULYlrjW3oW9R.o9AzthM2ctiU0rGLpjML924lQQ/VXA2");
		//	request.body(params.toString());
			Response response = request.get("/dashboard_uat/1/chart/top/10/alertStatus");
			System.out.println(response.getBody().asString());	
				  
			if(response.getStatusCode() == 200)
			{			
				test.log(LogStatus.PASS,"Response Code is : "+response.getStatusCode());
				test.log(LogStatus.PASS,"Alert Status API Response Time : "+response.getTime());
				test.log(LogStatus.INFO,"Alert Status Full Response : "+response.getBody().prettyPrint());
			}
			else
			{
				test.log(LogStatus.PASS,"Response Code is Not Expected: "+response.getStatusCode());
				test.log(LogStatus.FAIL,"Alert Status Full Response : "+response.getBody().prettyPrint());
			}
			
			
			//JSONObject json = new JSONObject(response.getBody().asString());
			//System.out.println(json.get("access_token"));
			//OAuthToken = json.get("access_token").toString();
			
			test.log(LogStatus.INFO, "My test has been ended....."," response is "+response.getBody().asString());
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Exception occured"+ex);
		}	
	}

	


}
