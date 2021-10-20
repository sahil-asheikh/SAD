/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.controllers;

import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbldb;
import com.qt.sad.model.Tblsystemparameter;
import com.qt.sad.service.Db_service;
import com.qt.sad.service.System_Parameter_service;
import com.qt.sad.utility.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Azher
 */
@WebServlet(name = "Db_controller", urlPatterns = {"/Db_controller"})

@MultipartConfig
public class Db_controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DATA_DIRECTORY = "database";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 20000000 * 20000000;

    private final Tbldb db = new Tbldb();
    private final Db_service db_service = new Db_service();
    private String message;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case "insert_database":
                insert_database(request, response);
                break;
            case "downoad_database":
                download_database(request, response);
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

    private void save_db(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + DATA_DIRECTORY;

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            ArrayList<String> strings = new ArrayList<>();
            ArrayList<String> myimgs = new ArrayList<>();

            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;   //add str subD for Uniqueness
                    File uploadedFile = new File(filePath);
                    // saves the file to upload directory
                    item.write(uploadedFile);
                    myimgs.add(filePath);
                    System.out.println("filepath : " + filePath);
                } else {
                    strings.add(item.getString());
                }
            }
            Tbldb db = new Tbldb();
            Db_service db_service = new Db_service();

            db.setUser_id(Utils.requiredNotNull(strings.get(0), "User id cannot be null"));
            db.setDbname((strings.get(1)));
            db.setDb(myimgs.get(0) + "-" + strings.get(3));
            db_service.insert_db(db);

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void insert_database(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            System_Parameter_service system_Parameter_service = new System_Parameter_service();
            Tblsystemparameter systemparameters = system_Parameter_service.getParameterByName("path_db");
            String path = systemparameters.getSystem_parameter_value();
            String user_id = request.getParameter("user_id");
            String db_name = request.getParameter("db_name");
            String db_username = request.getParameter("db_username");
            String db_password = request.getParameter("db_password");
            Part part = request.getPart("database_file");  //Part allows a particular implementation to use, for example, file renaming, file name fetch etc.

            if (db_service.checkDbByUserId(Utils.requiredNotNull(user_id, "User ID must not be empty"))) {
                message = "You already have uploaded your database";
            } else {
//            creating the object of Parts to get and read the resume name
                String dbFileUploaded = part.getSubmittedFileName();  // getting the name of a file using Part Class
                String newDbFileName = user_id + dbFileUploaded;

                if (Utils.checkFileType(dbFileUploaded, ".sql") || Utils.checkFileType(dbFileUploaded, ".zip")) {

//              invoking the method to save the file name into the database
                    this.db.setDb(Utils.requiredNotNull(newDbFileName, "File name must not be empty"));
                    this.db.setUser_id(Utils.requiredNotNull(user_id, "User ID must not be empty"));
                    this.db.setDbname(Utils.requiredNotNull(db_name, "Database name must not be empty"));
                    this.db.setDb_username(Utils.requiredNotNull(db_username, "Username must not be empty"));
                    this.db.setDb_password(Utils.requiredNotNull(db_password, "Password must not be empty"));
                    message = db_service.updateDbFileName(db); // updating the file name into the database

                    if (message.equals(ResponseMessages.DATA_ADDED.getResponseMessages())) {
//                    getting the name of the resume using Parts
                        InputStream is = part.getInputStream(); //it is used for reading a file, image, audio, video, webpage, etc.
                        byte[] data = new byte[is.available()]; //getting InputStream values into byte
                        is.read(data);      // reads the resume name

                        //FileOutputStream is used for writing streams of raw bytes such as image data, file data
                        FileOutputStream fos = new FileOutputStream(path + File.separator + dbFileUploaded);   // creating object with path and fileName parameters
                        fos.write(data);    // storing file at the path location
                        fos.close();    // closing the FileOutputStream

//                  renaming the resume with the unique name same as stored in database i.e. fileName
                        File file = new File(path + File.separator + dbFileUploaded);  // Create an object of the File class to Replace the file path with path of the directory
                        File rename = new File(path + File.separator + newDbFileName);    // Create an object of the File class to Replace the file path with path of the directory
                        file.renameTo(rename);   //executing the file to change the name
                    }
                } else {
                    message = "Please upload correct file type";
                }
            }

        } catch (IOException | ServletException e) {
            message = "com.qt.sad.controllers.Project_controller.insert_project()" + e.getMessage();
        } finally {
            response.sendRedirect("user_database.jsp?message=" + message);
        }
    }

    private void download_database(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String user_id = Utils.requiredNotNull(request.getParameter("user_id"), "User ID must not be zero");
            System_Parameter_service system_Parameter_service = new System_Parameter_service();
            Tblsystemparameter systemparameters = system_Parameter_service.getParameterByName("path_db");
            String path = systemparameters.getSystem_parameter_value();
            String db_path = path + File.separator + db_service.selectDbPath(user_id);
            message = db_service.download_file(db_path, request, response);
        } catch (Exception e) {
            message = "com.qt.sad.controllers.Db_controller.download_project()::" + e.getMessage();
        } finally {
            response.sendRedirect("admin_subscriptions.jsp?message=" + message);
        }
    }

}
