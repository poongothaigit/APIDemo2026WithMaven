package com.DemoAPI2026.base;

import org.testng.annotations.BeforeClass;
import com.DemoAPI2026.Utility.ConfigReader;
import io.restassured.RestAssured;
import io.qameta.allure.restassured.AllureRestAssured;


public class BaseTest {

	@BeforeClass
    public void setup() {

        RestAssured.baseURI =
                ConfigReader.getProperty("baseUrl");

        System.out.println("Base URI is: " + RestAssured.baseURI);
     // Attach API logs to Allure report
        RestAssured.filters(new AllureRestAssured());
    }
}
