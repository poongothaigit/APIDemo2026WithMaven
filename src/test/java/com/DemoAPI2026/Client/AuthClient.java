package com.DemoAPI2026.Client;

import static io.restassured.RestAssured.given;
import com.DemoAPI2026.models.LoginRequest;
import com.DemoAPI2026.models.RefreshRequest;
import com.DemoAPI2026.models.RegisterRequest;

import io.restassured.response.Response;

public class AuthClient {

	public Response register(RegisterRequest payload) {

        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/register");
    }

	public Response login(LoginRequest payload) {

        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/login");
    }
	
	public Response profile(String accessToken) {

        return given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/profile");
    }
	
	public Response refresh(RefreshRequest payload) {

        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/refresh");
    }
	
	public Response logout(String accessToken) {

        return given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/logout");
    }
}
