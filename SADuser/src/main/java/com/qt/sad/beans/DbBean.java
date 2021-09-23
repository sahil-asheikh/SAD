/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.beans;

/**
 *
 * @author Azher
 */
public class DbBean {

    private int id;
    private int studid;
    private int subDomainId;
    private int projectId;
    private String dbName;
    private String dbfile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudid() {
        return studid;
    }

    public void setStudid(int studid) {
        this.studid = studid;
    }

    public int getSubDomainId() {
        return subDomainId;
    }

    public void setSubDomainId(int subDomainId) {
        this.subDomainId = subDomainId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbfile() {
        return dbfile;
    }

    public void setDbfile(String dbfile) {
        this.dbfile = dbfile;
    }

}
