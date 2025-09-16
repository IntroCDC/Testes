package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 30/08/2025 - 07:27
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.GlobalDatabase;

public class ForumMethods {

    public static void main(String[] args) throws Exception {
        initializeForum();
    }

    public static void initializeForum() throws Exception {
        GlobalDatabase.DATABASE = "introcdc";
        DatabaseUtils.reloadConnection();
    }

    public static void updateUploads() throws Exception {
    }

}
