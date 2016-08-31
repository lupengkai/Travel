package com.travel.dao;

import com.travel.model.SceneryType;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class SceneryTypeDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public SceneryType loadById(int id) {
        return ((List<SceneryType>) hibernateTemplate.find("from SceneryType sl where sl.id = ?", id)).get(0);
    }

    public List<SceneryType> getAll() {
        return (List<SceneryType>) hibernateTemplate.find("from SceneryType sl ");
    }

}
