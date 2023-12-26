package dao;

import model.entity.Order;

import java.util.ArrayList;

public class OrderDAO implements DAOInterface <Order> {

    private static OrderDAO orderDAO;

    private OrderDAO() {

    }

    public static OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            orderDAO = new OrderDAO();
        }
        return orderDAO;
    }

    @Override
    public int Insert(Order order) {
        return 0;
    }

    @Override
    public int Update(Order order) {
        return 0;
    }

    @Override
    public int Delete(Order order) {
        return 0;
    }

    @Override
    public ArrayList <Order> SelectAll() {
        return null;
    }

    @Override
    public Order SelectByID(Order order) {
        return null;
    }

    @Override
    public ArrayList <Order> SelectByCondition(String condition) {
        return null;
    }
}
