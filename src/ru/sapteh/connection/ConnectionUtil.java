package ru.sapteh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/pc?&serverTimezone=UTC";
    public static String USER = "root";
    public static String PASSWORD = "1234";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
