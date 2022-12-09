package Tutorial5;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class getDemo1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:3000";
		
		Response resp =RestAssured.given().when().get("/posts/2");
		
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
		System.out.println(resp.body().asString());
		
		
		
	}

}
