package com.travel.service;

import com.travel.exception.PasswordErrorException;
import com.travel.exception.UserExistsException;
import com.travel.exception.UserNotFoundException;
import com.travel.dao.UserDao;
import com.travel.model.User;
import com.travel.vo.LoginInfo;

import javax.annotation.Resource;

/**
 * Created by tage on 8/30/16.
 */
public class UserManager  {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean validate(LoginInfo loginInfo)  throws UserNotFoundException,PasswordErrorException{
        User user = userDao.loadByName(loginInfo.getUsername());

        if (user == null) {
            throw new UserNotFoundException();
        } else if (!user.getPassword().equals(loginInfo.getPassword())) {
            throw new PasswordErrorException();
        } else {
            return true;
        }

    }


    public boolean exists(String username) {
        User user = userDao.loadByName(username);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }



    public void add(User user)  throws Exception{
        if (exists(user.getName())) {
            throw new UserExistsException();
        }

        userDao.save(user);
    }

    public User loadByName(String name) {
        return userDao.loadByName(name);
    }




}
