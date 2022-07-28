package model;

public interface DB {

    public abstract void query (String sql);

    public abstract void update(String sql);

}
