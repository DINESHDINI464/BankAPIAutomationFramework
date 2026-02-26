package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ForgotPasswordTest {
	@Test(description = "Test the login api is working or not: ")
	public void forgotPasswordTest() {

		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("sndinesh1992@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
