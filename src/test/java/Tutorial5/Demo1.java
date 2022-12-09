package Tutorial5;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class Demo1 {
	

	public static String testData(String fname,String lname,String job,String add)
	{
		JSONObject json =new JSONObject();
		json.put("FirstName", fname);
		json.put("LastName", lname);
		json.put("Job", job);
		json.put("Address", add);

		return json.toString();
		
	}
	
	

	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://localhost:3000";
		Response resp =RestAssured.given()
				.contentType("application/json")
				.body(Demo1.testData("Sachin", "patil", "sr test engineer", "Pune"))
				.put("/posts/2");
		
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
		System.out.println(resp.body().asString());
		
		Headers allheaders =resp.headers();
		
		for(Header abc:allheaders)
		{
			System.out.println(abc.getName()+"::"+abc.getValue());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
			
		
		

		
		
		
	}

}
