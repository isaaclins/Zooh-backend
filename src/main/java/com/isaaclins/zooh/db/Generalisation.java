package com.isaaclins.zooh.db;

import com.isaaclins.zooh.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Generalisation{
    public static boolean login(UserEntity user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DBConnection.connectToDB();

            String insertQuery = "SELECT * FROM user WHERE username ='" + sanitizeAndEscape(user.getUsername())+"' AND password =" +user.getPassword()+";";
            preparedStatement = connection.prepareStatement(insertQuery);

            resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public static boolean Register(UserEntity user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DBConnection.connectToDB();
            String insertQuery = "INSERT INTO user (username, password) VALUES ('" + sanitizeAndEscape(user.getUsername()) + "', " + user.getPassword() + ",)";
            preparedStatement = connection.prepareStatement(insertQuery);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Return true if the insertion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

// ANTI SQL-INJECTION!!!! LETS GOOOO
    public static String sanitizeAndEscape(String stringtosanitize) {
        // Remove all occurrences of < and >
        String sanitizedString = stringtosanitize.replaceAll("[<>]", "");

        return sanitizedString;
    }



}
