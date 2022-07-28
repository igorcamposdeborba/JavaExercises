package model;

import model.DB;

public class OracleDB implements DB {

    @Override
    public void query (String sql) {
        System.out.println("Querying " + sql + " in Oracle database");
    }

    @Override
    public void update(String sql) {
        System.out.println("Update " + sql + " in Oracle database");
    }

}
