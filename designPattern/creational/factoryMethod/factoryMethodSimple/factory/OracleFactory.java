package factory;

import model.DB;
import model.OracleDB;

public class OracleFactory implements DBFactory {

    @Override
    public DB getDatabase() {
        return new OracleDB();
    }

}