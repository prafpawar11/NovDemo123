package Tutorial2;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Demo5 {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000";
		Response resp = RestAssured.given().get("/posts/2");

		// resp.getHeaders();
		Headers allheader = resp.headers();
		// return type of headers() method is Headers interface

//		for (Header abc : allheader) {
//			if (abc.getName().equals("Content-Type")) 
//			{
//				System.out.println("Test case is pass");
//			}
//		}
		
		String a =resp.getContentType();
		System.out.println(a);
		
		String b =resp.contentType();
		System.out.println(b);
	}

}
