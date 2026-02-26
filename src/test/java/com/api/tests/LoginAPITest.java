package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	@Test(description = "Test the login api is working or not: ")
	public void loginTest() {

		RequestSpecification request = given().baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
				.body("{\"username\": \"Dinesh464\", \"password\": \"103R1a0464.\"}");
		Response response = request.post("api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
