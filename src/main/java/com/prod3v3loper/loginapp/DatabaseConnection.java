package com.prod3v3loper.loginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static final String URL = "jdbc:mysql://localhost:6606/databasename";
    private static final String USER = "root";
    private static final String PASSWORD = "test";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
