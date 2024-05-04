package br.com.alura.FipeTable.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data implements ConvertData{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> tClass) {
        try {
            return objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
