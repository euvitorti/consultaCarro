package br.com.alura.FipeTable.service;

import java.util.List;

public interface TConvertData {
    <T> T getData(String json, Class<T> tClass);

    <T> List<T> getList(String json, Class<T> tClass);
}
