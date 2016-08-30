package com.travel.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.travel.exception.PasswordErrorException;
import com.travel.exception.UserNotFoundException;
import com.travel.model.User;
import com.travel.service.UserManager;
import com.travel.vo.LoginInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 8/30/16.
 */
public class LoginAction  extends ActionSupport implements ModelDriven{
    private LoginInfo loginInfo = new LoginInfo();

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }


    @Override
    public Object getModel() {
        return loginInfo;
    }


    private UserManager userManager;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            userManager.validate(loginInfo);
            User user = new User();



        } catch (PasswordErrorException e) {
            request.getSession().setAttribute("error_message", "The password is error!");
            return ERROR;
        } catch (UserNotFoundException e) {
            request.getSession().setAttribute("error_message", "User not found");
            return ERROR;
        }
            User user = new User();
            user.setName(loginInfo.getUsername());

            request.getSession().setAttribute("user", user);
          return SUCCESS;








    }












}
