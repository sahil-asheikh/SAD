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
public class Tblproject {

    private int id;
    private String project_id;
    private String user_id;
    private String project;
    private String created_at;
    private String modified_at;

    private String location;
    private String exception;

    public Tblproject(int id, String project_id, String user_id, String project, String created_at, String modified_at) {
        this.id = id;
        this.project_id = project_id;
        this.user_id = user_id;
        this.project = project;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Tblproject(String location, String exception) {
        this.location = location;
        this.exception = exception;
    }

    public Tblproject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
