/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.service;

import com.qt.sad.dao.TblProject_dao;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tblproject;
import com.qt.sad.utility.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class Project_service {

    TblProject_dao project_dao = new TblProject_dao();

    public void insert_project(Tblproject project) {
        this.project_dao.insert_project(project);
    }

    public Tblproject select_project(String project_id) {
        return project_dao.select_project(project_id);
    }

    public Tblproject selectByUserId(String user_id) {
        return project_dao.selectByUserId(user_id);
    }

    public boolean checkProjectByUserId(String user_id) {
        return project_dao.checkProjectByUserId(user_id);
    }

    public String updateProjectFileName(Tblproject project) {
        return project_dao.insert_project(project);
    }

    public int countProjects() {
        return project_dao.countProjects();
    }

    public String selectProjectPath(String user_id) {
        return project_dao.selectProjectPath(user_id);
    }

    public String download_file(String filePath, HttpServletRequest request, HttpServletResponse response) {
        String message;
        if (Utils.checkFilePath(filePath)) {
            try {
                File downloadFile = new File(filePath);
                OutputStream outStream;
                // if you want to use a relative path to context root:
                try (FileInputStream inStream = new FileInputStream(downloadFile)) {
                    // if you want to use a relative path to context root:
                    String relativePath = request.getServletContext().getRealPath("");
                    System.out.println("relativePath = " + relativePath);
                    // obtains ServletContext
                    ServletContext context = request.getServletContext();
                    // gets MIME type of the file
                    String mimeType = context.getMimeType(filePath);
                    if (mimeType == null) {
                        // set to binary type if MIME mapping not found
                        mimeType = "application/octet-stream";
                    }
                    System.out.println("MIME type: " + mimeType);
                    // modifies response
                    response.setContentType(mimeType);
                    response.setContentLength((int) downloadFile.length());
                    // forces download
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
                    response.setHeader(headerKey, headerValue);
                    // obtains response's output stream
                    outStream = response.getOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                }
                message = ResponseMessages.FILE_DOWNLOADED.getResponseMessages();
                outStream.close();
            } catch (IOException e) {
                message = "com.begawo.file.management.DownloadServlet.processRequest()::" + e.getMessage();
            }
        } else {
            message = ResponseMessages.FILE_NOT_FOUND.getResponseMessages();
        }
        return message;
    }

}
