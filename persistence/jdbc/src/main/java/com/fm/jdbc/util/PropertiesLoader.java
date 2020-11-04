package com.fm.jdbc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class PropertiesLoader {

    public String url;
    public String username;
    public String password;

    public ApplicationProperties loadProperties() {
        // TODO: use jackson to load properties from yml
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ApplicationProperties applicationProperties = null;
        try {
            applicationProperties = mapper.readValue(new File("persistence/jdbc/src/main/resources/application.yml"),
                    ApplicationProperties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = applicationProperties.getUrl();
        username = applicationProperties.getUsername();
        password = applicationProperties.getPassword();
        return null;
    }
}
