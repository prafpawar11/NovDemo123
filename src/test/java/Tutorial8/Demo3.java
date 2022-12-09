package Tutorial8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3 {
	static Response resp;

	public static void main(String[] args) throws JsonProcessingException {

		RestAssured.baseURI = "http://localhost:3000/posts/";

		CreateUser abc=new CreateUser();
		
		abc.setFirstName("Sachin");
		abc.setLastName("Patil");
		abc.setAddress("Pune");
		abc.setJob("Test Engineer");
		
		ObjectMapper mapper =new ObjectMapper();
		
		String json =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(abc);
		
		RequestSpecification httpRequest=RestAssured.given();
		
		httpRequest.contentType(ContentType.JSON);
		httpRequest.body(json);
		Response resp =httpRequest.post();

		System.out.println(resp.getBody().asString());
		
		


		
	}

}
