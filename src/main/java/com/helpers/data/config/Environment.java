package com.helpers.data.config;

import lombok.Data;

import java.util.Map;

@Data
public class Environment {
    private Map<String, EnvironmentData> environment;
}
