package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    public static Connection getConnection() {
        Connection connection = null;

        try {
//          Đăng ký mysql driver với drivermanager
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

//          Thiết lập thông số để connect database
            String url = "jdbc:mysql://localhost:3306/demo2006";
            String username = "root";
            String password = "Hoanglekha@123";

//          Kết nối
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
