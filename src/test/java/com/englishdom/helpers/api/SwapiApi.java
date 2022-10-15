package com.englishdom.helpers.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SwapiApi {

    public static void compareWithJsonSchema() {
        String endPoint = "https://swapi.dev/api/starships/9/";
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .get(endPoint)
                .then().statusCode(200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/com/englishdom/helpers/data/ResponseExampleJson.json")));
    }


}

