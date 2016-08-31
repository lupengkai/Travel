package com.travel.dao;

import com.travel.model.Admin;
import com.travel.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class AdminDao {
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public Admin loadByName(String name) {
        List<Admin> admins = (List<Admin>) hibernateTemplate.find("from Admin ad where ad.name = ?", name);
        if (admins.size() != 0) {
            return admins.get(0);
        }
        return null;
    }
}
