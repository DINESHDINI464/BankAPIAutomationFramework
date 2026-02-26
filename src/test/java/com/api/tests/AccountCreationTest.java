package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	
	@Test(description = "Test the Account signup is working or not: ")
	public void createAccountTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().firstName("Dinesh").email("abc@gmail.com")
				.lastName("s").mobileNumber("8588756687").password("password123").build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		
		//Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}

}
