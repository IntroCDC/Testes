package br.com.introcdc.tests.database;
/*
  Written by IntroCDC, Bruno Coêlho at 29/08/2017 - 06:27
 */

import br.com.introcdc.tests.database.query.DatabaseQuery;

public class DatabaseUtils extends GlobalDatabase {

    /**
     * Create new Query of type 'SELECT'
     */
    public static DatabaseQuery selectFromTable(String table) {
        StringComponents.checkNull(table, "Table cannot be null");
        return new DatabaseQuery("SELECT", table);
    }

    /**
     * Create new Query of type 'UPDATE'
     */
    public static DatabaseQuery updateTable(String table) {
        StringComponents.checkNull(table, "Table cannot be null");
        return new DatabaseQuery("UPDATE", table);
    }

    /**
     * Create new Query of type 'DELETE'
     */
    public static DatabaseQuery deleteFromTable(String table) {
        StringComponents.checkNull(table, "Table cannot be null");
        return new DatabaseQuery("DELETE", table);
    }

    /**
     * Create new Query of type 'INSERT'
     */
    public static DatabaseQuery insertIntoTable(String table) {
        StringComponents.checkNull(table, "Table cannot be null");
        return new DatabaseQuery("INSERT", table);
    }

}
