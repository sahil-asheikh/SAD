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
public class Tbldb {

    private int id;
    private String db_id;
    private String user_id;
    private String dbname;
    private String db_username;
    private String db_password;
    private String db;
    private String created_at;
    private String modified_at;

    private String location;
    private String exception;

    public Tbldb(int id, String db_id, String user_id, String dbname, String db_username, String db_password, String db, String created_at, String modified_at) {
        this.id = id;
        this.db_id = db_id;
        this.user_id = user_id;
        this.dbname = dbname;
        this.db_username = db_username;
        this.db_password = db_password;
        this.db = db;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Tbldb(String location, String exception) {
        this.location = location;
        this.exception = exception;
    }

    public Tbldb() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDb_id() {
        return db_id;
    }

    public void setDb_id(String db_id) {
        this.db_id = db_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDb_username() {
        return db_username;
    }

    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
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
