package com.qt.sad.controllers;

import com.qt.sad.commons.DatabaseConnect;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                userLogin(request, response);
                break;
            case "update":
                doPut(request, response);
                break;
            case "delete":
                doDelete(request, response);
                break;

            case "logout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("login.jsp");
                break;

            default:
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Connection con = DatabaseConnect.connectDb();
        String sql = null;
        String message = null;
        PreparedStatement ps = null;
        boolean status;
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        HttpSession session = null;
        try {
            ps = con.prepareStatement("select * from tbluser where mob=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            if (status == true) {
                session = request.getSession(true);
                session.setAttribute("sid", rs.getInt("id"));
                session.setAttribute("user", rs.getString("name"));
                message = "Login Successull";
                response.sendRedirect("dashboard.jsp?message=" + message);
            } else {
                message = "incorrect credential";
                response.sendRedirect("login.jsp?message=" + message);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

}
