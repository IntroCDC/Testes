package br.com.introcdc.tests.conversor;
/*
 * Written by IntroCDC, Bruno Coêlho at 13/11/2022 - 07:13
 */

public class TeamInfo {

    private String name;
    private String spawn;
    private String bed;
    private String generator;
    private String shop;
    private String upgrades;

    public TeamInfo(String name, String spawn, String bed, String generator, String shop, String upgrades) {
        this.name = name;
        this.spawn = spawn;
        this.bed = bed;
        this.generator = generator;
        this.shop = shop;
        this.upgrades = upgrades;
    }

    public String getName() {
        return name;
    }

    public String getSpawn() {
        return spawn;
    }

    public String getBed() {
        return bed;
    }

    public String getGenerator() {
        return generator;
    }

    public String getShop() {
        return shop;
    }

    public String getUpgrades() {
        return upgrades;
    }

    @Override
    public String toString() {
        return "br.com.introcdc.tests.conversor.TeamInfo{" +
                "name='" + name + '\'' +
                ", spawn='" + spawn + '\'' +
                ", bed='" + bed + '\'' +
                ", generator='" + generator + '\'' +
                ", shop='" + shop + '\'' +
                ", upgrades='" + upgrades + '\'' +
                '}';
    }

}
