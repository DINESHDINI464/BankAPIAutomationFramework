package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileUpdateRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "validating PUT user profile API")
	public void updateProfileTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Dinesh464", "103R1a0464."));
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println("token printed: " + loginresponse.getToken());
		System.out.println("----------------------------------------------");

		UserProfileManagementService userProfileManage = new UserProfileManagementService();
		response = userProfileManage.getProfile(loginresponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse profileResponse = response.as(UserProfileResponse.class); // De-serializing the o/p
		Assert.assertEquals(profileResponse.getUsername(), "Dinesh464");
		System.out.println("-----------------------------------------------------");
		ProfileUpdateRequest profileRequest = new ProfileUpdateRequest.Builder().firstName("teja")
				.mobileNumber("1234567891").build();
		response = userProfileManage.updateProfile(loginresponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
	}

}
