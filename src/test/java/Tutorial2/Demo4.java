package Tutorial2;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Demo4 {

	public static void main(String[] args) {

		
		for(int i=3;i<=20;i++)
		{
			RestAssured.baseURI = "http://localhost:3000/posts";

			RequestSpecification httpRequest = RestAssured.given();

			Response resp = httpRequest.delete("/"+i);
			
			System.out.println(resp.getStatusCode());
			
		}
		
	

	
		
		
		
	}

}
