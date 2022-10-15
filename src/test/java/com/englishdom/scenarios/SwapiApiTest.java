package com.englishdom.scenarios;

import com.englishdom.helpers.api.SwapiApi;
import org.testng.annotations.Test;

public class SwapiApiTest {

    @Test
    void CompareJsonsDueToSchema() {
        SwapiApi.compareWithJsonSchema();
    }
}
