package dao;

import java.util.ArrayList;

public interface DAOInterface <T> {

    public int Insert(T t);

    public int Update(T t);

    public int Delete(T t);

    public ArrayList <T> SelectAll();

    public T SelectByID(T t);

    public ArrayList <T> SelectByCondition(String condition);
}
