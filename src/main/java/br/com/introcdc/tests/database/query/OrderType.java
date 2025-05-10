package br.com.introcdc.tests.database.query;

/**
 * Written by IntroCDC, Bruno Coelho at 01/09/2017 - 06:02
 */

public enum OrderType {
    ASC("ASC"),
    DESC("DESC");

    private String process;

    OrderType(String process) {
        this.process = process;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public OrderType fill(String string) {
        String process = getProcess();
        setProcess(process + " " + string);
        // GlobalUtils.getTimer().schedule(() -> setProcess(process), 300, TimeUnit.MILLISECONDS);
        return this;
    }
}
