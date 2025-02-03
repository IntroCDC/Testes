package br.com.introcdc.tests.tests;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/01/2025 - 22:50
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.GlobalDatabase;

import java.sql.ResultSet;

public class Test {

    public static void main(String[] args) throws Exception {
        GlobalDatabase.reloadConnection();
        ResultSet resultSet = DatabaseUtils.selectFromTable("statistics").whereEquals("kuid", "LugoldLugoldLugoldLugold").executeQuery();
        System.out.println("Rodando...");
        while (resultSet.next()) {
            String id = resultSet.getString("statistic_id");
            long value = resultSet.getLong("value");
            ResultSet test = DatabaseUtils.selectFromTable("statistics").whereEquals("kuid", "fgxliBKDLgq50aILSTn68oRL")
                    .and().whereEquals("statistic_id", id).executeQuery();
            if (test.next()) {
                DatabaseUtils.updateTable("statistics").set("value", test.getLong("value") + value).whereEquals("id", test.getInt("id")).executeUpdate();
                DatabaseUtils.deleteFromTable("statistics").whereEquals("id", resultSet.getInt("id")).executeUpdate();
            } else {
                DatabaseUtils.updateTable("statistics").set("kuid", "fgxliBKDLgq50aILSTn68oRL").whereEquals("id", resultSet.getInt("id")).executeUpdate();
            }
        }
        System.out.println("Pronto!");
    }

}
