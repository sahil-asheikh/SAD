/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.models;

import com.qt.sad.beans.UserBean;
import com.qt.sad.commons.DatabaseConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azher
 */
public class UserModel {
    
    Connection con = DatabaseConnect.connectDb();
    String sql = null;
    String message = null;
    Statement stmt = null;
    PreparedStatement ps = null;

    public void insert(UserBean ub, HttpServletRequest request, HttpServletResponse response) throws IOException {

        //sql query
        sql = "INSERT INTO tbluser(name,mob,email,password,education,college,city)VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, ub.getName());
            ps.setString(2, ub.getMob());
            ps.setString(3, ub.getEmail());
            ps.setString(4, ub.getPassword());
            ps.setString(5, ub.getEducation());
            ps.setString(6, ub.getCollege());
            ps.setString(7, ub.getCity());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                message = "Successful Registred";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            response.sendRedirect("test.jsp?message=" + message);
        }

    }

    public void delete(UserBean ub, HttpServletRequest request, HttpServletResponse response) throws IOException {

        sql = "delete from tbldealer where id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ub.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected >= 1) {
                message = "Deleted Successfully";

            }

        } catch (SQLException e) {
            message = "Unable to delete because of" + e.getMessage();
        } finally {
            response.sendRedirect("test.jsp?message=" + message);
        }

    }

    public void update(UserBean ub, HttpServletRequest request, HttpServletResponse response) throws IOException {

        sql = "update tbluser set  name=?, mob=?, email=?, password=?, education=?, college=?, city=? where id= ?";
        try {
            ps = con.prepareStatement(sql);

            
            ps.setString(1, ub.getName());
            ps.setString(2, ub.getMob());
            ps.setString(3, ub.getEmail());
            ps.setString(4, ub.getPassword());
            ps.setString(5, ub.getEducation());
            ps.setString(6, ub.getCollege());
            ps.setString(7, ub.getCity());
            ps.setInt(8, ub.getId());
          
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected >= 1) {
                message = "Profile Update Successfully";
            }

        } catch (SQLException e) {
            message = "Unable to update because of :" + e.getMessage();
        } finally {
            response.sendRedirect("dashboard.jsp?message=" + message);
        }

    }
    
}
