package br.com.introcdc.tests.database;
/*
  Written by IntroCDC, Bruno Coelho at 29/08/2017 - 05:24
 */

import com.google.gson.JsonObject;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GlobalDatabase {

    /**
     * Connections
     */
    private static Connection CONNECTION = null;

    /**
     * Objects to Connection
     */
    private static final String USER = "introcdc";
    private static String PASSWORD = "";
    public static String DATABASE = "kindome";
    public static String CONNECTION_STRING = null;

    /**
     * Statistics
     */
    public static long CONNECTIONS = 0;
    public static long MYSQL_QUERIES = 0;
    public static final List<String> LAST_QUERIES = StringComponents.arrayList();
    public static final List<String> LAST_UPDATES = StringComponents.arrayList();
    public static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    /**
     * Execute query, return ResultSet
     */
    public static ResultSet executeQuery(String query) {
        StringComponents.checkNull(query, "Query cannot be null");
        CONNECTIONS++;
        MYSQL_QUERIES++;
        LAST_QUERIES.add(query);
        if (LAST_QUERIES.size() > 10) {
            LAST_QUERIES.remove(0);
        }
        ResultSet set = null;
        try {
            set = getStaticConnection().createStatement().executeQuery(query);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return set;
    }

    /**
     * Execute some update with exception
     */
    public static void executeUpdate(String query) throws SQLException {
        StringComponents.checkNull(query, "Query cannot be null");
        CONNECTIONS++;
        LAST_UPDATES.add(query);
        if (LAST_UPDATES.size() > 10) {
            LAST_UPDATES.remove(0);
        }
        try (Statement statement = getStaticConnection().createStatement()) {
            statement.executeUpdate(query);
        }
    }

    /**
     * Get static enabled mysql connection
     */
    public static Connection getStaticConnection() {
        try {
            if (CONNECTION == null) {
                return reloadConnection();
            } else if (CONNECTION.isClosed()) {
                return reloadConnection();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return CONNECTION;
    }

    /**
     * Reload static connection
     */
    public static Connection reloadConnection() throws Exception {
        if (StringComponents.toBoolean(System.getProperty("mysqlConnection", "true"))) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            if (CONNECTION_STRING == null) {
                setupMysql();
                CONNECTION_STRING = "127.0.0.1:3306";
            }
            CONNECTION = DriverManager.getConnection("jdbc:mysql://" + CONNECTION_STRING + "/" + DATABASE +
                    "?dontTrackOpenResources=true&useSSL=false&serverTimezone=America/Fortaleza", USER, PASSWORD);
            return CONNECTION;
        }
        return null;
    }

    /**
     * Setup mysql password
     */
    public static void setupMysql() throws IOException {
        if (System.getProperty("mysqlPassword") == null) {
            JsonObject object = StringComponents.readJson("http://localhost/passwords").getAsJsonObject();
            PASSWORD = object.get("mysql").getAsString();
        } else {
            PASSWORD = System.getProperty("mysqlPassword");
        }
    }

}
