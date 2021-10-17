/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.model.Tbluser;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.service.User_service;
import com.qt.sad.utility.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Azher
 */
@WebServlet(name = "User_controller", urlPatterns = {"/User_controller"})
public class User_controller extends HttpServlet {

    Tbluser user = new Tbluser();
    User_service user_service = new User_service();
    String message;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        switch (request.getParameter("action")) {
            case "register_user":
                register_user(request, response);
                break;
            case "update_user":
                update_user(request, response);
                break;
            case "delete_user":
                delete_user(request, response);
                break;
            case "update_password":
                update_password(request, response);
                break;
            case "change_status":
                change_status(request, response);
                break;
            case "login":
                userLogin(request, response);
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

    private void register_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            user.setName(Utils.requiredNotNull(request.getParameter("txtFirstName") + " " + request.getParameter("txtLastName"), "Name should not be empty"));
            user.setMobile(Utils.requiredNotNull(request.getParameter("txtContact"), "Mobule number should not be empty"));
            user.setEmail(Utils.requiredNotNull(request.getParameter("txtEmail"), "Email should not be empty"));
            user.setPassword(Utils.requiredNotNull(request.getParameter("txtPass"), "Password should not be empty"));
            user.setEducation(Utils.requiredNotNull(request.getParameter("selectEdu") + " - " + request.getParameter("selectSem"), "Education should not be empty"));
            user.setCollege(Utils.requiredNotNull(request.getParameter("txtCollege"), "College should not be empty"));
            user.setCity(Utils.requiredNotNull(request.getParameter("txtCity"), "City should not be empty"));
            message = user_service.register_user(user);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.User_controller.register_user()" + e.getMessage();
        } finally {
            response.sendRedirect("login.jsp?message=" + message + " please login to continue");
        }
    }

    private void update_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            user.setUser_id(Utils.requiredNotNull(request.getParameter("user_id"), "User_id cannot be null"));
            user.setName(Utils.requiredNotNull(request.getParameter("txtUserName"), "Name should not be empty"));
            user.setMobile(Utils.requiredNotNull(request.getParameter("txtContact"), "Mobule number should not be empty"));
            user.setEmail(Utils.requiredNotNull(request.getParameter("txtEmail"), "Email should not be empty"));
            if ((Utils.isEmpty(request.getParameter("selectEdu")) && Utils.isEmpty(request.getParameter("selectSem"))) || (Utils.isEmpty(request.getParameter("selectEdu")) || Utils.isEmpty(request.getParameter("selectSem")))) {
                user.setEducation(Utils.requiredNotNull(request.getParameter("txtEducation"), "Education should not be empty"));
            } else {
                user.setEducation(Utils.requiredNotNull(request.getParameter("selectEdu") + " - " + request.getParameter("selectSem"), "Education should not be empty"));
            }
            user.setCollege(Utils.requiredNotNull(request.getParameter("txtCollege"), "College should not be empty"));
            user.setCity(Utils.requiredNotNull(request.getParameter("txtCity"), "City should not be empty"));
            message = user_service.update_user(user);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.User_controller.update_user()" + e.getMessage();
        } finally {
            response.sendRedirect("user_profile.jsp?message=" + message);
        }
    }

    private void delete_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            message = user_service.delete_user(Utils.requiredNotNull(request.getParameter("user_id"), "User_id cannot be null"));
        } catch (Exception e) {
            message = "com.qt.sad.controllers.User_controller.delete_user()" + e.getMessage();
        } finally {
            response.sendRedirect("login.jsp?message=" + message);
        }
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            user.setMobile(Utils.requiredNotNull(request.getParameter("user"), "Username should not be empty"));
            user.setPassword(Utils.requiredNotNull(request.getParameter("pass"), "Password should not be empty"));
            message = user_service.user_login(user, request);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.User_controller.userLogin()" + e.getMessage();
        } finally {
            if (message.equals(ResponseMessages.LOGIN_SUCCESS.getResponseMessages())) {
                response.sendRedirect("user_dashboard.jsp?message=" + message);
            } else {
                response.sendRedirect("login.jsp?message=" + message);
            }
        }

    }

    private void update_password(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (Utils.requiredNotNull(request.getParameter("new_password"), "Password must not be empty").equals(Utils.requiredNotNull(request.getParameter("confirmPassword"), "Password must not be empty"))) {
                user.setPassword(Utils.requiredNotNull(request.getParameter("new_password"), "Password should not be empty"));
                user.setUser_id(Utils.requiredNotNull(request.getParameter("user_id"), "User ID should not be empty"));
                message = user_service.updatePassword(user, Utils.requiredNotNull(request.getParameter("old_password"), "Password should not be empty"));
            } else {
                message = "Password did not matched";
            }
        } catch (Exception e) {
            message = "com.qt.sad.controllers.User_controller.update_password()::" + e.getMessage();
        } finally {
            response.sendRedirect("user_profile.jsp?message=" + message);
        }
    }

    private void change_status(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            message = user_service.changeProjectStatus(Utils.requiredNotNull(request.getParameter("user_id"), "User ID must not be null"),
                    Integer.parseInt(Utils.requiredNotNull(request.getParameter("project_status"), "Project Status must not be null")));
        } catch (NumberFormatException e) {
            message = "com.qt.sad.controllers.User_controller.change_status()::" + e.getMessage();
        } finally {
            response.sendRedirect("admin_subscriptions.jsp?message=" + message);
        }
    }

}
