/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.service;

import com.qt.sad.dao.TblUser_dao;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbluser;
import com.qt.sad.utility.Utils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class User_service {

    Tbluser user = new Tbluser();
    TblUser_dao user_dao = new TblUser_dao();

    public String register_user(Tbluser user) {
        this.user.setUser_id(Utils.generatePublicId(30));
        this.user.setName(user.getName());
        this.user.setMobile(user.getMobile());
        this.user.setEmail(user.getEmail());
        this.user.setPassword(user.getPassword());
        this.user.setEducation(user.getEducation());
        this.user.setCollege(user.getCollege());
        this.user.setCity(user.getCity());
        return user_dao.insert_user(this.user);
    }

    public String update_user(Tbluser user) {
        this.user.setUser_id(user.getUser_id());
        this.user.setName(user.getName());
        this.user.setMobile(user.getMobile());
        this.user.setEmail(user.getEmail());
        this.user.setEducation(user.getEducation());
        this.user.setCollege(user.getCollege());
        this.user.setCity(user.getCity());
        return user_dao.update_user(this.user);
    }

    public String delete_user(String user_id) {
        return user_dao.delete_user(Utils.requiredNotNull(user_id, "User id cannot be null"));
    }

    public List<Tbluser> select_users() {
        return user_dao.select_users();
    }

    public Tbluser select_user(String user_id) {
        return user_dao.select_user(user_id);
    }

    public String user_login(Tbluser user, HttpServletRequest request) {
        Tbluser existUser = user_dao.findByMobile(user.getMobile());
        if (existUser == null) {
            return ResponseMessages.USER_NOT_FOUND.getResponseMessages();
        } else {
            if (existUser.getAttempts() >= 5) {
                return ResponseMessages.BLOCKED_ACCOUNT.getResponseMessages();
            } else if (existUser.getIs_deleted() == 1) {
                return ResponseMessages.USER_NOT_FOUND.getResponseMessages();
            } else {
                if (existUser.getMobile().equals(user.getMobile()) && existUser.getPassword().equals(user.getPassword())) {
                    int i = user_dao.reset_attempts(existUser.getUser_id());
                    if (i == 1) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user_name", existUser.getName());
                        session.setAttribute("user_id", existUser.getUser_id());
                        return ResponseMessages.LOGIN_SUCCESS.getResponseMessages();
                    } else {
                        return ResponseMessages.OPERATION_FAILED.getResponseMessages();
                    }
                } else {
                    int i = user_dao.increase_attempt(existUser.getUser_id(), existUser.getAttempts());
                    if (i == 1) {
                        return ResponseMessages.LOGIN_FAILED.getResponseMessages();
                    } else {
                        return ResponseMessages.OPERATION_FAILED.getResponseMessages();
                    }
                }
            }
        }
    }

    public boolean checkNewPassword(String old_password, String user_id) {
        if (user_dao.checkPassword(old_password, user_id)) {
            return true;
        } else {
            return false;
        }
    }

    public String updatePassword(Tbluser user, String old_password) {
        if (checkNewPassword(old_password, user.getUser_id())) {
            this.user.setPassword(user.getPassword());
            this.user.setUser_id(user.getUser_id());
            return user_dao.updatePassword(this.user);
        } else {
            return "Incorrect password";
        }
    }

    public String changeProjectStatus(String user_id, int status) {
        return user_dao.changeProjectStatus(user_id, status);
    }

    public int countUsers() {
        return user_dao.countUsers();
    }

    public int countRejectedProjects() {
        return user_dao.countRejectedProjects();
    }

    public int countApprovedProjects() {
        return user_dao.countApprovedProjects();
    }

    public int countPendingProjects() {
        return user_dao.countPendingProjects();
    }

}
