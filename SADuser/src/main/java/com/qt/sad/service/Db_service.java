/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.service;

import com.qt.sad.dao.TblDb_dao;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbldb;
import com.qt.sad.utility.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author LENOVO
 */
public class Db_service {

    TblDb_dao db_dao = new TblDb_dao();

    public Tbldb select_db(String db_id) {
        return db_dao.select_database(Utils.requiredNotNull(db_id, "Database id cannot be null"));
    }

    public String insert_db(Tbldb db) {
        return db_dao.insert_db(db);
    }

    public Tbldb selectByUserId(String user_id) {
        return db_dao.selectByUserId(user_id);
    }

    public boolean checkDbByUserId(String user_id) {
        return db_dao.checkDbByUserId(Utils.requiredNotNull(user_id, "User id cannot be null"));
    }

    public String updateDbFileName(Tbldb db) {
        return db_dao.insert_db(db);
    }

    public String selectDbName(String user_id) {
        return db_dao.selectDbName(user_id);
    }

    public String selectDbPath(String user_id) {
        return db_dao.selectDbPath(user_id);
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

    public String saveFile(Tbldb db, Part part, String path, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = null;
        Db_service db_service = new Db_service();

        return message;
    }

}
