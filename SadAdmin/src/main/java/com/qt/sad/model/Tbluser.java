/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.model;

/**
 *
 * @author Azher
 */
public class Tbluser {

    private int id;
    private String user_id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private String education;
    private String college;
    private String city;
    private int is_deleted;
    private int attempts;
    private int project_status;
    private String created_at;
    private String modified_at;

    private String location;
    private String exception;

    public Tbluser(int id, String user_id, String name, String mobile, String email, String password, String education, String college, String city, int project_status, String created_at, String modified_at) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.education = education;
        this.college = college;
        this.city = city;
        this.project_status = project_status;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Tbluser(String location, String exception) {
        this.location = location;
        this.exception = exception;
    }

    public Tbluser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getProject_status() {
        return project_status;
    }

    public void setProject_status(int project_status) {
        this.project_status = project_status;
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
