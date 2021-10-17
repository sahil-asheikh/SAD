/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.model.Tblsubdomain;
import com.qt.sad.service.Subdomain_service;
import com.qt.sad.utility.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azher
 */
@WebServlet(name = "Subdomain_controller", urlPatterns = {"/Subdomain_controller"})
public class Subdomain_controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Tblsubdomain subdomain = new Tblsubdomain();
    Subdomain_service subdomain_service = new Subdomain_service();
    String message;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        switch (request.getParameter("action")) {
            case "insert_subdomain":
                insert_subdomain(request, response);
                break;
            case "update_subdomain":
                update_subdomain(request, response);
                break;
            case "delete_subdomain":
                delete_subdomain(request, response);
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

    private void insert_subdomain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            subdomain.setSubdomain(Utils.requiredNotNull(request.getParameter("txtSubdomain"), "Subdomain cannot be null"));
            subdomain.setUser_id(Utils.requiredNotNull(request.getParameter("txtUserid"), "User ID cannot be null"));
            message = subdomain_service.insert_subdomain(subdomain);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.Subdomain_controller.insert_subdomain()::" + e.getMessage();
        } finally {
            response.sendRedirect("user_subdomain.jsp?message=" + message);
        }
    }

    private void update_subdomain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            subdomain.setSubdomain(Utils.requiredNotNull(request.getParameter("txtSubdomain"), "Subdomain cannot be null"));
            subdomain.setUser_id(Utils.requiredNotNull(request.getParameter("txtUserid"), "User ID cannot be null"));
            subdomain.setSubdomain_id(Utils.requiredNotNull(request.getParameter("txtSubdomainid"), "Subdomain ID cannot be null"));
            message = subdomain_service.update_subdomain(subdomain);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.Subdomain_controller.update_subdomain()::" + e.getMessage();
        } finally {
            response.sendRedirect("user_subdomain.jsp?message=" + message);
        }
    }

    private void delete_subdomain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

        } catch (Exception e) {
            message = "com.qt.sad.controllers.Subdomain_controller.delete_subdomain()::" + e.getMessage();
        } finally {
            response.sendRedirect("user_subdomain.jsp?message=" + message);
        }
    }

}
