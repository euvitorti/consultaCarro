package br.com.alura.FipeTable.service;

public interface ConvertData {
    <T> T getData(String json, Class<T> tClass);
}
