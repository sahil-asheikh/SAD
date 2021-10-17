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
public class Tblsystemparameter {

    private int id;
    private String system_parameter_name;
    private String system_parameter_value;
    private String created_at;
    private String modified_at;

    public Tblsystemparameter(int id, String system_parameter_name, String system_parameter_value, String created_at, String modified_at) {
        this.id = id;
        this.system_parameter_name = system_parameter_name;
        this.system_parameter_value = system_parameter_value;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Tblsystemparameter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSystem_parameter_name() {
        return system_parameter_name;
    }

    public void setSystem_parameter_name(String system_parameter_name) {
        this.system_parameter_name = system_parameter_name;
    }

    public String getSystem_parameter_value() {
        return system_parameter_value;
    }

    public void setSystem_parameter_value(String system_parameter_value) {
        this.system_parameter_value = system_parameter_value;
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

}
