package com.DemoAPI2026.Utility;

public class TokenManager {
	
	//Helper class
	public static String accessToken;
	public static String refreshToken;

	public static void setAccessToken(String token) {
        accessToken = token;
    }

    public static String getAccessToken() {
        return accessToken;
    }
    
    public static void setRefreshToken(String token) {
    	refreshToken = token;
    }

    public static String getRefreshToken() {
        return refreshToken;
    }
}
