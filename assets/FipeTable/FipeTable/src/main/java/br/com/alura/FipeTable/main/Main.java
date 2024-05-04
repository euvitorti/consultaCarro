package br.com.alura.FipeTable.main;

import br.com.alura.FipeTable.model.AutoModels;
import br.com.alura.FipeTable.model.Data;
import br.com.alura.FipeTable.service.Api;
import br.com.alura.FipeTable.service.ConvertData;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private Api api = new Api();
    private ConvertData convertData = new ConvertData();

    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
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

        //OBTENDO A LISTA DA API
        var brand = convertData.getList(json, Data.class);

        // ORGANIZANDO POR CÓDIGO
        brand.stream()
                .sorted(Comparator.comparing(Data::codigo))
                .forEach(System.out::println);

        System.out.println("""
                ----------------
                Informe o código:
                ----------------
                \n
                """);

        String code = scanner.nextLine();

        address += "/" + code + "/modelos";
        json = api.connect(address);

        var list = convertData.getData(json, AutoModels.class);

        System.out.println("""
                -----------------
                Modelos da marca:
                -----------------
                \n
                """);

        list.modelos().stream()
                .sorted(Comparator.comparing(Data::codigo))
                .forEach(System.out::println);
    }
}
