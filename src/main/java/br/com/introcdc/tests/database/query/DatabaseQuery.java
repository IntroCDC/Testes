package br.com.introcdc.tests.database.query;
/*
  Written by IntroCDC, Bruno Coelho at 29/08/2017 - 06:27
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.StringComponents;

import java.sql.ResultSet;
import java.util.Arrays;

public class DatabaseQuery extends DatabaseUtils {

    private final String type;
    private final String table;
    private final StringBuilder query;

    /**
     * Prepare Mysql Query
     */
    public DatabaseQuery(String type, String table) {
        this.type = type;
        this.table = table;
        this.query = new StringBuilder(type.toUpperCase() + (type.trim().isEmpty() ? "" : " "));
        if (type.equalsIgnoreCase("SELECT")) {
            this.query.append("* FROM ").append(table);
        } else if (type.equalsIgnoreCase("DELETE")) {
            this.query.append("FROM ").append(table);
        } else if (type.equalsIgnoreCase("INSERT")) {
            this.query.append("INTO ").append(table);
        } else if (type.equalsIgnoreCase("UPDATE")) {
            this.query.append(table);
        } else if (type.equalsIgnoreCase("ALTER TABLE")) {
            this.query.append(table);
        }
    }

    public String getType() {
        return type;
    }

    /**
     * Prepare Mysql Query(WHERE COLUMN = VALUE)
     */
    public DatabaseQuery whereEquals(String column, Object value) {
        getQuery().append(" ").append(getQuery().toString().contains("WHERE") ? "" : "WHERE ").append("`")
                .append(column).append("` = '").append(value).append("'");
        return this;
    }

    /**
     * Prepare Mysql Query(WHERE COLUMN = VALUE)
     */
    public DatabaseQuery whereIsNotEquals(String column, Object value) {
        getQuery().append(" ").append(getQuery().toString().contains("WHERE") ? "" : "WHERE ").append("`")
                .append(column).append("` != '").append(value).append("'");
        return this;
    }

    /**
     * Prepare Mysql Query(WHERE COLUMN IS Null)
     */
    public DatabaseQuery whereIsNull(String column) {
        getQuery().append(" ").append(getQuery().toString().contains("WHERE") ? "" : "WHERE ").append("`")
                .append(column).append("` IS NULL");
        return this;
    }

    /**
     * Prepare Mysql Query(WHERE COLUMN IS NOT Null)
     */
    public DatabaseQuery whereIsNotNull(String column) {
        getQuery().append(" ").append(getQuery().toString().contains("WHERE") ? "" : "WHERE ")
                .append("`").append(column).append("` IS NOT NULL");
        return this;
    }

    /**
     * Prepare Mysql Query(ORDER BY COLUMN ORDER)
     */
    public DatabaseQuery orderBy(OrderType orderType, String... columns) {
        getQuery().append(" ORDER BY ")
                .append(StringComponents.commas(Arrays.stream(columns).map(column -> "`" + column + "`"), ","))
                .append(" ").append(orderType);
        return this;
    }

    /**
     * Prepare Mysql Query(ORDER BY RAND)
     */
    public DatabaseQuery orderByRand() {
        getQuery().append(" ORDER BY RAND()");
        return this;
    }

    /**
     * Prepare Mysql Query(WHERE COLUMN MATH '%VALUE%')
     */
    public DatabaseQuery whereMath(String column, MathType mathType, long value) {
        return whereMath(column, mathType, (double) value);
    }

    public DatabaseQuery whereMath(String column, MathType mathType, double value) {
        StringComponents.checkNull(column, "Column cannot be null");
        getQuery().append(" ").append(getQuery().toString().contains("WHERE") ? "" : "WHERE ").append("`")
                .append(column).append("` ").append(mathType.getProcess()).append(" ").append(value);
        return this;
    }

    /**
     * Prepare Mysql Query(WHERE COLUMN LIKE '%VALUE%')
     */
    public DatabaseQuery whereLike(String column, Object value) {
        StringComponents.checkNull(column, "Column cannot be null");
        StringComponents.checkNull(value, "Value cannot be null");
        getQuery().append(" ").append(getQuery().toString().contains("WHERE") ? "" : "WHERE ").append("`")
                .append(column).append("` LIKE '%").append(value).append("%'");
        return this;
    }

    /**
     * Prepare Mysql Query(SET COLUMN = VALUE)
     */
    public DatabaseQuery set(String column, Object value) {
        StringComponents.checkNull(column, "Column cannot be null");
        StringComponents.checkNull(value, "Value cannot be null");
        String aNull = value.toString()
                .equalsIgnoreCase("NULL") ? "" : "'";
        getQuery().append(" SET `").append(column).append("` = ").append(aNull).append(value).append(
                aNull);
        return this;
    }

    /**
     * Prepare Mysql Query(COLUMN = VALUE)
     */
    public DatabaseQuery continueSet(String column, Object value) {
        StringComponents.checkNull(column, "Column cannot be null");
        StringComponents.checkNull(value, "Value cannot be null");
        String aNull = value.toString().equalsIgnoreCase("NULL") ? "" : "'";
        getQuery().append(" `").append(column).append("` = ").append(aNull).append(value).append(aNull);
        return this;
    }

    /**
     * Prepare Mysql Query Column info
     *
     * @param name         the name of the column
     * @param type         the type of the column (INT, DOUBLE, VARCHAR)
     * @param max          the max length of the value
     * @param canBeNull    if the value can be null
     * @param defaultValue set default value when insert without value
     * @return the query for update or get query from mysql
     */
    public DatabaseQuery columnType(String name, String type, int max, boolean canBeNull, String defaultValue) {
        StringComponents.checkNull(name, "Name cannot be null");
        StringComponents.checkNull(type, "Type cannot be null");
        getQuery().append(" ").append(name).append(" ").append(type.toUpperCase()).append("(").append(max).append(") ")
                .append(canBeNull ? "NULL" : "NOT NULL").append(" DEFAULT ").append(defaultValue != null ? "'" + defaultValue + "'" : "NULL");
        return this;
    }

    public DatabaseQuery replace(String column, Object search, Object toReplace) {
        StringComponents.checkNull(search, "search cannot be null");
        StringComponents.checkNull(toReplace, "toReplace cannot be null");
        getQuery().append(" SET `").append(column).append("` = REPLACE(`").append(column).append("`, '")
                .append(search).append("', '").append(toReplace).append("')");
        return this;
    }

    /**
     * Prepare Mysql Arrays(ARRAY)
     */
    public StringBuilder arrayKeys = null;
    public StringBuilder arrayValues = null;

    public DatabaseQuery openArrays() {
        arrayKeys = new StringBuilder(" (");
        arrayValues = new StringBuilder(" (");
        return this;
    }

    public DatabaseQuery closeArrays() {
        arrayKeys.append(")");
        arrayValues.append(")");
        string(arrayKeys.toString()).values().string(arrayValues.toString());
        return this;
    }

    public DatabaseQuery setInArray(String key, Object object) {
        if (arrayKeys.toString().endsWith("`")) {
            arrayKeys.append(",");
            arrayValues.append(",");
        }
        arrayKeys.append("`").append(key).append("`");
        arrayValues.append(object == null ? "" : "'").append(object == null ? "NULL" : String.valueOf(object)).append(object == null ? "" : "'");
        return this;
    }

    /**
     * Prepare Mysql VALUES
     */
    public DatabaseQuery values() {
        query.append(" VALUES");
        return this;
    }

    /**
     * Prepare Mysql LIMIT
     */
    public DatabaseQuery limit(int limit) {
        query.append(" LIMIT ").append(limit);
        return this;
    }

    /**
     * Prepare Mysql OR
     */
    public DatabaseQuery or() {
        query.append(" OR");
        return this;
    }

    /**
     * Prepare Mysql ADD
     */
    public DatabaseQuery add() {
        query.append(" ADD");
        return this;
    }

    /**
     * Prepare Mysql ','
     */
    public DatabaseQuery comma() {
        query.append(", ");
        return this;
    }

    /**
     * Prepare Mysql AND
     */
    public DatabaseQuery and() {
        query.append(" AND");
        return this;
    }

    /**
     * Prepare Mysql String
     */
    public DatabaseQuery string(String object) {
        query.append(object);
        return this;
    }

    public DatabaseQuery openClause() {
        query.append("(");
        return this;
    }

    public DatabaseQuery closeClause() {
        query.append(")");
        return this;
    }

    /**
     * Get complete query to execute
     */
    public StringBuilder getQuery() {
        return query;
    }

    /**
     * Execute update update
     */
    public void executeUpdate() {
        try {
            executeUpdate(getQuery().toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Execute update query
     */
    public ResultSet executeQuery() {
        return executeQuery(getQuery().toString());
    }

    @Override
    public String toString() {
        return getQuery().toString();
    }

}
