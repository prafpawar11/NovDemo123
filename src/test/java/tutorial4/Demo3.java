package tutorial4;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3 {
	Properties prop;
	RequestSpecification httpRequest;
	Response resp;
	String id;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = prop.getProperty("baseuri");
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(UtilsClass.jsonData(prop.getProperty("fname"), prop.getProperty("lname"),
				prop.getProperty("job"), prop.getProperty("add")));
		resp = httpRequest.post(prop.getProperty("pathVariable"));

	
	}

	@Test(priority = 1)
	public void validateStatusCode() {
		Assert.assertEquals(resp.getStatusCode(), 201);
	}

	@Test(priority = 2)
	public void validateStatusline() {
		Assert.assertEquals(resp.statusLine().contains("Created"), true);
	}

	@Test(priority = 3)
	public void captureResponseId() {
		id = resp.jsonPath().getString("id");
	}

	@Test(priority = 4)
	public void validatefirstName() {
		String fname = prop.getProperty("fname");
		String Firstname = resp.jsonPath().getString("FirstName");
		Assert.assertEquals(fname, Firstname);
	}

	@Test(priority = 5)
	public void validateLastName() {
		Assert.assertEquals(prop.getProperty("lname"), resp.jsonPath().getString("LastName"));
	}

	@Test(priority = 6)
	public void validateJob() {
		Assert.assertEquals(prop.getProperty("job"), resp.jsonPath().getString("Job"));
	}

	@Test(priority = 7)
	public void validateAddress() {
		Assert.assertEquals(prop.getProperty("add"), resp.jsonPath().getString("Address"));
	}

	@Test(priority = 8)
	public void validateContentTypeResponseHeader() {
		Assert.assertEquals(resp.header("Content-Type"), "application/json; charset=utf-8");
	}

	public Demo3() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\praf0\\Desktop\\June Batch Script\\RestAssuredTutorial\\src\\test\\java\\tutorial4\\config.properties");
		prop.load(fis);
	}

}
