/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.dao;

import com.qt.sad.database.Saddu;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tblsystemparameter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class System_Parameter_dao {

    Tblsystemparameter systemparameter = new Tblsystemparameter();
    private static final String TABLENAME = Tblsystemparameter.class.getSimpleName().toLowerCase();
    String sql;
    String message;
    int i;
    Connection con;
    CallableStatement cs;
    ResultSet rs;

    public boolean checkSyatemParameterName(String sp_name) {
        con = Saddu.connectDb();
        sql = "select * from " + TABLENAME + " where system_parameter_name = ?";
        boolean check = false;
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, sp_name);
            rs = cs.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.System_Parameter_dao.checkSyatemParameterName()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.System_Parameter_dao.checkSyatemParameterName()::" + e.getMessage();
            }
        }
        return check;
    }

    public String updateSystemParameter(String sp_name, String sp_value) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET system_parameter_value = ? WHERE system_parameter_name = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, sp_value);
            cs.setString(2, sp_name);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            } else {
                message = ResponseMessages.OPERATION_FAILED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.System_Parameter_dao.updateSystemParameter()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.System_Parameter_dao.updateSystemParameter()::" + e.getMessage();
            }
        }
        return message;
    }

    public String insertSystemParameter(String sp_name, String sp_value) {
        con = Saddu.connectDb();
        sql = "INSERT INTO " + TABLENAME + " (system_parameter_name, system_parameter_value) VALUES (?, ?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, sp_name);
            cs.setString(2, sp_value);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_ADDED.getResponseMessages();
            } else {
                message = ResponseMessages.OPERATION_FAILED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.System_Parameter_dao.insertSystemParameter()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.System_Parameter_dao.insertSystemParameter()::" + e.getMessage();
            }
        }
        return message;
    }

    public String deleteSystemParameter(String sp_name) {
        con = Saddu.connectDb();
        sql = "delete from " + TABLENAME + " where system_parameter_name = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, sp_name);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_DELETED.getResponseMessages();
            } else {
                message = ResponseMessages.OPERATION_FAILED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.System_Parameter_dao.deleteSystemParameter()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.System_Parameter_dao.deleteSystemParameter()::" + e.getMessage();
            }
        }
        return message;
    }

    public List<Tblsystemparameter> select_system_parameters() {
        ArrayList<Tblsystemparameter> parameters = new ArrayList<>();
        con = Saddu.connectDb();
        sql = "select * from " + TABLENAME;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Tblsystemparameter parameter = new Tblsystemparameter(
                        rs.getInt("id"),
                        rs.getString("system_parameter_name"),
                        rs.getString("system_parameter_value"),
                        rs.getString("created_at"),
                        rs.getString("modified_at"));
                parameters.add(parameter);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.System_Parameter_dao.select_system_parameters()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.System_Parameter_dao.select_system_parameters()::" + e.getMessage();
            }
        }
        return parameters;
    }

    public Tblsystemparameter selectParameterByName(String sp_name) {
        Tblsystemparameter parameter = new Tblsystemparameter();
        con = Saddu.connectDb();
        sql = "select * from " + TABLENAME + " where system_parameter_name = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, sp_name);
            rs = cs.executeQuery();
            if (rs.next()) {
                parameter.setSystem_parameter_name(rs.getString("system_parameter_name"));
                parameter.setSystem_parameter_value(rs.getString("system_parameter_value"));
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.System_Parameter_dao.selectParameterByName()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.System_Parameter_dao.selectParameterByName()::" + e.getMessage();
            }
        }
        return parameter;
    }

}
