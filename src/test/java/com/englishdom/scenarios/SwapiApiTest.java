package com.englishdom.scenarios;

import com.api.SwapiApi;
import org.testng.annotations.Test;

public class SwapiApiTest {

    private final String pathToJSonSchema1 = "src/main/java/com/helpers/data/responsejson/ResponseExampleJson.json";

    @Test(groups = {"ApiTests"})
    void CompareJsonsDueToSchema() {
        SwapiApi.validateRepsonseWithJsonSchema(pathToJSonSchema1);
    }
}
