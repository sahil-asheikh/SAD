/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.model;

/**
 *
 * @author LENOVO
 */
public class Tbladmin {

    private int id;
    private String admin_id;
    private String mobile;
    private String name;
    private String password;
    private int attempts;
    private int is_deleted;
    private String created_at;
    private String modified_at;

    private String location;
    private String exception;

    public Tbladmin(String admin_id, String mobile, String name, String password, int attempts, int is_deleted, String created_at, String modified_at) {
        this.admin_id = admin_id;
        this.mobile = mobile;
        this.name = name;
        this.password = password;
        this.attempts = attempts;
        this.is_deleted = is_deleted;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Tbladmin(String location, String exception) {
        this.location = location;
        this.exception = exception;
    }

    public Tbladmin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

}
