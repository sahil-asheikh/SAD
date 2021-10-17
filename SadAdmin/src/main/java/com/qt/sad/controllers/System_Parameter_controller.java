/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.service.System_Parameter_service;
import com.qt.sad.utility.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "System_Parameter_controller", urlPatterns = {"/System_Parameter_controller"})
public class System_Parameter_controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    System_Parameter_service system_Parameter_service = new System_Parameter_service();
    String message;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case "save_system_parameter":
                save_system_parameter(request, response);
                break;
            case "delete":
                delete_system_parameter(request, response);
                break;
            case "update":
                update_system_parameter(request, response);
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

    private void save_system_parameter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            message = system_Parameter_service.saveSystemParameter(Utils.requiredNotNull(request.getParameter("system_parameter_name"), "System Parameter Name must not be null"), Utils.requiredNotNull(request.getParameter("system_parameter_value"), "System Parameter Value must not be null"));
        } catch (Exception e) {
            message = "com.qt.sad.controllers.System_Parameter_controller.save_system_parameter()::" + e.getMessage();
        } finally {
            response.sendRedirect("admin_system_parameters.jsp?message=" + message);
        }
    }

    private void delete_system_parameter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            message = system_Parameter_service.deleteSystemParameter(Utils.requiredNotNull(request.getParameter("sp_name"), "System Parameter Name must not be null"));
        } catch (Exception e) {
            message = "com.qt.sad.controllers.System_Parameter_controller.delete_system_parameter()::" + e.getMessage();
        } finally {
            response.sendRedirect("admin_show_sp.jsp?message=" + message);
        }
    }

    private void update_system_parameter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            message = system_Parameter_service.updateSystemParameter(
                    Utils.requiredNotNull(request.getParameter("sp_name"), "System Parameter Name must not be null"),
                    Utils.requiredNotNull(request.getParameter("sp_value"), "System Parameter Value must not be null"));
        } catch (Exception e) {
            message = "com.qt.sad.controllers.System_Parameter_controller.update_system_parameter()::" + e.getMessage();
        } finally {
            response.sendRedirect("admin_show_sp.jsp?message=" + message);
        }
    }

}
