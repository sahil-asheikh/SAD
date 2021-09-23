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
public class ProjectBean {

    private int id;
    private int studId;
    private int subDomainId;
    private String project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public int getSubDomainId() {
        return subDomainId;
    }

    public void setSubDomainId(int subDomainId) {
        this.subDomainId = subDomainId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

}
