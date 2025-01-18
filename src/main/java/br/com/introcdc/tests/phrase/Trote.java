package br.com.introcdc.tests.phrase;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Trote {

    public static Random random = new Random();

    public static void main(String[] args) {
        pessoa();
    }

    public static void pessoa() {
        List<String> pessoas = Arrays.asList("Biidu", "Bruno", "Logan", "Keroch");
        List<String> locais = Arrays.asList("Restaurante", "Taxi", "Eletricista", "Tecnico", "Bar", "Chaveiro", "Funeraria", "Pizzaria", "Agua", "Floricultura");
        System.out.println("Pessoa: " + pessoas.get(random.nextInt(pessoas.size())));
        System.out.println("Local: " + locais.get(random.nextInt(locais.size())));
    }

}
