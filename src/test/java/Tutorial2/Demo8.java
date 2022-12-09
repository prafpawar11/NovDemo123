package Tutorial2;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Demo8 {
	private String baseurl = "http://localhost:3000";
	private String pathVariable = "/posts/2";
	private Response resp;

	public Response set() {
		RestAssured.baseURI = baseurl;
		return RestAssured.given().get(pathVariable);
	}

	@BeforeClass
	public void setup() {
		resp =set();
	}

	@Test(priority = 1)
	public void verifyStatusCode() {
//		int a =resp.getStatusCode();
//		Assert.assertEquals(a, 200);

		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void validateStatusLine() {
		Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200 OK");
	}

	@Test(priority = 3)
	public void validateFirstNameInResponseBody() {
		String fname = resp.jsonPath().getString("FirstName");

		boolean a = resp.getBody().asString().contains(fname);
		Assert.assertTrue(a);
	}

	@Test(priority = 4)
	public void validateLastNameInResponseBody() {
		Assert.assertEquals(resp.getBody().asString().contains(resp.jsonPath().getString("LastName")), true);
	}

	@Test(priority = 5)
	public void validateJobInResponseBody() {
		Assert.assertTrue(resp.getBody().asString().contains(resp.jsonPath().getString("Job")));
	}

	@Test(priority = 6)
	public void validateAddressinResponseBody() {
		String add = resp.jsonPath().getString("Address");
		String respbody = resp.getBody().asString();
		Assert.assertEquals(respbody.contains(add), true);

	}

	@Test(priority = 7)
	public void validateContentTypeHeader() {
		Headers allheaders = resp.headers();

		for (Header abc : allheaders) {
			if (abc.equals("Content-Type")) {
				System.out.println("test case is pas");
			}

		}

	}

}
