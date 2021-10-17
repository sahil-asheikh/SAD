/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.dao;

import com.qt.sad.database.Saddu;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tblsubdomain;
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
public class TblSubdomain_dao {

    private final String TABLENAME = Tblsubdomain.class.getSimpleName().toLowerCase();
    private Connection con;
    private String sql, message;
    private CallableStatement cs;
    private ResultSet rs;
    private int i;

    public String insert_subdomain(Tblsubdomain subdomain) {
        con = Saddu.connectDb();
        sql = "INSERT INTO " + TABLENAME + " ( subdomain_id, user_id, subdomain) VALUES (?, ?, ?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, Utils.generatePublicId(30));
            cs.setString(2, subdomain.getUser_id());
            cs.setString(3, subdomain.getSubdomain());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_ADDED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.insert_subdomain()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.insert_subdomain()::" + e.getMessage();
            }
        }
        return message;
    }

    public List<Tblsubdomain> select_subdomains() {
        ArrayList<Tblsubdomain> subdomains = new ArrayList<>();
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Tblsubdomain subdomain = new Tblsubdomain(
                        rs.getInt("id"),
                        rs.getString("subdomain_id"),
                        rs.getString("user_id"),
                        rs.getString("subdomain"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
                subdomains.add(subdomain);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.select_subdomains()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.select_subdomains()::" + e.getMessage();
            }
        }
        return subdomains;
    }

    public Tblsubdomain select_subdomain(String subdomain_id) {
        Tblsubdomain subdomain = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where subdomain_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, subdomain_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                subdomain = new Tblsubdomain(
                        rs.getInt("id"),
                        rs.getString("subdomain_id"),
                        rs.getString("user_id"),
                        rs.getString("subdomain"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.select_subdomain()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.select_subdomain()::" + e.getMessage();
            }
        }
        return subdomain;
    }

    public String update_subdomain(Tblsubdomain subdomain) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET user_id = ?, subdomain = ? WHERE subdomain_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, subdomain.getUser_id());
            cs.setString(2, subdomain.getSubdomain());
            cs.setString(3, subdomain.getSubdomain_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.update_subdomain()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.update_subdomain()::" + e.getMessage();
            }
        }
        return message;
    }

    public String delte_subdomain(String subdomain_id) {
        con = Saddu.connectDb();
        sql = "DELETE FROM " + TABLENAME + " WHERE subdomain_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, subdomain_id);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_DELETED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.delete_subdomain()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.delete_subdomain()::" + e.getMessage();
            }
        }
        return message;
    }

    public Tblsubdomain selectByUserId(String user_id) {
        Tblsubdomain subdomain = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                subdomain = new Tblsubdomain(
                        rs.getInt("id"),
                        rs.getString("subdomain_id"),
                        rs.getString("user_id"),
                        rs.getString("subdomain"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.selectByUserId()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.selectByUserId()::" + e.getMessage();
            }
        }
        return subdomain;
    }

    public boolean checkSubdomainByUserId(String user_id) {
        boolean subdomain_avail = false;
        con = Saddu.connectDb();
        sql = "select * from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                subdomain_avail = true;
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.selectByUserId()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.selectByUserId()::" + e.getMessage();
            }
        }
        return subdomain_avail;
    }

    public boolean checkDomain(Tblsubdomain subdomain) {
        con = Saddu.connectDb();
        sql = "select * from " + TABLENAME + " where subdomain = ?";
        boolean subdomain_avail = false;
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, subdomain.getSubdomain());
            rs = cs.executeQuery();
            if (rs.next()) {
                subdomain_avail = true;
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.checkDomain()" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.checkDomain()" + e.getMessage();
            }
        }
        return subdomain_avail;
    }

    public String selectSubdomainName(String user_id) {
        String name = null;
        con = Saddu.connectDb();
        sql = "select subdomain from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                name = rs.getString("subdomain");
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblSubdomain_dao.selectSubdomainName()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblSubdomain_dao.selectSubdomainName()::" + e.getMessage();
            }
        }
        return name;
    }

}
