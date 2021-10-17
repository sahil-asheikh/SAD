/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.service;

import com.qt.sad.dao.TblSubdomain_dao;
import com.qt.sad.model.Tblsubdomain;
import com.qt.sad.utility.Utils;

/**
 *
 * @author LENOVO
 */
public class Subdomain_service {

    Tblsubdomain subdomain = new Tblsubdomain();
    TblSubdomain_dao subdomain_dao = new TblSubdomain_dao();

    public Tblsubdomain select_subdomain(String subdomain_id) {
        return subdomain_dao.select_subdomain(Utils.requiredNotNull(subdomain_id, "Subdomain ID cannot be null"));
    }

    public String insert_subdomain(Tblsubdomain subdomain) {

        this.subdomain.setSubdomain(subdomain.getSubdomain());
        this.subdomain.setUser_id(subdomain.getUser_id());

        //        check the domain
        if (subdomain_dao.checkDomain(this.subdomain)) {
            return "This domain is already taken";
        } else {
            return subdomain_dao.insert_subdomain(this.subdomain);
        }
    }

    public String update_subdomain(Tblsubdomain subdomain) {

        this.subdomain.setSubdomain(subdomain.getSubdomain());
        this.subdomain.setUser_id(subdomain.getUser_id());
        this.subdomain.setSubdomain_id(subdomain.getSubdomain_id());

        //        check the domain
        if (subdomain_dao.checkDomain(this.subdomain)) {
            return "This domain is already taken";
        } else {
            return subdomain_dao.update_subdomain(this.subdomain);
        }
    }

    public Tblsubdomain selectByUserId(String user_id) {
        return subdomain_dao.selectByUserId(Utils.requiredNotNull(user_id, "User ID cannot be null"));
    }

    public boolean checkSubdomainByUserId(String user_id) {
        return subdomain_dao.checkSubdomainByUserId(Utils.requiredNotNull(user_id, "User ID cannot be null"));
    }

    public String selectSubDomainName(String user_id) {
        return subdomain_dao.selectSubdomainName(user_id);
    }

}
