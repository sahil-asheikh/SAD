/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tblproject;
import com.qt.sad.model.Tblsystemparameter;
import com.qt.sad.service.Project_service;
import com.qt.sad.service.System_Parameter_service;
import com.qt.sad.utility.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Azher
 */
@WebServlet(name = "Project_controller", urlPatterns = {"/Project_controller"})

@MultipartConfig        // have to user to get the name of the file
public class Project_controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DATA_DIRECTORY = "uploads";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 20000000 * 20000000;

    private final Tblproject project = new Tblproject();
    private final Project_service project_service = new Project_service();
    private String message;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        switch (action) {
            case "insert_project":
                insert_project(request, response);
                break;
            case "download_project":
                download_project(request, response);
                break;
        }
    }

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void insert_project(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System_Parameter_service system_Parameter_service = new System_Parameter_service();
        Tblsystemparameter systemparameters = system_Parameter_service.getParameterByName("path_project");
        String path = systemparameters.getSystem_parameter_value();
        String user_id = request.getParameter("user_id");
        try {
//            creating the object of Parts to get and read the resume name
            Part part = request.getPart("project_file");  //Part allows a particular implementation to use, for example, file renaming, file name fetch etc.
            String projectFileUploaded = part.getSubmittedFileName();  // getting the name of a file using Part Class
            String newProjectFileName = user_id + projectFileUploaded;

            if (Utils.checkFileType(projectFileUploaded, ".war") || Utils.checkFileType(projectFileUploaded, ".zip")) {
//              invoking the method to save the file name into the database
                this.project.setProject(Utils.requiredNotNull(newProjectFileName, "File name must not be empty"));
                this.project.setUser_id(Utils.requiredNotNull(user_id, "User ID must not be empty"));
                message = project_service.updateProjectFileName(project); // updating the file name into the database

                if (message.equals(ResponseMessages.DATA_ADDED.getResponseMessages())) {
//                    getting the name of the resume using Parts
                    InputStream is = part.getInputStream(); //it is used for reading a file, image, audio, video, webpage, etc.
                    byte[] data = new byte[is.available()]; //getting InputStream values into byte
                    is.read(data);      // reads the resume name

                    //FileOutputStream is used for writing streams of raw bytes such as image data, file data
                    FileOutputStream fos = new FileOutputStream(path + File.separator + projectFileUploaded);   // creating object with path and fileName parameters
                    fos.write(data);    // storing file at the path location
                    fos.close();    // closing the FileOutputStream

//                  renaming the resume with the unique name same as stored in database i.e. fileName
                    File file = new File(path + File.separator + projectFileUploaded);  // Create an object of the File class to Replace the file path with path of the directory
                    File rename = new File(path + File.separator + newProjectFileName);    // Create an object of the File class to Replace the file path with path of the directory
                    file.renameTo(rename);   //executing the file to change the name
                }
            } else {
                message = "Please upload correct file type";
            }
        } catch (IOException | ServletException e) {
            message = "com.qt.sad.controllers.Project_controller.insert_project()" + e.getMessage();
        } finally {
            response.sendRedirect("user_project.jsp?message=" + message);
        }
    }

    private void download_project(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String user_id = Utils.requiredNotNull(request.getParameter("user_id"), "User ID must not be zero");
            System_Parameter_service system_Parameter_service = new System_Parameter_service();
            Tblsystemparameter systemparameters = system_Parameter_service.getParameterByName("path_db");
            String path = systemparameters.getSystem_parameter_value();
            String project_path = path + File.separator + project_service.selectProjectPath(user_id);
            message = project_service.download_file(project_path, request, response);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.Project_controller.download_project()::" + e.getMessage();
        } finally {
            response.sendRedirect("admin_subscriptions.jsp?message=" + message);
        }
    }

}
