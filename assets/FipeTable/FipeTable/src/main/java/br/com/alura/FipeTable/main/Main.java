package br.com.alura.FipeTable.main;

import br.com.alura.FipeTable.service.Api;

import java.util.Scanner;

public class Main {
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private Api api = new Api();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        String menu = """
               ------------------
               Carro
               Moto
               Caminhão
               ------------------
               
               Digite uma das opções:
               """;

        System.out.println(menu);
        String choice = scanner.nextLine();

        String address;

        if (choice.toLowerCase().contains("carr")) {
            address = BASE_URL + "carros/marcas";
        } else if (choice.toLowerCase().contains("mot")) {
            address = BASE_URL + "motos/marcas";
        } else {
            address = BASE_URL + "caminhoes/marcas";
        }

        var json = api.connect(address);
        System.out.println(json);
    }
}
