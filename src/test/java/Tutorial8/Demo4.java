package Tutorial8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo4 extends CreateUser{

	public static void main(String[] args) throws JsonProcessingException {
		RestAssured.baseURI = "http://localhost:3000/posts/";

		CreateUser abc = new CreateUser();

		abc.setFirstName("Vishal");
		abc.setLastName("Patil");
		abc.setAddress("Pune");
		abc.setJob("Test Engineer");
		
		
		
		ObjectMapper mapper = new ObjectMapper();

		String a = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(abc);

		
		Response resp = RestAssured.given().contentType(ContentType.JSON).body(a).post();

		System.out.println(resp.getBody().asString());

	}

}
