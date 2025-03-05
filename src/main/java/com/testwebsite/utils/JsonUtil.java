package com.testwebsite.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

    public static String getJsonProperty(String jsonValue) {

            JsonNode jsonFile = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                jsonFile = objectMapper.readTree(new File("src/main/resources/AddUserInfo.json"));
            } catch (IOException e) {
                LoggerUtil.error("Error Reading Json File " + e.getMessage());
            }
        assert jsonFile != null;
        return jsonFile.get(jsonValue).asText();
        }
    }





