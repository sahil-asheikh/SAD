/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.models;

import com.qt.sad.beans.SubDomainBean;
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
public class SubDomainModel {
    
    Connection con = DatabaseConnect.connectDb();
    String sql = null;
    String message = null;
    Statement stmt = null;
    PreparedStatement ps = null;

    public void insert(SubDomainBean subdom, HttpServletRequest request, HttpServletResponse response) throws IOException {

        //sql query
        sql = "INSERT INTO tblsubdomain(studid,subdomain)VALUES(?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, subdom.getStudId());
            ps.setString(2, subdom.getSubDomain());
           

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                message = "Domain Created";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            response.sendRedirect("dashboard.jsp?message=" + message);
        }

    }

    public void delete(SubDomainBean subdom, HttpServletRequest request, HttpServletResponse response) throws IOException {

        sql = "delete from tbldealer where id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, subdom.getId());
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

    public void update(SubDomainBean subdom, HttpServletRequest request, HttpServletResponse response) throws IOException {

        sql = "update tblsubdomain set  subdomain=? where id= ?";
        try {
            ps = con.prepareStatement(sql);

            
           
            ps.setString(2, subdom.getSubDomain());
            ps.setInt(3, subdom.getId());
          
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
