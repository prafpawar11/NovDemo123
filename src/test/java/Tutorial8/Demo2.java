package Tutorial8;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo2 {
	private String baseuri="http://localhost:3000";
	private String pathVariable="/posts/21";
	private Response resp;
	
	@BeforeMethod
	public void setUP()
	{
		RestAssured.baseURI=baseuri;
	}
	
	
	@Test(priority = 1)
	public void getRequest()
	{
		resp =given().when().get(pathVariable);
		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}
	
	@Test(priority = 2)
	public void deleteRequest()
	{
		resp =given().when().delete(pathVariable);
		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}
	
	@Test(priority = 3)
	public void getAfterDeleteRequest()
	{
		resp =given().when().get(pathVariable);
		Assert.assertEquals(resp.statusCode(), 404);
		Assert.assertEquals(resp.contentType(), "application/json; charset=utf-8");
	}

}
