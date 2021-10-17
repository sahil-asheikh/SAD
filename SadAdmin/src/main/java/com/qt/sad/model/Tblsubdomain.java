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
public class Tblsubdomain {

    private int id;
    private String subdomain_id;
    private String user_id;
    private String subdomain;
    private String created_at;
    private String modified_at;

    private String location;
    private String exception;

    public Tblsubdomain(int id, String subdomain_id, String user_id, String subdomain, String created_at, String modified_at) {
        this.id = id;
        this.subdomain_id = subdomain_id;
        this.user_id = user_id;
        this.subdomain = subdomain;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Tblsubdomain(String location, String exception) {
        this.location = location;
        this.exception = exception;
    }

    public Tblsubdomain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubdomain_id() {
        return subdomain_id;
    }

    public void setSubdomain_id(String subdomain_id) {
        this.subdomain_id = subdomain_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
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
