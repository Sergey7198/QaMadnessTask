package com.helpers.data.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Objects;

public class Config {

    public static final String DATA_CONF_JSON = "src/main/resources/conf/data.conf.json";

    private static Environment environment;

    @SneakyThrows
    private static com.helpers.data.config.Environment getConfigData() {
        if (Objects.isNull(environment)) {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(DATA_CONF_JSON);
            environment = objectMapper.readValue(file, Environment.class);
        }
//        System.out.println(environment.toString());
        return environment;
    }

    private static EnvironmentData getEnvironmentData(String environmentName) {
        return getConfigData().getEnvironment().get(environmentName);
    }


    public static String getEnvironmentURL(String environment) {
        return getEnvironmentData(environment).getUrl();
    }

    public static String getApiURL(String environment) {
        return getEnvironmentData(environment).getApiUrl();
    }

}