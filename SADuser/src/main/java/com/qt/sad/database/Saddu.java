/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Masarrat
 */
public class Saddu {

    private static final String DATABASE = Saddu.class.getSimpleName().toLowerCase();
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/" + DATABASE;
     private static final String USER="sad-manager";
     private static final String PASS="wMSGDjz<r4GC";
//    private static final String USER = "root";
//    private static final String PASS = "admin";

    public static Connection connectDb() {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println("com.qt.sad.database.Saddu.connectDb()::DATABASE `" + DATABASE + "` CONNECTED");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("com.qt.sad.database.Saddu.connectDb()::" + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        connectDb();
    }
}
