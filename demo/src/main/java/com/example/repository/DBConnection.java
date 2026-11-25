package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3308/testdb?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "MiOtraPassword123";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
