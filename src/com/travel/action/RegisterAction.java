package com.travel.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travel.exception.UserExistsException;
import com.travel.model.User;
import com.travel.service.DocumentTypeManager;
import com.travel.service.UserManager;
import com.travel.vo.RegisterInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 8/30/16.
 */
public class RegisterAction  extends ActionSupport implements ModelDriven{


    private RegisterInfo registerInfo = new RegisterInfo();

    public RegisterInfo getRegisterInfo() {
        return registerInfo;
    }

    public void setRegisterInfo(RegisterInfo registerInfo) {
        this.registerInfo = registerInfo;
    }

    @Override
    public Object getModel() {
        return registerInfo;
    }

    private UserManager userManager;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    private DocumentTypeManager documentTypeManager;

    public DocumentTypeManager getDocumentTypeManager() {
        return documentTypeManager;
    }

    public void setDocumentTypeManager(DocumentTypeManager documentTypeManager) {
        this.documentTypeManager = documentTypeManager;
    }

    @Override
    public String execute() throws Exception {
        User user = null;
        HttpServletRequest request = ServletActionContext.getRequest();
        if (registerInfo.getName() == null || registerInfo.getName().trim().equals("")) {

            request.getSession().setAttribute("error_message", "Username is empty");
            return ERROR;

        } else if (registerInfo.getPassword1() == null || registerInfo.getPassword1().trim().equals("")) {
            request.getSession().setAttribute("error_message", "Password is Empty.");
            return ERROR;
        } else if (userManager.exists(registerInfo.getName())) {

            request.getSession().setAttribute("error_message", "Username already exists.");
            return ERROR;
        } else if (!registerInfo.getPassword1().equals(registerInfo.getPassword2())) {
            request.getSession().setAttribute("error_message", "Two passwords are not same");
            return ERROR;

        } else {
            user = new User();
            user.setName(registerInfo.getName());
            user.setPassword(registerInfo.getPassword1());
            user.setBirth_day(registerInfo.getBirth_day());
            user.setBirth_month(registerInfo.getBirth_month());
            user.setBirth_day(registerInfo.getBirth_day());
            user.setLocation_coun(registerInfo.getLocation_coun());
            user.setLocation_prov(registerInfo.getLocation_prov());
            user.setLocation_city(registerInfo.getLocation_city());
            user.setDocumentType(documentTypeManager.loadById(registerInfo.getDocumentType()));
            user.setID_number(registerInfo.getID_number());
            try {
                userManager.add(user);
            } catch (UserExistsException e) {
                request.getSession().setAttribute("error_message", "Username already exists.");
                return ERROR;
            }
        }

        return SUCCESS;
    }
}
