package com.DemoAPI2026.models;

public class RegisterRequest {
	//POJO model class used to create the request body for API calls.
	public String name;
    public String email;
    public String password;
    public String role;
  //  private String role = "user";

    public RegisterRequest(String name, String email, String password, String role) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
