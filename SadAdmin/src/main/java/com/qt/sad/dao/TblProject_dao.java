/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.dao;

import com.qt.sad.database.Saddu;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tblproject;
import com.qt.sad.utility.Utils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azher
 */
public class TblProject_dao {

    private final String TABLENAME = Tblproject.class.getSimpleName().toLowerCase();
    private Connection con;
    private String sql, message;
    private CallableStatement cs;
    private ResultSet rs;
    private int i;

    public String insert_project(Tblproject project) {
        con = Saddu.connectDb();
        sql = "INSERT INTO " + TABLENAME + " ( project_id, user_id, project) VALUES (?, ?, ?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, Utils.generatePublicId(30));
            cs.setString(2, project.getUser_id());
            cs.setString(3, project.getProject());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_ADDED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.insert_project()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.insert_project()::" + e.getMessage();
            }
        }
        return message;
    }

    public List<Tblproject> select_projects() {
        ArrayList<Tblproject> projects = new ArrayList<>();
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Tblproject project = new Tblproject(
                        rs.getInt("id"),
                        rs.getString("project_id"),
                        rs.getString("user_id"),
                        rs.getString("project"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
                projects.add(project);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.select_project()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.select_project()::" + e.getMessage();
            }
        }
        return projects;
    }

    public Tblproject select_project(String project_id) {
        Tblproject project = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where project_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, project_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                project = new Tblproject(
                        rs.getInt("id"),
                        rs.getString("project_id"),
                        rs.getString("user_id"),
                        rs.getString("project"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.select_project()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.select_project()::" + e.getMessage();
            }
        }
        return project;
    }

    public String update_project(Tblproject project) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET user_id = ?, project = ? WHERE project_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, project.getUser_id());
            cs.setString(2, project.getProject());
            cs.setString(4, project.getProject_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.update_project()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.update_project()::" + e.getMessage();
            }
        }
        return message;
    }

    public String delte_project(String project_id) {
        con = Saddu.connectDb();
        sql = "DELETE FROM " + TABLENAME + " WHERE project_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, project_id);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_DELETED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.delte_project()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.delte_project()::" + e.getMessage();
            }
        }
        return message;
    }

    public Tblproject selectByUserId(String user_id) {
        Tblproject project = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                project = new Tblproject(
                        rs.getInt("id"),
                        rs.getString("project_id"),
                        rs.getString("user_id"),
                        rs.getString("project"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.selectByUserId()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.selectByUserId()::" + e.getMessage();
            }
        }
        return project;
    }

    public boolean checkProjectByUserId(String user_id) {
        boolean project_avail = false;
        con = Saddu.connectDb();
        sql = "select project_id from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                project_avail = true;
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.checkProjectByUserId()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.checkProjectByUserId()::" + e.getMessage();
            }
        }
        return project_avail;
    }

    public int countProjects() {
        con = Saddu.connectDb();
        sql = "select count(*) from " + TABLENAME;
        int count = 0;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.countProjects()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.countProjects()::" + e.getMessage();
            }
        }
        return count;
    }

    public String selectProjectPath(String user_id) {
        con = Saddu.connectDb();
        sql = "select project from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                message = rs.getString("project");
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblProject_dao.selectProjectPath()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblProject_dao.selectProjectPath()::" + e.getMessage();
            }
        }
        return message;
    }

}
