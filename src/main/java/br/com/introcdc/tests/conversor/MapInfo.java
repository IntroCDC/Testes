package br.com.introcdc.tests.conversor;
/*
 * Written by IntroCDC, Bruno Coêlho at 13/11/2022 - 07:10
 */

import java.util.List;
import java.util.Map;

public class MapInfo {

    private String displayName;
    private String lobbyLocation;
    private String lobbyB1;
    private String lobbyB2;
    private Map<String, TeamInfo> teamInfoMap;
    private List<String> diamond;
    private List<String> emerald;
    private double up;
    private double down;
    private double maxX;
    private double maxZ;
    private double minX;
    private double minZ;

    public MapInfo(String displayName, String lobbyLocation, String lobbyB1, String lobbyB2, Map<String, TeamInfo> teamInfoMap, List<String> diamond, List<String> emerald, double up, double down, double maxX, double maxZ, double minX, double minZ) {
        this.displayName = displayName;
        this.lobbyLocation = lobbyLocation;
        this.lobbyB1 = lobbyB1;
        this.lobbyB2 = lobbyB2;
        this.teamInfoMap = teamInfoMap;
        this.diamond = diamond;
        this.emerald = emerald;
        this.up = up;
        this.down = down;
        this.maxX = maxX;
        this.maxZ = maxZ;
        this.minX = minX;
        this.minZ = minZ;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLobbyLocation() {
        return lobbyLocation;
    }

    public String getLobbyB1() {
        return lobbyB1;
    }

    public String getLobbyB2() {
        return lobbyB2;
    }

    public Map<String, TeamInfo> getTeamInfoMap() {
        return teamInfoMap;
    }

    public List<String> getDiamond() {
        return diamond;
    }

    public List<String> getEmerald() {
        return emerald;
    }

    public double getUp() {
        return up;
    }

    public double getDown() {
        return down;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinZ() {
        return minZ;
    }

    public String minLocation() {
        return getMinX() + " " + getDown() + " " + getMinZ();
    }

    public String maxLocation() {
        return getMaxX() + " " + getUp() + " " + getMaxZ();
    }

    @Override
    public String toString() {
        return "br.com.introcdc.tests.conversor.MapInfo{" +
                "displayName='" + displayName + '\'' +
                ", lobbyLocation='" + lobbyLocation + '\'' +
                ", lobbyB1='" + lobbyB1 + '\'' +
                ", lobbyB2='" + lobbyB2 + '\'' +
                ", teamInfoMap=" + teamInfoMap +
                ", diamond=" + diamond +
                ", emerald=" + emerald +
                ", up=" + up +
                ", down=" + down +
                ", maxX=" + maxX +
                ", maxZ=" + maxZ +
                ", minX=" + minX +
                ", minZ=" + minZ +
                '}';
    }

}
