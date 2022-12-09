package Tutorial2;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1 {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000/posts/";

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(jsondata("abc","xyz","test","Pune").toString());
		

		Response resp = httpRequest.post();

		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.body().asString());
		System.out.println(resp.contentType());

	}

	static JSONObject jsondata(String fname, String lname, String job, String add) {
		JSONObject json = new JSONObject();
		json.put("FirstName", fname);
		json.put("LastName", lname);
		json.put("Job", job);
		json.put("Address", add);

		return json;
	}
}
