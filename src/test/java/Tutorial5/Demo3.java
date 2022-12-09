package Tutorial5;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
;

public class Demo3 {

	public static String updateSingleEntity(String key,String value)
	{
		JSONObject json = new JSONObject();
		json.put(key, value);
		return json.toString();
	}
	

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://localhost:3000";

		Response resp = RestAssured.given()
				.contentType("application/json")
				.body(updateSingleEntity("Job","Test Leader"))
				.patch("/posts/2");

		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
		System.out.println(resp.body().asString());

	}

}
