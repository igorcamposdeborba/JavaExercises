package factory;

import model.DB;

public interface DBFactory {

    public abstract DB getDatabase();
}
