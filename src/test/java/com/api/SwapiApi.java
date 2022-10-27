package com.api;

import com.helpers.data.config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class SwapiApi {

    public static void validateRepsonseWithJsonSchema(String pathToSchema) {
        String endPoint = Config.getEnvironmentURL("test");
        RestAssured.given()
                .filter(new AllureRestAssured())
                .log().all()
                .get(endPoint)
                .then().statusCode(200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(pathToSchema)));
    }


}

