/*package com.isaaclins.zooh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    private static final String URL = "jdbc:mysql://localhost:3306/zooh?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "220563";

    public static Connection connectToDB() {
        Connection Connection = null;
        try {
            Connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return Connection;
    }
}
*/