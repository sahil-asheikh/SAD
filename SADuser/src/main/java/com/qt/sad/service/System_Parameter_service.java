/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.service;

import com.qt.sad.dao.System_Parameter_dao;
import com.qt.sad.model.Tblsystemparameter;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class System_Parameter_service {

    System_Parameter_dao system_Parameter_dao = new System_Parameter_dao();

    public String saveSystemParameter(String sp_name, String sp_value) {
        if (system_Parameter_dao.checkSyatemParameterName(sp_name)) {
            return "System Parameter Name is already available";
        } else {
            return system_Parameter_dao.insertSystemParameter(sp_name, sp_value);
        }
    }

    public String updateSystemParameter(String sp_name, String sp_value) {
        if (system_Parameter_dao.checkSyatemParameterName(sp_name)) {
            return system_Parameter_dao.updateSystemParameter(sp_name, sp_value);
        } else {
            return "System Parameter Name not found";
        }
    }

    public String deleteSystemParameter(String sp_name) {
        if (system_Parameter_dao.checkSyatemParameterName(sp_name)) {
            return system_Parameter_dao.deleteSystemParameter(sp_name);
        } else {
            return "System Parameter Name not found";
        }
    }

    public List<Tblsystemparameter> select_system_parameters() {
        return system_Parameter_dao.select_system_parameters();
    }

    public Tblsystemparameter getParameterByName(String sp_name) {
        return system_Parameter_dao.getParameterByName(sp_name);
    }

}
