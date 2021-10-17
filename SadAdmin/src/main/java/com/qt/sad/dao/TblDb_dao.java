/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.dao;

import com.qt.sad.database.Saddu;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbldb;
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
public class TblDb_dao {

    private final String TABLENAME = Tbldb.class.getSimpleName().toLowerCase();
    private Connection con;
    private String sql, message;
    private CallableStatement cs;
    private ResultSet rs;
    private int i;

    public String insert_db(Tbldb database) {
        con = Saddu.connectDb();
        sql = "INSERT INTO " + TABLENAME + " (db_id, user_id, dbname, db_username, db_password, db) VALUES (?,?,?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, Utils.generatePublicId(30));
            cs.setString(2, database.getUser_id());
            cs.setString(3, database.getDbname());
            cs.setString(4, database.getDb_username());
            cs.setString(5, database.getDb_password());
            cs.setString(6, database.getDb());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_ADDED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.insert_db()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.insert_db()::" + e.getMessage();
            }
        }
        return message;
    }

    public List<Tbldb> select_databases() {
        ArrayList<Tbldb> databases = new ArrayList<>();
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Tbldb database = new Tbldb(
                        rs.getInt("id"),
                        rs.getString("db_id"),
                        rs.getString("user_id"),
                        rs.getString("dbname"),
                        rs.getString("db_username"),
                        rs.getString("db_password"),
                        rs.getString("db"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
                databases.add(database);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.select_databases()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.select_databases()::" + e.getMessage();
            }
        }
        return databases;
    }

    public Tbldb select_database(String db_id) {
        Tbldb database = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where db_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, db_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                database = new Tbldb(
                        rs.getInt("id"),
                        rs.getString("db_id"),
                        rs.getString("user_id"),
                        rs.getString("dbname"),
                        rs.getString("db_username"),
                        rs.getString("db_password"),
                        rs.getString("db"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.select_database()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.select_database()::" + e.getMessage();
            }
        }
        return database;
    }

    public String update_db(Tbldb database) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET user_id = ?, dbname = ?, db = ? WHERE db_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, database.getUser_id());
            cs.setString(2, database.getDbname());
            cs.setString(3, database.getDb());
            cs.setString(4, database.getDb_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.update_db()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.update_db()::" + e.getMessage();
            }
        }
        return message;
    }

    public String delte_db(String db_id) {
        con = Saddu.connectDb();
        sql = "DELETE FROM " + TABLENAME + " WHERE db_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, db_id);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_DELETED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.delte_db()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.delte_db()::" + e.getMessage();
            }
        }
        return message;
    }

    public Tbldb selectByUserId(String user_id) {
        Tbldb database = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                database = new Tbldb(
                        rs.getInt("id"),
                        rs.getString("db_id"),
                        rs.getString("user_id"),
                        rs.getString("dbname"),
                        rs.getString("db_username"),
                        rs.getString("db_password"),
                        rs.getString("db"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.selectByUserId()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.selectByUserId()::" + e.getMessage();
            }
        }
        return database;
    }

    public boolean checkDbByUserId(String user_id) {
        boolean database_avail = false;
        con = Saddu.connectDb();
        sql = "select db_id from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                database_avail = true;
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.selectByUserId()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.selectByUserId()::" + e.getMessage();
            }
        }
        return database_avail;
    }

    public String selectDbName(String user_id) {
        String name = null;
        con = Saddu.connectDb();
        sql = "select dbname from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            while (rs.next()) {
                name = rs.getString("dbname");
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.selectDbName()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.selectDbName()::" + e.getMessage();
            }
        }
        return name;
    }

    public String selectDbPath(String user_id) {
        con = Saddu.connectDb();
        sql = "select db from " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                message = rs.getString("db");
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblDb_dao.selectDbPath()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblDb_dao.selectDbPath()::" + e.getMessage();
            }
        }
        return message;
    }

}
