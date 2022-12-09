package Tutorial5;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2 {
	RequestSpecification httpRequest;
	Response resp;
	String id;
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI="http://localhost:3000";
		httpRequest =RestAssured.given();
	}
	
	@Test(priority = 1)
	public void createANewUser()
	{
		httpRequest.contentType("application/json");
		String data =UtilsClass.jsonData("Amruta", "patil", "Automation tester", "Pune");
		httpRequest.body(data);
		resp =httpRequest.post("/posts");
		id =resp.jsonPath().getString("id");
		Assert.assertEquals(resp.statusCode(), 201);
		Assert.assertEquals(resp.statusLine().contains("Created"), true);
		System.out.println(resp.body().asString());
		System.out.println("--------------------------------------------------");
	}
	
	@Test(priority = 2)
	public void retriveTheDataAfterPost()
	{
		resp =httpRequest.get("/posts/"+id);
		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(resp.statusLine().contains("OK"), true);
		System.out.println(resp.body().asString());
		System.out.println("------------------------------------------------");
	}
	
	@Test(priority = 3)
	public void updateData()
	{
		httpRequest.contentType("application/json");
		String data =UtilsClass.jsonData("Anjali", "Kale", "Test Engineer", "Mumbai");
		httpRequest.body(data);
		resp =httpRequest.put("/posts/"+id);
		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(resp.statusLine().contains("OK"), true);
		System.out.println(resp.body().asString());
		System.out.println("------------------------------------------------");
	
	}
	
	
	@Test(priority = 4)
	public void retriveTheDataAfterPut()
	{
		resp =httpRequest.get("/posts/"+id);
		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(resp.statusLine().contains("OK"), true);
		System.out.println(resp.body().asString());
		
	}
	
	
	
	
	
	
}
