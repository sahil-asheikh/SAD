/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.service;

import com.qt.sad.dao.TblAdmin_dao;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbladmin;
import com.qt.sad.utility.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class Admin_service {

    TblAdmin_dao admin_dao = new TblAdmin_dao();
    String message;

    public String admin_login(Tbladmin admin, HttpServletRequest request) {
        Tbladmin existAdmin = admin_dao.select_adminByMobile(admin.getMobile());
        if (existAdmin == null) {
            return ResponseMessages.USER_NOT_FOUND.getResponseMessages();
        } else {
            if (existAdmin.getAttempts() >= 5) {
                return ResponseMessages.BLOCKED_ACCOUNT.getResponseMessages();
            } else if (existAdmin.getIs_deleted() == 1) {
                return ResponseMessages.USER_NOT_FOUND.getResponseMessages();
            } else {
                if ((existAdmin.getPassword().equals(admin.getPassword()))) {
                    int i = admin_dao.reset_attempts(existAdmin.getAdmin_id());
                    if (i == 1) {
                        HttpSession session = request.getSession();
                        session.setAttribute("admin_id", existAdmin.getAdmin_id());
                        return ResponseMessages.LOGIN_SUCCESS.getResponseMessages();
                    } else {
                        return ResponseMessages.OPERATION_FAILED.getResponseMessages();
                    }
                } else {
                    int i = admin_dao.increase_attempts(existAdmin.getAdmin_id(), existAdmin.getAttempts());
                    if (i == 1) {
                        return ResponseMessages.LOGIN_FAILED.getResponseMessages();
                    } else {
                        return ResponseMessages.OPERATION_FAILED.getResponseMessages();
                    }
                }
            }
        }
    }

}
