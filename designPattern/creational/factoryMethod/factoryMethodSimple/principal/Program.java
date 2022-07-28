package principal;

import factory.OracleFactory;
import model.DB;

public class Program {

    public static void main (String [] args){

        DB db = new OracleFactory().getDatabase();
        db.query("SELECT * FROM users");
        db.update("INSERT INTO user VALUES ('User', 25)");

    }
}
