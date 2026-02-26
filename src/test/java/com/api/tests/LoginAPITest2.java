package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest2 {
	@Test(description = "Test the login api is working or not: ")
	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest("Dinesh464", "103R1a0464.");
		AuthService authService = new AuthService(); // created object of Authentication service
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class); // this gives LoginResponse class object to
																		// as -->de-serialaize the JSON into individual values
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getEmail());
		
		Assert.assertTrue(loginResponse.getToken()!= null);
		Assert.assertEquals(loginResponse.getId(), 4496);
		Assert.assertEquals(loginResponse.getEmail(), "sndinesh1992@gmail.com");

	}

}
