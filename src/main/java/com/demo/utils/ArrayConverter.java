package com.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// convert List to json string object to save/retrieve it in database
public class ArrayConverter implements AttributeConverter<ArrayList<String>,String> {

    @Override
    public String convertToDatabaseColumn(ArrayList<String> strings) {
        String customerInfoJson = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            customerInfoJson = objectMapper.writeValueAsString(strings);
        } catch (final JsonProcessingException e) {
            System.out.println("JSON writing error ---> "+ e);
        }

        return customerInfoJson;
    }

    @Override
    public ArrayList<String> convertToEntityAttribute(String s) {
        ArrayList<String> customerInfo = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            customerInfo = objectMapper.readValue(s, ArrayList.class);
        } catch (final IOException e) {
            System.out.println("JSON writing error ---> "+ e);
        }
        return customerInfo;
    }
}
