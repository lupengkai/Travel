package com.travel.dao;

import com.travel.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class UserDao {
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }



    public User loadByName(String name) {
        List<User> users = (List<User>)hibernateTemplate.find("from User u where u.name = ?", name);
        if (users.size()!=0) {
            return users.get(0);
        }
        return null;
    }

    public void save(User user) {
        hibernateTemplate.save(user);
    }


    public User loadById(int id) {

        List<User> users = (List<User>) hibernateTemplate.find("from User u where u.id = ?", id);

        if (users.size() != 0) {
            return users.get(0);
        }
        return null;
    }

    public void update(User user) {
        hibernateTemplate.update(user);

    }
}
