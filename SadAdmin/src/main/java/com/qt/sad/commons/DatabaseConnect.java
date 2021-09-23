/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.commons;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Masarrat
 */
public class DatabaseConnect {
    
    
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/saddu";
    // Global user & Pass
    // static final String gUSER="wheelroot";
    // static final String gPASS="ws1234";
     
     //local user & pass
    static final String USER="root";
    static final String PASS="12345";
    
    
    public static Connection connectDb(){
        
        Connection con=null;
        
        try {
              Class.forName(JDBC_DRIVER);
            
            //connection to database
            
            con=DriverManager.getConnection(DB_URL,USER,PASS);
            
            System.out.println("Successfull");
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println(e.getMessage());
        }
        return con;
    }
     public static void main(String[] args) {
        connectDb();
    }
    
   
}
