/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbladmin;
import com.qt.sad.service.Admin_service;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "Admin_controller", urlPatterns = {"/Admin_controller"})
public class Admin_controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Admin_service admin_service = new Admin_service();
    Tbladmin admin = new Tbladmin();
    String message;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        switch (action) {
            case "login":
                admin_login(request, response);
                break;
            case "logout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("index.jsp?message=Loged out successfully");
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void admin_login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String mobile = request.getParameter("user");
            String password = request.getParameter("pass");
            admin.setMobile(mobile);
            admin.setPassword(password);
            message = admin_service.admin_login(admin, request);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.Admin_controller.admin_login()::" + e.getMessage();
        } finally {
            if (message.equals(ResponseMessages.LOGIN_SUCCESS.getResponseMessages())) {
                response.sendRedirect("admin_dashboard.jsp?message=" + message);
            } else {
                response.sendRedirect("index.jsp?message=" + message);
            }
        }
    }
    
}
