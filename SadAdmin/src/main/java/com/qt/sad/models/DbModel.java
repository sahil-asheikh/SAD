/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.models;

import com.qt.sad.beans.DbBean;
import com.qt.sad.beans.ProjectBean;
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
public class DbModel {
    
    Connection con = DatabaseConnect.connectDb();
    String sql = null;
    String message = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    
  
    

    public void insert(DbBean dbean, HttpServletRequest request, HttpServletResponse response) throws IOException {

        //sql query
        sql = "INSERT INTO tbldb(studid,subdomainid,projectid,dbname,db)VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, dbean.getStudid());
            ps.setInt(2, dbean.getSubDomainId());
            ps.setInt(3, dbean.getProjectId());
            ps.setString(4, dbean.getDbName());
            ps.setString(5, dbean.getDbfile());
           

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                message = "Database Import Successfull";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            response.sendRedirect("dashboard.jsp?message=" + message);
        }

    }

    public void delete(ProjectBean projbean, HttpServletRequest request, HttpServletResponse response) throws IOException {

        sql = "delete from tblproject where id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, projbean.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected >= 1) {
                message = "Domain Deleted";

            }

        } catch (SQLException e) {
            message = "Unable to delete because of" + e.getMessage();
        } finally {
            response.sendRedirect("test.jsp?message=" + message);
        }

    }

    public void update(ProjectBean projbean, HttpServletRequest request, HttpServletResponse response) throws IOException {

        sql = "update tblproject set  project=? where id= ?";
        try {
            ps = con.prepareStatement(sql);

            
           
            ps.setString(2, projbean.getProject());
            ps.setInt(3, projbean.getId());
          
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected >= 1) {
                message = "Subdomain Updated";
            }

        } catch (SQLException e) {
            message = "Unable to update because of :" + e.getMessage();
        } finally {
            response.sendRedirect("test.jsp?message=" + message);
        }

    }
    
}
