package br.com.introcdc.tests.database.query;
/*
 * Written by IntroCDC, Bruno Coelho at 02/06/2020 - 08:18
 */

public record ColumnCreator(String name,
                            ColumnType columnType,
                            Object defaultValue) {

    public static final String CHARSET = "utf8mb4";
    public static final String COLLATE = "utf8mb4_0900_ai_ci";
    public static final String NONE = "none";
    public static final String AUTO_INCREMENT = "AUTO_INCREMENT";

    public String getName() {
        return name;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String toString() {
        StringBuilder returnBuilder = new StringBuilder();
        returnBuilder.append("`").append(getName()).append("` ");

        ColumnType columnType = getColumnType();
        Object defaultValue = getDefaultValue();
        returnBuilder.append(columnType.toString().toLowerCase());
        if (columnType == ColumnType.VARCHAR || columnType == ColumnType.CHAR || columnType == ColumnType.TEXT) {
            if (columnType == ColumnType.VARCHAR || columnType == ColumnType.CHAR) {
                returnBuilder.append("(").append(columnType.getValue()).append(")");
            }
            returnBuilder.append(" CHARACTER SET ").append(CHARSET).append(" ");
            if (defaultValue == null && !columnType.equals(ColumnType.TEXT)) {
                returnBuilder.append("DEFAULT NULL");
            } else {
                returnBuilder.append("NOT NULL");
                if (!String.valueOf(defaultValue).equalsIgnoreCase("none") && !columnType.equals(ColumnType.TEXT)) {
                    returnBuilder.append(" DEFAULT '").append(defaultValue).append("'");
                }
            }
        } else if (columnType == ColumnType.DOUBLE) {
            returnBuilder.append("(").append(columnType.getValue()).append(") ");
        }

        if (columnType == ColumnType.DOUBLE || columnType == ColumnType.INT || columnType == ColumnType.BIGINT) {
            returnBuilder.append(" NOT NULL");
            if (!String.valueOf(defaultValue).equalsIgnoreCase(NONE) && !String.valueOf(defaultValue).equals(AUTO_INCREMENT)) {
                returnBuilder.append(" DEFAULT '").append(defaultValue).append("'");
            }
        }

        if (columnType == ColumnType.INT && String.valueOf(defaultValue).equals(AUTO_INCREMENT)) {
            returnBuilder.append(" " + AUTO_INCREMENT);
        }

        return returnBuilder.toString();
    }

    public enum ColumnType {
        VARCHAR, CHAR, TEXT, DOUBLE, INT, BIGINT;

        private Object value;

        public Object getValue() {
            return value;
        }

        public ColumnType value(Object value) {
            this.value = value;
            return this;
        }
    }

}
