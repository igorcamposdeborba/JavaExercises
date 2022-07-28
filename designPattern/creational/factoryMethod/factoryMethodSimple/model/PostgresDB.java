package model;
import model.DB;

public class PostgresDB implements DB {

    @Override
    public void query (String sql) {
        System.out.println("Querying " + sql + " in Postgres database");
    }

    @Override
    public void update(String sql) {
        System.out.println("Update " + sql + " in Postgres database");
    }
}
