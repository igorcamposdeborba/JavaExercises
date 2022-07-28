package factory;
import factory.DBFactory;
import model.DB;
import model.PostgresDB;

public class PostgresFactory implements DBFactory {

    @Override
    public DB getDatabase() {
        return new PostgresDB();
    }

}
