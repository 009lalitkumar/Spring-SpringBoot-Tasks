package com.springboot.workers.crudapi.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/my_org";
    private static final String USER = "root";
    private static final String PASS = "123654";

    private DatabaseConnection() {

    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected to database server " + conn.getMetaData().getDatabaseProductName() + " version: "
                + conn.getMetaData().getDatabaseProductVersion());
        return conn;
    }
}