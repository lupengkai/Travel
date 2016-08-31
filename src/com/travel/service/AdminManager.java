package com.travel.service;

import com.travel.dao.AdminDao;
import com.travel.exception.AdminNotFoundException;
import com.travel.exception.PasswordErrorException;
import com.travel.model.Admin;
import com.travel.vo.AdminLoginInfo;

import javax.annotation.Resource;

/**
 * Created by tage on 8/31/16.
 */
public class AdminManager {
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    @Resource
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public boolean validate(AdminLoginInfo adminLoginInfo) throws AdminNotFoundException, PasswordErrorException {
        Admin admin = adminDao.loadByName(adminLoginInfo.getName());

        if (admin == null) {
            throw new AdminNotFoundException();
        } else if (!admin.getPassword().equals(adminLoginInfo.getPassword())) {
            throw new PasswordErrorException();
        } else {
            return true;
        }

    }


    public Admin loadByName(String name) {
        return adminDao.loadByName(name);
    }
}
