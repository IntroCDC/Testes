package br.com.introcdc.tests.database.query;
/**
 * Written by IntroCDC, Bruno Coêlho at 29/08/2017 - 11:58
 */

public enum MathType {
    EQUALS("="),
    EQUALSORBIGGER(">="),
    EQUALSORLESS("<="),
    BIGGER(">"),
    LESS("<"),
    ISNEQUALS("!=");

    private final String process;

    MathType(String process) {
        this.process = process;
    }

    public String getProcess() {
        return process;
    }
}
