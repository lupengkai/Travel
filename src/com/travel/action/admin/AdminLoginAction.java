package com.travel.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travel.exception.AdminNotFoundException;
import com.travel.exception.PasswordErrorException;
import com.travel.model.Admin;
import com.travel.service.AdminManager;
import com.travel.vo.AdminLoginInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 8/31/16.
 */
public class AdminLoginAction extends ActionSupport implements ModelDriven {
    private AdminLoginInfo adminLoginInfo = new AdminLoginInfo();

    public AdminLoginInfo getAdminLoginInfo() {
        return adminLoginInfo;
    }

    public void setAdminLoginInfo(AdminLoginInfo adminLoginInfo) {
        this.adminLoginInfo = adminLoginInfo;
    }

    @Override
    public Object getModel() {
        return adminLoginInfo;
    }


    private AdminManager adminManager;

    public AdminManager getAdminManager() {
        return adminManager;
    }

    public void setAdminManager(AdminManager adminManager) {
        this.adminManager = adminManager;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            adminManager.validate(adminLoginInfo);
            Admin admin = adminManager.loadByName(adminLoginInfo.getName());


            request.getSession().setAttribute("admin", admin);
            return SUCCESS;


        } catch (PasswordErrorException e) {
            request.getSession().setAttribute("error_message", "The password is error!");
            return ERROR;
        } catch (AdminNotFoundException e) {
            request.getSession().setAttribute("error_message", "Admin not found");
            return ERROR;
        }


    }
}
