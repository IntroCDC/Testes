package br.com.introcdc.tests.kindome;
/*
 * Written by IntroCDC, Bruno Coelho at 02/04/2025 - 02:31
 */

import br.com.introcdc.tests.database.GlobalDatabase;

public class DatabaseImporter {

    public static void main(String[] args) throws Exception {
        GlobalDatabase.reloadConnection();
    }

}
