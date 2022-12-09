package tutorial4;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2 {

	static String baseuri = "http://localhost:3000";
	static String pathvariable = "/posts";
	static RequestSpecification httpRequest;

	public static void main(String[] args) {
		RestAssured.baseURI = baseuri;
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(Demo2.jsonData("amit", "shahir", "tester", "Pune"));
		
		Response resp =httpRequest.post(pathvariable);
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
		System.out.println(resp.body().asString());
		System.out.println(resp.jsonPath().getString("id"));
	}
	
	public static String jsonData(String fname,String lname,String job,String add)
	{
		JSONObject json =new JSONObject();
		json.put("FirstName", fname);
		json.put("LastName", lname);
		json.put("Job", job);
		json.put("Address", add);
		
		return json.toString();
	}

}
