package com.travel.dao;


import com.travel.model.Retailer;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class RetailerDao {
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public Retailer loadById(int id) {

        List<Retailer> retailers = (List<Retailer>) hibernateTemplate.find("from Retailer r where s.id = ?", id);

        if (retailers.size() != 0) {
            return retailers.get(0);
        }
        return null;
    }


}
