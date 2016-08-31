package com.travel.dao;

import com.travel.model.DocumentType;
import com.travel.model.Scenery;
import com.travel.model.SceneryLevel;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 8/30/16.
 */
public class SceneryLevelDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public SceneryLevel loadById(int id) {
        return ((List<SceneryLevel>) hibernateTemplate.find("from SceneryLevel sl where sl.id = ?", id)).get(0);
    }

    public List<SceneryLevel> getAll() {
        return (List<SceneryLevel>) hibernateTemplate.find("from SceneryLevel sl ");
    }

}
