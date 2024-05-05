package br.com.alura.FipeTable.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Auto(String Valor,
                   String Marca,
                   String Modelo,
                   Integer AnoModelo,
                   String Combustivel) {
}
