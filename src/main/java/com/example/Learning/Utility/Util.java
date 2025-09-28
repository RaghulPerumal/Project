package com.example.Learning.Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;

public class Util {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public String writeValueAsString(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }

    public HashMap<String, Object> converttoMap(Object o) {
        return objectMapper.convertValue(o, HashMap.class);
    }
}
