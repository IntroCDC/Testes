package br.com.introcdc.tests.value;
/*
 * Written by IntroCDC, Bruno Coelho at 02/09/2024 - 21:35
 */

public enum ValueType {
    PARCELADA("Parcelada", " ("),
    IFOOD("iFood", "IFD*"),
    MAIS_DELIVERY("Mais Delivery", "MP *"),
    LAJE("Laje", "LAJE HEAD SHOP"),
    PIX_EDUARDA("Pix Eduarda", "Maria Eduarda"),
    PIX("Pix", "PICPAY"),
    CONDOMINIO("Mercadinho Condomínio", "24/7 MARKET"),
    UBER("Uber", "Uber *UBER"),
    COMIDA("Comida", "MC DONALDS", "KALZONE", "RESTAURANTE GIRASSOL", "GRUPO FAST GRILL", "HOTEL E REST KRONE", "ORGANICO", "DOM PRATINHO", "MEEP PA*KRS GESTAO DE", "MONTE CARLO LTDA", "MAHALO POKE", "CLUB CAFE IGUATEMI", "JUNTOS ACAITERIA"),
    ROUPAS("Roupas e Derivados", "CENTAURO", "CEA MODAS 0380"),
    POSTO("Gasolina", "POSTO"),
    ESTACIONAMENTO("Estacionamento", "ESTACIONAMENTO", "BENFICA PARK", "FORTALEZA NORTH SHOPPI");

    private final String title;
    private final String[] type;
    private double value;
    private int amount;

    ValueType(String title, String... type) {
        this.title = title;
        this.type = type;
        this.value = 0.0;
        this.amount = 0;
    }

    public String getTitle() {
        return title;
    }

    public String[] getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
