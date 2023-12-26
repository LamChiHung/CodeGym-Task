package dao;

import database.JDBCUtils;
import model.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface <Customer> {

    private static CustomerDAO customerDAO;

    private CustomerDAO() {
    }

    public static CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            customerDAO = new CustomerDAO();
        }
        return customerDAO;
    }

    @Override
    public int Insert(Customer customer) {
        int result = 0;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "INSERT INTO `demo2006`.`customer` (`id`, `name`, `age`) " +
                    "VALUES (?,?,?);\n";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());

            result = preparedStatement.executeUpdate();

            System.out.println("Insert success!");
            System.out.println(result + " row was inserted");

            JDBCUtils.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int Update(Customer customer) {
        int result = 0;
        try {
            Connection connection = JDBCUtils.getConnection();

            Statement statement = connection.createStatement();

            String sql = "UPDATE `demo2006`.`customer` " +
                    "SET `name` = '" + customer.getName() + "', `age` = " + customer.getAge() + " WHERE (`id` = " + customer.getId() + ");";

            result = statement.executeUpdate(sql);

            System.out.println("update success!");
            System.out.println(result + " row was updated");

            JDBCUtils.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int Delete(Customer customer) {
        int result = 0;
        try {
            Connection connection = JDBCUtils.getConnection();

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM `demo2006`.`customer` WHERE (`id` = " + customer.getId() + ");";

            result = statement.executeUpdate(sql);

            System.out.println("deleted success!");
            System.out.println(result + " row was deleted");

            JDBCUtils.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList <Customer> SelectAll() {
        ArrayList <Customer> result = new ArrayList <>();
        try {
            Connection connection = JDBCUtils.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM `demo2006`.`customer`";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                result.add(new Customer(id, name, age));
            }

            System.out.println("select success!");
            System.out.println(result.toString());

            JDBCUtils.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Customer SelectByID(Customer customer) {
        Customer result = null;
        try {
            Connection connection = JDBCUtils.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM `demo2006`.`customer` WHERE `id` = " + customer.getId() + ";";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                result = new Customer(id, name, age);
            }

            System.out.println("select success!");
            System.out.println(result.toString());

            JDBCUtils.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList <Customer> SelectByCondition(String condition) {
        ArrayList <Customer> result = new ArrayList <>();
        try {
            Connection connection = JDBCUtils.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM `demo2006`.`customer` WHERE " + condition;

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                result.add(new Customer(id, name, age));
            }

            System.out.println("select success!");
            System.out.println(result.toString());

            JDBCUtils.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
