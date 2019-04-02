package com.smojum.redirectpostservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// TODO: 4/2/2019 check whether spring boot has created an out of the box map implemation yet. 
@Component
@ConfigurationProperties("app-post-data")
public class PostDataMappingProperties {
    private final Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }
}
