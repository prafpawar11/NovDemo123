package Tutorial8;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Demo1 {

	static Response resp;

	public static void main(String[] args) {
		

		RestAssured.baseURI = "http://localhost:3000/posts/";

		for (int i = 2; i <= 9; i++) {
			String a = Integer.toString(i);

			resp = given().when().delete(a);

			System.out.println(resp.statusCode());
		}

	}

}
