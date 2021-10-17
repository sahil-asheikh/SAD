/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.dao;

import com.qt.sad.database.Saddu;
import com.qt.sad.enums.ResponseMessages;
import com.qt.sad.model.Tbluser;
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
public class TblUser_dao {

    private final String TABLENAME = Tbluser.class.getSimpleName().toLowerCase();
    private Connection con;
    private String sql, message;
    private CallableStatement cs;
    private ResultSet rs;
    private int i;

    public String insert_user(Tbluser user) {
        con = Saddu.connectDb();
        sql = "INSERT INTO " + TABLENAME + " (user_id, name, mobile, email, password, education, college, city) VALUES (?,?,?,?,?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user.getUser_id());
            cs.setString(2, user.getName());
            cs.setString(3, user.getMobile());
            cs.setString(4, user.getEmail());
            cs.setString(5, user.getPassword());
            cs.setString(6, user.getEducation());
            cs.setString(7, user.getCollege());
            cs.setString(8, user.getCity());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_ADDED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.insert_user()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.insert_user()::" + e.getMessage();
            }
        }
        return message;
    }

    public List<Tbluser> select_users() {
        ArrayList<Tbluser> users = new ArrayList<>();
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Tbluser user = new Tbluser(
                        rs.getInt("id"),
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("education"),
                        rs.getString("college"),
                        rs.getString("city"),
                        rs.getInt("project_status"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.select_users()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.select_users()::" + e.getMessage();
            }
        }
        return users;
    }

    public Tbluser select_user(String user_id) {
        Tbluser user = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                user = new Tbluser(
                        rs.getInt("id"),
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("education"),
                        rs.getString("college"),
                        rs.getString("city"),
                        rs.getInt("project_status"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.select_user()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.select_user()::" + e.getMessage();
            }
        }
        return user;
    }

    public String update_user(Tbluser user) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET name = ?, mobile = ?, email = ?, education = ?, college = ?, city = ? WHERE user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user.getName());
            cs.setString(2, user.getMobile());
            cs.setString(3, user.getEmail());
            cs.setString(4, user.getEducation());
            cs.setString(5, user.getCollege());
            cs.setString(6, user.getCity());
            cs.setString(7, user.getUser_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            } else {
                message = ResponseMessages.OPERATION_FAILED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.update_user()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.update_user()::" + e.getMessage();
            }
        }
        return message;
    }

    public String delete_user(String user_id) {
        con = Saddu.connectDb();
        sql = "DELETE FROM " + TABLENAME + " WHERE user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_DELETED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.delete_user()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.delete_user()::" + e.getMessage();
            }
        }
        return message;
    }

    public Tbluser findByMobile(String mobile) {
        Tbluser user = null;
        con = Saddu.connectDb();
        sql = "SELECT * FROM " + TABLENAME + " where mobile = " + mobile;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                user = new Tbluser(
                        rs.getInt("id"),
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("mobile"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("education"),
                        rs.getString("college"),
                        rs.getString("city"),
                        rs.getInt("project_status"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.select_user()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.select_user()::" + e.getMessage();
            }
        }
        return user;
    }

    public int count_attempts(String user_id) {
        con = Saddu.connectDb();
        sql = "SELECT attempts FROM " + TABLENAME + " where user_id = ?";
        int attempts = 0;
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                attempts = rs.getInt("attempts");
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.count_attempts()" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.count_attempts()" + e.getMessage();
            }
        }
        return attempts;
    }

    public int increase_attempt(String user_id, int count) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET attempts = ? WHERE user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, count + 1);
            cs.setString(2, user_id);
            i = cs.executeUpdate();
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.increase_attempt()" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.increase_attempt()" + e.getMessage();
            }
        }
        return i;
    }

    public int reset_attempts(String user_id) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " SET attempts = 0 WHERE user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            i = cs.executeUpdate();
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.reset_attempts()" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.reset_attempts()" + e.getMessage();
            }
        }
        return i;
    }

    public boolean checkPassword(String old_password, String user_id) {
        con = Saddu.connectDb();
        sql = "SELECT password FROM " + TABLENAME + " where user_id = ?";
        boolean check_password = false;
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user_id);
            rs = cs.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(old_password)) {
                    check_password = true;
                }
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.checkPassword()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.checkPassword()::" + e.getMessage();
            }
        }
        return check_password;
    }

    public String updatePassword(Tbluser user) {
        con = Saddu.connectDb();
        sql = "UPDATE " + TABLENAME + " set password = ? WHERE user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, user.getPassword());
            cs.setString(2, user.getUser_id());
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            } else {
                message = ResponseMessages.OPERATION_FAILED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.updatePassword()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.updatePassword()::" + e.getMessage();
            }
        }
        return message;
    }

    public String changeProjectStatus(String user_id, int status) {
        con = Saddu.connectDb();
        sql = "update " + TABLENAME + " set project_status = ? where user_id = ?";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, status);
            cs.setString(2, user_id);
            i = cs.executeUpdate();
            if (i == 1) {
                message = ResponseMessages.DATA_UPDATED.getResponseMessages();
            } else {
                message = ResponseMessages.OPERATION_FAILED.getResponseMessages();
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.changeProjectStatus()" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.changeProjectStatus()" + e.getMessage();
            }
        }
        return message;
    }

    public int countUsers() {
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
            message = "com.qt.sad.dao.TblUser_dao.countUsers()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.countUsers()::" + e.getMessage();
            }
        }
        return count;
    }

    public int countRejectedProjects() {
        con = Saddu.connectDb();
        sql = "select count(*) from " + TABLENAME + " where project_status = -1";
        int count = 0;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.countRejectedProjects()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.countRejectedProjects()::" + e.getMessage();
            }
        }
        return count;
    }

    public int countApprovedProjects() {
        con = Saddu.connectDb();
        sql = "select count(*) from " + TABLENAME + " where project_status = 1";
        int count = 0;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.countApprovedProjects()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.countApprovedProjects()::" + e.getMessage();
            }
        }
        return count;
    }

    public int countPendingProjects() {
        con = Saddu.connectDb();
        sql = "select count(*) from " + TABLENAME + " where project_status = 0";
        int count = 0;
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            message = "com.qt.sad.dao.TblUser_dao.countPendingProjects()::" + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                message = "com.qt.sad.dao.TblUser_dao.countPendingProjects()::" + e.getMessage();
            }
        }
        return count;
    }

}
