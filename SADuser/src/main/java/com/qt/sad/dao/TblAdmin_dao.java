/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.dao;

import com.qt.sad.database.Saddu;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbladmin;
import com.qt.sad.utility.Utils;
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
public class TblAdmin_dao {

    private final String TABLENAME = Tbladmin.class.getSimpleName().toLowerCase();
    private Connection con;
    private String sql, message;
    private CallableStatement cs;
    private ResultSet rs;
    private int i;

    public String insert_admin(Tbladmin admin) {
        con = Saddu.connectDb();
        sql = "INSERT INTO " + TABLENAME + " (admin_id, mobile, name, password) VALUES( ?, ?, ?, ?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, Utils.generatePublicId(30));
            cs.setString(2, admin.getMobile());
            cs.setString(3, admin.getName());
            cs.setString(4, admin.getPassword());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_ADDED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.insert_tbladmin()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.insert_tbladmin()::" + e.getMessage();
            }
        }
        return message;
    }

    public List<Tbladmin> select_admins() {
        ArrayList<Tbladmin> admins = new ArrayList<>();
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Tbladmin admin = new Tbladmin(
                        rs.getString("admin_id"),
                        rs.getString("mobile"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("attempts"),
                        rs.getInt("is_deleted"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
                admins.add(admin);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.select_allAdmins()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.select_allAdmins()::" + e.getMessage();
            }
        }
        return admins;
    }

    public Tbladmin select_admin(String admin_id) {
        Tbladmin admin = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where admin_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, admin_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                admin = new Tbladmin(
                        rs.getString("admin_id"),
                        rs.getString("mobile"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("attempts"),
                        rs.getInt("is_deleted"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.select_tbladmin()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.select_tbladmin()::" + e.getMessage();
            }
        }
        return admin;
    }

    public Tbladmin select_adminByMobile(String mobile) {
        Tbladmin admin = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where mobile = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, mobile);
            rs = cs.executeQuery();
            while (rs.next()) {
                admin = new Tbladmin(
                        rs.getString("admin_id"),
                        rs.getString("mobile"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("attempts"),
                        rs.getInt("is_deleted"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.select_tbladmin()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.select_tbladmin()::" + e.getMessage();
            }
        }
        return admin;
    }

    public String update_admin(Tbladmin admin) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET mobile = ?, name = ?, password = ? WHERE admin_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, admin.getMobile());
            cs.setString(2, admin.getName());
            cs.setString(3, admin.getPassword());
            cs.setString(4, admin.getAdmin_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.update_tbladmin()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.update_tbladmin()::" + e.getMessage();
            }
        }
        return message;
    }

    public String delte_admin(Tbladmin admin) {
        con = Saddu.connectDb();
        sql = "DELETE FROM " + TABLENAME + " WHERE admin_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, admin.getAdmin_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_DELETED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.delte_tbladmin()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.delte_tbladmin()::" + e.getMessage();
            }
        }
        return message;
    }

    public int reset_attempts(String admin_id) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET attempts = 0 WHERE admin_id = ?;";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, admin_id);
            i = cs.executeUpdate();
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.reset_attempts()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.reset_attempts()::" + e.getMessage();
            }
        }
        return i;
    }

    public int increase_attempts(String admin_id, int attempts) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET attempts = ? WHERE admin_id = ?;";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, attempts + 1);
            cs.setString(2, admin_id);
            i = cs.executeUpdate();
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblAdmin_dao.increase_attempts()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblAdmin_dao.increase_attempts()::" + e.getMessage();
            }
        }
        return i;
    }

}
