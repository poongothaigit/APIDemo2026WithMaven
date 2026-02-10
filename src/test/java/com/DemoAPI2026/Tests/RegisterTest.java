package com.DemoAPI2026.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DemoAPI2026.Client.AuthClient;
import com.DemoAPI2026.Utility.TokenManager;
import com.DemoAPI2026.base.BaseTest;
import com.DemoAPI2026.models.LoginRequest;
import com.DemoAPI2026.models.RegisterRequest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})

public class RegisterTest extends BaseTest{

	 @Test(priority = 1)

	    public void registerUserTest() {

	        AuthClient client = new AuthClient();
	        RegisterRequest payload =
	                new RegisterRequest("Daisy", "daisy20259@test.com", "654321", "admin");

	        Response response = client.register(payload);

	        System.out.println(response.asString());
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }
	 
	 @Test(dependsOnMethods = "registerUserTest")

	    public void loginTest() {

	        AuthClient client = new AuthClient();
	        LoginRequest payload =
	                new LoginRequest("daisy20259@test.com", "654321");

	        Response response = client.login(payload);

	        JsonPath json = response.jsonPath();

	        TokenManager.accessToken = json.getString("accessToken");
	        TokenManager.refreshToken = json.getString("refreshToken");
	        System.out.println("Access Token: " + TokenManager.accessToken);

	        Assert.assertNotNull(TokenManager.accessToken);
	    }
	 
}
